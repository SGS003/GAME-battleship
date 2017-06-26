package qwe;

import java.util.Scanner;

public class Board {
	public final static int BOARD_LENGTH = 10;
	
	public static void initialBoard() {
		int count = 0;
		for (int i = 0; i < BOARD_LENGTH; i++) {
			for (int j = 0; j < BOARD_LENGTH; j++) {
				if (count % BOARD_LENGTH == 0)
					System.out.println();
				System.out.print("  ~");
				count++;
			}
		}
		System.out.println("");
	}

	public static void compBoard(int[][] point) {
		// TODO Auto-generated method stub
		Carrier(point);
		Battleship(point);
		Cruiser(point);
		Submarine(point);
		Destroyer(point);
	}

	public static void paint(int[][] point) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < BOARD_LENGTH; i++) {
			for (int j = 0; j < BOARD_LENGTH; j++) {
				if (count % BOARD_LENGTH == 0) {
					System.out.println();
				}
				if (point[i][j] == 1 || point[i][j] == 2 || point[i][j] == 3 || point[i][j] == 4 || point[i][j] == 5) {
					System.out.print("  *");
					count++;
				} else if (point[i][j] == 0) {
					System.out.print("  ~");
					count++;
				} else if (point[i][j] == -1) {
					System.out.print("  #");
					count++;
				}
			}
		}
		System.out.println();
	}

	public static void shot(int[][] point) {

		Scanner set = new Scanner(System.in);
		System.out.println("please enter the  x-location of your shot:");
		int x = set.nextInt();
		System.out.println("please enter the  y-location of your shot:");
		int y = set.nextInt();
		System.out.println();
		if (is_hit(x, y, point)) {
			point[x][y] = -1;
			System.out.println("Congratulations! You hit one ship!");
			if (is_destroyed(point)) {
				System.out.println("Congratualations!You have destroyed one ship!");
			}
		} else {
			System.out.println("MISS!!! Keep trying!");
		}
	}

	private static boolean is_hit(int x, int y, int[][] point) {
		// TODO Auto-generated method stub
		if (point[x][y] == 0)
			return false;
		else
			return true;
	}

	private static Boolean is_destroyed(int[][] point) {
		// TODO Auto-generated method stub
		int[] count = new int[5];
		int i = 0;
		int j = 0;
		for (i = 0; i < 10; i++) {
			for (j = 0; j < 10; j++) {
				if (point[i][j] == 1)
					count[0]++;
				if (point[i][j] == 2)
					count[1]++;
				if (point[i][j] == 3)
					count[2]++;
				if (point[i][j] == 4)
					count[3]++;
				if (point[i][j] == 5)
					count[4]++;
			}
		}
		if (count[0] == 0 || count[1] == 0 || count[2] == 0 || count[3] == 0 || count[4] == 0)
			return true;
		else
			return false;
	}

	static boolean win(int[][] point) {
		// TODO Auto-generated method stub
		int a = 0;
		for (int i = 0; i < BOARD_LENGTH; i++) {
			for (int j = 0; j < BOARD_LENGTH; j++) {
				if (point[i][j] == 0 || point[i][j] == -1) {
					a++;
				}
			}
		}
		if (a == BOARD_LENGTH*BOARD_LENGTH)
			return true;
		else
			return false;
	}

	public static void setCarrier(int[][] point) {
		Scanner set = new Scanner(System.in);
		System.out.println("please enter  x-location:");
		int x = set.nextInt();
		System.out.println("please enter  y-location :");
		int y = set.nextInt();
		System.out.println("Please enter the direction,0 FOR horizontal,1 FOR vertical.");
		int d = set.nextInt();
		if (d == 1) {
			if (x >= 0 && (x + 5) <= 9 && y >= 0 && y <= 9 && point[x][y] == 0 && point[x + 1][y] == 0
					&& point[x + 2][y] == 0 && point[x + 3][y] == 0 && point[x + 4][y] == 0) {
				point[x][y] = 5;
				point[x + 1][y] = 5;
				point[x + 2][y] = 5;
				point[x + 3][y] = 5;
				point[x + 4][y] = 5;
			} else {
				System.out.println("Invalid Placement!!!Please reset!!");
				setCarrier(point);
			}
		} else if (d == 0) {
			if (x >= 0 && x <= 9 && y >= 0 && (y + 5) <= 9 && point[x][y] == 0 && point[x][y + 1] == 0
					&& point[x][y + 2] == 0 && point[x][y + 3] == 0 && point[x][y + 4] == 0) {

				point[x][y] = 5;
				point[x][y + 1] = 5;
				point[x][y + 2] = 5;
				point[x][y + 3] = 5;
				point[x][y + 4] = 5;
			} else if (!(point[x][y] == 0)) {
				System.out.println("The square has already been taken.Please reset!");
				setCarrier(point);
			} else {
				System.out.println("OUT OF BOARD! Please set the ship again!");
				setCarrier(point);
			}
		} else {
			System.out.println("Invalid direction.PLEASE RESET!");
			setCarrier(point);
		}

	}

	public static void setBattleship(int[][] point) {
		Scanner set = new Scanner(System.in);
		System.out.println("please enter  x-location:");
		int x = set.nextInt();
		System.out.println("please enter  y-location :");
		int y = set.nextInt();
		System.out.println("Please enter the direction,0 FOR horizontal,1 FOR vertical.");
		int d = set.nextInt();
		if (d == 1) {
			if (x >= 0 && (x + 4) <= 9 && y >= 0 && y <= 9 && point[x][y] == 0 && point[x + 1][y] == 0
					&& point[x + 2][y] == 0 && point[x + 3][y] == 0) {
				point[x][y] = 4;
				point[x + 1][y] = 4;
				point[x + 2][y] = 4;
				point[x + 3][y] = 4;
			} else if (!(point[x][y] == 0)) {
				System.out.println("The square has already been taken.Please reset!");
				setBattleship(point);
			} else {
				System.out.println("OUT OF BOARD! Please set the ship again!");
				setBattleship(point);
			}
		} else if (d == 0) {
			if (x >= 0 && x <= 9 && y >= 0 && (y + 4) <= 9 && point[x][y] == 0 && point[x][y + 1] == 0
					&& point[x][y + 2] == 0 && point[x][y + 3] == 0) {
				point[x][y] = 4;
				point[x][y + 1] = 4;
				point[x][y + 2] = 4;
				point[x][y + 3] = 4;
			} else if (!(point[x][y] == 0)) {
				System.out.println("The square has already been taken.Please reset!");
				setBattleship(point);
			} else {
				System.out.println("OUT OF BOARD! Please set the ship again!");
				setBattleship(point);
			}
		} else {
			System.out.println("Invalid direction.PLEASE RESET!");
			setBattleship(point);
		}
	}

	public static void setCruiser(int[][] point) {
		Scanner set = new Scanner(System.in);
		System.out.println("please enter  x-location:");
		int x = set.nextInt();
		System.out.println("please enter  y-location :");
		int y = set.nextInt();
		System.out.println("Please enter the direction,0 FOR horizontal,1 FOR vertical.");
		int d = set.nextInt();
		if (d == 1) {
			if (x >= 0 && (x + 3) <= 9 && y >= 0 && y <= 9 && point[x][y] == 0 && point[x + 1][y] == 0
					&& point[x + 2][y] == 0) {
				point[x][y] = 3;
				point[x + 1][y] = 3;
				point[x + 2][y] = 3;
			} else if (!(point[x][y] == 0)) {
				System.out.println("The square has already been taken.Please reset!");
				setCruiser(point);
			} else {
				System.out.println("OUT OF BOARD! Please set the ship again!");
				setCruiser(point);
			}
		} else if (d == 0) {
			if (x >= 0 && x <= 9 && y >= 0 && (y + 3) <= 9 && point[x][y] == 0 && point[x][y + 1] == 0
					&& point[x][y + 2] == 0) {
				point[x][y] = 3;
				point[x][y + 1] = 3;
				point[x][y + 2] = 3;
			} else if (!(point[x][y] == 0)) {
				System.out.println("The square has already been taken.Please reset!");
				setCruiser(point);
			} else {
				System.out.println("OUT OF BOARD! Please set the ship again!");
				setCruiser(point);
			}
		} else {
			System.out.println("Invalid direction.PLEASE RESET!");
			setCruiser(point);
		}
	}

	public static void setSubmarine(int[][] point) {
		Scanner set = new Scanner(System.in);
		System.out.println("please enter  x-location:");
		int x = set.nextInt();
		System.out.println("please enter  y-location :");
		int y = set.nextInt();
		System.out.println("Please enter the direction,0 FOR horizontal,1 FOR vertical.");
		int d = set.nextInt();
		if (d == 1) {
			if (x >= 0 && (x + 3) <= 9 && y >= 0 && y <= 9 && point[x][y] == 0 && point[x + 1][y] == 0
					&& point[x + 2][y] == 0) {
				point[x][y] = 3;
				point[x + 1][y] = 3;
				point[x + 2][y] = 3;
			} else if (!(point[x][y] == 0)) {
				System.out.println("The square has already been taken.Please reset!");
				setSubmarine(point);
			} else {
				System.out.println("OUT OF BOARD! Please set the ship again!");
				setSubmarine(point);
			}
		} else if (d == 0) {
			if (x >= 0 && x <= 9 && y >= 0 && (y + 3) <= 9 && point[x][y] == 0 && point[x][y + 1] == 0
					&& point[x][y + 2] == 0) {
				point[x][y] = 3;
				point[x][y + 1] = 3;
				point[x][y + 2] = 3;
			} else if (!(point[x][y] == 0)) {
				System.out.println("The square has already been taken.Please reset!");
				setSubmarine(point);
			} else {
				System.out.println("OUT OF BOARD! Please set the ship again!");
				setSubmarine(point);
			}
		} else {
			System.out.println("Invalid direction.PLEASE RESET!");
			setSubmarine(point);
		}
	}

	public static void setDestroyer(int[][] point) {
		Scanner set = new Scanner(System.in);
		System.out.println("please enter  x-location:");
		int x = set.nextInt();
		System.out.println("please enter  y-location :");
		int y = set.nextInt();
		System.out.println("Please enter the direction,0 FOR horizontal,1 FOR vertical.");
		int d = set.nextInt();

		if (d == 1) {
			if (x >= 0 && (x + 2) <= 9 && y >= 0 && y <= 9 && point[x][y] == 0 && point[x + 1][y] == 0) {
				point[x][y] = 2;
				point[x + 1][y] = 2;
			} else if (!(point[x][y] == 0)) {
				System.out.println("The square has already been taken.Please reset!");
				setDestroyer(point);
			} else {
				System.out.println("OUT OF BOARD! Please set the ship again!");
				setDestroyer(point);
			}
		} else if (d == 0) {
			if (x >= 0 && x <= 9 && y >= 0 && (y + 2) <= 9 && point[x][y] == 0 && point[x][y + 1] == 0) {
				point[x][y] = 2;
				point[x][y + 1] = 2;
			} else if (!(point[x][y] == 0)) {
				System.out.println("The square has already been taken.Please reset!");
				setDestroyer(point);
			} else {
				System.out.println("OUT OF BOARD! Please set the ship again!");
				setDestroyer(point);
			}
		} else {
			System.out.println("Invalid direction.PLEASE RESET!");
			setDestroyer(point);
		}
	}

	public static void Carrier(int[][] point) {
		int x = (int) (Math.random() * 9);
		int y = (int) (Math.random() * 9);
		int d = (int) Math.random();
		if (d == 1) {
			if (x >= 0 && (x + 5) <= 9 && y >= 0 && y <= 9 && point[x][y] == 0 && point[x + 1][y] == 0
					&& point[x + 2][y] == 0 && point[x + 3][y] == 0 && point[x + 4][y] == 0) {
				point[x][y] = 5;
				point[x + 1][y] = 5;
				point[x + 2][y] = 5;
				point[x + 3][y] = 5;
				point[x + 4][y] = 5;
			} else
				Carrier(point);

		} else if (d == 0) {
			if (x >= 0 && x <= 9 && y >= 0 && (y + 5) <= 9 && point[x][y] == 0 && point[x][y + 1] == 0
					&& point[x][y + 2] == 0 && point[x][y + 3] == 0 && point[x][y + 4] == 0) {

				point[x][y] = 5;
				point[x][y + 1] = 5;
				point[x][y + 2] = 5;
				point[x][y + 3] = 5;
				point[x][y + 4] = 5;
			} else
				Carrier(point);
		} else
			Carrier(point);
	}

	public static void Battleship(int[][] point) {
		int x = (int) (Math.random() * 9);
		int y = (int) (Math.random() * 9);
		int d = (int) Math.random();
		if (d == 1) {
			if (x >= 0 && (x + 4) <= 9 && y >= 0 && y <= 9 && point[x][y] == 0 && point[x + 1][y] == 0
					&& point[x + 2][y] == 0 && point[x + 3][y] == 0) {
				point[x][y] = 4;
				point[x + 1][y] = 4;
				point[x + 2][y] = 4;
				point[x + 3][y] = 4;
			} else
				Battleship(point);
		} else if (d == 0) {
			if (x >= 0 && x <= 9 && y >= 0 && (y + 4) <= 9 && point[x][y] == 0 && point[x][y + 1] == 0
					&& point[x][y + 2] == 0 && point[x][y + 3] == 0) {
				point[x][y] = 4;
				point[x][y + 1] = 4;
				point[x][y + 2] = 4;
				point[x][y + 3] = 4;
			} else
				Battleship(point);
		} else
			Battleship(point);
	}

	public static void Cruiser(int[][] point) {
		int x = (int) (Math.random() * 9);
		int y = (int) (Math.random() * 9);
		int d = (int) Math.random();
		if (d == 1) {
			if (x >= 0 && (x + 3) <= 9 && y >= 0 && y <= 9 && point[x][y] == 0 && point[x + 1][y] == 0
					&& point[x + 2][y] == 0) {
				point[x][y] = 3;
				point[x + 1][y] = 3;
				point[x + 2][y] = 3;
			} else
				Cruiser(point);
		} else if (d == 0) {
			if (x >= 0 && x <= 9 && y >= 0 && (y + 3) <= 9 && point[x][y] == 0 && point[x][y + 1] == 0
					&& point[x][y + 2] == 0) {
				point[x][y] = 3;
				point[x][y + 1] = 3;
				point[x][y + 2] = 3;
			} else
				Cruiser(point);
		} else
			Cruiser(point);
	}

	public static void Submarine(int[][] point) {
		int x = (int) (Math.random() * 9);
		int y = (int) (Math.random() * 9);
		int d = (int) Math.random();
		if (d == 1) {
			if (x >= 0 && (x + 3) <= 9 && y >= 0 && y <= 9 && point[x][y] == 0 && point[x + 1][y] == 0
					&& point[x + 2][y] == 0) {
				point[x][y] = 3;
				point[x + 1][y] = 3;
				point[x + 2][y] = 3;
			} else
				Submarine(point);
		} else if (d == 0) {
			if (x >= 0 && x <= 9 && y >= 0 && (y + 3) <= 9 && point[x][y] == 0 && point[x][y + 1] == 0
					&& point[x][y + 2] == 0) {
				point[x][y] = 3;
				point[x][y + 1] = 3;
				point[x][y + 2] = 3;
			} else
				Submarine(point);
		} else
			Submarine(point);
	}

	public static void Destroyer(int[][] point) {
		int x = (int) (Math.random() * 9);
		int y = (int) (Math.random() * 9);
		int d = (int) Math.random();
		if (d == 1) {
			if (x >= 0 && (x + 2) <= 9 && y >= 0 && y <= 9 && point[x][y] == 0 && point[x + 1][y] == 0) {
				point[x][y] = 2;
				point[x + 1][y] = 2;
			} else
				Destroyer(point);
		} else if (d == 0) {
			if (x >= 0 && x <= 9 && y >= 0 && (y + 2) <= 9 && point[x][y] == 0 && point[x][y + 1] == 0) {
				point[x][y] = 2;
				point[x][y + 1] = 2;
			} else
				Destroyer(point);
		} else
			Destroyer(point);
	}
}
