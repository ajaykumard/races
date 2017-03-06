package com.spring.cloud;

import java.util.List;

import com.spring.cloud.Participant;

public class RaceswithPartocipants extends Race 
{
	private List<Participant> participants;
	
	public RaceswithPartocipants(Race r,List<Participant> participants)
	{
		super(r.getName(),r.getId(),r.getCity(),r.getState());
		this.participants = participants;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
	
	
}
