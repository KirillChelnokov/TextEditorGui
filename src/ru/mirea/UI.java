package ru.mirea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UI extends JFrame {
    JTextArea mainTextArea = new JTextArea(10,50);
    JButton someButton = new JButton("Some button");

    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("Файл");
    JMenuItem openItem = new JMenuItem("Открыть...");
    JMenuItem closeItem = new JMenuItem("Закрыть...");

    public UI(String appName){
        super(appName);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(menuBar);

        fileMenu.add(openItem);
        fileMenu.add(closeItem);
        menuBar.add(fileMenu);

        openItem.addActionListener(new FileOpener(this));

        JPanel contentsPanel = (JPanel) getContentPane();

        JPanel topButtonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topButtonsPanel.add(someButton);

        contentsPanel.add(topButtonsPanel,BorderLayout.NORTH);
        contentsPanel.add(mainTextArea);

        // contents.setLayout(...);
        // repaint()

        pack();
        setVisible(true);
    }

}
