package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by M on 2018/8/29.
 */
@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @RequestMapping("/queryAll")
    public List<Banner> query(){
        List<Banner> banners = bannerService.queryAllBanners();
        return banners;
    }
    @RequestMapping("/add")
    public void addBanner(Banner banner, @RequestParam(value = "img", required = false)MultipartFile img, HttpServletRequest request){
        //获取项目的绝对路径
        String realPath = request.getServletContext().getRealPath("/");
        String uploadFilePath = realPath + "upload";
        File file = new File(uploadFilePath);
        if(!file.exists()){
            file.mkdir();
        }
        String originalFilename = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = FilenameUtils.getExtension(originalFilename);
        String newName =uuid+"."+extension;
        try {
            img.transferTo(new File(uploadFilePath,newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        banner.setImgPath("/upload/"+newName);
        bannerService.add(banner);
    }
    @RequestMapping("/update")
    public String updateBanner(Banner banner){
        bannerService.update(banner);
        return "/main/main";
    }
    @RequestMapping("/delete")
    public String deleteBanner(Integer id){
        bannerService.delete(id);
        return "/main/main";
    }
}
