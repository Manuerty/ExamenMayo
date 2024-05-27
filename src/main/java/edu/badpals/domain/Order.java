package edu.badpals.domain;

import jakarta.persistence.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

@Entity
@Table(name="t_orders")
public class Order {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ord_id")
    private int ID;

    @OneToOne
    @JoinColumn(name="ord_wizard")
    private Wizard wizard;

    @OneToOne
    @JoinColumn(name="ord_item")
    private MagicalItem item;

    public int getId() {
        return ID;
    }
    public Wizard getWizard(){
        return wizard;
    }

    public MagicalItem getItem(){
        return item;
    }

    public Order(){}

    public Order( Wizard orderWizard, MagicalItem orderedItem){
        this.wizard = orderWizard;
        this.item = orderedItem;
    }

    @Override
    public String toString(){
        return this.getWizard().getName() + " " + this.getItem().getName();
    }
}
