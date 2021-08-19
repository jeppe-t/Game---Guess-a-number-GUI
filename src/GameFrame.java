package video25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    private Game game;
    private Player player;
    private TextField textField;
    private JLabel indikator, antalForsøg;


    public GameFrame(String title){
        super(title);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,100);

        getContentPane().setLayout(new FlowLayout());



        game = new Game();
        player = new Player();

        addComponents();


    }

    void addComponents(){

        //Adding components

        antalForsøg = new JLabel("Forsøg: " + player.getTries());
        getContentPane().add(antalForsøg);

        textField = new TextField(8);
        getContentPane().add(textField);

        JButton button = new JButton("Gæt tal!!!");
        getContentPane().add(button);

        indikator = new JLabel("Gæt et tal mellem [ 1-10 ]");
        getContentPane().add(indikator);

        button.addActionListener(this);

    }

    private void resetGame(){

        //Create new random number and new player.
        game = new Game();
        player = new Player();

        //Set default text in components
        indikator.setText("Gæt et tal mellem [ 1-10 ]");
        antalForsøg.setText("Forsøg: " + player.getTries());

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //Increment tries.
        player.addTries();
        antalForsøg.setText("Forsøg: " + player.getTries());


        //Extract number guessed
        String indtastetString = textField.getText();
        int indtastet = Integer.parseInt(indtastetString);


        //CORRECT
        if(indtastet == game.getRandomNumber()){
            JOptionPane.showMessageDialog(null, "Tillykke - du gættede rigtigt!!!\nDu brugte " + player.getTries() + " forsøg!\nNice:-D");
            resetGame();
        //To low
        } else if (indtastet < game.getRandomNumber()){
            indikator.setText("Forkert - du gættede for lavt!!!");
        //To High
        } else if (indtastet > game.getRandomNumber()){
            indikator.setText("Forkert - du gættede for højt!!!");

        }



    }
}
