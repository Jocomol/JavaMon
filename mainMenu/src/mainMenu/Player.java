package mainMenu;

import javafx.scene.control.Button;

public class Player extends Human {
	
	Controller myController = new Controller();

	public Player(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public int chooseAttack(int atk) {		
		return atk;
	}
	public void changeJavamon() {
		
	
	
	boolean javamonalive = false;
	for (Javamon javam : this.mainmons) {
		if (javam != null) {
			if (javam.isAlife() == true) {
				javamonalive = true;
			}
		}
	}
	if (javamonalive == true) {
			
				
				
				myController.callSwitchJavamon();
				System.out.println(this.getName() + " chooses " + this.getCurrentJavamon().getName() + " as his next Javamon");


		}
	 else {
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
