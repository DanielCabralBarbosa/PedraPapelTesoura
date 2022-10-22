package br.com.danielcabral.git;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Player extends Thread {
		
	String name, currentPlay;
	String[] plays = {"Pedra", "Papel", "Tesoura"};
	Random random;
	static Semaphore semaphore = new Semaphore(1);
	
	public Player(String _name)	{
		this.name = _name;
		this.random = new Random();
	}
	
	public String play() {
		int x = this.random.nextInt(3);	
		this.currentPlay = plays[x];
		return currentPlay;
	}
		
	public void run() {
		
		try {
			
			System.out.println(this.name + ": Se preparando ");
			
			semaphore.acquire();
			
			System.out.println(" Vez de: " + this.name);
			
			try {
				
				System.out.println("Jogada de " + this.name + ": " + this.play());
				
				//sleep
				Thread.sleep(1000);		
				
				
			} finally {
				
				System.out.println(this.name + " passa a vez");
				semaphore.release();
				
				
				System.out.println(" Proximo ");
				System.out.println(" ");
				
			}
			
		}catch (InterruptedException e) {e.printStackTrace();}
			
			
		}
		
	}
