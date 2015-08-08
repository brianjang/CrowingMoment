package com.onevalue.brian.crowingmoment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by brian on 15. 8. 4..
 */
public class MomentListFragment extends ListFragment {
  private static final String TAG = "MomentListFragment";
  private ArrayList<Moment> mMoments;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivity().setTheme(R.string.moment_title);
    mMoments = MomentLab.get(getActivity()).getMoments();

    MomentAdapter adapter = new MomentAdapter(mMoments);
    setListAdapter(adapter);
  }

  @Override
  public void onListItemClick(ListView l, View v, int position, long id) {
    Log.d(TAG, "onListItem");
    Moment m = ((MomentAdapter)getListAdapter()).getItem(position);
    Log.d(TAG, m.getTitle() + "was clicked");
  }

  private class MomentAdapter extends ArrayAdapter<Moment> {

    public MomentAdapter(ArrayList<Moment> moments) {
      super(getActivity(), 0, moments);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

      if(convertView == null) {
        convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_moment, null);

        Moment m = getItem(position);

        TextView titleTextView = (TextView)convertView.findViewById(R.id.moment_list_item_titelTextView);
        titleTextView.setText(m.getTitle());

        TextView dataTextView = (TextView)convertView.findViewById(R.id.moment_list_item_dateTextView);
        dataTextView.setText(m.getDate().toString());

        CheckBox savedCehckBox = (CheckBox)convertView.findViewById(R.id.moment_list_item_savedCheckBox);
        savedCehckBox.setChecked(m.isSave());

      }

      return convertView;
    }
  }
}
