package com.baizhi.service;

import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by M on 2018/8/30.
 */
@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDAO chapterDAO;
    @Override
    public void delete(Integer id) {
        chapterDAO.delete(id);
    }

    @Override
    public List<Chapter> queryAll() {
        return chapterDAO.queryAllChapters();
    }

    @Override
    public void addChapter(Chapter chapter) {
        chapterDAO.add(chapter);
    }
}
