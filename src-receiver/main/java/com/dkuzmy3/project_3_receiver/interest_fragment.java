package com.dkuzmy3.project_3_receiver;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.nio.charset.Charset;

public class interest_fragment extends Fragment {
    //private FragmentAListener listener;
    static String[] interestList;
    private String TAG = "interestTAG";
    FragmentManager fm;
    FragmentTransaction fragTransaction;
    interest_webview_fragment web_frag;

    //public interface FragmentAListener{
    //    void onInputASent(int input);
    //}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        interestList = getResources().getStringArray(R.array.interest_array);       // populate array

        fragTransaction = getFragmentManager().beginTransaction();                  // for transactions
        fragTransaction.setCustomAnimations(android.R.animator.fade_in,             // of fragments
                android.R.animator.fade_out);


        fm = getActivity().getSupportFragmentManager();

        View view = inflater.inflate(R.layout.interest_list_fragment, container, false);    // inflate the view

        ListView list = (ListView)view.findViewById(R.id.interest_listView);    // populate listview

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(),  // array adapter
                android.R.layout.simple_list_item_1, interestList);                     // for list items
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
                web_frag = new interest_webview_fragment();
                web_frag.setArguments(bundle);
                fragTransaction.replace(R.id.frame_container ,web_frag);
                //fragTransaction.show(web_frag);
                fragTransaction.commit();
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
