package me.brianerlich.discordbot.Audio;
import me.brianerlich.discordbot.Bot.Bot;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.ServerVoiceChannel;
import org.javacord.api.entity.server.Server;
import me.brianerlich.discordbot.Audio.Playlist;

public class AudioServer {
    private Server Server;
    private Playlist playlist;
    public AudioServer(DiscordApi botApi, long ID){
        Server = botApi.getServerById(ID).get();
        playlist = Bot.Playlists.get(ID);
    }
    public void Connect(ServerVoiceChannel c){
        c.connect().thenAccept(audioConnection -> {
            audioConnection.setAudioSource(playlist.PlaylistPlayer);
        }).exceptionally(e -> {
            // Failed to connect to voice channel (no permissions?)
            e.printStackTrace();
            return null;
        });

    }
    public void PlayPause() {
        playlist.PlayPauseSong();
    }
    public void ReorderQueue(int OldPos, int NewPos){
        playlist.ReorderQueue(OldPos, NewPos);
    }
    public void AddToQueue(String URL){
        playlist.AddToQueue(URL);
    }

}
