package com.ssafy.gui;

import com.ssafy.xml.BoxOfficeDomParser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class BoxOfficeUi extends JFrame {
    JButton button = null;
    JTable table = null;

    DefaultTableModel model = null;

    public static void main(String[] args) {
        BoxOfficeUi ui = new BoxOfficeUi();
        ui.launchUi();
    }

    private void launchUi(){
        button = new JButton("읽기");

        table = new JTable();
        String[] header = {"랭킹", "제목", "개봉일", "누적관객"};
        model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(header);

        addEventListener();

        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.add(button, BorderLayout.SOUTH);
        this.setTitle("오늘의 영화 랭킹 TOP 10");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setVisible(true);
    }

    private void addEventListener(){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);

                BoxOfficeDomParser parser = new BoxOfficeDomParser();
                List<com.ssafy.xml.BoxOffice> list = parser.getBoxOffice();

                for (BoxOffice info:list) {
                    model.addRow(new Object[]{
                            info.getRank(),
                            info.getMovieNm(),
                            info.getOpenDt(),
                            info.getAudiAcc()
                    });
                }

                model.fireTableDataChanged();
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                String nm = model.getValueAt(row, 1).toString();
                JOptionPane.showMessageDialog(BoxOfficeUi.this, "선택된 영화 정보: " + nm);
            }
        });
    }
}
