package com.example.grbkhd.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @TableName shuoshuo
 */
@TableName(value ="shuoshuo")
public class Shuoshuo implements Serializable {
    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 发布日期
     */
    private Date date;

    /**
     * 图片
     */
    private String img;

    /**
     * 内容
     */
    private String content;

    /**
     * 作者
     */
    private String zuozhe;

    /**
     * 是否热门(0是否，1是是)
     */
    private Integer remen;

    /**
     * 浏览量
     */
    private Integer liulan;

    /**
     * 点赞数
     */
    private Integer dianzan;

    /**
     * 评论数
     */
    private Integer pinglun;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    public Integer getId() {
        return id;
    }

    /**
     * id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 发布日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 发布日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 图片
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 作者
     */
    public String getZuozhe() {
        return zuozhe;
    }

    /**
     * 作者
     */
    public void setZuozhe(String zuozhe) {
        this.zuozhe = zuozhe;
    }

    /**
     * 是否热门(0是否，1是是)
     */
    public Integer getRemen() {
        return remen;
    }

    /**
     * 是否热门(0是否，1是是)
     */
    public void setRemen(Integer remen) {
        this.remen = remen;
    }

    /**
     * 浏览量
     */
    public Integer getLiulan() {
        return liulan;
    }

    /**
     * 浏览量
     */
    public void setLiulan(Integer liulan) {
        this.liulan = liulan;
    }

    /**
     * 点赞数
     */
    public Integer getDianzan() {
        return dianzan;
    }

    /**
     * 点赞数
     */
    public void setDianzan(Integer dianzan) {
        this.dianzan = dianzan;
    }

    /**
     * 评论数
     */
    public Integer getPinglun() {
        return pinglun;
    }

    /**
     * 评论数
     */
    public void setPinglun(Integer pinglun) {
        this.pinglun = pinglun;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Shuoshuo other = (Shuoshuo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getZuozhe() == null ? other.getZuozhe() == null : this.getZuozhe().equals(other.getZuozhe()))
            && (this.getRemen() == null ? other.getRemen() == null : this.getRemen().equals(other.getRemen()))
            && (this.getLiulan() == null ? other.getLiulan() == null : this.getLiulan().equals(other.getLiulan()))
            && (this.getDianzan() == null ? other.getDianzan() == null : this.getDianzan().equals(other.getDianzan()))
            && (this.getPinglun() == null ? other.getPinglun() == null : this.getPinglun().equals(other.getPinglun()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getZuozhe() == null) ? 0 : getZuozhe().hashCode());
        result = prime * result + ((getRemen() == null) ? 0 : getRemen().hashCode());
        result = prime * result + ((getLiulan() == null) ? 0 : getLiulan().hashCode());
        result = prime * result + ((getDianzan() == null) ? 0 : getDianzan().hashCode());
        result = prime * result + ((getPinglun() == null) ? 0 : getPinglun().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", date=").append(date);
        sb.append(", img=").append(img);
        sb.append(", content=").append(content);
        sb.append(", zuozhe=").append(zuozhe);
        sb.append(", remen=").append(remen);
        sb.append(", liulan=").append(liulan);
        sb.append(", dianzan=").append(dianzan);
        sb.append(", pinglun=").append(pinglun);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
