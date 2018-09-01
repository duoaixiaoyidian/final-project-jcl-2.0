package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.Mp3Util;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.aspectj.weaver.SourceContextImpl;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

/**
 * Created by M on 2018/8/30.
 */
@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("/query")
    @ResponseBody
    public List<Chapter> query(){
        List<Chapter> chapters = chapterService.queryAll();
        return chapters;
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        chapterService.delete(id);
        return "main/main";
    }
    //添加章节
    @RequestMapping("/add")
    public String add(Chapter chapter,Integer id,MultipartFile path,HttpServletRequest request){
        String realPath = request.getServletContext().getRealPath("/");
        String uploadFilePath = realPath + "upload";
        File file = new File(uploadFilePath);
        if(!file.exists()){
            file.mkdir();
        }
        String originalFilename = path.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = FilenameUtils.getExtension(originalFilename);
        String nameName = uuid + "."+extension;
        try {
            path.transferTo(new File(uploadFilePath, nameName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置章节的id
        String cid=UUID.randomUUID().toString();
        chapter.setId(cid);
        //设置章节的内容
        chapter.setTitle(originalFilename);
        //设置章节的大小
        long size = path.getSize();
        String s="";
        if(size>1024*1024) {
            s= String.format("%.2f", (double) size / (1024 * 1024)) + "M";

        }
        else {
            s = String.format("%.2f", (double) size / (1024)) + "KB";
        }
        chapter.setSize(s);
        //设置章节的时长
        File file1 = new File(uploadFilePath + "/" +nameName);
        String duration = Mp3Util.getDuration(file1);
        chapter.setDuration(duration);
        //设置章节的audioPath
        chapter.setAudioPath(nameName);
        //设置章节的所属专辑
        chapter.setAlbum_id(id);
        chapterService.addChapter(chapter);
        return "main/main";
    }
    //下载音频
    @RequestMapping("/down")
    public void down(String title, String audioPath, HttpServletRequest request, HttpServletResponse response) {
        String realPath = request.getServletContext().getRealPath("/");
        String filePath = realPath + "upload/" + audioPath;
        File file = new File(filePath);
        String extension = FilenameUtils.getExtension(audioPath);
        //title = title + "." + extension;
        String a = null;
        try {
            a = new String(title.getBytes("utf-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //设置响应体
        response.setContentType("audio/mpeg");
        //设置响应头
        response.setHeader("Content-Disposition", "attachment;filename=" + a);
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(file));
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
