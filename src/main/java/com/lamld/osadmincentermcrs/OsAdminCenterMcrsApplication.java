package com.lamld.osadmincentermcrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan({"com.lamld", "vn.mos.core"})
public class OsAdminCenterMcrsApplication {

  public static void main(String[] args) {
    SpringApplication.run(OsAdminCenterMcrsApplication.class, args);
  }

}
