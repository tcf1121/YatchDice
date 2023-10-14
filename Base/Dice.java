package Base;

import java.util.Arrays;
import java.util.Random;

public class Dice {
	private int[] dice = new int[5];
	private int[] count = new int[6];
	private Random random = new Random();
	
	public Dice() {
		Arrays.fill(dice, random.nextInt(6)+1);
	}
	
	public void Roll_dice(int num) {
		dice[num] = random.nextInt(6)+1;	
	}
	
	public int getDice(int num) {
		return dice[num];
	}
	
	public void Count_dice() {
		Arrays.fill(count,0);
		
		for(int i=0;i<5;i++) {
			count[dice[i]-1]++;
		}
	}
	public int[] getCount() {
		return count;
	}
}
