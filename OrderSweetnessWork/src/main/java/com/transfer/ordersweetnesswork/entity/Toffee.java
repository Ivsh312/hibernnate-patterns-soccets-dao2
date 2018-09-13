/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.ordersweetnesswork.entity;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Lenovo
 */
@Entity
public class Toffee extends Sweetness implements Serializable {
    //@Id @GeneratedValue
    protected int idToffee;
    
    public Toffee(){
        
    }
    
    private Toffee(Builder builder) {
        super(builder);
        this.idToffee = builder.idToffee;
    }

    public boolean getIdToffee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static class Builder extends Toffee.InnerBuilder<Builder> {

        protected int idToffee;

        public Builder idToffee(int idToffee) {
            this.idToffee = idToffee;
            return this;
        }

        @Override
        public Toffee build() {
            Preconditions.checkArgument(this.idToffee > 0, "no field of idSweetnes is initalized correct");
            return new Toffee(this);
        }
    }

    @Override
    public String toString() {
        return "Toffee{" 
                + "idToffee=" 
                + idToffee 
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
