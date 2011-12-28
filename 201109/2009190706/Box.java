import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class Box{

	final private int WIDTH=20;
	final private int HEIGHT=20;
	private int xLeft;
	private int yTop;
	private int element;	//9 is mine
	private Rectangle box;

    public Box(int x, int y, int e) {
    	xLeft=x;
    	yTop=y;
    	element=e;
    	box = new Rectangle(xLeft, yTop, WIDTH, HEIGHT);
    }

    public void draw(Graphics2D g2){
    	g2.setColor(Color.BLACK);
    	g2.draw(box);

    	if(isMine())
    		g2.drawString("*", xLeft+8, yTop+17);

    	else if(element!=0){
    		switch(element){
    				case 1:
    					g2.setColor(new Color(0.0f, 0.0f, 0.6f));
    					break;
    				case 2:
    					g2.setColor(new Color(0.0f, 0.6f, 0.0f));
    					break;
    				case 3:
    					g2.setColor(new Color(0.6f, 0.0f, 0.0f));
    					break;
    				case 4:
    					g2.setColor(new Color(0.6f, 0.0f, 0.6f));
    					break;
    				case 5:
    					g2.setColor(new Color(0.0f, 0.6f, 0.6f));
    					break;
    				case 6:
    					g2.setColor(new Color(0.6f, 0.6f, 0.0f));
    					break;
    				default:
    			}
    		g2.drawString(""+element, xLeft+7, yTop+15);
    	}
    }

    public boolean isMine(){
    	if(element==9)
    		return true;
    	else return false;
    }

    public boolean isEmpty(){
    	if(element==0)
    		return true;
    	else return false;
    }

    public void setElement(int e){
    	element=e;
    }
}