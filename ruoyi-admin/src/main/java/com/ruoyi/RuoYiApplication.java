package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class RuoYiApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println("   _____            _             ____              _   \r\n" + 
        		"  / ____|          (_)           |  _ \\            | |  \r\n" + 
        		" | (___  _ __  _ __ _ _ __   __ _| |_) | ___   ___ | |_ \r\n" + 
        		"  \\___ \\| '_ \\| '__| | '_ \\ / _` |  _ < / _ \\ / _ \\| __|\r\n" + 
        		"  ____) | |_) | |  | | | | | (_| | |_) | (_) | (_) | |_ \r\n" + 
        		" |_____/| .__/|_|  |_|_| |_|\\__, |____/ \\___/ \\___/ \\__|\r\n" + 
        		"        | |                  __/ |                      \r\n" + 
        		"        |_|                 |___/                       ");
    }
}