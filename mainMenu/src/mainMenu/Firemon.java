package mainMenu;

import javafx.scene.control.TextArea;

public class Firemon extends Javamon 
{
	Controller myController = new Controller();
	//variables
	Attack Normal_Hit = new Attack("Hit", 20, 15, 25, 0, 1); //String name, int dammage, int attackspeed, int nummberuses, int type
	Attack Fire_Firestorm = new Attack("Firestorm", 30, 15, 10, 1, 2);
	Attack Fire_Inferno = new Attack("Inferno", 35, 10, 5, 1, 3);
	Attack Fire_FireHit = new Attack("Firehit", 20, 15, 25, 1 , 4);
	Attack Fire_Ember = new Attack("Ember", 40, 10, 10, 1, 5);
	Attack Fire_Flametrow = new Attack("Flamethrow", 40, 10, 20, 1 , 6);
	Attack Normal_Cut = new Attack("Cut", 10, 50, 30, 0, 7);
	{
	this.coulddoattaks[0] = Normal_Hit;
	this.coulddoattaks[1] = Fire_Firestorm;
	this.coulddoattaks[2] = Fire_Inferno;
	this.coulddoattaks[3] = Normal_Cut;
	this.coulddoattaks[4] = Fire_FireHit;
	this.coulddoattaks[5] = Fire_Ember;
	this.coulddoattaks[6] = Fire_Flametrow;
	}	
	//getter and setter
	//methods
	public Firemon(String name, String race, String type, int defense, int healthPoints, int agility, int level, int attack1, int attack2, int attack3, int attack4) 
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
		
		/*switch (attackId)
		{
		case 1: attackId = 1; //Name: Normal_Hit Basedammage: 20 basespeed: 5 Numberuses: 25
			//OUTPUT is Attacking
			Normal_Hit.setUser(this);
			output = Normal_Hit.doAttack();
			break;
		case 2: attackId = 2; //Name: Fire_Firestrom Basedammage: 30 basespeed: 15 Numberuses: 10
			//OUTPUT is Attacking
			Fire_Firestorm.setUser(this);
			output = Fire_Firestorm.doAttack();
			break;
		case 3: attackId = 3; //Name: Fire_Inferno Basedammage: 35 basespeed: 10 Numberuses: 5
			//OUTPUT is Attacking
			Fire_Ember.setUser(this);
			output = Fire_Ember.doAttack();
			break;
		case 4: attackId = 4; //Name: Fire_Hit Basedammage: 35 basespeed: 10 Numberuses: 5
			//OUTPUT is Attacking
			Fire_Inferno.setUser(this);
			output = Fire_Inferno.doAttack();
			break;
		case 5: attackId = 5; //Name: Fire_Flamethrow Basedammage: 25 basespeed: 10 Numberuses: 30
			//OUTPUT is Attacking
			Fire_Flametrow.setUser(this);
			output = Fire_Flametrow.doAttack();
			break;
		case 6: attackId = 6; //Name: Normal_Cut Basedammage: 10 basespeed: 50 Numberuses: 20
			//OUTPUT is Attacking
			Normal_Cut.setUser(this);
			output = Normal_Cut.doAttack();
			break;
		case 7: attackId = 7; //Name: Fire_Apocalypse Basedammage: 5000 basespeed: 5000 Numberuses: 1
			//OUTPUT is Attacking
			Fire_Apocalypse.setUser(this);
			this.setHealthPoints(0);
			output = Fire_Apocalypse.doAttack();
			//Kill this Javamon and output
			break;
		default:
			System.out.println("Default");
			break;
		}*/
		
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
				 if (attackInfo[1] == 4)
				 {
					 damage = damage - 10;
				 }
				 else if (attackInfo[1] == 3 || attackInfo[1] == 5)
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
						 textlog.appendText("\n" + this.getName() + " is a Firetype Javamon, so it cant Burn");
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
