package sg.edu.rp.c346.id20028828.demotodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> itemList;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<ToDoItem> objects){
        super(context, resource, objects);
        this.parent_context = context;
        this.layout_id = resource;
        this.itemList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);

        ToDoItem currentItem = itemList.get(position);

        tvTitle.setText(currentItem.getTitle());
        tvDate.setText(currentItem.toString());

        return rowView;
    }
}
