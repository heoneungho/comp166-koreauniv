import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.Color;
import javax.swing.JComponent;
import java.util.Random;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class MainComponent extends JComponent {

	private Box[][] box;
	private Cover[][] cover;
	private int n;	//size
	private int numMines;
	private byte mode;	//0:normal	1:mine finding mode

    public MainComponent() {
    	numMines = 0;
    	mode = 0;

    	MouseListener listener = new CoverMouseListener();
    	addMouseListener(listener);

    	n=15;
    	createBoxes(n);
    	setMines(n);
    	setElements(n);
    	createCovers(n);
    }

    private void createBoxes(int n){
    	int m=n+2;	//메소드의 효율을 위해 상하좌우 한 줄씩 크게 생성
    	int x=0;
    	int y=0;
    	box = new Box[m][m];
    	for(int i=0; i<m; i++){
    		for(int j=0; j<m; j++){
    			box[i][j] = new Box(x, y, 0);
    			x=x+20;
    		}
    		x=0;
    		y=y+20;
    	}
    }

    private void createCovers(int n){
    	int x=20;
    	int y=20;
    	cover = new Cover[n][n];
    	for(int i=0; i<n; i++){
    		for(int j=0; j<n; j++){
    			cover[i][j] = new Cover(x, y);
    			x=x+20;
    		}
    		x=20;
    		y=y+20;
    	}
    }

    private void setMines(int n){
    	Random generator = new Random();
    	int m = (int)(n*n*0.15);	//mine의 갯수는 전체의 15%
    	for(int k=0; k<m; k++){
    		int i = 1 + generator.nextInt(n);	//0<i<n
    		int j = 1 + generator.nextInt(n);	//0<j<n
    		if(box[i][j].isEmpty()){
    			box[i][j].setElement(9);
    			numMines++;
    			}
    		else
    			k--;	//again one more time
    	}
    }

    private void setElements(int n){
    	int mineCounter=0;
    	for(int i=1; i<n+1; i++){	//모든 Box에 대해서
    		for(int j=1; j<n+1; j++){
    			if(!box[i][j].isMine()){
    				for(int l=i-1; l<i+2; l++){			//그 Box를
    					for(int m=j-1; m<j+2; m++){		//둘러쌓고 있는 8개 Box를 순회해서
    						if(box[l][m].isMine())		//그 Box의 Number(mine의 갯수)를 구함
    							mineCounter++;
    					}
    				}
     			box[i][j].setElement(mineCounter);
    			mineCounter=0;
    			}
    		}
    	}
    }

    public void paintComponent(Graphics g){
    	Graphics2D g2 = (Graphics2D)g;

    	Rectangle background = new Rectangle(20, 20, n*20, n*20);
    	g2.setColor(Color.WHITE);
    	g2.fill(background);

    	g2.setColor(Color.BLACK);
    	for(int i=1; i<n+1; i++){		//setElement()메소드의 간소화를 위해서
    		for(int j=1; j<n+1; j++){	//첫 행,열과 마지막 행,열은 사용하지 않는다.
    			box[i][j].draw(g2);
    		}
    	}

    	for(int i=0; i<n; i++){
    		for(int j=0; j<n; j++){
    			cover[i][j].draw(g2);
    		}
    	}

		/* Cross Line */
		g2.setColor(Color.BLACK);
    	int x = 20;
    	int y = 20;
    	for(int i=0; i<n+1; i++){
    		g2.draw(new Line2D.Double(20,y, 320,y));
    		y=y+20;
    	}
    	for(int i=0; i<n+1; i++){
    		g2.draw(new Line2D.Double(x,20, x,320));
    		x=x+20;
    	}

    }

    public int getNumMines(){
    	return numMines;
    }

    public void changeMode(){
    	if(mode==0)
    		mode=1;
    	else
    		mode=0;
    }

    class CoverMouseListener implements MouseListener{
    	public void mousePressed(MouseEvent event){
    		int x = event.getX();
    		int y = event.getY();
    		if(20<=x && x<=320 && 20<=y && y<=320){	//component range
    			int i = (y-20)/20;	//calculate index
    			int j = (x-20)/20;

				if(mode==0){
    				openCover(i, j);
    				if(box[i+1][j+1].isMine()){
						cover[i][j].setCondition(3);
						JOptionPane.showMessageDialog(null,"Game Over!");
    				}
				}
    			else
    				checkCover(i, j);

    			repaint();
    		}
    	}

    	public void openCover(int i, int j){	//recursive
    		if(0<=i && i<=14 && 0<=j && j<=14){	//index range
    			if(!cover[i][j].isOpen() && !box[i+1][j+1].isMine()){
    				cover[i][j].setCondition(1);	//open
    				if(box[i+1][j+1].isEmpty()){
    					openCover(i-1, j);
    					openCover(i+1, j);
    					openCover(i, j-1);
    					openCover(i, j+1);
    				}
    		}
    		}
    	}

    	public void checkCover(int i, int j){
    		if(!cover[i][j].isOpen() && !cover[i][j].isChecking()){
				cover[i][j].setCondition(2);
    		}
    	}

    	public void mouseReleased(MouseEvent event){}
    	public void mouseClicked(MouseEvent event){}
    	public void mouseEntered(MouseEvent event){}
    	public void mouseExited(MouseEvent event){}
    }
}