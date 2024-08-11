package Music;

import java.util.Arrays;

import javax.sound.midi.Sequence;

import org.jfugue.midi.MidiParserListener;
import org.staccato.StaccatoParser;

public class MusicNotes {

    private Sequence musicSequence;
    private Instrument instrument = new Instrument();
    private Volume volume = new Volume();
    private Octave octave = new Octave();
    private Tempo tempo = new Tempo();

    private static final String NOTES[] = {"A","a","B","b","C","c","D","d","E","e","F","f","G","g"};
    private static final String OTHER_VOWELS[] = {"I","i","O","o","U","u"};
    private static final String PAUSE_DEFINITION = "R";

    public Sequence getMusicNotes() {
        return this.musicSequence;
    }

    //gera uma nota aleatoria
    public String getRandomNote() {
        return NOTES[(int)(Math.random() * NOTES.length)];
    }

    public void setMusicNotes(String musicText) {

        //inicializa a musica com o volume default
        String newMusicNotes = volume.formatVolume();

        //Altera os caracteres especias do texto do último ao primeiro conforme suas operações
        for (int i = 0; i < musicText.length(); i++) {
            
            //salva o caractere atual
            String c = Character.toString(musicText.charAt(i));
            String cLast = "";

            //guarda o caractere anterior
            if(i > 0) {
                cLast = Character.toString(musicText.charAt(i-1));
            }

            //verifica se caractere = B e se há mais três caracteres depois dele
            if(c.equals("B") && i+3 < musicText.length()){

                //verifica se os próximos caracteres são = PM+
                if(Character.toString(musicText.charAt(i+1)).equals("P")
                    && Character.toString(musicText.charAt(i+2)).equals("M")
                    && Character.toString(musicText.charAt(i+3)).equals("+"))
                {
                    tempo.incTempo();
                    i += 3; //pula os próximos caracteres
                    newMusicNotes += " " + tempo.TEMPO_DEFINITION + tempo.getTempo();
                }

                //se não, verifica se B é uma nota musical
                else if(Arrays.asList(NOTES).contains(c))
                {
                    newMusicNotes += " " + c + octave.getOctave();
                }

            }

            //verifica se o caractere é uma nota musical
            else if (Arrays.asList(NOTES).contains(c))
            {
                newMusicNotes += " " + c + octave.getOctave();
            }

            //verifica se o caractere é uma vogal que não é nota musical
            else if (Arrays.asList(OTHER_VOWELS).contains(c)){

                //verifica se o caractere anterior ao atual no texto é uma nota musical 
                if (Arrays.asList(NOTES).contains(cLast)){

                    //se sim, repete a nota musical
                    newMusicNotes += " " + cLast + octave.getOctave();

                }
                else{

                    //se não, gera o som de telefone tocando (com uma nota aleatoria) e depois volta para o instrumento anterior
                    newMusicNotes += " " + instrument.INSTRUMENT_DEFINITION + instrument.TELEPHONE_RING
                        + " " + getRandomNote() + octave.getOctave()
                        + " " + instrument.INSTRUMENT_DEFINITION + instrument.getInstrument();

                }

            }

            //verifica se o caractere = space
            else if(c.equals(" ")){

                //gera uma pausa/silencio
                newMusicNotes += " " + PAUSE_DEFINITION;

            }

            //verifica se o caractere = ?
            else if(c.equals("?")){
                newMusicNotes += " " + getRandomNote() + octave.getOctave();
            }

            //verifica se o caractere = nova linha
            else if(c.equals("\n")){
                instrument.randomInstrument();
                newMusicNotes += " " + instrument.INSTRUMENT_DEFINITION + instrument.getInstrument();
            }

            //verifica se o caractere = +
            else if(c.equals("+")){
                volume.doubleVolume();
                newMusicNotes += " " + volume.formatVolume();
            }

            //verifica se o caractere = -
            else if(c.equals("-")){
                volume.setVolumeToDefault();
                newMusicNotes += " " + volume.formatVolume();
            }

            //verifica se caractere = R e se há mais um caractere depois deste
            else if(c.equals("R") && i+1 < musicText.length()){

                //verifica se o próximo caractere = +
                if(Character.toString(musicText.charAt(i+1)).equals("+"))
                {
                    octave.incOctave();
                    i++;
                }
                else if(Character.toString(musicText.charAt(i+1)).equals("-"))
                {
                    octave.decOctave();
                    i++;
                }

            }

            //verifica se o caractere = ;
            else if(c.equals(";")){
                tempo.randomTempo();
                newMusicNotes += " " + tempo.TEMPO_DEFINITION + tempo.getTempo();
            }

        }

        //mostra no terminal o midi gerado
        System.out.println(newMusicNotes);

        //converte o texto midi para uma sequencia midi
        StaccatoParser staccatoParser = new StaccatoParser();
        MidiParserListener midiParserListener= new MidiParserListener();
        staccatoParser.addParserListener(midiParserListener);
        staccatoParser.parse(newMusicNotes);

        this.musicSequence = midiParserListener.getSequence();
    }

}
