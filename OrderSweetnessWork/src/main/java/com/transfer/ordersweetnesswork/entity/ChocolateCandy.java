/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.ordersweetnesswork.entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Lenovo
 */
@Entity
@DiscriminatorValue("CHOCK")
public class ChocolateCandy extends Sweetness implements Serializable {
        //@Id @GeneratedValue
    protected int idChocolateCandy;
    public ChocolateCandy(){
        
    }
    private ChocolateCandy(Builder builder) {
        super(builder);
        this.idChocolateCandy = builder.idChocolateCandy;
    }

    public boolean getIdChocolateCandy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static class Builder extends Sweetness.InnerBuilder<Builder> {
        protected int idChocolateCandy;
        public Builder idChocolateCandy(int idChocolateCandy) {
            this.idChocolateCandy = idChocolateCandy;
            return this;
        }

        @Override
        public ChocolateCandy build() {
            return new ChocolateCandy(this);
        }
    }

    public void setIdChocolateCandy(int idChocolateCandy) {
        this.idChocolateCandy = idChocolateCandy;
    }
    
    
    
    @Override
    public String toString() {
        return "ChocolateCandy{" 
                + "idChocolateCandy=" 
                + idChocolateCandy 
                + ", idSweetnes=" 
                + idSweetnes 
                + ", taste=" 
                + taste 
                + ", mass=" 
                + mass 
                + ", price=" 
                + price 
                + ", nameProdyck=" 
                + nameProdyck 
                + ", nameTypeSweetness=" 
                + nameTypeSweetness + '}';
    }
    
}
