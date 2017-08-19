package com.ljd.android.ljdevelopers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MOJISOLA on 19/08/2017.
 */

public class LjdevelopersAdapter extends RecyclerView.Adapter<LjdevelopersAdapter.ViewHolder>{

    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_URL = "url";

    private List<Ljdevelopers> ljdevelopers;
    private Context context;

    public LjdevelopersAdapter(List<Ljdevelopers> ljdevelopers, Context context){

        this.ljdevelopers = ljdevelopers;
        this.context = context;}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ljdevelopers_list, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Ljdevelopers ljdeveloper = ljdevelopers.get(position);
        holder.login.setText(ljdeveloper.getLogin());

        Picasso.with(context)
                .load(ljdeveloper.getAvatar_url())
                .into(holder.avatar_url);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Ljdevelopers ljdevelopers1 = ljdevelopers.get(position);

                Intent skipIntent = new Intent(v.getContext(), ProfileActivity.class);
                skipIntent.putExtra(KEY_NAME, ljdevelopers1.getLogin());
                skipIntent.putExtra(KEY_URL, ljdevelopers1.getHtml_url());
                skipIntent.putExtra(KEY_IMAGE, ljdevelopers1.getAvatar_url());
                v.getContext().startActivity(skipIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ljdevelopers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView login;
        public ImageView avatar_url;
        public TextView html_url;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            login = (TextView) itemView.findViewById(R.id.username);
            avatar_url = (ImageView) itemView.findViewById(R.id.imageView);
            html_url = (TextView) itemView.findViewById(R.id.htmUrl);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }



    }
}
