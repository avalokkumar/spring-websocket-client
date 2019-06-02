package com.clay.meetup.rsvp;

import com.clay.meetup.rsvp.handler.RsvpWebSocketHandler;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@SpringBootApplication
public class RsvpProcessorApplication {

	private static final String MEETUP_RSPV_ENDPOINT = "ws://stream.meetup.com/2/rsvps";

	public static void main(String[] args) {
		SpringApplication.run(RsvpProcessorApplication.class, args);
	}


	@Bean
	public ApplicationRunner initializeConnection(RsvpWebSocketHandler rsvpWebSocketHandler){

		return args -> {
			WebSocketClient rsvpSocketClient = new StandardWebSocketClient();

			rsvpSocketClient.doHandshake(rsvpWebSocketHandler, MEETUP_RSPV_ENDPOINT);
		};
	}
}
