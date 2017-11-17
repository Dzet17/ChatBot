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
		display.displayText("Welcome to Chatbot");
	}

	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	
	/**
	 * Uses the processConversation constructor to configure what you have input
	 * @param chat
	 * @return A somewhat reasonable response to what you said
	 */
	private String popupChat(String chat)
	{
		String chatbotSays = ""; //Assigns a valid value to a variable that will be returned for the method.
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public Chatbot getChatbot()
	{
		return null;
	}
	public PopupDisplay getDisplay()
	{
		return null;
	}	
	public ChatFrame getChatFrame()
	{
		return null;
	}
}
