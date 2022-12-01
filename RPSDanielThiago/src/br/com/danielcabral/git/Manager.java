package br.com.danielcabral.git;

public class Manager extends Thread {

	int rodadas;
	Player player1, player2;
	
	public Manager (Player _player1, Player _player2, int _rodadas) {
		rodadas = _rodadas;
		player1 = _player1;
		player2 = _player2;
	}
	
	public void run() {
		
		for (int i = 0; i < rodadas; i++) {
			match(i);
		}
		
	}
	
	public void match(int r) {
		
		System.out.println("-=RODADA " + (r + 1) + "=-");
		
		if(player1.plays[r] == player2.plays[r]) {
			System.out.println("Empate!");
		}
		else if(player1.plays[r] == player1.hand[0]) {
			if(player2.plays[r] == player2.hand[2]) {
				System.out.println("Vitoria de " + player1.name);
				player1.points ++;
			}
			else {
				System.out.println("Vitoria de " + player2.name);
				player2.points ++;
			}
		}
		else if(player1.plays[r] == player1.hand[1]) {
			if(player2.plays[r] == player2.hand[0]) {
				System.out.println("Vitoria de " + player1.name);
				player1.points ++;
			}
			else {
				System.out.println("Vitoria de " + player2.name);
				player2.points ++;
			}
		}
		else if(player1.plays[r] == player1.hand[2]) {
			if(player2.plays[r] == player2.hand[1]) {
				System.out.println("Vitoria de " + player1.name);
				player1.points ++;
			}
			else {
				System.out.println("Vitoria de " + player2.name);
				player2.points ++;
			}						
		}
		System.out.println();
	}
	
}
