package cn.rayfoo.factory;

import cn.rayfoo.dao.UserDao;
import cn.rayfoo.dao.UserDaoMySQLImpl;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/6/18 11:07 上午
 * @Description:
 */
public class BeanFacroty {
    public static UserDao getUserDao(){
        return new UserDaoMySQLImpl();
    }
}
