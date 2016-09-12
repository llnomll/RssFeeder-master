package a816.android.soldesk.rssfeeder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * Created by soldesk on 2016-09-09.
 */
public class Content extends AppCompatActivity {

    private WebView wv;
    TextView textViewlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

       /* textViewlist = (TextView) findViewById(R.id.textView_list);*/


        String url = getIntent().getStringExtra("url");
        wv = (WebView) findViewById(R.id.webview_content);
        wv.setWebViewClient(new WebViewClient());
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setSupportZoom(true);
        wv.getSettings().setDisplayZoomControls(true);
        wv.getSettings().setBuiltInZoomControls(true);
        wv.loadUrl(url);

    }

    public void onClickBtnBack(View view) {
        finish();

    }

}
