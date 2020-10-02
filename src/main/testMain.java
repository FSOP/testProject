package main;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;

public class testMain {
    static Connection conn = null;
    static Statement state;

    public static void connect(){
        ResultSet res1;
        try{
            String url = "jdbc:sqlite:C:/Users/ukouu/IdeaProjects/Testproject/data/test.txt";
            conn = DriverManager.getConnection(url);
            state = conn.createStatement();
            System.out.println("DB connection Established");
            //res1 = state.executeQuery("select * from test");
            res1 = query("select * from test where test1 > 1000");
            System.out.println("query succesfully ended");
            System.out.println(res1);

            System.out.println(res1.getString(0));


        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            try{
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static ResultSet query(String query){
        ResultSet res = null;
        try{
            res = state.executeQuery(query);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            return res;
        }
    }
    public static void main(String args[]){

//        connect();
        String line = "1958-004A$$$$00007$$$D$SL-1$R/B                  CIS    1958-05-15  TYMSC  1958-12-03    102.7   65.1    1571     206     N/A       ";
        ArrayList<String> satdata = new ArrayList<String>();

        satdata.add(0, line.substring(0,11));   //Int' Designator
        satdata.add(1,line.substring(13,18));   //Norad
        satdata.add(2,line.substring(19,20));   //Multiple NameFlag
        satdata.add(3,line.substring(20,21));   //Payload Flag
        satdata.add(4,line.substring(21,22));    //Operational Status Code
        satdata.add(5,line.substring(23,47));   //Satellite Names
        satdata.add(6,line.substring(49,54));   //Ownership
        satdata.add(7,line.substring(56,66));   //launch date
        satdata.add(8,line.substring(68,73));   //launch site
        satdata.add(9,line.substring(75,85));   //Decay date
        satdata.add(10,line.substring(87,94));  //Orbital Period
        satdata.add(11,line.substring(96,101)); //Inclination
        satdata.add(12,line.substring(103,109));    //Apogee Altitude
        satdata.add(13,line.substring(111,117));    //Perigee Altitude
        satdata.add(14,line.substring(119,127));    //Radar Cross Section
        satdata.add(15,line.substring(129,132));    //Orbital Status Code
        //celestrak.com/satcat/satcat-format.php

        int i = 1;
        for(String st : satdata){
            System.out.println(i + " : "+st.trim());
            i++;
        }

        //String b[] = a.split(" ");
//        System.out.println(b[0]);
//        System.out.println(b[1]);



    }
}
