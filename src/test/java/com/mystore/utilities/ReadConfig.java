package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
    public Properties properties;
//    String path ="D:\\JOB FIND 10 days study 28-6\\RESUME MAY end\\Sapient\\testproject\\CodeStudioFramework\\configuration/config.properties";
    String path = System.getProperty("user.dir")+"\\configuration\\config.properties";
//    String path = "D:/JOB FIND 10 days study 28-6/RESUME MAY end/Sapient/testproject/CodeStudioFramework/configuration/config.properties";
    public ReadConfig(){
        try {
        properties = new Properties();
            System.out.println(path);
            FileInputStream file = new FileInputStream(path);
            properties.load(file);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public String getBaseUrl(){
        String value = properties.getProperty("baseurl");
        System.out.println("baseURL value is"+value);
        if(value!=null) {
            return value;
        }
        else{
            throw new RuntimeException("URL not specified");
            }

        }

    public String getBrowser(){
        String value = properties.getProperty("browser");
        if(value!=null) {
            return value;
        }
        else{
            throw new RuntimeException("URL not specified");
        }

    }

    }
