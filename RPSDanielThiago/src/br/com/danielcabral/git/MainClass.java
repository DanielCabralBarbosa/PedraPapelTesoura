package br.com.danielcabral.git;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

import javax.sound.sampled.Line;

public class MainClass {
	
	
	public static void main(String[]args) {
		
		Scanner console = new Scanner(System.in);
		System.out.println("Digite a quantidade de rodadas");
		int rodadas = console.nextInt();
		
		Thread[] threads = new Thread[3];
		Semaphore semaphore = new Semaphore(1);

		Player player1 = new Player("Roberto", semaphore, rodadas);
		Player player2 = new Player("Carlos", semaphore, rodadas);
		Manager manager = new Manager(player1, player2, rodadas);
		
		threads[0] = player1;
		threads[1] = player2;
		threads[2] = manager;															
		
		for (int i = 0; i < threads.length; i++){
			
			threads[i].start();
			
			try {
				threads[i].join();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}			
				
		System.out.println("-=FIM DE JOGO=-");		
		System.out.println("Pontos de " + player1.name + ": " + player1.points);
		System.out.println("Pontos de " + player2.name + ": " + player2.points);
				
	}
	
}
