package cn.rayfoo.mapper;

import cn.rayfoo.bean.Person;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by rayfoo@qq.com Luna on 2020/2/18 15:39
 */
public interface PersonMapper extends Mapper<Person> {

    List<Person> findAll();

}
