import java.util.ArrayList;

public class Scene extends GraphicElement
{
	private ArrayList<String> arrLi_Text = new ArrayList<String>(); //all dialog and text in current scene
	private ArrayList<Integer> arrLi_children = new ArrayList<Integer>(); //position in sceneArray of next scenes
	private int i_parent; //position in sceneArray of previous scene
	private int i_sceneID; //position in sceneArray of current scene

	public Scene()
	{
		
	}
}
