package sda.cipher.GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public void startGui() {
        JFrame mainFrame = new JFrame("Crypto app");
        mainFrame.setMinimumSize(new Dimension(400, 200));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.add(addMainPanel());
        mainFrame.setVisible(true);
        mainFrame.pack();
    }
    private Component addMainPanel() {
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints constr = new GridBagConstraints();
        //TODO get this value from properties
        JLabel titleLabel = new JLabel("SDA Enigma Machine");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.RED);
        constr.fill = GridBagConstraints.CENTER;
        constr.gridx = 0;
        constr.gridy = 0;
        panel.add(titleLabel, constr);
        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.gridy = 1;
        panel.add(addSubPanelWithControllers(), constr);
        JButton runAlgorithmBtn = new JButton("Run algorithm");
        constr.gridy = 2;
        constr.ipadx = 2;
        constr.ipady = 2;
        panel.add(runAlgorithmBtn, constr);
        JTextArea logArea = new JTextArea(8, 10);
        constr.gridy = 3;
        panel.add(logArea, constr);
        return panel;
    }
    private Component addSubPanelWithControllers() {
        JPanel subPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        JLabel sourceLabel = new JLabel("Source file:");
        JLabel destinationLabel = new JLabel("Destination:");
        JLabel chooseLabel = new JLabel("Choose cipher");
        JTextField inputField = new JTextField("input.txt", 10);
        JTextField outputField = new JTextField("output.txt", 10);
        JButton choseInput = new JButton("Select");
        JButton choseOutput = new JButton("Select");
        JComboBox ciphersCombo = new JComboBox(new String[]{"Cesar", "ROT-13"});
        JRadioButton encodeRadioBtn = new JRadioButton("Encode");
        encodeRadioBtn.setSelected(true);
        JRadioButton decodeRadioBtn = new JRadioButton("Decode");
        ButtonGroup group = new ButtonGroup();
        group.add(encodeRadioBtn);
        group.add(decodeRadioBtn);
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 0;
        constraints.gridx = 0;
        subPanel.add(sourceLabel, constraints);
        constraints.gridx = 1;
        subPanel.add(inputField, constraints);
        constraints.gridx = 2;
        subPanel.add(choseInput, constraints);
        constraints.gridx = 3;
        subPanel.add(chooseLabel, constraints);
        constraints.gridx = 4;
        subPanel.add(encodeRadioBtn, constraints);
        constraints.gridy = 1;
        constraints.gridx = 0;
        subPanel.add(destinationLabel, constraints);
        constraints.gridx = 1;
        subPanel.add(outputField, constraints);
        constraints.gridx = 2;
        subPanel.add(choseOutput, constraints);
        constraints.gridx = 3;
        subPanel.add(ciphersCombo, constraints);
        constraints.gridx = 4;
        subPanel.add(decodeRadioBtn, constraints);
        return subPanel;
    }
}