package com.wintux.principal.Configuraciones;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	@Bean
	public NewTopic miPrimerTopic() {
		return TopicBuilder.name("pruebita")
				//.partitions(3)
				.build();
	}
	@Bean
	public NewTopic miSegundoTopic() {
		return TopicBuilder.name("jsonTpc")
				//.partitions(3)
				.build();
	}
}
