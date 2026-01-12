package logic;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;

	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}

	public  UnitCard(String name,int bloodCost,int power ,int health,String flavorText){
		this.name = name;
		this.bloodCost = bloodCost;
		this.power = power;
		this.health = health;
		this.flavorText = flavorText;
	}

	public  void setName(String newName){
		if(newName.isBlank()){
			this.name = "Creature";
		}else {
			this.name = newName;
		}
	}
	public  void setBloodCost(int newBloodCost){
		this.bloodCost = Math.max(0, newBloodCost);
	}

	public  void setPower(int NewPower){
		this.power = Math.max(0, NewPower);
	}
	public  void setHealth(int NewHealth){
		this.health = Math.max(1, NewHealth);

	}
	public void  setFlavorText(String text){
		this.flavorText = text;
	}


	public String getName(){
		return  this.name;
	}
	public int getBloodCost(){return  this.bloodCost;}
	public  int getPower(){return  this.power;}
	public  int getHealth(){return  this.health;}
	public  String getFlavorText(){return this.flavorText;}

	public boolean equals(UnitCard other){

		return  this.name.equals(other.getName());

	}
}
