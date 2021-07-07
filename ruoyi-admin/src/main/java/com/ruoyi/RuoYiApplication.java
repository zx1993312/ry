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
        System.out.println(".---.  .---.    ____    ,---.   .--.  .-_'''-.              ____     __   ___    _  \r\n" + 
        		"|   |  |_ _|  .'  __ `. |    \\  |  | '_( )_   \\             \\   \\   /  /.'   |  | | \r\n" + 
        		"|   |  ( ' ) /   '  \\  \\|  ,  \\ |  ||(_ o _)|  '             \\  _. /  ' |   .'  | | \r\n" + 
        		"|   '-(_{;}_)|___|  /  ||  |\\_ \\|  |. (_,_)/___|              _( )_ .'  .'  '_  | | \r\n" + 
        		"|      (_,_)    _.-`   ||  _( )_\\  ||  |  .-----.         ___(_ o _)'   '   ( \\.-.| \r\n" + 
        		"| _ _--.   | .'   _    || (_ o _)  |'  \\  '-   .'        |   |(_,_)'    ' (`. _` /| \r\n" + 
        		"|( ' ) |   | |  _( )_  ||  (_,_)\\  | \\  `-'`   |         |   `-'  /     | (_ (_) _) \r\n" + 
        		"(_{;}_)|   | \\ (_ o _) /|  |    |  |  \\        /          \\      /       \\ /  . \\ / \r\n" + 
        		"'(_,_) '---'  '.(_,_).' '--'    '--'   `'-...-'            `-..-'         ``-'`-''  \r\n" + 
        		"                                                                                    ");
    }
}