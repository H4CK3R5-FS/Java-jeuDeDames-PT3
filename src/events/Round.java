package events;

import java.util.HashMap;

import game.Texts;
import model.Joueur;
import model.Piece;
import utilitaires.Utilitaires;

public class Round {
	public static boolean verif_Choice(String position) {
		if (position.length()==2) {
			if(((position.charAt(0)>='A')&&(position.charAt(0)<='H'))&&((position.charAt(1)>='1')&&(position.charAt(1)<='8'))) {
				return true;
			}
		
		}
		return false;
	}
	public static void round(HashMap<String,Piece> hmP,String[][] board) {
		System.out.println(Texts.piece_Choice);
		String choix = Utilitaires.saisieString().toUpperCase();
		String prev_pos=Utilitaires.get_Position(board, hmP.get(choix).getX(), hmP.get(choix).getY());
		System.out.println("choisis ta position : ");
		String choix_pos = Utilitaires.saisieString().toUpperCase();
		System.out.print(verif_Choice(choix_pos));
		while (!verif_Choice(choix_pos)) {
			choix_pos = Utilitaires.saisieString().toUpperCase();
		}
		 int x=choix_pos.charAt(0);
		 x=x-64;
		 int y =choix_pos.charAt(1);
		 y=y-48;
		Events.move(hmP.get(choix), board, x, y);
		System.out.println("Player moved "+hmP.get(choix).getName()+"from "+prev_pos+" to "+Utilitaires.get_Position(board, x, y));
	}
}
