package com.giants3.reader.utils;

import java.io.File;

/**
 * Created by davidleen29 on 2018/7/4.
 */
public class Assets {
    public   static String ASSETS_URL;

    public static final String PATH_DIVIDER_ON_URL="__";


    public static void init(String ip,String serverName)
    {
        ASSETS_URL="http://"+ip+":8080/"+serverName+"/api/file/";
    }


    public static String completeUrl(String path)
    {

        return ASSETS_URL+UrlFormatter.encode(path.replace(File.separator,PATH_DIVIDER_ON_URL));

    }
}
