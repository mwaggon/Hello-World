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
public class Info {
    private PointInfo dim;
    private int Value;
    
    public int getValue(){
        return Value;
    }
    public PointInfo getDim(){
        return dim;
    }
    
    @Override
    public String toString() {
        return dim.getCountry() + ": " + this.getValue() + "% immunized";
    }
}
