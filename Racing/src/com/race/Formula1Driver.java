package com.race;


public class Formula1Driver extends Driver {
    private int noOfFirstPositions;
    private int noOfSecondPositions;
    private int noOfThirdPositions;
    private float noOfCurrentPoints;
    private int noOfRacesParticipated;
    private int totalDriverFullPoints;
    private int sumOfRaces;

    public Formula1Driver(String driverName, String team, String location) {
        super(driverName,team,location);
    }


    public int getnoOfFirstPositions() {
        return noOfFirstPositions;
    }

    public void setnoOfFirstPositions(int noOfFirstPositions) {
        this.noOfFirstPositions = noOfFirstPositions;
    }

    public int getnoOfSecondPositions() {
        return noOfSecondPositions;
    }

    public void setnoOfSecondPositions(int noOfSecondPositions) {
        this.noOfSecondPositions = noOfSecondPositions;
    }

    public int getnoOfThirdPositions() {
        return noOfThirdPositions;
    }

    public void setnoOfThirdPositions(int noOfThirdPositions) {
        this.noOfThirdPositions = noOfThirdPositions;
    }

    public float getnoOfCurrentPoints() {
        return noOfCurrentPoints;
    }

    public void setnoOfCurrentPoints(float noOfCurrentPoints) {
        this.noOfCurrentPoints = noOfCurrentPoints;
    }

    public int getnoOfRacesParticipated(int i) { return noOfRacesParticipated;}

    public int gettotalDriverFullPoints(){
        return totalDriverFullPoints;
    }

    public void settotalDriverFullPoints(int totalDriverFullPoints){
        this.totalDriverFullPoints = totalDriverFullPoints;
    }

    public void setNoOfRacesParticipated(int noOfRacesParticipated) {
        this.noOfRacesParticipated = noOfRacesParticipated;
    }



    @Override
    public void calculateNoOfPoints(boolean checkRaceCondition, int positions) {
        if (checkRaceCondition) {
                if (positions == 1) {
                    totalDriverFullPoints += 25;
                    noOfFirstPositions++;
                }
                if (positions == 2) {
                    totalDriverFullPoints += 18;
                    noOfSecondPositions++;
                }
                if (positions == 3) {
                    totalDriverFullPoints += 15;
                    noOfThirdPositions++;
                }
                if (positions == 4) {
                    totalDriverFullPoints += 12;
                }
                if (positions == 5) {
                    totalDriverFullPoints += 10;
                }
                if (positions == 6) {
                    totalDriverFullPoints += 8;
                }
                if (positions == 7) {
                    totalDriverFullPoints += 6;
                }
                if (positions == 8) {
                    totalDriverFullPoints += 4;
                }
                if (positions == 9) {
                    totalDriverFullPoints += 2;
                }
                if (positions == 10) {
                    totalDriverFullPoints += 1;
                } else {
                    System.out.println("Highsts point is 10");
                }

            }
        else{
            System.out.println("Race Not Finished");
        }


        }


    public void calculations(boolean b, int value) {
    }
}






