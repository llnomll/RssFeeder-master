package a816.android.soldesk.rssfeeder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by soldesk on 2016-09-09.
 */
public class NewsListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ProgressDialog loadingDialog;
    private ListView listView;
    private NewsListAdapter adapter;
    private NewsContent newsContent;

    private String encode;
    private String uri;

    public static NewsListFragment newsListFragment(String uri, String encode) {
        NewsListFragment instance = new NewsListFragment();
        instance.setUri(uri);
        instance.setEcode(encode);
        return instance;
    }

    public void setEcode(String encode) {
        this.encode = encode;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.newsfragment, null);
        //로딩다이얼로그 보임
        loadingDialog = ProgressDialog.show(getActivity(), "RSS Refresh", "RSS 정보 업데이트 중...", true, true);
        //doInBackground 메소드를 호출해줌
        newsContent = new NewsContent(new NewsContent.OnNewsParseFinishListener() {

            @Override
            public void onNewsParseFinish(ArrayList<NewsDTO> result) {
                //로딩다이얼로그 감춤
                loadingDialog.dismiss();
                adapter.setList(result);
                adapter.notifyDataSetChanged();
                //어댑터 뉴스 리스트 최신화
            }
        }, encode);
        newsContent.execute(uri);
        //execute();
        //AsyncTask를 실행시킨다. execute()메서드에 의해 가장 먼저 호출되는
        // 메서드가 inPreExcute()이고
        // 다음으로 자동으로 호출되는 메서드가 doInBackground()이다.

        //리스트뷰 객체를 생성
        listView = (ListView) view.findViewById(R.id.newListView);
        //어댑터 생성
        adapter = new NewsListAdapter();
        //어댑터 부착
        listView.setAdapter(adapter);
        //이벤트 부착
        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }//inCreate();

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        //<?> 제너릭 자료행을 스고 싶으나 실제형 인자가
        //무엇인지를 모르거나 신경쓰고 싶지 않을 때 사용

//        //새로운 화면을 띄우기 위한 클래스 작성
        Intent intent = new Intent(getActivity(), Content.class);
//        //새로운 화면에 데이터를 전달
        intent.putExtra("url", adapter.getNews(position).getLink());
//        //새로운 화면으로 전환
        startActivity(intent);
    }
}