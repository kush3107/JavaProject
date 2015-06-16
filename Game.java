package com.kupra.wrestling;

import java.util.Scanner;

public class Game {
	public static void main(String[] args){
		Wrestler wrestler1=new Wrestler("undertaker",2,200,600,150,60);
		Wrestler wrestler2=new Wrestler("John Cena",1,180,550,120,60);
		Wrestler wrestler3=new Wrestler("Khali",5,300,630,130,40);
		Wrestler wrestler4=new Wrestler("Randy Ortan",6,200,600,150,60);
		Wrestler wrestler5=new Wrestler("Kane",4,200,600,150,60);
		Wrestler wrestler6=new Wrestler("Hulk Hogan",3,200,600,150,60);
		
		try{
		wrestler1.setMatchesWon(61);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		Wrestler player[]={wrestler1,wrestler2,wrestler3};
		Wrestler comp[]={wrestler4,wrestler5,wrestler6};
		while(true){
		int randPlayer=(int)(Math.random()*3);
		int compPlayer=(int)(Math.random()*3);
		
			
		player[randPlayer].display();
		//comp[compPlayer].display();
		System.out.println("Which attribute do you want to play with?");
		System.out.println("1. Height\n2. Weight\n3.Rank");
		Scanner ob=new Scanner(System.in);
		ob.hasNextInt();
		int userChoice=ob.nextInt();
		player[randPlayer].play(userChoice, comp[compPlayer]);
		System.out.println("Do you wish to play again?\n1 for yes\n2 for no");
		ob.hasNextInt();
		int counter=ob.nextInt();
		if (counter==2)
		{
			System.out.println("The Game has ended");
			break;
		}
		}
	}

}
