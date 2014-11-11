package javacommon.util;

import javax.servlet.http.HttpServletRequest;

public class JavaScriptExtUtils {
	public static String getExtLibMainPath(HttpServletRequest request) {
		return request.getContextPath() + "/resource/ext1.1";
	}
}
