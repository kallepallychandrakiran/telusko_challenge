import java.util.*;
class URLService {
    public static Map<String, String> urlSet = new HashMap<>();
    Random random = new Random();
    public String generateURL(String oUrl) {
        StringBuilder sb = new StringBuilder();
        if(urlSet.containsKey(oUrl)) {
            return urlSet.get(oUrl);
        } else {
            int maxBound = oUrl.length();
            while(sb.length() != 4) {
                int idx = random.nextInt(maxBound);
                char ch = oUrl.charAt(idx);
                if((ch != '.') && (ch != '/') && (ch != '-') && (ch != '_'))
                    sb.append(oUrl.charAt(idx));
            }
            for (int i = 0; i < 5; i++) {
                int idx = random.nextInt(maxBound);
                sb.append(oUrl.charAt(idx));
            }

            String finalUrl = sb.toString();
            urlSet.put(oUrl, finalUrl);
            return finalUrl;
        }
    }
}
public class RandomURL {
    public static void main(String[] args) {
        URLService service = new URLService();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter URL : ");
        String string = sc.next();
        String oUrl = string.substring(8);

        String rUrl = service.generateURL(oUrl);
        System.out.println("Final URL : " + "https://" + rUrl);

    }

}
