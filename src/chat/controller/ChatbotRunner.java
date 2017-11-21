package chat.controller;

import java.util.List;
import java.util.ArrayList;
import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.controller.ChatbotController;

public class ChatbotRunner 
{
	public static void main (String [] args)
	{
		ChatbotController myApp = new ChatbotController();
		myApp.start();
	}
}