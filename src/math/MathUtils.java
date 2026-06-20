package math;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class MathUtils {
    private static final Map<Character, Integer> HEX_MAP = new HashMap<>();
    private static final char[] DIGITS = "0123456abcdef".toCharArray();
    static {
        for (int i = 0; i < 10; i++) HEX_MAP.put((char) ('0' + i), i);
        for (int i = 10; i < 16; i++) HEX_MAP.put((char) ('a' + i), i);
        for (int i = 10; i < 16; i++) HEX_MAP.put((char) ('A' + i), i);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Number> T mod(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (T) (Integer.valueOf(((a.intValue() % b.intValue()) + b.intValue()) % b.intValue()));
        } else if (a instanceof Long && b instanceof Long) {
            return (T) (Long.valueOf(((a.longValue() % b.longValue()) + b.longValue()) % b.longValue()));
        } else if (a instanceof BigInteger && b instanceof BigInteger) {
            return (T) ((BigInteger) a).mod((BigInteger) b);
        } else {
            throw new UnsupportedOperationException("Not supported");
        }
    }

    public static Integer gcd(int a, int b) {
        return null;
    }


    public static String numberToBaseString(String num, int toBase) {
        return numberToBaseString(num, null, toBase);
    }

    public static String numberToBaseString(String num, Integer fromBase, int toBase) {
        if (num == null || num.isEmpty()) return null;
        int base  = getBase(num, fromBase);
        boolean isNegative = num.startsWith("-");
        String cleanNum = num.replaceFirst("-", "");
        cleanNum = cleanNum.replaceFirst("0[oxbOXB]", "");
        int decVal = toDecimal(cleanNum, base);
        String result = fromDecimal(decVal, toBase);
        result = switch (toBase) {
            case 2 -> "0b" + result;
            case 8 -> "0o" + result;
            case 16 -> "0x" + result;
            default -> result;
        };
        return isNegative ? "-" + result : result;
    }

    /**
     * Private Helper Functions
     */
    private static int getBase(String num, Integer fromBase) {
        if (num == null) return 0;
        if (fromBase != null) return fromBase;
        if (num.startsWith("0x") || num.startsWith("0X"))
            return 16;
        else if (num.startsWith("0o") || num.startsWith("0O"))
            return 8;
        else if (num.startsWith("0b") || num.startsWith("0B"))
            return 2;
        else
            return 10;

    }

    private static int toDecimal(String num, Integer fromBase) {
        int result = 0;
        for (char c : num.toCharArray()) {
            Integer val;
            val = HEX_MAP.getOrDefault(c, 0);
            if (val == null || val >= fromBase){
                throw new IllegalArgumentException("Invalid digit '" + c + "' for base " + fromBase);
            }
            result = result * fromBase + val;
        }
        return result;
    }

    private static String fromDecimal(int num, int base) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.insert(0, DIGITS[num % base]);
            num /= base;
        }
        if (sb.isEmpty()) sb.append(0);
        return sb.toString();
    }
}
