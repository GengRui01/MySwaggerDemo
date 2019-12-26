package MySwaggerDemo.domain.query;

import java.util.List;

/**
 * Description:
 *
 * @ClassName: MovieQuery
 * @Author: GengRui
 * @Date: 2019/11/25 15:00
 */
public class MovieQuery {
    private List<String> areaList;
    private String beginDate;
    private String endDate;
    private String lowScore;
    private String highScore;

    public List<String> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<String> areaList) {
        this.areaList = areaList;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLowScore() {
        return lowScore;
    }

    public void setLowScore(String lowScore) {
        this.lowScore = lowScore;
    }

    public String getHighScore() {
        return highScore;
    }

    public void setHighScore(String highScore) {
        this.highScore = highScore;
    }
}
