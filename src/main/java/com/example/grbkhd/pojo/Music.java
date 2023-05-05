package com.example.grbkhd.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName music
 */
@TableName(value ="music")
public class Music implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 歌曲名称
     */
    private String title;

    /**
     * 歌曲地址
     */
    private String address;

    /**
     * 歌曲作者
     */
    private String artist;

    /**
     * 歌曲图片
     */
    private String img;

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
     * 歌曲名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 歌曲名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 歌曲地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 歌曲地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 歌曲作者
     */
    public String getArtist() {
        return artist;
    }

    /**
     * 歌曲作者
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * 歌曲图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 歌曲图片
     */
    public void setImg(String img) {
        this.img = img;
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
        Music other = (Music) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getArtist() == null ? other.getArtist() == null : this.getArtist().equals(other.getArtist()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getArtist() == null) ? 0 : getArtist().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
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
        sb.append(", address=").append(address);
        sb.append(", artist=").append(artist);
        sb.append(", img=").append(img);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}