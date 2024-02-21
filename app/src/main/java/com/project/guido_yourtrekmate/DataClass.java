package com.project.guido_yourtrekmate;

public class DataClass {
    private String dataTitle;
    private String dataLoc;
    private String dataRat;
    private String dataImage;

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

    public DataClass(String dataTitle, String dataLoc, String dataRat, String dataImage) {
        this.dataTitle = dataTitle;
        this.dataLoc = dataLoc;
        this.dataRat = dataRat;
        this.dataImage = dataImage;
    }
    public DataClass(){

    }
}

