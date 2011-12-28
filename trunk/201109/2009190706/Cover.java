import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class Cover {

	final private int WIDTH=20;
	final private int HEIGHT=20;
	private int xLeft;
	private int yTop;
	private Rectangle cover;
	private int condition;	//0:closed	1:open	2:checking	3:broken

    public Cover(int x, int y) {
    	xLeft=x;
    	yTop=y;
    	cover = new Rectangle(xLeft, yTop, WIDTH, HEIGHT);
    }

    public void draw(Graphics2D g2){
    	g2.setColor(new Color(0.75f, 0.75f, 0.75f));
    	if(condition==0)
    		g2.fill(cover);
    	else if(condition==1)
    		g2.draw(cover);
    	else if(condition==2){
    		g2.setColor(Color.GREEN);
    		g2.fill(cover);
    	}
    	else{
    		g2.setColor(Color.RED);
    		g2.fill(cover);
    	}
    }

    public void setCondition(int c){
    	condition=c;
    }

    public boolean isOpen(){
    	if(condition==1)
    		return true;
    	else
    		return false;
    }

    public boolean isChecking(){
    	if(condition==2)
    		return true;
    	else
    		return false;
    }
}