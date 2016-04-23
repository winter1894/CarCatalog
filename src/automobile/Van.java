package automobile;

/**
 * 
 * @author Matthew
 * A van is an Automobile
 */
public class Van extends Automobile{


	/**
	 * default constructor for Van
	 */
	public Van(){}

	/**
	 * Takes in all information of a particular Van
	 * @param type
	 * @param MPG
	 * @param power
	 * @param seats
	 * @param price
	 */
	public Van(String type, int MPG, int power, int seats, int price){
		//sends broad information to automobile
		setAutomobile(type, MPG, power, seats, price);
		//sets a custom perk of the particular automobile
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
	 * sets AWD perk to all Vans
	 */
	public void setPerk(){
		perk="mini vans offer spacious seating";
		super.setPerk(perk);
	}

	/**
	 * returns the perk when requested
	 */
	public String getPerk(){
		return perk;
	}

}
