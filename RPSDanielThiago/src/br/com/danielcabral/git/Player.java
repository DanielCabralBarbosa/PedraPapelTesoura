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
		System.out.println("Jogada de " + this.name + ": " + this.currentPlay);
		return currentPlay;
	}
		
	public void run() {
		
		try {
			
			//System.out.println(this.name + ": Se preparando ");
			
			
			semaphore.acquire();
						
			System.out.println("Vez de: " + this.name);
			
			try {

				this.play();
				System.out.println(" ");

				Thread.sleep(1000);		
				
				
			} finally {

				semaphore.release();
				
			}
			
		}catch (InterruptedException e) {e.printStackTrace();}
			
			
		}
		
	}
