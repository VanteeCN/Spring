package cn.rayfoo.mapper;

import cn.rayfoo.bean.Account;
import com.github.abel533.mapper.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/15 3:39 下午
 * @Description:
 */
public interface AccountMapper extends Mapper<Account> {
    List<Account> findAccountByName(@Param("accountName") String accountName);
}
