/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.ordersweetnesswork.Present;

import com.transfer.ordersweetnesswork.entity.Sweetness;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Lenovo
 */
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
    public boolean addSweetness(Sweetness swets){
        this.sumMass += swets.getMass();
        return this.add(swets);
    }
    
}
