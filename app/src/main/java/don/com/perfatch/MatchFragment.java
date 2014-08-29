package don.com.perfatch;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

@SuppressLint("ValidFragment")
public class MatchFragment extends Fragment {

    private GridView gridView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_match, container, false);
        gridView = (GridView)v.findViewById(R.id.match_gridView);
        gridView.setAdapter(new GridImageAdapter(getActivity().getApplicationContext()));
        return v;
    }

}