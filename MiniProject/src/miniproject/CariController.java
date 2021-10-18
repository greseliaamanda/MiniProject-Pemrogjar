package miniproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class CariController {
    private Cari view;

    public CariController(Cari view) {
        this.view = view;
        
        this.view.getBtnBaca().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getNameList();
            }
        });
    }
    
    List<String> nameList;
    File DESTINATION_FILE;
    
    public void getNameList(){
        JFileChooser loadFile = view.getLoadFile();
        if(JFileChooser.OPEN_DIALOG == loadFile.showOpenDialog(view)){
            try {
                DESTINATION_FILE = loadFile.getSelectedFile();
                Scanner sc = new Scanner(DESTINATION_FILE);
                nameList = new ArrayList<>();
                while (sc.hasNext()) {
                    nameList.add(sc.nextLine());
                }
//                getCurrentReadingFileName(DESTINATION_FILE);
            }catch (FileNotFoundException ex) {
                Logger.getLogger(CariController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CariController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
