package com.baizhi.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by M on 2018/8/29.
 */
public class Banner implements Serializable {
    private Integer id;
    private String title;
    private String imgPath;
    private String description;
    private String status;
    private Date createDate;
    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Banner banner = (Banner) o;

        if (id != null ? !id.equals(banner.id) : banner.id != null) return false;
        if (title != null ? !title.equals(banner.title) : banner.title != null) return false;
        if (imgPath != null ? !imgPath.equals(banner.imgPath) : banner.imgPath != null) return false;
        if (description != null ? !description.equals(banner.description) : banner.description != null) return false;
        if (status != null ? !status.equals(banner.status) : banner.status != null) return false;
        return createDate != null ? createDate.equals(banner.createDate) : banner.createDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (imgPath != null ? imgPath.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

    public Banner(Integer id, String title, String imgPath, String description, String status, Date createDate) {

        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.description = description;
        this.status = status;
        this.createDate = createDate;
    }

    public Banner() {

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

    public String getImgPath() {

        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
