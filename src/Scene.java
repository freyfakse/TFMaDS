import java.util.ArrayList;

public class Scene extends GraphicElement
{
	private ArrayList<Integer> al_children = new ArrayList<Integer>(10); //position in sceneArray of next scenes
	private ArrayList<Character> al_actors = new ArrayList<Character>(10);
	private ArrayList<String> al_texts = new ArrayList<String>(10); //all dialog and text in current scene
	private int i_parent; //position in sceneArray of previous scene
	private int i_sceneID; //position in sceneArray of current scene
	//private String str_text; //all dialog and text in current scene

	public Scene()
	{
		
	}

	public ArrayList<String> getAl_texts() {
		return al_texts;
	}

	public void setAl_texts(ArrayList<String> al_texts) {
		this.al_texts = al_texts;
	}

	public ArrayList<Integer> getAl_children() {
		return al_children;
	}

	public void setAl_children(ArrayList<Integer> al_children) {
		this.al_children = al_children;
	}

	public ArrayList<Character> getAl_actors() {
		return al_actors;
	}

	public void setAl_actors(ArrayList<Character> al_actors) {
		this.al_actors = al_actors;
	}

	public int getI_parent() {
		return i_parent;
	}

	public void setI_parent(int i_parent) {
		this.i_parent = i_parent;
	}

	public int getI_sceneID() {
		return i_sceneID;
	}

	public void setI_sceneID(int i_sceneID) {
		this.i_sceneID = i_sceneID;
	}
}
