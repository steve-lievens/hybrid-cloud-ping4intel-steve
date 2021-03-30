package com.team4.hybridcloudping4intel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import util.Crypto;

@SpringBootApplication
public class HybridCloudPing4intelApplication {

    public static void main(String[] args) {
        SpringApplication.run(HybridCloudPing4intelApplication.class, args);
        new HybridCloudPing4intelApplication().run();
    }

    public void run(){
        String username = Crypto.getInstance().encrypt("");
        System.out.println(username);

        String pw = Crypto.getInstance().encrypt("");
        System.out.println(pw);
    }



}
