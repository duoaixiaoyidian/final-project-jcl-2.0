package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by M on 2018/8/29.
 */
@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Banner> query(){
        List<Banner> banners = bannerService.queryAllBanners();
        return banners;
    }
    @RequestMapping("/add")
    public String addBanner(Banner banner){
        bannerService.add(banner);
        return "/main/main";
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
