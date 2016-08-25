package com.example.saisrikanth.project3companion;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by srikh on 3/16/(2016.
 */
public class IndianapolisList extends ListFragment{
    private static final String TitleCheck = "IndianapolisList";
    private ListSelectionListener mListener = null;
    public interface ListSelectionListener {
        public void onListSelection(int index);
    }

    @Override
    public void onAttach(Activity activity) {
        Log.i(TitleCheck, getClass().getSimpleName() + ":entered onAttach()");
        super.onAttach(activity);

        try {

            // Set the ListSelectionListener for communicating with the QuoteViewerActivity
            mListener = (ListSelectionListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnArticleSelectedListener");
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TitleCheck, getClass().getSimpleName() + ":entered onCreate()");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TitleCheck, getClass().getSimpleName() + ":entered onCreateView()");
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onActivityCreated(Bundle savedState) {
        Log.i(TitleCheck, getClass().getSimpleName() + ":entered onActivityCreated()");
        super.onActivityCreated(savedState);

        // Set the list adapter for the ListView
        // Discussed in more detail in the user interface classes lesson
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.listview, IndianapolisMainActivity.mListArray));

        // Set the list choice mode to allow only one selection at a time
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {

        // Indicates the selected item has been checked
        getListView().setItemChecked(pos, true);

        // Inform the QuoteViewerActivity that the item in position pos has been selected
        mListener.onListSelection(pos);
    }


}



