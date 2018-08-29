package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

/**
 * Created by M on 2018/8/29.
 */
public interface BannerService {
    public List<Banner> queryAllBanners();
    public void add(Banner banner);
    public void update(Banner banner);
    public void delete(Integer id);
}
