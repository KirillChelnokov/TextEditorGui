package ru.mirea;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.PublicKey;

public class FileOpener implements ActionListener {
    UI calledUI;

    public FileOpener(UI calledUI){
        this.calledUI = calledUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();

        Integer result = fileChooser.showOpenDialog(null);

        //if (result==JFileChooser.APPROVE_OPTION){
        if (result.equals(0)){
            File selectedFile = fileChooser.getSelectedFile();

            try {
                FileReader fileReader = new FileReader(selectedFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

//                        char c = (char)fileReader.read();
//                        while (fileReader.read()!=-1){
//
//                        }

                String readString = "";
                String resultString = "";

                while ((readString=bufferedReader.readLine())!=null){
                    resultString = resultString.concat(readString);
                }

                calledUI.mainTextArea.setText(resultString);

                //} catch (Exception exception){
            } catch (IOException ioException){
                //System.out.println("что-то пошло не так");
                System.out.println("Не удалось открыть файл");
            }

            // FileInputStream и прочие инструменты работы с файлами
        }
    }
}
