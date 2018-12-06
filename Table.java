import java.util.ArrayList;

public class Table {

	final int MAXPLAYER = 4;
	private Deck allcards;
	private Player[] player;
	private Dealer dealer;
	private int[] pos_betArray;
	//private Player Player;
	public Table(int nDeck)
	{
		 allcards = new Deck(nDeck);
		 player=new Player[MAXPLAYER];
		 
 	}
	
	public void set_player(int pos, Player p)
    {     
		player[pos] = p;
    }
	public Player[] get_player()
	{	
		return player;
	}
	
	public void set_dealer(Dealer d)
	{
		dealer=d;
	}
	
	public Card get_face_up_card_of_dealer()
	{
		ArrayList<Card> getcard=dealer.getOneRoundCard();
		Card face=getcard.get(1);
		return face;
			//return dealer.getOneRoundCard().get(1);//莊家的第二張
	}
	private void ask_each_player_about_bets()
	{   
		pos_betArray=new int[MAXPLAYER];
		for(int i =0;i<MAXPLAYER;i++)
		{
			player[i].say_hello();  			
			pos_betArray[i]=player[i].makeBet();
		  
		}
	}
	private void distribute_cards_to_dealer_and_players()
	{
		//給玩家的兩張牌
		for(int i=0;i<MAXPLAYER;i++)
		{       ArrayList<Card> get=new ArrayList<Card>();
			    Player a=player[i];
				get.add(allcards.getOneCard(true));
				get.add(allcards.getOneCard(true));
				a.setOneRoundCard(get);
        }
		
		ArrayList<Card> getcard=new ArrayList<Card>();
		getcard.add(allcards.getOneCard(true));
		getcard.add(allcards.getOneCard(false));
		dealer.setOneRoundCard(getcard);
	
	}
	
	private void ask_each_player_about_hits()
	{   boolean hit =false;
		ArrayList<Card> getcard=new ArrayList<Card>();
		for(int i=0;i<MAXPLAYER;i++)
			 {   
			     
			     Player a =player[i];
			    getcard=a.getOneRoundCard();
		do
		   {   
			 hit=a.hit_me(this); 
		     if(hit)
				 {   getcard.add(allcards.getOneCard(true));
					 a.setOneRoundCard(getcard);
					 System.out.println(player[i].getName() +" wanna hit");
					 System.out.println(player[i].getName()+"'s Cards now:");
					 for(Card c : getcard){
							c.printCard();
						}
				 }
		     else
		         {
		     	 System.out.println(a.getName()+", Pass hit!");
					System.out.println(a.getName()+", Final Card:");
					for(Card c : getcard)
					{
			  			c.printCard();
		            }
			     }
		   }
	     while(hit);
		   
	}
	}
	private void ask_dealer_about_hits()
	{
		boolean hit =false;
		ArrayList<Card> getcard=dealer.getOneRoundCard();
		do
		{   hit=dealer.hit_me(this);
			if(hit)
			{
				getcard.add(allcards.getOneCard(true));
				dealer.setOneRoundCard(getcard);
				System.out.println("Dealer wanna hit");	
				for(Card c : getcard){
					c.printCard();
				}
			}
			else
			{
			    System.out.println("Dealer's hit is over!");	
			}
		}
		while(hit);
	}
	private void calculate_chips()
	{
		ArrayList<Card> getcard=new ArrayList<Card>(); 
		getcard=dealer.getOneRoundCard();
		
		System.out.println("Dealer's card value is: "+dealer.getTotalValue());
		System.out.println("Dealer's Cards:");
		for(Card c:getcard)
		  {
			c.printCard();
		  }
		 for(int i=0;i<MAXPLAYER;i++) 
		 {
			Player a=player[i];
			System.out.println(a.getName()+" card value is "+a.getTotalValue());
			if(dealer.getTotalValue()>a.getTotalValue() && dealer.getTotalValue()<=21)
			{   a.increase_chips(-pos_betArray[i]);
				System.out.println(a.getName()+", Loss "+pos_betArray[i]+" Chips, the Chips now is: "+a.get_current_chips());
			}
			else if(a.getTotalValue()>dealer.getTotalValue() && a.getTotalValue()<=21)
			{   a.increase_chips(pos_betArray[i]);
				System.out.println(a.getName()+",Get "+pos_betArray[i]+" Chips, the Chips now is: "+a.get_current_chips());
				
			}
			else if(a.getTotalValue()>dealer.getTotalValue() && a.getTotalValue()>21 && dealer.getTotalValue()<=21 )
			{
				a.increase_chips(-pos_betArray[i]);
				System.out.println(a.getName()+", Loss "+pos_betArray[i]+" Chips, the Chips now is: "+a.get_current_chips());
			}
			else if(dealer.getTotalValue()>a.getTotalValue() && dealer.getTotalValue()>21 &&a.getTotalValue()<=21)
			{
				a.increase_chips(pos_betArray[i]);
				System.out.println(a.getName()+",Get "+pos_betArray[i]+" Chips, the Chips now is: "+a.get_current_chips());
			}
			else if(dealer.getTotalValue()>21 && a.getTotalValue()>21)
			{
				System.out.println("chips have no change! The Chips now is:"+a.get_current_chips());
				
			}
			else 
			{
				System.out.println("chips have no change! The Chips now is:"+a.get_current_chips());
				
			}
		 }
	}
	public int[] get_players_bet()
	{
		return pos_betArray;
	}
	public void play()
	{
		ask_each_player_about_bets();
		distribute_cards_to_dealer_and_players();
		ask_each_player_about_hits();
		ask_dealer_about_hits();
		calculate_chips();	
	}

}