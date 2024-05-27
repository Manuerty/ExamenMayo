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
    private String person;

    public String getName(){
        return name;
    }
    public int getDexterity(){
        return dexterity;
    }
    public String getPerson(){
        return person;
    }

    public int setDexterity(int dexterity){
        return this.dexterity = dexterity;
    }

    public String setPerson(String person){
        return this.person = person;
    }



    public Wizard(){}



    @Override
    public String toString(){
        return this.getName() + " " + this.getDexterity() + " " + this.getPerson();
    }
}
