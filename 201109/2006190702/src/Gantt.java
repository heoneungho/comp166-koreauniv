
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


import javax.swing.JPanel;

// 간트차트

class Gantt extends JPanel{
	private ArrayList grP;
	private int gTime;
	int w=0;
	
	Gantt(){
		grP=new ArrayList();
		
	}
	public void imgChange(int Id, int time){
		gTime=time;
		if(grP.size()<1){
			grP.add(new runP(Id, time));
		}else if(((runP)grP.get(grP.size()-1)).Id == Id){
			((runP)grP.get(grP.size()-1)).set_ed(time);
		}else {
			((runP)grP.get(grP.size()-1)).set_ed(time);
			grP.add(new runP(Id, time));
		}
		
		
		this.repaint();
	}
	public void grP_Reset(){
		grP.clear();
	}
	public void paint(Graphics g){
		try {
			if(grP.size()>0){
				w=((runP)grP.get(grP.size()-1)).ed_time*50+100;
			}
			if(w<700){
				w=700;
			}
		} catch (Exception e) { 
		}
		g.drawString("time"+String.valueOf(gTime), 10, 10);
		for(int i=0;i<grP.size();i++){
			g.drawRect(20+((runP)grP.get(i)).st_time*50, 20, (((runP)grP.get(i)).ed_time-((runP)grP.get(i)).st_time)*50, 35);
			g.drawString(String.valueOf(((runP)grP.get(i)).st_time), ((runP)grP.get(i)).st_time*50+20, 70);
			g.drawString(String.valueOf(((runP)grP.get(i)).ed_time), ((runP)grP.get(i)).ed_time*50+20, 70);
			g.drawString(((runP)grP.get(i)).getString(), ((((runP)grP.get(i)).st_time*50+20)+(((runP)grP.get(i)).ed_time*50+20))/2 - ((runP)grP.get(i)).getMinus(), 42);
		}
		this.setSize(new Dimension(w, 95));
	}
}

class runP{
	int Id;
	int st_time;
	int ed_time;
	int minus;
	
	runP(int Id, int st_time){
		this.Id = Id;
		this.st_time = st_time;
		this.ed_time = st_time;
	}
	
	public void set_ed(int ed_time){
		this.ed_time = ed_time;
	}
	public String getString(){
		if(Id == -1)
			return "대기중";
		else
			return String.valueOf(Id);
	}
	public int getMinus(){
		if(Id == -1)
			minus = 16;
		else
			minus = 2;
		return minus; 		
	}
	
}

