package Screen;
import java.awt.*;

import javax.sound.midi.Sequence;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfugue.player.ManagedPlayer;

import Output.FileSaver;
import Player.DurationBar;
import Player.PlayButton;
import Player.SystemPlayer;

public class PlayScreen extends Screen{

    private static final int START_PIXEL_PROGRESS_BAR = 40;
    private static final int WIDTH_PROGRESS_BAR = 500;
    private static final int POS_Y_PROGRESS_INDICATOR = 165;
    private static final int WIDTH_PROGRESS_INDICATOR = 10;
    private static final int HEIGHT_PROGRESS_INDICATOR = 20;


    private JLabel labelFileSave;
    private JLabel labelTitle;
    private JLabel labelPlayer;
    private FileSaver fileSave;
    SystemPlayer playNotes;
    JPanel progressIndicator;
    JPanel progressBar;
    JPanel playerSection;
    ManagedPlayer player;
    Sequence musicSequence;
    PlayButton playButton;


    public PlayScreen(String fileContent){

        super("Reprodução");

        SystemPlayer playNotes = new SystemPlayer(fileContent);
        setMusicSequence(playNotes.getMIDI());


        createComponents(musicSequence);
        configComponents();
        addComponents();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    private void createComponents(Sequence musicSequence){
        setTitle("Reproduzir Música");
        setLabelTitle(new JLabel("- Gerador Musical -"));
        setLabelPlayer(new JLabel("- Reproduzir Música -"));
        setPlayerSection(new JPanel());
        setProgressIndicator(new JPanel());
        setProgressBar(new JPanel());
        setLabelFileSave(new JLabel("- Salvar em MIDI -"));               
        setFileSave(new FileSaver(425, musicSequence, new FileNameExtensionFilter(".midi", "midi")));
        setPlayer(new ManagedPlayer());
        setPlayButton(
            new PlayButton(musicSequence,
            getPlayer(),
            new DurationBar(START_PIXEL_PROGRESS_BAR, WIDTH_PROGRESS_BAR, POS_Y_PROGRESS_INDICATOR, WIDTH_PROGRESS_INDICATOR, HEIGHT_PROGRESS_INDICATOR,
                            player, progressIndicator, musicSequence)));         
    }

    private void configComponents(){

        labelTitle.setBounds(160, 20, 400, 50);
        labelTitle.setFont(new Font(null, Font.BOLD, 25));

        //---------------------------------------------------------

        labelPlayer.setBounds(20, 100, 200, 50);
        labelPlayer.setFont(new Font(null, Font.BOLD, 15));

        playerSection.setBounds(20, 150, 545, 50);
        playerSection.setBackground(Color.white);
        playerSection.setBorder(new LineBorder(new Color(216, 225, 240),0));

        progressIndicator.setBounds(START_PIXEL_PROGRESS_BAR, POS_Y_PROGRESS_INDICATOR, WIDTH_PROGRESS_INDICATOR, HEIGHT_PROGRESS_INDICATOR);
        progressIndicator.setBackground(new Color(132, 149, 179));
        progressIndicator.setBorder(new LineBorder(new Color(216, 225, 240),0));

        progressBar.setBounds(START_PIXEL_PROGRESS_BAR,170,WIDTH_PROGRESS_BAR,10);
        progressBar.setBackground(new Color(216, 225, 240));
        progressBar.setBorder(new LineBorder(new Color(216, 225, 240),0));

        //---------------------------------------------------------

        labelFileSave.setBounds(20, 270, 200, 50);
        labelFileSave.setFont(new Font(null, Font.BOLD, 15));

        fileSave.setBounds(20, 320, 545, 40);

    }

    private void addComponents(){

        add(labelTitle);

        add(labelPlayer);
        add(progressIndicator);      // indicador de progresso da duração da música
        add(progressBar);            // barra de duração da música
        add(playerSection);          // seção de fundo do player

        add(playButton);

        add(labelFileSave);         // Label do salvamento
        add(fileSave);              // Campo de escolha de arquivo para salvamento

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

    public JPanel getProgressIndicator() {
        return progressIndicator;
    }
    public void setProgressIndicator(JPanel progressIndicator) {
        this.progressIndicator = progressIndicator;
    }

    public FileSaver getFileSave() {
        return fileSave;
    }
    public void setFileSave(FileSaver fileSave) {
        this.fileSave = fileSave;
    }

    public ManagedPlayer getPlayer() {
        return player;
    }
    public void setPlayer(ManagedPlayer player) {
        this.player = player;
    }

    public Sequence getMusicSequence() {
        return musicSequence;
    }
    public void setMusicSequence(Sequence musicSequence) {
        this.musicSequence = musicSequence;
    }

    public JPanel getProgressBar() {
        return progressBar;
    }
    public void setProgressBar(JPanel progressBar) {
        this.progressBar = progressBar;
    }

    public JPanel getPlayerSection() {
        return playerSection;
    }
    public void setPlayerSection(JPanel playerSection) {
        this.playerSection = playerSection;
    }

    public PlayButton getPlayButton() {
        return playButton;
    }
    public void setPlayButton(PlayButton playButton) {
        this.playButton = playButton;
    }

    public JLabel getLabelPlayer() {
        return labelPlayer;
    }
    public void setLabelPlayer(JLabel labelPlayer) {
        this.labelPlayer = labelPlayer;
    }

}
