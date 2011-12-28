import java.util.Random;

public class Process {

	int processNum;
	int arrivalTime;
	int burstTime;
	int priority;
	int remainTime;
	int waitingTime = 0;
	int turnaroundTime = 0;
	int terminateTime;

	public Process(int psNum) {
		Random rand = new Random();

		processNum = psNum;
		if (psNum == 0) {
			arrivalTime = 0;
			burstTime = 1;
		}
		else{
			arrivalTime = rand.nextInt(10);
			burstTime = rand.nextInt(20);
		}
		priority = rand.nextInt(5);

		while (burstTime == 0)
			burstTime = rand.nextInt(20);

		remainTime = burstTime;

	}
	
	public Process(int psNum, int arrival, int burst, int priority) {
		processNum = psNum;
		this.arrivalTime = arrival;
		this.burstTime = burst;
		this.priority = priority;
		remainTime = burstTime;

	}

	public Process(Process origin) {
		processNum = origin.processNum;
		arrivalTime = origin.arrivalTime;
		burstTime = origin.burstTime;
		priority = origin.priority;
		remainTime = origin.remainTime;
	}


	public int getRemainTime() {
		return remainTime;
	}


	public void setRemainTime(int remainTime) {
		this.remainTime = remainTime;
	}
	
	public void setTerminateTime(int terminateTime) {
		this.terminateTime = terminateTime;
		setTurnaroundTime();
		setWaitingTime();
	}
	
	public int getTerminateTime() {
		return terminateTime;
	}
	
	public void setTurnaroundTime() {
		turnaroundTime = terminateTime - arrivalTime;
	}
	
	public int getTurnaroundTime() {
		return turnaroundTime;
	}
	
	public void setWaitingTime() {
		waitingTime = turnaroundTime - burstTime;
	}
	
	public int getWaitingTime() {
		return waitingTime;
	}
	@Override
	public String toString() {
		String result = "P"+processNum+"	"+burstTime+"	"+arrivalTime+"	"+priority+ "\n";
		if(processNum == -1)	result = "	¥Î±‚¡ﬂ\n";
		 
		return result;
	}
}

