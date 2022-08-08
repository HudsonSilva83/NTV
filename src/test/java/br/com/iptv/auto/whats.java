package br.com.iptv.auto;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class whats {

	public static final String ACCOUNT_SID = "ACa9f46cddfd842c87ccc309b2c793fe4c";
	public static final String AUTH_TOKEN = "cdcdb69eb2a0fa11126d643d76eb8958";

	public void mensagem(String mensagem) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(new com.twilio.type.PhoneNumber("whatsapp:+553194143658"),
				new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), mensagem).create();

	}

}
