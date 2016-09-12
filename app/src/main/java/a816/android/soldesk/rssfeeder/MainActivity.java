package a816.android.soldesk.rssfeeder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)this.findViewById(R.id.listView01);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        final ArrayList<String> items = new ArrayList<>();
        items.add("중앙일보");
        items.add("조선일보");
        items.add("동아일보");
        items.add("한겨례");
        items.add("매일경제");
        items.add("SBS");
        items.add("MBC");
        items.add("CNN");
        items.add("NewYork Times");

        CustomAdapter adapter = new CustomAdapter(this,0,items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String company="";
                switch (items.get(i)) {
                    case "중앙일보":
                        company = CategoryCreater.COMPANY_JOONGANG;
                        break;
                    case "조선일보":
                        company = CategoryCreater.COMPANY_JOSUN;
                        break;
                    case "동아일보":
                        company = CategoryCreater.COMPANY_DONGA;
                        break;
                    case "한겨례":
                        company = CategoryCreater.COMPANY_HAN;
                        break;
                    case "매일경제":
                        company = CategoryCreater.COMPANY_MK;
                        break;
                    case "SBS":
                        company = CategoryCreater.COMPANY_SBS;
                        break;
                    case "MBC":
                        company = CategoryCreater.COMPANY_MBC;
                        break;
                    case "CNN":
                        company = CategoryCreater.COMPANY_CNN;
                        break;
                    case "NewYork Times":
                        company = CategoryCreater.COMPANY_NY;
                        break;
                }
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                intent.putExtra("company",company);
                startActivity(intent);
            }
        });

    }


    private class CustomAdapter extends ArrayAdapter<String> {
        private ArrayList<String> items;

        public CustomAdapter(Context context, int textViewResourceId, ArrayList<String> object) {
            super(context, textViewResourceId, object);
            this.items = object;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.listview_item, null);
            }

            // ImageView 인스턴스
            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);

            // 리스트뷰의 아이템에 이미지를 변경한다.
            if ("중앙일보".equals(items.get(position)))
                imageView.setImageResource(R.drawable.joongang_1);
            else if ("조선일보".equals(items.get(position)))
                imageView.setImageResource(R.drawable.chosun_1);
            else if ("동아일보".equals(items.get(position)))
                imageView.setImageResource(R.drawable.donga_1);
            else if ("한겨례".equals(items.get(position)))
                imageView.setImageResource(R.drawable.han_1);
            else if ("매일경제".equals(items.get(position)))
                imageView.setImageResource(R.drawable.mk_1);
            else if ("SBS".equals(items.get(position)))
                imageView.setImageResource(R.drawable.sbs_1);
            else if ("MBC".equals(items.get(position)))
                imageView.setImageResource(R.drawable.mbc_1);
            else if ("CNN".equals(items.get(position)))
                imageView.setImageResource(R.drawable.cnn);
            else if ("NewYork Times".equals(items.get(position)))
                imageView.setImageResource(R.drawable.nytimes);

            TextView textView = (TextView) v.findViewById(R.id.textView);
            textView.setText(items.get(position));

            return v;
        }

    }

}
