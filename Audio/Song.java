package me.brianerlich.discordbot.Audio;
import com.sedmelluq.discord.lavaplayer.track.*;

public class Song {
public String Name;
public String url;
public String Artist;
public int Runtime;

    public Song(String name, String url, String artist, int runtime) {
        Name = name;
        this.url = url;
        Artist = artist;
        Runtime = runtime;
    }
}
