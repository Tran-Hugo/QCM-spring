package com.qcm.qcm.models;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String question;
    @ManyToOne
    @JoinColumn(name="id_qcm")
    private Qcm qcm;

    public Question() {
    }

    public Question(int id, String type, String question, Qcm qcm) {
        this.id = id;
        this.type = type;
        this.question = question;
        this.qcm = qcm;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Qcm getQcm() {
        return this.qcm;
    }

    public void setQcm(Qcm qcm) {
        this.qcm = qcm;
    }

    public Question id(int id) {
        setId(id);
        return this;
    }

    public Question type(String type) {
        setType(type);
        return this;
    }

    public Question question(String question) {
        setQuestion(question);
        return this;
    }

    public Question qcm(Qcm qcm) {
        setQcm(qcm);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Question)) {
            return false;
        }
        Question question = (Question) o;
        return id == question.id && Objects.equals(type, question.type) && Objects.equals(question, question.question) && Objects.equals(qcm, question.qcm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, question, qcm);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", type='" + getType() + "'" +
            ", question='" + getQuestion() + "'" +
            ", qcm='" + getQcm() + "'" +
            "}";
    }

}
