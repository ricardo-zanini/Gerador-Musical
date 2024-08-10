package Music;

public class Octave {
    private static final int DEFAULT_OCTAVE = 5;
    private static final int MIN_OCTAVE = 0;
    private static final int MAX_OCTAVE = 10;

    private int number = DEFAULT_OCTAVE;

    public int getOctave() {
        return this.number;
    }

    public void setOctave(int newOctave) {
        this.number = newOctave;
    }

    //Aumenta uma oitava em relação à atual
    public void incOctave() {
        if(this.number + 1 > MAX_OCTAVE)
        {
            this.number = MIN_OCTAVE;
        }
        else{
            this.number++;
        }
    }

    //Diminui uma oitava em relação à atual
    public void decOctave() {
        if(this.number - 1 < MIN_OCTAVE)
        {
            this.number = MAX_OCTAVE;
        }
        else{
            this.number--;
        }
    }
}
