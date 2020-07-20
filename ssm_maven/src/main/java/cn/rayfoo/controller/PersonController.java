package cn.rayfoo.controller;

import cn.rayfoo.bean.Person;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by rayfoo@qq.com Luna on 2020/2/18 15:41
 * @author rayfoo
 */
@Controller
public class PersonController extends BaseController{


    @RequestMapping("/info")
    public ModelAndView test01(){
        //查询所有人
        List<Person> info = personService.findAll();
        //打印测试
        System.out.println(info);
        ModelAndView modelAndView = new ModelAndView("info");
        //将info添加到域对象
        modelAndView.addObject("person",info);
        return modelAndView;
    }


    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String findPage(Map resultMap, @RequestParam(value = "pageNo",defaultValue = "1",required = false) int pageNo,@RequestParam(value = "pageSize",defaultValue = "5",required = false) int pageSize){
        //分页查询
        PageInfo<Person> page = personService.findPage(pageNo, pageSize);
        //将结果集添加到map中
        resultMap.put("page",page);
        //返回model
        return "page";
    }

}
