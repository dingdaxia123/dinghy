package com.dinghy.domain.util;


import com.google.common.base.Strings;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static boolean isBlank(String string) {
        return string == null || string.trim().equals("");
    }

    public static boolean isNotBlank(String string) {
        return !isBlank(string);
    }

    /**
     * 替换指定位置的字符
     *
     * @param index
     * @param res
     * @param str
     * @return
     */
    public static String replaceIndex(int index, String res, String str) {
        return res.substring(0, index) + str + res.substring(index + 1);
    }

    @SuppressWarnings("unchecked")
    public static List<Integer> string2integerList(String value) {
        String[] split = value.split(",");
        @SuppressWarnings("rawtypes")
        List<Integer> list = new ArrayList();
        for (String s : split) {
            list.add(Integer.valueOf(s));
        }
        return list;
    }

    public static List<String> string2stringList(String value) {
        String[] split = value.split(",");
        return Arrays.asList(split);
    }

    @SuppressWarnings("rawtypes")
    public static String list2string(List<?> valueList) {
        StringBuffer buf = new StringBuffer();
        for (Iterator ite = valueList.iterator(); ite.hasNext(); ) {
            buf.append(ite.next());
            if (ite.hasNext()) buf.append(",");
        }
        return buf.toString();
    }

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String cutIfExceed(String original, int length) {
        if (Strings.isNullOrEmpty(original) || original.length() <= length) {
            return original;
        } else {
            return original.substring(0, length);
        }
    }

    public static boolean isBlank(Date date) {
        return date == null;
    }

    public static boolean isBlank(BigDecimal bd) {
        return bd == null || bd.equals("");
    }

    public static boolean isBlank(Long l) {
        return l == null;
    }

    public static boolean isBlank(Double d) {
        return d == null;
    }

    public static String getCurrentDate() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return fmt.format(new Date());
    }

    public static boolean contains(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return false;
        }
        return str.indexOf(searchStr) >= 0;
    }

    /**
     * 邮箱验证
     *
     * @param email 邮箱地址
     * @return 验证结果
     */
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9]+[-|\\_|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9-]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}?$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 返回一格式化的日期
     *
     * @param date java.util.Date
     * @return String yyyy-mm-dd 格式
     */
    public static String formatDate(Date date) {
        DateFormat dateDF = DateFormat.getDateInstance(
                DateFormat.MEDIUM);
        return dateDF.format(date);
    }

    /**
     * 返回一格式化的日期时间
     *
     * @param date Date
     * @return String yyyy-mm-dd hh:ss:mm 格式
     */
    public static String formatDateTime(Date date) {
        DateFormat datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return datetime.format(date);
    }

    /***
     * 两个日期相差多少秒
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getTimeDelta(Date date1, Date date2) {
        long timeDelta = (date1.getTime() - date2.getTime()) / 1000;//单位是秒
        int secondsDelta = timeDelta > 0 ? (int) timeDelta : (int) Math.abs(timeDelta);
        return secondsDelta;
    }

    /**
     * 验证时间是否在10分钟之内 大于10为true 小于10为false
     *
     * @param sendDate
     * @param now
     * @return
     */
    public static boolean compareTime(Date sendDate, Date now) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String systemTime = sdf.format(sendDate).toString();
            String compareTime = sdf.format(now).toString();
            Date begin;
            Date end;
            begin = sdf.parse(systemTime);
            end = sdf.parse(compareTime);

            long between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒

            long day = between / (24 * 3600);
            long hour = between % (24 * 3600) / 3600;
            long minute = between % 3600 / 60;
            return !((hour == 0) && (day == 0) && (minute < 10));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static String getFixLenthString(int strLength) {

        Random rm = new Random();

        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);

        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);

        String random = fixLenthString.substring(2, strLength + 2);

        if (random.length() > 0 && "0".equals(random.substring(0, 1))) {
            return getFixLenthString(strLength);
        } else {
            // 返回固定的长度的随机数
            return random;
        }
    }

    /**
     * 手机号码验证
     *
     * @param mobile 手机号码
     * @return 验证结果
     */
    public static boolean isMobile(String mobile) {
        String regular = "1[3,4,5,8,7]{1}\\d{9}";
        Pattern pattern = Pattern.compile(regular);
        boolean flag = false;
        if (isNotBlank(mobile)) {
            Matcher matcher = pattern.matcher(mobile);
            flag = matcher.matches();
        }
        return flag;
    }

    public static String getRoundNumber() {
        return String.valueOf(Math.round(Math.random() * 100000 + 99999));
    }

    public static boolean isContainChinese(String str) {

        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public static boolean verifyPassword(String password) {
        if (password.length() < 8 || password.length() > 20) {
            return false;
        }
        int a = 0;
        int b = 0;
        int c = 0;
        Pattern pattern1 = Pattern.compile("[a-z]*");
        Pattern pattern2 = Pattern.compile("[A-Z]*");
        Pattern pattern3 = Pattern.compile("[0-9]*");

        Matcher matcher1;
        Matcher matcher2;
        Matcher matcher3;

        for (int i = 0; i < password.length(); i++) {
            String index = String.valueOf(password.charAt(i));
            matcher1 = pattern1.matcher(index);
            matcher2 = pattern2.matcher(index);
            matcher3 = pattern3.matcher(index);
            if (matcher1.matches()) {
                a = a + 1;
            }
            if (matcher2.matches()) {
                a = a + 1;
            }
            if (matcher3.matches()) {
                b = b + 1;
            }
            if (index.equals("_")) {
                c = c + 1;
            }
        }
        if ((a > 0 && b > 0) || (a > 0 && c > 0) || (b > 0 && c > 0)) {
            return true;
        } else {
            return false;
        }
    }

    //判断小数点
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
}

