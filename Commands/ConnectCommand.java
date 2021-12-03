package me.brianerlich.discordbot.Commands;

import me.brianerlich.discordbot.Audio.AudioServer;
import org.javacord.api.entity.channel.ServerVoiceChannel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.user.User;
import me.brianerlich.discordbot.Bot.Bot;

import java.util.Optional;

public class ConnectCommand implements ICommand, IPlaylist{
    public void MessageIn(String SentMSG, User WhoSent, TextChannel ChannelSent, Long ServerID, Optional<ServerVoiceChannel> UserVC) {
        Bot.AudioServers.get(ServerID).Connect(UserVC.get());
    }

    public String Command() {
        return "connect"; // What the user would type after the prefix
    }
    public AudioServer getAudioServer(Long ID){
        return Bot.AudioServers.get(ID);
    }
}

