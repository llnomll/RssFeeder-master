package a816.android.soldesk.rssfeeder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by soldesk on 2016-09-09.
 */
public class NewsListAdapter extends BaseAdapter {
    private ArrayList<NewsDTO> list=new ArrayList<>();

    public NewsDTO getNews(int position){
        return list.get(position);
    }
    public void setList(ArrayList<NewsDTO> list){
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = ((LayoutInflater)viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_newsitem,null);
        }
        TextView tv_title = (TextView) view.findViewById(R.id.item_tv_title);
        /*TextView tv_link = (TextView) view.findViewById(R.id.item_tv_link);*/
        TextView tv_pubdate = (TextView) view.findViewById(R.id.item_tv_pubdate);
        /*TextView tv_desc = (TextView) view.findViewById(R.id.item_tv_desc);*/

        NewsDTO newsDTO = list.get(i);

        tv_title.setText(newsDTO.getTitle());
//        tv_desc.setText(newsDTO.getDescription());
//        tv_link.setText(newsDTO.getLink());
        tv_pubdate.setText(newsDTO.getPubDate());
        return view;
    }
}
