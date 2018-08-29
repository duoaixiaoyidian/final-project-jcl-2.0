package com.baizhi.service;

import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by M on 2018/8/29.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDAO menuDAO;
    @Override
    public List<Menu> queryAll() {
        return menuDAO.queryAllMenus();
    }
}
