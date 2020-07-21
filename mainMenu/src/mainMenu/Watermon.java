package mainMenu;

import javafx.scene.control.TextArea;

public class Watermon extends Javamon
{
	Controller myController = new Controller();
	//Varaibles
	Attack Normal_Hit = new Attack("Hit", 20, 15, 25, 0, 1); //String name, int dammage, int attackspeed, int nummberuses, int type
	Attack Water_Hydrocannon = new Attack("Hydrocannon", 40, 30, 5, 3, 2);
	Attack Water_Hydropump = new Attack("Hydropump", 20, 20, 15, 3, 3);
	Attack Normal_Cut = new Attack("Cut", 10, 50, 30, 0, 4);
	Attack Water_WaterHit = new Attack("Waterhit", 20, 15, 25, 3, 5);
	Attack Water_Aquajet = new Attack("Aquajet", 30, 15, 15, 3, 6);
	Attack Water_Drown = new Attack("Drown", 100, 100, 1, 3, 7);
	{
	this.coulddoattaks[0] = Normal_Hit;
	this.coulddoattaks[1] = Water_Hydrocannon;
	this.coulddoattaks[2] = Water_Hydropump;
	this.coulddoattaks[3] = Normal_Cut;
	this.coulddoattaks[4] = Water_WaterHit;
	this.coulddoattaks[5] = Water_Aquajet;
	this.coulddoattaks[6] = Water_Drown;
	}	
	//getter and setter
	//methods
	public Watermon(String name, String race, String type, int defense, int healthPoints, int agility, int level, int attack1, int attack2, int attack3, int attack4) 
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
		
		
		/*case 1: attackId = 1; //Name: Normal_Hit Basedammage: 20 basespeed: 15 Numberuses: 25
			//OUTPUT is Attacking
			Normal_Hit.setUser(this);
			output = Normal_Hit.doAttack();
			break;
		case 2: attackId = 2; //Name:  Water_Hydrocannon Basedammage: 40 basespeed: 30 Numberuses: 5
			//OUTPUT is Attacking
		 	Water_Hydrocannon.setUser(this);
			output = Water_Hydrocannon.doAttack();
			break;
		case 3: attackId = 3; //Name: Water_Hydropump Basedammage: 20 basespeed: 20 Numberuses: 15
			//OUTPUT is Attacking
			Water_Hydropump.setUser(this);
			output = Water_Hydropump.doAttack();
			break;
		case 4: attackId = 4; //Name: Water_WaterHit Basedammage: 20 basespeed: 15 Numberuses: 25
			//OUTPUT is Attacking
			Water_WaterHit.setUser(this);
			output = Water_WaterHit.doAttack();
			break;
		case 5: attackId = 5; //Name: Water_Aquajet Basedammage: 30 basespeed: 15 Numberuses: 15
			//OUTPUT is Attacking
			Water_Aquajet.setUser(this);
			output = Water_Aquajet.doAttack();
			break;
		case 6: attackId = 6; //Name: Normal_Cut Basedammage: 10 basespeed: 50 Numberuses: 20
			//OUTPUT is Attacking
			Normal_Cut.setUser(this);
			output = Normal_Cut.doAttack();
			break;
		case 7: attackId = 7; //Name: Water_Drown Basedammage: 100 basespeed: 100 Numberuses: 1
			//OUTPUT is Attacking
			Water_Drown.setUser(this);
			output = Water_Drown.doAttack();
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


