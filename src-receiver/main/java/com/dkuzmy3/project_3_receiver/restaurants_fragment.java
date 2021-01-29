package com.dkuzmy3.project_3_receiver;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class restaurants_fragment extends Fragment {
    //private FragmentAListener listener;
    static String[] interestList2;
    private String TAG2 = "interestTAG";
    FragmentManager fm2;
    FragmentTransaction fragTransaction2;
    restaurants_webview_fragment web_frag2;

    //public interface FragmentAListener{
    //    void onInputASent(int input);
    //}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        interestList2 = getResources().getStringArray(R.array.restaurant_array);       // populate array

        fragTransaction2 = getFragmentManager().beginTransaction();                  // for transactions
        fragTransaction2.setCustomAnimations(android.R.animator.fade_in,             // of fragments
                android.R.animator.fade_out);


        fm2 = getActivity().getSupportFragmentManager();

        View view = inflater.inflate(R.layout.restaurants_list_fragment, container, false);    // inflate the view

        ListView list = (ListView)view.findViewById(R.id.restaurants_listView);    // populate listview

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(),  // array adapter
                android.R.layout.simple_list_item_1, interestList2);               // for list items
        // R.layout.text_edit
        list.setAdapter(listViewAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // i = index number
                // send the website and number to fragment that views webpages
                //int input = i;
                //listener.onInputASent(input);

                Bundle bundle = new Bundle();
                bundle.putInt("val", i);
                //fragTransaction.show(fm.findFragmentById(R.id.interestActivity_fragment_pageview));
                web_frag2 = new restaurants_webview_fragment();
                web_frag2.setArguments(bundle);
                fragTransaction2.replace(R.id.frame_container2, web_frag2);
                //fragTransaction.show(web_frag);
                fragTransaction2.commit();
            }
        });
        setRetainInstance(true);
        return view;
    }
/*
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentAListener){listener = (FragmentAListener)context;}
        else{throw new RuntimeException(context.toString() + "no fragmentAlistner");}
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }*/
}
