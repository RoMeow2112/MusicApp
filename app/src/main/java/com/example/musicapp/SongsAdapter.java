package com.example.musicapp;

import static androidx.core.content.ContextCompat.startActivity;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsAdapterViewHolder> {
    Context context;
    List<Song> arrayListSongs;

    public SongsAdapter (Context context, List<Song> arrayListSongs)
    {
        this.context = context;
        this.arrayListSongs = arrayListSongs;
    }

    @NonNull
    @Override
    public SongsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.song_row_item, parent, false);
        return new SongsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsAdapterViewHolder holder, int position) {
        Song song = arrayListSongs.get(position);
        holder.txtsongname.setText(song.getSongName());
    }

    @Override
    public int getItemCount() {
        return arrayListSongs.size();
    }

    public class SongsAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView txtsongname;
        public SongsAdapterViewHolder (@NonNull View itemView) {
            super(itemView);
            txtsongname = (TextView) itemView.findViewById(R.id.txtsongname);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ArrayList<String> url = new ArrayList<>();
            arrayListSongs.forEach((song) -> url.add(song.getSongUrl()));
            context.startActivity(new Intent(context, PlayerActivityOnline.class)
                    .putExtra("songs", url)
                    .putExtra("songname", arrayListSongs.get(getAdapterPosition()).getSongName())
                    .putExtra("pos",getAdapterPosition()));
        }
    }

}
