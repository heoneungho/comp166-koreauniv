import java.io.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SwingNotepad extends JFrame implements ActionListener {
  // ��� ���� ����
  JTextArea ta; // ������ �� �ִ� ���� �� �Է¶�
  JMenuBar menubar; // �޴���
  JMenu fileMenu, editMenu, fontMenu, helpMenu; // ���� �޴�, ���� �޴�
  JMenuItem newItem, openItem, saveItem, saveAsItem, exitItem;// �޴�������
  JMenuItem cancelItem, cutItem, copyItem, pasteItem, dateItem, allItem;
  JMenuItem  fontItem;
  JMenuItem  infoItem;

  //  ������ ����
  public SwingNotepad() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// X Ŭ�� => ����
    setTitle("2011190717 �������� MemoPad");// ����
    ta = new JTextArea();// ta ����
    JScrollPane scroll = new JScrollPane(ta);// ��ũ�ѿ� ta �� �ִ´�.
    add(scroll);// ��ũ���� �������� �߾ӿ� ���δ�.
    // getContentPane().add(scroll); // JDK 1.4�� ����� �ڵ�
    menubar = new JMenuBar();// �޴��� ����
    setJMenuBar(menubar);// �޴��ٸ� ���δ�.
    fileMenu = new JMenu("File");
    menubar.add(fileMenu);// �޴��ٿ� ���� �޴� ���̱�
    newItem = new JMenuItem("New");
    openItem = new JMenuItem("Open");
    saveItem = new JMenuItem("Save");
    saveAsItem = new JMenuItem("Save As");
    exitItem = new JMenuItem("Exit");
    fileMenu.add(newItem);
    fileMenu.add(openItem);
    fileMenu.add(saveItem);
    fileMenu.add(saveAsItem);
    fileMenu.addSeparator();// ���м� �ֱ�
    fileMenu.add(exitItem);
    newItem.addActionListener(this); // ������ ���̱�
    openItem.addActionListener(this);
    saveItem.addActionListener(this);
    saveAsItem.addActionListener(this);
    exitItem.addActionListener(this);
    editMenu = new JMenu("Edit");// ���� �޴� ����
    menubar.add(editMenu);// �޴��ٿ� ���� �޴� ���̱�
    copyItem = new JMenuItem("Copy");
    cutItem = new JMenuItem("Cut");
    pasteItem = new JMenuItem("Paste");
    allItem = new JMenuItem("All");
    dateItem = new JMenuItem("Date");
    cancelItem = new JMenuItem("Cancel");
    editMenu.add(cancelItem);
    editMenu.add(copyItem);
    editMenu.add(cutItem);
    editMenu.add(pasteItem);
    editMenu.add(allItem);
    editMenu.add(dateItem);
    cancelItem.addActionListener(this);
    copyItem.addActionListener(this); // ������ ���̱�
    cutItem.addActionListener(this);
    pasteItem.addActionListener(this);
    allItem.addActionListener(this);
    dateItem.addActionListener(this);
    fontMenu = new JMenu("Font");
    menubar.add(fontMenu);
    fontItem = new JMenuItem("Font");
    fontMenu.add(fontItem);
    fontItem.addActionListener(this);
    helpMenu = new JMenu("Help");
    menubar.add(helpMenu);
    infoItem = new JMenuItem("Info");
    helpMenu.add(infoItem);
    infoItem.addActionListener(this);
    setBounds(300, 300, 600, 400);// ũ�� ����(x ��ǥ, y ��ǥ, ����, ����)
    setVisible(true);// ���̱�
  }// ������

  // �̺�Ʈ ó��
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == exitItem) {
      System.exit(0); // ���α׷� ����
    }
    if (obj == newItem) {
      ta.setText(""); // ta �� �����.
    }
    if (obj == openItem) {
      openFile(); // ���� ���� �޼ҵ� ȣ��
    }// if
    if (obj == saveItem) {
      saveFile(); // ���� ���� �޼ҵ� ȣ��
    }// if
    if (obj == copyItem) { // �����ϱ� ���ý�
      ta.copy();
      copyItem.setEnabled(false);
      cutItem.setEnabled(false);
    }// if
    if (obj == cutItem) {
      ta.cut();
      copyItem.setEnabled(false);
      cutItem.setEnabled(false);
    }// if
    if (obj == pasteItem) {
      ta.paste();
      copyItem.setEnabled(true);
      cutItem.setEnabled(true);
    }// if
    if (obj == allItem) {
      ta.selectAll(); // ��� ����
    }// if
    if (obj == dateItem) {
      java.util.Date date = new java.util.Date();
      ta.append(date.toLocaleString());// ������ ��¥/�ð� �߰�
    }// if
  }// actionPerformed

  private void openFile() {  //  ���� ����
    JFileChooser chooser = new JFileChooser();
    int returnVal = chooser.showOpenDialog(this);// ���� ��ȭ����
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      File file = chooser.getSelectedFile();
      System.out.println(file.getName() + "���õ�");
      // �� �κ��� I/O ���� �� ����^^
      BufferedReader br = null;
      try {
        br = new BufferedReader(new FileReader(file));
        String text = "";
        while ((text = br.readLine()) != null) {
          ta.append(text + "\r\n");// �ٹٲ�( Win : \r\n, Unix : \n )
        }// while
        br.close();
      } catch (Exception e) {
        e.printStackTrace();// ���� �޽��� �ڼ��� ���
      }// catch
    }// if
  }// openFile

  private void saveFile() {  //  ���� ����
    JFileChooser chooser = new JFileChooser();
    int returnVal = chooser.showSaveDialog(this);// ���� ��ȭ����
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      File file = chooser.getSelectedFile();
      System.out.println(file.getName() + "���õ�");
      BufferedWriter bw = null;
      try {
        bw = new BufferedWriter(new FileWriter(file));
        bw.write(ta.getText());// ta ���� �о ���Ͽ� ����
        bw.flush();// ��� ����
        bw.close();// �ݱ�
      } catch (Exception e) {
        e.printStackTrace();// ���� �޽��� �ڼ��� ���
      }// catch
    }// if
  }// saveFile

  public static void main(String[] args) {
    new SwingNotepad();
  }// main
}// end