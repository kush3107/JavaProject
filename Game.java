package com.kupra.wrestling;

import java.util.*;

public class Game {
	public static void main(String[] args) {
		int lastIndexOne, lastIndexTwo, counter = 0, win;
		List<Wrestler> wrestlers = Wrestler.deck();
		User firstPlayer = new User();
		User secondPlayer = new User();
		Scanner ob = new Scanner(System.in);
		System.out.println("Enter name of first player");
		ob.hasNext();
		String playerOneName = ob.next();
		firstPlayer.name = playerOneName;
		System.out.println("Enter name of second player");
		ob.hasNext();
		String playerTwoName = ob.next();
		secondPlayer.name = playerTwoName;
		Collections.shuffle(wrestlers);
		int index = 0;
		for (Wrestler someWrestler : wrestlers) {
			if (index % 2 == 0) {
				firstPlayer.currentDeck.add(someWrestler);

			} else {
				secondPlayer.currentDeck.add(someWrestler);

			}
			index++;
		}
		int playerOneCards = User.numberOfCards(firstPlayer.currentDeck);
		int playerTwoCards = User.numberOfCards(secondPlayer.currentDeck);
		int toss = (int) Math.random() * 2;
		lastIndexOne = playerOneCards - 1;
		lastIndexTwo = playerTwoCards - 1;
		if (toss == 0) {
			System.out.println("Its " + firstPlayer.name + " turn");
			firstPlayer.currentDeck.get(lastIndexOne).display();
			counter = 0;
		} else {
			System.out.println("Its " + secondPlayer.name + " turn");
			secondPlayer.currentDeck.get(lastIndexTwo).display();
			counter = 1;
		}
		System.out
				.println("Which attribute do you want to play one?\n1 : Rank\n2 : Height\n3 : Weight");
		ob.hasNextInt();
		int choice = ob.nextInt();
		if (toss == 0)
			secondPlayer.currentDeck.get(lastIndexTwo).display();
		else
			firstPlayer.currentDeck.get(lastIndexOne).display();
		// while loop
		while (playerOneCards != 0 && playerTwoCards != 0) {
			if (counter % 2 == 0 && toss != 0 && toss != 1) {
				System.out.println("Its " + firstPlayer.name + " turn");
				firstPlayer.currentDeck.get(lastIndexOne).display();
				System.out
						.println("Which attribute do you want to play one?\n1 : Rank\n2 : Height\n3 : Weight");
				ob.hasNextInt();
				choice = ob.nextInt();
				secondPlayer.currentDeck.get(lastIndexTwo).display();

			} else if (counter % 2 != 0 && toss != 0 && toss != 1) {
				System.out.println("Its " + secondPlayer.name + " turn");
				secondPlayer.currentDeck.get(lastIndexTwo).display();
				System.out
						.println("Which attribute do you want to play one?\n1 : Rank\n2 : Height\n3 : Weight");
				ob.hasNextInt();
				choice = ob.nextInt();
				firstPlayer.currentDeck.get(lastIndexOne).display();

			}
			win = Logic.play(choice, firstPlayer.currentDeck.get(lastIndexOne),
					secondPlayer.currentDeck.get(lastIndexTwo));
			if (win == 0) {
				Wrestler removedCard = secondPlayer.currentDeck
						.remove(lastIndexTwo);
				firstPlayer.currentDeck.add(removedCard);
				System.out.println(firstPlayer.name + " has won this round.");
			} else {
				Wrestler removedCard = firstPlayer.currentDeck
						.remove(lastIndexOne);
				secondPlayer.currentDeck.add(removedCard);
				System.out.println(secondPlayer.name + " has won this round.");
			}
			toss = 5;
			playerOneCards = User.numberOfCards(firstPlayer.currentDeck);
			playerTwoCards = User.numberOfCards(secondPlayer.currentDeck);
			Collections.shuffle(firstPlayer.currentDeck);
			Collections.shuffle(secondPlayer.currentDeck);
			counter++;
			lastIndexOne = playerOneCards - 1;
			lastIndexTwo = playerTwoCards - 1;
		}
		if (playerOneCards == 0) {
			System.out.println(secondPlayer.name + " has won the game");
		}
		if (playerTwoCards == 0) {
			System.out.println(firstPlayer.name + " has won the game");
		}
		ob.close();
	}
}
