package Snake_Ladder_Problem;

import java.util.Scanner;

public class SnakeAndLadder {
	public static final int NO_PLAY=1;
	public static final int LADDER=2;
	public static final int SNAKE=3;
	static int die_count=0,start=0,end=100,player1_position=start,player2_position=start,current_position1,current_position2;
	
	public static void main(String args[]) {
		System.out.println("Welcome to Snake and Ladder Simulation Program !!!");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Player 1 :");
		String player1_name=sc.nextLine();
		System.out.println("Enter Player 2 :");
		String player2_name=sc.nextLine();
		System.out.println("\n******************Game Starts******************\n");
		System.out.println("Player 1 position["+player1_name+"]  :"+player1_position);
		System.out.println("Player 2 position["+player2_name+"]  :"+player2_position);
		while(player1_position<= end && player2_position <= end) {
			System.out.println("-----PLayer 1 Turn-------");
			current_position1=playGame(player1_position);
			player1_position=current_position1;
			System.out.println(player1_name+" Current Position :"+player1_position);
			if(current_position1 == 100) {
				System.out.println(player1_name+" Won the Game !!!");
				System.out.println("Total Number of times Die Rolled :-"+die_count);
				System.exit(0);
			}
			System.out.println("-----PLayer 2 Turn-------");
			current_position2=playGame(player2_position);
			player2_position=current_position2;
			System.out.println(player2_name+" Current Position :"+player2_position);
			if(current_position2  == 100){
				System.out.println(player2_name+" Won the Game !!!");
				System.out.println("Total Number of times Die Rolled :-"+die_count);
				System.exit(0);
			}
			if(current_position1!=100 && current_position2!=100)
				System.out.print("******************************************\n");
		}
	}
			
	public static int rollDie() {
		die_count++;
		return (int)(Math.random()*6)+1;
	}
	public static int getOption() {
		return (int)(Math.random()*3)+1;
	}
	public static int playGame(int player_position ) {
		int move_positions=rollDie();
		int total_moves=move_positions;
		System.out.println("Number Occurred on Die :"+move_positions);
		int option=getOption();
		System.out.println("Selected option="+option);
		switch(option) {
			case NO_PLAY:System.out.println("!!!!!!!! NO-PLAY !!!!!!!");
						break;
			case LADDER:System.out.println("######## LADDER ##########");
						player_position=player_position+move_positions;
						System.out.println("Rolling Die Again..........");
						move_positions=rollDie();
						System.out.println("Number Occurred on Die :"+move_positions);
						total_moves+=move_positions;
						System.out.println("Total Moves="+total_moves);
						player_position=player_position+move_positions;
						if(player_position>end)
							player_position=player_position-total_moves;
						break;
			case SNAKE:System.out.println("$$$$$$$$$$ SNAKE $$$$$$$$$$");
						player_position=player_position-move_positions;
						if(player_position < start)
							player_position=0;
						break;
		}
		return player_position;	
	}
}
