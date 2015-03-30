package com.cn.daming.deskclock;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Z on 2015/3/30.
 */
public class ExploreItem extends Fragment  {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String title;
    String path;
    private OnFragmentInteractionListener mListener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.title=getArguments().getString(ARG_PARAM1);
        this.path=getArguments().getString(ARG_PARAM2);
        super.onCreate(savedInstanceState);
    }

    public static ExploreItem newInstance(String title, String path) {
        ExploreItem fragment = new ExploreItem();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        args.putString(ARG_PARAM2, path);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.explore_item, container, false);
        final TextView textView=(TextView)view.findViewById(R.id.explore_item_text);
        textView.setText(this.title);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onFragmentInteraction(textView.getText().toString());
            }
        });

        return view;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(String selectText);
    }
}
