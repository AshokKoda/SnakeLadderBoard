package com.bridgelabz.snakeladder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


/*
 * Snake And Ladder
 */
public class SnakeLadderGame {

	public static void main(String[] args) {
		
		System.out.println("------Welcome To Snake And Ladder Game-------");
		SnakeLadder s = new SnakeLadder();
		s.startGame();

	}

}

/*
 * New class for SnakeLadder
 */
class SnakeLadder{
	
	public final static int WIN = 100;
	static Map<Integer,Integer> snake = new HashMap<Integer,Integer>();
	static Map<Integer,Integer> ladder = new HashMap<Integer,Integer>();
	
	{
		snake.put(99,54);
		snake.put(70,55);
		snake.put(52,42);
		snake.put(25,2);
		snake.put(95,72);
		
		ladder.put(6,25);
		ladder.put(11,40);
		ladder.put(60,85);
		ladder.put(46,90);
		ladder.put(17,69);
	}
	
	public int rollDice()
	{
		int n = 0;
		Random r = new Random();
		n=r.nextInt(7);
		return (n==0?1:n);
	}
	
	/*
	 * Start Game
	 */
	public void startGame() {
		int player1 = 0, player2= 0;
		int currentPlayer= -1;
		
		Scanner sc = new Scanner(System.in);
		String str;
		int diceValue =0;
		
		do
		{
			System.out.println(currentPlayer==-1?"\n\nFIRST PLAYER TURN":"\n\nSECOND PLAYER TURN");
			System.out.println("Press R to roll Dice");
			str = sc.next();
			diceValue = rollDice();
			
			
			if(currentPlayer == -1)
			{
				player1 = calculatePlayerValue(player1,diceValue);
				System.out.println("First Player :: " + player1);
				System.out.println("Second Player :: " + player2);
				System.out.println("------------------");
				if(isWin(player1))
				{
					System.out.println("First player wins");
					return;
				}
			}
			else
			{
				player2 = calculatePlayerValue(player2,diceValue);
				System.out.println("First Player :: " + player1);
				System.out.println("Second Player :: " + player2);
				System.out.println("------------------");
				if(isWin(player2))
				{
					System.out.println("Second player wins");
					return;
				}
			}
			
			currentPlayer= -currentPlayer;
			
			
			
		}while("r".equals(str));
	}
	
	public int calculatePlayerValue(int player, int diceValue)
	{
		player = player + diceValue;
		
		if(player > WIN)
		{
			player = player - diceValue;
			return player;
		}
		
		if(null!=snake.get(player))
		{
			System.out.println("Snake raja is eated!.. ");
			player= snake.get(player);
		}
		
		if(null!=ladder.get(player))
		{
			System.out.println("climb up the ladder");
			player= ladder.get(player);
		}
		return player;
	}
	
	public boolean isWin(int player)
	{
		return WIN == player;
	}
}
