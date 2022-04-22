import com.race.Formula1Driver;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.*;


class DriverTable extends Formula1Driver {
    static LinkedList<Formula1Driver> driverlist = new <Formula1Driver>LinkedList();
    static LinkedList<Races> racelist = new <Races>LinkedList();
    //static Races races=new Races();
    static Date date = new Date();
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    static DefaultTableModel tableModel3 = new DefaultTableModel();
    static JTable table2 = new JTable(tableModel3);

    public DriverTable(String driverName, String team, String location) {
        super(driverName, team, location);
    }

    static class MyWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Closing window");
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        try {
            FileInputStream saveInToFile = new FileInputStream("f1driver.txt");
            ObjectInputStream save = new ObjectInputStream(saveInToFile);
            driverlist = (LinkedList) save.readObject();
            racelist = (LinkedList) save.readObject();


            save.close();
        } catch (Exception exc) {
            System.out.println("Error in loading file");
        }
        Comparator<Formula1Driver> pointComparator = new Comparator<Formula1Driver>() {

            @Override
            public int compare(Formula1Driver o1, Formula1Driver o2) {
                if (o1.getnoOfCurrentPoints() > o2.getnoOfCurrentPoints()) {
                    return -1;
                } else if (o1.getnoOfCurrentPoints() == o2.getnoOfCurrentPoints()) {
                    if (o1.getnoOfFirstPositions() > o2.getnoOfFirstPositions()) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        };
        Collections.sort(driverlist, pointComparator);

    }

    public static void points(int place, int x) {

        outer:
        for (Formula1Driver formula1Driver : driverlist) {
            if (driverlist.indexOf(formula1Driver) == x) {
                if (place == 1) {
                    formula1Driver.setnoOfFirstPositions(formula1Driver.getnoOfFirstPositions()+1);
                    formula1Driver.setnoOfCurrentPoints(formula1Driver.getnoOfCurrentPoints()+25);

                    formula1Driver.setNoOfRacesParticipated(formula1Driver.getnoOfRacesParticipated()+1);


                    break outer;

                }
                if (place == 2) {
                    formula1Driver.setnoOfSecondPositions(formula1Driver.getnoOfSecondPositions()+1);
                    formula1Driver.setnoOfCurrentPoints(formula1Driver.getnoOfCurrentPoints()+18);
                    formula1Driver.setNoOfRacesParticipated(formula1Driver.getnoOfRacesParticipated(formula1Driver.getnoOfRacesParticipated()+1);


                    break outer;
                }

                if (place == 3) {
                    formula1Driver.setnoOfThirdPositions(formula1Driver.getnoOfThirdPositions()+1);
                    formula1Driver.setnoOfCurrentPoints(formula1Driver.getnoOfCurrentPoints()+15);
                    formula1Driver.setNoOfRacesParticipated(formula1Driver.getnoOfRacesParticipated(formula1Driver.getnoOfRacesParticipated()+1);

                    break outer;
                }

                if (place == 4) {
                    formula1Driver.setnoOfCurrentPoints(formula1Driver.getnoOfCurrentPoints()+12);
                    formula1Driver.setNoOfRacesParticipated(formula1Driver.getnoOfRacesParticipated(formula1Driver.getnoOfRacesParticipated() + 1)+1);

                    break outer;
                }

                if (place == 5) {
                    formula1Driver.setnoOfCurrentPoints(formula1Driver.getnoOfCurrentPoints()+10);
                    formula1Driver.getnoOfRacesParticipated(formula1Driver.getnoOfRacesParticipated(formula1Driver.getnoOfRacesParticipated() + 1)+1);

                    break outer;
                }

                if (place == 6) {
                    formula1Driver.setnoOfCurrentPoints(formula1Driver.getnoOfCurrentPoints()+8);
                    formula1Driver.getnoOfRacesParticipated(formula1Driver.getnoOfRacesParticipated() + 1).setnoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated()+1);

                    break outer;
                }

                if (place == 7) {
                    formula1Driver.setnoOfCurrentPoints(formula1Driver.getnoOfCurrentPoints()+6);
                    formula1Driver.setnoOfRacesParticipated(formula1Driver.getnoOfRacesParticipated()+1);

                    break outer;
                }

                if (place == 8) {
                    formula1Driver.setnoOfCurrentPoints(formula1Driver.getnoOfCurrentPoints()+4);
                    formula1Driver.setNoOfRacesParticipated(formula1Driver.).setNoRaces(formula1Driver.getNoRaces() + 1);

                    break outer;
                }

                if (place == 9) {
                    formula1Driver.setnoOfCurrentPoints(formula1Driver.getnoOfCurrentPoints()+2);
                    formula1Driver.setNoOfRacesParticipated(formula1Driver.getnoOfRacesParticipated(formula1Driver.getnoOfRacesParticipated() + 1)+1);

                    break outer;
                }

                if (place == 10) formula1Driver.setnoOfCurrentPoints(formula1Driver.getnoOfCurrentPoints()+1);
                {
                    formula1Driver.setNoOfRacesParticipated(formula1Driver.getnoOfRacesParticipated(formula1Driver.getnoOfRacesParticipated() + 1)+1);

                    break outer;
                }
            }
        }
    }


    public static void print(){
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("NAME");
        tableModel.addColumn("TEAM");
        tableModel.addColumn("LOCATION");
        tableModel.addColumn("NUMBER OF FIRST POSITIONS");
        tableModel.addColumn("NUMBER OF SECOND POSITIONS");
        tableModel.addColumn("NUMBER OF THIRD POSITIONS");
        tableModel.addColumn(" NUMBER OF POINTS THAT DRIVER HAVE");
        tableModel.addColumn("NUMBER OF RACES THAT DRIVER PARTICIPATED");

        for (Formula1Driver formulaDriver : driverlist) {
            tableModel.addRow(new Object[]{formulaDriver.getDriverName(), formulaDriver.getTeam(), formulaDriver.getLocation(), formulaDriver.getnoOfFirstPositions(), formulaDriver.getnoOfSecondPositions(), formulaDriver.getnoOfThirdPositions(), formulaDriver.getnoOfCurrentPoints(), formulaDriver.getnoOfRacesParticipated()});
        }

        JFrame f = new JFrame();
        JPanel jp = new JPanel();
        f.setContentPane(jp);
        f.addWindowListener(new MyWindowListener());

        JButton button1 = new JButton(new AbstractAction("Number of Points that Driver currently Have ascending") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comparator<Formula1Driver> pointComparator = new Comparator<Formula1Driver>() {

                    @Override
                    public int compare(Formula1Driver o1, Formula1Driver o2) {
                        if (o1.getnoOfCurrentPoints()> o2.getnoOfCurrentPoints()) {
                            return -1;
                        } else if (o1.getnoOfCurrentPoints() == o2.getnoOfCurrentPoints()) {
                            if (o1.getnoOfFirstPositions() > o2.getnoOfFirstPositions()) {
                                return -1;
                            } else {
                                return 1;
                            }
                        } else {
                            return 1;
                        }
                    }
                };
                Collections.sort(driverlist, pointComparator);

            }


        });

        JButton button2 = new JButton(new AbstractAction("First Position descending") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comparator<Formula1Driver> pointComparator = new Comparator<Formula1Driver>() {

                    @Override
                    public int compare(Formula1Driver o1, Formula1Driver o2) {
                        if (o1.getnoOfCurrentPoints() > o2.getnoOfCurrentPoints()) {
                            return -1;
                        } else if (o1.getnoOfCurrentPoints() == o2.getnoOfCurrentPoints()) {
                            if (o1.getnoOfFirstPositions() > o2.getnoOfFirstPositions()) {
                                return -1;
                            } else {
                                return 1;
                            }
                        } else {
                            return 1;
                        }
                    }
                };
                Collections.sort(driverlist, pointComparator);

            }


        });
        String location = null;
        String Date = null;
        JButton button3 = new JButton(new AbstractAction("add race") {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                Collections.shuffle(list);
                Collections.shuffle(driverlist);
                for (int x = 0; x < list.size(); x++) {
                    int place = list.get(x);
                    points(place, x);
                    for (Formula1Driver formula1Driver : driverlist) {
                        if (driverlist.indexOf(formula1Driver) == x) {
                            Races races = new Races();
                            races.setDate(Date);
                            races.setName(NAME);
                            races.setLocation(location);
                            racelist.add(races);
                        }
                    }
                }

                DefaultTableModel tableModel3 = new DefaultTableModel();
                JTable table2 = new JTable(tableModel3);
                tableModel3.addColumn("dates");
                tableModel3.addColumn("driver name");
                tableModel3.addColumn("location");
                f.getContentPane().add(new JScrollPane(table2));
                racelist.sort(Comparator.comparing(Races::getDate));

                for (Races races : racelist) {

                    tableModel3.addRow(new Object[]{formatter.format(races.getDate()), races.getName(), races.getLocation()});

                }
                Comparator<Formula1Driver> pointComparator = new Comparator<Formula1Driver>() {

                    @Override
                    public int compare(Formula1Driver o1, Formula1Driver o2) {
                        if (o1.getnoOfCurrentPoints() > o2.getnoOfCurrentPoints()) {
                            return -1;
                        } else if (o1.getnoOfCurrentPoints() == o2.getnoOfCurrentPoints()) {
                            if (o1.getnoOfFirstPositions() > o2.getnoOfFirstPositions()) {
                                return -1;
                            } else {
                                return 1;
                            }
                        } else {
                            return 1;
                        }
                    }
                };
                Collections.sort(driverlist, pointComparator);

            }


        });


        JButton button4 = new JButton(new AbstractAction("probability Race") {
            int y = 9;

            @Override
            public void actionPerformed(ActionEvent e) {

                // races.setDate(date);
                //  racelist.add(races);
                tableModel.addColumn("new positions");
                List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                Collections.shuffle(list);
                for (int x = 0; x < 10; x++) {
                    int place = list.get(x);


                    points(place, x);

                    tableModel.setValueAt(place, x, y);
                }


                y = y + 1;
                Comparator<Formula1Driver> pointComparator = new Comparator<Formula1Driver>() {

                    @Override
                    public int compare(Formula1Driver o1, Formula1Driver
                            o2) {
                        if (o1.getnoOfCurrentPoints() > o2.getnoOfCurrentPoints()) {
                            return -1;
                        } else if (o1.getnoOfCurrentPoints() == o2.getnoOfCurrentPoints()) {
                            if (o1.getnoOfFirstPositions() > o2.getnoOfFirstPositions()) {
                                return -1;
                            } else {
                                return 1;
                            }
                        } else {
                            return 1;
                        }
                    }
                };
                Collections.sort(driverlist, pointComparator);

            }


        });


        JButton button5 = new JButton(new AbstractAction("race date") {
            @Override
            public void actionPerformed(ActionEvent e) {


                DefaultTableModel tableModel2 = new DefaultTableModel();
                JTable table1 = new JTable(tableModel2);
                //table1.setModel(table2.getModel());
                tableModel2.addColumn("dates");
                tableModel2.addColumn("driver name");
                tableModel2.addColumn("location");
                f.getContentPane().add(new JScrollPane(table1));
                racelist.sort(Comparator.comparing(Races::getDate));

                for (Races races : racelist) {

                    tableModel2.addRow(new Object[]{formatter.format(races.getDate()), races.getName(), races.getLocation()});

                }
            }
        });


        JButton button6 = new JButton(new AbstractAction("search driver") {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        f.getContentPane().add(button1);
        f.getContentPane().add(button2);
        f.getContentPane().add(button3);
        f.getContentPane().add(button4);
        f.getContentPane().add(button5);
        f.getContentPane().add(new JScrollPane(table));

        f.setSize(1000, 1000);

        //   f.add(new JScrollPane(table));
        f.setVisible(true);


    }


    private static class Races {
    }
}