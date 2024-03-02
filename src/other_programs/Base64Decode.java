package other_programs;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Base64Decode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String decodedString = "eyJjdXN0b21lckFjY291bnRJZCI6IjUxNjExMTY2Nzk2NTA2NzQ3NzciLCJpc0xvZ2dlZEluIjp0cnVlfQ%253D%253D";
        decodedString = URLDecoder.decode(decodedString, "UTF-8");
        byte[] decodedBytes = Base64.getDecoder().decode(URLDecoder.decode(decodedString, "UTF-8"));
        String jsonString = new String(decodedBytes);
        System.out.println(jsonString);
    }
}

class DomainTest {
    public static void main(String[] args) {
        Map<String, String> val = new HashMap<>();

        val.put("mm", "vv");
        val.put("kj", "dd");
        val.put("dd", "dd");
        val.put("tt", "dd");
        System.out.println(val.keySet());
    }
}

class HeadingTest {
    public static void main(String[] args) {
        String text = "<h4 style=\"margin-bottom: 16px;\">If you change your mind</h4><p>You have <b>14 days</b> to change your mind. <b>See our <a href=\"https://www.o2.co.uk/help/phones-sims-and-devices/our-returns-and-repairs-policy#qs\">return policy</a> for details.</b></p>";
        int headingOpen = text.indexOf("<h4 style=\"margin-bottom: 16px;\">");
        int headingClose = text.indexOf("</h4>");
        StringBuilder str = new StringBuilder(text);
        if (headingOpen != -1) {
            str.insert(headingOpen, "<br>");
            //text = text.substring(headingOpen, headingOpen) + "<br>";
        }
        System.out.println(str);
    }
}