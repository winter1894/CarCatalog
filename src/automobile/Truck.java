package automobile;

/**
 * 
 * @author Matthew
 * A truck is an Automobile
 */
public class Truck extends Automobile{

	/**
	 * default constructor for Truck
	 */
	public Truck(){}

	/**
	 * Takes in all information of a particular Truck
	 * @param type
	 * @param MPG
	 * @param power
	 * @param seats
	 * @param price
	 */
	public Truck(String type, int MPG, int power, int seats, int price){
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
	 * sets AWD perk to all Trucks 
	 */
	public void setPerk(){
		perk="this truck has a rear bed and hauling power";
		super.setPerk(perk);
	}

	/**
	 * returns the perk when requested
	 */
	public String getPerk(){
		return perk;
	}
}
