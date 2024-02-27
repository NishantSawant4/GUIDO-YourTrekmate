package com.project.guido_yourtrekmate;

public class DataClass {
    private String dataTitle;
    private String dataLoc;
    private String dataRat;
    private String dataImage;
    private String dataDesc;

    public String getDataTitle() {
        return dataTitle;
    }

    public String getDataLoc() {
        return dataLoc;
    }

    public String getDataRat() {
        return dataRat;
    }

    public String getDataImage() {
        return dataImage;
    }
    public String getDataDesc() {
        return dataDesc;
    }

    public DataClass(String dataTitle, String dataLoc, String dataRat, String dataImage, String dataDesc) {
        this.dataTitle = dataTitle;
        this.dataLoc = dataLoc;
        this.dataRat = dataRat;
        this.dataImage = dataImage;
        this.dataDesc = dataDesc;
    }
    public DataClass(){

    }
}

