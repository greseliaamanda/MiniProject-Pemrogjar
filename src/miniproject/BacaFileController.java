package miniproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class BacaFileController {

    private BacaFile view;

    public BacaFileController(BacaFile view) {
        this.view = view;
        
        this.view.getBtnBaca().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proses();
            }
        });
    }
    
    private void proses() {
        JFileChooser loadFile = view.getLoadFile();
        StyledDocument doc = view.getTxtHasil().getStyledDocument();
        if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(view)) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(loadFile.getSelectedFile()));
                String data = null;
                doc.insertString(0, "", null);
                while ((data = reader.readLine()) != null) {
                    doc.insertString(doc.getLength(), data, null);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BacaFileController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | BadLocationException ex) {
                Logger.getLogger(BacaFileController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException ex) {
                        Logger.getLogger(BacaFileController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
