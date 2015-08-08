package com.onevalue.brian.crowingmoment;

import android.support.v4.app.Fragment;

/**
 * Created by brian on 15. 8. 4..
 */
public class MomentListActiviy extends SingleFragmentActivity {
  @Override
  protected Fragment createFragment() {
    return new MomentListFragment();
  }
}
