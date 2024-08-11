package Player;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.midi.Sequence;
import javax.swing.JPanel;

import org.jfugue.player.ManagedPlayer;

public class DurationBar {

    static final int PIXELS_INCREMENT = 1;
    
    int startPixel = 0;
    int endPixel = 0;
    int barWidth = 0;
    int posYOfProgressIndicator;
    int heightOfProgressIndicator;
    int widthOfProgressIndicator;
    ManagedPlayer player;
    JPanel progressIndicator;
    int progress;
    double duration;
    long velocity; // milissegundos por pixel
    boolean paused = false;
    boolean started = false;
    
    public DurationBar(int startPixel, int barWidth, int posYOfProgressIndicator, int widthOfProgressIndicator, int heightOfProgressIndicator,
                        ManagedPlayer player, JPanel progressIndicator, Sequence sequence) {

        setStartPixel(startPixel);
        setBarWidth(barWidth);
        setPosYOfProgressIndicator(posYOfProgressIndicator);
        setHeightOfProgressIndicator(heightOfProgressIndicator);
        setWidthOfProgressIndicator(widthOfProgressIndicator);
        setPlayer(player);
        setProgress(startPixel);
        setProgressIndicator(progressIndicator);
        setDuration( Math.floor( ( ( sequence.getMicrosecondLength() / 1000 ) / getBarWidth() ) * PIXELS_INCREMENT ) );
        setVelocity((long) duration);
        
    }

    public void startBar() {
        if(getVelocity() != 0 && !hasStarted()){
            Timer timer = new Timer();
            TimerTask timertask = new TimerTask() {
                public void run() {
                    if(!paused){
                        if(getProgress() < getEndPixel() - getWidthOfProgressIndicator()){
                            incProgress();
                            updateBar(getProgress());
                        }
                        else{
                            restartBar();
                            timer.cancel();
                        }
                    }
                }
            };

            this.started = true;

            timer.scheduleAtFixedRate(timertask, 0, velocity);
        }
    }

    public ManagedPlayer getPlayer() {
        return player;
    }
    public void setPlayer(ManagedPlayer player) {
        this.player = player;
    }

    public JPanel getProgressIndicator() {
        return progressIndicator;
    }
    public void setProgressIndicator(JPanel progressIndicator) {
        this.progressIndicator = progressIndicator;
    }

    public void updateBar(int actualProgress) {
        this.progressIndicator.setBounds(actualProgress, getPosYOfProgressIndicator(), getWidthOfProgressIndicator(), getHeightOfProgressIndicator());
    }
    public void restartBar() {
        this.started = false;
        setProgress(getStartPixel());
        updateBar(getProgress());
    }

    public int getProgress() {
        return progress;
    }
    public void setProgress(int progress) {
        this.progress = progress;
    }
    public void incProgress() {
        this.progress += PIXELS_INCREMENT;
    }

    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }

    public long getVelocity() {
        return velocity;
    }
    public void setVelocity(long velocity) {
        this.velocity = velocity;
    }

    public boolean isBarPaused() {
        return this.paused;
    }
    public void playBar() {
        this.paused = false;
    }
    public void pauseBar(){
        this.paused = true;
    }

    public boolean hasStarted() {
        return this.started;
    }

    public int getStartPixel() {
        return this.startPixel;
    }
    public void setStartPixel(int startPixel) {
        this.startPixel = startPixel;
        this.endPixel = this.barWidth + startPixel;
    }

    public int getEndPixel() {
        return this.endPixel;
    }

    public int getBarWidth() {
        return this.barWidth;
    }
    public void setBarWidth(int barWidth) {
        this.barWidth = barWidth;
        this.endPixel = barWidth + this.startPixel;
    }

    public int getPosYOfProgressIndicator() {
        return posYOfProgressIndicator;
    }
    public void setPosYOfProgressIndicator(int posYOfProgressIndicator) {
        this.posYOfProgressIndicator = posYOfProgressIndicator;
    }

    public int getHeightOfProgressIndicator() {
        return heightOfProgressIndicator;
    }
    public void setHeightOfProgressIndicator(int heightOfProgressIndicator) {
        this.heightOfProgressIndicator = heightOfProgressIndicator;
    }

    public int getWidthOfProgressIndicator() {
        return widthOfProgressIndicator;
    }
    public void setWidthOfProgressIndicator(int widthOfProgressIndicator) {
        this.widthOfProgressIndicator = widthOfProgressIndicator;
    }

}
