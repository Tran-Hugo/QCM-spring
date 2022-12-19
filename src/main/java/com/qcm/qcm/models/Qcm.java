package com.qcm.qcm.models;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Qcm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String theme;
    @OneToMany(targetEntity=Score.class,mappedBy = "qcm")
    private List<Score> scores;

    public Qcm() {
    }

    public Qcm(int id, String theme, List<Score> scores) {
        this.id = id;
        this.theme = theme;
        this.scores = scores;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }


    public Qcm id(int id) {
        setId(id);
        return this;
    }

    public Qcm theme(String theme) {
        setTheme(theme);
        return this;
    }

   

}
