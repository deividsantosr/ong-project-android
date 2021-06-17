package com.example.nogs.api;

public class Donation {
    private String id;
    private String ongId;
    private String ongName;
    private String userId;
    private String userName;
    private String paymentMethod;
    private Double value;
    private String observations;
    private String createdDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOngId() {
        return ongId;
    }

    public void setOngId(String ongId) {
        this.ongId = ongId;
    }

    public String getOngName() {
        return ongName;
    }

    public void setOngName(String ongName) {
        this.ongName = ongName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
