package com.project.guido_yourtrekmate;

public class DataClass {
    private String dataTitle;
    private String dataLoc;
    private String dataRat;
    private String dataImage;
    private String dataDesc;
    private String dataDist;
    private String dataTime;
    private String dataMonth;


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
    public String getDataDist(){return dataDist;}
    public String getDataTime(){return dataTime;}
    public String getDataMonth(){return dataMonth;}

    public DataClass(String dataTitle, String dataLoc, String dataRat, String dataImage, String dataDesc, String dataDist, String dataTime, String dataMonth) {
        this.dataTitle = dataTitle;
        this.dataLoc = dataLoc;
        this.dataRat = dataRat;
        this.dataImage = dataImage;
        this.dataDesc = dataDesc;
        this.dataDist = dataDist;
        this.dataTime = dataTime;
        this.dataMonth = dataMonth;
    }
    public DataClass(){

    }
}

