package GameScreen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class StartScreen extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JScrollPane scrollPane;
    ImageIcon icon;
	private JButton btnStart;
	private JButton btnEnd;
	
	public StartScreen() {
        icon = new ImageIcon(StartScreen.class.getResource("/image/yatchdice.png"));
             
        JPanel bg = new JPanel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
                g.drawImage(icon.getImage(), 0, 0, null);
                setOpaque(false); 
                
            }
        };
        bg.setLayout(null);
		init();
				
		bg.add(btnStart);
		bg.add(btnEnd);
		
        scrollPane = new JScrollPane(bg);       
        setContentPane(scrollPane);
		
		addListeners();
		showFrame();
	}
	
	public void init() {
		btnStart = new JButton();
		btnStart.setBounds(288, 344, 204, 70);
        btnStart.setBorderPainted(false);
        btnStart.setContentAreaFilled(false);
        
        btnEnd = new JButton();
        btnEnd.setBounds(288, 434, 204, 70);
        btnEnd.setBorderPainted(false);
        btnEnd.setContentAreaFilled(false);
	}
    public void addListeners() {

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GameScreen();
            }
        });
        btnEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int choice = JOptionPane.showConfirmDialog(
                		StartScreen.this,
                        "게임을 종료하시겠습니까?",
                        "게임 종료",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );
                if (choice == JOptionPane.OK_OPTION) {               	
                	System.exit(0);
                }
                
            }
        });
    }
    public void showFrame() {
        setTitle("Yacth Dice");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
    }
   
    public static void main(String[] args) {
    	StartScreen Screen = new StartScreen();
    	Screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Screen.setVisible(true);
    }
}
