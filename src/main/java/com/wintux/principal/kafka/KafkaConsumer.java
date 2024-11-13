package com.wintux.principal.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	@KafkaListener(topics="pruebita", groupId="miGrupito")
	public void consumir(String mensaje) {
		LOGGER.info(String.format("Se recibió el mensaje: %s.", mensaje));
	}
}
