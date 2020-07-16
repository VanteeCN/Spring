package cn.rayfoo.test;

import cn.rayfoo.dao.UserDao;
import cn.rayfoo.factory.BeanFacroty;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/6/18 11:06 上午
 * @Description:
 */
public class TestApp {
    private static UserDao userDao = BeanFacroty.getUserDao();

    public static void main(String[] args) {
        userDao.getName();
    }
}
