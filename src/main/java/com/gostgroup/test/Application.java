package com.gostgroup.test;

import com.gostgroup.test.rest.UsersController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"model"}, basePackageClasses = UsersController.class)
@EnableAutoConfiguration
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}

