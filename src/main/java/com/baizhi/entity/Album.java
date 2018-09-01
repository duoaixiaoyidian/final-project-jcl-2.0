package com.baizhi.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by M on 2018/8/30.
 */
public class Album implements Serializable {
    private Integer id;
    private String title;
    private Integer count;
    private String corverImg;
    private Integer score;
    private String author;
    private String broadCast;
    private String brief;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publicDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    private String status;
    private List<Chapter> children;
    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", corverImg='" + corverImg + '\'' +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", brief='" + brief + '\'' +
                ", publicDate=" + publicDate +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                ", children=" + children +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (id != null ? !id.equals(album.id) : album.id != null) return false;
        if (title != null ? !title.equals(album.title) : album.title != null) return false;
        if (count != null ? !count.equals(album.count) : album.count != null) return false;
        if (corverImg != null ? !corverImg.equals(album.corverImg) : album.corverImg != null) return false;
        if (score != null ? !score.equals(album.score) : album.score != null) return false;
        if (author != null ? !author.equals(album.author) : album.author != null) return false;
        if (broadCast != null ? !broadCast.equals(album.broadCast) : album.broadCast != null) return false;
        if (brief != null ? !brief.equals(album.brief) : album.brief != null) return false;
        if (publicDate != null ? !publicDate.equals(album.publicDate) : album.publicDate != null) return false;
        if (createDate != null ? !createDate.equals(album.createDate) : album.createDate != null) return false;
        if (status != null ? !status.equals(album.status) : album.status != null) return false;
        return children != null ? children.equals(album.children) : album.children == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (corverImg != null ? corverImg.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (broadCast != null ? broadCast.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (publicDate != null ? publicDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCorverImg() {
        return corverImg;
    }

    public void setCorverImg(String corverImg) {
        this.corverImg = corverImg;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    public Album(Integer id, String title, Integer count, String corverImg, Integer score, String author, String broadCast, String brief, Date publicDate, Date createDate, String status, List<Chapter> children) {

        this.id = id;
        this.title = title;
        this.count = count;
        this.corverImg = corverImg;
        this.score = score;
        this.author = author;
        this.broadCast = broadCast;
        this.brief = brief;
        this.publicDate = publicDate;
        this.createDate = createDate;
        this.status = status;
        this.children = children;
    }

    public Album() {

    }
}
