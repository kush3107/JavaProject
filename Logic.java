package com.kupra.wrestling;

import java.util.*;

public class Logic {
	public static int play(int choice, Wrestler ob1, Wrestler ob2) {

		switch (choice) {
		case 1:
			// ob2.display();
			if (ob1.rank < ob2.rank) {

				return 0;
			} else {
				// ob2.incrementMatchesWon();

				return 1;
			}

		case 2:
			// ob2.display();
			if (ob1.height > ob2.height) {
				// ob1.incrementMatchesWon();

				return 0;
			}

			else {
				// ob2.incrementMatchesWon();

				return 1;
			}

		case 3:
			if (ob1.weight > ob2.weight) {
				// ob1.incrementMatchesWon();

				return 0;
			} else {
				// ob2.incrementMatchesWon();

				return 1;
			}

		default:
			System.out.println("Wrong Choice");
			return 5;
		}
	}

}
