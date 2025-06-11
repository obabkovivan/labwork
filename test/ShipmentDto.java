package org.example.test;

public class ShipmentDto {
    private String id;
    private String date;
    private String carNumber;
    private String containerNumber;
    private String containerWeight;
    private String seal;
    private String oilWeight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(String containerNumber) {
        this.containerNumber = containerNumber;
    }

    public String getContainerWeight() {
        return containerWeight;
    }

    public void setContainerWeight(String containerWeight) {
        this.containerWeight = containerWeight;
    }

    public String getSeal() {
        return seal;
    }

    public void setSeal(String seal) {
        this.seal = seal;
    }

    public String getOilWeight() {
        return oilWeight;
    }

    public void setOilWeight(String oilWeight) {
        this.oilWeight = oilWeight;
    }
}
