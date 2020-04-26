package tool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class InputManager implements ActionListener {
    private JTextField output;
    private JTextArea log;
    private final String defaultPath = "./ROT13MAven/src/main/resources";

    public InputManager(JTextField jField, JTextArea logArea) {
        output = jField;
        log = logArea;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser(defaultPath);
        final int status = fileChooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {

            //POBIERAMY SCIEZKE PLIKU
            File file = fileChooser.getSelectedFile();
            output.setText(file.getAbsolutePath());
            log.append("Chosen file: " +  file.getName()+"\n");

        } else {
            log.append("Canceled" + "\n");
        }

    }
}
