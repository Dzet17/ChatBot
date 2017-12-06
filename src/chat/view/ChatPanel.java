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
import javax.swing.JScrollPane;
import javax.swing.JLabel;

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
	private SpringLayout baseLayout_1;
	private JButton checkerButton;
	private JLabel infoLabel;
	private JScrollPane chatScrollPane;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		//Initialize GUI data members
		chatButton = new JButton("chat");
		inputField = new JTextField();
		infoLabel = new JLabel("Type to chat with the ChatBot");
		baseLayout = new SpringLayout();
		baseLayout_1 = new SpringLayout();
		baseLayout_1.putConstraint(SpringLayout.NORTH, inputField, 245, SpringLayout.NORTH, this);
		baseLayout_1.putConstraint(SpringLayout.WEST, inputField, 49, SpringLayout.WEST, this);
		baseLayout_1.putConstraint(SpringLayout.EAST, inputField, -215, SpringLayout.EAST, this);
		baseLayout_1.putConstraint(SpringLayout.SOUTH, infoLabel, -6, SpringLayout.NORTH, inputField);
		baseLayout_1.putConstraint(SpringLayout.EAST, infoLabel, 0, SpringLayout.EAST, inputField);
		baseLayout_1.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.NORTH, inputField);
		baseLayout_1.putConstraint(SpringLayout.WEST, chatButton, 30, SpringLayout.EAST, inputField);
		chatScrollPane = new JScrollPane();
		baseLayout_1.putConstraint(SpringLayout.NORTH, chatScrollPane, -77, SpringLayout.SOUTH, this);
		baseLayout_1.putConstraint(SpringLayout.WEST, chatScrollPane, 8, SpringLayout.WEST, chatButton);
		baseLayout_1.putConstraint(SpringLayout.SOUTH, chatScrollPane, -6, SpringLayout.NORTH, chatButton);
		checkerButton = new JButton("Check contents");
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupScrollPane()
	{
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);	
	}

	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setLayout(baseLayout_1);
		this.add(chatButton);
		this.add(inputField);
		this.add(infoLabel);
		this.add(chatScrollPane);
		chatArea = new JTextArea(10, 20);
		baseLayout_1.putConstraint(SpringLayout.EAST, chatScrollPane, 2, SpringLayout.EAST, chatArea);
		baseLayout_1.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		baseLayout_1.putConstraint(SpringLayout.WEST, chatArea, 48, SpringLayout.WEST, this);
		baseLayout_1.putConstraint(SpringLayout.SOUTH, chatArea, 204, SpringLayout.NORTH, this);
		baseLayout_1.putConstraint(SpringLayout.EAST, chatArea, 327, SpringLayout.WEST, this);
		add(chatArea);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}
	private void setupLayout()
	{
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 66, SpringLayout.SOUTH, inputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatScrollPane, -36, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, 0, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, inputField);
		baseLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 21, SpringLayout.WEST, this);
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
