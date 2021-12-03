package me.brianerlich.discordbot.Audio;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.youtube.YoutubeAudioSourceManager;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import org.javacord.api.DiscordApi;
import org.javacord.api.audio.AudioSource;

import java.util.ArrayList;

public class Playlist{
        ArrayList<Song> queue = new ArrayList<>();
        ArrayList<AudioTrack> queueTracks = new ArrayList<>();
        int CurrentTrack = 0;

        AudioSource PlaylistPlayer;
        AudioPlayer player;
        AudioPlayerManager playerManager;
    public Playlist(DiscordApi botApi) {
        playerManager = new DefaultAudioPlayerManager();
        playerManager.registerSourceManager(new YoutubeAudioSourceManager());
        player = playerManager.createPlayer();
        PlaylistPlayer = new LavaPlayerSource(botApi, player);

    }



    protected void PlayPauseSong(){
    player.setPaused(!player.isPaused());
    }

    protected void Skip() {
        try {
            player.playTrack(queueTracks.get(CurrentTrack + 1));
        } catch (Exception e) {// catch ArrayIndexOutOfBounds error, or whatever it's called for ArrayLists

        }
    }

    protected void ReorderQueue(int OldPos, int NewPos){

    }
    protected void AddToQueue(String URL){
        playerManager.loadItem(URL, new AudioLoadResultHandler() {
            @Override
            public void trackLoaded(AudioTrack track) {
                player.playTrack(track);
            }

            @Override
            public void playlistLoaded(AudioPlaylist playlist) {
                for(AudioTrack track : playlist.getTracks()){
                    player.playTrack(track);
                }
            }

            @Override
            public void noMatches() {
                System.out.println("No song found");
            }

            @Override
            public void loadFailed(FriendlyException exception) {
                System.out.println("Error lol");
            }
        });


    }
    protected void RemoveFromQueue(int Pos){

    }
    protected Song GetCurrentSong(){
        return null;
    }
}
