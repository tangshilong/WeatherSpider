package util;

import java.util.HashMap;
import java.util.Map;

public class CookieUtil {
	public static Map<String, String> getCookie() {
		Map<String, String> values = new HashMap<>();
		String cookieString = getCookieString();
		String[] split = cookieString.split("; ");
		for (String string : split) {
			int indexOf = string.indexOf("=");
			String key = string.substring(0, indexOf);
			String value = string.substring(indexOf + 1, string.length());
			values.put(key, value);
		}
		return values;
	}

	public static String getCookieString() {
		return "DT=1494847271:17507:ip-10-226-237-178; Prefs=FAVS:1|WXSN:1|PWSOBS:1|WPHO:1|PHOT:1|RADC:0|RADALL:0|HIST0:NULL|GIFT:1|PHOTOTHUMBS:50|HISTICAO:59758*NULL|; akacd_WU_NextGen=3672300070~rv=52~id=9b0b31f7675a540ae4504d304d8d9428";
	}

	public static void main(String[] args) {
		getCookie();
	}
}
