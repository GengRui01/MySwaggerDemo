package MySwaggerDemo.service.impl;

import MySwaggerDemo.domain.entity.Movie;
import MySwaggerDemo.domain.entityEnum.AreaEnum;
import MySwaggerDemo.domain.entityEnum.StatusEnum;
import MySwaggerDemo.domain.query.MovieQuery;
import MySwaggerDemo.domain.vo.MovieVo;
import MySwaggerDemo.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import MySwaggerDemo.service.MovieService;
import MySwaggerDemo.util.EmptyUtil;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description:
 *
 * @ClassName: MovieServiceImpl
 * @Author: GengRui
 * @Date: 2019/11/25 15:54
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;

    /**
     * Description: 查看所有电影信息
     *
     * @param query
     * @return
     */
    @Override
    public List<MovieVo> getList(MovieQuery query) {
        List<Movie> entityList = movieMapper.getList(query);
        if (EmptyUtil.isEmpty(entityList)) {
            return null;
        }

        List<MovieVo> voList = new ArrayList<>();
        entityList.forEach(entity -> voList.add(entryToVo(entity)));
        return voList;
    }

    /**
     * Description: 查看电影详细信息
     *
     * @param movieNo
     * @return
     */
    @Override
    public MovieVo getDetail(String movieNo) {
        Movie movie = movieMapper.getDetail(movieNo);
        if (EmptyUtil.isEmpty(movie)) {
            return null;
        }
        return entryToVo(movie);
    }

    /**
     * Description: 封装为前端可展示的对象
     *
     * @param movie
     * @return
     */
    private MovieVo entryToVo(Movie movie) {
        MovieVo movieVo = new MovieVo(movie);
        movieVo.setAreaName(EmptyUtil.isEmpty(movieVo.getArea()) ? "" : AreaEnum.getAreaByCode(movieVo.getArea()).getValue());
        movieVo.setStatusName(EmptyUtil.isEmpty(movieVo.getStatus()) ? "" : StatusEnum.getStatusByCode(movieVo.getStatus()).getValue());
        return movieVo;
    }

    /**
     * Description: 生成电影编码
     *
     * @return
     */
    @Override
    public String getInsertMovieNo() {
        Instant instant = new Date().toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        String nowStr = localDateTime.format(format);
        Integer nowInt = 1;

        String lastNo = movieMapper.getLastMovieNo();
        String lastDate = lastNo.substring(0, 8);
        if (nowStr.equals(lastDate)) {
            Integer lastInt = Integer.parseInt(lastNo.substring(9, 11));
            nowInt += lastInt;
        }

        if (nowInt < 10) {
            return "M" + nowStr + "0" + nowInt;
        } else {
            return "M" + nowStr + nowInt;
        }
    }

    /**
     * Description: 新增校验
     *
     * @param movieVo
     * @return
     */
    @Override
    public String checkInsert(MovieVo movieVo) {
        if (movieMapper.checkName(movieVo.getMovieNo(), movieVo.getName()) != 0) {
            return "该电影名称已存在";
        }
        return null;
    }

    /**
     * Description: 新增
     *
     * @param movieVo
     * @return
     */
    @Override
    public int insert(MovieVo movieVo) {
        return movieMapper.insert(new Movie(movieVo));
    }

    /**
     * Description: 修改校验
     *
     * @param movieVo
     * @return
     */
    @Override
    public String checkUpdate(MovieVo movieVo) {
        Movie movie = movieMapper.getDetail(movieVo.getMovieNo());
        if (EmptyUtil.isEmpty(movie)) {
            return "该电影编码不存在";
        }
        if (movieMapper.checkName(movieVo.getMovieNo(), movieVo.getName()) != 0) {
            return "该电影名称已存在";
        }
        return null;
    }

    /**
     * Description: 修改
     *
     * @param movieVo
     * @return
     */
    @Override
    public int update(MovieVo movieVo) {
        return movieMapper.update(new Movie(movieVo));
    }

    /**
     * Description: 启停用校验
     *
     * @param movieNo
     * @param status
     * @return
     */
    @Override
    public String checkStatus(String movieNo, Integer status) {
        Movie movie = movieMapper.getDetail(movieNo);
        if (EmptyUtil.isEmpty(movie)) {
            return "该电影编码不存在";
        }
        if (movie.getStatus().compareTo(status) == 0) {
            return "启停用前后状态相同";
        }
        return null;
    }

    /**
     * Description: 启停用
     *
     * @param movieNo
     * @param status
     * @return
     */
    @Override
    public int status(String movieNo, Integer status) {
        return movieMapper.update(new Movie(movieNo, status, null));
    }

    /**
     * Description: 删除
     *
     * @param movieNo
     * @return
     */
    @Override
    public int delete(String movieNo) {
        return movieMapper.update(new Movie(movieNo, null, 1));
    }
}
