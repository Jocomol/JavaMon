package mainMenu;

import java.util.Random;

import javafx.scene.control.Button;

public class Human {
	// variables
	Javamon[] mainmons = new Javamon[6];
	Item[] health = new Item[5];
	Item[] depoison = new Item[5];
	Item[] deburner = new Item[5];
	Item[] reviverstrong = new Item[5];
	Item[] reviverweak = new Item[5];
	String Name;
	private int points;
	Javamon currentJavamon;
	Random randomGenerator = new Random();
	boolean hasLost = false;
	Controller myController = new Controller();

	// getter and setter
	public Javamon[] getMainmons() {
		return mainmons;
	}

	public void setMainmons(Javamon[] mainmons) {
		this.mainmons = mainmons;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Javamon getCurrentJavamon() {
		return currentJavamon;
	}

	public void setCurrentJavamon(Javamon currentJavamon) {
		this.currentJavamon = currentJavamon;
		currentJavamon.setTrainer(this);
	}

	public boolean isHasLost() {
		return hasLost;
	}

	public void setHasLost(boolean hasLost) {
		this.hasLost = hasLost;
	}

	// Methods
	
	public Human(String name)
	{
		this.setName(name);
	}
	public int chooseAttack() {
		int outputattack = randomGenerator.nextInt(4);
		/*int[] attackIds = currentJavamon.getAviableAttacks();
		int outputattack = attackIds[randomInt]; */
		return outputattack;
	}


	public void changeJavamon() {
		boolean javamonalive = false;
		for (Javamon javam : mainmons) {
			if (javam != null) {
				if (javam.isAlife() == true) {
					javamonalive = true;
				}
			}
		}
		if (javamonalive == true) {
			boolean javaonchosen = false;
			while (javaonchosen == false) {
				int randomIntjavamon = randomGenerator.nextInt(6);
				if (mainmons[randomIntjavamon] != null && mainmons[randomIntjavamon].isAlife()) 
				{
					
					this.currentJavamon.enemy.setEnemy(mainmons[randomIntjavamon]);
					this.mainmons[randomIntjavamon].setEnemy(this.currentJavamon.enemy);
					
					
					this.setCurrentJavamon (mainmons[randomIntjavamon]);
					
					
					System.out.println(this.getName() + " chooses " + this.getCurrentJavamon().getName() + " as his next Javamon");
					javaonchosen = true;
				}
				else
				{
					
				}

			}
		} else {
			//OUPUT No javamons left
			System.out.println(this.getName() + " has no Javamons left");
			this.currentJavamon.setIsdead(true);
			this.setHasLost(true);
			
			Button switchbtn = (Button) Main.gamescene.lookup("#switchJavamon");
			switchbtn.setDisable(true);
			switchbtn.setVisible(false);
			
			Button attackbtn = (Button) Main.gamescene.lookup("#attackJavamon");
			attackbtn.setDisable(true);
			switchbtn.setVisible(false);
			

		}
	}
}
