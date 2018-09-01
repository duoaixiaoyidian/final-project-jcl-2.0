package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by M on 2018/8/30.
 */
public interface AlbumDAO {
    public void addAlbum(Album album);
    public void deleteAlbum(Integer id);
    public List<Album> queryAllAlbums();
    public Album queryAlbumById(Integer id);
}
