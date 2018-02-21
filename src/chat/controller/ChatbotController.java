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
	/**
	 * starts the program with an introduction popup
	 */
	public void start()

	{
		display.displayText("Welcome to Chatbot");
	}

	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	
	public String useCheckers(String text)
	{
		String response = "";
		
		if(chatbot.contentChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response += "";
		}
		//continue will all checkers except length and quit checker
		
		return response;
	}
	
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
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
