package me.brianerlich.discordbot.Bot;

import me.brianerlich.discordbot.Commands.*;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.event.message.MessageEvent;

import java.util.ArrayList;
import java.util.Locale;

public class MessageHandler{
    static final ArrayList<ICommand> RegisteredCommands = new ArrayList<>();
    static{
        RegisteredCommands.add(new PauseCommand());
        RegisteredCommands.add(new PlayCommand());
        RegisteredCommands.add(new RemoveFromQueueCommand());
        RegisteredCommands.add(new ReorderQueueCommand());
        RegisteredCommands.add(new SeekCommand());
        RegisteredCommands.add(new SkipCommand());
        RegisteredCommands.add(new UnpauseCommand());

    }

    public static void MessageIn(MessageCreateEvent e) {
        if(!e.getMessage().getAuthor().isBotUser()){
            for(ICommand i : RegisteredCommands){
                String Command = Bot.Prefix +i.Command();
                if(e.getMessageContent().toLowerCase().startsWith(Command)) {
                    i.MessageIn(e.getMessageContent().substring(Command.length()), e.getMessageAuthor().asUser().get(), e.getChannel(), e.getServer().get().getId(), e.getMessageAuthor().getConnectedVoiceChannel());
                }
            }
        }
    }
}
