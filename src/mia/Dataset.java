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
public class Dataset {
    private Legend[] dimension;
    private Info[] fact;
    
    public Legend[] getDimension(){
        return dimension;
    }
    public Info[] getFact(){
        return fact;
    }
    
    @Override
    public String toString() {
        String everything = null;
        System.out.println("Polio Immunizations in 1980");
        for(int i = 0; i < fact.length; i++){
            System.out.println(fact[i].toString());
            everything += fact[i].getValue();
        }
        return everything;
    }
}
