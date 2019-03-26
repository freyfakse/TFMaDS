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
			SAXParser sceneSaxParser = saxFactory.newSAXParser();

			DefaultHandler saxHandler = new DefaultHandler() 
			{	
				boolean b_sceneID = false;
				boolean b_parentID = false;
				boolean b_childID = false;
				boolean b_actorID = false;
				boolean b_text = false;

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

					if (qName.equalsIgnoreCase("actor_ID")) 
					{
						b_actorID = true;
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
						al_scenes.add(scene);
						scene.ResetVariables();
					}
					if(qName.equalsIgnoreCase("scene_ID")){}
					if(qName.equalsIgnoreCase("parent_ID")){}
					if(qName.equalsIgnoreCase("child_ID")){}
					if(qName.equalsIgnoreCase("actor_ID")){}
					if(qName.equalsIgnoreCase("text")){}
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
						System.out.println("ID of child : " + new String(ch, start, length));
						scene.getAl_children().add(Integer.parseInt(new String(ch, start, length)));
						/*
						for(int i=0;i<scene.getAl_children().size();i++)
						{
							System.out.println("children array id: " +scene.getAl_children().get(i));
						}
						*/
						b_childID = false;
					}

					if (b_actorID) 
					{
						System.out.println("Name of actor : " + new String(ch, start, length));
						//scene.getAl_children().set(i_currentActor, Integer.parseInt(new String(ch, start, length)));
						
						scene.getAl_actors().add(Integer.parseInt(new String(ch, start, length)));
						
						b_actorID = false;
					}
					
					if (b_text) 
					{
						System.out.println("text : " + new String(ch, start, length));
						//scene.getAl_children().set(i_currentText, Integer.parseInt(new String(ch, start, length)));
						
						scene.getAl_texts().add(new String(ch, start, length));
						
						b_text = false;
					}
				}
			};

			sceneSaxParser.parse("scenes.txt", saxHandler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void LoadActorsFromXML()
	{
		
	}
	
}
