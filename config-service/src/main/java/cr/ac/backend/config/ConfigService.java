package cr.ac.backend.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication(
        scanBasePackages = {
                "cr.ac.backend.config",
                //"com.m4n0.amq"
        })
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigService {
    public static void main(String[] args) {
        SpringApplication.run(ConfigService.class, args);
    }
}