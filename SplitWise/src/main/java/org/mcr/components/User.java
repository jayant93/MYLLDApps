package org.mcr.components;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;

    private Long phnNumber;

    private double owedAmount;

    private User owesTo;

    private double paidAmount;

    public User getOwesTo() {
        return owesTo;
    }

    public void setOwesTo(User owesTo) {
        this.owesTo = owesTo;
    }

    public User(String name, Long phnNumber){
        this.name = name;
        this.phnNumber = phnNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhnNumber() {
        return phnNumber;
    }

    public void setPhnNumber(Long phnNumber) {
        this.phnNumber = phnNumber;
    }

    public double getOwedAmount() {
        return owedAmount;
    }

    public void setOwedAmount(double owedAmount) {
        this.owedAmount = owedAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phnNumber=" + phnNumber +
                ", owedAmount=" + owedAmount +
                ", owesTo=" + owesTo +
                ", paidAmount=" + paidAmount +
                '}';
    }
}
