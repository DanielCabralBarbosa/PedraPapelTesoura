package br.com.danielcabral.git;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

import javax.sound.sampled.Line;

public class MainClass {
	
	
	public static void main(String[]args) {
		
		Scanner console = new Scanner(System.in);
		System.out.println("Digite a quantidade de rodadas");
		int rodadas = console.nextInt();
		
		Semaphore semaphore = new Semaphore(1);

		Player player1 = new Player("Carlos", semaphore, rodadas);
		Player player2 = new Player("Pedro", semaphore, rodadas);
		
		Manager manager = new Manager(player1, player2, rodadas);	
		
		player1.start();
		player2.start();
													
		
		while(player1.isAlive() || player2.isAlive()) {
			
		}
	
			for (int i = 0; i < rodadas; i++) {
				manager.match(i);
			}
		
		
				
		System.out.println("-=FIM DE JOGO=-");		
		System.out.println("Pontos de " + player1.name + ": " + player1.points);
		System.out.println("Pontos de " + player2.name + ": " + player2.points);
				
	}
	
}
