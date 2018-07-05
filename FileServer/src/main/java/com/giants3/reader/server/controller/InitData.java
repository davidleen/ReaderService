package com.giants3.reader.server.controller;

import com.giants3.reader.server.service.BookService;
import com.giants3.reader.server.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 应用程序启动初始化
 * Created by davidleen29 on 2015/8/7.
 */
@Component
public class InitData implements ApplicationListener<ContextRefreshedEvent> {


    private static final Logger logger = Logger.getLogger(InitData.class);
    private static boolean isStart = false;


    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

//
//    @Autowired
//    TestXmlRepository testXmlRepository;




    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (!isStart) {

            final String applicationName = event.getApplicationContext().getApplicationName();



            userService.addOne();
            bookService.addOne();
            bookService.addOneComic();

        }
        System.out.println("spring 容器初始化完毕================================================");

    }





}
