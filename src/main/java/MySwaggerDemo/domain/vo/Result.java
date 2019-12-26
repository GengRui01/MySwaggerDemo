package MySwaggerDemo.domain.vo;

import MySwaggerDemo.domain.entityEnum.ResultEnum;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuhui on 2018/9/12.
 */
public class Result<T> implements Serializable {
    private boolean success = true;
    private String retCode;
    private String retMsg;
    private T data;


    public Result() {
        this.retCode = ResultEnum.SUCCESS.getCode();
        this.retMsg = ResultEnum.SUCCESS.getMsg();
    }

    public String getRetCode() {
        return this.retCode;
    }

    public void setRetCode(String retCode) {
        if (retCode != null) {
            this.success = !retCode.startsWith("-");
        }

        this.retCode = retCode;
    }

    public String getRetMsg() {
        return this.retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setError() {
        this.retCode = ResultEnum.CALL_FAIL.getCode();
        this.retMsg = ResultEnum.CALL_FAIL.getMsg();
        this.success = false;
    }

    public void setCodeMsg(String retCode, String retMsg) {
        this.success = false;
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", retCode='" + retCode + '\'' +
                ", retMsg='" + retMsg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * Description: 系统异常
     *
     * @MethodName: exception
     * @Author: GengRui
     * @Date: 2019/3/8 15:19
     * @param: []
     * @return: com.fengniaojx.background.MySwaggerDemo.domain.enumEntity.Result
     */
    public static Result exception() {
        Result res = new Result();
        res.success = false;
        res.retCode = ResultEnum.CALL_EXCEPTION.getCode();
        res.retMsg = ResultEnum.CALL_EXCEPTION.getMsg();
        return res;
    }

    /**
     * Description: 缺少请求参数 可传入缺少参数信息retMsg
     *
     * @MethodName: abnormalParam
     * @Author: GengRui
     * @Date: 2019/3/23 9:57
     * @param: [retMsg]
     * @return: com.fengniaojx.background.MySwaggerDemo.domain.enumEntity.Result
     */
    public static Result abnormalParam(String retMsg) {
        Result res = new Result();
        res.retCode = ResultEnum.ABNORMAL_PARAM.getCode();
        res.retMsg = retMsg;
        res.success = false;
        return res;
    }

    /**
     * Description: 请求失败
     *
     * @MethodName: fail
     * @Author: GengRui
     * @Date: 2019/3/11 16:47
     * @param: []
     * @return: com.fengniaojx.background.MySwaggerDemo.domain.enumEntity.Result
     */
    public static Result fail() {
        Result res = new Result();
        res.setError();
        return res;
    }

    /**
     * Description: 请求失败 可传入失败信息retMsg
     *
     * @MethodName: result
     * @Author: GengRui
     * @Date: 2019/3/8 15:17
     * @param: [retMsg]
     * @return: com.fengniaojx.background.MySwaggerDemo.domain.enumEntity.Result
     */
    public static Result fail(String retMsg) {
        Result res = new Result();
        res.retCode = ResultEnum.CALL_FAIL.getCode();
        res.retMsg = retMsg;
        res.success = false;
        return res;
    }

    /**
     * Description: 请求成功 返回数据包括list和totalCount
     *
     * @MethodName: success
     * @Author: GengRui
     * @Date: 2019/3/8 15:11
     * @param: [list, totalCount]
     * @return: com.fengniaojx.background.MySwaggerDemo.domain.enumEntity.Result
     */
    public static Result success(List<?> list, Integer totalCount) {
        Result res = new Result();
        Map<String, Object> map = new HashMap();
        map.put("list", list);
        map.put("totalCount", totalCount);
        res.data = map;
        return res;
    }

    /**
     * Description: 请求成功 返回数据包括list和totalCount
     *
     * @MethodName: success
     * @Author: GengRui
     * @Date: 2019/3/8 15:11
     * @param: [list, totalCount]
     * @return: com.fengniaojx.background.MySwaggerDemo.domain.enumEntity.Result
     */
    public static Result success(List<?> list, Long totalCount) {
        Result res = new Result();
        Map<String, Object> map = new HashMap();
        map.put("list", list);
        map.put("totalCount", totalCount);
        res.data = map;
        return res;
    }

    /**
     * Description: 请求成功 有返回数据
     *
     * @MethodName: success
     * @Author: GengRui
     * @Date: 2019/3/8 15:11
     * @param: [data]
     * @return: com.fengniaojx.background.MySwaggerDemo.domain.enumEntity.Result
     */
    public static Result success(Object data) {
        Result res = new Result();
        res.setData(data);
        return res;
    }

    /**
     * Description: 请求成功 无返回数据
     *
     * @MethodName: success
     * @Author: GengRui
     * @Date: 2019/3/8 15:10
     * @param: []
     * @return: com.fengniaojx.background.MySwaggerDemo.domain.enumEntity.Result
     */
    public static Result success() {
        Result res = new Result();
        return res;
    }
}