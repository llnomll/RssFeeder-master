package a816.android.soldesk.rssfeeder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by soldesk on 2016-09-09.
 */
public class CategoryActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button btnBacktoMain;
    TextView textViewTitle;
    String title = "";

    ArrayList<NewsListFragment> tabFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cathegory);

        textViewTitle = (TextView) findViewById(R.id.textView_title);
        title += (getIntent().getStringExtra("company")).toString();

        if (title.equals(CategoryCreater.COMPANY_JOONGANG)) textViewTitle.setText("중앙일보");
        if (title.equals(CategoryCreater.COMPANY_JOSUN)) textViewTitle.setText("조선일보");
        if (title.equals(CategoryCreater.COMPANY_DONGA)) textViewTitle.setText("동아일보");
        if (title.equals(CategoryCreater.COMPANY_HAN)) textViewTitle.setText("한겨례");
        if (title.equals(CategoryCreater.COMPANY_MK)) textViewTitle.setText("매일경제");
        if (title.equals(CategoryCreater.COMPANY_SBS)) textViewTitle.setText("SBS");
        if (title.equals(CategoryCreater.COMPANY_MBC)) textViewTitle.setText("MBC");
        if (title.equals(CategoryCreater.COMPANY_CNN)) textViewTitle.setText("CNN");
        if (title.equals(CategoryCreater.COMPANY_NY)) textViewTitle.setText("NewYork Times");


        btnBacktoMain = (Button) findViewById(R.id.btnBacktoMain);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayList<CategoryInfo> tab_list = CategoryCreater.create(getIntent().getStringExtra("company"));

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        for(int i=0;i<tab_list.size();i++){
            tabFragmentList.add(NewsListFragment.newsListFragment(tab_list.get(i).getUrl(),tab_list.get(i).getEncode()));
            tabs.addTab(tabs.newTab().setText(tab_list.get(i).getTitle()));
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, tabFragmentList.get(0)).commit();



        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("MainActivity", "선택된 탭 : " + position);

                Fragment selected = tabFragmentList.get(position);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        getSupportActionBar().hide();
    }

    public void onClickBtnBacktoMain(View view) {
        finish();

    }
}
