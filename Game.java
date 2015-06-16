package com.kupra.wrestling;
import java.util.*;

public class Game {
	public static void main(String[] args){
		List<Wrestler> wrestlers = Wrestler.deck();
		Collections.shuffle(wrestlers);
		List<Wrestler> playerOne=new ArrayList<Wrestler>();
		List<Wrestler> playerTwo=new ArrayList<Wrestler>();
		int index=0;
		for(Wrestler someWrestler : wrestlers){
			if(index%2 == 0){
		playerOne.add(someWrestler);
		}else{
			playerTwo.add(someWrestler);
		}
			index++;
		}
			int lastIndexOne=playerOne.size()-1;
			int lastIndexTwo=playerTwo.size()-1;
			//while loop
		while(playerOne.size()!=0 && playerTwo.size()!=0){
		int toss=(int)(Math.random()*2);
		
		if(toss==0&&playerOne.size()==3){
			System.out.println("Its Player1's turn");
			playerOne.get(lastIndexOne).display();
		}
		else if(toss!=0&&playerOne.size()==3){
			System.out.println("Its Player2's turn");
			playerTwo.get(lastIndexTwo).display();
		
		}
		else if(playerOne.size()>3){
			System.out.println("Its Player1's turn");
			playerOne.get(lastIndexOne).display();
		
		}
		else{
			System.out.println("Its Player2's turn");
			playerTwo.get(lastIndexTwo).display();
		}
		System.out.println("Which attribute do you want to play with?");
		System.out.println("1. Height\n2. Weight\n3.Rank");
		Scanner ob=new Scanner(System.in);
		ob.hasNextInt();
		int userChoice=ob.nextInt();
		int check=(playerOne.get(lastIndexOne)).play(userChoice, (playerTwo.get(lastIndexTwo)));
		if(check==0){
			Wrestler ob2=playerTwo.remove(lastIndexTwo);
			playerOne.add(ob2);
		}else if(check==5){
			System.out.println("Please try again!");
			continue;
		}
		else{
			Wrestler ob1=playerOne.remove(lastIndexOne);
			playerTwo.add(ob1);
		}
		if(playerOne.size()!=0)
		lastIndexOne--;
		if(playerTwo.size()!=0)
		lastIndexTwo--;
		}
		System.out.println("Thanks for playing!");
		if (playerOne.size()==0)
		{
			
			System.out.println("Player2 has won the game!");
			
		}
		if(playerTwo.size()==0){
			System.out.println("Player1 has won the game!");
		}
		
		}
	}



