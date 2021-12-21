package com.example.kommunevalgbackend.Model;

import javax.persistence.*;

@Entity
public class Kandidat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kandidatId;
    private String firstName;
    private String lastName;

    @JoinColumn(name = "parti_id")
    @ManyToOne
    private Parti parti;

    public int getKandidatId() {
        return kandidatId;
    }

    public void setKandidatId(int kandidatId) {
        this.kandidatId = kandidatId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Parti getParti() {
        return parti;
    }

    public void setParti(Parti parti) {
        this.parti = parti;
    }
}
