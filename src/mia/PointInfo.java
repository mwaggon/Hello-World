/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mia;

/**
 *
 * @author csstudent
 */
public class PointInfo {
    private String PUBLISHSTATE;
    private String REGION;
    private String GHO;
    private String WORLDBANKINCOMEGROUP;
    private int YEAR;
    private String COUNTRY;
    
    public String getPublishState(){
        return PUBLISHSTATE;
    }
    public String getRegion(){
        return REGION;
    }
    public String getGHO(){
        return GHO;
    }
    public String getIncomeGroup(){
        return WORLDBANKINCOMEGROUP;
    }
    public int getYear(){
        return YEAR;
    }
    public String getCountry(){
        return COUNTRY;
    }
}

