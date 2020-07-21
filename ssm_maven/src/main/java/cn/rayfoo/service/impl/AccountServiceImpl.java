package cn.rayfoo.service.impl;

import cn.rayfoo.bean.Account;
import cn.rayfoo.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/15 3:40 下午
 * @Description:
 */
@Service@Slf4j
public class AccountServiceImpl extends BaseService implements AccountService {

    @Override
    @Transactional
    public String transFer(String sourceName, String targetName, Double money) {
        log.debug("进入了transFer");
        //-1、用户为空
        if(StringUtils.isEmpty(sourceName) || StringUtils.isEmpty(targetName)){
            throw new RuntimeException("未输入账户名！");
        }
        if(money == 0){
            throw new RuntimeException("金额不能为0！");
        }
        if(money < 0){
            throw new RuntimeException("金额不能为负数！");
        }

        //0、如果是同一个用户
        if(sourceName.equals(targetName)){
            throw new RuntimeException("不允许给自己转账！");
        }

        //1、根据名称查询出转入账户
        List<Account> source = accountMapper.findAccountByName(sourceName);
        //2、根据名称查询转出账户
        List<Account> target = accountMapper.findAccountByName(targetName);

        //判断是否成功拿到数据
        if (CollectionUtils.isEmpty(source) || CollectionUtils.isEmpty(target)) {
            throw new RuntimeException("账户不存在!");
        }
        if (source.size() > 1 || target.size() > 1) {
            throw new RuntimeException("结果集不唯一!");
        }
        //3、转入账户减去金额
        Account sourceAccount = source.get(0);
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        if(sourceAccount.getMoney()<0){
            throw new RuntimeException("账户余额不足!");
        }

        //4、转出账户加上金额
        Account targetAccount = target.get(0);
        targetAccount.setMoney(targetAccount.getMoney() + money);
        //5、更新转出账户
        accountMapper.updateByPrimaryKey(sourceAccount);

        //模拟出现异常
        if (money == 100) {
            throw new RuntimeException("模拟出现异常，转账失败");
        }
        //6、更新转入账户
        accountMapper.updateByPrimaryKey(targetAccount);

        return "转账成功！";
    }
}
