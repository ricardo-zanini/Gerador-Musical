package Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import org.jfugue.player.ManagedPlayer;

public class PlayButton extends JButton implements ActionListener {
    
    Sequence musicSequence;
    ManagedPlayer player;
    DurationBar timer;

    public PlayButton(Sequence sequence, ManagedPlayer player, DurationBar timer) {
        setMusicSequence(sequence);
        setPlayer(player);
        setTimer(timer);
        buttonConfig();
        addActionListener(this);
    }

    public void buttonConfig() {
        setBounds(230, 220, 100, 50);
        setBackground(new Color(216, 225, 240));
        setFont(new Font(null, Font.BOLD, 18));
        setBorder(new LineBorder(new Color(216, 225, 240),0));
        setText("Play ▶");
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this){
            try {
                getTimer().startBar();
                getTimer().playBar();
                player.start(getMusicSequence());
            } catch (InvalidMidiDataException e1) {
                e1.printStackTrace();
            } catch (MidiUnavailableException e1) {
                e1.printStackTrace();
            }
        }
    }

    public Sequence getMusicSequence() {
        return musicSequence;
    }
    public void setMusicSequence(Sequence musicSequence) {
        this.musicSequence = musicSequence;
    }

    public ManagedPlayer getPlayer() {
        return player;
    }
    public void setPlayer(ManagedPlayer player) {
        this.player = player;
    }

    public DurationBar getTimer() {
        return timer;
    }
    public void setTimer(DurationBar timer) {
        this.timer = timer;
    }

}
