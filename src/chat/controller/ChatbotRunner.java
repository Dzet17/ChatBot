package chat.controller;

import java.util.List;
import java.util.ArrayList;
import chat.model.Chatbot;
import chat.view.PopupDisplay;


public class ChatbotRunner 
{
	public static void main (String [] args)
	{
		PopupDisplay sample = new PopupDisplay();
		sample.displayText("asd");
		sample.collectResponse("Asdaasdasdas");
	}
}