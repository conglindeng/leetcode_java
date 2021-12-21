package leetcode.easy;

public class DayOfYear_1154 {
    public int dayOfYear(String date) {
        if (date == null || date.length() == 0) {
            return 0;
        }
        String[] split = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        if (month < 1 || month > 12) {
            return 0;
        }
        int day = Integer.parseInt(split[2]);
        if (day < 1 || day > 31) {
            return 0;
        }
        for (int i = 1; i < month; i++) {
            day += getDaysByMonthAndYear(i, year);
        }
        return day;
    }

    private boolean isLeapYear(int year) {
        boolean devide4 = year % 4 == 0;
        boolean devide100 = year % 100 == 0;
        boolean devide400 = year % 400 == 0;
        return (devide4 && !devide100) || devide400;
    }

    private int getDaysByMonthAndYear(int month, int year) {
        //判断月份是否小于8，如果month为2的话，则判定是否是闰年，其他的则通过是否是奇数来进行判定，奇数则为31天，偶数为30天
        if (month < 8) {
            if (month == 2) {
                return isLeapYear(year) ? 29 : 28;
            } else if (month % 2 == 0) {
                return 30;
            } else {
                return 31;
            }
        } else {
            if (month % 2 == 0) {
                return 31;
            } else {
                return 30;
            }
        }
    }
}
