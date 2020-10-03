package com.example.karkapazhagu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class My_intern extends RecyclerView.Adapter<My_intern.ViewHolder> {

    private Context context;
    private List<upload_intern> uploads;

    public My_intern(Context context, List<upload_intern> uploads) {
        this.uploads = uploads;
        this.context = context;
    }

    @Override
    public My_intern.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_images1, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(My_intern.ViewHolder holder, int position) {
        upload_intern upload = uploads.get(position);

        holder.textViewName.setText(upload.getName());
        holder.textViewDescription.setText(upload.getDescription());



        Glide.with(context).load(upload.getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return uploads.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public ImageView imageView;
        public TextView textViewDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textViewDescription=(TextView) itemView.findViewById(R.id.textViewDescription);
        }
    }
}
