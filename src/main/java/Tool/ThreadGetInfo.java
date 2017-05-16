package Tool;

import com.xiechanglei.code.utils.http.HttpRequest;
import com.xiechanglei.code.utils.http.HttpResponse;
import com.xiechanglei.code.utils.http.HttpUtil;
import com.xiechanglei.code.web.page.catcher.CatchHandler;
import com.xiechanglei.code.web.page.catcher.Resolver;
import dao.InfoDao;
import dao.StationDao;
import dao.UrlDao;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import po.Info;
import po.Station;
import po.Url;
import util.CookieUtil;

import java.util.List;


/**
 * Created by tangshilong on 2017/5/15.
 */
public class ThreadGetInfo implements Runnable {
    private int num;

    public ThreadGetInfo(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        try {
            List<Url> list = UrlDao.getUrlByNum(num);
            for (Url url : list) {
                System.out.println(url.getId());
                HttpRequest requestInfo = getHttpRequest();
                HttpResponse responseInfo;
                try {
                    responseInfo = HttpUtil.get(url.getUrl(), requestInfo);
                    CatchHandler.parse(responseInfo.getContent(), new Resolver() {
                        @Override
                        public void success() {
                            //生成date
                            String[] splits = url.getUrl().split("/");
                            String date = splits[6] + "/" + splits[7] + "/" + splits[8];
                            //获取station
                            String stationNum = splits[5];
                            try {
                                List<Station> stations = StationDao.getStationByNum(stationNum);
                                Elements elements = $("body").getElements();
                                for (Element element : elements) {
                                    String html = element.html();
                                    if(html==null||"".equals(html)){
                                        continue;
                                    }
                                    String[] strings = html.split("<br>");
                                    for (int i = 1; i < strings.length; i++) {
                                        String[] infos = strings[i].split(",");
                                        if (infos.length<14) {
                                            break;
                                        }
                                        Info info = new Info(stations.get(0).getNum(), stations.get(0).getStationName(), date, infos[0], infos[1], infos[3], infos[4], infos[5], infos[6], infos[7], infos[11], infos[12], infos[13]);
                                        try {
                                            InfoDao.saveInfo(info);
                                        } catch (Exception e) {
                                            System.out.println("信息存储出错");
                                            e.printStackTrace();
                                        }
                                        try {
                                            UrlDao.updateFlag(url.getId());
                                        } catch (Exception e) {
                                            System.out.println("更新url状态出错");
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("获取stationNum出错");
                                e.printStackTrace();
                            }
                        }

                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("获取url列表失败");
            e.printStackTrace();
        }
    }

    public static HttpRequest getHttpRequest() {
        HttpRequest requestInfo = HttpRequest.createDefaultRequestInfo();
        requestInfo.setCookies(CookieUtil.getCookie());
        requestInfo.setCharset("utf-8");
        requestInfo.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        requestInfo.addHeader("accept-language", "zh-CN,zh;q=0.8");
        return requestInfo;
    }

    public static void main(String[] args) throws Exception {

        //String[] strings = "https://www.wunderground.com/history/station/52955/2007/1/1/DailyHistory.html?format=1".split("/");
        //for (int i = 0; i < strings.length; i++) {
        //    System.out.println(i+"-----"+strings[i]);
        //}
//https://www.wunderground.com/history/station/52884/2007/1/1/DailyHistory.html?format=1
        List<Url> urlByNum = UrlDao.getUrlByNum(1);
        for (Url url :urlByNum){
            System.out.println(url);
        }
    }
}
