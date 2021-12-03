package me.brianerlich.discordbot.Bot;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import me.brianerlich.discordbot.Audio.AudioServer;
import me.brianerlich.discordbot.Audio.Playlist;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;
import org.javacord.api.entity.server.*;

import java.util.HashMap;

public class Bot{
    private static String BotToken = "OTE0MzY3MjE0MjQzNjc2MTky.YaMA0w.Tco2-q29R-qf4rFCY5A6rvzXnOU";
    public static final char Prefix = '.';
    public static HashMap<Long, Playlist> Playlists = new HashMap<>();
    public static HashMap<Long, AudioServer> AudioServers = new HashMap<>();
    public static void main(String[] args) throws Exception {
        DiscordApi botApi = new DiscordApiBuilder().setToken(BotToken)
                .login()
                .join();
        botApi.addMessageCreateListener(MessageHandler::MessageIn);
        startup(botApi);

    }
    public static void startup(DiscordApi botApi){
        for (Server s: botApi.getServers().toArray(new Server[botApi.getServers().size()])){
            Playlists.put(s.getId(), new Playlist(botApi));
            AudioServers.put(s.getId(), new AudioServer(botApi, s.getId()));

        }
    }
}
