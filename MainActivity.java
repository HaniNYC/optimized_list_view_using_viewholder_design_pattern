package slidenerd.vivz;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    ListView list;
    String[] memeTitles;
    String[] memeDescriptions;
    int[] images = {R.drawable.meme1, R.drawable.meme2, R.drawable.meme3, R.drawable.meme4, R.drawable.meme5, R.drawable.meme6, R.drawable.meme7, R.drawable.meme8, R.drawable.meme9, R.drawable.meme10, R.drawable.meme1, R.drawable.meme2, R.drawable.meme3, R.drawable.meme4, R.drawable.meme5, R.drawable.meme6, R.drawable.meme7, R.drawable.meme8, R.drawable.meme9, R.drawable.meme10,R.drawable.meme1, R.drawable.meme2, R.drawable.meme3, R.drawable.meme4, R.drawable.meme5, R.drawable.meme6, R.drawable.meme7, R.drawable.meme8, R.drawable.meme9, R.drawable.meme10, R.drawable.meme1, R.drawable.meme2, R.drawable.meme3, R.drawable.meme4, R.drawable.meme5, R.drawable.meme6, R.drawable.meme7, R.drawable.meme8, R.drawable.meme9, R.drawable.meme10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        memeTitles = res.getStringArray(R.array.titles);
        memeDescriptions = res.getStringArray(R.array.descriptions);

        list = (ListView) findViewById(R.id.listView);
        VivzAdapter adapter = new VivzAdapter(this, memeTitles, images, memeDescriptions);
        list.setAdapter(adapter);

    }


}

class VivzAdapter extends ArrayAdapter<String> {
    int size = 1;
    Context context;
    int[] images;
    String[] titleArray;
    String[] descriptionArray;

    VivzAdapter(Context c, String[] titles, int imgs[], String[] desc) {
        super(c, R.layout.single_row, R.id.textView, titles);
        this.context = c;
        this.images = imgs;
        this.titleArray = titles;
        this.descriptionArray = desc;
    }
    class MyViewHolder
    {
        ImageView myImage;
        TextView myTitle;
        TextView myDescription;
        MyViewHolder(View v)
        {
            myImage= (ImageView) v.findViewById(R.id.imageView);
            myTitle= (TextView) v.findViewById(R.id.textView);
            myDescription= (TextView) v.findViewById(R.id.textView2);
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row=convertView;
        MyViewHolder holder=null;
        if(row==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, parent, false);
            holder=new MyViewHolder(row);
            row.setTag(holder);
            Log.d("VIVZ","Creating a new row");
        }
        else
        {
            holder= (MyViewHolder) row.getTag();
            Log.d("VIVZ","Recycling stuff");
        }

        holder.myImage.setImageResource(images[position]);

        holder.myTitle.setText(titleArray[position]);

        holder.myDescription.setText(descriptionArray[position]);

        return row;
    }
}
