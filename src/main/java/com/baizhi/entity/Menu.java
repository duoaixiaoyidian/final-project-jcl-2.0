package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by M on 2018/8/28.
 */
public class Menu implements Serializable {
    private Integer id;
    private String title;
    private String content;
    private String href;
    private String iconCls;
    private Integer parntId;
    private List<Menu> list;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", href='" + href + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", parntId=" + parntId +
                ", list=" + list +
                '}';
    }

    public Menu(Integer id, String title, String content, String href, String iconCls, Integer parntId, List<Menu> list) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.href = href;
        this.iconCls = iconCls;
        this.parntId = parntId;
        this.list = list;
    }

    public Menu() {

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (id != null ? !id.equals(menu.id) : menu.id != null) return false;
        if (title != null ? !title.equals(menu.title) : menu.title != null) return false;
        if (content != null ? !content.equals(menu.content) : menu.content != null) return false;
        if (href != null ? !href.equals(menu.href) : menu.href != null) return false;
        if (iconCls != null ? !iconCls.equals(menu.iconCls) : menu.iconCls != null) return false;
        if (parntId != null ? !parntId.equals(menu.parntId) : menu.parntId != null) return false;
        return list != null ? list.equals(menu.list) : menu.list == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (href != null ? href.hashCode() : 0);
        result = 31 * result + (iconCls != null ? iconCls.hashCode() : 0);
        result = 31 * result + (parntId != null ? parntId.hashCode() : 0);
        result = 31 * result + (list != null ? list.hashCode() : 0);
        return result;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Integer getParntId() {
        return parntId;
    }

    public void setParntId(Integer parntId) {
        this.parntId = parntId;
    }

    public List<Menu> getList() {
        return list;
    }

    public void setList(List<Menu> list) {
        this.list = list;
    }
}
