package Snake_Ladder_Problem;

public class SnakeAndLadder {
	public static final int NO_PLAY=1;
	public static final int LADDER=2;
	public static final int SNAKE=3;
	
	public static void main(String args[]) {
		System.out.println("Welcome to Snake and Ladder Simulation Program !!!");
		int start=0,end=100;
		int player_position=start;
		System.out.println("\n******************Game Starts******************\n"+"Player position is "+player_position);
		while(player_position <= end) {
			int move_positions=rollDie();
			System.out.println("Number of positions to move :"+move_positions);
			int option=getOption();
			System.out.println("Selected option="+option);
			switch(option) {
					case NO_PLAY:System.out.println("!!!!!! NO-PLAY !!!!!!");
									break;
					case LADDER:System.out.println("####### LADDER #######");
								player_position=player_position+move_positions;
								if(player_position>end)
									player_position=player_position-move_positions;
								break;
					case SNAKE:System.out.println("$$$$$$$$ SNAKE $$$$$$$$");
								player_position=player_position-move_positions;
								if(player_position < start)
									player_position=0;
								break;
			}
			System.out.println("Player Current Position :"+player_position);
			if(player_position==100) {
				System.out.println("Won!");
				System.exit(0);
			}
		}
			
	}
	public static int rollDie() {
		return (int)(Math.random()*6)+1;
	}
	public static int getOption() {
		return (int)(Math.random()*3)+1;
	}
}
