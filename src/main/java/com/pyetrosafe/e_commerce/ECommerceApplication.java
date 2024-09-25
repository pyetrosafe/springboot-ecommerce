package com.pyetrosafe.e_commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication()
public class ECommerceApplication {

    @RequestMapping("/")
    public String home() {
        return "<center><b>Hello Docker World AEEEEEEEEEEE!</b></center>";
    }
    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
        System.out.println("Está rodando mais melhor de bom porra!");
    }

}
