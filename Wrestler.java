package com.kupra.wrestling;

public class Wrestler {
	public int rank;
	public String name;
	public float height;
    public float weight;
    private int matchesWon;
    private int matchesPlayed;
    private int matchesLost;
    public Wrestler(String newName, int newRank, float newHeight, float newWeight, int totalMatches, int matchesWon){
    	this.name=newName;
    	this.rank=newRank;
    	this.height=newHeight;
    	this.weight=newWeight;
    	this.matchesPlayed=totalMatches;
    	this.matchesWon=matchesWon;
    	this.matchesPlayed=this.matchesWon+this.matchesLost;
    	
    }
    public String toString(){
    	return "name : "+this.name+", rank = "+this.rank;
    	
    }
    public void incrementMatchesWon(){
    	this.matchesWon++;
    	this.matchesPlayed++;
    }
    public void setMatchesWon(int wins) throws Exception{
    	if(wins < this.matchesWon)
    		throw new Exception("improper");
    	this.matchesWon=wins;
    	this.matchesPlayed=this.matchesLost+this.matchesWon;
    }
    public void display(){
    	System.out.println("Name : "+this.name+"\nRank : "+this.rank+"\nMatches Played : "+this.matchesPlayed+"\nHeight : "+this.height+"\nWeight : "+this.weight+"\nMatches Won : "+this.matchesWon+"\nMatches Lost : "+this.matchesLost); 
    
    }
    public void play(int choice, Wrestler ob){
    	
    	switch (choice){
    	case 1:
    		ob.display();
    		if(this.height>ob.height){
    			this.incrementMatchesWon();
    			System.out.println(this.name+" has won the game(Player)");
    		}
    		else{
    			ob.incrementMatchesWon();
    			System.out.println(ob.name+" has won the game(Comp)");
    		}
    		break;
    	case 2:
    		ob.display();
    		if(this.weight>ob.weight){
    			this.incrementMatchesWon();
    			System.out.println(this.name+" has won the game(Player)");
    		}

    		else{
    			ob.incrementMatchesWon();
    			System.out.println(ob.name+" has won the game(Comp)");
    		}
    		break;
    	case 3:
    		ob.display();
    		if(this.rank<ob.rank){
    			this.incrementMatchesWon();
    		
    			System.out.println(this.name+" has won the game(Player)");
    		}
    		else{
    			ob.incrementMatchesWon();
    		
    			System.out.println(ob.name+" has won the game(Comp)");
    		}
    		break;
    		default:
    			System.out.println("Wrong Choice");
    	}
    }

}
