/********************************************
 * this program allows the user to play a 
 * rock, paper scissor game, using do-while 
 * loops, if-then statements, methods, scanner
 * and random objects.
 * 
 * title: Rock, Paper, Scissor game
 * programmer: Daniel Martinez
 * date: 3/17/2019
 ********************************************/

import java.util.*;
public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);	//create a scanner object
		Random rand = new Random();				//create a random object
		
		String playAgain = "";					//controls the do-while loop
		String userIn = "";						//holds user String input
		double numWin = 0;						//holds number of wins
		int numLose = 0;						//holds number of loses
		int numTie = 0;							//holds number of ties
		int gameNum = 0;						//holds number of games
		int userIn_int;							//holds user integer input
		int computerIn;							//holds computer input
		
		//calls instruction method
		instructions();
		
		//this do-while loop runs as long as the player wants to play
		do{
			computerIn = rand.nextInt(3);	//generates a random number between 0 and 2

			System.out.print("\nyour choice: ");
			userIn = in.next();
			
			userIn_int = convertToInt(userIn);	//pass user in to convert method and stores the value into variable
      
			System.out.println(convertToString(computerIn));	//prints computer choice
			
			//this if statement check whether the user wins, loses or ties
			if((check(userIn_int + 1)) == computerIn){
				System.out.println("you win");
				numWin ++;
			}
			else if((check(userIn_int - 1)) == computerIn){
				System.out.println("you lose");
				numLose ++;
			}
			else if(userIn_int == computerIn){
				System.out.println("it's a tie");
				numTie ++;
			}
			gameNum ++;
			
			userIn = "";
			userIn_int = 0;
			
			System.out.print("\ndo you want to play again: ");
			playAgain = in.next();
			playAgain = playAgain.toUpperCase();
		}while(playAgain.charAt(0) == 'Y');
		
		//calls statistics method when exit loop
		statistics(numWin, numLose, numTie, gameNum);

	}
	
	//this method prints instructions for the game
	public static void instructions() {
		System.out.println("\nLets play rock, paper, scissor!." +
							"\nEnter your choice below and I will enter mine."+
							"\nGood Luck!");
	}
	
	//this method prints the statistics of the game
	public static void statistics(double numWin, int numLose, int numTie, int gameNum) {
		System.out.println("Number of Games: " + gameNum);
		System.out.println("Games won: " + (int)numWin);
		System.out.println("Games lost: " + numLose);
		System.out.println("Games tie: " + numTie);
		System.out.println("Win percentage: " + (double)Math.round(((numWin/gameNum)*100)*100)/100);
	}
  
	//this method converts from String to Integer and return the value
	public static int convertToInt(String userIn) {
		int userIn_int = 0;
		userIn = userIn.toUpperCase();
		if(userIn.charAt(0) == 'R') {
			userIn_int = 0;
		}
		else if(userIn.charAt(0) == 'S'){
			userIn_int = 1;
		}
		else if(userIn.charAt(0) == 'P') {
			userIn_int = 2;
		}
		else {
			System.out.println("invalid input!");
		}
    
		return userIn_int;
	}
	
	//this method converts from integer to string and return the value
	public static String convertToString(int computerIn) {
    
		String computerIn_Str = "";
		if(computerIn == 0) {
			computerIn_Str = "Rock";
		}
		else if(computerIn == 1) {
			computerIn_Str = "Scissor";
		}
		else {
			computerIn_Str = "Paper";
		}
		return ("computer's choice: " + computerIn_Str);
    
	}
	
	/*this method checks if a value goes over 2 or below 0 and sets it back to 0 or 2
	this method is use as the main algorithm to check if user wins or loses*/
	public static int check(int val){
		if(val > 2){
			val = 0;
		}
		else if(val < 0){
			val = 2;
		}
		return val;
	}

}




