package MySwaggerDemo.service;

import MySwaggerDemo.domain.query.MovieQuery;
import MySwaggerDemo.domain.vo.MovieVo;

import java.util.List;

/**
 * Description:
 *
 * @InterfaceName: MovieService
 * @Author: GengRui
 * @Date: 2019/11/25 15:54
 */
public interface MovieService {

    /**
     * Description: 查看所有电影信息
     *
     * @param query
     * @return
     */
    List<MovieVo> getList(MovieQuery query);

    /**
     * Description: 查看电影详细信息
     *
     * @param movieNo
     * @return
     */
    MovieVo getDetail(String movieNo);

    /**
     * Description: 生成电影编码
     *
     * @return
     */
    String getInsertMovieNo();

    /**
     * Description: 新增校验
     *
     * @param movieVo
     * @return
     */
    String checkInsert(MovieVo movieVo);

    /**
     * Description: 新增
     *
     * @param movieVo
     * @return
     */
    int insert(MovieVo movieVo);

    /**
     * Description: 修改校验
     *
     * @param movieVo
     * @return
     */
    String checkUpdate(MovieVo movieVo);

    /**
     * Description: 修改
     *
     * @param movieVo
     * @return
     */
    int update(MovieVo movieVo);

    /**
     * Description: 启停用校验
     *
     * @param movieNo
     * @param status
     * @return
     */
    String checkStatus(String movieNo, Integer status);

    /**
     * Description: 启停用
     *
     * @param movieNo
     * @param status
     * @return
     */
    int status(String movieNo, Integer status);

    /**
     * Description: 删除
     *
     * @param movieNo
     * @return
     */
    int delete(String movieNo);
}
