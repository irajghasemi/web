package se.datalayer.guards.utils;

import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Convenient String manipulation class.
 */
public abstract class StringUtil {

    private static Random randomGenerator = new Random();
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Returns true when the passed string equals "true", "yes" or "1". It is case insensitive.
     */
    public static boolean isTrue(String s) {
        if (s == null) {
            return false;
        }

        s = s.trim();

        return "yes".equalsIgnoreCase(s) || "true".equalsIgnoreCase(s) || "1".equalsIgnoreCase(s);
    }

    /**
     * is the given string a numeric ?
     */
    public static boolean isNumeric(String s) {
        if (s == null) {
            return false;
        }

        try {
            Long.parseLong(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @return true when not null and has at least one char.
     */
    public static boolean hasLength(String s) {
        return s != null && s.trim().length() > 0;
    }

    /**
     * Determine if the passed string is present in the passed String array.
     * @param s the string to look for
     * @param table the String array
     * @return the first occurence's index of the string in this array or -1 if the string could not be found.
     */
    public static int findStringInArray(String s, String[] table) {
        Assert.notNull(s);
        Assert.notNull(table);

        for (int i = 0; i < table.length; i++) {
            if (s.equalsIgnoreCase(table[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * create random int code
     */
    public static String getRandomCode() {
        String value = "" + Math.abs(randomGenerator.nextInt() % 10000);
        value = value.replace('4', 'z');
        value = value.replace('3', 'e');
        value = value.replace('8', 'c');
        return value;
    }

    /**
     * truncate the string to a size limit.
     * @param in
     * @param maxSize
     */
    public static String truncate(String in, int maxSize) {
        if (in != null && in.length() > maxSize) {
            return in.substring(0, maxSize);
        }
        return in;
    }

    /**
     * chunk the string : add "..." at the end of the string if the size is too long.
     *
     * @param in
     * @param maxSize
     */
    public static String chunk(String in, int maxSize) {
        if (in != null && in.length() > 3 && in.length() > maxSize) {
            if (maxSize < 3) {
                return "...";
            }
            return new StringBuilder(in.substring(0, maxSize - 3)).append("...").toString();
        }
        return in;
    }

    /**
     * Convert an array of objects to a list of String.
     * toString() is called on each array's object.
     * @param array the array of object
     * @return a list of string
     */
    public static List<String> asListOfString(Object[] array) {
        List<String> al = new ArrayList<String>(array.length);
        for (Object o : array) {
            al.add(o.toString());
        }

        return al;
    }

    public static String flattenArrayAsString(Object[] objects) {
        if (objects != null) {
            StringBuilder builder = new StringBuilder("");
            for (Object o : objects) {
                if (o != null) {
                    builder.append(o.toString());
                } else {
                    builder.append("null");
                }
                builder.append(",");
            }
            return builder.toString();
        }
        return "";
    }

	public static String getFormattedDate(Date modDate) {
		if(null == modDate) {
			return null;
		}
		return SDF.format(modDate);
	}

	public static String splitByCount(String valueOf, String seporator, int count) {
		if(count <= 0){
			return valueOf;
		}
		int minCount = 6;
		StringBuffer sb = new StringBuffer();
		int length = valueOf.length();
		if(length < minCount) {
			for(int i=0;i<minCount-length;i++) {
				sb.append("0");
			}
			sb.append(valueOf);
			valueOf = sb.toString();
			//Clear stored string.
			sb.delete(0, sb.length());
		}
		
		for(int i=0;i<valueOf.length();i++) {
			sb.append(valueOf.charAt(i));
			//The last condition will avoiding add extra slash.
			if(i >= (count - 1) && (i + 1) % count == 0
					&& i != valueOf.length() -1) {
				sb.append(seporator);
			}
		}
		return sb.toString();
	}

}
                