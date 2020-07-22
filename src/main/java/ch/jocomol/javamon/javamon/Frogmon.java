package ch.jocomol.javamon.javamon;

import ch.jocomol.javamon.Attack;
import ch.jocomol.javamon.Controller;
import javafx.scene.control.TextArea;

public class Frogmon extends Javamon
{
	Controller myController = new Controller();
	//variables
	Attack Normal_Hit = new Attack("Hit", 20, 15, 25, 0, 1); //String name, int dammage, int attackspeed, int nummberuses, int type
	Attack Normal_Cut = new Attack("Cut", 10, 50, 30, 0, 2);
	Attack Normal_Hypercroak = new Attack("Hypercroak", 40, 30, 5, 0, 3);
	Attack Normal_Jumpkick = new Attack("Jumpkick", 30, 25, 15, 0, 4);
	Attack Poison_PoisonFang = new Attack("Poisonfang", 50, 10, 15, 2 , 5);
	Attack Poison_Venoshock = new Attack("Venoshock", 50, 5, 20, 2, 6);
	Attack Poison_Acid = new Attack("Acid", 50, 40, 5, 2, 7);
	{
	this.coulddoattaks[0] = Normal_Hit;
	this.coulddoattaks[1] = Normal_Hypercroak;
	this.coulddoattaks[2] = Normal_Jumpkick;
	this.coulddoattaks[3] = Normal_Cut;
	this.coulddoattaks[4] = Poison_PoisonFang;
	this.coulddoattaks[5] = Poison_Venoshock;
	this.coulddoattaks[6] = Poison_Acid;
	}

	//getter and setter
	//methods
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
		/*switch (attackId)
		{
		case 1: attackId = 1; //Name: Normal_Hit Basedammage: 20 basespeed: 15 Numberuses: 25
			//OUTPUT is Attacking
			Normal_Hit.setUser(this);
			output = Normal_Hit.doAttack();
			break;
		case 2: attackId = 2; //Name:  Normal_Hypercroak Basedammage: 40 basespeed: 30 Numberuses: 5
			//OUTPUT is Attacking
		 	Normal_Hypercroak.setUser(this);
			output = Normal_Hypercroak.doAttack();
			break;
		case 3: attackId = 3; //Name: Normal_Jumpkick Basedammage: 30 basespeed: 24 Numberuses: 15
			//OUTPUT is Attacking
			Normal_Jumpkick.setUser(this);
			output = Normal_Jumpkick.doAttack();
			break;
		case 4: attackId = 4; //Name: Poison_PoisonFang Basedammage: 30 basespeed: 10 Numberuses: 15
			//OUTPUT is Attacking
			Poison_PoisonFang.setUser(this);
			output = Poison_PoisonFang.doAttack();
			break;
		case 5: attackId = 5; //Name: Poison_Venoshock Basedammage: 30 basespeed: 5 Numberuses: 20
			//OUTPUT is Attacking
			Poison_Venoshock.setUser(this);
			output = Poison_Venoshock.doAttack();
			break;
		case 6: attackId = 6; //Name: Normal_Cut Basedammage: 10 basespeed: 50 Numberuses: 20
			//OUTPUT is Attacking
			Normal_Cut.setUser(this);
			output = Normal_Cut.doAttack();
			break;
		case 7: attackId = 7; //Name: Poison_Acid Basedammage: 50 basespeed: 40 Numberuses: 5
			//OUTPUT is Attacking
			Poison_Acid.setUser(this);
			output = Poison_Acid.doAttack();
			break;
		default:
			System.out.println("Default");
			break;
		} */

		return output;

	}

	public Frogmon(String name, String race, String type, int defense, int healthPoints, int agility, int level, int attack1, int attack2, int attack3, int attack4)
	{
		super(name, race, type, defense, healthPoints, agility, level, attack1, attack2, attack3, attack4);
		setattacks();
	}

	public void defend(int[] attackInfo)
	{
		 TextArea textlog = (TextArea) Controller.gamescene.lookup("#textlog");

		 if (attackInfo[3] == 0)
		 {
			 //OUTPUT enemy is out of attacknumber
			 textlog.appendText("\n" + this.getEnemy().getName() + " cant use this attack anymore");
		 }
		 else
		 {
			 if (attackInfo[2] > (this.getAgility() - this.getDefense()) + this.getLevel() + 3)
			 {
				 int damage = attackInfo[0] - (this.getDefense() + this.getLevel());
				 if (attackInfo[1] == 0)
				 {
					 damage = damage - 10;
				 }
				 else if (attackInfo[1] == 5)
				 {
					 damage = damage + 15;
				 }

				 if (damage > 0)
				 {
					 if (damage > 30 && attackInfo[1] == 2)
					 {
						 //OUTPUT cant be poisoned
						 textlog.appendText("\n" + this.getName() + " is a Frogtype Javamon, so it cant be Poisoned");
					 }
					 else if (damage > 30 && attackInfo[1] == 1)
					 {
						 this.setBurning(true);
						 //OUTPUT this is burning
						 textlog.appendText("\n" + this.getName()+ " is Burning");
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
