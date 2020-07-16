package cn.rayfoo.service;

import cn.rayfoo.bean.Person;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by rayfoo@qq.com Luna on 2020/2/18 15:39
 */
public interface PersonService {

    /**
     * 查询所有
     * @return
     */
    List<Person> findAll();

    /**
     * 分页查询
     * @param pageNo 页码
     * @param pageSize 每页数量
     * @return 当前页信息
     */
    PageInfo<Person> findPage(int pageNo, int pageSize);
}
