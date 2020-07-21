package cn.rayfoo.common;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/20 9:26 下午
 * @Description:
 */
public class MyException extends Exception{

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MyException(String msg) {
        this.msg = msg;
    }
}
