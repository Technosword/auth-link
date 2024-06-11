package us.tobyschz.authlink.common;

//credit to zeeshaanahmad for shortening function
public class ShortenerUtil {
    private ShortenerUtil() { //utils should never be init

    }

    private static final String alphabet = "1QM0kvswoLhimrlVK2ujU783axRECHyND4ZSzpPdtGqfgY6OFWBXJnbATcIe95";
    private static final int length = alphabet.length();

    /**
     * @param num Base10 number of type Long
     * @return base62 encoded string representation of input Long
     */
    public static String idToStr(Long num) {
        StringBuilder str = new StringBuilder();
        while (num > 0) {
            str.insert(0, alphabet.charAt((int) (num % length)));
            num = num / length;
        }
        return str.toString();
    }

    /**
     * @param str Base62 encoded string
     * @return decoded Base10 number of type Long
     */
    public static Long strToId(String str) {
        Long num = 0L;
        for (int i = 0; i < str.length(); i++) {
            num = num * length + alphabet.indexOf(str.charAt(i));
        }
        return num;
    }

}
