package com.qcm.qcm.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int score;
    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name="id_qcm")
    private Qcm qcm;

    public Score() {
    }

    public Score(int id, int score, User user, Qcm qcm) {
        this.id = id;
        this.score = score;
        this.user = user;
        this.qcm = qcm;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Qcm getQcm() {
        return this.qcm;
    }

    public void setQcm(Qcm qcm) {
        this.qcm = qcm;
    }

    public Score id(int id) {
        setId(id);
        return this;
    }

    public Score score(int score) {
        setScore(score);
        return this;
    }

    public Score user(User user) {
        setUser(user);
        return this;
    }

    public Score qcm(Qcm qcm) {
        setQcm(qcm);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", score='" + getScore() + "'" +
            ", user='" + getUser() + "'" +
            ", qcm='" + getQcm() + "'" +
            "}";
    }

    
}
