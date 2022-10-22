package br.com.danielcabral.git;

public class MainClass {
	
	
	public static void main(String[]args) {
		Player player1 = new Player("Carlos");
		Player player2 = new Player("Pedro");
		player1.start();
		player2.start();
		
		if(player1.currentPlay == player2.currentPlay) {
			System.out.println("Empate!");
		}
		else if(player1.currentPlay == player1.plays[0]) {
			if(player2.currentPlay == player2.plays[2]) 
				System.out.println("Vitória de " + player1.name);
			else 
				System.out.println("Vitória de " + player2.name);			
		}
		else if(player1.currentPlay == player1.plays[1]) {
			if(player2.currentPlay == player2.plays[0]) 
				System.out.println("Vitória de " + player1.name);
			else 
				System.out.println("Vitória de " + player2.name);			
		}
		else if(player1.currentPlay == player1.plays[2]) {
			if(player2.currentPlay == player2.plays[1]) 
				System.out.println("Vitória de " + player1.name);
			else
				System.out.println("Vitória de " + player2.name);			
		}
		
	}
	
}
