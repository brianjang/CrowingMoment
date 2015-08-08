package com.onevalue.brian.crowingmoment;


import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;

import java.util.UUID;

//FragmentActivity : use android support library for legacy compatibility
public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
//        return new MomentFragment();
        UUID momentId = (UUID)getIntent().getSerializableExtra(MomentFragment.EXTRA_MOMENT_ID);

        return MomentFragment.newInstance(momentId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
