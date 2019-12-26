package MySwaggerDemo.domain.vo;

import MySwaggerDemo.domain.entity.Movie;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

public class MovieVo {

    /**
     * 编码
     */
    private String movieNo;

    /**
     * 名称
     */
    private String name;

    /**
     * 评分
     */
    private BigDecimal score;

    /**
     * 地域类型 1欧美 2日本 3香港 4大陆 5其他
     */
    private Integer area;
    private String areaName;

    /**
     * 上映日期
     */
    private String date;

    /**
     * 影片介绍
     */
    private String introduction;

    /**
     * 备注
     */
    private String remark;

    /**
     * 启停用状态 1启用 0停用
     */
    private Integer status;
    private String statusName;

    public String getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(String movieNo) {
        this.movieNo = movieNo == null ? null : movieNo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public MovieVo(Movie movie) {
        BeanUtils.copyProperties(movie, this);
    }

    public MovieVo() {
    }
}