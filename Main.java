package qwe;

public class Main {
	public static void main(String[] args) {
		IOManager.welcome();
		IOManager.intro();
		Board.initialBoard();
		if (IOManager.chooseMode() == 1)
			VScomp();
		else
			VSplayer();
	}

	private static void VSplayer() {
		// TODO Auto-generated method stub
		System.out.println("PLAYER1 start setting  ships!");
		int[][] point1 = new int[10][10];
		Board.setCarrier(point1);
		Board.setBattleship(point1);
		Board.setCruiser(point1);
		Board.setSubmarine(point1);
		Board.setDestroyer(point1);
		Board.paint(point1);

		System.out.println("PLAYER2 start setting  ships!");
		int[][] point2 = new int[10][10];
		Board.setCarrier(point2);
		Board.setBattleship(point2);
		Board.setCruiser(point2);
		Board.setSubmarine(point2);
		Board.setDestroyer(point2);
		Board.paint(point2);

		System.out.println("Battle begin!");
		int count = 0;
		while (!Board.win(point2) && !Board.win(point1)) {
			if (count % 2 == 0) {
				System.out.println("PLAYER1 ATTACK!");
				Board.shot(point2);
			} else {
				System.out.println("PLAYER2 ATTACK!");
				Board.shot(point1);
			}
			count++;
		}
		if (Board.win(point2)) {
			System.out.println("Winner's board");
			Board.paint(point2);
			System.out.println("Loser's board");
			Board.paint(point1);
			System.out.println("PLAYER1 won the game!");
		} else if (Board.win(point1)) {
			System.out.println("Winner's board");
			Board.paint(point1);
			System.out.println("Loser's board");
			Board.paint(point2);
			System.out.println("PLAYER2 won the game!");
		}
		System.out.println(count + " shots have been taken!");
	}

	private static void VScomp() {
		// TODO Auto-generated method stub
		System.out.println("You will have battle with Computer!");
		int[][] point = new int[10][10];
		int count = 0;
		Board.compBoard(point);
		while (!Board.win(point)) {
			Board.shot(point);
			count++;
		}
		Board.paint(point);
		if (Board.win(point))
			System.out.println("You win with " + count + " shots!!!");
	}
}
