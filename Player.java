import java.util.ArrayList;

public  class Player extends Person{
	private String name;
	private int chips;
	private int bet;
	

	
	public Player(String name,int chips )
	{
	  	this. name=name ;
	  	this. chips=chips ;
	}
	public String getName()
	{
		return name;
		
	}
	 public int makeBet()
	 {
		 if(chips>0)
		 {
			 bet=1;
			  
		return bet; 
		}
		 else
		 {
			 return 0;
		 }
		 
	 }
	 
	 //public boolean hitMe(Table table) 
	 //{     
		 // if(getTotalValue()>17)
		 // {
		//	  return false;
		 // }
		  //else
		 //{
			//  return true;
		 // }
	   
	// }
	
	 public int get_current_chips()
	 {
		 return chips;
	 }
	 public void increase_chips (int diff)
	 {
		 chips+=diff;
		  
	 }
	 public void say_hello()
	 {
		 System.out.println("Hello, I am " + name + ".");
		 System.out.println("I have " + chips + " chips.");


	 }
	@Override
	public boolean hit_me(Table table) {
		// TODO Auto-generated method stub
		 
		  if(getTotalValue()>17)
		  {
			  return false;
		  }
		  else
		  {
			  return true;
		  }
	}
	//public void setOneRoundCard(ArrayList<Card> cards)
	// {
		//oneRoundCard=cards; 

	// }

}
