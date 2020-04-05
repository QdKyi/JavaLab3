package ua.lviv.iot.ExtremeSportEquipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "ua.lviv.iot.ExtremeSportEquipment.dataAccess", "ua.lviv.iot.ExtremeSportEquipment.business",
        "ua.lviv.iot.ExtremeSportEquipment.controller" })
@EnableJpaRepositories("ua.lviv.iot.ExtremeSportEquipment.dataAccess")
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}