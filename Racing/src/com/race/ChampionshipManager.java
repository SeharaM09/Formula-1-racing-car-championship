package com.race;

import java.io.IOException;
import java.util.Map;

public interface ChampionshipManager {

    void newDriver();

    void deleteDriver();

    void changeDriverTeam();

    void displayDriverStatistics();

    void displayDriverTable();



    void saveData(String[] information) throws IOException;

    void readSavedData(String[] information);


    void addNewRacePositions(String raceDate, Map<String, Integer> positions, Formula1ChampionshipManager d);
}
