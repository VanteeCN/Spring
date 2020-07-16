package cn.rayfoo.service.impl;

import cn.rayfoo.mapper.AccountMapper;
import cn.rayfoo.mapper.PersonMapper;
import cn.rayfoo.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/16 7:43 下午
 * @Description: 提取公用的service
 */
public class BaseService {

    /**
     * 创建所有mapper
     */
    @Autowired
    protected AccountMapper accountMapper;
    @Autowired
    protected PersonMapper personMapper;

}
