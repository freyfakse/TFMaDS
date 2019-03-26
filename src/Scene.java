import java.util.ArrayList;

public class Scene extends GraphicElement
{
	private ArrayList<Integer> al_childrenIDs = new ArrayList<Integer>(); //position in sceneArray of next scenes
	private ArrayList<Integer> al_actorIDs = new ArrayList<Integer>(); //Corresponds to Actor's 'i_actorID'
	private ArrayList<String> al_texts = new ArrayList<String>(); //all dialog and text in current scene
	private int i_parentID; //position in sceneArray of previous scene
	private int i_sceneID; //position in sceneArray of current scene
	//private String str_text; //all dialog and text in current scene

	public Scene()
	{
		al_actorIDs.clear();
	}
	
	//To be used after a scene has been appended to 'al_scenes'. The same scene instance is then refilled and reappended.
	public void ResetVariables() 
	{
		al_childrenIDs.clear();
		al_actorIDs.clear();
		al_texts.clear();
		//i_parentID = -1;
		//i_sceneID = -1;
	}
	

	public ArrayList<String> getAl_texts() {
		return al_texts;
	}

	public void setAl_texts(ArrayList<String> al_texts) {
		this.al_texts = al_texts;
	}

	public ArrayList<Integer> getAl_children() {
		return al_childrenIDs;
	}

	public void setAl_children(ArrayList<Integer> al_children) {
		this.al_childrenIDs = al_children;
	}

	public ArrayList<Integer> getAl_actors() {
		return al_actorIDs;
	}

	public void setAl_actors(ArrayList<Integer> al_actors) {
		this.al_actorIDs = al_actors;
	}

	public int getI_parent() {
		return i_parentID;
	}

	public void setI_parent(int i_parent) {
		this.i_parentID = i_parent;
	}

	public int getI_sceneID() {
		return i_sceneID;
	}

	public void setI_sceneID(int i_sceneID) {
		this.i_sceneID = i_sceneID;
	}
}
