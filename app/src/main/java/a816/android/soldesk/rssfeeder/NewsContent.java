package a816.android.soldesk.rssfeeder;

import android.os.AsyncTask;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by soldesk on 2016-09-09.
 */
public class NewsContent extends AsyncTask<String, Void, ArrayList<NewsDTO>> {
    private String encode;
    /*
    *안드로이드에서 AsyncTask는 쓰레드 관리와 UI Thread와의 통신을 원활하게
    * 도와주는 Wrapper Class이다
    * 쓰레드를 쓰기위해서 AsyncTask클래스를 상속받았다
    * 첫번째 인자 : execute() 시에 넘겨 받을 인자를 정의
    * doInBackground()에서 호툴될 때 값이 넘어가게 되며 여러개의 값을 넘겨 받을 수 있도록 되어있다.
     *
      *두번째 인자 : onProgressUpdate()가 호출될 때 넘겨 받을 인자를 뜻한다.
      *
      *세번째 인자 : onPostExecute()가 호출될 때 넘겨 받을 인자를 뜻함
      * 작업이 끝났을 때 무언가를 처리하고 싶을 때 사용
      * */

    URL url;

    private String tagname = "";
    private String title = "";
    private String description = "";
    private String pubDate = "";
    private String date = "dc:date";
    private String link = "";

    private static final String TAG_TITLE = "title";
    private static final String TAG_LINK = "link";
    private static final String TAG_PUB_DATE = "pubDate";
    private static final String TAG_DESCRIPTION = "description";


    private OnNewsParseFinishListener listener;

    public NewsContent(OnNewsParseFinishListener listener, String encode) {
        this.listener = listener;
        this.encode = encode;
    }

    @Override
    protected ArrayList<NewsDTO> doInBackground(String... uri) {
        ArrayList<NewsDTO> parsedList = new ArrayList<>();//얻어온 뉴스 데이터들을 저장할 어레이리스트
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            url = new URL(uri[0]);

            InputStream in = url.openStream();

            xpp.setInput(in, encode);

            boolean isInItemTag = false;

            int eventType = xpp.getEventType();


            NewsDTO news = null;//뉴스아이템을 저장할 DTO

            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    tagname = xpp.getName();
                    if ("item".equals(tagname)) {
                        news = new NewsDTO();//새로운 뉴스아이템 생성
                        isInItemTag = true;
                    }
                } else if (eventType == XmlPullParser.TEXT) {
                    if (TAG_TITLE.equals(tagname) && isInItemTag) {
                        title += xpp.getText();
                    } else if (TAG_DESCRIPTION.equals(tagname) && isInItemTag) {
                        description += xpp.getText();
                    } else if ((TAG_PUB_DATE.equals(tagname) | TAG_PUB_DATE.equals(date)) && isInItemTag) {
                        pubDate += xpp.getText();
                    } else if (TAG_LINK.equals(tagname) && isInItemTag) {
                        link += xpp.getText();
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                    tagname = xpp.getName();

                    if ("item".equals(tagname)) {

                        news.setTitle(title);
                        news.setDescription(description);
                        news.setPubDate(pubDate);
                        news.setLink(link);

                        parsedList.add(news);//리스트에 아이템 추가

                        title = "";
                        description = "";
                        pubDate = "";
                        link = "";

                        isInItemTag = false;
                    }
                }
                eventType = xpp.next();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return parsedList;
    }

    @Override
    protected void onPostExecute(ArrayList<NewsDTO> newsDTOs) {
        listener.onNewsParseFinish(newsDTOs);
    }

    public interface OnNewsParseFinishListener {
        public void onNewsParseFinish(ArrayList<NewsDTO> result);
    }
}