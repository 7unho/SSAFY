package com.ssafy.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.Random;

public class LayoutTest extends JFrame {
    private static final long serialBersionUID = 1L;
    private JLabel lNum1, lNum2, lCorrectCnt, lWrongCnt;
    private JTextField tfAns;
    private int answer;

    public static void main(String[] args) {
        LayoutTest lt = new LayoutTest();
        lt.launchUi();
    }

    public void launchUi(){
        this.add(new JLabel("구구단을 외자1"), BorderLayout.NORTH);

        makeResultPanel();
        makeProblempanel();

        this.setTitle("layout test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void makeProblem(){
        Random rand = new Random();
        int num1 = rand.nextInt(9) + 1;
        int num2 = rand.nextInt(9) + 1;
        this.answer = num1 * num2;
        lNum1.setText(num1 + "");
        lNum2.setText(num2 + "");
        tfAns.setText("");
    }

    private void makeResultPanel(){
        JPanel panel = new JPanel();
        panel.add(new JLabel("정답 개수 : "));
        lCorrectCnt = new JLabel("0");
        panel.add((lCorrectCnt));
        panel.add(new JLabel("오답 개수 :"));
        lWrongCnt = new JLabel("0");
        panel.add(lWrongCnt);
        this.add(panel, BorderLayout.SOUTH);
    }

    private void makeProblempanel(){
        JPanel panel = new JPanel();
        lNum1 = new JLabel();
        lNum2 = new JLabel();
        panel.add(lNum1);
        panel.add(new JLabel("*"));
        panel.add(lNum2);
        panel.add(new JLabel("="));
        tfAns = new JTextField(10);
        panel.add(tfAns);
        makeProblem();
        tfAns.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // keyCode -> 10 : enterkey
                if(e.getKeyCode() == 10){
                    int val = Integer.parseInt(tfAns.getText());
                    int pre;
                    if(val == answer){
                        pre = Integer.parseInt(lCorrectCnt.getText());
                        lCorrectCnt.setText((pre + 1) + "");
                    }else{
                        pre = Integer.parseInt(lWrongCnt.getText());
                        lWrongCnt.setText((pre + 1) + "");
                    }
                    makeProblem();
                }
            }
        });
        this.add(panel, BorderLayout.CENTER);
    }
}
