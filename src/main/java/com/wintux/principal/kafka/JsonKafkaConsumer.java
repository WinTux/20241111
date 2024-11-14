package com.wintux.principal.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.wintux.principal.Models.Usuario;

@Service
public class JsonKafkaConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	@KafkaListener(topics="jsonTpc", groupId="miGrupito")
	public void Consumir(Usuario u) {
		LOGGER.info(String.format("Se recibió JSON: %s.", u));
	}
}
