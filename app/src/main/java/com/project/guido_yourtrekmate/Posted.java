package com.project.guido_yourtrekmate;

public class Posted {
    private String nameId;
    private String postedMsg;
    Posted(String nameId,String postedMsg){
        this.nameId = nameId;
        this.postedMsg=postedMsg;
    }

    public String getNameId() {
        return nameId;
    }

    public String getPostedMsg() {
        return postedMsg;
    }
}
