package ch.jocomol.javamon.javamon;

import javafx.scene.control.TextArea;

public class Dirtmon extends Javamon
{
	Controller myController = new Controller();
	//variables
	Attack Normal_Hit = new Attack("Hit", 20, 15, 25, 0, 1); //String name, int dammage, int attackspeed, int nummberuses, int type
	Attack Dirt_SandTomb = new Attack("Sand Tomb", 40, 25, 10, 5, 2);
	Attack Dirt_MudSlap = new Attack("Mud-Slap", 20, 30, 15, 5, 3);
	Attack Normal_Cut = new Attack("Cut", 10, 50, 30, 0, 4);
	Attack Dirt_DirtHit = new Attack("Waterhit", 20, 15, 25, 5, 5);
	Attack Dirt_Earthquake = new Attack("Earthquake", 50, 15, 15, 5, 6);
	Attack Dirt_TectonicRage = new Attack("Tectonic Rage", 100, 100, 1, 5,7 );
	{
	this.coulddoattaks[0] = Normal_Hit;
	this.coulddoattaks[1] = Dirt_SandTomb;
	this.coulddoattaks[2] = Dirt_MudSlap;
	this.coulddoattaks[3] = Normal_Cut;
	this.coulddoattaks[4] = Dirt_DirtHit;
	this.coulddoattaks[5] = Dirt_Earthquake;
	this.coulddoattaks[6] = Dirt_TectonicRage;
	}

	//getter and setter

	//Methods

	public Dirtmon(String name, String race, String type, int defense, int healthPoints, int agility, int level,  int attack1, int attack2, int attack3, int attack4)
	{
		super(name, race, type, defense, healthPoints, agility, level, attack1, attack2, attack3, attack4);
		setattacks();
	}
	public void setattacks()
	{
		int counter = 0;
		for (int attackid : aviableAttacks)
		{
			for (Attack attack : coulddoattaks)
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
		 if (attackInfo[3] < 0)
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
				 else if (attackInfo[1] == 3 || attackInfo[1] == 4)
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
						 //OUTPUT defender is Burning
						 this.setBurning(true);
						 textlog.appendText("\n" + this.getName() + " is a Dirttype Javamon, so it cant Burn");
					 }

					 //OUTPUT Defender took damage
					 textlog.appendText("\n" + this.getName() + " took " + damage + " damage");
					this.setHealthPoints(this.getHealthPoints() - damage);
					this.statusCheck();
					enemy.statusCheck();
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


