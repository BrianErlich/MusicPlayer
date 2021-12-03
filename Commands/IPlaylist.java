package me.brianerlich.discordbot.Commands;
import me.brianerlich.discordbot.Bot.Bot;
import me.brianerlich.discordbot.Audio.AudioServer;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.user.User;

public interface IPlaylist {
    AudioServer getAudioServer(Long ID);
}
