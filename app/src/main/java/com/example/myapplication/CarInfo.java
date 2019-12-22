package com.example.myapplication;

import android.content.Context;

/**
 * Created by ASUS A555L on 1/19/2018.
 */

 class CarInfo {


     private String carID;
     private String carName;
     private String carModel;
     private String carRegistrationNumber;
     private String carStatus;
    // private Byte[] carImage;





    public CarInfo (String carID ,String carName,String carModel,String carRegistrationNumber,String carStatus )
    {
        this.carID=carID;
        this.carName=carName;
        this.carModel=carModel;
        this.carRegistrationNumber=carRegistrationNumber;
        this.carStatus=carStatus;
    }



    public CarInfo (String carID,String carName,String carRegistrationNumber,String carModel)
    {
        this.carID=carID;
        this.carName=carName;
        this.carRegistrationNumber=carRegistrationNumber;

    }




    public void setCarID(String carID) {
        this.carID = carID;
    }
    public void setCarRegistrationNumber(String carRegistrationNumber) {this.carRegistrationNumber = carRegistrationNumber;}
    public void setCarName(String carName) {
        this.carName = carName;
    }
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }



    public String getCarID() {return carID;}
    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }
    public String getCarName() {return carName;}
    public String getCarModel() {
        return carModel;
    }
    public String getCarStatus() {
        return carStatus;
    }







}
