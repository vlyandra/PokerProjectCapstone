/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author elich
 */
public class WelcomeScreen extends JFrame{
    JPanel mainPanel = new JPanel();
    JPanel welcomePanel = new JPanel();
    JPanel controlPanel = new JPanel();
    Container contentPane = this.getContentPane();
    JPanel pokerCalPanel = new PokerPanel(new JPanel());
    JPanel historyPanel = new PokerHistory();
    
    
    public WelcomeScreen(){
        setTitle("Poker Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1300,450);
        setVisible(true);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        
        JLabel createdBy = new JLabel("Created by:");
        createdBy.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
        JLabel authorsNames = new JLabel("Vanessa Redman   " + "Robert Edwards   " + "Thomas Corea   " +
                "Yuko Takegoshi   " + "Keith DeMoura   " + "Eli Cheek");
        authorsNames.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
        JLabel welcomeLabel = new JLabel("Welcome to the Poker Odds Calculator!");
        welcomeLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 32));
        JButton calculatorButton = new JButton("Go to Poker Calculator");
        JButton databaseButton = new JButton("Go to Poker Database");

        mainPanel.add(welcomePanel);
        mainPanel.setPreferredSize(new Dimension(contentPane.getWidth()-controlPanel.getWidth(),contentPane.getHeight()));
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setPreferredSize(new Dimension(175,contentPane.getHeight()));
        controlPanel.add(calculatorButton);
        controlPanel.add(databaseButton);
        welcomePanel.add(welcomeLabel);
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        welcomePanel.add(Box.createVerticalStrut(100));
        //mainPanel.add(Box.createHorizontalStrut(100));
        welcomePanel.add(Box.createVerticalStrut(40));
        welcomePanel.add(Box.createVerticalStrut(100));
        welcomePanel.add(createdBy);
        welcomePanel.add(authorsNames);
        add(mainPanel);
        add(controlPanel);
        
        //Using Spring Layout for resizing purposes not committed to this layout
        //seemed like the best for this basic purpose
        layout.putConstraint(SpringLayout.WEST, controlPanel,
                     5,
                     SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, controlPanel,
                     5,
                     SpringLayout.NORTH, contentPane);  
        layout.putConstraint(SpringLayout.WEST, mainPanel,
                     5,
                     SpringLayout.EAST, controlPanel);
        layout.putConstraint(SpringLayout.EAST, mainPanel,
                     5,
                     SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, mainPanel,
                     5,
                     SpringLayout.NORTH, controlPanel);
        layout.putConstraint(SpringLayout.SOUTH, contentPane,
                     5,
                     SpringLayout.SOUTH, mainPanel);
        //pack();
        validate();
        //Buttons will manipulate the viewing screen
        calculatorButton.addActionListener((ActionEvent e) -> {
            SpringLayout mainLayout = new SpringLayout();
            mainPanel.removeAll();
            mainPanel.add(pokerCalPanel);
            mainPanel.setLayout(mainLayout);
            mainLayout.putConstraint(SpringLayout.WEST, pokerCalPanel, 5, SpringLayout.WEST, mainPanel);
            mainLayout.putConstraint(SpringLayout.NORTH, pokerCalPanel, 5, SpringLayout.NORTH, mainPanel);
            repaint();
            validate();
        });
        databaseButton.addActionListener((ActionEvent e) -> {            
            mainPanel.removeAll();
            mainPanel.add(historyPanel);
            repaint();
            validate();
        });
        validate();
    }
}

