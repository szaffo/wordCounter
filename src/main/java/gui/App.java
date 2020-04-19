package gui;

import javax.swing.JFrame;

public class App extends JFrame {

    private static final long serialVersionUID = 791336967263136017L;

    private Panel panel;

    public App() {

        setResizable(false);
        setTitle("Word counter by Szabó Martin");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel = new Panel();
        
        add(panel);
        
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}
