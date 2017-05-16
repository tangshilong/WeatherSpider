package Tool;

import com.xiechanglei.code.utils.http.HttpRequest;
import com.xiechanglei.code.utils.http.HttpResponse;
import com.xiechanglei.code.utils.http.HttpUtil;
import com.xiechanglei.code.web.page.catcher.CatchHandler;
import com.xiechanglei.code.web.page.catcher.Resolver;
import dao.StationDao;
import po.Station;

import java.util.List;

/**
 * Created by tangshilong on 2017/5/16.
 */
public class TestUrl {

    public static void main(String[] args) {
        for (int i = 1; i <= 194; i++) {
            try {
                List<Station> stations = StationDao.getStationById(i);
                int id = stations.get(0).getId();
                String num = stations.get(0).getNum();
                String url = "https://www.wunderground.com/global/stations/" + num + ".html";
                System.out.println(url);
                try {
                    HttpRequest requestInfo = ThreadGetInfo.getHttpRequest();
                    HttpResponse responseInfo;
                    responseInfo = HttpUtil.get(url, requestInfo);
                    CatchHandler.parse(responseInfo.getContent(), new Resolver() {

                        @Override
                        public void success() {
                            try {
                                StationDao.updateSelectName(id,"1");
                            } catch (Exception e) {
                                System.out.println("更新selectName失败");
                                e.printStackTrace();
                            }

                        }

                    });
                } catch (Exception e) {
                    System.out.println("url无效");
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}