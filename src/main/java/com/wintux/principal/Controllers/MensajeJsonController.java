package com.wintux.principal.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wintux.principal.Models.Usuario;
import com.wintux.principal.kafka.JsonKafkaProducer;

@RestController
@RequestMapping("/api/kafka/json") // http://localhost:8080/api/kafka/json
public class MensajeJsonController {
	private JsonKafkaProducer kafkaJsonProd;

	public MensajeJsonController(JsonKafkaProducer kafkaJsonProd) {
		super();
		this.kafkaJsonProd = kafkaJsonProd;
	}
	@PostMapping("/publicar") // http://localhost:8080/api/kafka/json/publicar [POST]
	public ResponseEntity<String> publicarJson(@RequestBody Usuario usu){
		kafkaJsonProd.enviarMensaje(usu);
		return ResponseEntity.ok("Se envió el mensaje (un usuario) al topic de kafka.");
	}
}
