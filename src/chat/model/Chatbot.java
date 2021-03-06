package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String[] verbs;
	private String[] topics;
	private String[] followUps;
	private String[] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;

	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = null;
		this.questions = new String[10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.currentTime = LocalTime.now();
		this.topics = new String[7];
		this.verbs = new String[4];
		this.followUps = new String[5];

		buildVerbs();
		buildShoppingList();
		getFollowUps();
		buildQuestions();
		getTopics();
		buildMovieList();
	}

	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "ambivalent about";
		verbs[3] = "am thinking about";
	}

	private void buildMovieList()
	{
		movieList.add(new Movie("Spiderhuman"));
	}

	private void buildShoppingList()
	{
		shoppingList.add("eggs");
		shoppingList.add("protein");
		shoppingList.add("hot peppers");
		shoppingList.add("onions");
		shoppingList.add("snacks");
		shoppingList.add("bagel");
		shoppingList.add("crunchy peanut butter");
		shoppingList.add("hot sauce");
		shoppingList.add("juice");
	}

	private void buildCuteAnimals()
	{
		
	}

	private void buildQuestions()
	{

	}

	/**
	 * Takes the user's text input and processes it and returns a string
	 * @param input The user's supplied text
	 * @return The combined input and response
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += currentTime.getHour() + ":" + currentTime.getMinute() + " ";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();

		return chatbotResponse;
	}

	/**
	 * Builds a random response using the chatbot's sentence part arrays.
	 * @return The random response of a chatbot.
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);

		response += verbs[random];

		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".";

		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		if (random % 2 == 0)
		{
		random = (int) (Math.random() * movieList.size());
		response += "\n" + movieList.get(random).getTitle() + " is a great movie!";
		}
	
		if (random % 2 == 0)
		{
			random = (int) (Math.random() * movieList.size());
			response += "\n" + movieList.get(random).getTitle() + " is a g great movie!";
		}
		
		int followup = (int) (Math.random() * 5);
		
		switch (followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
		case 1: 
			response += followUps[2] + "\n";
			break;
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
		}
		
		
		return response;
	}
	
	/**
	 * Checks the length of the string, so chatbot can respond accordingly
	 * @param input the user's supplied text
	 * @return A similarly lengthened response
	 */
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;

		if (input != null)

		{
			if (input.length() > 2)
				validLength = true;
		}
		return validLength;
	}

	public boolean htmlTagChecker(String input)
	{
			boolean containsHTML = false;
			if(input == null || !input.contains("<"))
			{
				
			}
			int firstOpen = input.indexOf("<");
			int firstClose = input.indexOf(">",firstOpen);
			int secondOpen = -9;
			int secondClose = -9;
			String tagText = "";
			
			//Check bad tags
			if(input.contains("<>") || input.indexOf("< >") > -1)
			{
				containsHTML = false;
			}
			//Check singleton
			if(input.toUpperCase().contains("<P>") || input.toLowerCase().contains("<br>"))
			{
				containsHTML = true;
			}
			//Check others
			else if(firstClose > firstOpen)
				
				
				//Others
				tagText = input.substring(firstOpen + 1, firstClose).toLowerCase();
				secondOpen = input.toLowerCase().indexOf("</" + tagText, firstClose);
				
			return containsHTML;
				
	}

	public boolean userNameChecker(String input)
	{
		return false;
	}

	public boolean contentChecker(String contentChecker)
	{
		return false;
	}

	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}

	/**
	 * Checks if the shoppingList is true, making the chatbot able to respond
	 * @param shoppingItem Adds these keywords for direct response
	 * @return A premade response for the keyword
	 */
	public boolean shoppingListChecker(String shoppingItem)
	{
		for (String i:shoppingList) 
		{
			if(shoppingItem.indexOf(i) >= 0);	
		}
		return true;
	}

	public boolean movieTitleChecker(String title)
	{
		return false;
	}

	public boolean movieGenreChecker(String genre)
	{
		return false;
	}
	
/**
 * The 
 * @param exitString
 * @return
 */
	public boolean quitChecker(String exitString)
	{
		if (exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		return false;
	}
	
	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}

	public List<Movie> getMovieList()
	{
		return movieList;
	}

	public List<String> getShoppingList()
	{
		return shoppingList;
	}

	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String[] getQuestions()
	{
		return null;
	}

	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}

	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}

	public LocalTime getCurrentTime()
	{
		return null;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
}
