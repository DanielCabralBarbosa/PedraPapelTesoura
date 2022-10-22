package br.com.danielcabral.git;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Player extends Thread {
		
	String name;
	String[] plays = {"Pedra", "Papel", "Tesoura"};
	Random random;
	static Semaphore semaphore = new Semaphore(1);
	
	public Player(String _name)	{
		this.name = _name;
		random = new Random(System.currentTimeMillis());
	}
	
	public String play() {
		int x = random.nextInt(3);	
		return plays[x];
	}
		
	public void run() {
		
		try {
			
			System.out.println(this.name + " : Se preparando " 
			+ semaphore.availablePermits());
			
			semaphore.acquire();
			
			System.out.println(" Vez do : " + this.name);
			
			try {
				
				System.out.println("Jogada de " + this.name + ": " + this.play() 
				+ semaphore.availablePermits());
				
				//sleep
				Thread.sleep(1000);		
				
				
			} finally {
				
				System.out.println(this.name + "passa a vez");
				semaphore.release();
				
				
				System.out.println(" Próximo " 
						+ semaphore.availablePermits());
				
			}
			
		}catch (InterruptedException e) {e.printStackTrace();}
			
			
		}
		
	}
