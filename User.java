package com.kupra.wrestling;

import java.util.*;

public class User {
	public String name;
	List<Wrestler> currentDeck = new ArrayList<Wrestler>();
	public static int numberOfCards(List<Wrestler> list){
		return list.size();
	}
	

}
