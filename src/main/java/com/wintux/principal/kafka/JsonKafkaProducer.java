package com.wintux.principal.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.wintux.principal.Models.Usuario;

@Service
public class JsonKafkaProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
	private KafkaTemplate<String,Usuario> kafkaTemplate;
	public JsonKafkaProducer(KafkaTemplate<String, Usuario> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	public void enviarMensaje(Usuario user) {
		LOGGER.info(String.format("Mensaje enviado (objeto usuario): %s.", user));
		Message<Usuario> mensaje = MessageBuilder
				.withPayload(user)
				.setHeader(KafkaHeaders.TOPIC, "jsonTpc")
				.build();
		kafkaTemplate.send(mensaje);
	}
}
