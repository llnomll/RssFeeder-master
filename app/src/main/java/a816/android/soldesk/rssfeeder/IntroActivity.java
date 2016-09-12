package a816.android.soldesk.rssfeeder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ProgressBar;

/**
 * Created by soldesk on 2016-09-09.
 */
public class IntroActivity extends Activity {

    Handler h;
    ProgressBar pbbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.introactivity);
        h = new Handler();
        h.postDelayed(irun, 4000);

        pbbar = (ProgressBar) findViewById(R.id.progressBar01);
        pbbar.setVisibility(ProgressBar.VISIBLE);
    }

    Runnable irun = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(IntroActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        h.removeCallbacks(irun);
    }
}
