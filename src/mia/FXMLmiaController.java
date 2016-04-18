/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mia;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.*;
import com.google.gson.*;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author csstudent
 */
public class FXMLmiaController implements Initializable {
    
    @FXML
    private BarChart barChart;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        
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
        Dataset data = gson.fromJson(str, Dataset.class);
        
        XYChart.Series<String, Integer> dataSeries = new XYChart.Series();
        Map<String, Integer> dataPoints = new TreeMap<String, Integer>();
        Info[] infos = data.getFact();
        
        for(Info info: infos){
            String country = info.getDim().getCountry();
            Integer percent = info.getValue();
            dataPoints.put(country, percent);
        }
        
        
        
    }    
    
}
