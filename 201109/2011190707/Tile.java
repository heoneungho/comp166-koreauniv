import javax.swing.*;

public class Tile extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private State state		= null;
	private int face		= 0;
	private int row			= 0;
	private int col			= 0;
	
	public Tile(int face, int row, int col, Icon icon) {
		super(icon);
		this.state = State.CLOSE;
		this.face = face;
		this.row = row;
		this.col = col;
	}
	public void setFace(int face) { this.face = face; }
	public int getFace() { return this.face; }
	public int getRow() { return this.row; }
	public int getCol() { return this.col; }
	public void setState(State STATE) { this.state = STATE; }
	public State getState() { return this.state; }
}
