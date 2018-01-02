package com.kalkulator;
//nowa wersja tego pliku
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//kolejna nowa wersja tego pliku
public class Calculator extends JFrame implements ActionListener {

    private JTextField firstNumber = new JTextField("0", 5);
    private JButton plusOrMinus = new JButton("+");
    private JTextField secondNumber = new JTextField("0", 5);
    private JButton equals = new JButton("=");
    private JLabel result = new JLabel("");
    private JLabel info = new JLabel("wprowadź dwie liczby...");

    public Calculator() {
        super("Dodawanie lub odejmowanie");
        setSize(320, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
        setLayout(flow);
        plusOrMinus.addActionListener(this);
        equals.addActionListener(this);
        add(firstNumber);
        add(plusOrMinus);
        add(secondNumber);
        add(equals);
        add(result);
        add(info);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == equals) {
            try {
                int numberOne = Integer.parseInt(firstNumber.getText());
                int numberTwo = Integer.parseInt(secondNumber.getText());
                if (plusOrMinus.getText() == "+") {
                    result.setText("" + (numberOne + numberTwo));
                    info.setText("dodawanie wykonane");
                } else {
                    result.setText("" + (numberOne - numberTwo));
                    info.setText("odejmowanie wykonane");
                }
            } catch (NumberFormatException nfe) {
                firstNumber.setText("0");
                secondNumber.setText("0");
                result.setText("0");
                info.setText("możesz wprowadzać tylko liczby całkowite!!!");
            }
        }
        if (event.getSource() == plusOrMinus) {
            if (plusOrMinus.getText() == "+") {
                plusOrMinus.setText("-");
                info.setText("wybrałeś odejmowanie");
            } else {
                plusOrMinus.setText("+");
                info.setText("wybrałeś dodawanie");
            }
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }
}
