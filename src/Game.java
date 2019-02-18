import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;

import org.xml.sax.Attributes;
//import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Game extends JFrame implements KeyListener {
	private ArrayList<Scene> al_scenes = new ArrayList<Scene>();
	private int i_currentState = 0; // program states: main menu (0), game (1) and pause (2)
	private int i_currentScene = 0; // i_sceneID for current scene
	private int i_windowWidth = 1600;
	private int i_windowHeight = 800;

	public Game() // initialize
	{
		setSize(i_windowWidth, i_windowHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(true);
		Graphics g = this.getGraphics();
		g.setColor(Color.cyan);
		addKeyListener(this);

		LoadXML();

		GameLoop();
	}

	public void GameLoop() //
	{
		while (true) 
		{
			while (i_currentState == 0)// main menu
			{

			}

			while (i_currentState == 1)// game
			{

			}

			while (i_currentState == 2)// pause
			{

			}
		}
	}

	public void LoadXML() 
	{
		try 
		{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() 
			{
				boolean bfname = false;
				boolean blname = false;
				boolean bnname = false;
				boolean bsalary = false;

				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException 
				{
					System.out.println("Start Element :" + qName);

					if (qName.equalsIgnoreCase("FIRSTNAME")) 
					{
						bfname = true;
					}

					if (qName.equalsIgnoreCase("LASTNAME")) 
					{
						blname = true;
					}

					if (qName.equalsIgnoreCase("NICKNAME")) 
					{
						bnname = true;
					}

					if (qName.equalsIgnoreCase("SALARY")) 
					{
						bsalary = true;
					}

				}

				public void endElement(String uri, String localName, String qName) throws SAXException 
				{
					System.out.println("End Element :" + qName);
				}

				public void characters(char ch[], int start, int length) throws SAXException 
				{

					if (bfname) 
					{
						System.out.println("First Name : " + new String(ch, start, length));
						bfname = false;
						System.out.println(length);
					}

					if (blname) 
					{
						System.out.println("Last Name : " + new String(ch, start, length));
						blname = false;
					}

					if (bnname) 
					{
						System.out.println("Nick Name : " + new String(ch, start, length));
						bnname = false;
					}

					if (bsalary) 
					{
						System.out.println("Salary : " + new String(ch, start, length));
						bsalary = false;
					}
				}
			};

			saxParser.parse("File.txt", handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// }

	// }

	public void Load() // TODO load saved game.
	{
		try {

		}
		// catch(){}
		finally {
		}
	}

	public void Save() // TODO save game to .txt-file. Should just be scene ID.
	{
		try {

		}
		// catch(){}
		finally {
		}
	}

	public void SwitchFromOrToPauseState() {
		System.out.println("test pause");

		if (i_currentState == 1) {
			i_currentState = 2;
			System.out.println("1 " + i_currentState);
		} else if (i_currentState == 2) {
			i_currentState = 1;
			System.out.println("2 " + i_currentState);
		}
	}

	@Override
	public void keyPressed(KeyEvent KE) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent KE) {
		// TODO Auto-generated method stub
		if (KE.getKeyCode() == KeyEvent.VK_SPACE) // TODO continue/scroll text &
													// go to next scene
		{
			System.out.println("test space");

			if (i_currentState == 1) {
				// scroll
			}
		}

		if (KE.getKeyCode() == KeyEvent.VK_ESCAPE) // TODO Pause
		{
			SwitchFromOrToPauseState();
		}

		if (KE.getKeyCode() == KeyEvent.VK_P) // TODO also pause
		{
			SwitchFromOrToPauseState();
		}
	}

	@Override
	public void keyTyped(KeyEvent KE) {
		// TODO Auto-generated method stub

	}
}
