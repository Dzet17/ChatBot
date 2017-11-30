package chat.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import java.awt.Color;
import chat.controller.ChatbotController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The JPanel subclass for the chatbot project
 * @author Dylan Zettler
 * @version 21/11/17 1.2
 */
public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout baseLayout;
	private JButton checkerButton;
	private JLabel infoLabel;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		//Initialize GUI data members
		chatButton = new JButton("chat");
		chatArea = new JTextArea(10, 20);
		inputField = new JTextField();
		infoLabel = new JLabel("Type to chat with the ChatBot");
		baseLayout = new SpringLayout();
		baseLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setLayout(baseLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}
	private void setupLayout()
	{
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 66, SpringLayout.SOUTH, inputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -36, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, 0, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, inputField);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 21, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, inputField, 169, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, -10, SpringLayout.EAST, this);
	}
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		
		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});	
	}
}
