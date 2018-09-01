package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by M on 2018/8/30.
 */
@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("/query")
    @ResponseBody
    public List<Album> query(){
        List<Album> albums = albumService.queryAll();
        return albums;
    }
    //
    @RequestMapping("/add")
    public String add(Album album){
        albumService.add(album);
        return "/main/main";
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        albumService.delete(id);
        return "/main/main";
    }
    @RequestMapping("/queryAlbum")
    @ResponseBody
    public Album queryAlbum(Integer id){
        Album album = albumService.queryAlbum(id);
        return album;
    }
}
