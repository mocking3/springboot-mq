package net.runningcoder.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class MqDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqDemoApplication.class, args);
	}
}
