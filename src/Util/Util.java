package Util;

import java.text.NumberFormat;
import java.util.Locale;

public class Util {
    Locale formatMoney;
    public static String moneyVND(int money){
        Locale formatMoney = new Locale("vn","VN");
        NumberFormat nf = NumberFormat.getInstance(formatMoney);
        return nf.format(money);
    }
}
