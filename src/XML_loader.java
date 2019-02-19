import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XML_loader {
	
	
	public ArrayList<Scene> al_scenes = new ArrayList<Scene>(10);
	private Scene scene = new Scene(); 
	
	public XML_loader()
	{
		
	}
	
	public void LoadScenesFromXML() //a scene is put together from XML and then put in 'al_scenes'
	{
		try 
		{
			SAXParserFactory saxFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxFactory.newSAXParser();

			DefaultHandler saxHandler = new DefaultHandler() 
			{	
				boolean b_sceneID = false;
				boolean b_parentID = false;
				boolean b_childID = false;
				boolean b_actor = false;
				boolean b_text = false;
				
				int i_currentScene = 0; //Position of scene we're currently loading
				int i_currentChild = 0; //Position of child scene in current scene's 'al_children' we're currently loading
				int i_currentActor = 0; //Position of actor in current scene's 'al_actors' we're currently loading
				int i_currentText = 0; //Position of text in current scene's 'al_texts' we're currently loading

				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException 
				{
					System.out.println("Start Element :" + qName);

					if (qName.equalsIgnoreCase("scene_ID")) 
					{
						b_sceneID = true;
					}

					if (qName.equalsIgnoreCase("parent_ID")) 
					{
						b_parentID = true;
					}

					if (qName.equalsIgnoreCase("child_ID")) 
					{
						b_childID = true;
					}

					if (qName.equalsIgnoreCase("b_actor")) 
					{
						b_actor = true;
					}
					
					if (qName.equalsIgnoreCase("text")) 
					{
						b_text = true;
					}
				}

				public void endElement(String uri, String localName, String qName) throws SAXException 
				{
					System.out.println("End Element :" + qName);
					
					if(qName.equalsIgnoreCase("scene"))
					{
						//al_scenes.set(i_currentScene, scene);
						
						i_currentScene ++;
						
						i_currentChild = 0;
						i_currentActor = 0;
						i_currentText = 0;
						
						System.out.println("current scene" +i_currentScene);
					}
					
					if(qName.equalsIgnoreCase("child_ID"))
					{
						i_currentChild ++;
					}
					if(qName.equalsIgnoreCase("actor"))
					{
						i_currentActor ++;
					}
					if(qName.equalsIgnoreCase("text"))
					{
						i_currentText ++;
					}
				}

				public void characters(char ch[], int start, int length) throws SAXException 
				{

					if (b_sceneID) 
					{
						System.out.println("ID of scene : " + new String(ch, start, length));
						scene.setI_sceneID(Integer.parseInt(new String(ch, start, length)));
						b_sceneID = false;
					}

					if (b_parentID) 
					{
						System.out.println("ID of parent : " + new String(ch, start, length));
						scene.setI_parent(Integer.parseInt(new String(ch, start, length)));
						b_parentID = false;
					}

					if (b_childID) 
					{
						scene.getAl_children().ensureCapacity(i_currentChild+1);
						System.out.println("ID of child : " + new String(ch, start, length));
						
						int holder = Integer.parseInt(new String(ch, start, length));
						System.out.println("holder: " + holder +" i_cc: " +i_currentChild);
						
						scene.getAl_children().set(i_currentChild, holder);
						b_childID = false;
					}

					if (b_actor) 
					{
						System.out.println("Name of actor : " + new String(ch, start, length));
						scene.getAl_children().set(i_currentActor, Integer.parseInt(new String(ch, start, length)));
						b_actor = false;
					}
					
					if (b_text) 
					{
						System.out.println("text : " + new String(ch, start, length));
						scene.getAl_children().set(i_currentText, Integer.parseInt(new String(ch, start, length)));
						b_text = false;
					}
				}
			};

			saxParser.parse("scenes.txt", saxHandler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
