package main;

import conTools.*;
import dataMan.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    static App app;
    private JPanel panel1;
    private JButton loadButton;
    private JTextField textBox;
    private JButton Button_Celestrak;
    private JButton button2;
    private JLabel label_lastupdate;
    private JButton testButton;
    private JFileChooser fc;

    public App() {
        fileDialogTool filedialog = new fileDialogTool(app);
        loadButton.addActionListener(filedialog);
        Button_Celestrak.addActionListener(new satcatMan());
        button2.addActionListener(new readDB());
        testButton.addActionListener(new testButton());
        //textBox.set
    }

//    public JTextField getTextbox(){
//        System.out.println("getTextbox");
//        return textBox;
//    }

    public static void main(String args[]){

        JFrame frame = new JFrame("App");

        app = new App();
        app.setContentPane(app.panel1);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.pack();
        app.setVisible(true);
    }
}
