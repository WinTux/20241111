package com.wintux.principal.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wintux.principal.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/kafka") // http://localhost:9092/api/kafka
public class MensajeController {
	private KafkaProducer kafkaProd;

	public MensajeController(KafkaProducer kafkaProd) {
		super();
		this.kafkaProd = kafkaProd;
	}
	@GetMapping("/publicar") // http://localhost:9092/api/kafka/publicar?mensajito=Hola a todos
	public ResponseEntity<String> publicar(@RequestParam("mensajito") String msj){
		kafkaProd.enviarMensaje(msj);
		return ResponseEntity.ok("Mensaje enviado al topic.");
	}
}
