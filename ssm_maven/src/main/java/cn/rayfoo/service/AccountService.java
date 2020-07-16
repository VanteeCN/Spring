package cn.rayfoo.service;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/15 3:39 下午
 * @Description:
 */
public interface AccountService {
    String transFer(String sourceName, String targetName, Double money);
}
