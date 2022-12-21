package com.qcm.qcm.models;

public class ResponsePOJO {
    private int id;
    private String content;
    private Boolean is_correct;

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

}
