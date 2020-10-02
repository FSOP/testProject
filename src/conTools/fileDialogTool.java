package conTools;

import main.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class fileDialogTool implements ActionListener {
    String fname = new String();
    JFileChooser fc = new JFileChooser();
    JPanel panel1 = new JPanel();
    JTextField textbox;
    public App appinst;
    int i = 0;

    public fileDialogTool(App app){
        System.out.println("filedialogtool");
    }
    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println(appinst);
        System.out.println("i is :"+i);
        //appinst.getTextbox();
        System.out.println("button clicked");
        fc = new JFileChooser();
        fc.showOpenDialog(panel1);
        fname = fc.getSelectedFile().getAbsolutePath();
        System.out.println(fname);
        //textbox.setText(fname);
    }
}
