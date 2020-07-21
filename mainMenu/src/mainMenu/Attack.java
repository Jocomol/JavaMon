package mainMenu;
import java.util.Random;
import javafx.scene.control.TextArea;
public class Attack 
{
	//variables
	private int mindammage, maxdammage, nummberuses, minattackspeed, maxattackspeed, type, id;
	private String name;
	private Javamon User;
	private Random randomGenerator = new Random();
	
	//getter and setter
	public int getMindammage() {
		return mindammage;
	}
	public void setMindammage(int mindammage) {
		this.mindammage = mindammage - 5;
	}
	public int getMaxdammage() {
		return maxdammage;
	}
	public void setMaxdammage(int maxdammage) {
		this.maxdammage = maxdammage + 3;
	}
	public int getNummberuses() {
		return nummberuses;
	}
	public void setNummberuses(int nummberuses) {
		this.nummberuses = nummberuses;
	}
	public int getMinattackspeed() {
		return minattackspeed - 5;
	}
	public void setMinattackspeed(int minattackspeed) {
		this.minattackspeed = minattackspeed;
	}
	public int getMaxattackspeed() {
		return maxattackspeed + 3;
	}
	public void setMaxattackspeed(int maxattackspeed) {
		this.maxattackspeed = maxattackspeed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Javamon getUser() {
		return User;
	}
	public void setUser(Javamon user) {
		User = user;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//methods

	public Attack(String name, int dammage, int attackspeed, int nummberuses, int type, int id)
	{
		
		
		this.setName(name);
		this.setMinattackspeed(attackspeed);
		this.setMaxattackspeed(attackspeed);
		this.setMaxdammage(dammage);
		this.setMindammage(dammage);
		this.setNummberuses(nummberuses);
		this.setType(type);
		this.setId(id);
	}
	
	public int[] doAttack()
	{
		TextArea textlog = (TextArea) Controller.gamescene.lookup("#textlog");
		
		
		int[] output = new int[4];
		int attackdamage = randomGenerator.nextInt((this.getMaxdammage() - this.getMindammage()) + 1) + this.getMindammage();
		int attackspeed = randomGenerator.nextInt((this.getMinattackspeed() - this.getMinattackspeed()) + 1) + this.getMinattackspeed();
		output[0] = attackdamage + User.level * 5; //damage
		output[1] = this.getType(); //type
		output[2] = (attackspeed + User.getAgility()) - (User.getDefense() / 2); //attackspeed
		output[3] = this.getNummberuses(); //uses of attack
		this.setNummberuses(this.getNummberuses() - 1);
		
		textlog.appendText("\n" + this.getUser().getName() + " uses " + this.getName() + "!");
		return output;
		
		
	}
	
}
