package mainMenu;

public abstract class Javamon 
{
	//variables
	boolean isBurning = false, isPoisoned = false, isdead = false; //is Burning due to an attack or Poisoned
	int agility, HealthPoints, Defense, level, roundsBurning = 0, roundsPoisoned = 0, maxhp; 
	String type, race, name;
	String url, myurl;
	Javamon enemy;
	Human trainer;
	int[] aviableAttacks = new int[4];
	Attack[] coulddoattaks = new Attack[7];
	Attack[] candoattacks = new Attack[4];
	Controller myController = new Controller();
	
	//getters and setters
	public boolean isBurning() {
		return isBurning;
	}
	public void setBurning(boolean isBurning) {
		this.isBurning = isBurning;
	}
	public boolean isPoisoned() {
		return isPoisoned;
	}
	public void setPoisoned(boolean isPoisoned) {
		this.isPoisoned = isPoisoned;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getHealthPoints() {
		return HealthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		HealthPoints = healthPoints;
	}
	public int getDefense() {
		return Defense;
	}
	public void setDefense(int defense) {
		Defense = defense;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getRoundsBurning() {
		return roundsBurning;
	}
	public void setRoundsBurning(int roundsBurning) {
		this.roundsBurning = roundsBurning;
	}
	public int getRoundsPoisoned() {
		return roundsPoisoned;
	}
	public void setRoundsPoisoned(int roundsPoisoned) {
		this.roundsPoisoned = roundsPoisoned;
	}
	
	public Javamon getEnemy() {
		return enemy;
	}
	public void setEnemy(Javamon enemy) {
		this.enemy = enemy;
	}
	
	public int[] getAviableAttacks() {
		return aviableAttacks;
	}
	public void setAviableAttacks(int[] aviableAttacks) {
		this.aviableAttacks = aviableAttacks;
	}
	
	public Human getTrainer() {
		return trainer;
	}
	public void setTrainer(Human trainer) {
		this.trainer = trainer;
	}
	
	public boolean isIsdead() {
		return isdead;
	}
	public void setIsdead(boolean isdead) {
		this.isdead = isdead;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

	public int getMaxhp() {
		return maxhp;
	}
	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}

	public String getMyurl() {
		return myurl;
	}
	public void setMyurl(String myurl) {
		this.myurl = myurl;
	}
	//Methods
	

	public Javamon(String name, String race, String type, int defense, int healthPoints, int agility, int level, int attack1, int attack2, int attack3, int attack4)
	{
		this.setName(name);
		this.setRace(race);
		this.setType(type);
		this.setDefense(defense);
		this.setHealthPoints(healthPoints);
		this.setAgility(agility);
		this.setLevel(level);
		this.setMaxhp(healthPoints);
		this.aviableAttacks[0] = attack1;
		this.aviableAttacks[1] = attack2;
		this.aviableAttacks[2] = attack3;
		this.aviableAttacks[3] = attack4;
	}
	
	public String toString()
	{
		String output;
		output = "*****" + this.getName() + "*****\n";
		output += "Type: " + this.getType() + "\n";
		output += "Species: " + this.getRace() + "\n";
		output += "Level: " + this.getLevel() + "\n";
		output += "Health: " + this.getHealthPoints() + "\n";
		output += "Defense: " + this.getDefense() + "\n";
		output += "Agility: " + this.getAgility() + "\n";
		output += "\n";
		return output;
	}
	
	public void statusCheck()
	{
		if (isAlife() == false)
		{
			isFainted();
		}
		if (this.isBurning() == true)
		{
			this.setBurning(false);
			roundsBurning = 3;
		}
		else if (this.isBurning() == false && this.getRoundsBurning() > 0)
		{
			//OUTPUT Got damage by Fire
			System.out.println(this.getName() + " got 10 Damage from Fire");
			roundsBurning -= 1;
			this.setHealthPoints(this.getHealthPoints() - 10);
			if (this.getRoundsBurning() == 0)
			{
				System.out.println(this.getName() + " doesnt Burn anymore");
			}
		}
		
		if (this.isPoisoned() == true)
		{
			this.setPoisoned(false);
			roundsPoisoned = 3;
		}
		else if (this.isPoisoned() == false && this.getRoundsPoisoned() > 0)
		{
			roundsPoisoned -= 1;
			this.setHealthPoints(this.getHealthPoints() - 7);
			//OUTPUT Got damage by Poison
			System.out.println(this.getName() + " got 10 Damage from Poison");
			if (this.getRoundsPoisoned() == 0)
			{
				System.out.println(this.getName() + " isnt Poisoned anymore");
			}
		}
	}
	
	public boolean isAlife()
	{
		if (this.getHealthPoints() <= 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	} 
	
	public void isFainted()
	{
		 if (this.isAlife() == false)
		 {
			 this.setRoundsBurning(0);
			 this.setBurning(false);
			 this.setPoisoned(false);
			 this.setRoundsPoisoned(0);
			 this.setIsdead(true);
			 System.out.println(this.getName() + " has fainted");
				//OUTPUT: Javamon faintet
			 
			if (trainer.getName() == "Red")
			{
				myController.callSwitchJavamon();
			}
			else 
			{
				trainer.changeJavamon();
			}
			 
		 }
	}
	public int[] attack(int attackId)
	{
		int[] output = new int[2];
		return output;
	}
	
	public void defend(int[] attackInfo){}
}
