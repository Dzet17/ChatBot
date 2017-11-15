package chat.controller;

import chat.model.*;
import chat.view.*;

public class ChatbotController 
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Dylan Zettler");
		//View initialized after Model
		display = new PopupDisplay();
		appFrame =new ChatFrame(this);
	}
	
	public void start()

	{
		String response = display.collectResponse("What do you want to talk about");
		
		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
		{
			response = popupChat(response);
			response = display.collectResponse(response);
		}
	}

	public String interactWithChatbot(String input)
	
	private String popupChat(String chat)
	{
		String chatbotSays = ""; //Assigns a valid value to a variable that will be returned for the method.
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public Chatbot getChatbot()
	
	public PopupDisplay getDisplay()
	
	public ChatFrame getChatFrame()
	}
}
