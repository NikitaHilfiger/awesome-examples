package com.client;

import com.client.shared.CabBookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
@ComponentScan
public class MainConfig {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);

        CabBookingService service = ctx.getBean(CabBookingService.class);
        int resultRmiMethod = service.doSome(5, 3);
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
