import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;

public class SystemPlayer extends Player{

    public String musicNotes;
    
    public SystemPlayer(String musicText){
  
        setMusicNotes(musicText);
        play(this.musicNotes);

        // Rhythm rhythm = new Rhythm()
        // .addLayer("OoOoOOOOOO..oO...O..oOO..")
        // .addLayer("......S...S...S.")
        // .addLayer("````````````````")
        // .addLayer("...............+++++");
        // new Player().play(rhythm.getPattern().repeat(2));

    }
    public String getMusicNotes() {
        return musicNotes;
    }

    public void setMusicNotes(String musicNotes) {
        this.musicNotes = musicNotes;
    }
    
}
