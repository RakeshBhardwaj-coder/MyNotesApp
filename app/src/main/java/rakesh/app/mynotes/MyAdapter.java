package rakesh.app.mynotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context context;
    ArrayList title_id,notes_id;

    public MyAdapter(Context context, ArrayList title_id, ArrayList notes_id) {
        this.context = context;
        this.title_id = title_id;
        this.notes_id = notes_id;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.data_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.title_id.setText(String.valueOf(title_id.get(position)));
        holder.notes_id.setText(String.valueOf(notes_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return title_id.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title_id,notes_id;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_id = itemView.findViewById(R.id.tvTitle);
            notes_id = itemView.findViewById(R.id.tvNotes);

        }
    }
}
