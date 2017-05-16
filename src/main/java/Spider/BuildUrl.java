package Spider;

import Tool.ThreadBuildUrl;

/**
 * Created by tangshilong on 2017/5/16.
 */
public class BuildUrl {
    public static final int MAX_THREAD = 60;

    public static void main(String[] args) {
        for (int i = 0; i < MAX_THREAD; i++) {
            ThreadBuildUrl threadBuildUrl = new ThreadBuildUrl(i);
            threadBuildUrl.start();
        }
    }
}
