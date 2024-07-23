import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.*;

public class HomeScreen extends Screen{
    private TextArea textArea;
    private JScrollPane scroll;
    private JLabel labelTextArea;
    private JLabel labelFileSelector;
    private JLabel labelFileSave;
    private JLabel labelTitle;
    private FileSelector fileSelector;
    private FileSaver fileSave;
    private JButton buttonCreateMusic;

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
        setFileSelector(new FileSelector(505, textArea, new FileNameExtensionFilter("Arquivos de Texto", "txt")));        
        setFileSave(new FileSaver(425, textArea.getText(), new FileNameExtensionFilter("Arquivos de Música", "midi")));            
        setButtonCreateMusic(new JButton("Reproduzir"));
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

        add(labelFileSave);         // Botão de Reprodução
        add(fileSave);              // Campo de escolha de arquivo para salvamento

        add(buttonCreateMusic);     // Botão de Reprodução
    }

    private void eventPlayMusic(){
        if(!screenAlreadyExists("Reprodução")){
            PlayScreen playScreen = new PlayScreen(textArea.getText());
        }
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


    public FileSaver getFileSave() {
        return fileSave;
    }
    public void setFileSave(FileSaver fileSave) {
        this.fileSave = fileSave;
    }


    public JButton getButtonCreateMusic() {
        return buttonCreateMusic;
    }
    public void setButtonCreateMusic(JButton buttonCreateMusic) {
        this.buttonCreateMusic = buttonCreateMusic;
    }

    
}
