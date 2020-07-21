package mainMenu;




import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;




public class Controller implements Initializable{
	
	/*
	 * Die Controller Klasse ist der "Controller vom Projekt. Über sie werden die XML und CSS Komponenten angesprochen."
	 * Sie ist ziemlich gross, und man hätte auch mehrere Controllerklassen bauen können, aber das hätte es viel unübersichtlicher gemacht.
	 * 
	 * Alle call Funktionen(callOptions usw.) sind dazu da, die FXML Files und die Stylesheets ins Gui zu laden. Wir haben alle so genannt,
	 * damit wir eine gute Übersicht haben.
	 */
	
	
	

	public Button volume_button;
	static int SCREEN_WIDTH = 1920;
	static int SCREEN_HEIGHT = 1080;
	static String action = "-   -   -   -   FIGHT   -   -   -   -";
	static boolean muted = false;
	static boolean notChoosenOne = true, notChoosenTwo = true, notChoosenThree = true, notChoosenFour = true, notChoosenFive = true, notChoosenSix = true, notChoosenSeven = true, notChoosenEight = true, notChoosenNine = true, notChoosenTen = true, notChoosenEleven = true, notChoosenTwelve = true;
	static int myteamcount;
	static String urlJone = "file:images/Splendesa.png", urlJtwo = "file:images/Glupato.png", urlJthree = "file:images/Insanic.png", urlJfour = "file:images/Fighcarp.png", urlJfive = "file:images/Splattercrock.png", urlJsix = "file:images/Keraxol.png", urlJseven = "file:images/Ganson.png", urlJeight = "file:images/Pitrap.png", urlJnine = "file:images/Salagrot.png", urlJten = "file:images/Tadtus.png", urlJeleven = "file:images/Munish.png", urlJtwelve = "file:images/Grabovsk.png";
	static String menuuri, fighturi;
	static Media menusound, fightsound;
	static MediaPlayer menump, fightmp;
	static Scene pickerscene;
	static Label yTeam;
	static Button Jone, Jtwo, Jthree, Jfour, Jfive, Jsix, Jseven, Jeight, Jnine, Jten, Jeleven, Jtwelve, attackJmon, run, attackOne, attackTwo, attackThree, attackFour;
	static Scene gamescene;
	static boolean switchable = true, attackable = true;
	
	
	@FXML
	private FlowPane switchmons;
	
	@FXML
	public static Button start, switchJmon;
	
	@FXML
	private ImageView enemyplatform;
	
	@FXML
	private ImageView platform;
	
	@FXML 
	private TextArea textlog;
	
	@FXML
	private Button great;
	
	@FXML
	private ScrollPane sp;
	
	
	
	
	/*
	 *Einfache Funktion um das Spiel zu beenden 
	 */
	 
	public void quitGame()
	{
		try {
			
			Thread.sleep(500);
			
		} catch (InterruptedException e) {
			
			e.getMessage();
		}
		
		System.exit(0);
	}
	
	
	
    public void callOptions()	//Options Gui wird geladen
    {
    	
    	 try{
    		 //Files werden geladen, Scene wird erstellt und gesetzt
    		Parent optparent = FXMLLoader.load(getClass().getResource("/application/OptionsFXML.fxml"));
    		Scene optscene = new Scene(optparent, SCREEN_WIDTH, SCREEN_HEIGHT);  
    		optscene.getStylesheets().add("application/application_option.css");
    		Main.stage.setScene(optscene);
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
    public void callMenu()
    {
    	
    	try {
    		
    		Main.stage.setScene(Main.scene);
    		
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
    }
	

    
    @FXML
    public void gamePlay()		//Game wird gestartet
    {
    	Main.mp.stop();
    	menuuri = new File("sound", "fightmenu_theme.wav").toURI().toString();
		menusound = new Media(menuuri);
		menump = new MediaPlayer(menusound);
		menump.setVolume(0.1);
		menump.setCycleCount(MediaPlayer.INDEFINITE);
		menump.play();
    	
    	
					
		
    	try{
    		Parent teamparent = FXMLLoader.load(getClass().getResource("/application/Teampicker.fxml"));
    		pickerscene = new Scene(teamparent, SCREEN_WIDTH, SCREEN_HEIGHT);
    		pickerscene.getStylesheets().add("/application/Picker.css");
    		Main.stage.setScene(pickerscene);
    		
    		
    		FlowPane allJmons = (FlowPane) pickerscene.lookup("#fpAllJavamons");
    		
    		allJmons.setPrefWidth(allJmons.getWidth() / 3);
    		allJmons.setLayoutX(64);
    		allJmons.setLayoutY(55);
    		allJmons.setLayoutY(allJmons.getLayoutY());
    		
    		
    		//Javamon Buttons werden erstellt und Ihre Bilder werden gesetzt
    		
    		Jone = new Button();
    		Jtwo = new Button();
    		Jthree = new Button();
    		Jfour = new Button();
    		Jfive = new Button();
    		Jsix= new Button();
    		Jseven = new Button();
    		Jeight = new Button();
    		Jnine = new Button();
    		Jten = new Button();
    		Jeleven = new Button();
    		Jtwelve = new Button();
    		
    		allJmons.getChildren().add(Jone);
    		allJmons.getChildren().add(Jtwo);
    		allJmons.getChildren().add(Jthree);
    		allJmons.getChildren().add(Jfour);
    		allJmons.getChildren().add(Jfive);
    		allJmons.getChildren().add(Jsix);
    		allJmons.getChildren().add(Jseven);
    		allJmons.getChildren().add(Jeight);
    		allJmons.getChildren().add(Jnine);
    		allJmons.getChildren().add(Jten);
    		allJmons.getChildren().add(Jeleven);
    		allJmons.getChildren().add(Jtwelve);
    		
    		
    		
    		
    		
    		Jone.setPrefSize(128, 128);
    		Jtwo.setPrefSize(128, 128);
    		Jthree.setPrefSize(128, 128);
    		Jfour.setPrefSize(128, 128);
    		Jfive.setPrefSize(128, 128);
    		Jsix.setPrefSize(128, 128);
    		Jseven.setPrefSize(128, 128);
    		Jeight.setPrefSize(128, 128);
    		Jnine.setPrefSize(128, 128);
    		Jten.setPrefSize(128, 128);
    		Jeleven.setPrefSize(128, 128);
    		Jtwelve.setPrefSize(128, 128);
    		
    		Jone.setStyle("-fx-background-image: url(" + Main.Javamon11.getUrl() + ")");
    		Jtwo.setStyle("-fx-background-image: url(" + Main.Javamon2.getUrl()+ ")");
    		Jthree.setStyle("-fx-background-image: url(" + Main.Javamon8.getUrl() + ")");
    		Jfour.setStyle("-fx-background-image: url(" + Main.Javamon7.getUrl() + ")");
    		Jfive.setStyle("-fx-background-image: url(" + Main.Javamon1.getUrl() + ")");
    		Jsix.setStyle("-fx-background-image: url(" + Main.Javamon4.getUrl() + ")");
    		Jseven.setStyle("-fx-background-image: url(" + Main.Javamon10.getUrl() + ")");
    		Jeight.setStyle("-fx-background-image: url(" + Main.Javamon6.getUrl() + ")");
    		Jnine.setStyle("-fx-background-image: url(" + Main.Javamon9.getUrl() + ")");
    		Jten.setStyle("-fx-background-image: url(" + Main.Javamon5.getUrl() + ")");
    		Jeleven.setStyle("-fx-background-image: url(" + Main.Javamon3.getUrl() + ")");
    		Jtwelve.setStyle("-fx-background-image: url(" + Main.Javamon12.getUrl() + ")");
    		
    		Jone.setOnAction(E->{
    			
    			actionButtonZero();
    		});
    		
    		Jtwo.setOnAction(E->{
    			
    			actionButtonOne();
    		});
    		
    		Jthree.setOnAction(E->{
    			
    			actionButtonTwo();
    		});
    		
    		Jfour.setOnAction(E->{
    			
    			actionButtonThree();
    		});
    		
    		Jfive.setOnAction(E->{
    			
    			actionButtonFour();
    		});
    		
    		Jsix.setOnAction(E->{
    			
    			actionButtonFive();
    		});
    		
    		Jseven.setOnAction(E->{
    			
    			actionButtonSix();
    		});
    		
    		Jeight.setOnAction(E->{
    			
    			actionButtonSeven();
    		});
    		
    		Jnine.setOnAction(E->{
    			
    			actionButtonEight();
    		});
    		
    		Jten.setOnAction(E->{
    			
    			actionButtonNine();
    		});
    		
    		Jeleven.setOnAction(E->{
    			
    			actionButtonTen();
    		});
    		
    		Jtwelve.setOnAction(E->{
    		
    			actionButtonEleven();
    		});
    		
    		yTeam = (Label) pickerscene.lookup("#yourteamtitle");
    		
    		yTeam.setStyle("-fx-font-size: 60px");
    		
    		start = (Button) pickerscene.lookup("#gamestartButton");
    		
    		start.setStyle("-fx-background-radius: 180");
    		
    		
    		start.setVisible(true);
    		start.setOnAction(E->{
    			if(myteamcount == 6){
    				callFight();
    			}
    			
    		});
    		
    		
    		
    		
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	
    		
    }
    
    public void volumeSwitch(){
    	Button vbtn = (Button) Main.scene.lookup("#volume_button");
    	
    	if(Main.mp.getStatus().equals(Status.PLAYING) && muted == false){
    		Main.mp.setMute(true);
    		vbtn.setStyle("-fx-background-image: url('file:images/volume_off.png')");
    		muted = true;
    	}
    	else if(Main.mp.getStatus().equals(Status.PLAYING) && muted == true){
    		Main.mp.setMute(false);
    		vbtn.setStyle("-fx-background-image: url('file:images/volume_on.png')");
    		muted = false;
    	}
    }
    
    public void callCredits()
    {
    	try {
    		
			Parent creditsparent = FXMLLoader.load(getClass().getResource("/application/CreditsFXML.fxml"));
			Scene creditsscene = new Scene(creditsparent, SCREEN_WIDTH, SCREEN_HEIGHT);
			creditsscene.getStylesheets().add("/application/Credits.css");
			Main.stage.setScene(creditsscene);
			
			
			ImageView creditsimage = (ImageView) creditsscene.lookup("#creditsImage");
			Image crimg = new Image("file:images/credits.png");
			creditsimage.setImage(crimg);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}
	
	
	
	public void buildteams(){
		
		int ice = 0;
		int icy = 0;
		
		FlowPane allJmons = (FlowPane) pickerscene.lookup("#fpAllJavamons");
		
		
		if(allJmons.getChildren().contains(Jone)){
			Main.Computer.mainmons[ice] = Main.Javamon11;
			ice++;
		}
		else{
			Main.You.mainmons[icy] = Main.Javamon11;
			icy++;
		}
		
		if(allJmons.getChildren().contains(Jtwo)){
			Main.Computer.mainmons[ice] = Main.Javamon2;
			ice++;
		}
		else{
			Main.You.mainmons[icy] = Main.Javamon2;
			icy++;	
		}
		

		if(allJmons.getChildren().contains(Jthree)){
			Main.Computer.mainmons[ice] = Main.Javamon8;
			ice++;
		}
		else{
			Main.You.mainmons[icy] = Main.Javamon8;
			icy++;
		}
		
		if(allJmons.getChildren().contains(Jfour)){
			Main.Computer.mainmons[ice] = Main.Javamon7;
			ice++;
		}
		else{
			Main.You.mainmons[icy] = Main.Javamon7;
			icy++;
		}
		
		if(allJmons.getChildren().contains(Jfive)){
			Main.Computer.mainmons[ice] = Main.Javamon1;
			ice++;
		}
		else{
			Main.You.mainmons[icy] = Main.Javamon1;
			icy++;
		}
		
		if(allJmons.getChildren().contains(Jsix)){
			Main.Computer.mainmons[ice] = Main.Javamon4;
			ice++;
		}
		else{
			Main.You.mainmons[icy] = Main.Javamon4;
			icy++;
		}
		
		if(allJmons.getChildren().contains(Jseven)){
			Main.Computer.mainmons[ice] = Main.Javamon10;
			ice++;
		}
		else{
			Main.You.mainmons[icy] = Main.Javamon10;
			icy++;
		}
		
		if(allJmons.getChildren().contains(Jeight)){
			Main.Computer.mainmons[ice] = Main.Javamon6;
			ice++;
		}
		else{
			Main.You.mainmons[icy] = Main.Javamon6;
			icy++;
		}
		
		if(allJmons.getChildren().contains(Jnine)){
			Main.Computer.mainmons[ice] = Main.Javamon9;
			ice++;
		}
		else{
			Main.You.mainmons[icy] = Main.Javamon9;
			icy++;
		}
		
		if(allJmons.getChildren().contains(Jten)){
			Main.Computer.mainmons[ice] = Main.Javamon5;
			ice++;
		}
		else{
			Main.You.mainmons[icy] = Main.Javamon5;
			icy++;
		}
		if(allJmons.getChildren().contains(Jeleven)){
			Main.Computer.mainmons[ice] = Main.Javamon3;
			ice++;
		}
		else{
			Main.You.mainmons[icy] = Main.Javamon3;
			icy++;
		}
		
		if(allJmons.getChildren().contains(Jtwelve)){
			Main.Computer.mainmons[ice] = Main.Javamon12;
			ice++;
		}
		else{
			Main.You.mainmons[icy] = Main.Javamon12;
			icy++;
		}
		
		
		
		shuffleArray(Main.You.mainmons);
		shuffleArray(Main.Computer.mainmons);
		
		Main.You.setCurrentJavamon(Main.You.mainmons[0]);
		Main.Computer.setCurrentJavamon(Main.Computer.mainmons[0]);
		
		Main.You.getCurrentJavamon().setEnemy(Main.Computer.getCurrentJavamon());
		Main.Computer.getCurrentJavamon().setEnemy(Main.You.getCurrentJavamon());
		
	}
	
	
	public void callFight(){
		
		try{
			buildteams();
			
			
    		menump.stop();
    		
    		fighturi = new File("sound", "battle_theme.wav").toURI().toString();
    		fightsound = new Media(fighturi);
    		fightmp = new MediaPlayer(fightsound);
    		fightmp.setVolume(0.1);
    		fightmp.setCycleCount(MediaPlayer.INDEFINITE);
    		fightmp.play();
    		
    		Parent gameparent = FXMLLoader.load(getClass().getResource("/application/GameFXML.fxml"));
    		gamescene = new Scene(gameparent, SCREEN_WIDTH, SCREEN_HEIGHT);
    		gamescene.getStylesheets().add("application/game.css");
    		Main.stage.setScene(gamescene);	
    		
    		
    		switchimagesenemy();
    		switchimagesyou();
    		
    		/*
    		ImageView enemy = (ImageView) gamescene.lookup("#enemyYovamon");
    		ImageView yourJavamon = (ImageView) gamescene.lookup("#yourJavamon");
    		
    		
    		
    		
    		enemy.setStyle("-fx-background-image: url(" + Main.Computer.getCurrentJavamon().getUrl() + ")");
    		*/
    		
    		
    		TextArea ta = (TextArea) gamescene.lookup("#textlog");
    		ta.setText(action + "\n");
    		ta.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
    		
    		ImageView ime = (ImageView) gamescene.lookup("#enemyplatform");
    		Image enpf = new Image("file:images/platform_forest.png");
    		ime.setImage(enpf);
    		
    		ImageView imp = (ImageView) gamescene.lookup("#platform");
    		Image ppf = new Image("file:images/platform.png");
    		imp.setImage(ppf);
    		
    		ta.setEditable(false);
    		
    		switchJmon = (Button) gamescene.lookup("#switchJavamon");
    		switchJmon.setPrefSize(150, 60);
    		switchJmon.setStyle("-fx-background-color: #1EA340;");
    		switchJmon.setText("Switch");
    		
    		attackJmon = (Button) gamescene.lookup("#attackJavamon");
    		attackJmon.setPrefSize(150, 60);
    		attackJmon.setStyle("-fx-background-color: #FF4425;");
    		attackJmon.setText("Attack");
    		attackJmon.setLayoutX(885);
    		
    		run = (Button) gamescene.lookup("#run");
    		run.setPrefSize(150, 60);
    		run.setLayoutX(SCREEN_WIDTH - 150);
    		run.setStyle("-fx-background-color: #2254FF;");
    		run.setText("Run");
    		
	
    		
    	} catch(Exception e)
    	{
    		
    		e.printStackTrace();
    	}
    	

		
		    
		
	}
	
	public void switchimagesenemy(){
		
		Image newenemy = new Image(Main.Computer.currentJavamon.getUrl());
		ImageView enemyImage = (ImageView) Main.stage.getScene().lookup("#enemyJavamon");
		
		if(Main.Computer.isHasLost() == false){
			enemyImage.setImage(newenemy);
		}
		else{
			enemyImage.setImage(null);
		}
	}
	
	
	public void switchimagesyou(){
		
		Image newYou = new Image(Main.You.currentJavamon.getMyurl());
		ImageView youImage = (ImageView) Main.stage.getScene().lookup("#yourJavamon");
		
		if(Main.You.isHasLost() == false){
			youImage.setImage(newYou);
		}
		else{
			youImage.setImage(null);
		}
	}
		
	
	
	public void callSwitchJavamon(){
		
		
			try {
				
				switchable = false;
				Parent switchparent = FXMLLoader.load(getClass().getResource("/application/SwitchFXML.fxml"));
				Scene switchscene = new Scene(switchparent, SCREEN_WIDTH, SCREEN_HEIGHT);
				
				Main.stage.setScene(switchscene);
				
				Button sjOne = (Button) switchscene.lookup("#sjOne");
				Button sjTwo = (Button) switchscene.lookup("#sjTwo");
				Button sjThree = (Button) switchscene.lookup("#sjThree");
				Button sjFour = (Button) switchscene.lookup("#sjFour");
				Button sjFive = (Button) switchscene.lookup("#sjFive");
				Button sjSix = (Button) switchscene.lookup("#sjSix");
				
				
				
		
				sjOne.setStyle("-fx-background-image: url(" + Main.You.mainmons[0].getUrl() +"); -fx-background-repeat: no-repeat; -fx-background-position: top center; ");
				sjTwo.setStyle("-fx-background-image: url(" + Main.You.mainmons[1].getUrl() +"); -fx-background-repeat: no-repeat; -fx-background-position: top center; ");
				sjThree.setStyle("-fx-background-image: url(" + Main.You.mainmons[2].getUrl() +"); -fx-background-repeat: no-repeat; -fx-background-position: top center; ");
				sjFour.setStyle("-fx-background-image: url(" + Main.You.mainmons[3].getUrl() +"); -fx-background-repeat: no-repeat; -fx-background-position: top center; ");
				sjFive.setStyle("-fx-background-image: url(" + Main.You.mainmons[4].getUrl() +"); -fx-background-repeat: no-repeat; -fx-background-position: top center; ");
				sjSix.setStyle("-fx-background-image: url(" + Main.You.mainmons[5].getUrl() +"); -fx-background-repeat: no-repeat; -fx-background-position: top center; ");
				
				if(Main.You.getCurrentJavamon() == Main.You.mainmons[0]){
					sjOne.setDisable(true);
					sjOne.setText("CURRENT");
				}
				
				if(Main.You.getCurrentJavamon() == Main.You.mainmons[1]){
					sjTwo.setDisable(true);
					sjTwo.setText("CURRENT");
				}
				
				if(Main.You.getCurrentJavamon() == Main.You.mainmons[2]){
					sjThree.setDisable(true);
					sjThree.setText("CURRENT");
				}
				
				if(Main.You.getCurrentJavamon() == Main.You.mainmons[3]){
					sjFour.setDisable(true);
					sjFour.setText("CURRENT");
				}
				
				if(Main.You.getCurrentJavamon() == Main.You.mainmons[4]){
					sjFive.setDisable(true);
					sjFive.setText("CURRENT");
				}
				
				if(Main.You.getCurrentJavamon() == Main.You.mainmons[5]){
					sjSix.setDisable(true);
					sjSix.setText("CURRENT");
				}
				
				
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	
	
	
	public void actionButtonZero(){
		
		FlowPane allJmons = (FlowPane) pickerscene.lookup("#fpAllJavamons");
		FlowPane myteam = (FlowPane) pickerscene.lookup("#fpYourJavamons");
		
		if(myteamcount < 6 && notChoosenOne == true){
			myteamcount += 1;
			notChoosenOne = false;
			allJmons.getChildren().remove(Jone);
			myteam.getChildren().add(Jone);
		}
		else if(notChoosenOne == false)
		{
			myteamcount -= 1;
			notChoosenOne = true;
			myteam.getChildren().remove(Jone);
			allJmons.getChildren().add(Jone);
		}
		
		
		
		
		
	}
	
	public void actionButtonOne(){
		
		FlowPane allJmons = (FlowPane) pickerscene.lookup("#fpAllJavamons");
		FlowPane myteam = (FlowPane) pickerscene.lookup("#fpYourJavamons");
		
		if(myteamcount < 6 && notChoosenTwo == true){
			myteamcount += 1;
			notChoosenTwo = false;
			allJmons.getChildren().remove(Jtwo);
			myteam.getChildren().add(Jtwo);
		}
		else if(notChoosenTwo == false)
		{
			myteamcount -= 1;
			notChoosenTwo = true;
			myteam.getChildren().remove(Jtwo);
			allJmons.getChildren().add(Jtwo);
		}
		
		
		
		
		
		}
	
	public void actionButtonTwo(){
		
		FlowPane allJmons = (FlowPane) pickerscene.lookup("#fpAllJavamons");
		FlowPane myteam = (FlowPane) pickerscene.lookup("#fpYourJavamons");
		
		if(myteamcount < 6 && notChoosenThree == true){
			myteamcount += 1;
			notChoosenThree = false;
			allJmons.getChildren().remove(Jthree);
			myteam.getChildren().add(Jthree);
		}
		else if(notChoosenThree == false)
		{
			myteamcount -= 1;
			notChoosenThree = true;
			myteam.getChildren().remove(Jthree);
			allJmons.getChildren().add(Jthree);
		}
		
		
		
		
	}
	
	public void actionButtonThree(){
		
		FlowPane allJmons = (FlowPane) pickerscene.lookup("#fpAllJavamons");
		FlowPane myteam = (FlowPane) pickerscene.lookup("#fpYourJavamons");
		
		if(myteamcount < 6 && notChoosenFour == true){
			myteamcount += 1;
			notChoosenFour = false;
			allJmons.getChildren().remove(Jfour);
			myteam.getChildren().add(Jfour);
		}
		else if(notChoosenFour == false)
		{
			myteamcount -= 1;
			notChoosenFour = true;
			myteam.getChildren().remove(Jfour);
			allJmons.getChildren().add(Jfour);
		}
		
		
		
		
	}
	
	public void actionButtonFour(){
		
		FlowPane allJmons = (FlowPane) pickerscene.lookup("#fpAllJavamons");
		FlowPane myteam = (FlowPane) pickerscene.lookup("#fpYourJavamons");
		
		if(myteamcount < 6 && notChoosenFive == true){
			myteamcount += 1;
			notChoosenFive = false;
			allJmons.getChildren().remove(Jfive);
			myteam.getChildren().add(Jfive);
		}
		else if(notChoosenFive == false)
		{
			myteamcount -= 1;
			notChoosenFive = true;
			myteam.getChildren().remove(Jfive);
			allJmons.getChildren().add(Jfive);
		}
		
		
		
		
	}
	
	public void actionButtonFive(){
		
		FlowPane allJmons = (FlowPane) pickerscene.lookup("#fpAllJavamons");
		FlowPane myteam = (FlowPane) pickerscene.lookup("#fpYourJavamons");
		
		if(myteamcount < 6 && notChoosenSix == true){
			myteamcount += 1;
			notChoosenSix = false;
			allJmons.getChildren().remove(Jsix);
			myteam.getChildren().add(Jsix);
		}
		else if(notChoosenSix == false)
		{
			myteamcount -= 1;
			notChoosenSix = true;
			myteam.getChildren().remove(Jsix);
			allJmons.getChildren().add(Jsix);
		}
		
		
		
		
	}
	
	public void actionButtonSix(){
		
		FlowPane allJmons = (FlowPane) pickerscene.lookup("#fpAllJavamons");
		FlowPane myteam = (FlowPane) pickerscene.lookup("#fpYourJavamons");
		
		if(myteamcount < 6 && notChoosenSeven){
			myteamcount += 1;
			notChoosenSeven = false;
			allJmons.getChildren().remove(Jseven);
			myteam.getChildren().add(Jseven);
		}
		else if(notChoosenSeven == false)
		{
			myteamcount -= 1;
			notChoosenSeven = true;
			myteam.getChildren().remove(Jseven);
			allJmons.getChildren().add(Jseven);
		}
		
		
		
		
	}
	
	public void actionButtonSeven(){
		
		FlowPane allJmons = (FlowPane) pickerscene.lookup("#fpAllJavamons");
		FlowPane myteam = (FlowPane) pickerscene.lookup("#fpYourJavamons");
		
		if(myteamcount < 6 && notChoosenEight == true){
			myteamcount += 1;
			notChoosenEight = false;
			allJmons.getChildren().remove(Jeight);
			myteam.getChildren().add(Jeight);
		}
		else if(notChoosenEight == false)
		{
			myteamcount -= 1;
			notChoosenEight = true;
			myteam.getChildren().remove(Jeight);
			allJmons.getChildren().add(Jeight);
		}
		
		
		
		
	}
	
	public void actionButtonEight(){
		
		FlowPane allJmons = (FlowPane) pickerscene.lookup("#fpAllJavamons");
		FlowPane myteam = (FlowPane) pickerscene.lookup("#fpYourJavamons");
		
		if(myteamcount < 6 && notChoosenNine == true){
			myteamcount += 1;
			notChoosenNine = false;
			allJmons.getChildren().remove(Jnine);
			myteam.getChildren().add(Jnine);
		}
		else if(notChoosenNine == false)
		{
			myteamcount -= 1;
			notChoosenNine = true;
			myteam.getChildren().remove(Jnine);
			allJmons.getChildren().add(Jnine);
		}
		
		
		
		
	}
	
	public void actionButtonNine(){
		
		FlowPane allJmons = (FlowPane) pickerscene.lookup("#fpAllJavamons");
		FlowPane myteam = (FlowPane) pickerscene.lookup("#fpYourJavamons");
		
		if(myteamcount < 6 && notChoosenTen == true){
			myteamcount += 1;
			notChoosenTen = false;
			allJmons.getChildren().remove(Jten);
			myteam.getChildren().add(Jten);
		}
		else if(notChoosenTen == false)
		{
			myteamcount -= 1;
			notChoosenTen = true;
			myteam.getChildren().remove(Jten);
			allJmons.getChildren().add(Jten);
		}
		
		
		
		
	}
	
	public void actionButtonTen(){
		
		FlowPane allJmons = (FlowPane) pickerscene.lookup("#fpAllJavamons");
		FlowPane myteam = (FlowPane) pickerscene.lookup("#fpYourJavamons");
		
		if(myteamcount < 6 && notChoosenEleven == true){
			myteamcount += 1;
			notChoosenEleven = false;
			allJmons.getChildren().remove(Jeleven);
			myteam.getChildren().add(Jeleven);
		}
		else if(notChoosenEleven == false)
		{
			myteamcount -= 1;
			notChoosenEleven = true;
			myteam.getChildren().remove(Jeleven);
			allJmons.getChildren().add(Jeleven);
		}
		
		
		
		
	}
	
	public void actionButtonEleven(){
		
		FlowPane allJmons = (FlowPane) pickerscene.lookup("#fpAllJavamons");
		FlowPane myteam = (FlowPane) pickerscene.lookup("#fpYourJavamons");
		
		if(myteamcount < 6 && notChoosenTwelve == true){
			myteamcount += 1;
			notChoosenTwelve = false;
			allJmons.getChildren().remove(Jtwelve);
			myteam.getChildren().add(Jtwelve);
		}
		else if(notChoosenTwelve == false)
		{
			myteamcount -= 1;
			notChoosenTwelve = true;
			myteam.getChildren().remove(Jtwelve);
			allJmons.getChildren().add(Jtwelve);
		}
		
		
	}
	
	static void shuffleArray(Javamon[] mainmons)
	  {
	    //Mischt das Javamon array, so dass immer ein zufälliges Starter-Javamon erscheint
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = mainmons.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      Javamon a = mainmons[index];
	      mainmons[index] = mainmons[i];
	      mainmons[i] = a;
	    }
	  }
	
	
	public void callAttackJavamon(){
		
		switchable = true;
		
		try {
			Parent attackparent = FXMLLoader.load(getClass().getResource("/application/AttackFXML.fxml"));
			Scene attackscene = new Scene(attackparent, SCREEN_WIDTH, SCREEN_HEIGHT);
			Main.stage.setScene(attackscene);
			
			attackOne = (Button) attackscene.lookup("#attackOne");
			attackTwo = (Button) attackscene.lookup("#attackTwo");
			attackThree = (Button) attackscene.lookup("#attackThree");
			attackFour = (Button) attackscene.lookup("#attackFour");
			
			System.out.println(Main.You.getCurrentJavamon().candoattacks[0].getName());
			
			switch(Main.You.getCurrentJavamon().candoattacks[0].getType()){
			
			case 0: attackOne.setText(Main.You.getCurrentJavamon().candoattacks[0].getName());
					attackOne.setStyle("-fx-background-color: #7F7F7F; -fx-font-size: 60;");
					break;
			
			case 1: attackOne.setText(Main.You.getCurrentJavamon().candoattacks[0].getName());
					attackOne.setStyle("-fx-font-size: 60; -fx-background-color: #E82B10; ");
					break;
					
			
			case 2: attackOne.setText(Main.You.getCurrentJavamon().candoattacks[0].getName());
					attackOne.setStyle("-fx-font-size: 60; -fx-background-color: #9609A8;");
					break;
					
			
			case 3: attackOne.setText(Main.You.getCurrentJavamon().candoattacks[0].getName());
					attackOne.setStyle("-fx-background-color: #2267FF; -fx-font-size: 60;");
					break;
						
			
			case 4: attackOne.setText(Main.You.getCurrentJavamon().candoattacks[0].getName());
					attackOne.setStyle("-fx-background-color: #27A849; -fx-font-size: 60;");
					break;
					
			
			case 5: attackOne.setText(Main.You.getCurrentJavamon().candoattacks[0].getName());
					attackOne.setStyle("-fx-background-color: #C79600; -fx-font-size: 60;");
					break;
				
		
			}
			
			
			
			switch(Main.You.getCurrentJavamon().candoattacks[1].getType()){
			
			
			
			case 0: attackTwo.setText(Main.You.getCurrentJavamon().candoattacks[1].getName());  
			attackTwo.setStyle("-fx-font-size: 60; -fx-background-color: #7F7F7F");
					break;
			
			case 1: attackTwo.setText(Main.You.getCurrentJavamon().candoattacks[1].getName());
					attackTwo.setStyle("-fx-font-size: 60; -fx-background-color: #E82B10");
					break;
			
			case 2: attackTwo.setText(Main.You.getCurrentJavamon().candoattacks[1].getName());
					attackTwo.setStyle("-fx-font-size: 60; -fx-background-color: #9609A8");
					break;
			
			case 3: attackTwo.setText(Main.You.getCurrentJavamon().candoattacks[1].getName());
					attackTwo.setStyle("-fx-background-color: #2267FF; -fx-font-size: 60");
					break;
			
			case 4: attackTwo.setText(Main.You.getCurrentJavamon().candoattacks[1].getName());
					attackTwo.setStyle("-fx-background-color: #27A849; -fx-font-size: 60");
					break;
			
			case 5: attackTwo.setText(Main.You.getCurrentJavamon().candoattacks[1].getName());
					attackTwo.setStyle("-fx-background-color: #C79600; -fx-font-size: 60");
					break;
		
			}
			
			
			switch(Main.You.getCurrentJavamon().candoattacks[2].getType()){
			
			
			
			case 0: attackThree.setText(Main.You.getCurrentJavamon().candoattacks[2].getName());  
					attackThree.setStyle("-fx-font-size: 60; -fx-background-color: #7F7F7F");
					break;
			
			case 1: attackThree.setText(Main.You.getCurrentJavamon().candoattacks[2].getName());
					attackThree.setStyle("-fx-font-size: 60; -fx-background-color: #E82B10");
					break;
			
			case 2: attackThree.setText(Main.You.getCurrentJavamon().candoattacks[2].getName());
					attackThree.setStyle("-fx-font-size: 60; -fx-background-color: #9609A8");
					break;
			
			case 3: attackThree.setText(Main.You.getCurrentJavamon().candoattacks[2].getName());
					attackThree.setStyle("-fx-background-color: #2267FF; -fx-font-size: 60");
					break;
			
			case 4: attackThree.setText(Main.You.getCurrentJavamon().candoattacks[2].getName());
					attackThree.setStyle("-fx-background-color: #27A849; -fx-font-size: 60");
					break;
			
			case 5: attackThree.setText(Main.You.getCurrentJavamon().candoattacks[2].getName());
					attackThree.setStyle("-fx-background-color: #C79600; -fx-font-size: 60");
					break;
		
			}
			
			
			
			
			switch(Main.You.getCurrentJavamon().candoattacks[3].getType()){
			
			
			
			case 0: attackFour.setText(Main.You.getCurrentJavamon().candoattacks[3].getName());  
					attackFour.setStyle("-fx-font-size: 60; -fx-background-color: #7F7F7F");
					break;
			
			case 1: attackFour.setText(Main.You.getCurrentJavamon().candoattacks[3].getName());
					attackFour.setStyle("-fx-font-size: 60; -fx-background-color: #E82B10");
					break;
					
			
			case 2: attackFour.setText(Main.You.getCurrentJavamon().candoattacks[3].getName());
					attackFour.setStyle("-fx-font-size: 60; -fx-background-color: #9609A8");
					break;
					
			
			case 3: attackFour.setText(Main.You.getCurrentJavamon().candoattacks[3].getName());
					attackFour.setStyle("-fx-background-color: #2267FF; -fx-font-size: 60");
					break;
			
			case 4: attackFour.setText(Main.You.getCurrentJavamon().candoattacks[3].getName());
					attackFour.setStyle("-fx-background-color: #27A849; -fx-font-size: 60");
					break;
			
			case 5: attackFour.setText(Main.You.getCurrentJavamon().candoattacks[3].getName());
					attackFour.setStyle("-fx-background-color: #C79600; -fx-font-size: 60");
					break;
		
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void TackOne(){
		
		
		System.out.println("round " + Main.roundcounter + "\n");
		Main.roundcounter += 1;
		Main.Computer.currentJavamon.defend(Main.You.currentJavamon.attack(Main.You.chooseAttack(0)));
		
		Button attackBtn = (Button) gamescene.lookup("#attackJavamon");	
		Button switchBtn = (Button) gamescene.lookup("#switchJavamon");
		
		attackBtn.setVisible(false);
		switchBtn.setVisible(false);
		
		Main.stage.setScene(gamescene);
		
		switchimagesenemy();
		switchimagesyou();

		
		attackMe();
		switchable = true;
		Button switcher = (Button) gamescene.lookup("#switchJavamon");
		switcher.setDisable(false);
		
	}
	
	
	public void TackTwo(){
		System.out.println("round " + Main.roundcounter + "\n");
		Main.roundcounter += 1;
		Main.Computer.currentJavamon.defend(Main.You.currentJavamon.attack(Main.You.chooseAttack(1)));
		
		Button attackBtn = (Button) gamescene.lookup("#attackJavamon");	
		Button switchBtn = (Button) gamescene.lookup("#switchJavamon");
		
		attackBtn.setVisible(false);
		switchBtn.setVisible(false);
		
		Main.stage.setScene(gamescene);
		
		switchimagesenemy();
		switchimagesyou();
		
		attackMe();
		switchable = true;
		Button switcher = (Button) gamescene.lookup("#switchJavamon");
		switcher.setDisable(false);
	}
	
	public void TackThree(){
		System.out.println("round " + Main.roundcounter + "\n");
		Main.roundcounter += 1;
		Main.Computer.currentJavamon.defend(Main.You.currentJavamon.attack(Main.You.chooseAttack(2)));
		
		Button attackBtn = (Button) gamescene.lookup("#attackJavamon");	
		Button switchBtn = (Button) gamescene.lookup("#switchJavamon");
		
		attackBtn.setVisible(false);
		switchBtn.setVisible(false);
		
		Main.stage.setScene(gamescene);
		
		switchimagesenemy();
		switchimagesyou();

		
		attackMe();
		switchable = true;
		Button switcher = (Button) gamescene.lookup("#switchJavamon");
		switcher.setDisable(false);
	}
	
	
	public void TackFour(){
		System.out.println("round " + Main.roundcounter + "\n");
		Main.roundcounter += 1;
		Main.Computer.currentJavamon.defend(Main.You.currentJavamon.attack(Main.You.chooseAttack(3)));
		
		Button attackBtn = (Button) gamescene.lookup("#attackJavamon");	
		Button switchBtn = (Button) gamescene.lookup("#switchJavamon");
		switchBtn.setVisible(false);
		
		attackBtn.setVisible(false);
		
		Main.stage.setScene(gamescene);
		
		switchimagesenemy();
		switchimagesyou();

		
		attackMe();
		switchable = true;
		Button switcher = (Button) gamescene.lookup("#switchJavamon");
		switcher.setDisable(false);
	}
	
	public void attackMe(){
		
		
		
		TextArea ta = (TextArea) gamescene.lookup("#textlog");
		Button attackBtn = (Button) gamescene.lookup("#attackJavamon");	
		Button switchBtn = (Button) gamescene.lookup("#switchJavamon");
		
		
		
		
		Main.You.currentJavamon.defend(Main.Computer.currentJavamon.attack(Main.Computer.chooseAttack()));
		
		
		
		ta.appendText("\n");
		switchBtn.setVisible(true);
		
		attackBtn.setVisible(true);
		
	}
	/*
	
	
	
	this.setCurrentJavamon (mainmons[randomIntjavamon]);*/
	public void switch1(){
		
		TextArea ta = (TextArea) gamescene.lookup("#textlog");
		String before = Main.You.getCurrentJavamon().getName();
		
		Main.stage.setScene(gamescene);
		
		if(Main.You.getCurrentJavamon() != Main.You.mainmons[0]){
			
			Main.You.currentJavamon.enemy.setEnemy(Main.You.mainmons[0]);
			Main.You.mainmons[0].setEnemy(Main.You.currentJavamon.enemy);
			
			
			
			Main.You.setCurrentJavamon(Main.You.mainmons[0]);
			
			ta.appendText("\n" + before + " was switched out!\n" + Main.You.getCurrentJavamon().getName()+ " is now playing!");
			
			switchimagesenemy();
			switchimagesyou();
			disableSwitch();
			
			attackMe();
		}
		
		
	}
	
	public void switch2(){
		
		TextArea ta = (TextArea) gamescene.lookup("#textlog");
		String before = Main.You.getCurrentJavamon().getName();
		
		Main.stage.setScene(gamescene);
		
		
		if(Main.You.getCurrentJavamon() != Main.You.mainmons[1]){
			
			Main.You.currentJavamon.enemy.setEnemy(Main.You.mainmons[1]);
			Main.You.mainmons[1].setEnemy(Main.You.currentJavamon.enemy);
			
			disableSwitch();
			
			Main.You.setCurrentJavamon(Main.You.mainmons[1]);
			
			ta.appendText("\n" + before + " was switched out!\n" + Main.You.getCurrentJavamon().getName()+ " is now playing!");
			
			switchimagesenemy();
			switchimagesyou();
			attackMe();
		}
		
		
		
		
	}
	
	public void switch3(){
		
		TextArea ta = (TextArea) gamescene.lookup("#textlog");
		String before = Main.You.getCurrentJavamon().getName();
		
		Main.stage.setScene(gamescene);
		
		
		if(Main.You.getCurrentJavamon() != Main.You.mainmons[2]){
			
			Main.You.currentJavamon.enemy.setEnemy(Main.You.mainmons[2]);
			Main.You.mainmons[2].setEnemy(Main.You.currentJavamon.enemy);
			
			
			
			
			Main.You.setCurrentJavamon(Main.You.mainmons[2]);
			
			ta.appendText("\n" + before + " was switched out!\n" + Main.You.getCurrentJavamon().getName()+ " is now playing!");
			
			switchimagesenemy();
			switchimagesyou();
			disableSwitch();
			
			attackMe();
		}
	}
	
	public void switch4(){
		
		TextArea ta = (TextArea) gamescene.lookup("#textlog");
		String before = Main.You.getCurrentJavamon().getName();
		
		Main.stage.setScene(gamescene);
		
		if(Main.You.getCurrentJavamon() != Main.You.mainmons[3]){
			
			Main.You.currentJavamon.enemy.setEnemy(Main.You.mainmons[3]);
			Main.You.mainmons[3].setEnemy(Main.You.currentJavamon.enemy);
			
			disableSwitch();
			
			Main.You.setCurrentJavamon(Main.You.mainmons[3]);
			
			ta.appendText("\n" + before + " was switched out!\n" + Main.You.getCurrentJavamon().getName()+ " is now playing!");
			
			switchimagesenemy();
			switchimagesyou();
			attackMe();
		}
	}
	
	public void switch5(){
		
		TextArea ta = (TextArea) gamescene.lookup("#textlog");
		String before = Main.You.getCurrentJavamon().getName();
		
		Main.stage.setScene(gamescene);
		
		
		if(Main.You.getCurrentJavamon() != Main.You.mainmons[4]){
			
			Main.You.currentJavamon.enemy.setEnemy(Main.You.mainmons[1]);
			Main.You.mainmons[4].setEnemy(Main.You.currentJavamon.enemy);
			
			disableSwitch();
			
			Main.You.setCurrentJavamon(Main.You.mainmons[4]);
			
			ta.appendText("\n" + before + " was switched out!\n" + Main.You.getCurrentJavamon().getName()+ " is now playing!");
			
			switchimagesenemy();
			switchimagesyou();
			attackMe();
		}
	}
	
	public void switch6(){
		
		TextArea ta = (TextArea) gamescene.lookup("#textlog");
		String before = Main.You.getCurrentJavamon().getName();
		
		
		
		Main.stage.setScene(gamescene);
		if(Main.You.getCurrentJavamon() != Main.You.mainmons[5]){
			
			Main.You.currentJavamon.enemy.setEnemy(Main.You.mainmons[5]);
			Main.You.mainmons[5].setEnemy(Main.You.currentJavamon.enemy);
			
			disableSwitch();
			
			
			Main.You.setCurrentJavamon(Main.You.mainmons[5]);
			
			ta.appendText("\n" + before + " was switched out!\n" + Main.You.getCurrentJavamon().getName()+ " is now playing!");
			
			switchimagesenemy();
			switchimagesyou();
			attackMe();
		}
	}
	
	public void disableSwitch(){
		Button switcher = (Button) gamescene.lookup("#switchJavamon");
		switcher.setDisable(true);
	}
	
	
}
