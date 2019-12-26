package MySwaggerDemo.domain.entityEnum;

public enum ResultEnum {
    SUCCESS("200", "执行成功！"),
    CALL_FAIL("-101000", "服务器异常！"),
    CALL_EXCEPTION("-101001", "系统异常 请联系管理员！"),
    ABNORMAL_PARAM("-101002", "缺少请求参数 请检查！");

    private final String code;
    private final String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
