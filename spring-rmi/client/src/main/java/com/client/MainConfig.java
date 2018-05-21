package com.client;

import com.client.shared.CabBookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@SpringBootApplication
public class MainConfig {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MainConfig.class, args);
        CabBookingService service = ctx.getBean(CabBookingService.class);
        int resultRmiMethod = service.doSome(3, 3);
        System.out.println("Result from RMI Service = " + resultRmiMethod);
    }

    @Bean
    RmiProxyFactoryBean service() {
        RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
        rmiProxyFactory.setServiceUrl("rmi://localhost:1099/CabBookingService");
        rmiProxyFactory.setServiceInterface(CabBookingService.class);
        return rmiProxyFactory;
    }
}
