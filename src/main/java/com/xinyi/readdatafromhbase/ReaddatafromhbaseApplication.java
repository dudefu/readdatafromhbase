package com.xinyi.readdatafromhbase;

import com.xinyi.readdatafromhbase.runner.StartupRunner;
import com.xinyi.readdatafromhbase.runner.TaskRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReaddatafromhbaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReaddatafromhbaseApplication.class, args);
    }

    @Bean
    public StartupRunner startupRunner(){
        return new StartupRunner();
    }

    @Bean
    public TaskRunner taskRunner(){
        return new TaskRunner();
    }

}
