package com.onevalue.brian.crowingmoment;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by brian on 15. 7. 30..
 */
public class MomentLab {
  private ArrayList<Moment> mMoments;
  private static MomentLab sMomentLab; //singleton instance of this class
  private Context mAppContext;

  private void dummyMoments() {
    for (int i = 0; i < 100; i++) {
      Moment m = new Moment();
      m.setTitle("Moment #" + i);
      m.setSave(i % 2 == 0);
      mMoments.add(m);
    }
  }

  //private constructor
  private MomentLab(Context appContext) {
    mAppContext = appContext;
    mMoments = new ArrayList<Moment>();
    dummyMoments();
  }

  //create singleton instance of this class
  public static MomentLab get(Context c) {
    if (sMomentLab == null) {
      sMomentLab = new MomentLab(c.getApplicationContext());
    }

    return sMomentLab;
  }

  /**
   * define instance method of this class
   */
  public ArrayList<Moment> getMoments() {
    return mMoments;
  }

  public Moment getMoment(UUID id) {
    for(Moment m : mMoments) {
      if (m.getId().equals(id)) {
        return  m;
      }
    }

    return null;
  }
}
