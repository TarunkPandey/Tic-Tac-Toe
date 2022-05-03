package com.TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Random random = new Random(); // To determine whose turn it is first.
    JFrame frame = new JFrame();
    JPanel tittle_panel = new JPanel(); // To hold the title.
    JPanel button_panel = new JPanel(); //To hold all the buttons.
    JLabel text_field = new JLabel(); //To display a msg.
    JButton[] buttons = new JButton[9];
    boolean player1_turn; // true if its player1 turn and vice versa.


    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text_field.setBackground(new Color(25,25,25));
        text_field.setForeground(new Color(25,255,0));
        text_field.setFont(new Font("Ink Free",Font.BOLD,75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic-Tac-Toe");
        text_field.setOpaque(true);

        tittle_panel.setLayout(new BorderLayout());
        tittle_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3)); // For 9 buttons of O and X on the frame
        button_panel.setBackground(new Color(150,150,150));

        for (int i = 0; i <9 ; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]); //Adding buttons on the panel.
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        tittle_panel.add(text_field); //Adding text_field to tittle_panel
        frame.add(tittle_panel,BorderLayout.NORTH); //Adding tittle_panel to frame
        frame.add(button_panel); // Adding button_panel to the frame.

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i <9 ; i++) {
            if (e.getSource()==buttons[i]) {
              if (player1_turn){
               if (buttons[i].getText()==""){
                   buttons[i].setForeground(new Color(255,0,0));
                   buttons[i].setText("X");
                   player1_turn=false;
                   text_field.setText("O Turn");
                   check();
               }
              }
              else {
                  if (buttons[i].getText()==""){
                      buttons[i].setForeground(new Color(0,255,255));
                      buttons[i].setText("O");
                      player1_turn=true;
                      text_field.setText("X Turn");
                      check();
                  }
              }
            }
        }
    }

    public void firstTurn(){ // To determine whose turn it is among X or O.

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2)==0){ // generates 2 random numbers between O and X.
            player1_turn=true;
            text_field.setText("X Turn");
        }
        else{
            player1_turn=false;
            text_field.setText("O Turn");
        }
    }
    public void check(){   // To check if any player has won.

        // check draw
        int i = 0;
        while (buttons[i].getText() != "") {
            if (i == buttons.length - 1) {
                draw();
                break;
            }
            i++;
        }
       // Check X win conditions
        if (
                        (buttons[0].getText()=="X")&&
                        (buttons[1].getText()=="X")&&
                        (buttons[2].getText()=="X")){
            xWins(0,1,2);
        }
        if (
                        (buttons[3].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[5].getText()=="X")){
            xWins(3,4,5);
        }
        if (
                        (buttons[6].getText()=="X")&&
                        (buttons[7].getText()=="X")&&
                        (buttons[8].getText()=="X")){
            xWins(6,7,8);
        }
        if (
                        (buttons[0].getText()=="X")&&
                        (buttons[3].getText()=="X")&&
                        (buttons[6].getText()=="X")){
            xWins(0,3,6);
        }
        if (
                        (buttons[1].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[7].getText()=="X")){
            xWins(1,4,7);
        }
        if (
                        (buttons[2].getText()=="X")&&
                        (buttons[5].getText()=="X")&&
                        (buttons[8].getText()=="X")){
            xWins(2,5,8);
        }
        if (
                        (buttons[0].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[8].getText()=="X")){
            xWins(0,4,8);
        }
        if (
                        (buttons[2].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[6].getText()=="X")){
            xWins(2,4,6);
        }

        // Check O win conditions
        if (
                        (buttons[0].getText()=="O")&&
                        (buttons[1].getText()=="O")&&
                        (buttons[2].getText()=="O")){
            oWins(0,1,2);
        }
        if (
                        (buttons[3].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[5].getText()=="O")){
            oWins(3,4,5);
        }
        if (
                        (buttons[6].getText()=="O")&&
                        (buttons[7].getText()=="O")&&
                        (buttons[8].getText()=="O")){
            oWins(6,7,8);
        }
        if (
                        (buttons[0].getText()=="O")&&
                        (buttons[3].getText()=="O")&&
                        (buttons[6].getText()=="O")){
            oWins(0,3,6);
        }
        if (
                        (buttons[1].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[7].getText()=="O")){
            oWins(1,4,7);
        }
        if (
                        (buttons[2].getText()=="O")&&
                        (buttons[5].getText()=="O")&&
                        (buttons[8].getText()=="O")){
            oWins(2,5,8);
        }
        if (
                        (buttons[0].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[8].getText()=="O")){
            oWins(0,4,8);
        }
        if (
                        (buttons[2].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[6].getText()=="O")){
            oWins(2,4,6);
        }
    }
    public void draw() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("Game is draw!");
    }

    public void xWins(int a, int b, int c){  // To check if X wins.
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i <9 ; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("X Wins");
    }

    public void oWins(int a, int b, int c){  // To check if O wins.
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i <9 ; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("O Wins");
    }

}
