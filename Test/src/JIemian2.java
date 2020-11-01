import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.image.*;

public class JIemian2 extends Application {
	  @Override 
	  public void start(Stage primaryStage) {
		  	Pane pane2 = new Pane();
	        pane2.setPadding(new Insets(50, 240, 10, 250));
	        Circle circle = new Circle(0,0,10);
	        Rectangle rectangle = new Rectangle(0,0,60,10);
	        circle.setLayoutX(100);
	        circle.setLayoutY(100);
	        rectangle.setLayoutX(100);
	        rectangle.setLayoutY(700);
	        pane2.getChildren().add(rectangle);
	        pane2.getChildren().add(circle);
	        Scene scene2 = new Scene(pane2,1000,1000);
	        primaryStage.setTitle("ÅöÇòÓÎÏ·");
	        primaryStage.setScene(scene2);
	        primaryStage.show();
	        scene2.setOnKeyPressed(e -> {
	        	if(e.getCode() == KeyCode.LEFT) {
	        		if(rectangle.getX() > -100) {
		    			rectangle.setX(rectangle.getX() - 10);
	        		}
	        		else {
		    			rectangle.setX(rectangle.getX());
	        		}
	        	}else if(e.getCode() == KeyCode.RIGHT) {
	        		if(rectangle.getX() < 840) {
		    			rectangle.setX(rectangle.getX() + 10);
	        		}else {
		    			rectangle.setX(rectangle.getX());
	        		}
	        	}
	        });
	        primaryStage.setTitle("ÅöÇòÓÎÏ·");
	        primaryStage.setScene(scene2);
	        primaryStage.show();
	  }
	  public static void main(String[] args){
		  launch(args);
	  }
	
}
