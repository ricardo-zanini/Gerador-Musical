package Music;

public class Tempo {
    private static final int DEFAULT_TEMPO = 120; //batidas por minuto
    private static final int MAX_TEMPO = 600;
    private static final int INCREMENT_TEMPO = 80;
    public static final String TEMPO_DEFINITION = "T";

    private int beatsPerMin = DEFAULT_TEMPO;

    public int getTempo() {
        return this.beatsPerMin;
    }

    public void setTempo(int newTempo) {
        this.beatsPerMin = newTempo;
    }

    //Aumenta BPM em conforme a constante INCREMENT_TEMPO, sem passar do limite máximo
    public void incTempo() {
        if(this.beatsPerMin + INCREMENT_TEMPO > MAX_TEMPO)
        {
            this.beatsPerMin = MAX_TEMPO;
        }
        else{
            this.beatsPerMin += INCREMENT_TEMPO;
        }
    }

    //Randomiza o valor do tempo (batidas por minuto)
    public void randomTempo() {
        this.beatsPerMin = (int)( Math.random() * (MAX_TEMPO ) ) + 1;
    }
}
