package ch.jocomol.javamon.javamon;

import ch.jocomol.javamon.Attack;
import ch.jocomol.javamon.Controller;
import ch.jocomol.javamon.trainer.Human;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Javamon {
	boolean burning, poisoned, dead = false;
	private int agility, healthPoints, defense, level, maxhp;
	private int roundsBurning, roundsPoisoned = 0;
	private String type, race, name, url, myurl;
	private Javamon enemy;
	private Human trainer;
	private int[] aviableAttacks = new int[4];
	private Attack[] coulddoattaks = new Attack[7];
	private Attack[] candoattacks = new Attack[4];
	private Controller myController = new Controller();

	public Javamon(String name, String race, String type, int defense, int healthPoints, int agility, int level, int attack1, int attack2, int attack3, int attack4) {
		this.name = name;
		this.race = race;
		this.type = type;
		this.defense = defense;
		this.healthPoints = healthPoints;
		this.agility = agility;
		this.level = level;
		this.maxhp = healthPoints;
		this.aviableAttacks[0] = attack1;
		this.aviableAttacks[1] = attack2;
		this.aviableAttacks[2] = attack3;
		this.aviableAttacks[3] = attack4;
	}

	public String toString() {
		String output = "*****" + this.name+ "*****\n";
		output += "Type: " + this.type + "\n";
		output += "Species: " + this.race + "\n";
		output += "Level: " + this.level + "\n";
		output += "Health: " + this.healthPoints + "\n";
		output += "Defense: " + this.defense + "\n";
		output += "Agility: " + this.agility + "\n";
		output += "\n";
		return output;
	}

	public void statusCheck() {
		if (this.healthPoints > 0){
			this.faint();
		}

		if (this.burning) {
			this.burning = false;
			roundsBurning = 3;
		}

		else if (this.roundsBurning > 0) {
			System.out.println(this.name + " got 10 Damage from Fire");
			roundsBurning -= 1;
			this.healthPoints = this.healthPoints - 10;
			if (this.roundsBurning == 0) {
				System.out.println(this.name + " doesnt Burn anymore");
			}
		}

		if (this.poisoned) {
			this.poisoned = false;
			roundsPoisoned = 3;
		}

		else if (this.roundsPoisoned > 0) {
			roundsPoisoned -= 1;
			this.healthPoints = this.healthPoints - 7;
			System.out.println(this.name + " got 10 Damage from Poison");
			if (this.roundsPoisoned == 0) {
				System.out.println(this.name + " isnt Poisoned anymore");
			}
		}
	}

	public void faint() {
		this.roundsBurning = 0;
		this.burning = false;
		this.poisoned = false;
		this.roundsPoisoned = 0;
		this.dead = true;
		System.out.println(this.name + " has fainted");
		if (trainer.getName() == "Red") {
			myController.callSwitchJavamon();
		} else {
			trainer.changeJavamon();
		}
	}

	public int[] attack(int attackId) {
		return new int[2];
	}

	public void defend(int[] attackInfo){}
}
