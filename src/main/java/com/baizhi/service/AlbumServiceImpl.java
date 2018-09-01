package com.baizhi.service;

import com.baizhi.dao.AlbumDAO;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by M on 2018/8/30.
 */
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDAO albumDAO;
    @Override
    public void add(Album album) {
        albumDAO.addAlbum(album);
    }

    @Override
    public void delete(Integer id) {
        albumDAO.deleteAlbum(id);
    }

    @Override
    public List<Album> queryAll() {
        return albumDAO.queryAllAlbums();
    }

    @Override
    public Album queryAlbum(Integer id) {
        return albumDAO.queryAlbumById(id);
    }
}
