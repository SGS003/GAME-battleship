package qwe;

import java.util.Scanner;

public class IOManager {

	public static void welcome() {
		System.out.println("Welcome to BATTLESHIP GAME!");
	}

	public static int chooseMode() {
		Scanner choose = new Scanner(System.in);
		System.out.println("Please enter 1 OR 2 to choose the game.VS compyter OR VS person ");
		int a = choose.nextInt();
		return a;
	}

	public static void intro() {
		// TODO Auto-generated method stub
		System.out.println("Each Player will have a 10*10 board.Location is between 0 and 9.");
		System.out.println(" ~ represents water. * represents ship.# represents the beaten ship");
		System.out.println("Every time you entered the location of ship,you should put in the left/top location of the ship");
		System.out.println(
				"If the square you set was already been taken or the location you entered was out of board, you will have to reset! ");
		System.out.println("Now it is battle board.");
	}

}
