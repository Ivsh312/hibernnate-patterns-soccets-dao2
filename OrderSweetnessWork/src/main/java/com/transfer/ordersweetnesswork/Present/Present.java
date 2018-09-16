/*
*save array of sweetness 
*
*
 */
package com.transfer.ordersweetnesswork.Present;

import com.transfer.ordersweetnesswork.entity.Sweetness;
import java.io.Serializable;
import java.util.ArrayList;


public final class Present extends ArrayList<Sweetness> implements Serializable{
    
    private double sumMass = 0;
    private static int valueId = 0;
    private static int id;
    
    public Present(ArrayList<Sweetness> c) {
        super(c);
        id = valueId++;
    }

    public Present() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //serves to add elements instead of the default method
    public boolean addSweetness(Sweetness swets){
        this.sumMass += swets.getMass();
        return this.add(swets);
    }
    
}
