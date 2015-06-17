package com.kupra.wrestling;

import java.util.*;

public class Wrestler {
	public int rank;
	public String name;
	public float height;
	public float weight;
	private int matchesWon;
	private int matchesPlayed;
	private int matchesLost;

	public Wrestler(String newName, int newRank, float newHeight,
			float newWeight, int totalMatches, int matchesWon) {
		this.name = newName;
		this.rank = newRank;
		this.height = newHeight;
		this.weight = newWeight;
		this.matchesPlayed = totalMatches;
		this.matchesWon = matchesWon;
		this.matchesPlayed = this.matchesWon + this.matchesLost;

	}

	public static List<Wrestler> deck() {
		List<Wrestler> deck = new ArrayList<Wrestler>();
		deck.add(new Wrestler("undertaker", 2, 200, 600, 150, 60));
		deck.add(new Wrestler("John Cena", 1, 180, 550, 120, 60));
		deck.add(new Wrestler("Khali", 5, 300, 630, 130, 40));
		deck.add(new Wrestler("Randy Ortan", 6, 200, 600, 150, 60));
		deck.add(new Wrestler("Kane", 4, 200, 600, 150, 60));
		deck.add(new Wrestler("Hulk Hogan", 3, 200, 600, 150, 60));
		return deck;
	}

	public void incrementMatchesWon() {
		this.matchesWon++;
		this.matchesPlayed++;
	}

	public void setMatchesWon(int wins) throws Exception {
		if (wins < this.matchesWon)
			throw new Exception("improper");
		this.matchesWon = wins;
		this.matchesPlayed = this.matchesLost + this.matchesWon;
	}

	public void display() {
		System.out.println("Name : " + this.name + "\nRank : " + this.rank
				+ "\nMatches Played : " + this.matchesPlayed + "\nHeight : "
				+ this.height + "\nWeight : " + this.weight
				+ "\nMatches Won : " + this.matchesWon + "\nMatches Lost : "
				+ this.matchesLost);

	}

}
