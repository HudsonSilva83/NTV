package br.com.iptv.auto;

import org.telegram.telegrambots.meta.api.objects.Message;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Mensagem {
	
	private static final String MESSAGE_FIELD = "message";
	
	 @JsonProperty(MESSAGE_FIELD)
	    private Message message; 



	public boolean hasMessage() {
		// TODO Auto-generated method stub
		return false;
	}

	public Message getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
