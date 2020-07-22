package ch.jocomol.javamon;

import ch.jocomol.javamon.javamon.Javamon;
import javafx.scene.control.TextArea;

import java.util.Random;

public class Attack {

	private int minDamage, maxDamage, numberUses, minattackSpeed, maxattackSpeed, type, id;
	private String name;
	private Random randomGenerator = new Random();

	public Attack(String name, int damage, int attackSpeed, int numberUses, int type, int id) {
		this.name = name;
		this.minattackSpeed = attackSpeed;
		this.maxattackSpeed = attackSpeed;
		this.maxDamage = damage;
		this.minDamage = damage;
		this.numberUses = numberUses;
		this.type = type;
		this.id = id;
	}

	public int[] doAttack(Javamon user) {
		TextArea textlog = (TextArea) Controller.gamescene.lookup("#textlog");
		int[] output = new int[4];
		int attackdamage = randomGenerator.nextInt((this.maxDamage - this.minDamage) + 1) + this.minDamage;
		int attackspeed = randomGenerator.nextInt((this.minattackSpeed - this.minattackSpeed) + 1) + this.minattackSpeed;
		output[0] = attackdamage + user.getLevel() * 5;
		output[1] = this.type;
		output[2] = (attackspeed + user.getAgility()) - (user.getDefense() / 2);
		output[3] = this.numberUses;
		this.numberUses = this.numberUses - 1;
		textlog.appendText("\n" + this.user.getName() + " uses " + this.name + "!");
		return output;
	}
}
