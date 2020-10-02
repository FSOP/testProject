package dataMan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import conTools.*;
import main.*;


public class satcatMan implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        testWeb satdata = new testWeb();
        BufferedReader br = satdata.downCelestrak();
        insertdb(br);

        testDB db = new testDB();
        db.metadataman("SATCAT");
    }

    public void insertdb(BufferedReader brSAT){
        testDB dbcon = new testDB();
        String line;

        try {
            long starttime = System.currentTimeMillis();
            System.out.println("Starttime: "+starttime);
            dbcon.executeDB("delete from satcat");
            while ((line = brSAT.readLine()) != null) {
                ArrayList<String> satdata = new ArrayList<String>();

                //
                satdata.add(0, line.substring(0, 11));   //Int' Designator
                satdata.add(1, line.substring(13, 18));   //Norad
                satdata.add(2, line.substring(19, 20));   //Multiple NameFlag
                satdata.add(3, line.substring(20, 21));   //Payload Flag
                satdata.add(4, line.substring(21, 22));    //Operational Status Code
                satdata.add(5, line.substring(23, 47));   //Satellite Names
                satdata.add(6, line.substring(49, 54));   //Ownership
                satdata.add(7, line.substring(56, 66));   //launch date
                satdata.add(8, line.substring(68, 73));   //launch site
                satdata.add(9, line.substring(75, 85));   //Decay date
                satdata.add(10, line.substring(87, 94));  //Orbital Period
                satdata.add(11, line.substring(96, 101)); //Inclination
                satdata.add(12, line.substring(103, 109));    //Apogee Altitude
                satdata.add(13, line.substring(111, 117));    //Perigee Altitude
                satdata.add(14, line.substring(119, 127));    //Radar Cross Section
                satdata.add(15, line.substring(129, 132));    //Orbital Status Code
                //celestrak.com/satcat/satcat-format.php


                String prestatedquery = "insert into satcat values (?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                dbcon.insertSATCAT(prestatedquery, satdata);
//                dbcon.executeDB("insert into satcat (international_designator, norad) values ('abc', '123')");
            }
            long stoptime = System.currentTimeMillis();
            System.out.println("Elasped Time: " + (stoptime - starttime));
        } catch (IOException e){
            e.getMessage();
        }

    }


    public static void main(String args[]){

    }
}
