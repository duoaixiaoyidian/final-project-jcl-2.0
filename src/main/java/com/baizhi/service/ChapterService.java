package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

/**
 * Created by M on 2018/8/30.
 */
public interface ChapterService {
    public void delete(Integer id);
    public List<Chapter> queryAll();
    public void addChapter(Chapter chapter);
}
