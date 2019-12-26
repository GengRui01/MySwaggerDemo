package MySwaggerDemo.domain.entity;

import MySwaggerDemo.domain.vo.MovieVo;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

public class Movie {
    /**
     * 主键
     */
    private Long id;

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

    /**
     * 0 未删除 1 已删除
     */
    private Integer isDelete;

    /**
     * 生成记录时间
     */
    private Date createTime;

    /**
     * 修改记录时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Movie(String movieNo, Integer status, Integer isDelete) {
        this.movieNo = movieNo;
        this.status = status;
        this.isDelete = isDelete;
    }

    public Movie(MovieVo movieVo) {
        BeanUtils.copyProperties(movieVo, this);
    }

    public Movie() {
    }
}