package com.dinghy.network;

import com.dinghy.domain.util.StringUtils;
//import com.ecpss.gateway.domain.exception.GateWayException;
//import com.ecpss.gateway.domain.utils.StringUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BaseController {

    protected Logger logger = (Logger) LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @ExceptionHandler(Exception.class)
    // 在Controller类中添加该注解方法即可(注意：添加到某个controller，只针对该controller起作用)
    public ModelAndView exceptionHandler(Exception ex) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        logger.error(ex.getMessage(), ex);
        if (ex instanceof NoSuchRequestHandlingMethodException) {
            modelAndView.setViewName("/404");
            return modelAndView;
        }
//        else if (ex instanceof GateWayException) {
//            modelAndView.addObject("errorMessage", ex.getMessage());
//            modelAndView.setViewName("/error");
//            return modelAndView;
//        }
        else {
            modelAndView.addObject("errorMessage", "系统异常");
            modelAndView.setViewName("/500");
            return modelAndView;
        }
    }

    protected String getURL(HttpServletRequest request) {
        String urlref = request.getHeader("Referer");
        if (StringUtils.isNotBlank(urlref)) {
            String a[] = urlref.split("/");
            String url = a[2];
            return url;
        } else {
            return "";
        }
    }

    protected String getIpAddr(HttpServletRequest request) {
        Enumeration<?> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println(key + ":" + value);
        }
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // System.out.println("ip----------------"+ip);
        return ip;
    }

    public static String base64read(String base64xml) throws Exception {
//        return new String(Base64.getDecoder().decode(base64xml.replace(" ", "+").replace("\n","")),"UTF-8");
        Base64 base64 = new Base64();
        return new String(base64.decode(base64xml.replace(" ", "+").replace("\n","").getBytes("UTF-8")));
//        return new String(Base64.decode(base64xml.getBytes("UTF-8")));
    }

    public static String base64encode(String src) throws UnsupportedEncodingException {
//        return new String(Base64.getEncoder().encode(src.getBytes("UTF-8")));
//        return new String(Base64.encode(src.getBytes("UTF-8")));
        Base64 base64 = new Base64();
        return new String(base64.encode(src.getBytes("UTF-8")));
    }

    public static void main(String args[]) throws Exception {
//        String a ="朱翔";
//        String b = new String(new Base64().encode(a.getBytes("UTF-8")),"UTF-8");
//        System.out.println(b);
//        System.out.println(BaseController.base64read("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGOCIgc3RhbmRhbG9uZT0ieWVzIj8+PHllbWFkYWk+PGFjY291bnROdW1iZXI+MTAwMDAxPC9hY2NvdW50TnVtYmVyPjxub3RpZnlVUkw+aHR0cDovLzE5Mi4xNjguMS40NTo4MDk5L3YxL3dpdGhkcmF3L3dpdGhkcmF3UmV0dXJuLmRvPC9ub3RpZnlVUkw+PHR0PjA8L3R0Pjx0cmFuc2Zlckxpc3Q+PHRyYW5zSWQ+TUJFQVcxNjExMjgxNzIwMjUyMTgyNjwvdHJhbnNJZD48YmFua0NvZGU+5bel5ZWG6ZO26KGMPC9iYW5rQ29kZT48cHJvdmljZT7ljJfkuqzluII8L3Byb3ZpY2U+PGNpdHk+5YyX5Lqs5biCPC9jaXR5PjxicmFuY2hOYW1lPueqn+eqv++8n+OAgu+8jO+8n+S4veS4veWnkDwvYnJhbmNoTmFtZT48YWNjb3VudE5hbWU+6Zu35Lqa5pifPC9hY2NvdW50TmFtZT48Y2FyZE5vPjlhOWNjODk0ODAxZGI2ZjU3NjdiNzJhNGE2MjJkZTBkZjlhZTIxYWQ3MDllNjJlNjk1ZWI2ZTBlNjNiYmNhMTE8L2NhcmRObz48YW1vdW50PjEwMDA8L2Ftb3VudD48cmVtYXJrPumrmOminOWAvFtNQkVBVzE2MTEyODE3MjAyNTIxODI2XeaPkOeOsDwvcmVtYXJrPjxzZWN1cmVDb2RlPjFBQjUzN0ZDNzIyOUU4ODJDMkQ2NEYzRTAzMzEyQzM3PC9zZWN1cmVDb2RlPjwvdHJhbnNmZXJMaXN0PjwveWVtYWRhaT4="));
//        System.out.println(new String(a.getBytes("UTF16")));
//        System.out.println(isGarbledCode(new String(a.getBytes("GBK"))));
        String a="PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz48cm9vdCB0eD0i\n" +
                "MTAwMSI+PG1lckNvZGU+NDEyNTE8L21lckNvZGU+PG9yZGVyTnVtYmVyPjEwMDg0\n" +
                "NDM1MjU3ODc8L29yZGVyTnVtYmVyPjxiZWdpblRpbWU+PC9iZWdpblRpbWU+PGVu\n" +
                "ZFRpbWU+PC9lbmRUaW1lPjxwYWdlSW5kZXg+MTwvcGFnZUluZGV4PjxzaWduPkFB\n" +
                "MUM5NEZGREVDQzgwMUQ1MUZGOTIwNEYxNDJCMTZDPC9zaWduPjwvcm9vdD4=";
        System.out.println(BaseController.base64read(a));
    }


    public static boolean isGarbledCode(String strName) {
        if (null == strName || 0 == strName.trim().length()) {
            return true;
        }

        Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
        Matcher m = p.matcher(strName);
        String after = m.replaceAll("");
        String temp = after.replaceAll("\\p{P}", "");
        char[] ch = temp.trim().toCharArray();
        float chLength = ch.length;
        float count = 0;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!Character.isLetterOrDigit(c)) {

                if (!isChinese(c)) {
                    count = count + 1;
                }
            }
        }

        float result = count / chLength;
        if (result > 0.4) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }
}
