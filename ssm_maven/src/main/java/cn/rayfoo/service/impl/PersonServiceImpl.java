package cn.rayfoo.service.impl;

import cn.rayfoo.bean.Person;
import cn.rayfoo.mapper.PersonMapper;
import cn.rayfoo.service.PersonService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rayfoo@qq.com Luna on 2020/2/18 15:39
 * @author rayfoo
 */
@Service@Slf4j
public class PersonServiceImpl extends BaseService  implements PersonService {

    @Override
    public List<Person> findAll() {
        return personMapper.findAll();
    }

    @Override
    public PageInfo<Person> findPage(int pageNo, int pageSize) {
        //开启分页插件
        PageHelper.startPage(pageNo, pageSize);
        //查询所有数据
        List<Person> all = personMapper.selectByExample(null);

        //包装当前页信息
        PageInfo<Person> pageInfo = new PageInfo<>(all);
        //返回分页后结果
        return pageInfo;
    }
}
