package Tool;

import Spider.BuildUrl;
import dao.StationDao;
import dao.UrlDao;
import po.Station;
import po.Url;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tangshilong on 2017/5/15.
 */
public class ThreadBuildUrl extends Thread {
    private int num;

    public ThreadBuildUrl(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        //2012 2016
        Set set1 = new HashSet();
        set1.add(1);
        set1.add(3);
        set1.add(5);
        set1.add(7);
        set1.add(8);
        set1.add(10);
        set1.add(12);
        Set set2 = new HashSet();
        set2.add(4);
        set2.add(6);
        set2.add(9);
        set2.add(11);

        for (int i = 1; i <= 194; i++) {
            if (i % BuildUrl.MAX_THREAD == num) {
                //根据id获取station
                try {
                    List<Station> stations = StationDao.getStationById(i);
                    //生成日期
                    for (int j = 2007; j < 2017; j++) {
                        for (Integer k = 1; k <= 12; k++) {
                            Integer t = 2;
                            if (k == t) {
                                int n = 28;
                                if ((j == 2012)||(j == 2016)) n = 29;
                                for (int m = 1; m <= n; m++) {
                                    buildUrl(stations, j, k, m);
                                }
                            } else if (set1.contains(k)) {
                                for (int m = 1; m <= 31; m++) {
                                    buildUrl(stations, j, k, m);
                                }
                            } else if(set2.contains(k)){
                                for (int m = 1; m <= 30; m++) {
                                    buildUrl(stations, j, k, m);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("++++++++++++++++++++++++" + i);
                    e.printStackTrace();
                }
            }
        }


    }

    private static void buildUrl(List<Station> stations, int j, Integer k, int m) {
        String date = j + "/" + k + "/" + m;
        String url = "https://www.wunderground.com/history/station/" + stations.get(0).getNum() + "/" + date + "/DailyHistory.html?format=1";
        try {
            UrlDao.saveUrl(new Url(url, 0));
            System.out.println(url);
        } catch (Exception e) {
            System.out.println("++++" + url);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Set set1 = new HashSet();
        set1.add(1);
        set1.add(3);
        set1.add(5);
        set1.add(7);
        set1.add(8);
        set1.add(10);
        set1.add(12);
        boolean contains = set1.contains(1);
        System.out.println(contains);

        Integer t =12;
        Integer t2 = 2;
        System.out.println(t<=12);
    }
}

