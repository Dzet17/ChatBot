package chat.controller;

import java.util.List;
import java.util.ArrayList;
import chat.model.Chat;
import chat.view.PopupDisplay;


public class ChatRunner 
{
	public static void main (String [] args)
	{
		PopupDisplay sample = new PopupDisplay();
		sample.displayText("asd");
		sample.collectResponse("Asdaasdasdas");
	}
}