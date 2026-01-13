package logic;

public class CardCounter {
	
	private UnitCard card;
	private int count;
	
	public String toString() {
		return  this.getCard() + " x " + this.getCount();
	}
	public CardCounter(UnitCard card,int count){
		this.card = card;
		this.setCount(count);
	}
	public void setCount(int count){
		this.count = Math.max(0,count);
	}


	public UnitCard getCard(){
		return  this.card;
	}

	public int getCount(){
		return this.count;
	}

}
