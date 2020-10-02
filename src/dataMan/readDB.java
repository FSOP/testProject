package dataMan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import conTools.testDB;


public class readDB implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        testDB db = new testDB();
        ResultSet res = db.queryDB("Select * from test");

        try {
            while (res.next()) {
                System.out.println(res.getString(1));
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }
}
