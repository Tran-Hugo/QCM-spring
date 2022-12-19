package com.qcm.qcm.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private Boolean is_correct;
    @ManyToOne
    @JoinColumn(name="id_question")
    private Question question;

    public Reponse() {
    }

    public Reponse(int id, String content, Boolean is_correct, Question question) {
        this.id = id;
        this.content = content;
        this.is_correct = is_correct;
        this.question = question;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean isIs_correct() {
        return this.is_correct;
    }

    public Boolean getIs_correct() {
        return this.is_correct;
    }

    public void setIs_correct(Boolean is_correct) {
        this.is_correct = is_correct;
    }

    public Question getQuestion() {
        return this.question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Reponse id(int id) {
        setId(id);
        return this;
    }

    public Reponse content(String content) {
        setContent(content);
        return this;
    }

    public Reponse is_correct(Boolean is_correct) {
        setIs_correct(is_correct);
        return this;
    }

    public Reponse question(Question question) {
        setQuestion(question);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", content='" + getContent() + "'" +
            ", is_correct='" + isIs_correct() + "'" +
            ", question='" + getQuestion() + "'" +
            "}";
    }


}
