package br.com.danielcabral.git;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Player extends Thread {
		
	String name, play;
	String[] hand = {"Pedra", "Papel", "Tesoura"};
	String[] plays;
	int points, rodadas;
	boolean ready;
	Random random;
	Semaphore semaphore;
	
	public Player(String _name, Semaphore semaphore , int _rodadas)	{
		this.name = _name;
		this.points = 0;
		this.rodadas = _rodadas;
		this.random = new Random();
		this.semaphore = semaphore;
	}
	
	public String play() {
		int x = this.random.nextInt(3);	
		this.play = hand[x];
		System.out.println("Jogada de " + this.name + ": " + this.play);
		return play;
	}
		
	public void run() {
	
				try {
					semaphore.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
					}
								
					System.out.println("Vez de: " + this.name);
					
					this.plays = new String[rodadas];
					
					for(int i = 0; i < rodadas; i++) {
						this.plays[i] = this.play();
						System.out.println();
						this.ready = true;
												
					}

						semaphore.release();
									
					
					
				}
				
			}
			
