import java.util.Vector;

import javax.swing.JTextArea;

public class Sjfnp extends Scheduling implements Runnable {
	
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	void setSchedule(Vector<Process> psList) {
		//		���ľȵ� ���μ��� ����Ʈ -> arrivalTime - burstTime�� ���������� ����
		Process ps;
		Vector<Process> v = new Vector<Process>();
		Vector<Process> readyQueue = new Vector<Process>();
		int j = psList.size();
		int sumBurstTime = 0;

		for (int i = 0; i < j; i++) {
			ps = new Process(psList.elementAt(i));
			sumBurstTime = sumBurstTime + ps.burstTime;

			int length = v.size();

			if (length == 0) {
				v.add(ps);
			} else {
				for (int k = 0; k < length; k++) {
					Process tmp = (Process) v.elementAt(k);

					if (tmp.arrivalTime > ps.arrivalTime) { //�����ð��� ��������

						v.insertElementAt(ps, k);
						break;
					} else if (tmp.arrivalTime == ps.arrivalTime) { //������ burstTime ������
						if (tmp.burstTime > ps.burstTime) {

							v.insertElementAt(ps, k);
							break;
						}
					}
					if (k == length - 1) {
						v.add(ps);
					}
				}
			}
		}
		
		forcalculate = (Vector<Process>)v.clone();
		
		//SJF(nonpreemptive) Logic 
		for (int now = 0; now < sumBurstTime; now++) {
			
			for (int i = 0; i < v.size(); i++) {
				ps = v.elementAt(i);
				if (ps.arrivalTime <= now) {
					readyQueue.add(ps);
					v.removeElement(ps);
					i--;
				}
			}

			if (readyQueue.size() == 0) {
				scheduledPsList.add(new Process(-1));//�������� �ϰ͵� �ȵ��ö� 
				sumBurstTime ++;//�� ��쿡 ����ƮŸ���� �ƴѵ� ���� �ð��� �����Ƿ�
				continue;
			} else {
				Process temp = new Process(-1);
				for (int i = 0; i < readyQueue.size(); i++) {
					ps = readyQueue.elementAt(i);
					if (i == 0) {
						temp = ps;
					} else if (temp.remainTime > ps.remainTime) {
						temp = ps;
					}
				}
				while(temp.getRemainTime() != 0){
					scheduledPsList.add(temp);
					temp.setRemainTime(temp.getRemainTime()-1);
					if(temp.getRemainTime() != 0)
						now++;
				}
				if (temp.remainTime == 0){
					readyQueue.removeElement(temp);
					temp.setTerminateTime(now + 1);
				}
			}
		}
	}

	void reset() {
		scheduledPsList.removeAllElements();
	}

	float avgWaiting() {
		int sumWaitingTime = 0;
		for(int i = 0; i < forcalculate.size(); i++){
			Process ps = forcalculate.elementAt(i);
			sumWaitingTime = sumWaitingTime + ps.getWaitingTime();
		}
		

		return (float) sumWaitingTime / forcalculate.size();
	}
	
	float avgTurnaround() {
		int sumTurnaroundTime = 0;
		for(int i = 0; i < forcalculate.size(); i++){
			Process ps = forcalculate.elementAt(i);
			sumTurnaroundTime = sumTurnaroundTime + ps.getTurnaroundTime();
		}
		

		return (float) sumTurnaroundTime / forcalculate.size();
	}

	public void setupFrame(Test test){
		this.frame = test;
	}

	public void run() {
		frame.Gantt_Reset();
		textArea.append("�������         ProcessNumber   BurstTime   ArrivalTime          Priority\n");
		for (int i = 0; i <  scheduledPsList.size() + 1; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i == scheduledPsList.size()){
				Process temp = (Process) scheduledPsList.elementAt(i - 1);
				System.out.println(i);
				frame.Gantt_setSize();
				frame.Gantt_add(temp.processNum, i);
				textArea.append("\n\n Average Waiting Time = " + this.avgWaiting());
				textArea.append("\n\n Average Turnaound Time = " + this.avgTurnaround());
				frame.set_e(0);
			}
			else{
				Process temp = (Process) scheduledPsList.elementAt(i);
				System.out.println(i);
				frame.Gantt_setSize();
				frame.Gantt_add(temp.processNum, i);
				textArea.append("����ð�"+i+"::	"+temp.toString());
			}
		}
	}
	public float resultWaiting(){
		return this.avgWaiting();
	}
	public float resultTurnaround(){
		return this.avgTurnaround();
	}

}

