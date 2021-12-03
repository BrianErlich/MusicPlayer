package me.brianerlich.discordbot.Commands;

import org.javacord.api.entity.channel.Channel;
import org.javacord.api.entity.channel.ServerVoiceChannel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.user.User;
import java.util.Optional;

public interface ICommand {
    void MessageIn(String SentMSG, User WhoSent, TextChannel ChannelSent, Long ServerID, Optional<ServerVoiceChannel> UserVC);
    String Command();
}
