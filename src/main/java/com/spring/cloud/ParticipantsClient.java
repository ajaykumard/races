package com.spring.cloud;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.cloud.Participant;

@FeignClient("participants")
public interface ParticipantsClient 
{
	@RequestMapping(method=RequestMethod.GET,value="/races/{raceId}")
	List<Participant> getParticipants(@PathVariable("raceId") String receId);
}
