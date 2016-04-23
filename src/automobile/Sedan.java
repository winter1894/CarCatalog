package automobile;

/**
 * 
 * @author Matthew
 * A sedan is an Automobile
 */
public class Sedan extends Automobile{

	/**
	 * default constructor for Sedan
	 */
	public Sedan(){}

	/**
	 * Takes in all information of a particular Sedan
	 * @param type
	 * @param MPG
	 * @param power
	 * @param seats
	 * @param price
	 */
	public Sedan(String type, int MPG, int power, int seats, int price){
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
	 * sets AWD perk to all Sedans 
	 */
	public void setPerk(){
		perk="is a great family sedan";
		super.setPerk(perk);
	}

	/**
	 * returns the perk when requested
	 */
	public String getPerk(){
		return perk;
	}

}
