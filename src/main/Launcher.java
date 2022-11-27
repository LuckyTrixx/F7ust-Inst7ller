package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class Launcher implements ActionListener {

    // Erstellen von Variablen für Spätere Objekte für die grafische Ausgabe
    private JComboBox sprache;
    private JComboBox driveletter;
    private JFrame optionsLauncher;
    private JCheckBox checkBoxVollbild;
    private JFileChooser chooser;
    private String location = "Choose Location";
    JButton bestaetigungsButton;
    JButton locationButton;
    JTextField locationField;

    public void launchMe() {
        System.out.println("MOPS");
        System.out.println(File.listRoots());
        System.out.println("MOPS");
        locationField = new JTextField(location);
        locationField.setEditable(false);
        int DriveIndex = 0;
        for (File root : File.listRoots()) {
            System.out.println(root.getAbsolutePath());
            System.out.println(root.getTotalSpace());
            DriveIndex++;
        }
        String[] DriveLetters = new String[DriveIndex];
        int DriveIndex2 = 0;
        for (File root : File.listRoots()) {
            DriveLetters[DriveIndex2] = root.getAbsolutePath();
            DriveIndex2++;
        }
        System.out.println("MOPS");
        // Einstellungen des Fensters
        optionsLauncher = new JFrame();
        optionsLauncher.setTitle("F7ust");
        optionsLauncher.setSize(1000, 500);
        JPanel panel = new JPanel();
        JLabel frage = new JLabel("Mops");
        panel.add(frage);
        // string Array für die Möglichen Sprachen
        String comboBoxSprache[] = { "English", "Deutsch", "More" };
        // Abfrage für Volbild
        checkBoxVollbild = new JCheckBox("Mops");

        // Adding the Stuff to the Window
        driveletter = new JComboBox(DriveLetters);
        sprache = new JComboBox(comboBoxSprache);
        bestaetigungsButton = new JButton("OK OK OK");
        bestaetigungsButton.addActionListener(this);
        locationButton = new JButton("Location");
        locationButton.addActionListener(this);
        panel.add(sprache);
        panel.add(driveletter);
        panel.add(bestaetigungsButton);
        panel.add(locationField);
        panel.add(locationButton);
        optionsLauncher.add(panel);
        optionsLauncher.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        switch (String.valueOf(sprache.getSelectedItem())) {
//        case "English":
//        }           
        if (e.getSource() == locationButton) {
            chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("choosertitle");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            //
            // disable the "All files" option.
            //
            chooser.setAcceptAllFileFilterUsed(false);
            //
            if (chooser.showOpenDialog(optionsLauncher) == JFileChooser.APPROVE_OPTION) {
                System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
                locationField.setText(chooser.getCurrentDirectory().toString());
                locationField.setColumns(20);
            } else {
                System.out.println("No Selection ");
            }
        } else {
            if (e.getSource() == bestaetigungsButton) {
                System.out.println("OK OK OK");
            }
        }
    }

}