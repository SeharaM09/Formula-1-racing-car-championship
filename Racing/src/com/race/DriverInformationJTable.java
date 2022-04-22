package com.race;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DriverInformationJTable extends JPanel {

    public DriverInformationJTable() {
        String[] columnNames = {
                "Name",
                "Location",
                "Team",
                "Points",
                "RacesParticipated"};
        Object[][] data = {
                {"John", "UK", "RED", new Integer(1000), new Integer(8)},
                {"Tom", "USA", "GREEN", new Integer(900), new Integer(7)},
                {"Helen", "AUS", "BLACK", new Integer(800), new Integer(8)},
                {"Kate", "SWD", "BLUE", new Integer(700), new Integer(8)},
                {"Susie", "JPY", "PINK", new Integer(500), new Integer(7)}
        };
        final JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("DriverInformationJTable");
        frame.setSize(400, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DriverInformationJTable newContentPane = new DriverInformationJTable();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);



        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createAndShowGUI();
    }

}