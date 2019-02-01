import java.awt.Color;

public class GraphicElement {

	private int i_height;
	private int i_width;
	private int i_xpos;
	private int i_ypos;
	
	private Color color;
	
	private boolean b_visible=false;
	
	public GraphicElement()
	{
		
	}
	
	public void DrawMe()
	{
		if(b_visible==true)
		{
			
		}
	}

	public int getI_height() {
		return i_height;
	}

	public void setI_height(int i_height) {
		this.i_height = i_height;
	}

	public int getI_width() {
		return i_width;
	}

	public void setI_width(int i_width) {
		this.i_width = i_width;
	}

	public int getI_xpos() {
		return i_xpos;
	}

	public void setI_xpos(int i_xpos) {
		this.i_xpos = i_xpos;
	}

	public int getI_ypos() {
		return i_ypos;
	}

	public void setI_ypos(int i_ypos) {
		this.i_ypos = i_ypos;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isB_visible() {
		return b_visible;
	}

	public void setB_visible(boolean b_visible) {
		this.b_visible = b_visible;
	}
	
}
