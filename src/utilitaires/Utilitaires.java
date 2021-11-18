package utilitaires;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import model.Piece;

public class Utilitaires {
public static void draw_Board(String[][] board) {

	for (int i =0; i<board.length; i++) {
		for(int j = 0;j<board[i].length;j++) {
			board[i][j]=".";
			board[0][0]="*";
			board[0][board[i].length-1]="*";
			board[board.length-1][0]="*";
			board[board.length-1][board[i].length-1]="*";
		}
		
	}
	add_Boarders_To_Board(board);
}
public static void add_Boarders_To_Board(String[][] board) {
	String letters ="ABCDEFGH";
	String numbers="12345678";
	for (int i =1; i<board.length-1; i++) {
		for(int j = 1;j<board[i].length-1;j++) {
			board[0][j]=String.valueOf(letters.charAt(j-1));
			board[board.length-1][j]=String.valueOf(letters.charAt(j-1));
			board[i][0]=String.valueOf(numbers.charAt(i-1));
			board[i][board[i].length-1]=String.valueOf(numbers.charAt(i-1));
		}
	}
}
public static void add_Pieces_To_List(ArrayList<Piece> alP) {
	int id = 1;
	for(int line =1;line<4;line++) {
		for(int column=1;column<8;column=column+2) {
			if (line%2!=0) {
				alP.add(new Piece("PN"+String.valueOf(id), "Noir", id, line, column)) ;
				alP.add(new Piece("PB"+String.valueOf(id+1), "Blanc", id+1, line+5, column));
			}else {
				alP.add(new Piece("PN"+String.valueOf(id), "Noir", id, line, column+1));
				alP.add(new Piece("PB"+String.valueOf(id+1), "Blanc", id+1, line+5, column+1));
			}
			id++;
		}

	}
}
public static void add_Pieces_To_Board(ArrayList<Piece> alP,HashMap<String,Piece> hmP,String[][] board) {
	for (Piece P : alP) {
		board[P.getY()][P.getX()]=P.getName();
		hmP.put(P.getName(), P);
	}
}
public static void read_Board(String[][] board) {
	for (int i =0; i<board.length; i++) {
		for(int j = 0;j<board[i].length;j++) {
			System.out.print("		"+board[i][j]);
		}
		System.out.println("\n\n\n\n");
	}
}
public static String saisieString() {
	Scanner sc = new Scanner(System.in);
	String s = sc.nextLine();
	return s;
}
public static int saisieInt() {
	Scanner sc = new Scanner(System.in);
	int s = sc.nextInt();
	return s;
}
public static String get_Position(String[][] board,int x,int y) {
	String pos_checkers="";
	pos_checkers=pos_checkers+board[0][x]+board[y][0];
	return pos_checkers;
}
}
