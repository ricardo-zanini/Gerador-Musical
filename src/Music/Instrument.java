package Music;

public class Instrument {
    
    private static final int DEFAULT_INSTRUMENT = 0;
    private static final int FIRST_INSTRUMENT = 0;
    private static final int LAST_INSTRUMENT = 127;
    public static final int TELEPHONE_RING = 124;
    public static final String INSTRUMENT_DEFINITION = "I";

    private int cod = DEFAULT_INSTRUMENT;

    public int getInstrument() {
        return this.cod;
    }

    public void setInstrument(int newInstrument) {
        this.cod = newInstrument;
    }

    //muda o instrumento por um novo aleatório e diferente
    public void randomInstrument() {
        int newRandomInstrument = (int)( Math.random() * (LAST_INSTRUMENT + 1) );
        while(newRandomInstrument == this.cod)
        {
            newRandomInstrument = (int)( Math.random() * (LAST_INSTRUMENT + 1) );
        }
        this.cod = newRandomInstrument;
    }
}
