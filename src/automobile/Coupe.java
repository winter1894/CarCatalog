package automobile;

/**
 * 
 * @author Matthew
 * A coupe is an Automobile
 */
public class Coupe extends Automobile{

	/**
	 * Default constructor for coupe
	 */
	public Coupe(){}

	/**
	 * Takes in all information of a particular SUV
	 * @param type
	 * @param MPG
	 * @param power
	 * @param seats
	 * @param price
	 */
	public Coupe(String type, int MPG, int power, int seats, int price){
		setAutomobile(type, MPG, power, seats, price);
		setPerk();
	}

	/**
	 * Automobile setter for referencing parent class
	 */
	public Automobile setAutomobile(String type, int MPG, int power, int seats, int price){
		super.setAutomobile(type, MPG, power, seats, price);
		return automobile;
	}

	/**
	 * sets perk in coupes 
	 */
	public void setPerk(){
		perk="is a two door coupe";
		super.setPerk(perk);
	}

	/**
	 * returns the perk when requested
	 */
	public String getPerk(){
		return perk;
	}


}
