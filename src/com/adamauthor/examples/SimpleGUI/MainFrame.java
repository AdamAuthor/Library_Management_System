package com.adamauthor.examples.SimpleGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        setSize(400, 400);
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JLabel label = new JLabel("Plus & Minus");
        label.setLocation(100, 100);
        label.setSize(100, 30);
        add(label);

        JTextField textField = new JTextField();
        textField.setLocation(100, 150);
        textField.setSize(100, 30);
        add(textField);

        JTextField textField2 = new JTextField();
        textField2.setLocation(220, 150);
        textField2.setSize(100, 30);
        add(textField2);

        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(100, 250, 100, 30);
        add(resultLabel);

        JButton button = new JButton("+");
        button.setBounds(100, 200, 100, 30);
        add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num1 = textField.getText();
                String num2 = textField2.getText();

                int n1 = Integer.parseInt(num1);
                int n2 = Integer.parseInt(num2);

                String res = String.valueOf(n1 + n2);
                resultLabel.setText(res);
                textField.setText("");
                textField2.setText("");
            }
        });

        JButton button1 = new JButton("-");
        button1.setBounds(220, 200, 100, 30);
        add(button1);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num1 = textField.getText();
                String num2 = textField2.getText();

                int n1 = Integer.parseInt(num1);
                int n2 = Integer.parseInt(num2);

                String res = String.valueOf(n1 - n2);
                resultLabel.setText(res);
                textField.setText("");
                textField2.setText("");
            }
        });
    }
}
