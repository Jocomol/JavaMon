package ch.jocomol.javamon;

import ch.jocomol.javamon.javamon.*;
import ch.jocomol.javamon.trainer.Human;

public class Battle
{
	//variables
	//Getter and setter
	//methods
	public void initBattle()
	{
		Human Player = new Human("Red");
		Javamon playermon1 = new Watermon("Splattercrock", "Splattercrock", "Water", 25, 150, 20,10, 1, 3, 6, 2); //String name, String race, String type, int defense, int healthPoints, int agility
		Javamon playermon2 = new Firemon("Glupato", "Glupato", "Fire", 20, 130, 25, 10, 4, 1, 3, 5);
		Javamon playermon3 = new Flowermon("Mushish", "Mushish", "Flower", 20, 130, 25, 10, 4, 1,2,3);
		Javamon playermon4 = new Frogmon("Keraxol", "Keraxol", "Frog", 20, 120, 30, 10, 4, 1, 4, 2);
		Javamon playermon5 = new Flowermon("Tadtus", "Tadtus", "Flower", 10, 155, 15, 10, 3, 1, 5, 2);
		Javamon playermon6 = new Dirtmon("Pitrap", "Pitrap", "Dirt", 10, 140, 15, 10, 4,2,1,3);
		Player.mainmons[0] = playermon1;
		Player.mainmons[1] = playermon2;
		Player.mainmons[2] = playermon3;
		Player.mainmons[3] = playermon4;
		Player.mainmons[4] = playermon5;
		Player.mainmons[5] = playermon6;
		Player.setCurrentJavamon(Player.mainmons[0]);

		Human Computer = new Human("Blue");
		Javamon computermon1 = new Watermon("Fighcarp", "Fighcarp", "Water", 10, 165, 15, 10,6,1,2,4);
		Javamon computermon2 = new Firemon("Insanic", "Insanic", "Fire", 40, 130, 10, 10, 3, 6, 5, 2);
		Javamon computermon3 = new Frogmon("Salagrot", "Salagrot", "Frog", 30, 150, 15, 10,3,2,5,1);
		Javamon computermon4 = new Watermon("Ganson", "Ganson", "Water", 15, 130, 15, 10,5,2,1,4);
		Javamon computermon5 = new Watermon("Splendesa", "Splendesa", "Water", 30, 140, 10, 10,3,4,2,1);
		Javamon computermon6 = new Dirtmon("Grabofk", "Grabofk", "Dirt", 30, 140, 10, 10, 7, 1, 3, 4);
		Computer.mainmons[0] = computermon1;
		Computer.mainmons[1] = computermon2;
		Computer.mainmons[2] = computermon3;
		Computer.mainmons[3] = computermon4;
		Computer.mainmons[4] = computermon5;
		Computer.mainmons[5] = computermon6;
		Computer.setCurrentJavamon(Computer.mainmons[0]);

		Player.getCurrentJavamon().setEnemy(Computer.getCurrentJavamon());
		Computer.getCurrentJavamon().setEnemy(Player.getCurrentJavamon());





	}
}
