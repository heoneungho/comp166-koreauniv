import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
public class JNotePad extends JFrame{
 
 private JTextPane _textPane;
 private ActionMap _actionMap = new ActionMap();
 private boolean _isSaved = true;
 private JFileChooser _fc = new JFileChooser(".");
 private File _file = null;
 
public JNotePad(){
 super("JNotePad");
  _textPane = new JTextPane();
  _textPane.getDocument().addDocumentListener(new DocumentListener(){
   public void insertUpdate(DocumentEvent e){
    _isSaved = false;
   }
   public void removeUpdate(DocumentEvent e){
    _isSaved = false;
   }
   public void changedUpdate(DocumentEvent e){
    _isSaved = false;
   }
  });
  JScrollPane p = new JScrollPane(_textPane);
  add(p);
  _actionMap = createActionMap();
  setJMenuBar(createMenuBar());
  add(createToolBar(), BorderLayout.NORTH);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 
private ActionMap createActionMap(){
 ActionMap am = new ActionMap();
 am.put("new", new NewAction());
 am.put("open", new OpenAction());

 return am;
}
 
private JMenuBar createMenuBar(){
 JMenuBar menubar = new JMenuBar();
 
 //File
 JMenu m = new JMenu("file");
 m.setMnemonic(KeyEvent.VK_F);
 m.add(new JMenuItem(_actionMap.get("new")));
 m.add(new JMenuItem(_actionMap.get("open")));
 m.add(new JMenuItem(_actionMap.get("save")));
 m.add(new JMenuItem(_actionMap.get("save as")));
 m.addSeparator();
 m.add(new JMenuItem(_actionMap.get("close")));
 menubar.add(m);
 
 
 return menubar;
}
 
private JToolBar createToolBar(){
 JToolBar toolbar = new JToolBar();
 toolbar.add(new JButton(_actionMap.get("new")));
 toolbar.add(new JButton(_actionMap.get("open")));

 toolbar.addSeparator();
 

 Component[] comps = toolbar.getComponents();
 for(int i = 0; i < comps.length; i++){
  if(comps[i] instanceof JButton)
   comps[i].setFocusable(false);
 }
 return toolbar;
}
 
private boolean confirmSave(){
 if(_isSaved)
  return true;
 int ret = JOptionPane.showConfirmDialog(
   this,
    "Content had been modified. Save changes?",
    "JNotePad",
    JOptionPane.YES_NO_CANCEL_OPTION);
  switch(ret){
   case JOptionPane.YES_OPTION :
    return save();
   case JOptionPane.NO_OPTION :
    return true;
   default :
    return false;
  }
}
 
private boolean open(){
 if(_fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
  File file = _fc.getSelectedFile();
 try{
  open(file);
  _file = file;
  setTitle(file.getName() + " - JNotePad");
  return true;
   }catch(IOException e){
    JOptionPane.showMessageDialog(
      this,
      "Could not open file " + file,
      "JNotePad",
      JOptionPane.ERROR_MESSAGE);
     }
  }
  return false;
}
 
private void open(File file) throws IOException{
 BufferedReader r = new BufferedReader(new FileReader(file));
 StringBuffer sbuf = new StringBuffer();
 char[] buf = new char[1024];
 int nread;
 
 while((nread = r.read(buf)) != -1){
  sbuf.append(buf, 0, nread);
 }
 r.close();
 _textPane.setText(sbuf.toString());
}
 
private boolean save(){
 if(_file == null)
  return saveAs();
 else
  try{
   save(_file);
   return true;
  }catch(IOException e){
   showSaveErrorMessage();
  }
   return false;
}
 
private void showSaveErrorMessage(){
 String[] mesg = {
    "Could not save file: " + _file,
    "Access denied."
 };

 JOptionPane.showMessageDialog(
   this,
   mesg,
   "JNotePad",
   JOptionPane.ERROR_MESSAGE);
}
 
public boolean saveAs(){
 if(_fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
  File file = _fc.getSelectedFile();
 try{
  save(file);
  _file = file;
  setTitle(_file.getName() + " - JNotePad");
  return true;
 
 }catch(IOException e){
  showSaveErrorMessage();
  return false;
 }
 }
 return false;
}
 
private void save(File file) throws IOException{
 BufferedWriter w = new BufferedWriter(new FileWriter(file));
 w.write(_textPane.getText());
 w.close();
}
 
private class NewAction extends AbstractAction{
 public NewAction(){
  super("new");
  putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl N"));
  putValue(Action.MNEMONIC_KEY, KeyEvent.VK_N);
  putValue(Action.SMALL_ICON, new ImageIcon("new.gif"));
 
 }
 
 public void actionPerformed(ActionEvent e){
 System.out.println(getValue(Action.NAME));
 if(!confirmSave())
  return;
  _textPane.setText("");
  _isSaved = true;
   }
}
 
private class OpenAction extends AbstractAction{
 public OpenAction(){
  super("open");


 }

 public void actionPerformed(ActionEvent e){
  System.out.println(getValue(Action.NAME));
  if(!confirmSave())
   return;
   _isSaved = open();
 }
}
 
 
private void start(){
 setSize(600,450);
 setLocation(150,150);
 setVisible(true);
}
 
public static void main(String[] args){
 new JNotePad().start();
}
}