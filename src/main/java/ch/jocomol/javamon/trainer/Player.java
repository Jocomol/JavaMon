package ch.jocomol.javamon.trainer;

import ch.jocomol.javamon.Controller;
import ch.jocomol.javamon.Main;
import ch.jocomol.javamon.javamon.Javamon;
import javafx.scene.control.Button;

public class Player extends Human {

	private Controller myController;

	public Player(String name) {
		super(name);
		this.myController = new Controller();
	}

	public void changeJavamon() {
	boolean javamonalive = false;
	for (Javamon javamon : this.getMainmons()) {
		if (javamon != null) {
			javamonalive = javamon.isDead();
		}
	}
	if (javamonalive) {
		myController.callSwitchJavamon();
		System.out.println(this.getName() + " chooses " + this.getCurrentJavamon().getName() + " as his next Javamon");
	} else {
		System.out.println(this.getName() + " has no Javamons left");
		this.currentJavamon.setDead(true);
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
