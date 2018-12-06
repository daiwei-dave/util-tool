package DesignPatterns.CommandPatterns.demo;

/**
 * @author daiwei
 * @date 2018/12/6 16:00
 */
public class StopCommand implements Command {
    private AudioPlayer myAudio;

    public StopCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }
    @Override
    public void execute() {
        myAudio.stop();
    }

}
