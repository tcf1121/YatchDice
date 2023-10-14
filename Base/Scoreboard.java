package Base;


public class Scoreboard {
	private Player player;
	private int Ones;
	private int Twos;
	private int Threes;
	private int Fours;
	private int Fives;
	private int Sixes;
	private int FourOfaKind;
	private int FullHouse;
	private int LittleStraight;
	private int BigStrainght;
	private int Yacht;
	private int Choice;
	
	public Scoreboard(Player player) {
		setPlayer(player);
		this.Ones = 0;
		this.Twos = 0;
		this.Threes = 0;
		this.Fours = 0;
		this.Fives = 0;
		this.Sixes = 0;
		this.FourOfaKind = 0;
		this.FullHouse = 0;
		this.LittleStraight = 0;
		this.BigStrainght = 0;
		this.Yacht = 0;
		this.Choice = 0;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Player getPlayer() {
		return player;
	}
	public void setOnes(Dice dice) {
		this.Ones = 0;
		int set = 1;		
		for(int i=0;i<5;i++) {
			if(dice.getDice(i) == set) {
				this.Ones += set;
			}
		}
	}
	public int getOnes() {return Ones;	}
	
	public void setTwos(Dice dice) {
		this.Twos = 0;
		int set = 2;
		for(int i=0;i<5;i++) {
			if(dice.getDice(i) == set) {
				this.Twos += set;
			}
		}
	}
	public int getTwos() {return Twos;	};
	
	public void setThrees(Dice dice) {
		this.Threes = 0;
		int set = 3;
		for(int i=0;i<5;i++) {
			if(dice.getDice(i) == set) {
				this.Threes += set;
			}
		}
	}
	public int getThrees() {return Threes;	}
	
	public void setFours(Dice dice) {
		this.Fours = 0;
		int set = 4;
		for(int i=0;i<5;i++) {
			if(dice.getDice(i) == set) {
				this.Fours += set;
			}
		}
	}
	public int getFours() {	return Fours;	}
	
	public void setFives(Dice dice) {
		this.Fives = 0;
		int set = 5;
		for(int i=0;i<5;i++) {
			if(dice.getDice(i) == set) {
				this.Fives += set;
			}
		}
	}
	public int getFives() {	return Fives;	}
	
	public void setSixes(Dice dice) {
		this.Sixes = 0;
		int set = 6;
		for(int i=0;i<5;i++) {
			if(dice.getDice(i) == set) {
				this.Sixes += set;
			}
		}
	}
	public int getSixes() {
		return Sixes;
	}
	
	public void setFourOfaKind(Dice dice) {
		this.FourOfaKind = 0;
		dice.Count_dice();
		boolean check = false;
		for(int count:dice.getCount()) {
			if(count >= 4) {
				check = true;
			}
		}
		if(check == true) {
			
			for(int i=0;i<5;i++) {
				this.FourOfaKind += dice.getDice(i);
			}
		}
		
	}
	public int getFourOfaKind() {	return FourOfaKind;	}
	
	public void setFullHouse(Dice dice) {
		this.FullHouse = 0;
		dice.Count_dice();
		boolean check2 = false;
		boolean check3 = false;
		for(int count:dice.getCount()) {
			if(count == 2) {
				check2 = true;
			}
			else if(count == 3) {
				check3 = true;
			}
		}
		if(check2 == true && check3 == true) {
			for(int i=0;i<5;i++) {
				this.FullHouse += dice.getDice(i);
			}
		}
	}
	public int getFullHouse() {	return FullHouse;	}
	
	public void setLittleStraight(Dice dice) {
		this.LittleStraight = 0;
		dice.Count_dice();
		boolean check = false;
		int[] count = dice.getCount();
		if(count[2]>=1 && count[3] >=1) {
			if((count[0]>=1&&count[1]>=1)||(count[1]>=1&&count[4]>=1)||(count[4]>=1&&count[5]>=1)) {
				check = true;
			}
		}
		if(check == true) {
			this.LittleStraight = 15;
		}
	}
	public int getLittleStraight() {
		return LittleStraight;
	}
	
	public void setBigStrainght(Dice dice) {
		this.BigStrainght = 0;
		dice.Count_dice();
		boolean check = false;
		int[] count = dice.getCount();
		if(count[1]==1 && count[2] ==1 && count[3] == 1 && count[4] == 1) {
			if(count[0] == 1 || count[5]==1) {
				check = true;
			}
		}
		if(check == true) {
			this.BigStrainght = 30;
		}
	}
	public int getBigStrainght() {
		return BigStrainght;
	}
	
	public void setYacht(Dice dice) {
		this.Yacht = 0;
		dice.Count_dice();
		boolean check = false;
		for(int count:dice.getCount()) {
			if(count == 5) {
				check = true;
			}
		}
		if(check == true) {
			this.Yacht = 50;
		}
	}
	public int getYacht() {
		return Yacht;
	}
	
	public void setChoice(Dice dice) {
		this.Choice = 0;
		for(int i =0; i<5; i++) {
			this.Choice += dice.getDice(i);
		}		
	}
	public int getChoice() {
		return Choice;
	}
	
	public void getScore() {
		getOnes();
		getTwos();
		getThrees();
		getFours();
		getFives();
		getSixes();
		getFourOfaKind();
		getFullHouse();
		getLittleStraight();
		getBigStrainght();
		getChoice();
		getYacht();
	}
	
}
