package conTools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import conTools.*;
import main.*;

public class testButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e){
        testDB db = new testDB();
        db.metadataman("CELESTRAK_SATCAT");
        new reloadAll();
    }

    public void main(){
        System.out.println("main of testButton");
    }
}
