package conTools;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//public class testWeb implements ActionListener {
//
//    @Override
//    public void actionPerformed(ActionEvent e){
//        String loc = "http://celestrak.com/pub/satcat.txt";
//        System.out.println("request url is :"+loc);
//        try{
//            URL url = new URL(loc);
//            URLConnection conn = url.openConnection();
//
//            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
//            BufferedReader br = new BufferedReader(reader);
//            int i;
//
//            for(i=0;i<10;i++){
//                System.out.println(br.readLine());
//            }
//        } catch(IOException ee){ ee.printStackTrace(); }
//    }

public class testWeb {
    public BufferedReader downCelestrak() {
        BufferedReader br = null;
        try {

            URL url = new URL("http://celestrak.com/pub/satcat.txt");
            URLConnection conn = url.openConnection();

            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            br = new BufferedReader(reader);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return br;
    }


    public static void main(String args[]){

    }
}

