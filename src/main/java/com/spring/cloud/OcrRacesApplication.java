package com.spring.cloud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class OcrRacesApplication implements CommandLineRunner {

	private static List<Race> races = new ArrayList<Race>(); 
	
	@Autowired
	private ParticipantsClient participantClient;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(OcrRacesApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception 
	{
		races.add(new Race("Beast", "123", "MA", "Stuttgart"));
		races.add(new Race("Tough Mudder", "456", "RI", "Providence"));
	}
	
	@RequestMapping("/")
	public List<Race> getRaces()
	{
		return races;
	}
	
	@RequestMapping("/participants")
	public List<RaceswithPartocipants> getRacesWithParticipants()
	{
		List<RaceswithPartocipants> returnRaces = new ArrayList<RaceswithPartocipants>();
		
		for(Race r : races)
		{
			returnRaces.add(new RaceswithPartocipants(r, participantClient.getParticipants(r.getId())));
		}
		return returnRaces;
	}
	
}
