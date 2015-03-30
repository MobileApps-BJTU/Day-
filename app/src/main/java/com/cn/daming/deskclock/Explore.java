package com.cn.daming.deskclock;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class Explore extends Activity implements ExploreItem.OnFragmentInteractionListener {
    @Override

    public void onFragmentInteraction(String selectText) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ExploreItemDetails fg=ExploreItemDetails.newInstance(selectText);
        ft.replace(R.id.fragment_container, fg);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
	public void onCreate(Bundle savedInstanceState) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ExploreItem fg=ExploreItem.newInstance("Food","http://www.picture.com");//title and  path just for test
        ft.add(R.id.fragment_container,fg);
        ft.addToBackStack(null);
        ft.commit();
        setContentView(R.layout.explore);
		super.onCreate(savedInstanceState);


	}
}
