import java.util.*;

import javax.swing.JTextArea;


public abstract class Scheduling {
	
	protected Vector<Process> scheduledPsList;
	protected Vector<Process> forcalculate;
	protected JTextArea textArea;
	protected Test frame;
		
	public Scheduling(){
		scheduledPsList = new Vector<Process>();
	}
	
	abstract void setSchedule(Vector<Process> psList);

	abstract void reset();
	
	abstract float avgWaiting();
	
	abstract float avgTurnaround();
		
	public Vector<Process> getSchedule(){
		return scheduledPsList;
	}
}
