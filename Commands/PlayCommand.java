package me.brianerlich.discordbot.Commands;

import me.brianerlich.discordbot.Audio.AudioServer;
import me.brianerlich.discordbot.Audio.Song;
import me.brianerlich.discordbot.Bot.Bot;
import org.javacord.api.entity.channel.ServerVoiceChannel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.user.User;

import java.util.Locale;
import java.util.Optional;

public class PlayCommand implements ICommand, IPlaylist{

    public void MessageIn(String SentMSG, User WhoSent, TextChannel ChannelSent, Long ServerID, Optional<ServerVoiceChannel> UserVC) {
         String[] words = SentMSG.split("\\s");
        for(int i = 0; i < words.length; i++){
            if(words[i].toLowerCase().startsWith("youtube.com/watch?v="))
                getAudioServer(ServerID).AddToQueue(words[i].toLowerCase());

        }

        }


    public String Command() {
        return "play";
    }

    public AudioServer getAudioServer(Long ID){
        return Bot.AudioServers.get(ID);
    }
}
