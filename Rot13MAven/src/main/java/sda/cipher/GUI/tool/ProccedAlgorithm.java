package sda.cipher.GUI.tool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;

public class ProccedAlgorithm implements ActionListener {
    private JTextField input;
    private JTextField output;
    private JComboBox cipher;
    private JRadioButton encode;
    private  JTextArea log;


    public ProccedAlgorithm(JTextField input, JTextField output, JComboBox ciphers, boolean encode, JTextArea log) {


        this.encode = encode;
        this.log = log;
        this.input = input;
        this.output = output;
        this.cipher = ciphers;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File inFile = Path.of(input.getText()).toFile();
        File outFile = Path.of(output.getText()).toFile();
        log.append("Algo: " + cipher.getSelectedItem() + " encode: " + encode.isSelected() + "\n");
        log.append("In: " + inFile.getName() + " out: " + outFile.getName() + "\n");
        log.append(this.toString() + "\n");
        try (final BufferedReader fileReader = new BufferedReader(new FileReader(inFile))) {
            final String line = fileReader.readLine();
            log.append("Input " + line + "\n");
        } catch (IOException ex) {
            log.append(ex + "ERROR\n");
        }
    }
}

