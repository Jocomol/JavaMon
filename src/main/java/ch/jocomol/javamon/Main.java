package ch.jocomol.javamon;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Getter;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;


@Getter
public class Main extends Application implements Initializable{

	/*Main ist die Hauptklasse des Projekts, resp. die Klase
	 * in welcher alles initialisiert wird.
	 *
	 * Wir haben �hnlichen Code nicht immer auskommentiert, wenn es das gleiche bewirkt wie vorher.
	 */







	static int SCREEN_WIDTH = 1920;
	static int SCREEN_HEIGHT = 1080;
	static int roundcounter = 1;
	static Stage stage;
	static Scene optionScene;
	static Scene scene;
	static Pane mainPane;
	public static Scene gamescene;
	static MediaPlayer mp;
	static Media sound;
	static String uri;
	static Battle battle = new Battle();
	static Human Computer = new Human("Blue");
	static Player You = new Player("Red");
	static Javamon Javamon1, Javamon2,  Javamon3,  Javamon4, Javamon5, Javamon6, Javamon7, Javamon8, Javamon9, Javamon10, Javamon11, Javamon12;
	Controller myController = new Controller();

	public static void main(String[] args) {
		launch(args);
		/*Im Main wird die Methode launch(args) aufgerufen, welche die Konfiguration von javafx startet
		  und schlussendlich die Methode start() aufruft. Start ist jetzt die eigentliche
		 * */
	}


	@Override
	public void start(Stage primaryStage) throws Exception{

		//Alle Javamons werden erstellt, und Ihnen werden Ihre Werte zugewiesen

		Javamon1 = new Watermon("Splattercrock", "Splattercrock", "Water", 25, 150, 20,10, 4, 3, 6, 2); //String name, String race, String type, int defense, int healthPoints, int agility
		Javamon2 = new Firemon("Glupato", "Glupato", "Fire", 20, 130, 25, 10, 4, 1, 3, 5);
		Javamon3 = new Flowermon("Mushish", "Mushish", "Flower", 20, 130, 25, 10, 4, 1,2,3);
		Javamon4 = new Frogmon("Keraxol", "Keraxol", "Frog", 20, 120, 30, 10, 4, 1, 5, 2);
		Javamon5 = new Flowermon("Tadtus", "Tadtus", "Flower", 10, 155, 15, 10, 3, 1, 5, 2);
		Javamon6 = new Dirtmon("Pitrap", "Pitrap", "Dirt", 10, 140, 15, 10, 4,2,1,3);

		Javamon7 = new Watermon("Fighcarp", "Fighcarp", "Water", 10, 165, 15, 10,6,1,2,4);
		Javamon8 = new Firemon("Insanic", "Insanic", "Fire", 40, 130, 10, 10, 3, 6, 5, 2);
		Javamon9 = new Frogmon("Salagrot", "Salagrot", "Frog", 30, 150, 15, 10,3,2,5,1);
		Javamon10 = new Watermon("Ganson", "Ganson", "Water", 15, 130, 15, 10,5,2,1,4);
		Javamon11 = new Watermon("Splendesa", "Splendesa", "Water", 30, 140, 10, 10,3,4,2,1);
		Javamon12 = new Dirtmon("Grabofk", "Grabofk", "Dirt", 30, 140, 10, 10, 7, 1, 3, 4);

		//URL des GegnerJavamons setzen

		Javamon1.setUrl("file:images/Splattercrock.png");
		Javamon2.setUrl("file:images/Glupato.png");
		Javamon3.setUrl("file:images/Munish.png");
		Javamon4.setUrl("file:images/Keraxol.png");
		Javamon5.setUrl("file:images/Tadtus.png");
		Javamon6.setUrl("file:images/Pitrap.png");
		Javamon7.setUrl("file:images/Fighcarp.png");
		Javamon8.setUrl("file:images/Insanic.png");
		Javamon9.setUrl("file:images/Salagrot.png");
		Javamon10.setUrl("file:images/Ganson.png");
		Javamon11.setUrl("file:images/Splendesa.png");
		Javamon12.setUrl("file:images/Grabovsk.png");


		//URL vom Javamon des Spielers setzen(Bild vom Javamon von hinten)

		Javamon1.setMyurl("file:images/Splattercrock_back.png");
		Javamon2.setMyurl("file:images/Glupato_back.png");
		Javamon3.setMyurl("file:images/Munish_back.png");
		Javamon4.setMyurl("file:images/Keraxol_back.png");
		Javamon5.setMyurl("file:images/Tadtus_back.png");
		Javamon6.setMyurl("file:images/Pitrap_back.png");
		Javamon7.setMyurl("file:images/Fighcarp_back.png");
		Javamon8.setMyurl("file:images/Insanic_back.png");
		Javamon9.setMyurl("file:images/Salagrot_back.png");
		Javamon10.setMyurl("file:images/Ganson_back.png");
		Javamon11.setMyurl("file:images/Splendesa_back.png");
		Javamon12.setMyurl("file:images/Grabovsk_back.png");



		//Hier wird ein Neuer MediaPlayer erstellt, welcher, solange man im Menu ist den Javamon-Titelsong abspielt
		//Er kann durch den Mute Button gemutet werden, und befindet sich in einem Loop

		uri = new File("sound", "javamon.wav").toURI().toString();
		sound = new Media(uri);
		mp = new MediaPlayer(sound);
		mp.setVolume(0.1);
		mp.setCycleCount(MediaPlayer.INDEFINITE);
		mp.play();

		//stage ist die Primary stage, also kann man die Primary Stage einfach �ber Stage ansprechen
		//Da wir nur eine Stage benutzen ist das ein effizienter, und simpler Weg
		stage = primaryStage;
		stage.setFullScreenExitHint("full");
		stage.initStyle(StageStyle.UNDECORATED);


		//Das FXML File wird in den Parent root geladen(root, da es das HauptMenu ist)
		Parent root = FXMLLoader.load(getClass().getResource("/application/MenuFXML.fxml"));

		/*Die Standart Scene wird erstellt, und mittels root(oben) initialisiert
		SCREEN_WIDTH und SCREEN_HEIHT sind die konstanten Masse des Screens. K�nnte auch mit ver�nderbar gemacht werden,
		aber war hier nicht wichtig*/
		scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
		try
		{
		scene.getStylesheets().add("application/application.css");		//CSS wird zugewiesen

		}catch(Exception e)
		{
			e.getMessage();
		}




		primaryStage.setScene(scene);	//Scene wird auf die Stage gesetzt
		primaryStage.setTitle("Javamon -- v.0.1-Alpha");	//wird nicht angezeigt
		primaryStage.show();	//Stage wird angezeigt


	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//Wird hier nicht benutzt(Auto Implementierung)

	}

}
