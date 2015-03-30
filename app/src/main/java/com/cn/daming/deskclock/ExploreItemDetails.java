package com.cn.daming.deskclock;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Z on 2015/3/30.
 */
public class ExploreItemDetails extends Fragment {
    String title;
    private static final String ARG_PARAM1 = "param1";
    public static ExploreItemDetails newInstance(String title) {
        ExploreItemDetails fragment = new ExploreItemDetails();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        fragment.setArguments(args);
        return fragment;
    }
    public ExploreItemDetails()
    {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.title=getArguments().getString(ARG_PARAM1);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.explore_item_details, container, false);
        TextView textView=(TextView)view.findViewById(R.id.explore_item_detail_text);
        textView.setText(this.title);
        return view;
    }
}
