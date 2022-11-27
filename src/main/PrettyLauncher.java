package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JProgressBar;

public class PrettyLauncher extends JFrame implements ActionListener {
    JFileChooser chooser;
    JLabel lblInstallLocation;
    JButton btnNewButton;
    JButton btnNewButton_1;
    JComboBox comboBox_1;
    JComboBox comboBox;

    CopyCat kopierer;

    private JPanel contentPane;
    private static JProgressBar progressBar;

    /**
     * Launch the application.
     */
    public void run() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PrettyLauncher frame = new PrettyLauncher();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public PrettyLauncher() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "English", "Deutsch", "Italiano" }));
        comboBox.setBounds(533, 11, 115, 20);
        contentPane.add(comboBox);

        JLabel lblNewLabel = new JLabel("Choose Language");
        lblNewLabel.setBounds(10, 11, 187, 20);
        contentPane.add(lblNewLabel);

        JLabel lblChooseYourCd = new JLabel("Choose Your CD Drive");
        lblChooseYourCd.setBounds(10, 42, 187, 20);
        contentPane.add(lblChooseYourCd);

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

        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(DriveLetters));
        comboBox_1.setBounds(533, 42, 115, 20);
        contentPane.add(comboBox_1);

        lblInstallLocation = new JLabel("Install Location");
        lblInstallLocation.setBounds(10, 78, 477, 20);
        contentPane.add(lblInstallLocation);

        btnNewButton = new JButton("Choose Location");
        btnNewButton.addActionListener(this);
        btnNewButton.setBounds(533, 73, 115, 20);
        contentPane.add(btnNewButton);

        btnNewButton_1 = new JButton("GOGOGOGOGOGOGOGO");
        btnNewButton_1.addActionListener(this);
        btnNewButton_1.setBounds(10, 152, 640, 78);
        contentPane.add(btnNewButton_1);

        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setBounds(10, 236, 640, 14);
        contentPane.add(progressBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//      switch (String.valueOf(sprache.getSelectedItem())) {
//      case "English":
//      }           
        if (e.getSource() == btnNewButton) {
            chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("choosertitle");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            //
            // disable the "All files" option.
            //
            chooser.setAcceptAllFileFilterUsed(false);
            //
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
                lblInstallLocation.setText(chooser.getSelectedFile().toString());
                // locationField.setColumns(20);
            } else {
                System.out.println("No Selection ");
            }
        } else {
            if (e.getSource() == btnNewButton_1) {
                System.out.println("OK OK OK");
                kopierer = new CopyCat();
                kopierer.faustInTheCraddle(comboBox_1.getSelectedItem().toString(),
                        chooser.getSelectedFile().toString(), comboBox.getSelectedItem().toString(), this);
                CdDriveFixer fixer = new CdDriveFixer();
                try {
                    fixer.fix(comboBox_1.getSelectedItem().toString(), chooser.getSelectedFile().toString(), comboBox.getSelectedItem().toString());
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
    }

    public static void fill() {
        progressBar.setValue(progressBar.getValue() + 1);
        System.out.println(progressBar.getValue());

    }
    
    public void setProgresstext(String text) {
        int percent = (progressBar.getValue()/progressBar.getMaximum());
        progressBar.setString(percent + "% " + text);
    }
}
