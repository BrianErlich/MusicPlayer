package me.brianerlich.discordbot.Audio;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame;
import org.javacord.api.DiscordApi;
import org.javacord.api.audio.AudioSource;
import org.javacord.api.audio.AudioSourceBase;
public class LavaPlayerSource extends AudioSourceBase{
    public final AudioPlayer audioPlayer;
    private AudioFrame lastFrame;
    public LavaPlayerSource(DiscordApi api, AudioPlayer audioPlayer) {
        super(api);
        this.audioPlayer = audioPlayer;
    }

    public byte[] getNextFrame() {
        if (lastFrame == null) {
            return null;
        }
        return applyTransformers(lastFrame.getData());
    }

    public boolean hasNextFrame() {
        lastFrame = audioPlayer.provide();
        return lastFrame != null;
    }

    public AudioSource copy() {
        return new LavaPlayerSource(getApi(), audioPlayer);
    }
}
