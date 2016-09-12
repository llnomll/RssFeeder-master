package a816.android.soldesk.rssfeeder;

import java.util.ArrayList;

/**
 * Created by soldesk on 2016-09-09.
 */
public class CategoryCreater {

    public static final String COMPANY_JOONGANG = "joong";
    public static final String COMPANY_JOSUN = "jo";
    public static final String COMPANY_DONGA = "dong";
    public static final String COMPANY_HAN = "han";
    public static final String COMPANY_MK = "mk";
    public static final String COMPANY_SBS = "sbs";
    public static final String COMPANY_MBC = "mbc";
    public static final String COMPANY_CNN = "cnn";
    public static final String COMPANY_NY = "ny";



    private static final String[] JUNG_TITLE = {"주요뉴스","인기뉴스","사회","경제","정치","IT/과학","스포츠","연예"};
    private static final String[] JUNG_URL = {
            "http://rss.joins.com/joins_homenews_list.xml",
            "http://rss.joins.com/sonagi/joins_sonagi_total_list.xml",
            "http://rss.joins.com/joins_life_list.xml",
            "http://rss.joins.com/joins_money_list.xml",
            "http://rss.joins.com/joins_politics_list.xml",
            "http://rss.joins.com/joins_it_list.xml",
            "http://rss.joins.com/news/joins_sports_etc_list.xml",
            "http://rss.joins.com/news/joins_star_etc_list.xml"
    };

    private static final String[] JOSUN_TITLE = {"주요뉴스","인기뉴스","사회","경제","정치","스포츠","연예","국제"};
    private static final String[] JOSUN_URL = {
            "http://myhome.chosun.com/rss/www_section_rss.xml",
            "http://newsplus.chosun.com/hitdata/xml/newsplus/index/index.xml",
            "http://www.chosun.com/site/data/rss/national.xml",
            "http://biz.chosun.com/site/data/rss/rss.xml",
            "http://www.chosun.com/site/data/rss/politics.xml",
            "http://www.chosun.com/site/data/rss/sports.xml",
            "http://www.chosun.com/site/data/rss/ent.xml",
            "http://www.chosun.com/site/data/rss/international.xml"
    };

    private static final String[] DONGA_TITLE = {"주요뉴스","사회","경제","정치","스포츠","연예","국제"};
    private static final String[] DONGA_URL = {
            "http://rss.donga.com/total.xml",
            "http://rss.donga.com/national.xml",
            "http://rss.donga.com/economy.xml",
            "http://rss.donga.com/politics.xml",
            "http://rss.donga.com/sportsdonga/sports_general.xml",
            "http://rss.donga.com/sportsdonga/entertainment.xml",
            "http://rss.donga.com/international.xml"
    };

    private static final String[] HAN_TITLE = {"주요뉴스","인기뉴스","경제","정치","스포츠","대중문화","국제"};
    private static final String[] HAN_URL = {
            "http://www.hani.co.kr/rss/lead/",
            "http://www.hani.co.kr/rss/newsrank/",
            "http://www.hani.co.kr/rss/economy/",
            "http://www.hani.co.kr/rss/politics/",
            "http://www.hani.co.kr/rss/sports/",
            "http://www.hani.co.kr/rss/culture/",
            "http://www.hani.co.kr/rss/international/"
    };

    private static final String[] MK_TITLE = {"주요뉴스","경제","정치","스포츠","문화/연예","국제","이코노미"};
    private static final String[] MK_URL = {
            "http://file.mk.co.kr/news/rss/rss_30000001.xml",
            "http://file.mk.co.kr/news/rss/rss_30100041.xml",
            "http://file.mk.co.kr/news/rss/rss_30200030.xml",
            "http://file.mk.co.kr/news/rss/rss_71000001.xml",
            "http://file.mk.co.kr/news/rss/rss_30000023.xml",
            "http://file.mk.co.kr/news/rss/rss_30300018.xml",
            "http://file.mk.co.kr/news/rss/rss_50000001.xml"
    };

    private static final String[] SBS_TITLE = {"속보","경제","정치","스포츠","연예","국제","사회"};
    private static final String[] SBS_URL = {
            "http://api.sbs.co.kr/xml/news/rss.jsp?pmDiv=all",
            "http://api.sbs.co.kr/xml/news/rss.jsp?pmDiv=economy",
            "http://api.sbs.co.kr/xml/news/rss.jsp?pmDiv=politics",
            "http://api.sbs.co.kr/xml/news/rss.jsp?pmDiv=sports",
            "http://api.sbs.co.kr/xml/news/rss.jsp?pmDiv=entertainment",
            "http://api.sbs.co.kr/xml/news/rss.jsp?pmDiv=international",
            "http://api.sbs.co.kr/xml/news/rss.jsp?pmDiv=society"
    };

    private static final String[] MBC_TITLE = {"전체뉴스","경제","정치","스포츠","문화/연예","국제","사회"};
    private static final String[] MBC_URL = {
            "http://imnews.imbc.com/rss/news/news_00.xml",
            "http://imnews.imbc.com/rss/news/news_04.xml",
            "http://imnews.imbc.com/rss/news/news_01.xml",
            "http://imnews.imbc.com/rss/news/news_07.xml",
            "http://imnews.imbc.com/rss/news/news_06.xml",
            "http://imnews.imbc.com/rss/news/news_03.xml",
            "http://imnews.imbc.com/rss/news/news_05.xmly"
    };

    private static final String[] CNN_TITLE = {"Top Stories","World","Americas","Asia","Europe","U.S.","Money"};
    private static final String[] CNN_URL = {
            "http://rss.cnn.com/rss/edition.rss",
            "http://rss.cnn.com/rss/edition_world.rss",
            "http://rss.cnn.com/rss/edition_americas.rss",
            "http://rss.cnn.com/rss/edition_asia.rss",
            "http://rss.cnn.com/rss/edition_europe.rss",
            "http://rss.cnn.com/rss/edition_us.rss",
            "http://rss.cnn.com/rss/money_news_international.rss"
    };

    private static final String[] NY_TITLE = {"World","U.S.","Business","Technology","Sports","Science","Health"};
    private static final String[] NY_URL = {
            "http://rss.nytimes.com/services/xml/rss/nyt/World.xml",
            "http://rss.nytimes.com/services/xml/rss/nyt/US.xml",
            "http://rss.nytimes.com/services/xml/rss/nyt/Business.xml",
            "http://rss.nytimes.com/services/xml/rss/nyt/Technology.xml",
            "http://rss.nytimes.com/services/xml/rss/nyt/Sports.xml",
            "http://rss.nytimes.com/services/xml/rss/nyt/Science.xml",
            "http://rss.nytimes.com/services/xml/rss/nyt/Health.xml"
    };





    public static ArrayList<CategoryInfo> create(String company){
        ArrayList<CategoryInfo> result = new ArrayList<>();
        switch (company){
            case COMPANY_JOSUN:
                for(int i = 0; i< JOSUN_TITLE.length; i++) {
                    CategoryInfo ci = new CategoryInfo(JOSUN_TITLE[i], JOSUN_URL[i],"UTF-8");
                    result.add(ci);
                }
                break;
            case COMPANY_JOONGANG:
                for(int i = 0; i< JUNG_TITLE.length; i++){
                    CategoryInfo ci = new CategoryInfo(JUNG_TITLE[i], JUNG_URL[i],"UTF-8");
                    result.add(ci);
                }
                break;
            case COMPANY_DONGA:
                for(int i = 0; i< DONGA_TITLE.length; i++) {
                    CategoryInfo ci = new CategoryInfo(DONGA_TITLE[i], DONGA_URL[i],"UTF-8");
                    result.add(ci);
                }
                break;
            case COMPANY_HAN:
                for(int i = 0; i< HAN_TITLE.length; i++) {
                    CategoryInfo ci = new CategoryInfo(HAN_TITLE[i], HAN_URL[i],"EUC-KR");
                    result.add(ci);
                }
                break;
            case COMPANY_MK:
                for(int i = 0; i< MK_TITLE.length; i++) {
                    CategoryInfo ci = new CategoryInfo(MK_TITLE[i], MK_URL[i],"EUC-KR");
                    result.add(ci);
                }
                break;
            case COMPANY_SBS:
                for(int i = 0; i< SBS_TITLE.length; i++) {
                    CategoryInfo ci = new CategoryInfo(SBS_TITLE[i], SBS_URL[i],"UTF-8");
                    result.add(ci);
                }
                break;
            case COMPANY_MBC:
                for(int i = 0; i< MBC_TITLE.length; i++) {
                    CategoryInfo ci = new CategoryInfo(MBC_TITLE[i], MBC_URL[i],"EUC-KR");
                    result.add(ci);
                }
                break;
            case COMPANY_CNN:
                for(int i = 0; i< CNN_TITLE.length; i++) {
                    CategoryInfo ci = new CategoryInfo(CNN_TITLE[i], CNN_URL[i],"UTF-8");
                    result.add(ci);
                }
                break;
            case COMPANY_NY:
                for(int i = 0; i< NY_TITLE.length; i++) {
                    CategoryInfo ci = new CategoryInfo(NY_TITLE[i], NY_URL[i],"UTF-8");
                    result.add(ci);
                }
                break;

        }
        return result;
    }

}
