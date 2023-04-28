package com.example.musicapp;

import static android.media.AudioManager.*;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.Fragments.OnlineFragment;

import java.io.IOException;
import java.util.List;
import android.media.MediaPlayer;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<Music> dataList;

    private static MediaPlayer mMediaPlayer;

    static boolean isPlaying = false;
    public MyAdapter(Context context, List<Music> dataList) {
        this.context = context;
        this.dataList = dataList;
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setAudioAttributes(new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build());
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Music data = dataList.get(position);
        holder.recName.setText(data.getname());
        holder.recUrl.setText(data.geturl());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static void playMusic(String url) {
        try {
            mMediaPlayer.setDataSource(url);
            mMediaPlayer.prepare();
            mMediaPlayer.setLooping(false);
            mMediaPlayer.start();
            // Wait for media player to finish playing
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    // Release media player when finished playing
                    mMediaPlayer.release();
                    mMediaPlayer = null;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static void stopPlaying() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.reset();
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView recName;
        TextView recUrl;

        CardView recCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recCard = itemView.findViewById(R.id.recCard);
            recName = itemView.findViewById(R.id.txtsongname);
            recUrl = itemView.findViewById(R.id.txturl);
            recCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isPlaying) {
                        stopPlaying();
                        isPlaying = false;
                    } else {
                        String url = recUrl.getText().toString();
                        Log.d("Test", "onClick: "+url);
                        playMusic(url);
                        isPlaying = true;
                    }
                }});
        }
    }
}
