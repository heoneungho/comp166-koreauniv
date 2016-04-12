#크리스마스 때 쓸쓸히 보면서 마음을 다스리자! 2012190702

# Introduction #

크리스마스 때 어울리는 음악을 틀고 멈추고 들으면서 내 자신을 한탄하자 휴ㅠㅠㅠㅠㅠㅠ
Add your content here.


# Details #

버튼 play 와 stop 을 만든다 !

즉, 이벤트를 발생 play 소스와 stop 소스를 받아 !

C 드라이브에 재생할 음악파일을 넣는다 !

그 데이터 위치를 받아서 음악을 재생하는 프로그램을 만든다 !

추가로 그림 or 동영상을 넣으면 화룡점정 !!

awt로 했으니 끌때는 !! System.exit(0) 마무리 !

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages


소스 여기다 적나 ??

import sun.audio.**;
import javax.swing.**;
import java.io.**;
import java.awt.**;
import java.awt.event.**;**

class JongHa\_1 extends Frame implements ActionListener {
> private Button playbtn, stopbtn;
> private AudioStream audio = null;
> Image img;
> ImageIcon ico;

> public void paintComponent(Graphics g)	{
> > Image image = new ImageIcon("Tree.jpg").getImage();
> > g.drawImage(image,3,4,this);

> }

> public static void main(String[.md](.md) args)	{
> > new JongHa\_1();

> }

> public void actionPerformed(ActionEvent e)	{
> > if(e.getSource() == playbtn)	{
> > > play();

> > }
> > else if(e.getSource() == stopbtn)	{
> > > stop();

> > }
> > }

> public void play()	{
> > try	{
> > > System.out.println("Play");
> > > String Filename = "C:\\MC2.wav";


> InputStream in = new FileInputStream(Filename);
> audio = new AudioStream(in);
> AudioPlayer.player.start(audio);

> } catch(Exception ex)	{
> > ex.printStackTrace();

> }
> }
> public void stop()	{
> > System.out.println("Stop");
> > if(audio != null)	{
> > > AudioPlayer.player.stop(audio);
> > > audio = null;

> > }
> > }

> public void paint(Graphics g)
> > {
> > > if (img != null)
> > > > g.drawImage(img, 10, 0, this);

> > }


> public JongHa\_1()	{
> > super("PlayMusic");
> > playbtn = new Button("Play");
> > stopbtn = new Button("Stop");
> > Panel pane = new Panel();
> > pane.add(playbtn);
> > pane.add(stopbtn);
> > playbtn.addActionListener(this);
> > stopbtn.addActionListener(this);
> > img = Toolkit.getDefaultToolkit().getImage("tree.jpg");
> > this.add(pane, "South");
> > this.setSize(200,240);
> > this.setVisible(true);
> > this.addWindowListener(new WindowAdapter()
> > > {
> > > > public void windowClosing(WindowEvent evt)
> > > > {
> > > > > dispose();
> > > > > System.exit(0);

> > > > }

> > });

> }
}


//오디오 스트림 출처 :http://cafe.naver.com/javacircle
그 외 나머지 ... 교재 ?? 그그.. 자바책 이름이 머더라..