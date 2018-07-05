package com.giants3.reader.server.controller;

import com.giants3.reader.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * Created by davidleen29 on 2018/5/19.
 */
@Controller
@RequestMapping("/file")
public class FileController extends  BaseController  {

    @Value("${rootPath}")
    private String rootPath;



    @RequestMapping(value = "/{filePath:.+}", method = RequestMethod.GET )
    @ResponseBody
    public FileSystemResource getProductFile(@PathVariable("filePath") String filePath  ) {


        logger.info("filePath====:"+filePath);
//        try {
//            filePath = new String(filePath.getBytes("ISO-8859-1"), "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        logger.info("filePath:"+filePath);
        String[] fileName=filePath.split("__");

        logger.info(filePath);
        String destFilePath=rootPath+File.separator+ StringUtils.combine(fileName, File.separator);

        FileSystemResource resource = new FileSystemResource(destFilePath);

        if(resource.exists()) return resource;
        return null;




    }

}
