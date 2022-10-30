package br.com.danielcabral.git;

import java.util.Scanner;

import javax.sound.sampled.Line;

public class MainClass {
	
	
	public static void main(String[]args) {
		
		Scanner console = new Scanner(System.in);
		System.out.println("Digite a quantidade de rodadas");
		int rodadas = console.nextInt();
		
		Player player1 = new Player("Carlos");
		Player player2 = new Player("Pedro");						
		
		for(int i = 0; i < rodadas; i++) {			
			
			System.out.println("-=RODADA: " + (i+1) + "=-");			
				
				player1.run();
				player2.run();					
			
			if(player1.currentPlay == player2.currentPlay) {
				System.out.println("Empate!");
			}
			else if(player1.currentPlay == player1.plays[0]) {
				if(player2.currentPlay == player2.plays[2]) {
					System.out.println("Vitoria de " + player1.name);
					player1.points ++;
				}
				else {
					System.out.println("Vitoria de " + player2.name);
					player2.points ++;
				}
			}
			else if(player1.currentPlay == player1.plays[1]) {
				if(player2.currentPlay == player2.plays[0]) {
					System.out.println("Vitoria de " + player1.name);
					player1.points ++;
				}
				else {
					System.out.println("Vitoria de " + player2.name);
					player2.points ++;
				}
			}
			else if(player1.currentPlay == player1.plays[2]) {
				if(player2.currentPlay == player2.plays[1]) {
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
		System.out.println("-=FIM DE JOGO=-");		
		System.out.println("Pontos de " + player1.name + ": " + player1.points);
		System.out.println("Pontos de " + player2.name + ": " + player2.points);
				
	}
	
}
