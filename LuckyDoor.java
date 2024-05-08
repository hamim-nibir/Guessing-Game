import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

class HomeWindow implements WindowListener, ActionListener {
    Frame fr;
    Label l1, l2;
    Button b;
    HomeWindow(){
        fr = new Frame("Lucky Door Game");
        fr.setLayout(null);
        fr.setResizable(false);
        fr.setSize(800, 800);
        fr.addWindowListener(this);
        fr.setBackground(Color.CYAN);
        fr.setVisible(true);

        l1 = new Label("Welcome to the exciting guessing game.");
        l2 = new Label("Choose the correct door & get your prize.");
        l1.setFont(new Font("ARIAL", Font.PLAIN,30));
        l1.setBounds(100,200, 600, 50);
        l2.setFont(new Font("ARIAL", Font.PLAIN, 30));
        l2.setBounds(100,250, 600, 50);
        fr.add(l1); fr.add(l2);

        b = new Button("Start the game");
        b.setBounds(330, 350, 100, 50);
        b.setBackground(Color.ORANGE);
        b.setFocusable(false);
        b.addActionListener(this);
        fr.add(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b){
            MainWindow mw = new MainWindow();
            fr.setVisible(false);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(1);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}

class MainWindow implements WindowListener, ActionListener{

    Frame fr;
    Button b;
    TextField tf;
    Label l;
    Button d1, d2, d3, playAgain;

    int correctDoor, lives;
    Random rand = new Random();

    MainWindow(){
        correctDoor = rand.nextInt(3);
        lives = 3;

        fr = new Frame("Lucky Door Game");
        fr.setSize(800, 800);
        fr.setLayout(null);
        fr.setBackground(Color.CYAN);
        fr.setResizable(false);
        fr.addWindowListener(this);
        fr.setVisible(true);

        b = new Button("Reset");
        b.setBounds(10,40, 100, 50);
        b.setBackground(Color.ORANGE);
        b.setFocusable(false);
        b.addActionListener(this);
        fr.add(b);

        tf = new TextField();
        tf.setBounds(250, 40, 300, 50);
        tf.setBackground(Color.WHITE);
        fr.add(tf);

        l = new Label("Remaining Attempts: " + lives);
        l.setBounds(600, 40, 150, 50);
        fr.add(l);

        d1 = new Button("Door 1");
        d1.setBounds(10, 120, 250, 500);
        d1.setBackground(Color.RED);
        d1.addActionListener(this);
        fr.add(d1);

        d2 = new Button("Door 2");
        d2.setBounds(270, 120, 250, 500);
        d2.setBackground(Color.RED);
        d2.addActionListener(this);
        fr.add(d2);

        d3 = new Button("Door 3");
        d3.setBounds(530, 120, 250, 500);
        d3.setBackground(Color.RED);
        d3.addActionListener(this);
        fr.add(d3);

        playAgain = new Button("Play Again");
        playAgain.setBounds(120,40,100,50);
        playAgain.setBackground(Color.ORANGE);
        playAgain.setFocusable(false);
        playAgain.setVisible(false);
        playAgain.addActionListener(this);
        fr.add(playAgain);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(d1)){
            if(correctDoor==0){
                tf.setText("Congratulations! You've got the prize.");
                d1.setBackground(Color.GREEN);
                playAgain.setVisible(true);
                b.setVisible(false);
                d2.setVisible(false);
                d3.setVisible(false);
            }
            else{
                lives--;
                l.setText("Remaining Lives : " + lives);
            }
        }
        else if(e.getSource().equals(d2)){
            if(correctDoor==1){
                tf.setText("Congratulations! You've got the prize.");
                d2.setBackground(Color.GREEN);
                playAgain.setVisible(true);
                b.setVisible(false);
                d1.setVisible(false);
                d3.setVisible(false);
            }
            else{
                lives--;
                l.setText("Remaining Lives : " + lives);
            }
        }
        else if(e.getSource().equals(d3)){
            if(correctDoor==2){
                tf.setText("Congratulations! You've got the prize.");
                d3.setBackground(Color.GREEN);
                playAgain.setVisible(true);
                b.setVisible(false);
                d2.setVisible(false);
                d1.setVisible(false);
            }
            else{
                lives--;
                l.setText("Remaining Lives : " + lives);
            }
        }
        else if(e.getSource().equals(b)){
            lives = 3;
            l.setText("Remaining Lives : " + lives);
            tf.setText(" ");
        }
        else if(e.getSource().equals(playAgain)){
            lives = 3;
            l.setText("Remaining Lives : " + lives);
            d1.setVisible(true);
            d2.setVisible(true);
            d3.setVisible(true);
            d1.setBackground(Color.RED);
            d2.setBackground(Color.RED);
            d3.setBackground(Color.RED);
            tf.setText(" ");
            correctDoor = rand.nextInt(3);
            b.setVisible(true);
        }
        if(lives == 0){
            tf.setText("Sorry! You didn't get the prize.");
            playAgain.setVisible(true);
        }
        else if(lives <0){
            d1.setVisible(false);
            d2.setVisible(false);
            d3.setVisible(false);
            tf.setText("Game over! Play Again.");
        }
        correctDoor = rand.nextInt(3);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(1);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}


public class LuckyDoor {
    public static void main(String[] args) {
        HomeWindow run = new HomeWindow();
    }
}
