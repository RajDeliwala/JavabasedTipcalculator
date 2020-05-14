package com.example.raj.bcs421rajdeliwalahwktip;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Raj on 4/16/2017.
 */

public class tipData extends Application {

    private String restaurantName;
    private double BillAmount;
    private double tipAmount;
    private double tipPercentage;
    private double speedService;
    private double friendService;
    private double accuracyService;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public double getBillAmount() {
        return BillAmount;
    }

    public void setBillAmount(double BillAmount) {
        this.BillAmount = BillAmount;
    }

    public double getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(double tipAmount) {
        this.tipAmount = tipAmount;
    }

    public double getTipPercentage() {
        return tipPercentage;
    }

    public void setTipPercentage(double tipPercentage) {
        this.tipPercentage = tipPercentage;
    }

    public double getSpeedService() {
        return speedService;
    }

    public void setSpeedService(double speedService) {
        this.speedService = speedService;
    }

    public double getFriendService() {
        return friendService;
    }

    public void setFriendService(double friendService) {
        this.friendService = friendService;
    }

    public double getAccuracyService() {
        return accuracyService;
    }

    public void setAccuracyService(double accuracyService) {
        this.accuracyService = accuracyService;
    }

    @Override
    public String toString()
    {
        return restaurantName;
    }
}
