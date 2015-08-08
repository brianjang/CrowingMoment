package com.onevalue.brian.crowingmoment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MomentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MomentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MomentFragment extends Fragment {

  private static final String TAG = "MomentFragment";



  //  reference for model object
  private Moment mMoment;

  //  reference for widget in View
  private EditText mTitleField;
  private Button mDateButton;
  private CheckBox mSaveCheckBox;

  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//  private static final String EXTRA_MOMENT_ID = "param1";
  public static final String EXTRA_MOMENT_ID = "com.onevalue.brian.crowingmoment.moment_id";

  // TODO: Rename and change types of parameters
  private UUID momentId;

  private OnFragmentInteractionListener mListener;

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @param momentId UUID of selected moment instance.
   * @return A new instance of fragment MomentFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static MomentFragment newInstance(UUID momentId) {
    MomentFragment fragment = new MomentFragment();
    Bundle args = new Bundle();
    args.putSerializable(EXTRA_MOMENT_ID, momentId);
    fragment.setArguments(args);
    return fragment;
  }

  public MomentFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      momentId = (UUID)getArguments().getSerializable(EXTRA_MOMENT_ID);
    }

    mMoment = MomentLab.get(getActivity()).getMoment(momentId);
    Log.d(TAG, "moment UUID : " + momentId.toString());
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_moment, container, false);

    mTitleField = (EditText)v.findViewById(R.id.moment_title);
    mTitleField.setText(mMoment.getTitle());
    
    mTitleField.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        //TODO
      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        mMoment.setTitle(s.toString());
      }

      @Override
      public void afterTextChanged(Editable s) {
        //TODO
      }
    });

    mDateButton = (Button)v.findViewById(R.id.moment_date);
    mDateButton.setText(mMoment.getDate().toString());
    mDateButton.setEnabled(false);

    mSaveCheckBox = (CheckBox)v.findViewById(R.id.moment_save);
    mSaveCheckBox.setChecked(mMoment.isSave());
    mSaveCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mMoment.setSave(isChecked);
      }
    });

    return v;
  }

  // TODO: Rename method, update argument and hook method into UI event
  public void onButtonPressed(Uri uri) {
    if (mListener != null) {
      mListener.onFragmentInteraction(uri);
    }
  }

//  @Override
//  public void onAttach(Activity activity) {
//    super.onAttach(activity);
//    try {
//      mListener = (OnFragmentInteractionListener) activity;
//    } catch (ClassCastException e) {
//      throw new ClassCastException(activity.toString()
//          + " must implement OnFragmentInteractionListener");
//    }
//  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  /**
   * This interface must be implemented by activities that contain this
   * fragment to allow an interaction in this fragment to be communicated
   * to the activity and potentially other fragments contained in that
   * activity.
   * <p>
   * See the Android Training lesson <a href=
   * "http://developer.android.com/training/basics/fragments/communicating.html"
   * >Communicating with Other Fragments</a> for more information.
   */
  public interface OnFragmentInteractionListener {
    // TODO: Update argument type and name
    public void onFragmentInteraction(Uri uri);
  }

}
