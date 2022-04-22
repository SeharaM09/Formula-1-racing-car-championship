package com.race;

public abstract class Driver {


    private String driverName;
    private String location;
    private String team;
    public Driver(String driverName, String team, String location) {
        this.driverName = driverName;
        this.team = team;
        this.location = location;

    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {

        this.driverName = driverName;

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location =location;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }




     public abstract void calculateNoOfPoints(boolean checkRaceCondition, int positions);


}
