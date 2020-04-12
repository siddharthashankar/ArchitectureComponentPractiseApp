package com.sid.architecture.component.livedata.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sid.architecture.component.R;
import com.sid.architecture.component.livedata.model.Hero;

import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.HeroViewHolder> {

    Context mCtx;
    List<Hero> heroList;

    public HeroesAdapter(Context mCtx, List<Hero> heroList) {
        this.mCtx = mCtx;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_hero_layout, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        Hero hero = heroList.get(position);

        Glide.with(mCtx)
                .load(hero.getImageurl())
                .into(holder.imageView);

        holder.name.setText(hero.getName());
        holder.realName.setText(hero.getRealname());
        holder.team.setText(hero.getTeam());
        holder.createdBy.setText(hero.getCreatedby());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        TextView realName;
        TextView  team;
        TextView createdBy;

        public HeroViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.tvName);
            realName = itemView.findViewById(R.id.tvRealName);
            team = itemView.findViewById(R.id.tvTeam);
            createdBy = itemView.findViewById(R.id.tvCreatedBy);
        }
    }
}
