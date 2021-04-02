package Snake_Ladder_Problem;

public class SnakeAndLadder {
	
	public static void main(String args[]) {
		System.out.println("Welcome to Snake and Ladder Simulation Program !!!");
		int start=0;
		int player_position=start;
		System.out.println("\n******************Game Starts******************\n"+"Player position is "+player_position);
		int move_positions=rollDie();
		System.out.println("Number of positions to move :"+move_positions);
			
	}
	public static int rollDie() {
		return (int)(Math.random()*6)+1;
	}	
}