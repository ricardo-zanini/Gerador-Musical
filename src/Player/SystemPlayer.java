package Player;
import java.util.Arrays;

import javax.sound.midi.Sequence;

import org.jfugue.midi.MidiParserListener;
import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;
import org.staccato.StaccatoParser;

import Music.Instrument;
import Music.MusicNotes;
import Music.Octave;
import Music.Tempo;
import Music.Volume;

public class SystemPlayer extends Player{
    
    private MusicNotes musicNotes = new MusicNotes();
    
    public SystemPlayer(String musicText){
  
        musicNotes.setMusicNotes(musicText);

        // play(this.musicNotes.getMusicNotes());

    }

    public Sequence getMIDI() {
        return this.musicNotes.getMusicNotes();
    }
    
}
