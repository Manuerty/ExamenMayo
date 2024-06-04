package edu.badpals.domain;

import jakarta.persistence.*;


@Entity
@Table(name="t_wizards")
public class Wizard {

    @Id
    @Column(name="wizard_name")
    private String name;

    @Column(name="wizard_dexterity")
    private int dexterity;

    @Column(name="wizard_person")
    @Enumerated(EnumType.STRING)
    private WizardType person;

    public Wizard(){}

    public String getName(){
        return name;
    }
    public int getDexterity(){
        return dexterity;
    }
    public WizardType getPerson(){
        return person;
    }

    public int setDexterity(int dexterity){
        return this.dexterity = dexterity;
    }

    public WizardType setPerson(WizardType person){
        return this.person = person;
    }

    @Override
    public String toString(){
        return this.getName() + " " + this.getDexterity() + " " + this.getPerson();
    }
}
