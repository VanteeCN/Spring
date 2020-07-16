package cn.rayfoo.controller;

import cn.rayfoo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/15 3:40 下午
 * @Description:
 */
@RestController
public class AccountController extends BaseController{

    @PostMapping("/transFer")
    public String transFer(String sourceName,String targetName,Double money){
        return accountService.transFer(sourceName,targetName,money);
    }

}
