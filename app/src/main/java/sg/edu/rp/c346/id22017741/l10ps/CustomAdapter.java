package sg.edu.rp.c346.id22017741.l10ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> songArrayList;

    public CustomAdapter(Context context, int resource, ArrayList<Song>objects){
        super(context, resource, objects);
        parent_context=context;
        layout_id=resource;
        songArrayList=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=(LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle=rowView.findViewById(R.id.tvTitle);
        TextView tvSinger=rowView.findViewById(R.id.tvSinger);
        TextView tvYear=rowView.findViewById(R.id.tvYear);
        TextView tvStar=rowView.findViewById(R.id.tvStar);

        // Obtain the Android Version information based on the position
        Song currentVersion=songArrayList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentVersion.getTitle());
        tvYear.setText(currentVersion.getYear()+"");
        tvStar.setText(currentVersion.getStars()+" Stars");
        tvSinger.setText(currentVersion.getSingers());

        return rowView;
    }
}
