import java.awt.*;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;

import java.io.*;
import java.util.*;

public class HomeScreen extends Screen{
    private TextArea textArea;
    private JScrollPane scroll;
    private JLabel labelTextArea;
    private JLabel labelFileSelector;
    private JLabel labelFileSave;
    private JLabel labelTitle;
    private FileSelector fileSelector;
    private FileSelector fileSave;
    private JButton buttonCreateMusic;
    private JButton buttonSaveMusic;

    public HomeScreen(){
        super("Tela Inicial");
        
        createComponents();
        configComponents();
        addComponents();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createComponents(){
        setTextArea(new TextArea());
        setScroll(new JScrollPane(textArea));
        setLabelTextArea(new JLabel("- Digite uma Música -"));       
        setLabelFileSelector(new JLabel("- Escolha um Arquivo -"));   
        setLabelFileSave(new JLabel("- Salvar em MIDI -"));       
        setLabelTitle(new JLabel("- Gerador Musical -"));          
        setFileSelector(new FileSelector(505, textArea));        
        setFileSave(new FileSelector(425));            
        setButtonCreateMusic(new JButton("Reproduzir"));   
        setButtonSaveMusic(new JButton("Salvar"));     
    }

    private void configComponents(){
        labelTitle.setBounds(175, 0, 400, 50);
        labelTitle.setFont(new Font(null, Font.BOLD, 25));

        //---------------------------------------------------------

        // Configurações da Label TEXTAREA
        labelTextArea.setBounds(10, 30, 200, 50);
        labelTextArea.setFont(new Font(null, Font.BOLD, 15));
        
        // Seta tamanho do scroll que envolve a textbox, e consequentemente o tamanho da textbox
        scroll.setBounds(10, 80, 565, 100);
        scroll.setBorder(new LineBorder(Color.BLACK,0));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        //---------------------------------------------------------

        labelFileSelector.setBounds(10, 180, 200, 50);
        labelFileSelector.setFont(new Font(null, Font.BOLD, 15));

        fileSelector.setBounds(10, 230, 565, 40);

        //---------------------------------------------------------

        labelFileSave.setBounds(10, 270, 200, 50);
        labelFileSave.setFont(new Font(null, Font.BOLD, 15));

        fileSave.setBounds(10, 320, 565, 40);

        buttonSaveMusic.setBounds(495, 320, 80, 40);
        buttonSaveMusic.setBackground(new Color(216, 225, 240));
        buttonSaveMusic.setFont(new Font(null, Font.BOLD, 12));
        buttonSaveMusic.setBorder(new LineBorder(new Color(216, 225, 240),0));
        buttonSaveMusic.addActionListener(event -> eventFileSave(event));

        //---------------------------------------------------------

        buttonCreateMusic.setBounds(180, 380, 200, 50);
        buttonCreateMusic.setBackground(new Color(216, 225, 240));
        buttonCreateMusic.setFont(new Font(null, Font.BOLD, 18));
        buttonCreateMusic.setBorder(new LineBorder(new Color(216, 225, 240),0));

        buttonCreateMusic.addActionListener(event -> eventPlayMusic());
    }

    private void addComponents(){
        add(labelTitle);

        add(labelTextArea);         // Label do TextArea
        add(scroll);                // Scroll contendo textArea
        
        add(labelFileSelector);     // Label do seletor
        add(fileSelector);          // Seletor de Arquivos

        add(buttonSaveMusic);       // Botão para salvamento do arquivo
        add(labelFileSave);         // Botão de Reprodução
        add(fileSave);              // Campo de escolha de arquivo para salvamento

        add(buttonCreateMusic);     // Botão de Reprodução
    }

    private void eventFileSave(ActionEvent e){
        String filePath = fileSave.getFieldFile().getText();

        if(filePath.length() == 0){
            UserAlert userAlert = new UserAlert("Você não selecionou um destino!");
        }else{
            try {
                File fileSaveCreate = new File(filePath);
                System.out.println(getExtension(filePath));

                if(getExtension(filePath).equals(Optional.of("midi"))){
                    if (fileSaveCreate.createNewFile()) {
                        try {
                            Player player = new Player();
                            Pattern pattern = new Pattern(fileSave.getFileContent());

                            player.saveMidi(pattern, filePath);
                            UserAlert userAlert = new UserAlert("Arquivo Salvo com sucesso"); 
                          } catch (IOException ex) {
                            UserAlert userAlert = new UserAlert("ERRO - Erro ao criar arquivo"); 
                          }
                    } else {
                        UserAlert userAlert = new UserAlert("O arquivo selecionado já existe!"); 
                    }
                }else{
                    UserAlert userAlert = new UserAlert("O arquivo deve ser do tipo MIDI"); 
                }
              } catch (IOException ex) {
                UserAlert userAlert = new UserAlert("ERRO - Erro ao criar arquivo"); 
              }
        }
    }

    private void eventPlayMusic(){
        if(!screenAlreadyExists("Reprodução")){
            PlayScreen playScreen = new PlayScreen(textArea.getText());
        }
    }

    // !!! DEVE SER MUDADA PARA CLASSE A PARTE 
    private Optional<String> getExtension(String filename) {
        return Optional.ofNullable(filename)
          .filter(f -> f.contains("."))
          .map(f -> f.substring(filename.lastIndexOf(".") + 1));
        }

    public TextArea getTextArea() {
        return textArea;
    }
    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }


    public JScrollPane getScroll() {
        return scroll;
    }
    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }


    public JLabel getLabelTextArea() {
        return labelTextArea;
    }
    public void setLabelTextArea(JLabel labelTextArea) {
        this.labelTextArea = labelTextArea;
    }


    public JLabel getLabelFileSelector() {
        return labelFileSelector;
    }
    public void setLabelFileSelector(JLabel labelFileSelector) {
        this.labelFileSelector = labelFileSelector;
    }


    public JLabel getLabelFileSave() {
        return labelFileSave;
    }
    public void setLabelFileSave(JLabel labelFileSave) {
        this.labelFileSave = labelFileSave;
    }


    public JLabel getLabelTitle() {
        return labelTitle;
    }
    public void setLabelTitle(JLabel labelTitle) {
        this.labelTitle = labelTitle;
    }


    public FileSelector getFileSelector() {
        return fileSelector;
    }
    public void setFileSelector(FileSelector fileSelector) {
        this.fileSelector = fileSelector;
    }


    public FileSelector getFileSave() {
        return fileSave;
    }
    public void setFileSave(FileSelector fileSave) {
        this.fileSave = fileSave;
    }


    public JButton getButtonCreateMusic() {
        return buttonCreateMusic;
    }
    public void setButtonCreateMusic(JButton buttonCreateMusic) {
        this.buttonCreateMusic = buttonCreateMusic;
    }
    

    public JButton getButtonSaveMusic() {
        return buttonSaveMusic;
    }
    public void setButtonSaveMusic(JButton buttonSaveMusic) {
        this.buttonSaveMusic = buttonSaveMusic;
    }

    
}
