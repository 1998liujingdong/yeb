package com.cqupt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.cqupt.mapper")
public class YebApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(YebApplication.class,args);
    }
}
