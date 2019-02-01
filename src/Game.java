import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Game extends JFrame implements KeyListener
{
	private Scene[] sceneArray = new Scene[10];//10 is placeholder. Is to be the length of all # of scenes
	private int i_currentState;//program states: main menu (0), game (1) and pause (2)
	
	public Game() //initialize
	{
		
		GameLoop();
	}
	
	
	public void GameLoop() 
	{
		
	}
	
	public void Load()
	{
		try
		{
			
		}
		//catch(){}
		finally{}
	}
	
	public void Save()
	{
		
	}
	
	public void Pause()
	{
		if(i_currentState == 1)
		{
			
		}
		else if(i_currentState == 2)
		{
			
		}
	}

	@Override
	public void keyPressed(KeyEvent KE) {
		// TODO Auto-generated method stub
		if(KE.getKeyCode() == KeyEvent.VK_SPACE)//TODO continue/scroll text & go to next scene
		{
			
		}
		
		if(KE.getKeyCode() == KeyEvent.VK_ESCAPE)//TODO Pause
		{
			Pause();
		}
		
		if(KE.getKeyCode() == KeyEvent.VK_P)//TODO also pause
		{
			Pause();
		}
	}

	@Override
	public void keyReleased(KeyEvent KE) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent KE) {
		// TODO Auto-generated method stub
		
	}
}
