/*
 * class - Entity from Sweetness table
 */
package com.transfer.ordersweetnesswork.entity;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Sweetness implements Serializable {
    @Id @GeneratedValue
    protected Integer idSweetnes;
    protected String taste;
    protected double mass;
    protected double price;
    protected String nameProdyck;
    protected String nameTypeSweetness;
    
    public Sweetness(){
        
    }
    
    protected Sweetness(InnerBuilder<?> builder) throws IllegalStateException {
        Preconditions.checkArgument(builder.idSweetnes > 0, 
                "no field of idSweetnes is initalized correct");
        Preconditions.checkArgument(builder.mass > 0.0, 
                "no field of mass is initalized correct");
        Preconditions.checkArgument(builder.price > 0.0, 
                "no field of price is initalized correct");
        Preconditions.checkNotNull(builder.taste,
                "no field of taste is initalized correct");
        Preconditions.checkNotNull(builder.nameProdyck,
                "no field of nameProdyck is initalized");
        Preconditions.checkNotNull(builder.nameTypeSweetness,
                "no field of nameTypeSweetness is initalized");

        idSweetnes = builder.idSweetnes;
        taste = builder.taste;
        mass = builder.mass;
        price = builder.price;
        nameProdyck = builder.nameProdyck;
        nameTypeSweetness = builder.nameTypeSweetness;
    }

    protected static class InnerBuilder<T extends InnerBuilder<T>> {

        protected int idSweetnes;
        protected String taste;
        protected double mass;
        protected double price;
        protected String nameProdyck;
        protected String nameTypeSweetness;

        public T idSweetnes(int idSweetnes) {
            this.idSweetnes = idSweetnes;
            return (T) this;
        }

        public T taste(String taste) {
            this.taste = taste;
            return (T) this;
        }

        public T mass(double mass) {
            this.mass = mass;
            return (T) this;
        }

        public T price(double price) {
            this.price = price;
            return (T) this;
        }

        public T nameProdyck(String nameProdyck) {
            this.nameProdyck = nameProdyck;
            return (T) this;
        }

        public T nameTypeSweetness(String nameTypeSweetness) {
            this.nameTypeSweetness = nameTypeSweetness;
            return (T) this;
        }

        public Sweetness build() {
            return new Sweetness(this);
        }
    }

// public static class Builder extends InnerBuilder<Builder> {}
    public int getIdSweetnes() {
        return idSweetnes;
    }

    public void setIdSweetnes(int idSweetnes) {
        this.idSweetnes = idSweetnes;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNameProdyck() {
        return nameProdyck;
    }

    public void setNameProdyck(String nameProdyck) {
        this.nameProdyck = nameProdyck;
    }

    public String getNameTypeSweetness() {
        return nameTypeSweetness;
    }

    public void setNameTypeSweetness(String nameTypeSweetness) {
        this.nameTypeSweetness = nameTypeSweetness;
    }

    @Override
    public String toString() {
        return "Sweetnes{" + "idSweetnes=" + idSweetnes + ", taste=" + taste + ", mass=" + mass + ", price=" + price + ", nameProdyck=" + nameProdyck + ", nameTypeSweetness=" + nameTypeSweetness + '}';
    }
}
