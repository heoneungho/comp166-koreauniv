import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.*;


public class Test extends JFrame {

	/**
	 * @param args
	 */
	float FCFT_W;
	float FCFT_T;
	float priority_nonpreemtive_W;
	float priority_nonpreemtive_T;
	float priority_preemtive_W;
	float priority_preemtive_T;
	float SJF_nonpreemtive_W;
	float SJF_nonpreemtive_T;
	float SJF_preemtive_W;
	float SJF_preemtive_T;
	float RoundRobin_W;
	float RoundRobin_T;
	
	
	Fcfs fcfs;
	Sjfnp sjfnp;
	Sjfp sjfp;
	Priorityp priorityp;
	Prioritynp prioritynp;
	Rr rr;
	Process ps;
	Vector<Process> psList;
	int num;
	int e = 0;
	Gantt Chart;
		
	public Test(){
		fcfs = new Fcfs();
		sjfnp = new Sjfnp();
		sjfp = new Sjfp();
		priorityp = new Priorityp();
		prioritynp = new Prioritynp();
		rr = new Rr();
		psList = new Vector<Process>();
		Chart = new Gantt();
		initComponents();
	}
	
	private void initComponents() {
	 	 panel1 = new javax.swing.JPanel();
	 	 panel2 = new javax.swing.JPanel();
		 m_process_generate_button = new javax.swing.JButton();
		 m_SJSF_button = new javax.swing.JButton();
		 m_SJF_preemtive_button = new javax.swing.JButton();
		 m_SJF_nonPreemtive_button = new javax.swing.JButton();
		 m_priority_preemtive_button = new javax.swing.JButton();
		 m_priority_nonpreemtive_button = new javax.swing.JButton();
		 m_reset_button = new javax.swing.JButton();
		 m_process_look_button = new javax.swing.JButton();
		 m_RoundRobin_button = new javax.swing.JButton();
		 m_process_add_button = new javax.swing.JButton();
		 m_process_add_confirm_button = new javax.swing.JButton();
		 m_RoundRobin_quantum_button = new javax.swing.JButton();
		 //m_Result_button=new javax.swing.JButton();
		 //Sup
		 m_set_process_number_commit_button=new javax.swing.JButton();
		 //panel2 = new javax.swing.JPanel();
		 m_headTextArea = new javax.swing.JTextArea();
		 m_mainTextArea = new javax.swing.JTextArea();
		 scrollpane1 = new javax.swing.JScrollPane();
		 m_arriveTime_set_TextArea = new javax.swing.JTextField();
		 m_burstTime_set_TextArea = new javax.swing.JTextField();
		 m_priority_set_TextArea = new javax.swing.JTextField();
		 m_RoundRobin_quantun_set_TextArea = new javax.swing.JTextField();
		 //Sup
		 m_set_process_number_TextArea = new javax.swing.JTextField();
		 insertPS = new javax.swing.JFrame("프로세스 내용 입력창");
		 setQuantum = new javax.swing.JFrame("time quantum 입력창");
		 //Sup
		 m_set_process_number_View= new javax.swing.JFrame("프로세스 생성 갯수");
		  
		 insertPS.setVisible(false);
		 insertPS.setLayout(new java.awt.GridLayout(4,2));
		 insertPS.setSize(400, 150);
		 insertPS.add(new JLabel("		arrivalTime :"));
		 insertPS.add(m_arriveTime_set_TextArea);
		 insertPS.add(new JLabel("		burstTime :"));
		 insertPS.add(m_burstTime_set_TextArea);
		 insertPS.add(new JLabel("		priority :"));
		 insertPS.add(m_priority_set_TextArea);
		 insertPS.add(m_process_add_confirm_button);
		 
		 setQuantum.setVisible(false);
		 setQuantum.setLayout(new java.awt.BorderLayout());
		 setQuantum.setSize(300, 90);
		 setQuantum.add(new JLabel(" quantum :"),java.awt.BorderLayout.WEST);
		 setQuantum.add(m_RoundRobin_quantun_set_TextArea,java.awt.BorderLayout.CENTER);
		 setQuantum.add(m_RoundRobin_quantum_button,java.awt.BorderLayout.EAST);
		 
		 m_set_process_number_View.setVisible(false);
		 m_set_process_number_View.setLayout(new java.awt.BorderLayout());
		 m_set_process_number_View.setSize(300, 90);
		 m_set_process_number_View.add(new JLabel(" 프로세스 갯수 :"),java.awt.BorderLayout.WEST);
		 m_set_process_number_View.add(m_set_process_number_TextArea,java.awt.BorderLayout.CENTER);
		 m_set_process_number_View.add(m_set_process_number_commit_button,java.awt.BorderLayout.EAST);
		 
		 
		 
		 m_process_add_confirm_button.setText("프로세스 추가");
		 m_process_add_confirm_button.addActionListener(new java.awt.event.ActionListener() {
			 public void actionPerformed(java.awt.event.ActionEvent evt) {
				 jButton11ActionPerformed(evt);
			 }
		 });
		 
		 m_RoundRobin_quantum_button.setText("확인");
		 m_RoundRobin_quantum_button.addActionListener(new java.awt.event.ActionListener() {
			 public void actionPerformed(java.awt.event.ActionEvent evt) {
				 jButton12ActionPerformed(evt);
			 }
		 });
		 m_set_process_number_commit_button.setText("확인");
		 m_set_process_number_commit_button.addActionListener(new java.awt.event.ActionListener(){

			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SubSub(evt);
			}
			 
		 });
				 
		 setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		 setTitle("2006190702 장용현");
		 setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		 panel1.setLayout(new java.awt.GridLayout(0, 1));

		 m_process_generate_button.setText("프로세스 생성");
		 m_process_generate_button.addActionListener(new java.awt.event.ActionListener() {
			 public void actionPerformed(java.awt.event.ActionEvent evt) {
				 if(e == 0)
					 jButton1ActionPerformed(evt);
			 }
		 });
		 
		 panel1.add(m_process_generate_button);
		 
		 m_process_add_button.setText("프로세스 추가");
		 m_process_add_button.addActionListener(new java.awt.event.ActionListener() {
			 public void actionPerformed(java.awt.event.ActionEvent evt) {
				 if(e == 0)
				 jButton10ActionPerformed(evt);
			 }
		 });

		 panel1.add(m_process_add_button);

		 m_SJSF_button.setText("FCFS");
		 m_SJSF_button.addActionListener(new java.awt.event.ActionListener() {
			 public void actionPerformed(java.awt.event.ActionEvent evt) {
				 if(e == 0)
				 m_FCFS_button_Performed(evt);
			 }
		 });

		 panel1.add(m_SJSF_button);

		 m_SJF_preemtive_button.setText("SJF(preemptive)");
		 m_SJF_preemtive_button.addActionListener(new java.awt.event.ActionListener() {
			 public void actionPerformed(java.awt.event.ActionEvent evt) {
				 if(e == 0)
				 m_SJF_preemtive_button_performed(evt);
			 }
		 });

		 panel1.add(m_SJF_preemtive_button);

		 m_SJF_nonPreemtive_button.setText("SJF(nonpreemptive)");
		 m_SJF_nonPreemtive_button.addActionListener(new java.awt.event.ActionListener() {
			 public void actionPerformed(java.awt.event.ActionEvent evt) {
				 if(e == 0)
				 m_SJF_nonpreemtive_button_performed(evt);
			 }
		 });

		 panel1.add(m_SJF_nonPreemtive_button);

		 m_priority_preemtive_button.setText("PRIORITY(preemptive)");
		 m_priority_preemtive_button.addActionListener(new java.awt.event.ActionListener() {
			 public void actionPerformed(java.awt.event.ActionEvent evt) {
				 if(e == 0)
				 m_priority_preemtive_button_performed(evt);
			 }
		 });

		 panel1.add(m_priority_preemtive_button);

		 m_priority_nonpreemtive_button.setText("PRIORITY(nonpreemptive)");
		 m_priority_nonpreemtive_button.addActionListener(new java.awt.event.ActionListener() {
			 public void actionPerformed(java.awt.event.ActionEvent evt) {
				 if(e == 0)
				 m_priority_nonpreemtive_button_performed(evt);
			 }
		 });
		 panel1.add(m_priority_nonpreemtive_button);

		 m_RoundRobin_button.setText("Round robin");
		 m_RoundRobin_button.addActionListener(new java.awt.event.ActionListener() {
			 public void actionPerformed(java.awt.event.ActionEvent evt) {
				 if(e == 0)
				 m_RoundRobin_button_performed(evt);
			 }
		 });
		 
		 panel1.add(m_RoundRobin_button);

		m_process_look_button.setText("프로세스보기");
				 m_process_look_button.addActionListener(new java.awt.event.ActionListener() {
					 public void actionPerformed(java.awt.event.ActionEvent evt) {
						 if(e == 0)
						 m_process_look_button_performed(evt);
					 }
				 });

		 panel1.add(m_process_look_button);

		m_reset_button.setText("Reset");
				 m_reset_button.addActionListener(new java.awt.event.ActionListener() {
					 public void actionPerformed(java.awt.event.ActionEvent evt) {
						 if(e == 0)
						 m_process_reset_button_performed(evt);
					 }
				 });
				 
		ganttInner = new JScrollPane(Chart);
		bGantt = new javax.swing.JPanel();
		bGantt.setLayout(new BoxLayout(bGantt, BoxLayout.Y_AXIS));
		bGantt.setPreferredSize(new Dimension(500, 95));
		bGantt.add(ganttInner);

		 panel1.add(m_reset_button);
		 
		 /*m_Result_button.setText("결과보기");
		 m_Result_button.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// TODO Auto-generated method stub
				if(e == 0){
				m_result_button_performed(evt);	
				}
			}
			 
		 });
		 
		 panel1.add(m_Result_button);
		 */
		 scrollpane1.setViewportView(m_mainTextArea);
		 
		 getContentPane().add(panel1, java.awt.BorderLayout.WEST);

		 panel2.setLayout(new java.awt.BorderLayout());

		 panel2.add(m_headTextArea, java.awt.BorderLayout.NORTH);
		 
		 panel2.add(scrollpane1, java.awt.BorderLayout.CENTER);
		 
		 panel2.add(bGantt, java.awt.BorderLayout.SOUTH);
		 
		 getContentPane().add(panel2, java.awt.BorderLayout.CENTER);

		 setSize(1250, 700);
	
	 }
	
	
	
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// 프로세스 생성
		m_set_process_number_TextArea.setText("5");
		m_set_process_number_View.setVisible(true);		
		
	}
	
	private void SubSub(java.awt.event.ActionEvent evt) {	//RR

		m_set_process_number_View.setVisible(false);
		int RandomNum;
		RandomNum=Integer.parseInt(m_set_process_number_TextArea.getText());
	//	num=m_set_process_number_TextArea.v;
		m_headTextArea.setText(num+"개의 프로세스가 생성되었습니다.");
		m_mainTextArea.setText("");
		//psList.clear();
		for(int i = num; i < RandomNum+num ; i++){
			ps = new Process(i);
			psList.add(ps);
		}
		num=RandomNum+num;
		m_headTextArea.setText("프로세스 " + (RandomNum) +"개가 생성되었습니다");

		m_mainTextArea.setText("");
		int size = psList.size();
		m_mainTextArea.append("ProcessNumber   BurstTime   ArrivalTime        Priority\n");
		for(int i = 0; i < size; i++){
			Process tmp = (Process)psList.elementAt(i);
			m_mainTextArea.append("          P"+tmp.processNum+"	            "+tmp.burstTime+"	     "+tmp.arrivalTime+
			"	"+tmp.priority+"\n");
		}


	}
	
	
	private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {// 프로세스 추가
		m_arriveTime_set_TextArea.setText("");
		m_burstTime_set_TextArea.setText("");
		m_priority_set_TextArea.setText("");
		insertPS.setVisible(true);
	}
	
	private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {// 프로세스 추가
		Process ps = new Process(num, Integer.parseInt(m_arriveTime_set_TextArea.getText()), Integer.parseInt(m_burstTime_set_TextArea.getText()), Integer.parseInt(m_priority_set_TextArea.getText()));
		num++;
		psList.add(ps);
		insertPS.setVisible(false);
		
		m_headTextArea.setText("프로세스 p"+(num - 1) +"이 추가로 생성되었습니다");
		m_mainTextArea.setText("");
		int size = psList.size();
		m_mainTextArea.append("ProcessNumber   BurstTime   ArrivalTime        Priority\n");
		for(int i = 0; i < size; i++){
			Process tmp = (Process)psList.elementAt(i);
			m_mainTextArea.append("          P"+tmp.processNum+"	            "+tmp.burstTime+"	     "+tmp.arrivalTime+
			"	"+tmp.priority+"\n");
		}

		
	}
	/*
	private void m_result_button_performed(java.awt.event.ActionEvent evt){
		Result a=new Result();
	
		m_headTextArea.setText("결과");
		m_mainTextArea.setText("");
		m_mainTextArea.append("FCFS WaitingTime :  "+FCFT_W+"\n");
		m_mainTextArea.append("FCFS TurnaoundTime :  "+FCFT_T+"\n");
		m_mainTextArea.append("Priority Preemtive WaitingTime :  "+priority_preemtive_W+"\n");
		m_mainTextArea.append("Priority Preemtive TurnaoundTime :  "+priority_preemtive_T+"\n");
		m_mainTextArea.append("Priority NonPreemtive WaitingTime :  "+priority_nonpreemtive_W+"\n");
		m_mainTextArea.append("Priority NonPreemtive TurnaoundTime :  "+priority_nonpreemtive_T+"\n");
		m_mainTextArea.append("SJF Preemtive WaitingTime :  "+SJF_preemtive_W+"\n");
		m_mainTextArea.append("SJF Preemtive TurnaoundTime :  "+SJF_preemtive_T+"\n");
		m_mainTextArea.append("SJF NonPreemtive WaitingTime :  "+SJF_nonpreemtive_W+"\n");
		m_mainTextArea.append("SJF NonPreemtive TurnaoundTime :  "+SJF_nonpreemtive_T+"\n");
		m_mainTextArea.append("RoundRobin WaitingTime :  "+RoundRobin_W+"\n");
		m_mainTextArea.append("RoundRobin TurnaoundTime :  "+RoundRobin_T+"\n");

	}
	*/
	private void m_SJF_preemtive_button_performed(java.awt.event.ActionEvent evt) {	//SJF(preemptive)
		m_headTextArea.setText("SJF(preemptive) 프로세스 스케쥴링");
		m_mainTextArea.setText("");
		
		sjfp.reset();
		sjfp.setSchedule(psList);
		e = 1;
		if(psList.size() == 0)
			e = 0;
		sjfp.setTextArea(m_mainTextArea);
		sjfp.setupFrame(this);
		new Thread(sjfp).start();
		SJF_preemtive_W=sjfp.resultWaiting();
		SJF_preemtive_T=sjfp.resultTurnaround();
	}
	
	private void m_FCFS_button_Performed(java.awt.event.ActionEvent evt){	//FCFS
		m_headTextArea.setText("FCFS 프로세스 스케쥴링");
		m_mainTextArea.setText("");
		
		fcfs.reset();
		fcfs.setSchedule(psList);
		e = 1;
		if(psList.size() == 0)
			e = 0;
		fcfs.setTextArea(m_mainTextArea);
		fcfs.setupFrame(this);
		new Thread(fcfs).start();
		FCFT_W=fcfs.resultWaiting();
		FCFT_T=fcfs.resultTurnaround();
	 }

	 private void m_SJF_nonpreemtive_button_performed(java.awt.event.ActionEvent evt) {	//SJF(nonpremptive)
		m_headTextArea.setText("SJF(nonpremptive) 프로세스 스케쥴링");
		m_mainTextArea.setText("");

		sjfnp.reset();
		sjfnp.setSchedule(psList);
		e = 1;
		if(psList.size() == 0)
			e = 0;
		sjfnp.setTextArea(m_mainTextArea);
		sjfnp.setupFrame(this);
		new Thread(sjfnp).start();
		SJF_nonpreemtive_W=sjfnp.resultWaiting();
		SJF_nonpreemtive_T=sjfnp.resultTurnaround();

	}
	 
	private void m_priority_preemtive_button_performed(java.awt.event.ActionEvent evt) {	//Priority(premptive)
		m_headTextArea.setText("Priority(premptive) 프로세스 스케쥴링");
		m_mainTextArea.setText("");

		priorityp.reset();
		priorityp.setSchedule(psList);
		e = 1;
		if(psList.size() == 0)
			e = 0;
		priorityp.setTextArea(m_mainTextArea);
		priorityp.setupFrame(this);
		new Thread(priorityp).start();
		priority_preemtive_W=priorityp.resultWaiting();
		priority_preemtive_T=priorityp.resultTurnaround();

	}

	private void m_priority_nonpreemtive_button_performed(java.awt.event.ActionEvent evt) {	//Priority(nonpremptive)
		m_headTextArea.setText("Priority(nonpremptive) 프로세스 스케쥴링");
		m_mainTextArea.setText("");

		prioritynp.reset();
		prioritynp.setSchedule(psList);
		e = 1;
		if(psList.size() == 0)
			e = 0;
		prioritynp.setTextArea(m_mainTextArea);
		prioritynp.setupFrame(this);
		new Thread(prioritynp).start();
		priority_nonpreemtive_W=prioritynp.resultWaiting();
		priority_nonpreemtive_T=prioritynp.resultTurnaround();

	}
	
	private void m_RoundRobin_button_performed(java.awt.event.ActionEvent evt) {//quantum 창 부르기
		m_RoundRobin_quantun_set_TextArea.setText("3");
		setQuantum.setVisible(true);
		
	}
	
	private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {	//RR
		setQuantum.setVisible(false);
		m_headTextArea.setText("Round Robin 프로세스 스케쥴링");
		m_mainTextArea.setText("");

		rr.reset();
		rr.setQuentum(Integer.parseInt(m_RoundRobin_quantun_set_TextArea.getText()));
		rr.setSchedule(psList);
		e = 1;
		if(psList.size() == 0)
			e = 0;
		rr.setTextArea(m_mainTextArea);
		rr.setupFrame(this);
		new Thread(rr).start();
		RoundRobin_W=rr.resultWaiting();
		RoundRobin_T=rr.resultTurnaround();

	}
	

	
	private void m_process_look_button_performed(java.awt.event.ActionEvent evt) {// 프로세스 보기
		m_headTextArea.setText("생성된 프로세스 리스트");
		m_mainTextArea.setText("");

		int size = psList.size();
		m_mainTextArea.append("ProcessNumber   BurstTime   ArrivalTime        Priority\n");
		for(int i = 0; i < size; i++){
			Process tmp = (Process)psList.elementAt(i);
			m_mainTextArea.append("          P"+tmp.processNum+"	            "+tmp.burstTime+"	     "+tmp.arrivalTime+
			"	"+tmp.priority+"\n");
		}
	}
	
	private void m_process_reset_button_performed(java.awt.event.ActionEvent evt) {//reset
		m_headTextArea.setText("초기화 되었습니다");
		m_mainTextArea.setText("");
		
		fcfs.reset();
		priorityp.reset();
		prioritynp.reset();
		sjfp.reset();
		sjfnp.reset();	
		rr.reset();
		num = 0;
		psList.removeAllElements();			
	 }
	public void Gantt_Reset(){
		Chart.grP_Reset();
	}
	public void Gantt_add(int Id, int time){
		Chart.imgChange(Id, time);
	}
	public void Gantt_setSize(){
		Chart.setPreferredSize(new Dimension(Chart.w, 85));
	}
	public void set_e(int e){
		this.e = e;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.awt.EventQueue.invokeLater(new Runnable() {
			 public void run() {
				 new Test().setVisible(true);
			 }
		 });
	}
	
	 private javax.swing.JButton m_process_generate_button;
	 private javax.swing.JButton m_SJSF_button;
	 private javax.swing.JButton m_SJF_preemtive_button;
	 private javax.swing.JButton m_SJF_nonPreemtive_button;
	 private javax.swing.JButton m_priority_preemtive_button;
	 private javax.swing.JButton m_priority_nonpreemtive_button;
	 private javax.swing.JButton m_reset_button;
	 private javax.swing.JButton m_process_look_button;
	 private javax.swing.JButton m_RoundRobin_button;
	 private javax.swing.JButton m_process_add_button;
	 private javax.swing.JButton m_process_add_confirm_button;
	 private javax.swing.JButton m_RoundRobin_quantum_button;
	 private javax.swing.JButton m_set_process_number_commit_button;
	 //private javax.swing.JButton m_Result_button;
	 private javax.swing.JTextArea m_mainTextArea;
	 private javax.swing.JTextArea m_headTextArea;
	 private javax.swing.JPanel panel1;
	 private javax.swing.JPanel panel2;
	 private javax.swing.JScrollPane scrollpane1;
	 private javax.swing.JScrollPane ganttInner;
	 private javax.swing.JTextField m_arriveTime_set_TextArea;
	 private javax.swing.JTextField m_burstTime_set_TextArea;
	 private javax.swing.JTextField m_priority_set_TextArea;
	 private javax.swing.JTextField m_RoundRobin_quantun_set_TextArea;
	 private JTextField m_set_process_number_TextArea;
	 private javax.swing.JFrame insertPS;
	 private javax.swing.JFrame setQuantum;
	 private javax.swing.JFrame m_set_process_number_View;
	 private javax.swing.JPanel bGantt;

}

