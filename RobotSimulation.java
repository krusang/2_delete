/*
 * Written by Krusang Patel
 */
import java.util.*;
import java.io.*;

public class RobotSimulation implements LLInterface<String> {

	
	public static final int SIZE = 10;  //instance 
	private char board[][];
	private LinkedListQueue<String> moves;

	public RobotSimulation() {
		board = new char[SIZE][SIZE];
		moves = new LinkedListQueue<String>();
	}

	
	public void printInit(String fileName) {  //this will print the initial board and read the file
		try {
			Scanner file = new Scanner(new File(fileName));
			for (int i = 0; i < SIZE; i++) {
				board[i] = file.nextLine().toCharArray();
				board[0][0] = 'O';
				System.out.println(board[i]);

			}
		} catch (Exception e) { //if file name is wrong
			System.out.println("Incorrect board file name");
		}
	}

	
	public void print() {       //prints boards
		for (int i = 0; i < SIZE; i++) {
			System.out.println(board[i]);
		}
	}

	
	public boolean boundCheck(int i, int j, char board[][]) {              
		if (i >= 0 && i < SIZE && j < SIZE && j >= 0 && board[i][j] == '_') //checks to see if it goes out of bounds of board
			return true;
		else {
			System.out.println("CRASH!");
			return false;
		}
	}

	// Movements
	public void move(String commLine) { //variables for postions
		
		int count = 0;
		int locY = 0;
		int locX = 0;

		try {
			Scanner command = new Scanner(new File(commLine));
			while (command.hasNext()) {
				String movement = command.nextLine();
				moves.enqueue(movement);
				
				
				//All of the movements, will take "move up", "move down', "move left", "move right" as command, anything else will be ignored

				
				if (moves.peek().equals("Move Up")) {
					System.out.println("\nCommand " + count);
					if (boundCheck(locY - 1, locX, board)) {
						board[locY][locX] = '_';
						board[locY - 1][locX] = 'O';
						locY -= 1;
						print();
						moves.dequeue();
						count++;
					}
				} else if (moves.peek().equals("Move Down")) {
					System.out.println("\nCommand " + count);
					if (boundCheck(locY + 1, locX, board)) {
						board[locY][locX] = '_';
						board[locY + 1][locX] = 'O';
						locY += 1;
						print();
						moves.dequeue();
						count++;
					}
				} else if (moves.peek().equals("Move Right")) {
					System.out.println("\nCommand " + count);
					if (boundCheck(locY, locX + 1, board)) {
						board[locY][locX] = '_';
						board[locY][locX + 1] = 'O';
						locX += 1;
						print();
						moves.dequeue();
						count++;
					}
				} else if (moves.peek().equals("Move Left")) {
					System.out.println("\nCommand " + count);
					if (boundCheck(locY, locX - 1, board)) {
						board[locY][locX] = '_';
						board[locY][locX - 1] = 'O';
						locX -= 1;
						print();
						moves.dequeue();
						count++;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Incorrect board file name");
		}
	}

	@Override
	public void enqueue(String aData) {
		// TODO Auto-generated method stub

	}

	@Override
	public String dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String peek() {
		// TODO Auto-generated method stub
		return null;
	}
}