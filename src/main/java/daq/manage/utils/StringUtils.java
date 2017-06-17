package daq.manage.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

	private static String[] splitWorker(String str, char separatorChar, boolean preserveAllTokens) {
		if (str == null) {
			return null;
		} else {
			int len = str.length();
			if (len == 0) {
				return new String[0];
			} else {
				List<String> list = new ArrayList();
				int i = 0;
				int start = 0;
				boolean match = false;
				boolean lastMatch = false;

				while (true) {
					while (i < len) {
						if (str.charAt(i) == separatorChar) {
							if (match || preserveAllTokens) {
								list.add(str.substring(start, i));
								match = false;
								lastMatch = true;
							}

							++i;
							start = i;
						} else {
							lastMatch = false;
							match = true;
							++i;
						}
					}

					if (match || preserveAllTokens && lastMatch) {
						list.add(str.substring(start, i));
					}

					return (String[]) list.toArray(new String[list.size()]);
				}
			}
		}
	}

	public static String[] split(String str, char separatorChar) {
		return splitWorker(str, separatorChar, false);
	}
	
	 public static boolean isEmpty(String str)
	  {
	    if (str == null)
	      return true;

	    return (str.trim().equals(""));
	  }
}
