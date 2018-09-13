/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.ordersweetnesswork.entity;
import com.google.common.base.Preconditions;
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
@DiscriminatorValue("ICICLE")
public class Icicle extends Sweetness implements Serializable {
    //@Id @GeneratedValue
    protected int idIcicle;
    
    public Icicle(){
        
    }
    
    private Icicle(Builder builder) {
        super(builder);
        this.idIcicle = builder.idIcicle;
    }

    public boolean getIdIcicle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static class Builder extends Icicle.InnerBuilder<Builder> {

        protected int idIcicle;

        public Builder idIcicle(int idIcicle) {
            this.idIcicle = idIcicle;
            return this;
        }

        @Override
        public Icicle build() {
            Preconditions.checkArgument(this.idIcicle > 0, "no field of idSweetnes is initalized correct");
            return new Icicle(this);
        }
    }

    @Override
    public String toString() {
        return "Icicle{" 
                + "idIcicle=" 
                + idIcicle 
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
