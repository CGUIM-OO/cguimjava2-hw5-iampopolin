
public class Card {
	 
		private Suit suit;  
		private int rank;  
		enum Suit{ Clubs , Diamonds , Hearts , Spades };
		 
		 
		public Card(int s,int value){
			if(s==1)
			{
				suit=Suit.Clubs;
			}
			if(s==2)
			{
				suit=Suit.Diamonds;
			}
			if(s==3)
			{
				suit=Suit.Hearts;
			}
			if(s==4)
			{
				suit=Suit.Spades;
			}
			rank=value;
		}	
		//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
		public void printCard(){
			 
			String rankarray[]= {"Ace","2","3","4","5","6","7","8","9","10","J","Q","k"};
			System.out.println( suit+","+rankarray[rank-1]);
			
			 

		}
		public Suit getSuit(){
			return suit;
		}
		public int getRank(){
			return rank;
		}
	}

 
