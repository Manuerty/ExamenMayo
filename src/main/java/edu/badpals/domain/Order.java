package edu.badpals.domain;

import jakarta.persistence.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

@Entity
@Table(name="t_orders")
public class Order {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ord_id")
    private int ID;

    @ManyToOne
    @JoinColumn(name="ord_wizard")
    private Wizard wizard;

    @OneToOne
    @JoinColumn(name="ord_item")
    private MagicalItem item;

    public Order(){}

    public Order( Wizard orderWizard, MagicalItem orderedItem){
        this.wizard = orderWizard;
        this.item = orderedItem;
    }

    public int getId() {
        return ID;
    }
    public Wizard getWizard(){
        return wizard;
    }

    public MagicalItem getItem(){
        return item;
    }

    public void setWizard(Wizard wizard){
        this.wizard = wizard;
    }

    public void setItem(MagicalItem item){
        this.item = item;
    }

    @Override
    public String toString(){
        return this.getWizard().getName() + " " + this.getItem().getName();
    }
}
