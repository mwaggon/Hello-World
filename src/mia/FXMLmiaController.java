/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mia;

import com.google.gson.Gson;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Slider;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.WindowEvent;
/**
 *
 * @author csstudent
 */
public class FXMLmiaController implements Initializable {
    
    private Dataset data;
    
    @FXML
    private BarChart barChart;
    
    @FXML
    private Slider minimum;
    
    @FXML
    private Slider maximum;
    
    @FXML
    private MenuBar menu;
    
    @FXML
    private BorderPane bPane;
    
    @FXML
    private Menu file;
     
    @FXML
    private Menu help;
    
    @FXML
    private MenuItem close;
    
    @FXML
    private MenuItem info;
     
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        
    }
    @FXML
    public void close(ActionEvent event){
        System.exit(0);
    }
    
    @FXML
    public void printAbout(ActionEvent event){
        Alert message = new Alert(AlertType.INFORMATION);
        message.setTitle("Information about my graph");
        message.setHeaderText(null);
        message.setContentText("This graph was made by Mia Swaggoner. It is about polio immunizations... ");
        message.showAndWait();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String s = "http://apps.who.int/gho/athena/data/GHO/WHS4_544.json?profile=simple&filter=YEAR:1980";
        URL ur = null;
        try{
            ur = new URL(s);
        } catch (Exception e){
            System.out.println("Improper URL " + s);
            System.exit(-1);
        }
        
        Scanner scan = null;
        try {
            scan = new Scanner(ur.openStream());
        } catch (Exception e) {
            System.out.println("Could not connect to " + s);
            System.exit(-1);
        }
        
        String str = new String();
        while (scan.hasNext()) {
            str += scan.nextLine() + "\n";
        }
        scan.close();
        //System.out.println(str);
        
        Gson gson = new Gson();
        data = gson.fromJson(str, Dataset.class);
        
        
        Info[] infos = data.getFact();
        
        XYChart.Series<String, Number> dataSeries = new XYChart.Series();
        dataSeries.setName("Percent Immunized");
        for(Info info : infos){
            if(info.getDim().getCountry() != null){
                //String country = info.getDim().getCountry();
                //Integer percent = info.getValue();
                dataSeries.getData().add(new XYChart.Data(info.getDim().getCountry(), info.getValue()));
            }
        }
        barChart.getData().add(dataSeries);
        
        

    
        
        }
        
        @FXML
        public void handleChangeFilter(MouseEvent event){
            barChart.getData().clear();
            Info[] infos = data.getFact();
            XYChart.Series<String, Number> dataSeries = new XYChart.Series();
            for(Info info : infos){
                if(info.getDim().getCountry() != null){
                    if(info.getValue() <= maximum.getValue() && info.getValue() >= minimum.getValue()){
                        dataSeries.getData().add(new XYChart.Data(info.getDim().getCountry(), info.getValue()));
                    }
                }
            }
            barChart.getData().add(dataSeries);
        
    }    
    
}
