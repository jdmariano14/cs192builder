package querybuilder192;

/**
 *
 * @author MARIANO, J Stephen DV
 * @studentno 2012-78002
 */
public class Helper {

    public static String enclose(String in, String enc1, String enc2) {
        try {
            if (!in.substring(0, enc1.length()).equals(enc1)) {
                in = enc1 + in;
            }
            if (!in.substring(in.length() - enc2.length(), in.length()).equals(enc2)) {
                in = in + enc2;
            }
            return in;
        }
        catch (Exception e) {
            return in;
        }
    }
}
