import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class MainFrame extends JFrame {

	private int FRAME_WIDTH=350;
	private int FRAME_HEIGHT=455;

	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem start;
	private JMenuItem help;
	private JMenuItem quit;

	private JPanel statusPanel;

	private JPanel buttonPanel;
	private JPanel timePanel;
	private JPanel numMinePanel;

	private JButton modeButton;
	private JLabel timeLabel;
	private JLabel numMineLabel;

	private MainComponent component;

	private int time=0;

    public MainFrame() {
    	setSize(FRAME_WIDTH, FRAME_HEIGHT);
    	setTitle("Mine");

    	component = new MainComponent();

    	Timer t = new Timer(1000, new TimeListener());
    	t.start();

		createMenuBar();
		createStatusPanel();

    	add(component, BorderLayout.CENTER);
    }

    private void createStatusPanel(){
    	statusPanel = new JPanel();

		buttonPanel = new JPanel();
		timePanel = new JPanel();
		numMinePanel = new JPanel();

		modeButton = new JButton("Change");
		modeButton.addActionListener(new ChangeModeListener());
		timeLabel = new JLabel(""+time);
		numMineLabel = new JLabel(""+component.getNumMines());

		buttonPanel.setBorder(new TitledBorder(new EtchedBorder(), "Mode"));
		buttonPanel.add(modeButton);
		timePanel.setBorder(new TitledBorder(new EtchedBorder(), "Time"));
		timePanel.add(timeLabel);
		numMinePanel.setBorder(new TitledBorder(new EtchedBorder(), "Mines"));
		numMinePanel.add(numMineLabel);

		statusPanel.setLayout(new GridLayout(1,3));
		statusPanel.add(buttonPanel);
		statusPanel.add(timePanel);
		statusPanel.add(numMinePanel);
		add(statusPanel, BorderLayout.SOUTH);
    }

    private void createMenuBar(){
    	menuBar = new JMenuBar();
		file = new JMenu("File");
    	start = new JMenuItem("Start");
    	start.addActionListener(new NewListener());
    	help = new JMenuItem("Help");
    	help.addActionListener(new HelpFrameListener());
    	quit = new JMenuItem("Quit");
    	quit.addActionListener(new QuitListener());
    	file.add(start);
    	file.add(help);
    	file.add(quit);
    	menuBar.add(file);
    	setJMenuBar(menuBar);
    }

    class ChangeModeListener implements ActionListener{
    	public void actionPerformed(ActionEvent event){
    		component.changeMode();
    	}
    }

    class TimeListener implements ActionListener{
    	public void actionPerformed(ActionEvent event){
    		time++;
    	}
    }

    class NewListener implements ActionListener{
    	public void actionPerformed(ActionEvent event){
    		setVisible(false);
    		JFrame frame = new MainFrame();
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setVisible(true);
    	}
    }

    class QuitListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.exit(0);
		}
	}

	class HelpFrameListener implements ActionListener{
    	public void actionPerformed(ActionEvent event){
    		JFrame helpFrame = new JFrame();
    		helpFrame.setSize(300, 300);
    		helpFrame.setTitle("Help");
			helpFrame.setVisible(true);
    	}
    }
}