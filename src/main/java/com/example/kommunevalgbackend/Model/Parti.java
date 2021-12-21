package com.example.kommunevalgbackend.Model;

import javax.persistence.*;

@Entity
public class Parti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partiId;
    private String parti;
    private double procent;
    private int kandidatCount;


    public int getPartiId() {
        return partiId;
    }

    public void setPartiId(int partiId) {
        this.partiId = partiId;
    }

    public String getParti() {
        return parti;
    }

    public void setParti(String parti) {
        this.parti = parti;
    }

    public double getProcent() {
        return procent;
    }

    public void setProcent(double procent) {
        this.procent = procent;
    }

    public int getKandidatCount() {
        return kandidatCount;
    }

    public void setKandidatCount() {
        this.kandidatCount++;
    }

}
