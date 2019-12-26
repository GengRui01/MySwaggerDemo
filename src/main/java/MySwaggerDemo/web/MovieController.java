package MySwaggerDemo.web;

import MySwaggerDemo.domain.query.MovieQuery;
import MySwaggerDemo.domain.vo.MovieVo;
import MySwaggerDemo.domain.vo.Result;
import MySwaggerDemo.service.impl.MovieServiceImpl;
import MySwaggerDemo.util.EmptyUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @ClassName: MovieController
 * @Author: GengRui
 * @Date: 2019/11/25 19:39
 */
@RestController
@Api(value = "电影Controller", tags = {"电影访问接口"})
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieServiceImpl movieService;

    /**
     * Description: 查看所有电影信息
     *
     * @param query
     * @return
     */
    @PostMapping("/getList")
    @ApiOperation("查看所有电影信息")
    public Result getList(@ApiParam("电影") MovieQuery query) {
        List<MovieVo> voList = movieService.getList(query);
        return Result.success(voList);
    }

    /**
     * Description: 查看电影详细信息
     *
     * @param movieNo
     * @return
     */
    @PostMapping("/getDetail")
    @ApiOperation("查看电影详细信息")
    public Result getDetail(@ApiParam("movieNo") String movieNo) {
        return Result.success(movieService.getDetail(movieNo));
    }

    /**
     * Description: 新增
     *
     * @param movieVo
     * @return
     */
    @PostMapping("/insert")
    @ApiOperation("新增一部电影")
    public Result insert(@ApiParam("电影实体对象") MovieVo movieVo) {
        // 生成电影编码
        movieVo.setMovieNo(movieService.getInsertMovieNo());
        // 新增校验
        String error = movieService.checkInsert(movieVo);
        if (!EmptyUtil.isEmpty(error)) {
            return Result.fail(error);
        }
        // 新增记录
        movieService.insert(movieVo);
        return Result.success();
    }

    /**
     * Description: 修改
     *
     * @param movieVo
     * @return
     */

    public Result update(MovieVo movieVo) {
        // 修改校验
        String error = movieService.checkUpdate(movieVo);
        if (!EmptyUtil.isEmpty(error)) {
            return Result.fail(error);
        }
        // 修改记录
        movieService.update(movieVo);
        return Result.success();
    }

    /**
     * Description: 启停用
     *
     * @param movieNo
     * @param status
     * @return
     */

    public Result status(String movieNo, Integer status) {
        // 启停用校验
        String error = movieService.checkStatus(movieNo, status);
        if (!EmptyUtil.isEmpty(error)) {
            return Result.fail(error);
        }
        //启停用记录
        movieService.status(movieNo, status);
        return Result.success();
    }

    /**
     * Description: 删除
     *
     * @param movieNo
     * @return
     */

    public Result delete(String movieNo) {
        // 新增记录
        movieService.delete(movieNo);
        return Result.success();
    }

}
