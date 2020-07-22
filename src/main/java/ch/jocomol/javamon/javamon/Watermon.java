package ch.jocomol.javamon.javamon;

import ch.jocomol.javamon.Attack;
import ch.jocomol.javamon.Controller;
import javafx.scene.control.TextArea;


public class Watermon extends Javamon
{
	Controller myController = new Controller();

	public Watermon(String name, String race, String type, int defense, int healthPoints, int agility, int level, int attack1, int attack2, int attack3, int attack4)
	{
		super(name, race, type, defense, healthPoints, agility, level, attack1, attack2, attack3, attack4);
		this.coulddoattaks[0] = new Attack("Hit", 20, 15, 25, 0, 1);
		this.coulddoattaks[1] = new Attack("Hydrocannon", 40, 30, 5, 3, 2);
		this.coulddoattaks[2] = new Attack("Hydropump", 20, 20, 15, 3, 3);
		this.coulddoattaks[3] = new Attack("Cut", 10, 50, 30, 0, 4);
		this.coulddoattaks[4] = new Attack("Waterhit", 20, 15, 25, 3, 5);
		this.coulddoattaks[5] = new Attack("Aquajet", 30, 15, 15, 3, 6);
		this.coulddoattaks[6] = new Attack("Drown", 100, 100, 1, 3, 7);
		setattacks();

	}

	public void setattacks()
	{
		int counter = 0;
		for (int attackid : this.getAviableAttacks())
		{
			for (Attack attack : this.getCoulddoattaks())
			{
				if (attack.getId() == attackid)
				{
					this.candoattacks[counter] = attack;
					this.candoattacks[counter].setUser(this);
				}
			}
			counter = counter + 1;
		}
	}

	public int[] attack(int attackId)
	{
		int[] output = new int[4];
		output = this.candoattacks[attackId].doAttack();
		return output;

	}

	public void defend(int[] attackInfo)
	{

		 TextArea textlog = (TextArea) Controller.gamescene.lookup("#textlog");

		 if (attackInfo[3] < 1)
		 {
			 //OUTPUT enemy is out of attacknumber
			 textlog.appendText("\n" + this.getEnemy().getName() + " cant use this attack anymore");
		 }
		 else
		 {
			 if (attackInfo[2] > (this.getAgility() - this.getDefense()) + this.getLevel() + 3)
			 {
				 int damage = attackInfo[0] - (this.getDefense() + this.getLevel());
				 if (attackInfo[1] == 1)
				 {
					 damage = damage - 10;
				 }
				 else if (attackInfo[1] == 4 || attackInfo[1] == 5)
				 {
					 damage = damage + 15;
				 }

				 if (damage > 0)
				 {
					 if (damage > 30 && attackInfo[1]  == 2)
					 {
						 //OUTPUT defender is poisoned
						 this.setPoisoned(true);
						 textlog.appendText("\n" + this.getName()+ " got Poisoned");
					 }
					 else if (damage > 30 && attackInfo[1] == 1)
					 {
						 //ouptut this cant burn
						 textlog.appendText("\n" + this.getName() + " is a Watertype Javamon, so it cant Burn");
					 }

					 //OUTPUT Defender took damage
					 textlog.appendText("\n" + this.getName() + " took " + damage + " damage");
					this.setHealthPoints(this.getHealthPoints() - damage);
					this.statusCheck();
					this.getEnemy().statusCheck();
				 }
				 else
				 {
					 //OUTPUT enemy made no damage
					 textlog.appendText("\n" + this.getName() + "s defense was so strong, that the attack from" + this.getEnemy().getName() + " made no dammage");
				 }
			}
			else
			{
				//OUTPUT missed
				textlog.appendText("\n" + this.getEnemy().getName() + " missed");
			}

		 }

	}

}


