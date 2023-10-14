package GameScreen;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Base.Dice;
import Base.Player;
import Base.Scoreboard;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class GameScreen extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JScrollPane scrollPane;
    ImageIcon icon;
    ImageIcon Turnicon = new ImageIcon(GameScreen.class.getResource("/image/turnO.png"));
    ImageIcon Ione =new ImageIcon(GameScreen.class.getResource("/image/one.png"));
    ImageIcon Itwo =new ImageIcon(GameScreen.class.getResource("/image/two.png"));
    ImageIcon Ithree =new ImageIcon(GameScreen.class.getResource("/image/three.png"));
    ImageIcon Ifour =new ImageIcon(GameScreen.class.getResource("/image/four.png"));
    ImageIcon Ifive =new ImageIcon(GameScreen.class.getResource("/image/five.png"));
    ImageIcon Isix =new ImageIcon(GameScreen.class.getResource("/image/six.png"));
    ImageIcon IcheckO =new ImageIcon(GameScreen.class.getResource("/image/checkO.png"));
    ImageIcon IcheckX =new ImageIcon(GameScreen.class.getResource("/image/checkX.png"));
    ImageIcon Ibutton =new ImageIcon(GameScreen.class.getResource("/image/button.png"));
	private JButton btnRoll;
	private JLabel lblNewLabel;
	private JLabel Aces_A;private JLabel Aces_B;	private JLabel Deuces_A;private JLabel Deuces_B;
	private JLabel Threes_A;private JLabel Threes_B;	private JLabel Fours_A;private JLabel Fours_B;
	private JLabel Fives_A;	private JLabel Fives_B;	private JLabel Sixes_A;	private JLabel Sixes_B;
	private JLabel Choice_A;	private JLabel Choice_B;	private JLabel FourOK_A;	private JLabel FourOK_B;
	private JLabel FullHouse_A;	private JLabel FullHouse_B;private JLabel Yacht_A;private JLabel Yacht_B;
	private JLabel S_Straight_A;private JLabel S_Straight_B;private JLabel L_Straight_A;private JLabel L_Straight_B;	
	private JLabel Total_A;private JLabel Total_B;
	private JButton bAces_A;private JButton bAces_B;	private JButton bDeuces_A;private JButton bDeuces_B;
	private JButton bThrees_A;private JButton bThrees_B;	private JButton bFours_A;private JButton bFours_B;
	private JButton bFives_A;	private JButton bFives_B;	private JButton bSixes_A;	private JButton bSixes_B;
	private JButton bChoice_A;	private JButton bChoice_B;	private JButton bFourOK_A;	private JButton bFourOK_B;
	private JButton bFullHouse_A;	private JButton bFullHouse_B;private JButton bYacht_A;private JButton bYacht_B;
	private JButton bS_Straight_A;private JButton bS_Straight_B;private JButton bL_Straight_A;private JButton bL_Straight_B;	
	
	private JCheckBox[] btndice = new JCheckBox[5];
	private JLabel[] diceimage = new JLabel[5];
	
	private Dice dice = new Dice();
	private Player player_A = new Player(1);
	private Player player_B = new Player(2);
	private Scoreboard Score_A = new Scoreboard(player_A);
	private Scoreboard Score_B = new Scoreboard(player_B);
	private int t_time = 3;
	private boolean turn = true;
	private int turn_num = 1;
	private JLabel lblturn;
	private JLabel lblAturn;
	private JLabel lblBturn;
	public GameScreen() {
        icon = new ImageIcon(GameScreen.class.getResource("/image/dicegame.png"));  
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
		lblinit();		
		bg.add(btnRoll);
		
        scrollPane = new JScrollPane(bg);       
        
        lblNewLabel = new JLabel(icon);
        lblNewLabel.setBounds(0, 0, 786, 563);
        
        lblNewLabel.add(Aces_A); lblNewLabel.add(Deuces_A); lblNewLabel.add(Threes_A);
        lblNewLabel.add(Fours_A); lblNewLabel.add(Fives_A); lblNewLabel.add(Sixes_A);
        lblNewLabel.add(Choice_A); lblNewLabel.add(FourOK_A); lblNewLabel.add(FullHouse_A);
        lblNewLabel.add(S_Straight_A); lblNewLabel.add(L_Straight_A); lblNewLabel.add(Yacht_A);
        lblNewLabel.add(Total_A);
        
        lblNewLabel.add(Aces_B); lblNewLabel.add(Deuces_B); lblNewLabel.add(Threes_B);
        lblNewLabel.add(Fours_B); lblNewLabel.add(Fives_B); lblNewLabel.add(Sixes_B);
        lblNewLabel.add(Choice_B); lblNewLabel.add(FourOK_B); lblNewLabel.add(FullHouse_B);
        lblNewLabel.add(S_Straight_B); lblNewLabel.add(L_Straight_B); lblNewLabel.add(Yacht_B);
        lblNewLabel.add(Total_B);
        
        lblNewLabel.add(bAces_A); lblNewLabel.add(bDeuces_A); lblNewLabel.add(bThrees_A);
        lblNewLabel.add(bFours_A); lblNewLabel.add(bFives_A); lblNewLabel.add(bSixes_A);
        lblNewLabel.add(bChoice_A); lblNewLabel.add(bFourOK_A); lblNewLabel.add(bFullHouse_A);
        lblNewLabel.add(bS_Straight_A); lblNewLabel.add(bL_Straight_A); lblNewLabel.add(bYacht_A);
        
        lblNewLabel.add(bAces_B); lblNewLabel.add(bDeuces_B); lblNewLabel.add(bThrees_B);
        lblNewLabel.add(bFours_B); lblNewLabel.add(bFives_B); lblNewLabel.add(bSixes_B);
        lblNewLabel.add(bChoice_B); lblNewLabel.add(bFourOK_B); lblNewLabel.add(bFullHouse_B);
        lblNewLabel.add(bS_Straight_B); lblNewLabel.add(bL_Straight_B); lblNewLabel.add(bYacht_B);
        
        lblNewLabel.add(btndice[0]); lblNewLabel.add(btndice[1]); lblNewLabel.add(btndice[2]); lblNewLabel.add(btndice[3]); lblNewLabel.add(btndice[4]);
        lblNewLabel.add(diceimage[0]); lblNewLabel.add(diceimage[1]); lblNewLabel.add(diceimage[2]); lblNewLabel.add(diceimage[3]); lblNewLabel.add(diceimage[4]);
        lblturn = new JLabel(turn_num+"/12");
        lblturn.setBounds(538, 117, 63, 63);
        lblturn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 25));
        lblturn.setHorizontalAlignment(JLabel.CENTER);
        lblAturn = new JLabel(Turnicon);
        lblAturn.setBounds(203, 24, 30, 30);
        lblNewLabel.add(lblAturn);
        
        lblBturn = new JLabel(Turnicon);
        lblBturn.setBounds(282, 24, 30, 30);
        lblBturn.setVisible(false);
        lblNewLabel.add(lblBturn);
        
        
        lblNewLabel.add(lblturn);
        
        bg.add(lblNewLabel);
        
        
        
        
        
        
        setContentPane(scrollPane);
		
		addListeners();
		showFrame();
	}
	
	public void init() {
		btnRoll = new JButton();
		btnRoll.setBounds(461, 392, 204, 70);
        btnRoll.setBorderPainted(false);
        btnRoll.setContentAreaFilled(false);
        
        bAces_A = new JButton(Ibutton);
        bAces_A.setBounds(193, 61, 50, 30);
        bAces_A.setBorderPainted(false);
        bAces_A.setContentAreaFilled(false);
        bAces_B = new JButton(Ibutton);
        bAces_B.setBounds(275, 61, 50, 30);
        bAces_B.setBorderPainted(false);
        bAces_B.setContentAreaFilled(false);
                
        bDeuces_A = new JButton(Ibutton);
        bDeuces_A.setBounds(193, 97, 50, 30); 
        bDeuces_A.setBorderPainted(false);
        bDeuces_A.setContentAreaFilled(false);
        bDeuces_B = new JButton(Ibutton);
        bDeuces_B.setBounds(275, 97, 50, 30);
        bDeuces_B.setBorderPainted(false);
        bDeuces_B.setContentAreaFilled(false);
        
        bThrees_A = new JButton(Ibutton);
        bThrees_A.setBounds(193, 132, 50, 30);
        bThrees_A.setBorderPainted(false);
        bThrees_A.setContentAreaFilled(false);
        bThrees_B = new JButton(Ibutton);
        bThrees_B.setBounds(275, 132, 50, 30);
        bThrees_B.setBorderPainted(false);
        bThrees_B.setContentAreaFilled(false);
               
        bFours_A = new JButton(Ibutton);
        bFours_A.setBounds(193, 168, 50, 30);
        bFours_A.setBorderPainted(false);
        bFours_A.setContentAreaFilled(false);
        bFours_B = new JButton(Ibutton);
        bFours_B.setBounds(275, 168, 50, 30);
        bFours_B.setBorderPainted(false);
        bFours_B.setContentAreaFilled(false);
        
        bFives_A = new JButton(Ibutton);
        bFives_A.setBounds(193, 203, 50, 30);
        bFives_A.setBorderPainted(false);
        bFives_A.setContentAreaFilled(false);
        bFives_B = new JButton(Ibutton);
        bFives_B.setBounds(275, 203, 50, 30);
        bFives_B.setBorderPainted(false);
        bFives_B.setContentAreaFilled(false);
                
        bSixes_A = new JButton(Ibutton);
        bSixes_A.setBounds(193, 238, 50, 30);   
        bSixes_A.setBorderPainted(false);
        bSixes_A.setContentAreaFilled(false);
        bSixes_B = new JButton(Ibutton);
        bSixes_B.setBounds(275, 238, 50, 30);
        bSixes_B.setBorderPainted(false);
        bSixes_B.setContentAreaFilled(false);
        
        bChoice_A = new JButton(Ibutton);
        bChoice_A.setBounds(193, 273, 50, 30);
        bChoice_A.setBorderPainted(false);
        bChoice_A.setContentAreaFilled(false);
        bChoice_B = new JButton(Ibutton);
        bChoice_B.setBounds(275, 273, 50, 30);  
        bChoice_B.setBorderPainted(false);
        bChoice_B.setContentAreaFilled(false);
        
        bFourOK_A = new JButton(Ibutton);
        bFourOK_A.setBounds(193, 317, 50, 30); 
        bFourOK_A.setBorderPainted(false);
        bFourOK_A.setContentAreaFilled(false);
        bFourOK_B = new JButton(Ibutton);
        bFourOK_B.setBounds(275, 317, 50, 30); 
        bFourOK_B.setBorderPainted(false);
        bFourOK_B.setContentAreaFilled(false);
        
        bFullHouse_A = new JButton(Ibutton);
        bFullHouse_A.setBounds(193, 353, 50, 30);    
        bFullHouse_A.setBorderPainted(false);
        bFullHouse_A.setContentAreaFilled(false);
        bFullHouse_B = new JButton(Ibutton);
        bFullHouse_B.setBounds(275, 353, 50, 30);    
        bFullHouse_B.setBorderPainted(false);
        bFullHouse_B.setContentAreaFilled(false);
        
        bS_Straight_A = new JButton(Ibutton);
        bS_Straight_A.setBounds(193, 389, 50, 30);
        bS_Straight_A.setBorderPainted(false);
        bS_Straight_A.setContentAreaFilled(false);
        bS_Straight_B = new JButton(Ibutton);
        bS_Straight_B.setBounds(275, 389, 50, 30);
        bS_Straight_B.setBorderPainted(false);
        bS_Straight_B.setContentAreaFilled(false);
        
        bL_Straight_A = new JButton(Ibutton);
        bL_Straight_A.setBounds(193, 423, 50, 30);
        bL_Straight_A.setBorderPainted(false);
        bL_Straight_A.setContentAreaFilled(false);
        bL_Straight_B = new JButton(Ibutton);
        bL_Straight_B.setBounds(275, 423, 50, 30);
        bL_Straight_B.setBorderPainted(false);
        bL_Straight_B.setContentAreaFilled(false);
        
        bYacht_A = new JButton(Ibutton);
        bYacht_A.setBounds(193, 458, 50, 30);
        bYacht_A.setBorderPainted(false);
        bYacht_A.setContentAreaFilled(false);
        bYacht_B = new JButton(Ibutton);
        bYacht_B.setBounds(275, 458, 50, 30);
        bYacht_B.setBorderPainted(false);
        bYacht_B.setContentAreaFilled(false);
       
        diceimage[0] = new JLabel(Ione);
        diceimage[0].setBounds(387, 250, 63, 63);
      
        diceimage[1] = new JLabel(Ione);
        diceimage[1].setBounds(460, 250, 63, 63);
        
        diceimage[2] = new JLabel(Ione);
        diceimage[2].setBounds(532, 250, 63, 63);
            
        diceimage[3] = new JLabel(Ione);
        diceimage[3].setBounds(605, 250, 63, 63);
                
        diceimage[4] = new JLabel(Ione);
        diceimage[4].setBounds(677, 250, 63, 63);
        
        
        btndice[0] = new JCheckBox(IcheckX);
        btndice[0].setSelectedIcon(IcheckO);
        btndice[0].setBounds(387, 250, 63, 63);
        btndice[0].setBorderPainted(false);
        btndice[0].setContentAreaFilled(false);
      
        btndice[1] = new JCheckBox(IcheckX);
        btndice[1].setSelectedIcon(IcheckO);
        btndice[1].setBounds(460, 250, 63, 63);
        btndice[1].setBorderPainted(false);
        btndice[1].setContentAreaFilled(false);
        
        btndice[2] = new JCheckBox(IcheckX);
        btndice[2].setSelectedIcon(IcheckO);
        btndice[2].setBounds(532, 250, 63, 63);
        btndice[2].setBorderPainted(false);
        btndice[2].setContentAreaFilled(false);
            
        btndice[3] = new JCheckBox(IcheckX);
        btndice[3].setSelectedIcon(IcheckO);
        btndice[3].setBounds(605, 250, 63, 63);
        btndice[3].setBorderPainted(false);
        btndice[3].setContentAreaFilled(false);
                
        btndice[4] = new JCheckBox(IcheckX);
        btndice[4].setSelectedIcon(IcheckO);
        btndice[4].setBounds(677, 250, 63, 63);
        btndice[4].setBorderPainted(false);
        btndice[4].setContentAreaFilled(false);
        
	}
	
	public void lblinit() {
        Aces_A = new JLabel(String.valueOf(Score_A.getOnes()));
        Aces_A.setBounds(193, 61, 50, 30);
        Aces_A.setHorizontalAlignment(JLabel.CENTER);
        Aces_B = new JLabel(String.valueOf(Score_B.getOnes()));
        Aces_B.setBounds(275, 61, 50, 30);
        Aces_B.setHorizontalAlignment(JLabel.CENTER);
        
        Deuces_A = new JLabel(String.valueOf(Score_A.getTwos()));
        Deuces_A.setBounds(193, 97, 50, 30);
        Deuces_A.setHorizontalAlignment(JLabel.CENTER);
        Deuces_B = new JLabel(String.valueOf(Score_B.getTwos()));
        Deuces_B.setBounds(275, 97, 50, 30);
        Deuces_B.setHorizontalAlignment(JLabel.CENTER);
        
        Threes_A = new JLabel(String.valueOf(Score_A.getThrees()));
        Threes_A.setBounds(193, 132, 50, 30);
        Threes_A.setHorizontalAlignment(JLabel.CENTER);
        Threes_B = new JLabel(String.valueOf(Score_B.getThrees()));
        Threes_B.setBounds(275, 132, 50, 30);
        Threes_B.setHorizontalAlignment(JLabel.CENTER);
               
        Fours_A = new JLabel(String.valueOf(Score_A.getFours()));
        Fours_A.setBounds(193, 168, 50, 30);
        Fours_A.setHorizontalAlignment(JLabel.CENTER);
        Fours_B = new JLabel(String.valueOf(Score_B.getFours()));
        Fours_B.setBounds(275, 168, 50, 30);
        Fours_B.setHorizontalAlignment(JLabel.CENTER);
        
        Fives_A = new JLabel(String.valueOf(Score_A.getFives()));
        Fives_A.setBounds(193, 203, 50, 30);
        Fives_A.setHorizontalAlignment(JLabel.CENTER);
        Fives_B = new JLabel(String.valueOf(Score_B.getFives()));
        Fives_B.setBounds(275, 203, 50, 30);
        Fives_B.setHorizontalAlignment(JLabel.CENTER);
                
        Sixes_A = new JLabel(String.valueOf(Score_A.getSixes()));
        Sixes_A.setBounds(193, 238, 50, 30); 
        Sixes_A.setHorizontalAlignment(JLabel.CENTER);
        Sixes_B = new JLabel(String.valueOf(Score_B.getSixes()));
        Sixes_B.setBounds(275, 238, 50, 30);
        Sixes_B.setHorizontalAlignment(JLabel.CENTER);
        
        Choice_A = new JLabel(String.valueOf(Score_A.getChoice()));
        Choice_A.setBounds(193, 273, 50, 30);
        Choice_A.setHorizontalAlignment(JLabel.CENTER);
        Choice_B = new JLabel(String.valueOf(Score_B.getChoice()));
        Choice_B.setBounds(275, 273, 50, 30);       
        Choice_B.setHorizontalAlignment(JLabel.CENTER);
        
        FourOK_A = new JLabel(String.valueOf(Score_A.getFourOfaKind()));
        FourOK_A.setBounds(193, 317, 50, 30); 
        FourOK_A.setHorizontalAlignment(JLabel.CENTER);
        FourOK_B = new JLabel(String.valueOf(Score_B.getFourOfaKind()));
        FourOK_B.setBounds(275, 317, 50, 30);    
        FourOK_B.setHorizontalAlignment(JLabel.CENTER);
        
        FullHouse_A = new JLabel(String.valueOf(Score_A.getFullHouse()));
        FullHouse_A.setBounds(193, 353, 50, 30);
        FullHouse_A.setHorizontalAlignment(JLabel.CENTER);
        FullHouse_B = new JLabel(String.valueOf(Score_B.getFullHouse()));
        FullHouse_B.setBounds(275, 353, 50, 30);    
        FullHouse_B.setHorizontalAlignment(JLabel.CENTER);
        
        S_Straight_A = new JLabel(String.valueOf(Score_A.getLittleStraight()));
        S_Straight_A.setBounds(193, 389, 50, 30);
        S_Straight_A.setHorizontalAlignment(JLabel.CENTER);
        S_Straight_B = new JLabel(String.valueOf(Score_B.getLittleStraight()));
        S_Straight_B.setBounds(275, 389, 50, 30);
        S_Straight_B.setHorizontalAlignment(JLabel.CENTER);
        
        L_Straight_A = new JLabel(String.valueOf(Score_A.getBigStrainght()));
        L_Straight_A.setBounds(193, 423, 50, 30);
        L_Straight_A.setHorizontalAlignment(JLabel.CENTER);
        L_Straight_B = new JLabel(String.valueOf(Score_B.getBigStrainght()));
        L_Straight_B.setBounds(275, 423, 50, 30);
        L_Straight_B.setHorizontalAlignment(JLabel.CENTER);
        
        Yacht_A = new JLabel(String.valueOf(Score_A.getYacht()));
        Yacht_A.setBounds(193, 458, 50, 30);
        Yacht_A.setHorizontalAlignment(JLabel.CENTER);
        Yacht_B = new JLabel(String.valueOf(Score_B.getYacht()));
        Yacht_B.setBounds(275, 458, 50, 30);
        Yacht_B.setHorizontalAlignment(JLabel.CENTER);
        
        Total_A = new JLabel(String.valueOf(player_A.getScore()));
        Total_A.setBounds(193, 511, 50, 30);
        Total_A.setHorizontalAlignment(JLabel.CENTER);
        Total_B = new JLabel(String.valueOf(player_B.getScore()));
        Total_B.setBounds(275, 511, 50, 30);
        Total_B.setHorizontalAlignment(JLabel.CENTER);
        
        diceimage[0] = new JLabel(Ione);
        diceimage[0].setBounds(387, 250, 63, 63);
      
        diceimage[1] = new JLabel(Ione);
        diceimage[1].setBounds(460, 250, 63, 63);
        
        diceimage[2] = new JLabel(Ione);
        diceimage[2].setBounds(532, 250, 63, 63);
            
        diceimage[3] = new JLabel(Ione);
        diceimage[3].setBounds(605, 250, 63, 63);
                
        diceimage[4] = new JLabel(Ione);
        diceimage[4].setBounds(677, 250, 63, 63);
	}
    public void addListeners() {

        btnRoll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if(turn == true && t_time>0) {
            		t_time --;
            		Rolldice();
            		if(bAces_A.isVisible()) {Score_A.setOnes(dice); Aces_A.setText(""+Score_A.getOnes());}
            		if(bDeuces_A.isVisible()) {Score_A.setTwos(dice);Deuces_A.setText(""+Score_A.getTwos());}            		
            		if(bThrees_A.isVisible()) {Score_A.setThrees(dice);Threes_A.setText(""+Score_A.getThrees());}
            		if(bFours_A.isVisible()) {Score_A.setFours(dice);Fours_A.setText(""+Score_A.getFours());}
            		if(bFives_A.isVisible()) {Score_A.setFives(dice);Fives_A.setText(""+Score_A.getFives());}
            		if(bSixes_A.isVisible()) {Score_A.setSixes(dice);Sixes_A.setText(""+Score_A.getSixes());}
            		if(bFourOK_A.isVisible()) {Score_A.setFourOfaKind(dice);FourOK_A.setText(""+Score_A.getFourOfaKind());}
            		if(bFullHouse_A.isVisible()) {Score_A.setFullHouse(dice);FullHouse_A.setText(""+Score_A.getFullHouse()); }
            		if(bS_Straight_A.isVisible()) {Score_A.setLittleStraight(dice);S_Straight_A.setText(""+Score_A.getLittleStraight());}
            		if(bL_Straight_A.isVisible()) {Score_A.setBigStrainght(dice); L_Straight_A.setText(""+Score_A.getBigStrainght());}
            		if(bYacht_A.isVisible()) {Score_A.setYacht(dice);Yacht_A.setText(""+Score_A.getYacht());}
            		if(bChoice_A.isVisible()) {Score_A.setChoice(dice);Choice_A.setText(""+Score_A.getChoice());}
            		JOptionPane.showMessageDialog(GameScreen.this, "주사위를 굴릴 기회가 " + t_time+"번 남았습니다.", "남은 횟수",JOptionPane.PLAIN_MESSAGE );
            	}
            	else if(turn == false && t_time>0) {
            		t_time --;
            		Rolldice();
            		if(bAces_B.isVisible()) {Score_B.setOnes(dice); Aces_B.setText(""+Score_B.getOnes());}
            		if(bDeuces_B.isVisible()) {Score_B.setTwos(dice);Deuces_B.setText(""+Score_B.getTwos());}            		
            		if(bThrees_B.isVisible()) {Score_B.setThrees(dice);Threes_B.setText(""+Score_B.getThrees());}
            		if(bFours_B.isVisible()) {Score_B.setFours(dice);Fours_B.setText(""+Score_B.getFours());}
            		if(bFives_B.isVisible()) {Score_B.setFives(dice);Fives_B.setText(""+Score_B.getFives());}
            		if(bSixes_B.isVisible()) {Score_B.setSixes(dice);Sixes_B.setText(""+Score_B.getSixes());}
            		if(bFourOK_B.isVisible()) {Score_B.setFourOfaKind(dice);FourOK_B.setText(""+Score_B.getFourOfaKind());}
            		if(bFullHouse_B.isVisible()) {Score_B.setFullHouse(dice);FullHouse_B.setText(""+Score_B.getFullHouse()); }
            		if(bS_Straight_B.isVisible()) {Score_B.setLittleStraight(dice);S_Straight_B.setText(""+Score_B.getLittleStraight());}
            		if(bL_Straight_B.isVisible()) {Score_B.setBigStrainght(dice); L_Straight_B.setText(""+Score_B.getBigStrainght());}
            		if(bYacht_B.isVisible()) {Score_B.setYacht(dice);Yacht_B.setText(""+Score_B.getYacht());}
            		if(bChoice_B.isVisible()) {Score_B.setChoice(dice);Choice_B.setText(""+Score_B.getChoice());}
            		JOptionPane.showMessageDialog(GameScreen.this, "주사위를 굴릴 기회가 " + t_time+"번 남았습니다.", "남은 횟수",JOptionPane.PLAIN_MESSAGE );
            	}
            	else if(t_time == 0) {
            		JOptionPane.showMessageDialog(GameScreen.this, "주사위를 모두 굴렸습니다.\n원하는 점수를 선택하세요.", "선택",JOptionPane.PLAIN_MESSAGE );
            	}
            }
        });

        bAces_A.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bAces_A.setVisible(false);
					player_A.setScore(Score_A.getOnes());
					Total_A.setText(""+player_A.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bDeuces_A.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bDeuces_A.setVisible(false);
					player_A.setScore(Score_A.getTwos());
					Total_A.setText(""+player_A.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bThrees_A.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bThrees_A.setVisible(false);
					player_A.setScore(Score_A.getThrees());
					Total_A.setText(""+player_A.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bFours_A.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bFours_A.setVisible(false);
					player_A.setScore(Score_A.getFours());
					Total_A.setText(""+player_A.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bFives_A.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bFives_A.setVisible(false);
					player_A.setScore(Score_A.getFives());
					Total_A.setText(""+player_A.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bSixes_A.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bSixes_A.setVisible(false);
					player_A.setScore(Score_A.getSixes());
					Total_A.setText(""+player_A.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bFourOK_A.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bFourOK_A.setVisible(false);
					player_A.setScore(Score_A.getFourOfaKind());
					Total_A.setText(""+player_A.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bFullHouse_A.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bFullHouse_A.setVisible(false);
					player_A.setScore(Score_A.getFullHouse());
					Total_A.setText(""+player_A.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bS_Straight_A.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bS_Straight_A.setVisible(false);
					player_A.setScore(Score_A.getLittleStraight());
					Total_A.setText(""+player_A.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bL_Straight_A.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bL_Straight_A.setVisible(false);
					player_A.setScore(Score_A.getBigStrainght());
					Total_A.setText(""+player_A.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bYacht_A.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bYacht_A.setVisible(false);
					player_A.setScore(Score_A.getYacht());
					Total_A.setText(""+player_A.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bChoice_A.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bChoice_A.setVisible(false);
					player_A.setScore(Score_A.getChoice());
					Total_A.setText(""+player_A.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        
        bAces_B.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bAces_B.setVisible(false);
					player_B.setScore(Score_B.getOnes());
					Total_B.setText(""+player_B.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bDeuces_B.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bDeuces_B.setVisible(false);
					player_B.setScore(Score_B.getTwos());
					Total_B.setText(""+player_B.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bThrees_B.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bThrees_B.setVisible(false);
					player_B.setScore(Score_B.getThrees());
					Total_B.setText(""+player_B.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bFours_B.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bFours_B.setVisible(false);
					player_B.setScore(Score_B.getFours());
					Total_B.setText(""+player_B.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bFives_B.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bFives_B.setVisible(false);
					player_B.setScore(Score_B.getFives());
					Total_B.setText(""+player_B.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bSixes_B.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bSixes_B.setVisible(false);
					player_B.setScore(Score_B.getSixes());
					Total_B.setText(""+player_B.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bFourOK_B.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bFourOK_B.setVisible(false);
					player_B.setScore(Score_B.getFourOfaKind());
					Total_B.setText(""+player_B.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bFullHouse_B.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bFullHouse_B.setVisible(false);
					player_B.setScore(Score_B.getFullHouse());
					Total_B.setText(""+player_B.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bS_Straight_B.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bS_Straight_B.setVisible(false);
					player_B.setScore(Score_B.getLittleStraight());
					Total_B.setText(""+player_B.getScore());
					nextTurn();
					} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bL_Straight_B.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bL_Straight_B.setVisible(false);
					player_B.setScore(Score_B.getBigStrainght());
					Total_B.setText(""+player_B.getScore());
					nextTurn();
				} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bYacht_B.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bYacht_B.setVisible(false);
					player_B.setScore(Score_B.getYacht());
					Total_B.setText(""+player_B.getScore());
					nextTurn();
				} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
        bChoice_B.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(GameScreen.this, "해당 점수를 선택하시겠습니까?", "점수 선택",JOptionPane.YES_NO_OPTION );
				if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
					bChoice_B.setVisible(false);
					player_B.setScore(Score_B.getChoice());
					Total_B.setText(""+player_B.getScore());
					nextTurn();
				} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
				}
				
			}
		});
      
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                		GameScreen.this,
                        "종료하시겠습니까?",
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
        setVisible(true);
    }
    
    public void setDiceimage(JLabel dice, int num) {
    	switch (num) {
		case 1:
			dice.setIcon(Ione);
			break;
		case 2:
			dice.setIcon(Itwo);
			break;
		case 3:
			dice.setIcon(Ithree);
			break;
		case 4:
			dice.setIcon(Ifour);
			break;
		case 5:
			dice.setIcon(Ifive);
			break;
		case 6:
			dice.setIcon(Isix);
			break;
		default:
			break;
		}
    }
    
    public void Rolldice() {
    	for(int i=0;i<5;i++) {
    		if(!btndice[i].isSelected()) {
    			dice.Roll_dice(i);
    			setDiceimage(diceimage[i], dice.getDice(i));
    		}
    	}
    }
    public void nextTurn() {		
		
		if(turn == false) {
			turn_num++;
			if(turn_num ==13) {
				JOptionPane.showMessageDialog(GameScreen.this, 
						player_A.getScore()>player_B.getScore()?"A":"B"+"가 승리했습니다.", "우승",JOptionPane.PLAIN_MESSAGE );
				int exit = JOptionPane.showConfirmDialog(GameScreen.this, "게임을 종료하시겠습니까?", "종료",JOptionPane.YES_NO_OPTION );
				if(exit == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				else {
				}
			}
			lblturn.setText(turn_num+"/12");
			lblAturn.setVisible(true);
			lblBturn.setVisible(false);
		}
		else {
			lblAturn.setVisible(false);
			lblBturn.setVisible(true);
		}
		t_time= 3;
		
		for(int i=0;i<5;i++) btndice[i].setSelected(false);
		turn = !turn;
    }
}
