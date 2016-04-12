CPU 스케쥴러.

# Introduction #

CPU스케줄러를 만들어보고 싶습니다 OS텀으로 만들때 java로 구현하다가 실패해서 C로 했었습니다 다시 도전해보고 싶습니다 불가하다면 숫자맞추는 야구게임을 만들겠습니다

# Details #
각각의 알고리즘을 비쥬얼하게 보여주는 프로그램

# Using code #

import javax.swing.**;**

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.**;**


public class Test extends JFrame {

> /
    * @param args
    * 
> float FCFT\_W;
> float FCFT\_T;
> float priority\_nonpreemtive\_W;
> float priority\_nonpreemtive\_T;
> float priority\_preemtive\_W;
> float priority\_preemtive\_T;
> float SJF\_nonpreemtive\_W;
> float SJF\_nonpreemtive\_T;
> float SJF\_preemtive\_W;
> float SJF\_preemtive\_T;
> float RoundRobin\_W;
> float RoundRobin\_T;


> Fcfs fcfs;
> Sjfnp sjfnp;
> Sjfp sjfp;
> Priorityp priorityp;
> Prioritynp prioritynp;
> Rr rr;
> Process ps;
> Vector

&lt;Process&gt;

 psList;
> int num;
> int e = 0;
> Gantt Chart;

> public Test(){
> > fcfs = new Fcfs();
> > sjfnp = new Sjfnp();
> > sjfp = new Sjfp();
> > priorityp = new Priorityp();
> > prioritynp = new Prioritynp();
> > rr = new Rr();
> > psList = new Vector

&lt;Process&gt;

();
> > Chart = new Gantt();
> > initComponents();

> }

> private void initComponents() {
> > panel1 = new javax.swing.JPanel();
> > panel2 = new javax.swing.JPanel();
> > m\_process\_generate\_button = new javax.swing.JButton();
> > m\_SJSF\_button = new javax.swing.JButton();
> > m\_SJF\_preemtive\_button = new javax.swing.JButton();
> > m\_SJF\_nonPreemtive\_button = new javax.swing.JButton();
> > m\_priority\_preemtive\_button = new javax.swing.JButton();
> > m\_priority\_nonpreemtive\_button = new javax.swing.JButton();
> > m\_reset\_button = new javax.swing.JButton();
> > m\_process\_look\_button = new javax.swing.JButton();
> > m\_RoundRobin\_button = new javax.swing.JButton();
> > m\_process\_add\_button = new javax.swing.JButton();
> > m\_process\_add\_confirm\_button = new javax.swing.JButton();
> > m\_RoundRobin\_quantum\_button = new javax.swing.JButton();
> > //m\_Result\_button=new javax.swing.JButton();
> > //Sup
> > m\_set\_process\_number\_commit\_button=new javax.swing.JButton();
> > //panel2 = new javax.swing.JPanel();
> > m\_headTextArea = new javax.swing.JTextArea();
> > m\_mainTextArea = new javax.swing.JTextArea();
> > scrollpane1 = new javax.swing.JScrollPane();
> > m\_arriveTime\_set\_TextArea = new javax.swing.JTextField();
> > m\_burstTime\_set\_TextArea = new javax.swing.JTextField();
> > m\_priority\_set\_TextArea = new javax.swing.JTextField();
> > m\_RoundRobin\_quantun\_set\_TextArea = new javax.swing.JTextField();
> > //Sup
> > m\_set\_process\_number\_TextArea = new javax.swing.JTextField();
> > insertPS = new javax.swing.JFrame("프로세스 내용 입력창");
> > setQuantum = new javax.swing.JFrame("time quantum 입력창");
> > //Sup
> > m\_set\_process\_number\_View= new javax.swing.JFrame("프로세스 생성 갯수");


> insertPS.setVisible(false);
> insertPS.setLayout(new java.awt.GridLayout(4,2));
> insertPS.setSize(400, 150);
> insertPS.add(new JLabel("		arrivalTime :"));
> insertPS.add(m\_arriveTime\_set\_TextArea);
> insertPS.add(new JLabel("		burstTime :"));
> insertPS.add(m\_burstTime\_set\_TextArea);
> insertPS.add(new JLabel("		priority :"));
> insertPS.add(m\_priority\_set\_TextArea);
> insertPS.add(m\_process\_add\_confirm\_button);

> setQuantum.setVisible(false);
> setQuantum.setLayout(new java.awt.BorderLayout());
> setQuantum.setSize(300, 90);
> setQuantum.add(new JLabel(" quantum :"),java.awt.BorderLayout.WEST);
> setQuantum.add(m\_RoundRobin\_quantun\_set\_TextArea,java.awt.BorderLayout.CENTER);
> setQuantum.add(m\_RoundRobin\_quantum\_button,java.awt.BorderLayout.EAST);

> m\_set\_process\_number\_View.setVisible(false);
> m\_set\_process\_number\_View.setLayout(new java.awt.BorderLayout());
> m\_set\_process\_number\_View.setSize(300, 90);
> m\_set\_process\_number\_View.add(new JLabel(" 프로세스 갯수 :"),java.awt.BorderLayout.WEST);
> m\_set\_process\_number\_View.add(m\_set\_process\_number\_TextArea,java.awt.BorderLayout.CENTER);
> m\_set\_process\_number\_View.add(m\_set\_process\_number\_commit\_button,java.awt.BorderLayout.EAST);



> m\_process\_add\_confirm\_button.setText("프로세스 추가");
> m\_process\_add\_confirm\_button.addActionListener(new java.awt.event.ActionListener() {
> > public void actionPerformed(java.awt.event.ActionEvent evt) {
> > > jButton11ActionPerformed(evt);

> > }

> });

> m\_RoundRobin\_quantum\_button.setText("확인");
> m\_RoundRobin\_quantum\_button.addActionListener(new java.awt.event.ActionListener() {
> > public void actionPerformed(java.awt.event.ActionEvent evt) {
> > > jButton12ActionPerformed(evt);

> > }

> });
> m\_set\_process\_number\_commit\_button.setText("확인");
> m\_set\_process\_number\_commit\_button.addActionListener(new java.awt.event.ActionListener(){

> public void actionPerformed(java.awt.event.ActionEvent evt) {
> > SubSub(evt);

> }

> });

> setDefaultCloseOperation(javax.swing.WindowConstants.EXIT\_ON\_CLOSE);
> setTitle("2006190702 장용현");
> setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT\_CURSOR));
> panel1.setLayout(new java.awt.GridLayout(0, 1));

> m\_process\_generate\_button.setText("프로세스 생성");
> m\_process\_generate\_button.addActionListener(new java.awt.event.ActionListener() {
> > public void actionPerformed(java.awt.event.ActionEvent evt) {
> > > if(e == 0)
> > > > jButton1ActionPerformed(evt);

> > }

> });

> panel1.add(m\_process\_generate\_button);

> m\_process\_add\_button.setText("프로세스 추가");
> m\_process\_add\_button.addActionListener(new java.awt.event.ActionListener() {
> > public void actionPerformed(java.awt.event.ActionEvent evt) {
> > > if(e == 0)
> > > jButton10ActionPerformed(evt);

> > }

> });

> panel1.add(m\_process\_add\_button);

> m\_SJSF\_button.setText("FCFS");
> m\_SJSF\_button.addActionListener(new java.awt.event.ActionListener() {
> > public void actionPerformed(java.awt.event.ActionEvent evt) {
> > > if(e == 0)
> > > m\_FCFS\_button\_Performed(evt);

> > }

> });

> panel1.add(m\_SJSF\_button);

> m\_SJF\_preemtive\_button.setText("SJF(preemptive)");
> m\_SJF\_preemtive\_button.addActionListener(new java.awt.event.ActionListener() {
> > public void actionPerformed(java.awt.event.ActionEvent evt) {
> > > if(e == 0)
> > > m\_SJF\_preemtive\_button\_performed(evt);

> > }

> });

> panel1.add(m\_SJF\_preemtive\_button);

> m\_SJF\_nonPreemtive\_button.setText("SJF(nonpreemptive)");
> m\_SJF\_nonPreemtive\_button.addActionListener(new java.awt.event.ActionListener() {
> > public void actionPerformed(java.awt.event.ActionEvent evt) {
> > > if(e == 0)
> > > m\_SJF\_nonpreemtive\_button\_performed(evt);

> > }

> });

> panel1.add(m\_SJF\_nonPreemtive\_button);

> m\_priority\_preemtive\_button.setText("PRIORITY(preemptive)");
> m\_priority\_preemtive\_button.addActionListener(new java.awt.event.ActionListener() {
> > public void actionPerformed(java.awt.event.ActionEvent evt) {
> > > if(e == 0)
> > > m\_priority\_preemtive\_button\_performed(evt);

> > }

> });

> panel1.add(m\_priority\_preemtive\_button);

> m\_priority\_nonpreemtive\_button.setText("PRIORITY(nonpreemptive)");
> m\_priority\_nonpreemtive\_button.addActionListener(new java.awt.event.ActionListener() {
> > public void actionPerformed(java.awt.event.ActionEvent evt) {
> > > if(e == 0)
> > > m\_priority\_nonpreemtive\_button\_performed(evt);

> > }

> });
> panel1.add(m\_priority\_nonpreemtive\_button);

> m\_RoundRobin\_button.setText("Round robin");
> m\_RoundRobin\_button.addActionListener(new java.awt.event.ActionListener() {
> > public void actionPerformed(java.awt.event.ActionEvent evt) {
> > > if(e == 0)
> > > m\_RoundRobin\_button\_performed(evt);

> > }

> });

> panel1.add(m\_RoundRobin\_button);

> m\_process\_look\_button.setText("프로세스보기");
> > m\_process\_look\_button.addActionListener(new java.awt.event.ActionListener() {
> > > public void actionPerformed(java.awt.event.ActionEvent evt) {
> > > > if(e == 0)
> > > > m\_process\_look\_button\_performed(evt);

> > > }

> > });


> panel1.add(m\_process\_look\_button);

> m\_reset\_button.setText("Reset");
> > m\_reset\_button.addActionListener(new java.awt.event.ActionListener() {
> > > public void actionPerformed(java.awt.event.ActionEvent evt) {
> > > > if(e == 0)
> > > > m\_process\_reset\_button\_performed(evt);

> > > }

> > });


> ganttInner = new JScrollPane(Chart);
> bGantt = new javax.swing.JPanel();
> bGantt.setLayout(new BoxLayout(bGantt, BoxLayout.Y\_AXIS));
> bGantt.setPreferredSize(new Dimension(500, 95));
> bGantt.add(ganttInner);

> panel1.add(m\_reset\_button);

> /**m\_Result\_button.setText("결과보기");
> m\_Result\_button.addActionListener(new java.awt.event.ActionListener(){**

> @Override
> public void actionPerformed(java.awt.event.ActionEvent evt) {
> > // TODO Auto-generated method stub
> > if(e == 0){
> > m\_result\_button\_performed(evt);
> > }

> }

> });

> panel1.add(m\_Result\_button);
  * 
> scrollpane1.setViewportView(m\_mainTextArea);

> getContentPane().add(panel1, java.awt.BorderLayout.WEST);

> panel2.setLayout(new java.awt.BorderLayout());

> panel2.add(m\_headTextArea, java.awt.BorderLayout.NORTH);

> panel2.add(scrollpane1, java.awt.BorderLayout.CENTER);

> panel2.add(bGantt, java.awt.BorderLayout.SOUTH);

> getContentPane().add(panel2, java.awt.BorderLayout.CENTER);

> setSize(1250, 700);

> }



> private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// 프로세스 생성
> > m\_set\_process\_number\_TextArea.setText("5");
> > m\_set\_process\_number\_View.setVisible(true);


> }

> private void SubSub(java.awt.event.ActionEvent evt) {	//RR

> m\_set\_process\_number\_View.setVisible(false);
> int RandomNum;
> RandomNum=Integer.parseInt(m\_set\_process\_number\_TextArea.getText());
> //	num=m\_set\_process\_number\_TextArea.v;
> > m\_headTextArea.setText(num+"개의 프로세스가 생성되었습니다.");
> > m\_mainTextArea.setText("");
> > //psList.clear();
> > for(int i = num; i < RandomNum+num ; i++){
> > > ps = new Process(i);
> > > psList.add(ps);

> > }
> > num=RandomNum+num;
> > m\_headTextArea.setText("프로세스 " + (RandomNum) +"개가 생성되었습니다");


> m\_mainTextArea.setText("");
> int size = psList.size();
> m\_mainTextArea.append("ProcessNumber   BurstTime   ArrivalTime        Priority\n");
> for(int i = 0; i < size; i++){
> > Process tmp = (Process)psList.elementAt(i);
> > m\_mainTextArea.append("          P"+tmp.processNum+"	            "+tmp.burstTime+"	     "+tmp.arrivalTime+
> > "	"+tmp.priority+"\n");

> }


> }


> private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {// 프로세스 추가
> > m\_arriveTime\_set\_TextArea.setText("");
> > m\_burstTime\_set\_TextArea.setText("");
> > m\_priority\_set\_TextArea.setText("");
> > insertPS.setVisible(true);

> }

> private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {// 프로세스 추가
> > Process ps = new Process(num, Integer.parseInt(m\_arriveTime\_set\_TextArea.getText()), Integer.parseInt(m\_burstTime\_set\_TextArea.getText()), Integer.parseInt(m\_priority\_set\_TextArea.getText()));
> > num++;
> > psList.add(ps);
> > insertPS.setVisible(false);


> m\_headTextArea.setText("프로세스 p"+(num - 1) +"이 추가로 생성되었습니다");
> m\_mainTextArea.setText("");
> int size = psList.size();
> m\_mainTextArea.append("ProcessNumber   BurstTime   ArrivalTime        Priority\n");
> for(int i = 0; i < size; i++){
> > Process tmp = (Process)psList.elementAt(i);
> > m\_mainTextArea.append("          P"+tmp.processNum+"	            "+tmp.burstTime+"	     "+tmp.arrivalTime+
> > "	"+tmp.priority+"\n");

> }


> }
> /**> private void m\_result\_button\_performed(java.awt.event.ActionEvent evt){
> > Result a=new Result();**


> m\_headTextArea.setText("결과");
> m\_mainTextArea.setText("");
> m\_mainTextArea.append("FCFS WaitingTime :  "+FCFT\_W+"\n");
> m\_mainTextArea.append("FCFS TurnaoundTime :  "+FCFT\_T+"\n");
> m\_mainTextArea.append("Priority Preemtive WaitingTime :  "+priority\_preemtive\_W+"\n");
> m\_mainTextArea.append("Priority Preemtive TurnaoundTime :  "+priority\_preemtive\_T+"\n");
> m\_mainTextArea.append("Priority NonPreemtive WaitingTime :  "+priority\_nonpreemtive\_W+"\n");
> m\_mainTextArea.append("Priority NonPreemtive TurnaoundTime :  "+priority\_nonpreemtive\_T+"\n");
> m\_mainTextArea.append("SJF Preemtive WaitingTime :  "+SJF\_preemtive\_W+"\n");
> m\_mainTextArea.append("SJF Preemtive TurnaoundTime :  "+SJF\_preemtive\_T+"\n");
> m\_mainTextArea.append("SJF NonPreemtive WaitingTime :  "+SJF\_nonpreemtive\_W+"\n");
> m\_mainTextArea.append("SJF NonPreemtive TurnaoundTime :  "+SJF\_nonpreemtive\_T+"\n");
> m\_mainTextArea.append("RoundRobin WaitingTime :  "+RoundRobin\_W+"\n");
> m\_mainTextArea.append("RoundRobin TurnaoundTime :  "+RoundRobin\_T+"\n");

> }
  * 
> private void m\_SJF\_preemtive\_button\_performed(java.awt.event.ActionEvent evt) {	//SJF(preemptive)
> > m\_headTextArea.setText("SJF(preemptive) 프로세스 스케쥴링");
> > m\_mainTextArea.setText("");


> sjfp.reset();
> sjfp.setSchedule(psList);
> e = 1;
> if(psList.size() == 0)
> > e = 0;

> sjfp.setTextArea(m\_mainTextArea);
> sjfp.setupFrame(this);
> new Thread(sjfp).start();
> SJF\_preemtive\_W=sjfp.resultWaiting();
> SJF\_preemtive\_T=sjfp.resultTurnaround();
> }

> private void m\_FCFS\_button\_Performed(java.awt.event.ActionEvent evt){	//FCFS
> > m\_headTextArea.setText("FCFS 프로세스 스케쥴링");
> > m\_mainTextArea.setText("");


> fcfs.reset();
> fcfs.setSchedule(psList);
> e = 1;
> if(psList.size() == 0)
> > e = 0;

> fcfs.setTextArea(m\_mainTextArea);
> fcfs.setupFrame(this);
> new Thread(fcfs).start();
> FCFT\_W=fcfs.resultWaiting();
> FCFT\_T=fcfs.resultTurnaround();
> }

> private void m\_SJF\_nonpreemtive\_button\_performed(java.awt.event.ActionEvent evt) {	//SJF(nonpremptive)
> m\_headTextArea.setText("SJF(nonpremptive) 프로세스 스케쥴링");
> m\_mainTextArea.setText("");

> sjfnp.reset();
> sjfnp.setSchedule(psList);
> e = 1;
> if(psList.size() == 0)
> > e = 0;

> sjfnp.setTextArea(m\_mainTextArea);
> sjfnp.setupFrame(this);
> new Thread(sjfnp).start();
> SJF\_nonpreemtive\_W=sjfnp.resultWaiting();
> SJF\_nonpreemtive\_T=sjfnp.resultTurnaround();

> }

> private void m\_priority\_preemtive\_button\_performed(java.awt.event.ActionEvent evt) {	//Priority(premptive)
> > m\_headTextArea.setText("Priority(premptive) 프로세스 스케쥴링");
> > m\_mainTextArea.setText("");


> priorityp.reset();
> priorityp.setSchedule(psList);
> e = 1;
> if(psList.size() == 0)
> > e = 0;

> priorityp.setTextArea(m\_mainTextArea);
> priorityp.setupFrame(this);
> new Thread(priorityp).start();
> priority\_preemtive\_W=priorityp.resultWaiting();
> priority\_preemtive\_T=priorityp.resultTurnaround();

> }

> private void m\_priority\_nonpreemtive\_button\_performed(java.awt.event.ActionEvent evt) {	//Priority(nonpremptive)
> > m\_headTextArea.setText("Priority(nonpremptive) 프로세스 스케쥴링");
> > m\_mainTextArea.setText("");


> prioritynp.reset();
> prioritynp.setSchedule(psList);
> e = 1;
> if(psList.size() == 0)
> > e = 0;

> prioritynp.setTextArea(m\_mainTextArea);
> prioritynp.setupFrame(this);
> new Thread(prioritynp).start();
> priority\_nonpreemtive\_W=prioritynp.resultWaiting();
> priority\_nonpreemtive\_T=prioritynp.resultTurnaround();

> }

> private void m\_RoundRobin\_button\_performed(java.awt.event.ActionEvent evt) {//quantum 창 부르기
> > m\_RoundRobin\_quantun\_set\_TextArea.setText("3");
> > setQuantum.setVisible(true);


> }

> private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {	//RR
> > setQuantum.setVisible(false);
> > m\_headTextArea.setText("Round Robin 프로세스 스케쥴링");
> > m\_mainTextArea.setText("");


> rr.reset();
> rr.setQuentum(Integer.parseInt(m\_RoundRobin\_quantun\_set\_TextArea.getText()));
> rr.setSchedule(psList);
> e = 1;
> if(psList.size() == 0)
> > e = 0;

> rr.setTextArea(m\_mainTextArea);
> rr.setupFrame(this);
> new Thread(rr).start();
> RoundRobin\_W=rr.resultWaiting();
> RoundRobin\_T=rr.resultTurnaround();

> }



> private void m\_process\_look\_button\_performed(java.awt.event.ActionEvent evt) {// 프로세스 보기
> > m\_headTextArea.setText("생성된 프로세스 리스트");
> > m\_mainTextArea.setText("");


> int size = psList.size();
> m\_mainTextArea.append("ProcessNumber   BurstTime   ArrivalTime        Priority\n");
> for(int i = 0; i < size; i++){
> > Process tmp = (Process)psList.elementAt(i);
> > m\_mainTextArea.append("          P"+tmp.processNum+"	            "+tmp.burstTime+"	     "+tmp.arrivalTime+
> > "	"+tmp.priority+"\n");

> }
> }

> private void m\_process\_reset\_button\_performed(java.awt.event.ActionEvent evt) {//reset
> > m\_headTextArea.setText("초기화 되었습니다");
> > m\_mainTextArea.setText("");


> fcfs.reset();
> priorityp.reset();
> prioritynp.reset();
> sjfp.reset();
> sjfnp.reset();
> rr.reset();
> num = 0;
> psList.removeAllElements();
> }
> public void Gantt\_Reset(){
> > Chart.grP\_Reset();

> }
> public void Gantt\_add(int Id, int time){
> > Chart.imgChange(Id, time);

> }
> public void Gantt\_setSize(){
> > Chart.setPreferredSize(new Dimension(Chart.w, 85));

> }
> public void set\_e(int e){
> > this.e = e;

> }

> public static void main(String[.md](.md) args) {
> > // TODO Auto-generated method stub
> > java.awt.EventQueue.invokeLater(new Runnable() {
> > > public void run() {
> > > > new Test().setVisible(true);

> > > }
> > > });

> }

> private javax.swing.JButton m\_process\_generate\_button;
> private javax.swing.JButton m\_SJSF\_button;
> private javax.swing.JButton m\_SJF\_preemtive\_button;
> private javax.swing.JButton m\_SJF\_nonPreemtive\_button;
> private javax.swing.JButton m\_priority\_preemtive\_button;
> private javax.swing.JButton m\_priority\_nonpreemtive\_button;
> private javax.swing.JButton m\_reset\_button;
> private javax.swing.JButton m\_process\_look\_button;
> private javax.swing.JButton m\_RoundRobin\_button;
> private javax.swing.JButton m\_process\_add\_button;
> private javax.swing.JButton m\_process\_add\_confirm\_button;
> private javax.swing.JButton m\_RoundRobin\_quantum\_button;
> private javax.swing.JButton m\_set\_process\_number\_commit\_button;
> //private javax.swing.JButton m\_Result\_button;
> private javax.swing.JTextArea m\_mainTextArea;
> private javax.swing.JTextArea m\_headTextArea;
> private javax.swing.JPanel panel1;
> private javax.swing.JPanel panel2;
> private javax.swing.JScrollPane scrollpane1;
> private javax.swing.JScrollPane ganttInner;
> private javax.swing.JTextField m\_arriveTime\_set\_TextArea;
> private javax.swing.JTextField m\_burstTime\_set\_TextArea;
> private javax.swing.JTextField m\_priority\_set\_TextArea;
> private javax.swing.JTextField m\_RoundRobin\_quantun\_set\_TextArea;
> private JTextField m\_set\_process\_number\_TextArea;
> private javax.swing.JFrame insertPS;
> private javax.swing.JFrame setQuantum;
> private javax.swing.JFrame m\_set\_process\_number\_View;
> private javax.swing.JPanel bGantt;

}

import java.util.Vector;

import javax.swing.JTextArea;

public class Sjfp extends Scheduling implements Runnable {

> public void setTextArea(JTextArea textArea) {
> > this.textArea = textArea;

> }

> void setSchedule(Vector

&lt;Process&gt;

 psList) {
> > //		정렬안된 프로세스 리스트 -> arrivalTime - burstTime이 작은순으로 정렬
> > Process ps;
> > Vector

&lt;Process&gt;

 v = new Vector

&lt;Process&gt;

();
> > Vector

&lt;Process&gt;

 readyQueue = new Vector

&lt;Process&gt;

();
> > int j = psList.size();
> > int sumBurstTime = 0;


> for (int i = 0; i < j; i++) {
> > ps = new Process(psList.elementAt(i));
> > sumBurstTime = sumBurstTime + ps.burstTime;


> int length = v.size();

> if (length == 0) {
> > v.add(ps);

> } else {
> > for (int k = 0; k < length; k++) {
> > > Process tmp = (Process) v.elementAt(k);


> if (tmp.arrivalTime > ps.arrivalTime) { //도착시간이 작은순서

> v.insertElementAt(ps, k);
> break;
> } else if (tmp.arrivalTime == ps.arrivalTime) { //같을땐 burstTime 작은순
> > if (tmp.burstTime > ps.burstTime) {


> v.insertElementAt(ps, k);
> break;
> }
> }
> if (k == length - 1) {
> > v.add(ps);

> }
> }
> }
> }

> forcalculate = (Vector

&lt;Process&gt;

)v.clone();

> //SJF(preemptive) Logic
> for (int now = 0; now < sumBurstTime; now++) {

> for (int i = 0; i < v.size(); i++) {
> > ps = v.elementAt(i);
> > if (ps.arrivalTime == now) {
> > > readyQueue.add(ps);
> > > v.removeElement(ps);
> > > i--;

> > }

> }

> if (readyQueue.size() == 0) {
> > scheduledPsList.add(new Process(-1));//씨피유에 암것도 안들어올때
> > sumBurstTime ++;//이 경우에 버스트타임은 아닌데 가는 시간은 있으므로
> > continue;

> } else {
> > Process temp = new Process(-1);
> > for (int i = 0; i < readyQueue.size(); i++) {
> > > ps = (Process) readyQueue.elementAt(i);
> > > if (i == 0) {
> > > > temp = ps;

> > > } else if (temp.remainTime > ps.remainTime) {
> > > > temp = ps;

> > > }

> > }
> > scheduledPsList.add(temp);
> > temp.setRemainTime(temp.getRemainTime()-1);
> > if (temp.remainTime == 0){
> > > readyQueue.removeElement(temp);
> > > temp.setTerminateTime(now + 1);

> > }

> }
> }
> }


> void reset() {
> > scheduledPsList.removeAllElements();

> }

> float avgWaiting() {
> > int sumWaitingTime = 0;
> > for(int i = 0; i < forcalculate.size(); i++){
> > > Process ps = forcalculate.elementAt(i);
> > > sumWaitingTime = sumWaitingTime + ps.getWaitingTime();

> > }



> return (float) sumWaitingTime / forcalculate.size();
> }

> float avgTurnaround() {
> > int sumTurnaroundTime = 0;
> > for(int i = 0; i < forcalculate.size(); i++){
> > > Process ps = forcalculate.elementAt(i);
> > > sumTurnaroundTime = sumTurnaroundTime + ps.getTurnaroundTime();

> > }



> return (float) sumTurnaroundTime / forcalculate.size();
> }

> public void setupFrame(Test test){
> > this.frame = test;

> }

> public void run() {
> > frame.Gantt\_Reset();
> > textArea.append("실행순서         ProcessNumber   BurstTime   ArrivalTime          Priority\n");
> > for (int i = 0; i <  scheduledPsList.size() + 1; i++) {
> > > try {
> > > > Thread.sleep(200);

> > > } catch (InterruptedException e) {
> > > > // TODO Auto-generated catch block
> > > > e.printStackTrace();

> > > }
> > > if(i == scheduledPsList.size()){
> > > > Process temp = (Process) scheduledPsList.elementAt(i - 1);
> > > > System.out.println(i);
> > > > frame.Gantt\_setSize();
> > > > frame.Gantt\_add(temp.processNum, i);
> > > > textArea.append("\n\n Average Waiting Time = " + this.avgWaiting());
> > > > textArea.append("\n\n Average Turnaound Time = " + this.avgTurnaround());
> > > > frame.set\_e(0);

> > > }
> > > else{
> > > > Process temp = (Process) scheduledPsList.elementAt(i);
> > > > System.out.println(i);
> > > > frame.Gantt\_setSize();
> > > > frame.Gantt\_add(temp.processNum, i);
> > > > textArea.append("현재시간"+i+"::	"+temp.toString());

> > > }

> > }

> }
> public float resultWaiting(){
> > return this.avgWaiting();

> }
> public float resultTurnaround(){
> > return this.avgTurnaround();

> }

}

import java.util.Vector;

import javax.swing.JTextArea;

public class Sjfnp extends Scheduling implements Runnable {

> public void setTextArea(JTextArea textArea) {
> > this.textArea = textArea;

> }

> void setSchedule(Vector

&lt;Process&gt;

 psList) {
> > //		정렬안된 프로세스 리스트 -> arrivalTime - burstTime이 작은순으로 정렬
> > Process ps;
> > Vector

&lt;Process&gt;

 v = new Vector

&lt;Process&gt;

();
> > Vector

&lt;Process&gt;

 readyQueue = new Vector

&lt;Process&gt;

();
> > int j = psList.size();
> > int sumBurstTime = 0;


> for (int i = 0; i < j; i++) {
> > ps = new Process(psList.elementAt(i));
> > sumBurstTime = sumBurstTime + ps.burstTime;


> int length = v.size();

> if (length == 0) {
> > v.add(ps);

> } else {
> > for (int k = 0; k < length; k++) {
> > > Process tmp = (Process) v.elementAt(k);


> if (tmp.arrivalTime > ps.arrivalTime) { //도착시간이 작은순서

> v.insertElementAt(ps, k);
> break;
> } else if (tmp.arrivalTime == ps.arrivalTime) { //같을땐 burstTime 작은순
> > if (tmp.burstTime > ps.burstTime) {


> v.insertElementAt(ps, k);
> break;
> }
> }
> if (k == length - 1) {
> > v.add(ps);

> }
> }
> }
> }

> forcalculate = (Vector

&lt;Process&gt;

)v.clone();

> //SJF(nonpreemptive) Logic
> for (int now = 0; now < sumBurstTime; now++) {

> for (int i = 0; i < v.size(); i++) {
> > ps = v.elementAt(i);
> > if (ps.arrivalTime <= now) {
> > > readyQueue.add(ps);
> > > v.removeElement(ps);
> > > i--;

> > }

> }

> if (readyQueue.size() == 0) {
> > scheduledPsList.add(new Process(-1));//씨피유에 암것도 안들어올때
> > sumBurstTime ++;//이 경우에 버스트타임은 아닌데 가는 시간은 있으므로
> > continue;

> } else {
> > Process temp = new Process(-1);
> > for (int i = 0; i < readyQueue.size(); i++) {
> > > ps = readyQueue.elementAt(i);
> > > if (i == 0) {
> > > > temp = ps;

> > > } else if (temp.remainTime > ps.remainTime) {
> > > > temp = ps;

> > > }

> > }
> > while(temp.getRemainTime() != 0){
> > > scheduledPsList.add(temp);
> > > temp.setRemainTime(temp.getRemainTime()-1);
> > > if(temp.getRemainTime() != 0)
> > > > now++;

> > }
> > if (temp.remainTime == 0){
> > > readyQueue.removeElement(temp);
> > > temp.setTerminateTime(now + 1);

> > }

> }
> }
> }

> void reset() {
> > scheduledPsList.removeAllElements();

> }

> float avgWaiting() {
> > int sumWaitingTime = 0;
> > for(int i = 0; i < forcalculate.size(); i++){
> > > Process ps = forcalculate.elementAt(i);
> > > sumWaitingTime = sumWaitingTime + ps.getWaitingTime();

> > }



> return (float) sumWaitingTime / forcalculate.size();
> }

> float avgTurnaround() {
> > int sumTurnaroundTime = 0;
> > for(int i = 0; i < forcalculate.size(); i++){
> > > Process ps = forcalculate.elementAt(i);
> > > sumTurnaroundTime = sumTurnaroundTime + ps.getTurnaroundTime();

> > }



> return (float) sumTurnaroundTime / forcalculate.size();
> }

> public void setupFrame(Test test){
> > this.frame = test;

> }

> public void run() {
> > frame.Gantt\_Reset();
> > textArea.append("실행순서         ProcessNumber   BurstTime   ArrivalTime          Priority\n");
> > for (int i = 0; i <  scheduledPsList.size() + 1; i++) {
> > > try {
> > > > Thread.sleep(200);

> > > } catch (InterruptedException e) {
> > > > // TODO Auto-generated catch block
> > > > e.printStackTrace();

> > > }
> > > if(i == scheduledPsList.size()){
> > > > Process temp = (Process) scheduledPsList.elementAt(i - 1);
> > > > System.out.println(i);
> > > > frame.Gantt\_setSize();
> > > > frame.Gantt\_add(temp.processNum, i);
> > > > textArea.append("\n\n Average Waiting Time = " + this.avgWaiting());
> > > > textArea.append("\n\n Average Turnaound Time = " + this.avgTurnaround());
> > > > frame.set\_e(0);

> > > }
> > > else{
> > > > Process temp = (Process) scheduledPsList.elementAt(i);
> > > > System.out.println(i);
> > > > frame.Gantt\_setSize();
> > > > frame.Gantt\_add(temp.processNum, i);
> > > > textArea.append("현재시간"+i+"::	"+temp.toString());

> > > }

> > }

> }
> public float resultWaiting(){
> > return this.avgWaiting();

> }
> public float resultTurnaround(){
> > return this.avgTurnaround();

> }

}

import java.util.**;**

import javax.swing.JTextArea;


public abstract class Scheduling {

> protected Vector

&lt;Process&gt;

 scheduledPsList;
> protected Vector

&lt;Process&gt;

 forcalculate;
> protected JTextArea textArea;
> protected Test frame;

> public Scheduling(){
> > scheduledPsList = new Vector

&lt;Process&gt;

();

> }

> abstract void setSchedule(Vector

&lt;Process&gt;

 psList);

> abstract void reset();

> abstract float avgWaiting();

> abstract float avgTurnaround();

> public Vector

&lt;Process&gt;

 getSchedule(){
> > return scheduledPsList;

> }
}


import java.util.Vector;

import javax.swing.JTextArea;

public class Rr extends Scheduling implements Runnable {

> int quantum;

> public void setTextArea(JTextArea textArea) {
> > this.textArea = textArea;

> }

> public void setQuentum(int quantum){
> > this.quantum = quantum;

> }

> void setSchedule(Vector

&lt;Process&gt;

 psList) {
> > //		정렬안된 프로세스 리스트 -> arrivalTime - processNum이 작은순으로 정렬
> > Process ps;
> > Vector

&lt;Process&gt;

 v = new Vector

&lt;Process&gt;

();
> > Vector

&lt;Process&gt;

 readyQueue = new Vector

&lt;Process&gt;

();
> > int j = psList.size();
> > int sumBurstTime = 0;


> for (int i = 0; i < j; i++) {
> > ps = new Process(psList.elementAt(i));
> > sumBurstTime = sumBurstTime + ps.burstTime;


> int length = v.size();

> if (length == 0) {
> > v.add(ps);

> } else {
> > for (int k = 0; k < length; k++) {
> > > Process tmp = (Process) v.elementAt(k);


> if (tmp.arrivalTime > ps.arrivalTime) { //도착시간이 작은순서

> v.insertElementAt(ps, k);
> break;
> } else if (tmp.arrivalTime == ps.arrivalTime) { //같을땐 생성프로세스순
> > if (tmp.processNum > ps.processNum) {


> v.insertElementAt(ps, k);
> break;
> }
> }
> if (k == length - 1) {
> > v.add(ps);

> }
> }
> }
> }

> forcalculate = (Vector

&lt;Process&gt;

)v.clone();

> //SJF Logic
> for (int now = 0; now < sumBurstTime; now++) {

> for (int i = 0; i < v.size(); i++) {
> > ps = v.elementAt(i);
> > if (ps.arrivalTime == now) {
> > > readyQueue.add(ps);
> > > v.removeElement(ps);
> > > i--;

> > }

> }

> if (readyQueue.size() == 0) {
> > scheduledPsList.add(new Process(-1));//씨피유에 암것도 안들어올때
> > sumBurstTime ++;//이 경우에 버스트타임은 아닌데 가는 시간은 있으므로
> > continue;

> } else {
> > Process temp = readyQueue.elementAt(0);
> > for(int i = 0; i < quantum; i++){
> > > if(temp.getRemainTime() != 0){
> > > > scheduledPsList.add(temp);
> > > > temp.setRemainTime(temp.getRemainTime()-1);
> > > > if(temp.getRemainTime() != 0){
> > > > > if(i == quantum-1) break;
> > > > > else{
> > > > > > now++;
> > > > > > for (int k = 0; k < v.size(); k++) {
> > > > > > > ps = v.elementAt(k);
> > > > > > > if (ps.arrivalTime == now) {
> > > > > > > > readyQueue.add(ps);
> > > > > > > > v.removeElement(ps);
> > > > > > > > k--;

> > > > > > > }

> > > > > > }

> > > > > }

> > > > }
> > > > else
> > > > > break;

> > > }
> > > else
> > > > break;

> > }
> > if (temp.remainTime == 0){
> > > readyQueue.removeElement(temp);
> > > temp.setTerminateTime(now + 1);

> > }
> > else{
> > > readyQueue.add(temp);
> > > readyQueue.removeElement(temp);

> > }

> }
> }
> }

> void reset() {
> > scheduledPsList.removeAllElements();

> }

> float avgWaiting() {
> > int sumWaitingTime = 0;
> > for(int i = 0; i < forcalculate.size(); i++){
> > > Process ps = forcalculate.elementAt(i);
> > > sumWaitingTime = sumWaitingTime + ps.getWaitingTime();

> > }



> return (float) sumWaitingTime / forcalculate.size();
> }

> float avgTurnaround() {
> > int sumTurnaroundTime = 0;
> > for(int i = 0; i < forcalculate.size(); i++){
> > > Process ps = forcalculate.elementAt(i);
> > > sumTurnaroundTime = sumTurnaroundTime + ps.getTurnaroundTime();

> > }



> return (float) sumTurnaroundTime / forcalculate.size();
> }

> public void setupFrame(Test test){
> > this.frame = test;

> }

> public void run() {
> > frame.Gantt\_Reset();
> > textArea.append("실행순서         ProcessNumber   BurstTime   ArrivalTime          Priority\n");
> > for (int i = 0; i <  scheduledPsList.size() + 1; i++) {
> > > try {
> > > > Thread.sleep(200);

> > > } catch (InterruptedException e) {
> > > > // TODO Auto-generated catch block
> > > > e.printStackTrace();

> > > }
> > > if(i == scheduledPsList.size()){
> > > > Process temp = (Process) scheduledPsList.elementAt(i - 1);
> > > > System.out.println(i);
> > > > frame.Gantt\_setSize();
> > > > frame.Gantt\_add(temp.processNum, i);
> > > > textArea.append("\n\n Average Waiting Time = " + this.avgWaiting());
> > > > textArea.append("\n\n Average Turnaound Time = " + this.avgTurnaround());
> > > > frame.set\_e(0);

> > > }
> > > else{
> > > > Process temp = (Process) scheduledPsList.elementAt(i);
> > > > System.out.println(i);
> > > > frame.Gantt\_setSize();
> > > > frame.Gantt\_add(temp.processNum, i);
> > > > textArea.append("현재시간"+i+"::	"+temp.toString());

> > > }

> > }

> }
> public float resultWaiting(){
> > return this.avgWaiting();

> }
> public float resultTurnaround(){
> > return this.avgTurnaround();

> }

}

import java.util.Random;

public class Process {

> int processNum;
> int arrivalTime;
> int burstTime;
> int priority;
> int remainTime;
> int waitingTime = 0;
> int turnaroundTime = 0;
> int terminateTime;

> public Process(int psNum) {
> > Random rand = new Random();


> processNum = psNum;
> if (psNum == 0) {
> > arrivalTime = 0;
> > burstTime = 1;

> }
> else{
> > arrivalTime = rand.nextInt(10);
> > burstTime = rand.nextInt(20);

> }
> priority = rand.nextInt(5);

> while (burstTime == 0)
> > burstTime = rand.nextInt(20);


> remainTime = burstTime;

> }

> public Process(int psNum, int arrival, int burst, int priority) {
> > processNum = psNum;
> > this.arrivalTime = arrival;
> > this.burstTime = burst;
> > this.priority = priority;
> > remainTime = burstTime;


> }

> public Process(Process origin) {
> > processNum = origin.processNum;
> > arrivalTime = origin.arrivalTime;
> > burstTime = origin.burstTime;
> > priority = origin.priority;
> > remainTime = origin.remainTime;

> }


> public int getRemainTime() {
> > return remainTime;

> }


> public void setRemainTime(int remainTime) {
> > this.remainTime = remainTime;

> }

> public void setTerminateTime(int terminateTime) {
> > this.terminateTime = terminateTime;
> > setTurnaroundTime();
> > setWaitingTime();

> }

> public int getTerminateTime() {
> > return terminateTime;

> }

> public void setTurnaroundTime() {
> > turnaroundTime = terminateTime - arrivalTime;

> }

> public int getTurnaroundTime() {
> > return turnaroundTime;

> }

> public void setWaitingTime() {
> > waitingTime = turnaroundTime - burstTime;

> }

> public int getWaitingTime() {
> > return waitingTime;

> }
> @Override
> public String toString() {
> > String result = "P"+processNum+"	"+burstTime+"	"+arrivalTime+"	"+priority+ "\n";
> > if(processNum == -1)	result = "	대기중\n";


> return result;
> }
}

import java.util.Vector;

import javax.swing.JTextArea;

public class Priorityp extends Scheduling implements Runnable {

> public void setTextArea(JTextArea textArea) {
> > this.textArea = textArea;

> }

> void setSchedule(Vector

&lt;Process&gt;

 psList) {
> > //		정렬안된 프로세스 리스트 -> arrivalTime - burstTime이 작은순으로 정렬
> > Process ps;
> > Vector

&lt;Process&gt;

 v = new Vector

&lt;Process&gt;

();
> > Vector

&lt;Process&gt;

 readyQueue = new Vector

&lt;Process&gt;

();
> > int j = psList.size();
> > int sumBurstTime = 0;


> for (int i = 0; i < j; i++) {
> > ps = new Process(psList.elementAt(i));
> > sumBurstTime = sumBurstTime + ps.burstTime;


> int length = v.size();

> if (length == 0) {
> > v.add(ps);

> } else {
> > for (int k = 0; k < length; k++) {
> > > Process tmp = (Process) v.elementAt(k);


> if (tmp.arrivalTime > ps.arrivalTime) { //도착시간이 작은순서

> v.insertElementAt(ps, k);
> break;
> } else if (tmp.arrivalTime == ps.arrivalTime) { //같을땐 burstTime 작은
> > if (tmp.burstTime > ps.burstTime) {


> v.insertElementAt(ps, k);
> break;
> }
> }
> if (k == length - 1) {
> > v.add(ps);

> }
> }
> }
> }

> forcalculate = (Vector

&lt;Process&gt;

)v.clone();

> //SJF Logic
> for (int now = 0; now < sumBurstTime; now++) {

> for (int i = 0; i < v.size(); i++) {
> > ps = v.elementAt(i);
> > if (ps.arrivalTime == now) {
> > > readyQueue.add(ps);
> > > v.removeElement(ps);
> > > i--;

> > }

> }

> if (readyQueue.size() == 0) {
> > scheduledPsList.add(new Process(-1));//씨피유에 암것도 안들어올때
> > sumBurstTime ++;//이 경우에 버스트타임은 아닌데 가는 시간은 있으므로
> > continue;

> } else {
> > Process temp = new Process(-1);
> > for (int i = 0; i < readyQueue.size(); i++) {
> > > ps = readyQueue.elementAt(i);
> > > if (i == 0) {
> > > > temp = ps;

> > > } else if (temp.priority > ps.priority) {
> > > > temp = ps;

> > > }

> > }
> > scheduledPsList.add(temp);
> > temp.setRemainTime(temp.getRemainTime()-1);
> > if (temp.remainTime == 0){
> > > readyQueue.removeElement(temp);
> > > temp.setTerminateTime(now + 1);

> > }

> }
> }
> }

> void reset(){
> > scheduledPsList.removeAllElements();

> }

> float avgWaiting() {
> > int sumWaitingTime = 0;
> > for(int i = 0; i < forcalculate.size(); i++){
> > > Process ps = forcalculate.elementAt(i);
> > > sumWaitingTime = sumWaitingTime + ps.getWaitingTime();

> > }



> return (float) sumWaitingTime / forcalculate.size();
> }

> float avgTurnaround() {
> > int sumTurnaroundTime = 0;
> > for(int i = 0; i < forcalculate.size(); i++){
> > > Process ps = forcalculate.elementAt(i);
> > > sumTurnaroundTime = sumTurnaroundTime + ps.getTurnaroundTime();

> > }



> return (float) sumTurnaroundTime / forcalculate.size();
> }

> public void setupFrame(Test test){
> > this.frame = test;

> }

> public void run() {
> > frame.Gantt\_Reset();
> > textArea.append("실행순서         ProcessNumber   BurstTime   ArrivalTime          Priority\n");
> > for (int i = 0; i <  scheduledPsList.size() + 1; i++) {
> > > try {
> > > > Thread.sleep(200);

> > > } catch (InterruptedException e) {
> > > > // TODO Auto-generated catch block
> > > > e.printStackTrace();

> > > }
> > > if(i == scheduledPsList.size()){
> > > > Process temp = (Process) scheduledPsList.elementAt(i - 1);
> > > > System.out.println(i);
> > > > frame.Gantt\_setSize();
> > > > frame.Gantt\_add(temp.processNum, i);
> > > > textArea.append("\n\n Average Waiting Time = " + this.avgWaiting());
> > > > textArea.append("\n\n Average Turnaound Time = " + this.avgTurnaround());
> > > > frame.set\_e(0);

> > > }
> > > else{
> > > > Process temp = (Process) scheduledPsList.elementAt(i);
> > > > System.out.println(i);
> > > > frame.Gantt\_setSize();
> > > > frame.Gantt\_add(temp.processNum, i);
> > > > textArea.append("현재시간"+i+"::	"+temp.toString());

> > > }

> > }

> }
> public float resultWaiting(){
> > return this.avgWaiting();

> }
> public float resultTurnaround(){
> > return this.avgTurnaround();

> }

}

import java.util.Vector;

import javax.swing.JTextArea;

public class Prioritynp extends Scheduling implements Runnable {

> public void setTextArea(JTextArea textArea) {
> > this.textArea = textArea;

> }

> void setSchedule(Vector

&lt;Process&gt;

 psList) {
> > //		정렬안된 프로세스 리스트 -> arrivalTime - burstTime이 작은순으로 정렬
> > Process ps;
> > Vector

&lt;Process&gt;

 v = new Vector

&lt;Process&gt;

();
> > Vector

&lt;Process&gt;

 readyQueue = new Vector

&lt;Process&gt;

();
> > int j = psList.size();
> > int sumBurstTime = 0;


> for (int i = 0; i < j; i++) {
> > ps = new Process(psList.elementAt(i));
> > sumBurstTime = sumBurstTime + ps.burstTime;


> int length = v.size();

> if (length == 0) {
> > v.add(ps);

> } else {
> > for (int k = 0; k < length; k++) {
> > > Process tmp = (Process) v.elementAt(k);


> if (tmp.arrivalTime > ps.arrivalTime) { //도착시간이 작은순서

> v.insertElementAt(ps, k);
> break;
> } else if (tmp.arrivalTime == ps.arrivalTime) { //같을땐 burstTime 작은순
> > if (tmp.burstTime > ps.burstTime) {


> v.insertElementAt(ps, k);
> break;
> }
> }
> if (k == length - 1) {
> > v.add(ps);

> }
> }
> }
> }

> forcalculate = (Vector

&lt;Process&gt;

)v.clone();

> //SJF Logic
> for (int now = 0; now < sumBurstTime; now++) {

> for (int i = 0; i < v.size(); i++) {
> > ps = v.elementAt(i);
> > if (ps.arrivalTime <= now) {
> > > readyQueue.add(ps);
> > > v.removeElement(ps);
> > > i--;

> > }

> }

> if (readyQueue.size() == 0) {
> > scheduledPsList.add(new Process(-1));//씨피유에 암것도 안들어올때
> > sumBurstTime ++;//이 경우에 버스트타임은 아닌데 가는 시간은 있으므로
> > continue;

> } else {
> > Process temp = new Process(-1);
> > for (int i = 0; i < readyQueue.size(); i++) {
> > > ps = readyQueue.elementAt(i);
> > > if (i == 0) {
> > > > temp = ps;

> > > } else if (temp.priority > ps.priority) {
> > > > temp = ps;

> > > }

> > }
> > while(temp.getRemainTime() != 0){
> > > scheduledPsList.add(temp);
> > > temp.setRemainTime(temp.getRemainTime()-1);
> > > if(temp.getRemainTime() != 0)
> > > > now++;

> > }
> > if (temp.remainTime == 0){
> > > readyQueue.removeElement(temp);
> > > temp.setTerminateTime(now + 1);

> > }

> }
> }
> }

> void reset(){
> > scheduledPsList.removeAllElements();

> }
> float avgWaiting() {
> > int sumWaitingTime = 0;
> > for(int i = 0; i < forcalculate.size(); i++){
> > > Process ps = forcalculate.elementAt(i);
> > > sumWaitingTime = sumWaitingTime + ps.getWaitingTime();

> > }



> return (float) sumWaitingTime / forcalculate.size();
> }

> float avgTurnaround() {
> > int sumTurnaroundTime = 0;
> > for(int i = 0; i < forcalculate.size(); i++){
> > > Process ps = forcalculate.elementAt(i);
> > > sumTurnaroundTime = sumTurnaroundTime + ps.getTurnaroundTime();

> > }



> return (float) sumTurnaroundTime / forcalculate.size();
> }

> public void setupFrame(Test test){
> > this.frame = test;

> }

> public void run() {
> > frame.Gantt\_Reset();
> > textArea.append("실행순서         ProcessNumber   BurstTime   ArrivalTime          Priority\n");
> > for (int i = 0; i <  scheduledPsList.size() + 1; i++) {
> > > try {
> > > > Thread.sleep(200);

> > > } catch (InterruptedException e) {
> > > > // TODO Auto-generated catch block
> > > > e.printStackTrace();

> > > }
> > > if(i == scheduledPsList.size()){
> > > > Process temp = (Process) scheduledPsList.elementAt(i - 1);
> > > > System.out.println(i);
> > > > frame.Gantt\_setSize();
> > > > frame.Gantt\_add(temp.processNum, i);
> > > > textArea.append("\n\n Average Waiting Time = " + this.avgWaiting());
> > > > textArea.append("\n\n Average Turnaound Time = " + this.avgTurnaround());
> > > > frame.set\_e(0);

> > > }
> > > else{
> > > > Process temp = (Process) scheduledPsList.elementAt(i);
> > > > System.out.println(i);
> > > > frame.Gantt\_setSize();
> > > > frame.Gantt\_add(temp.processNum, i);
> > > > textArea.append("현재시간"+i+"::	"+temp.toString());

> > > }

> > }

> }
> public float resultWaiting(){
> > return this.avgWaiting();

> }
> public float resultTurnaround(){
> > return this.avgTurnaround();

> }

}


import java.awt.**;
import java.util.ArrayList;
import javax.swing.**;


import javax.swing.JPanel;

// 간트차트

class Gantt extends JPanel{
> private ArrayList grP;
> private int gTime;
> int w=0;

> Gantt(){
> > grP=new ArrayList();


> }
> public void imgChange(int Id, int time){
> > gTime=time;
> > if(grP.size()<1){
> > > grP.add(new runP(Id, time));

> > }else if(((runP)grP.get(grP.size()-1)).Id == Id){
> > > ((runP)grP.get(grP.size()-1)).set\_ed(time);

> > }else {
> > > ((runP)grP.get(grP.size()-1)).set\_ed(time);
> > > grP.add(new runP(Id, time));

> > }



> this.repaint();
> }
> public void grP\_Reset(){
> > grP.clear();

> }
> public void paint(Graphics g){
> > try {
> > > if(grP.size()>0){
> > > > w=((runP)grP.get(grP.size()-1)).ed\_time\*50+100;

> > > }
> > > if(w<700){
> > > > w=700;

> > > }

> > } catch (Exception e) {
> > }
> > g.drawString("time"+String.valueOf(gTime), 10, 10);
> > for(int i=0;i<grP.size();i++){
> > > g.drawRect(20+((runP)grP.get(i)).st\_time\*50, 20, (((runP)grP.get(i)).ed\_time-((runP)grP.get(i)).st\_time)**50, 35);
> > > g.drawString(String.valueOf(((runP)grP.get(i)).st\_time), ((runP)grP.get(i)).st\_time\*50+20, 70);
> > > g.drawString(String.valueOf(((runP)grP.get(i)).ed\_time), ((runP)grP.get(i)).ed\_time\*50+20, 70);
> > > g.drawString(((runP)grP.get(i)).getString(), ((((runP)grP.get(i)).st\_time\*50+20)+(((runP)grP.get(i)).ed\_time\*50+20))/2 - ((runP)grP.get(i)).getMinus(), 42);

> > }
> > this.setSize(new Dimension(w, 95));

> }
}**

class runP{
> int Id;
> int st\_time;
> int ed\_time;
> int minus;

> runP(int Id, int st\_time){
> > this.Id = Id;
> > this.st\_time = st\_time;
> > this.ed\_time = st\_time;

> }

> public void set\_ed(int ed\_time){
> > this.ed\_time = ed\_time;

> }
> public String getString(){
> > if(Id == -1)
> > > return "대기중";

> > else
> > > return String.valueOf(Id);

> }
> public int getMinus(){
> > if(Id == -1)
> > > minus = 16;

> > else
> > > minus = 2;

> > return minus;

> }

}


import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JTextArea;

public class Fcfs extends Scheduling implements Runnable {

> public void setTextArea(JTextArea textArea) {
> > this.textArea = textArea;

> }

> void setSchedule(Vector

&lt;Process&gt;

 psList) {
//		정렬안된 프로세스 리스트 -> arrivalTime - processNum이 작은순으로 정렬
> > Process ps;
> > Vector

&lt;Process&gt;

 v = new Vector

&lt;Process&gt;

();
> > Vector

&lt;Process&gt;

 readyQueue = new Vector

&lt;Process&gt;

();
> > int j = psList.size();
> > int sumBurstTime = 0;


> for (int i = 0; i < j; i++) {
> > ps = new Process(psList.elementAt(i));
> > sumBurstTime = sumBurstTime + ps.burstTime;


> int length = v.size();

> if (length == 0) {
> > v.add(ps);

> } else {
> > for (int k = 0; k < length; k++) {
> > > Process tmp = (Process) v.elementAt(k);


> if (tmp.arrivalTime > ps.arrivalTime) { //도착시간이 작은순서

> v.insertElementAt(ps, k);
> break;
> } else if (tmp.arrivalTime == ps.arrivalTime) { //같을땐 생성프로세스순
> > if (tmp.processNum > ps.processNum) {


> v.insertElementAt(ps, k);
> break;
> }
> }
> if (k == length - 1) {
> > v.add(ps);

> }
> }
> }
> }

> forcalculate = (Vector

&lt;Process&gt;

)v.clone();

> for (int now = 0; now < sumBurstTime; now++) {

> for (int i = 0; i < v.size(); i++) {
> > ps = v.elementAt(i);
> > if (ps.arrivalTime <= now) {
> > > readyQueue.add(ps);
> > > v.removeElement(ps);
> > > i--;

> > }

> }

> if (readyQueue.size() == 0) {
> > scheduledPsList.add(new Process(-1));//씨피유에 암것도 안들어올때
> > sumBurstTime ++;//이 경우에 버스트타임은 아닌데 가는 시간은 있으므로
> > continue;

> } else {
> > Process temp = new Process(-1);
> > for (int i = 0; i < readyQueue.size(); i++) {
> > > ps = readyQueue.elementAt(i);
> > > if (i == 0) {
> > > > temp = ps;

> > > } else if (temp.arrivalTime > ps.arrivalTime) {
> > > > temp = ps;

> > > }

> > }
> > while(temp.getRemainTime() != 0){
> > > scheduledPsList.add(temp);
> > > temp.setRemainTime(temp.getRemainTime()-1);
> > > if(temp.getRemainTime() != 0)
> > > > now++;

> > }
> > if (temp.remainTime == 0){
> > > readyQueue.removeElement(temp);
> > > temp.setTerminateTime(now + 1);

> > }

> }
> }


> }

> void reset(){
> > scheduledPsList.removeAllElements();

> }

> float avgWaiting() {
> > int sumWaitingTime = 0;
> > for(int i = 0; i < forcalculate.size(); i++){
> > > Process ps = forcalculate.elementAt(i);
> > > sumWaitingTime = sumWaitingTime + ps.getWaitingTime();

> > }



> return (float) sumWaitingTime / forcalculate.size();
> }

> float avgTurnaround() {
> > int sumTurnaroundTime = 0;
> > for(int i = 0; i < forcalculate.size(); i++){
> > > Process ps = forcalculate.elementAt(i);
> > > sumTurnaroundTime = sumTurnaroundTime + ps.getTurnaroundTime();

> > }



> return (float) sumTurnaroundTime / forcalculate.size();
> }

> public void setupFrame(Test test){
> > this.frame = test;

> }

> public void run() {
> > frame.Gantt\_Reset();
> > textArea.append("실행순서         ProcessNumber   BurstTime   ArrivalTime          Priority\n");
> > for (int i = 0; i <  scheduledPsList.size() + 1; i++) {
> > > try {
> > > > Thread.sleep(200);

> > > } catch (InterruptedException e) {
> > > > // TODO Auto-generated catch block
> > > > e.printStackTrace();

> > > }
> > > if(i == scheduledPsList.size()){
> > > > Process temp = (Process) scheduledPsList.elementAt(i - 1);
> > > > System.out.println(i);
> > > > frame.Gantt\_setSize();
> > > > frame.Gantt\_add(temp.processNum, i);
> > > > textArea.append("\n\n Average Waiting Time = " + this.avgWaiting());
> > > > textArea.append("\n\n Average Turnaound Time = " + this.avgTurnaround());
> > > > frame.set\_e(0);

> > > }
> > > else{
> > > > Process temp = (Process) scheduledPsList.elementAt(i);
> > > > System.out.println(i);
> > > > frame.Gantt\_setSize();
> > > > frame.Gantt\_add(temp.processNum, i);
> > > > textArea.append("현재시간"+i+"::	"+temp.toString());

> > > }

> > }

> }
> public float resultWaiting(){
> > return this.avgWaiting();

> }
> public float resultTurnaround(){
> > return this.avgTurnaround();

> }
}