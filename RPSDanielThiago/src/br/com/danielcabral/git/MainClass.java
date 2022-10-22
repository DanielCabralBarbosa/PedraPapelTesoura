package br.com.danielcabral.git;

public class MainClass {
	
	public static void main(String[]args) {
		Player player1 = new Player("Carlos");
		Player player2 = new Player("Pedro");
		
		player1.start();
		player2.start();
	}
}
