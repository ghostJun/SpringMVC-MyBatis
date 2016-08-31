package com.zealot.controller.utils;

import com.zealot.base.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WangFei on 2014/11/7 0007.
 *         文件控制器
 */

@Controller
@RequestMapping("/file")
public class FileController {

    @ResponseBody
    @RequestMapping("/image/upload")
    public ResponseData imageUpload(Model model, @RequestParam(value = "imageFile", required = false) MultipartFile imageFile, HttpServletRequest request, HttpServletResponse response) {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String ss = realPath;
        String suffix = (imageFile.getOriginalFilename().substring
                (imageFile.getOriginalFilename().lastIndexOf("."))).toLowerCase();
        /**拼成完整的文件保存路径加文件**/
        String imagesPath = realPath + "data" + File.separator + "images";
        File imagesFile = new File(imagesPath);
        if (!imagesFile.exists()) {
            imagesFile.mkdirs();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        ;
        File file = new File(imagesPath + File.separator + fileName);
        ResponseData responseData = new ResponseData();
        try {
            imageFile.transferTo(file);
            responseData.setCode("true");
            responseData.setData("/data/images/" + fileName);

        } catch (IOException e) {
            e.printStackTrace();
            responseData.setCode("false");
            responseData.setData("上传失败");
        }
        return responseData;
    }

    @ResponseBody
    @RequestMapping("/excel/upload")
    public ResponseData excelUpload(Model model, @RequestParam(value = "excelFile", required = false) MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) {
        ResponseData responseData = new ResponseData();
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String suffix = (excelFile.getOriginalFilename().substring
                (excelFile.getOriginalFilename().lastIndexOf("."))).toLowerCase();
        /**拼成完整的文件保存路径加文件**/
        String filePath = realPath + "data" + File.separator + "excel";
        File imagesFile = new File(filePath);
        if (!imagesFile.exists()) {
            imagesFile.mkdirs();
        }
        String fileName = excelFile.getOriginalFilename();
        File file = new File(filePath + File.separator + fileName);
        try {
            responseData.setCode(true);
            responseData.setData("/data/excel/" + fileName);
            excelFile.transferTo(file);
//            sendSuccessJSON(response, "/data/excel/" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            responseData.setCode(false);
            responseData.setData("失败");
        }
        return responseData;
    }

    /**
     * {
     * "success": true/false,
     * "msg": "error message", # optional
     * "file_path": "[real file path]"
     * }
     *
     * @param model
     * @param imageFile
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/simditor/upload")
    public Map<String, Object> simditorUpload(Model model, @RequestParam(value = "imageFile", required = false) MultipartFile imageFile, HttpServletRequest request, HttpServletResponse response) {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String suffix = (imageFile.getOriginalFilename().substring
                (imageFile.getOriginalFilename().lastIndexOf("."))).toLowerCase();
        /**拼成完整的文件保存路径加文件**/
        String imagesPath = realPath + "data" + File.separator + "images";
        File imagesFile = new File(imagesPath);
        if (!imagesFile.exists()) {
            imagesFile.mkdirs();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        ;
        File file = new File(imagesPath + File.separator + fileName);
        ResponseData responseData = new ResponseData();
        Map<String, Object> data = new HashMap<>();
        try {
            imageFile.transferTo(file);
            responseData.setCode(true);
            data.put("success", true);
            data.put("msg", "上传成功");
            data.put("file_path", "/data/images/" + fileName);
//            responseData.setData("/data/images/" + fileName);

        } catch (IOException e) {
            e.printStackTrace();
            data.put("success", false);
            data.put("msg", true);
//            data.put("file_path","/data/images/" + fileName);
        }
        return data;
    }

    @ResponseBody
    @RequestMapping("/image/ajax-upload")
    public String imageAjaxUpload(Model model, @RequestParam(value = "imageFile", required = false) MultipartFile imageFile, HttpServletRequest request, HttpServletResponse response) {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String suffix = (imageFile.getOriginalFilename().substring
                (imageFile.getOriginalFilename().lastIndexOf("."))).toLowerCase();
        /**拼成完整的文件保存路径加文件**/
        String imagesPath = realPath + "data" + File.separator + "images";
        File imagesFile = new File(imagesPath);
        if (!imagesFile.exists()) {
            imagesFile.mkdirs();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        ;
        File file = new File(imagesPath + File.separator + fileName);
        ResponseData responseData = new ResponseData();
        try {
            imageFile.transferTo(file);
            return "{\"code\":true,\"message\":\"上传成功\",\"data\":\"/data/images/" + fileName + "\"}";

        } catch (IOException e) {
            e.printStackTrace();
            return "{\"code\":false,\"message\":\"上传失败\"";
        }

    }

}
