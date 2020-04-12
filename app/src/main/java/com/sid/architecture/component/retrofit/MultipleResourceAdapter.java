package com.sid.architecture.component.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sid.architecture.component.R;
import com.sid.architecture.component.retrofit.model.MultipleResource;

import java.util.List;

public class MultipleResourceAdapter extends RecyclerView.Adapter<MultipleResourceAdapter.MyViewHolder> {

    private List<MultipleResource.DataRecords> dataRecords;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id, name, year;

        public MyViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.id);
            name = (TextView) view.findViewById(R.id.name);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public MultipleResourceAdapter(List<MultipleResource.DataRecords> moviesList) {
        this.dataRecords = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MultipleResource.DataRecords movie = dataRecords.get(position);
        holder.id.setText(movie.name);
        holder.name.setText(movie.color);
        holder.year.setText(movie.year.toString());
    }

    @Override
    public int getItemCount() {
        return dataRecords.size();
    }
}
