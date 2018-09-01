package com.baizhi.service;

import com.baizhi.dao.BannerDAO;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by M on 2018/8/29.
 */
@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDAO bannerDAO;
    @Override
    public List<Banner> queryAllBanners() {
        List<Banner> banners = bannerDAO.queryBanners();
        return banners;
    }

    @Override
    public void add(Banner banner) {
        bannerDAO.add(banner);
    }

    @Override
    public void update(Banner banner) {
        bannerDAO.update(banner);
    }

    @Override
    public void delete(Integer id) {
        bannerDAO.delete(id);
    }

    @Override
    public Integer query() {
        return bannerDAO.query();
    }
}
