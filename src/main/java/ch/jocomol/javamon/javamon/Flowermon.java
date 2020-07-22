package ch.jocomol.javamon.javamon;

import ch.jocomol.javamon.Attack;
import ch.jocomol.javamon.Controller;
import javafx.scene.control.TextArea;

public class Flowermon extends Javamon
{


	//variables
	Attack Normal_Hit = new Attack("Hit", 20, 15, 25, 0, 1); //String name, int dammage, int attackspeed, int nummberuses, int type, int id
	Attack Plant_LeafTornado = new Attack("Leaf Tornado", 30, 40, 10, 4 , 2);
	Attack Plant_VineWhip = new Attack("Vine Whip", 20, 40, 15, 4 , 3);
	Attack Normal_Cut = new Attack("Cut", 10, 50, 30, 0, 4);
	Attack Plant_PlantHit = new Attack("Planthit", 20, 15, 25, 4, 5);
	Attack Plant_PowerWhip = new Attack("Power Whip", 40, 35, 5, 4, 6);
	Attack Plant_SeedBomb = new Attack("Seed Bomb", 100, 100, 1, 4, 7);
	{
	this.coulddoattaks[0] = Normal_Hit;
	this.coulddoattaks[1] = Plant_LeafTornado;
	this.coulddoattaks[2] = Plant_VineWhip;
	this.coulddoattaks[3] = Normal_Cut;
	this.coulddoattaks[4] = Plant_PlantHit;
	this.coulddoattaks[5] = Plant_PowerWhip;
	this.coulddoattaks[6] = Plant_SeedBomb;
	}


	//getter and setter

	//methods
	public Flowermon(String name, String race, String type, int defense, int healthPoints, int agility, int level,int attack1, int attack2, int attack3, int attack4)
	{
		super(name, race, type, defense, healthPoints, agility, level, attack1,attack2, attack3, attack4);
		setattacks();
		// TODO Auto-generate  d constructor stub
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

		/*switch (attackId)
		{
		case 1: attackId = 1; //Name: Normal_Hit Basedammage: 20 basespeed: 15 Numberuses: 25
			//OUTPUT is Attacking
			Normal_Hit.setUser(this);
			output = Normal_Hit.doAttack();
			break;
		case 2: attackId = 2; //Name:  Plant_LeafTornado Basedammage: 30 basespeed: 40 Numberuses: 10
			//OUTPUT is Attacking
			Plant_LeafTornado.setUser(this);
			output = Plant_LeafTornado.doAttack();
			break;
		case 3: attackId = 3; //Name: Plant_VineWhip Basedammage: 20 basespeed: 40 Numberuses: 15
			//OUTPUT is Attacking
			Plant_VineWhip.setUser(this);
			output = Plant_VineWhip.doAttack();
			break;
		case 4: attackId = 4; //Name: Plant_PlantHit Basedammage: 20 basespeed: 15 Numberuses: 25
			//OUTPUT is Attacking
			Plant_PlantHit.setUser(this);
			output = Plant_PlantHit.doAttack();
			break;
		case 5: attackId = 5; //Name: Plant_PowerWhip Basedammage: 40 basespeed: 35 Numberuses: 5
			//OUTPUT is Attacking
			Plant_PowerWhip.setUser(this);
			output = Plant_PowerWhip.doAttack();
			break;
		case 6: attackId = 6; //Name: Normal_Cut Basedammage: 10 basespeed: 50 Numberuses: 20
			//OUTPUT is Attacking
			Normal_Cut.setUser(this);
			output = Normal_Cut.doAttack();
			break;
		case 7: attackId = 7; //Name: Plant_SeedBomb Basedammage: 100 basespeed: 100 Numberuses: 1
			//OUTPUT is Attacking
			Plant_SeedBomb.setUser(this);
			output = Plant_SeedBomb.doAttack();
			break;
		default:
			System.out.println("Default");
			break;
		} */

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
				 if (attackInfo[1] == 3)
				 {
					 damage = damage - 10;
				 }
				 else if (attackInfo[1] == 1 || attackInfo[1] == 5)
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





