package Music;

public class Volume {

    private static final int DEFAULT_VOLUME = 8000;
    private static final int MIN_VOLUME = 0;
    private static final int MAX_VOLUME = 16383;
    private static final int COD_VOLUME = 935;

    private int value = DEFAULT_VOLUME;

    public int getVolume() {
        return this.value;
    }

    public void setVolume(int newVolume) {
        this.value = newVolume;
    }

    //aumenta o volume para o dobro do atual
    public void doubleVolume() {
        if(this.value*2 > MAX_VOLUME){
            this.value = DEFAULT_VOLUME;
        }
        else{
            this.value *= 2;
        }
    }

    //volume volta para o valor default
    public void setVolumeToDefault() {
        this.value = DEFAULT_VOLUME;
    }

    //retorna o volume formatado para uso na sequencia musical
    public String formatVolume() {
        return " :CE("+ COD_VOLUME + "," + this.value + ") ";
    }

}
