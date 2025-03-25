package com.yievsieievAndrii.apiCarsharing.models.engine;

public class EngineData {
    private int id;
    private int makeModelTrimId;
    private String engineType;
    private String fuelType;
    private String cylinders;
    private String size;
    private int horsepowerHp;
    private int horsepowerRpm;
    private int torqueFtLbs;
    private int torqueRpm;
    private int valves;
    private String valveTiming;
    private String camType;
    private String driveType;
    private String transmission;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMakeModelTrimId() {
        return makeModelTrimId;
    }

    public void setMakeModelTrimId(int makeModelTrimId) {
        this.makeModelTrimId = makeModelTrimId;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getCylinders() {
        return cylinders;
    }

    public void setCylinders(String cylinders) {
        this.cylinders = cylinders;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getHorsepowerHp() {
        return horsepowerHp;
    }

    public void setHorsepowerHp(int horsepowerHp) {
        this.horsepowerHp = horsepowerHp;
    }

    public int getHorsepowerRpm() {
        return horsepowerRpm;
    }

    public void setHorsepowerRpm(int horsepowerRpm) {
        this.horsepowerRpm = horsepowerRpm;
    }

    public int getTorqueFtLbs() {
        return torqueFtLbs;
    }

    public void setTorqueFtLbs(int torqueFtLbs) {
        this.torqueFtLbs = torqueFtLbs;
    }

    public int getTorqueRpm() {
        return torqueRpm;
    }

    public void setTorqueRpm(int torqueRpm) {
        this.torqueRpm = torqueRpm;
    }

    public int getValves() {
        return valves;
    }

    public void setValves(int valves) {
        this.valves = valves;
    }

    public String getValveTiming() {
        return valveTiming;
    }

    public void setValveTiming(String valveTiming) {
        this.valveTiming = valveTiming;
    }

    public String getCamType() {
        return camType;
    }

    public void setCamType(String camType) {
        this.camType = camType;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}
