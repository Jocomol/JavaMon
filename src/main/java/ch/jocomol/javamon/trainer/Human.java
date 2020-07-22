package ch.jocomol.javamon.trainer;

import ch.jocomol.javamon.Controller;
import ch.jocomol.javamon.Item;
import ch.jocomol.javamon.Main;
import ch.jocomol.javamon.javamon.Javamon;
import javafx.scene.control.Button;
import lombok.Getter;

import java.util.Random;

@Getter
public class Human {
	private Javamon[] mainmons = new Javamon[6];
	private Item[] health = new Item[5];
	private Item[] depoison = new Item[5];
	private Item[] deburner = new Item[5];
	private Item[] reviverstrong = new Item[5];
	private Item[] reviverweak = new Item[5];
	private String name;
	private int points;
	private Javamon currentJavamon;
	private Random randomGenerator = new Random();
	private boolean hasLost = false;
	private Controller myController = new Controller();

	public Human(String name) {
		this.name = name;
	}

	public int chooseAttack() {
		int outputattack = randomGenerator.nextInt(4);
		return outputattack;
	}


	public void changeJavamon() {
		boolean javamonalive = false;
		for (Javamon javamon : mainmons) {
			if (javamon != null) {
				javamonalive = javamon.isDead();
			}
		}
		if (javamonalive) {
			boolean javaonchosen = false;
			while (!javaonchosen) {
				int randomIntjavamon = randomGenerator.nextInt(6);
				if (mainmons[randomIntjavamon] != null && !mainmons[randomIntjavamon].isDead()) {
					this.currentJavamon.getEnemy().setEnemy(mainmons[randomIntjavamon]);
					this.mainmons[randomIntjavamon].setEnemy(this.currentJavamon.getEnemy());
					this.setCurrentJavamon (mainmons[randomIntjavamon]);
					System.out.println(this.getName() + " chooses " + this.getCurrentJavamon().getName() + " as his next Javamon");
					javaonchosen = true;
				}
			}
		} else {
			System.out.println(this.getName() + " has no Javamons left");
			this.currentJavamon.setDead(true);
			this.hasLost = true;

			Button switchbtn = (Button) Main.gamescene.lookup("#switchJavamon");
			switchbtn.setDisable(true);
			switchbtn.setVisible(false);

			Button attackbtn = (Button) Main.gamescene.lookup("#attackJavamon");
			attackbtn.setDisable(true);
			switchbtn.setVisible(false);
		}
	}

	public void setCurrentJavamon(Javamon currentJavamon) {
		this.currentJavamon = currentJavamon;
		currentJavamon.setTrainer(this);
	}

	public void addMainmon(Javamon mainmon){

	}
}
