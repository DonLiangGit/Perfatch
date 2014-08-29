package don.com.perfatch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by new on 8/28/14.
 */
public class GridImageAdapter extends BaseAdapter {

    private Context mContext;
    public Integer[] gridThumb = {R.drawable.frag_img2, R.drawable.frag_img2, R.drawable.frag_img2};

    public GridImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return gridThumb.length;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null) {
            imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(gridThumb[position]);
        return imageView;
    }

    public long getItemId(int position) {
        return 0;
    }

    public Object getItem(int position) {
        return null;
    }
}
