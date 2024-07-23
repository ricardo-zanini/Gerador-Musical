import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;

public class SystemPlayer extends Player{

    public String musicNotes;
    
    public SystemPlayer(String musicText){
  
        setMusicNotes(musicText);

         // !!!!!!!!!!!!!! TRABALAR NESSA PARTE !!!!!!!!!!!!!!

        play(this.musicNotes);

    }
    public String getMusicNotes() {
        return musicNotes;
    }

    public void setMusicNotes(String musicNotes) {
        this.musicNotes = musicNotes;
    }
    
}
