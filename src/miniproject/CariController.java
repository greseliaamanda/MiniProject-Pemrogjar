package miniproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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

        this.view.getBtnCari().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(DESTINATION_FILE == null){
                    JOptionPane.showMessageDialog(null, "Masukkan File Terlebih Dahulu!", "Informasi Kelas IP", JOptionPane.ERROR_MESSAGE);
                } else {
                    searchWord();
                }
                
            }
        });
    }

    List<String> nameList;
    File DESTINATION_FILE;

    public void getNameList() {
        JFileChooser loadFile = view.getLoadFile();
        if (JFileChooser.OPEN_DIALOG == loadFile.showOpenDialog(view)) {
            try {
                DESTINATION_FILE = loadFile.getSelectedFile();
                Scanner sc = new Scanner(DESTINATION_FILE);
                nameList = new ArrayList<>();
                while (sc.hasNext()) {
                    nameList.add(sc.nextLine());
                }
//                getCurrentReadingFileName(DESTINATION_FILE);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CariController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CariController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void searchWord() {
        String word = view.getTxtCari().getText();

        try {
            BufferedReader Buffer = new BufferedReader(new FileReader(DESTINATION_FILE));
            String line = null;
            int lines = 1;
            boolean thereis = false;
            while ((line = Buffer.readLine()) != null) {
                String arr[] = line.split(" ");
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].trim().equals(word)) {
                        thereis = true;
                        JOptionPane.showMessageDialog(null, word + " berada pada baris ke- " + lines, "Informasi Kelas IP", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                lines++;
            }
            if(thereis == false){
                JOptionPane.showMessageDialog(null, "Kata yang dicari tidak ditemukan", "Informasi Kelas IP", JOptionPane.ERROR_MESSAGE);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CariController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CariController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
