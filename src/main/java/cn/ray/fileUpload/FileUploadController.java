package cn.ray.fileUpload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Rayest on 2016/10/15 0015.
 */
@Controller
public class FileUploadController {
    @RequestMapping("/file")
    public String uploadFile() {

        return "/file";
    }

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
}
