package com.server;

import com.server.shared.CabBookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
@ComponentScan
public class MainConfig {

    public static void main(String[] args) {
//        SpringApplication.run(MainConfig.class, args);

        new AnnotationConfigApplicationContext(MainConfig.class);

        System.out.println(
                "App startup is done"
        );
    }

    @Bean
    RmiServiceExporter exporter(CabBookingService implementation) {
        Class<CabBookingService> serviceInterface = CabBookingService.class;
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceInterface(serviceInterface);
        exporter.setService(implementation);
        exporter.setServiceName(serviceInterface.getSimpleName());
        exporter.setRegistryPort(1099);
        return exporter;
    }
}
