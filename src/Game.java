import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.io.*;
import java.util.ArrayList;


public class Game extends JFrame implements KeyListener {
	
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
		g.setColor(Color.cyan); ///funk'ærnte
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
		XML_loader xml = new XML_loader();
		xml.LoadScenesFromXML();
	}

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

		if (i_currentState == 1) 
		{
			i_currentState = 2;
			//System.out.println("1 " + i_currentState);
		} 
		
		else if (i_currentState == 2) 
		{
			i_currentState = 1;
			//System.out.println("2 " + i_currentState);
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
