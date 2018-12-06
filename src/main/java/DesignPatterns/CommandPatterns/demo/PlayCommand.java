package DesignPatterns.CommandPatterns.demo;

/**
 * @author daiwei
 * @date 2018/12/6 15:58
 */
public class PlayCommand implements Command{
    private AudioPlayer myAudio;

    public PlayCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }


    @Override
    public void execute() {
        myAudio.play();
    }
}
