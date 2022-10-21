package br.com.danielcabral.git;

import java.util.Random;

public class Player extends Thread {
		
	String name;
	String[] plays = {"Pedra", "Papel", "Tesoura"};
	Random random;
	
	public Player(String _name)	{
		this.name = _name;
		random = new Random(System.currentTimeMillis());
	}
	
	public String play() {
		int x = random.nextInt(3);	
		return plays[x];
	}
		
	public void run() {
		System.out.println("Jogada de " + this.name + ": " + this.play());
	}
	
}
