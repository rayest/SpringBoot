package cn.ray.fileUpload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * Created by Rayest on 2016/10/15 0015.
 * 文件上传的接口
 */
@Controller
public class FileUploadController {
    // 上传单个文件
    @RequestMapping("/file")
    public String uploadFile() {
        return "/file"; // 跳转到 file.html 页面
    }

    // 通过对 file.html 配置页面的操作，将跳转到该接口
    @RequestMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败，" + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败，" + e.getMessage();
            }
            return "上传成功";
        } else {
            return "上传失败，上传的文件夹为空";
        }
    }

    // 上传多个文件
    @RequestMapping(value = "/multiFile", method = RequestMethod.GET)
    public String uploadMultiFile(){
        return "/multiFile"; // 跳转到 multiFile.html 页面
    }

    // 通过对 multiFile.html 配置页面的操作，将跳转到该接口
    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream out = null;
        for (int i = 0; i < files.size(); i++) {
            file = files.get(i);
            if (!file.isEmpty()){
                try {
                    byte[] bytes = file.getBytes();
                    out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                    out.write(bytes);
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    out = null;
                    return "上传失败文件" + i + "===" + e.getMessage();
                }
            }else {
                return "上传失败文件" + i + "===" + "上传的文件为空";
            }
        }

        return "上传成功";
    }
}
