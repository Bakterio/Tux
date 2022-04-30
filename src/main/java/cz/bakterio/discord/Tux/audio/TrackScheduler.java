package cz.bakterio.discord.Tux.audio;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TrackScheduler extends AudioEventAdapter {
    private AudioPlayer player;
    private final BlockingQueue<AudioTrack> queue;

    public TrackScheduler(AudioPlayer player) {
        this.player = player;
        this.queue = new LinkedBlockingQueue<>();
    }

    @Override
    public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
        this.player = player;
        if (endReason.mayStartNext) {
            nextTrack();
        }
    }

    public void nextTrack() {
        this.player.startTrack(this.queue.poll(), false);
    }

    public void queue(AudioTrack track) {
        if (!this.player.startTrack(track, true)) {
            this.queue.offer(track);
        }
    }

    public void clearup() {
        for (int i = 0; i < queue.size(); i++) {
            queue.remove(i);
        }
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public BlockingQueue<AudioTrack> getQueue() {
        return queue;
    }
}
