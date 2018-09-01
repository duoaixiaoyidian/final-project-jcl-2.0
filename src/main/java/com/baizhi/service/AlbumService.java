package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by M on 2018/8/30.
 */
public interface AlbumService {
    public void add(Album album);
    public void delete(Integer id);
    public List<Album> queryAll();
    public Album queryAlbum(Integer id);
}
