package com.baizhi.dao;

import com.baizhi.entity.Chapter;

import java.util.List;

/**
 * Created by M on 2018/8/30.
 */
public interface ChapterDAO {
    public void delete(Integer id);
    public List<Chapter> queryAllChapters();
    public void add(Chapter chapter);
}
