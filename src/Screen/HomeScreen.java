package Screen;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Input.FileSelector;
import Input.TextArea;
import Menu.CommandHelpItem;

import java.util.*;

public class HomeScreen extends Screen{

    private TextArea textArea;
    private JScrollPane scroll;
    private JLabel labelTextArea;
    private JLabel labelFileSelector;
    private JLabel labelTitle;
    private FileSelector fileSelector;
    private JButton buttonCreateMusic;
    private JMenuBar menuBar;
    private JMenu menu;

    public HomeScreen(){
        super("Tela Inicial");
        
        createComponents();
        configComponents();
        addComponents();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createComponents(){

        this.menuBar = new JMenuBar();
        this.menu = new JMenu("Ajuda");

        setTitle("Gerador Musical");
        setTextArea(new TextArea());
        setScroll(new JScrollPane(textArea));
        setLabelTextArea(new JLabel("- Digite uma Música -"));       
        setLabelFileSelector(new JLabel("- Abrir um Arquivo -"));
        setFileSelector(new FileSelector(505, textArea, new FileNameExtensionFilter(".txt", "txt")));         
        setLabelTitle(new JLabel("- Gerador Musical -"));                   
        setButtonCreateMusic(new JButton("Gerar Música"));
    }

    private void configComponents(){
        labelTitle.setBounds(175, 20, 400, 50);
        labelTitle.setFont(new Font(null, Font.BOLD, 25));

        //---------------------------------------------------------

        // Configurações da Label TEXTAREA
        labelTextArea.setBounds(20, 50, 200, 50);
        labelTextArea.setFont(new Font(null, Font.BOLD, 15));
        
        // Seta tamanho do scroll que envolve a textbox, e consequentemente o tamanho da textbox
        scroll.setBounds(20, 100, 545, 150);
        scroll.setBorder(new LineBorder(Color.BLACK,0));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        //---------------------------------------------------------

        labelFileSelector.setBounds(20, 250, 200, 50);
        labelFileSelector.setFont(new Font(null, Font.BOLD, 15));

        fileSelector.setBounds(20, 300, 545, 40);

        //---------------------------------------------------------

        buttonCreateMusic.setBounds(180, 360, 200, 50);
        buttonCreateMusic.setBackground(new Color(216, 225, 240));
        buttonCreateMusic.setFont(new Font(null, Font.BOLD, 18));
        buttonCreateMusic.setBorder(new LineBorder(new Color(216, 225, 240),0));

        buttonCreateMusic.addActionListener(event -> eventPlayMusic(textArea.getText()));
    }

    private void addComponents(){

        this.menu.add(new CommandHelpItem());
        this.menuBar.add(this.menu);
        this.setJMenuBar(this.menuBar);

        add(labelTitle);

        add(labelTextArea);         // Label do TextArea
        add(scroll);                // Scroll contendo textArea
        
        add(labelFileSelector);     // Label do seletor
        add(fileSelector);          // Seletor de Arquivos

        add(buttonCreateMusic);     // Botão de Reprodução
    }

    private void eventPlayMusic(String text){
        if(!screenAlreadyExists("Reprodução") && text.length() > 0){
            PlayScreen playScreen = new PlayScreen(text);
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


    public JButton getButtonCreateMusic() {
        return buttonCreateMusic;
    }
    public void setButtonCreateMusic(JButton buttonCreateMusic) {
        this.buttonCreateMusic = buttonCreateMusic;
    }

    
}
