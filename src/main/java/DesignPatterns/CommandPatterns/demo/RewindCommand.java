package DesignPatterns.CommandPatterns.demo;

/**
 * @author daiwei
 * @date 2018/12/6 15:59
 */
public class RewindCommand implements Command {

    private AudioPlayer myAudio;

    public RewindCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }
    @Override
    public void execute() {
        myAudio.rewind();
    }

}
