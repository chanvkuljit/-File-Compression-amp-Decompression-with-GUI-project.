package com.example.filecompressor;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileCompressorController {
    @FXML
    private Label infoText;
    @FXML
    private TextField openFilePathField;
    @FXML
    private TextField saveFilePathField;

    @FXML
    protected void onOpenFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open a file");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")+ "/Desktop"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text File","*.txt"), new FileChooser.ExtensionFilter("All Text Files","*.txt","*.md"));

        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if(selectedFile != null){
            System.out.println(selectedFile.getPath());
            openFilePathField.setText(selectedFile.getPath());
        }else{
            System.out.println("No file has been selected");
            infoText.setText("No file has been selected");
        }
    }

    @FXML
    protected void onSaveFileBtn() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")+ "/Desktop"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text File","*.txt"), new FileChooser.ExtensionFilter("All Text Files","*.txt","*.md"));
        fileChooser.setInitialFileName("default.txt");
        File selectedFile = fileChooser.showSaveDialog(new Stage());
        if(selectedFile != null){
            System.out.println(selectedFile.getPath());
            saveFilePathField.setText(selectedFile.getPath());
        }else{
            System.out.println("No file has been selected");
            infoText.setText("No file has been selected");
        }
    }

    @FXML
    protected void onCompress() throws Exception {

        System.out.println(openFilePathField.getText());
        if (openFilePathField.getText().equals("")){
            infoText.setText("Please Select a Source File");
            return;
        }
        if (saveFilePathField.getText().equals("")){
            infoText.setText("Please Select a Destination File");
            return;
        }
        boolean success = false;
        System.out.println("Compressed");
        CHuffmanEncoder he = new CHuffmanEncoder(openFilePathField.getText(),saveFilePathField.getText());
        success = he.encodeFile();
        System.out.println(success);
        infoText.setText("Your File is Compress Successfully");
        openFilePathField.clear();
        saveFilePathField.clear();

    }
    @FXML
    protected void onDecompress() throws Exception {
        if (openFilePathField.getText().equals("")){
            infoText.setText("Please Select a Source File");
            return;
        }
        if (saveFilePathField.getText().equals("")){
            infoText.setText("Please Select a Destination File");
            return;
        }
        boolean success = false;
        System.out.println("Decompressed");
        CHuffmanDecoder he = new CHuffmanDecoder(openFilePathField.getText(),saveFilePathField.getText());
        success = he.decodeFile();
        System.out.println(success);
        infoText.setText("Your File is Decompress Successfully");
        openFilePathField.clear();
        saveFilePathField.clear();
    }

    @FXML
    protected void getSrcFilePath(){
        String src = openFilePathField.getText();
        openFilePathField.setText(src);
        System.out.println(src);
    }
}