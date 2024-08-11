package Input;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Alert.UserAlert;

public class FileSelector extends JPanel{

    private JButton         buttonFile;
    private JTextField      fieldFile;
    private JFileChooser    windowFile;
    private String          fileContent;
    private File            file;

    // Campo com tamanho, campo textarea q recebe conteudo do arquvo, e filtro
    public FileSelector(int textFieldWidth, TextArea textArea, FileNameExtensionFilter filter){
        initializeFileSelector(textFieldWidth, filter);

        buttonFile.addActionListener(event -> selectFile(event, textArea));
    }

    // Campo com tamanho e filtro
    public FileSelector(int textFieldWidth, FileNameExtensionFilter filter){
        initializeFileSelector(textFieldWidth, filter);

        buttonFile.addActionListener(event -> selectFile(event, null));
    }

    // Campo com tamanho, campo textarea q recebe conteudo do arquvo
    public FileSelector(int textFieldWidth, TextArea textArea){
        initializeFileSelector(textFieldWidth, null);

        buttonFile.addActionListener(event -> selectFile(event, textArea));
    }

    // Campo com tamanho
    public FileSelector(int textFieldWidth){
        initializeFileSelector(textFieldWidth, null);

        buttonFile.addActionListener(event -> selectFile(event, null));
    }


    private void initializeFileSelector (int textFieldWidth, FileNameExtensionFilter filter){
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        ImageIcon imageIcon = new ImageIcon("img/fileIcon.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  

        setButtonFile(new JButton("", new ImageIcon(newimg)));
        setFieldFile(new JTextField());
        
        buttonFile.setBackground(new Color(216, 225, 240));
        buttonFile.setBorder(new LineBorder(new Color(216, 225, 240),0));
        buttonFile.setMaximumSize(new Dimension(60, 40));
        buttonFile.setFocusable(false);

        fieldFile.setFont(new Font(null, Font.BOLD, 12));
        fieldFile.setBackground(Color.white);
        fieldFile.setBorder(new LineBorder(Color.white,10));
        fieldFile.setMaximumSize(new Dimension(textFieldWidth, 40));
        fieldFile.setEditable(false);
        fieldFile.setFocusable(false);
        fieldFile.setForeground(new Color(204, 204, 204));

        
        windowFile  = new JFileChooser();
        windowFile.setVisible(false);
        
        windowFile.setAcceptAllFileFilterUsed(false);
        
        if(filter != null){
            windowFile.addChoosableFileFilter(filter);
        }
        
        add(buttonFile,  BorderLayout.WEST);
        add(fieldFile,  BorderLayout.EAST);
        add(windowFile);
    }

    private void selectFile(ActionEvent e, TextArea textArea){

        windowFile.setVisible(true);
        int windowState = windowFile.showOpenDialog(null);

        if (windowState == JFileChooser.APPROVE_OPTION){
            
            // Só executa essa parte se for passado o textArea de destino como parâmetro
            if(textArea != null){
                List<String> fileLines = new ArrayList<String>();
                setFile(windowFile.getSelectedFile());
                try (BufferedReader br = new BufferedReader(new FileReader(windowFile.getSelectedFile()))) {
                    fieldFile.setText(windowFile.getSelectedFile().getPath());
                    String line;
                    while ((line = br.readLine()) != null) {
                        fileLines.add(line);
                    }
                    setFileContent("");
                    for(int i = 0; i < fileLines.size(); i++){
                        setFileContent(getFileContent() + fileLines.get(i)) ;
                    }
                    textArea.setText(getFileContent());

                } catch (IOException exception) {
                    UserAlert userAlert = new UserAlert("ERRO - Erro na abertura de Arquivo!");
                }
            }else{
                // Imprime no field relacionado ao seletor o caminho do arquivo selecionado
                fieldFile.setText(windowFile.getSelectedFile().getPath());
            }
        }
    }

    public JButton getButtonFile() {
        return buttonFile;
    }
    public void setButtonFile(JButton buttonFile) {
        this.buttonFile = buttonFile;
    }


    public JTextField getFieldFile() {
        return fieldFile;
    }
    public void setFieldFile(JTextField fieldFile) {
        this.fieldFile = fieldFile;
    }


    public JFileChooser getWindowFile() {
        return windowFile;
    }
    public void setWindowFile(JFileChooser windowFile) {
        this.windowFile = windowFile;
    }


    public String getFileContent() {
        return fileContent;
    }
    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }


    public File getFile() {
        return file;
    }
    public void setFile(File file) {
        this.file = file;
    }

}