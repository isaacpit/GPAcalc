/*
 * Application by Isaac Pitblado
 * References used: 
 * Special thanks to oracle, their tutorial was used to develop this code
 * https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html#textarea
 * https://docs.oracle.com/javafx/2/layout/style_css.htm
 * https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html#textarea
 */

package application;
	



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
//	IntField hrsFlds[] = new IntField[6];
	AbstractNumField<Integer> hrsFlds[];
	AbstractNumField<Double> gpaFlds[];
	
	IntField hrsField;
	DoubleField gpaField;
	
	double fldWdth = 100;
	double lblWdth = 75;
	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GPA Calculator");
        

        BorderPane border = new BorderPane();
        Text title = new Text("GPA Calculator");
        title.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        title.setFill(Color.web("#E9B000"));
        
//        title.setFill(Color.GREEN);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);	
        grid.setPadding(new Insets(25, 25, 25, 25));
        


        border.setCenter(grid);
        border.setTop(title);

        
        
        BorderPane.setAlignment(title, Pos.TOP_CENTER);
        BorderPane.setMargin(title, new Insets(12,12,12,12));
        
        BorderPane.setMargin(grid, new Insets(12,12,12,12));
        border.getStyleClass().add("border");
        
        
        final Scene scene = new Scene(border, 1000, 500, Color.GREEN);
        scene.getStylesheets().add("application/application.css");
//        scene.setFill(Color.GREEN);
        primaryStage.setScene(scene);
        
        grid.getStyleClass().add("grid");
        
        Button genBtn = new Button("Generate");

        HBox hbBtn = new HBox(10);
        hbBtn.getStyleClass().add("hbox");
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(genBtn);
        grid.add(hbBtn, 1, 11);
        
//        grid.setStyle("-fx-padding: 10;" + 
//                "-fx-border-style: solid inside;" + 
//                "-fx-border-width: 8;" +
//                "-fx-border-insets: 10;" + 
//                "-fx-border-radius: 10;" + "-fx-border-color: gray;");
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        Text classtitle = new Text("# of Classes");
        classtitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//        classtitle.setFill(Color.GREEN);
        grid.add(classtitle, 0, 9, 2, 1);
        
        Label classes = new Label("# Classes:");
        grid.add(classes, 0, 10);
        
        IntField numClasses = new IntField();
        numClasses.setMaxWidth(fldWdth);
        grid.add(numClasses, 1, 10);

//        Label userName = new Label("GPA:");
//        grid.add(userName, 0, 6);
//
//        TextField totGPA = new TextField();
//        totGPA.setMaxWidth(100.0);
//        grid.add(totGPA, 1, 6);

        
        Text prevtitle = new Text("Current GPA");
        prevtitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(prevtitle, 0, 5, 2, 1);
        
        Label totGPA = new Label("GPA:");
        totGPA.setPrefWidth(lblWdth);
        grid.add(totGPA, 0, 6);
        
        gpaField = new DoubleField("0.0");
        gpaField.setPrefWidth(fldWdth);
        grid.add(gpaField, 1, 6);
        
        Label hrsLabel = new Label("Hours:");
        grid.add(hrsLabel, 0, 7);
        
        hrsField = new IntField("0");
        hrsField.setPrefWidth(fldWdth);
        grid.add(hrsField, 1, 7);

//        TextField totGPA = new TextField();
//        totGPA.setMaxWidth(100.0);
//        grid.add(totGPA, 1, 6);
//        
//        pw.setText("Hours");
//        totHours.clear();
//        
//        Text classtitle = new Text("Class 1");
//        classtitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//        grid.add(classtitle, 4, 0, 2, 1);
        
        Text outputTitle = new Text("Final GPA");
        outputTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(outputTitle, 2, 5);
        
        Label outputLabel = new Label("Final GPA:");
        outputLabel.setPrefWidth(lblWdth);
        grid.add(outputLabel, 2, 6);
        
        DoubleField outputField = new DoubleField();
        outputField.setMaxWidth(fldWdth);
        grid.add(outputField, 3, 6);
        
        Button outBtn = new Button("Calculate");
        HBox hbOutBtn = new HBox(10);
        hbOutBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbOutBtn.getChildren().add(outBtn);
        grid.add(hbOutBtn, 3, 7);
        
        Button setAsBtn = new Button("Set A's");
        HBox hbsetAsBtn = new HBox(10);
        hbsetAsBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbsetAsBtn.getChildren().add(setAsBtn);
        grid.add(hbsetAsBtn, 2, 9);
        
        Button setBsBtn = new Button("Set B's");
        HBox hbsetBsBtn = new HBox(10);
        hbsetBsBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbsetBsBtn.getChildren().add(setBsBtn);
        grid.add(hbsetBsBtn, 2, 10);
        
        Button setCsBtn = new Button("Set C's");
        HBox hbsetCsBtn = new HBox(10);
        hbsetCsBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbsetCsBtn.getChildren().add(setCsBtn);
        grid.add(hbsetCsBtn, 2, 11);
        
        Button set4HrsBtn = new Button("Set 4 hrs");
        HBox hbset4HrsBtn = new HBox(10);
        hbset4HrsBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbset4HrsBtn.getChildren().add(set4HrsBtn);
        grid.add(hbset4HrsBtn, 3, 9);
        
        Button set3HrsBtn = new Button("Set 3 hrs");

        HBox hbset3HrsBtn = new HBox(10);
        hbset3HrsBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbset3HrsBtn.getChildren().add(set3HrsBtn);
        grid.add(hbset3HrsBtn, 3, 10);
        
        TextArea inst = new TextArea(
        			"*****************************************"
        		+ "\nCalculator Instructions"
        		+ "\n*****************************************"
        		+ "\n1) Enter number of classes for the semester"
        		+ "\n2) Click \"Generate\" "
        		+ "\n3) Enter current GPA and total hours if desired"
        		+ "\n4) Enter current grades or use supplied buttons"
        		+ "\n5) Click \"Calculate\" \n");
        inst.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 20));
        inst.getStyleClass().add("textarea");
//        border.setRight(inst);
//        inst.setPrefWidth(100.0);
//        inst.setPrefHeight(100.0);
        inst.setPrefHeight(400);
        
        grid.add(inst, 4, 5);
        GridPane.setColumnSpan(inst, 8);
        GridPane.setRowSpan(inst, 8);
        
//        grid.setGridLinesVisible(true);
        grid.setPrefWidth(600);
        grid.setPrefHeight(600);
        
        
        Button setNullCurrBtn = new Button("Null Current");
        HBox hbsetNullCurrBtn = new HBox(10);
        hbsetNullCurrBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbsetNullCurrBtn.getChildren().add(setNullCurrBtn);
        grid.add(hbsetNullCurrBtn, 3, 11);
        
//        grid.setGridLinesVisible(true);
        
        genBtn.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.web("#E9B000"));
                actiontarget.setText("Your GPA is ");
//                actiontarget.setText(((3.8 * 18) / (4.8 * 18 ) ));
                int size = numClasses.getValue();
                createSchedule(size, grid);
                numClasses.clear();
                

            }
        });
        
        outBtn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override 
        	public void handle(ActionEvent e) {
        		actiontarget.setFill(Color.web("#E9B000"));
        		double sumProduct = gpaField.getValue() * hrsField.getValue();
        		double gpa = 0.0;
        		double temp;
        		int totalHours = hrsField.getValue();
        		for (int i = 0; i < hrsFlds.length; ++i) {
        			System.out.print("hrsFlds[" + i + "]: ");
        			System.out.println(hrsFlds[i].getValue());
        			System.out.print("gpaFlds[" + i + "]: ");
        			System.out.println(gpaFlds[i].getValue());

        			temp = (hrsFlds[i].getValue() * gpaFlds[i].getValue());
        			System.out.println("sumProduct:" + temp);
        			totalHours += hrsFlds[i].getValue();

        			System.out.println();
        			sumProduct += temp;
        		}
        		System.out.println("total sumProduct: " + sumProduct);
        		System.out.println("total Hours: " + totalHours);
        		gpa = sumProduct / totalHours;
        		System.out.println("GPA: " +  gpa);
        		outputField.setText(Double.toString(gpa));
        	}
        });

        setAsBtn.setOnAction(new EventHandler<ActionEvent> () {
        	public void handle(ActionEvent e) {
        		for (int i = 0; i < gpaFlds.length; ++i) {
//        			gpaFlds[i].setText("4.0");
        			int col = GridPane.getColumnIndex(gpaFlds[i]);
        			int row = GridPane.getRowIndex(gpaFlds[i]);
        			
                    gpaFlds[i] = new DoubleField("4.0");
                    gpaFlds[i].setPrefWidth(fldWdth);
                    grid.add(gpaFlds[i], col, row);
                    
        			System.out.println("col: " + col);
        			System.out.println("row: " + row);
        		}
        	}
        });
        
        setBsBtn.setOnAction(new EventHandler<ActionEvent> () {
        	public void handle(ActionEvent e) {
        		for (int i = 0; i < gpaFlds.length; ++i) {
        			int col = GridPane.getColumnIndex(gpaFlds[i]);
        			int row = GridPane.getRowIndex(gpaFlds[i]);
                    gpaFlds[i] = new DoubleField("3.0");
                    gpaFlds[i].setPrefWidth(fldWdth);
                    grid.add(gpaFlds[i], col, row);
                    
        			System.out.println("col: " + col);
        			System.out.println("row: " + row);
        		}
        	}
        });
        
        setCsBtn.setOnAction(new EventHandler<ActionEvent> () {
        	public void handle(ActionEvent e) {
        		for (int i = 0; i < gpaFlds.length; ++i) {
        			int col = GridPane.getColumnIndex(gpaFlds[i]);
        			int row = GridPane.getRowIndex(gpaFlds[i]);
                    gpaFlds[i] = new DoubleField("2.0");
                    gpaFlds[i].setPrefWidth(fldWdth);
                    grid.add(gpaFlds[i], col, row);
                    
        			System.out.println("col: " + col);
        			System.out.println("row: " + row);
        			
        		}
        	}
        });
        
        set4HrsBtn.setOnAction(new EventHandler<ActionEvent> () {
        	public void handle(ActionEvent e) {
        		for (int i = 0; i < hrsFlds.length; ++i) {
        			int col = GridPane.getColumnIndex(hrsFlds[i]);
        			int row = GridPane.getRowIndex(hrsFlds[i]);
        			
                    hrsFlds[i] = new IntField("4");
                    hrsFlds[i].setPrefWidth(fldWdth);
                    grid.add(hrsFlds[i], col, row);
                    
        			System.out.println("col: " + col);
        			System.out.println("row: " + row);
        			
        			
        		}
        	}
        });
        
        set3HrsBtn.setOnAction(new EventHandler<ActionEvent> () {
        	public void handle(ActionEvent e) {
        		for (int i = 0; i < hrsFlds.length; ++i) {
        			int col = GridPane.getColumnIndex(hrsFlds[i]);
        			int row = GridPane.getRowIndex(hrsFlds[i]);
        			
                    hrsFlds[i] = new IntField("3");
                    hrsFlds[i].setPrefWidth(fldWdth);
                    grid.add(hrsFlds[i], col, row);
                    
        			System.out.println("col: " + col);
        			System.out.println("row: " + row);
        		}
        	}
        });
        
        setNullCurrBtn.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.BLUEVIOLET);
                
                gpaField = new DoubleField("0.0");
                gpaField.setPrefWidth(fldWdth);
                grid.add(gpaField, 1, 6);
                
                hrsField = new IntField("0");
                hrsField.setPrefWidth(fldWdth);
                grid.add(hrsField, 1, 7);

            }
        });
        
        primaryStage.show();
    }
	
	
    public void createSchedule(int n, GridPane g) {
    	int j = 1;
    	int max = 6;
    	if (n > max) {
    		n = max;
    	}
    	hrsFlds = new IntField[n];
    	gpaFlds = new DoubleField[n];
    	for (int i = 0; i < 2 * n; i += 2) {
    		String title = "Class " + j;
//    		System.out.println(title);
//    		g.getChildren().clear();
            Text scenetitle = new Text(title);
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            g.add(scenetitle, i, 0, 2, 1);
    		
            Label gpaLbl = new Label("GPA:");
            gpaLbl.setPrefWidth(lblWdth);
            g.add(gpaLbl, i , 1);
            
            DoubleField gpaFld = new DoubleField("0.0");
            gpaFld.setPrefWidth(fldWdth);
            g.add(gpaFld, i + 1 , 1);
            
            Label hrsLbl = new Label("Hours:");
            hrsLbl.setPrefWidth(lblWdth);
            g.add(hrsLbl, i , 2);

            IntField hrsFld = new IntField("0");
            hrsFld.setPrefWidth(fldWdth);
            g.add(hrsFld, i + 1, 2);
            
            j++;
            gpaFlds[i / 2] = gpaFld;
    		hrsFlds[i / 2] = hrsFld;
    	}
    	return;
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
