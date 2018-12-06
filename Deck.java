import java.util.ArrayList;
import java.util.Random;

 

public class Deck {

	    ArrayList<Card> usedCard ;
	    public int nUsed;
	    private ArrayList<Card> cards;
	    private ArrayList<Card> openCard;
	   
		//TODO: Please implement the constructor (30 points) 
		public Deck(int nDeck){
			        //1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
					//Hint: Use new Card(x,y) and  3 for loops to add card into deck
					//Sample code start
					//Card card=new Card(1,1); ->means new card as clubs ace
					//cards.add(card);
					//Sample code end
			openCard=new ArrayList<Card>();
			cards=new ArrayList<Card>();
			usedCard=new ArrayList<Card>();
		  int deck,flower,num;
		  for(deck=0;deck<nDeck;deck++) 
		  {
			  for(flower=1;flower<=4;flower++)
			  {
				  for(num=1;num<=13;num++)
				  {
					  Card card=new Card (flower,num);
					  cards.add(card);
				  }
				  
			  }
			  
		  }
		  shuffle();
			
		}
		public void shuffle()
		{    openCard.clear();
			 Random rnd = new Random();
			while(usedCard.size()>0)
			{
				Card getback =usedCard.get(0);
				usedCard.remove(0);
				cards.add(getback);
				nUsed++;
			}
 			for(int a=0;a<cards.size();a++)
			{
				Card place=cards.get(a);
				int i=rnd.nextInt(cards.size());
				cards.set(a, cards.get(i));
				cards.set(i, place);
			}
			nUsed=0;
		}
		
		public Card getOneCard(boolean isOpened)
		{
			if(cards.size()>0) 
			{
				if(isOpened==true)
				{
				  Card deal=cards.get(0);
				  openCard.add(deal);
				  usedCard.add(deal);
				  cards.remove(0);
				  nUsed++;
				  return deal;
				
			    }
				else
				{
					Card deal=cards.get(0);
					usedCard.add(deal);
					cards.remove(0);
					nUsed++;	
					return deal;
				}
				
				}
			else
				
			{
				shuffle();
				getOneCard( isOpened);  
				return null;
				
			}
		    }
		public ArrayList<Card> getOpenedCard()
		{
				return openCard;
		}

		//TODO: Please implement the method to print all cards on screen (10 points)
		public void printDeck(){
			//Hint: print all items in ArrayList<Card> cards, 
			//TODO: please implement and reuse printCard method in Card class (5 points)
	       int deck;
	       for(deck=0;deck<cards.size();deck++)
	       {
	    	   Card poker=cards.get(deck);
	    	   poker.printCard();
	    	   
	       }
	       
		}
		public ArrayList<Card> getAllCards(){
			return cards;
		}
	
}
