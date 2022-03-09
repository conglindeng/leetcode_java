package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            res.append('-');
        }
        long numeratorL = numerator;
        long denominatorL = denominator;
        numeratorL = Math.abs(numeratorL);
        denominatorL = Math.abs(denominatorL);
        //先把正数部分算出来
        res.append(numeratorL / denominatorL);
        numeratorL = numeratorL % denominatorL;
        if (numerator % denominator == 0) {
            return res.toString();
        }
        res.append('.');
        //再做小数的处理
        Map<Long, Integer> idxMap = new HashMap<>();
        int idxCount = res.length();
        numeratorL *= 10;
        while (numeratorL != 0) {
            if (idxMap.containsKey(numeratorL)) {
                res.insert(idxMap.get(numeratorL), "(");
                res.append(")");
                return res.toString();
            }
            idxMap.put(numeratorL, idxCount);
            res.append(numeratorL / denominatorL);
            numeratorL = numeratorL % denominatorL;
            numeratorL *= 10;
            idxCount++;
        }
        return res.toString();
    }
}
