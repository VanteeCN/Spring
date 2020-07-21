package cn.rayfoo.controller;

import cn.rayfoo.utils.FtpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/20 5:11 下午
 * @Description:
 */
@Controller
public class FileUploadController extends BaseController{

    @PostMapping("/fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile file){

        //上传的位置
        String path = session.getServletContext().getRealPath("/upload/");
        
        //创建文件对象
        File dir = new File(path);
        
        //判断该位置是否存在
        if(!dir.exists()){
            dir.mkdir();
        }
        
        //获取文件名
        String filename = file.getOriginalFilename();

        //获取后缀
        String suffix = filename.substring(filename.lastIndexOf("."));

        //使用UUID替换文件名
        filename = UUID.randomUUID().toString().replace("-","") + suffix;

        try {
            //完成上传
            file.transferTo(new File(dir,filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }

    @PostMapping("/ftpUpload")
    public String ftpUpload(@RequestParam("file") MultipartFile file){
        //获取文件名
        String filename = file.getOriginalFilename();

        //获取后缀
        String suffix = filename.substring(filename.lastIndexOf("."));

        //使用UUID替换文件名
        filename = UUID.randomUUID().toString().replace("-","") + suffix;

        try {
            //完成上传
            FtpUtils.uploadFile("/",filename,file.getInputStream());
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


}
