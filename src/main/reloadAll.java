package main;
import conTools.*;
import dataMan.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;


public class reloadAll extends App{
    public reloadAll() {
            System.out.println("reloadALl");
            testDB db = new testDB();
            ResultSet res = db.queryDB("select max(updatetime) from metadata");

            String updatetime = "";
            try {
                while (res.next()) {
                    updatetime = res.getString(1);

                }
                System.out.println("updatetime is : "+updatetime);
//                this.label_lastupdate.setText(updatetime);
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }

}
