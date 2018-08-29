package com.baizhi.dao;

import com.baizhi.entity.Banner;

import java.util.List;

/**
 * Created by M on 2018/8/29.
 */
public interface BannerDAO {
    public List<Banner> queryBanners();
    public void add(Banner banner);
    public void update(Banner banner);
    public void delete(Integer id);
}
