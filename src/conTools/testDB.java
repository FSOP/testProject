package conTools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class testDB {
    Connection conn = null;
    Statement state;
    String dbloc = "data/currentdata.txt";
    String dbURL = "jdbc:sqlite:" + dbloc;

    public void initDB(){
        try{
            conn = DriverManager.getConnection(dbURL);
            state = conn.createStatement();
            System.out.println("DB Connection Established");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public ResultSet queryDB(String query){
        ResultSet res1 = null;
        try{
            if (conn == null){
                initDB();
            }
            res1 = state.executeQuery(query);
            System.out.println(res1);

        } catch(SQLException e){
            System.out.println(e.getMessage());
        } finally{
            return res1;
        }
    }

    public void executeDB(String query){
        try{
            if (conn == null){ initDB(); }

            System.out.println(query);
            state.execute(query);
        } catch (SQLException e){
            System.out.println("ERROR in executeDB");
            System.out.println(e.getMessage());
        }
    }

    public void insertSATCAT(String query, ArrayList<String> satdata){
        try{
            if (conn == null) { initDB(); };
            PreparedStatement psmt = conn.prepareStatement(query);
            int i = 1;
            for (String sp : satdata){
                psmt.setString(i, sp);
                i++;
            }
            psmt.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public void metadataman(String target){
        if (conn == null) { initDB(); }
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = format1.format(System.currentTimeMillis());
        System.out.println(target +": "+nowtime);
        String query = "insert into metadata values (?, ?)";

        try {
            PreparedStatement psmt = conn.prepareStatement(query);
            psmt.setString(1, nowtime);
            psmt.setString(2, target);
            psmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
