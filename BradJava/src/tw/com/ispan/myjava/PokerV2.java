package tw.com.ispan.myjava;

import java.util.Arrays;

public class PokerV2 {
	public static void main(String[] args) {
		// 洗牌
		int[] poker = shuffle();
		
		//System.out.println("-----");
		// 發牌
		int[][] players = new int[4][13];
		for (int i=0; i<poker.length; i++) {
			players[i%4][i/4] = poker[i];
		}
		
		// 攤牌
		String[] suits = {"黑桃","紅心","方塊","梅花"};
		String[] values = new String[] {"A ","2 ","3 ","4 ","5 ","6 ","7 ",
				"8 ","9 ","10","J ","Q ","K "};
		for (int[] player : players) {
			Arrays.sort(player);
			for (int card : player) {
				System.out.print(suits[card/13] + values[card%13] + " ");
			}
			System.out.println();
		}
		
	}
	
	static int[] shuffle() {
		int[] poker = new int[52];	// poker[第幾張] = 值 => 52 => 0
		boolean isRepeat;
		int rand;
		for (int i=0; i<poker.length; i++) {
			do {
				rand = (int)(Math.random()*52);	// rand 0 - 51
				
				// 檢查機制
				isRepeat = false;
				for (int j = 0; j < i; j++) {
					if (poker[j] == rand) {
						// 重複了
						isRepeat = true;
						break;
					}
				}
			}while (isRepeat);
			
			poker[i] = rand;
			//System.out.println(poker[i]);
		}
		
		return poker;
	}
	
	
	
}
