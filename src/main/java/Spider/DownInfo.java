package Spider;

import Tool.ThreadGetInfo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tangshilong on 2017/5/16.
 */
public class DownInfo {
    public static final int MAX_THREAD = 50;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(MAX_THREAD);
        for (int i = 0; i < MAX_THREAD; i++) {
            pool.execute(new ThreadGetInfo(i));
        }
    }
}
