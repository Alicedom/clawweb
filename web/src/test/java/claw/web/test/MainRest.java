package claw.web.test;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class MainRest {
    public static void main(String[] args) {
        try {
            String content = "{'title': 'This is a post','content_raw': 'This is some content'}";
            URL url = new URL("http://localhost:9000/wordpress/wp-json/wp/v2/posts/1");

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString("admin:admin".getBytes(StandardCharsets.UTF_8)));
            conn.setRequestProperty("Content-Length", String.valueOf(content.getBytes("UTF-8").length));
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(content);
            wr.flush();
            wr.close();

            System.out.printf("Response: %d %sn", conn.getResponseCode(), conn.getResponseMessage());
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String input;

            while ((input = br.readLine()) != null) {
                System.out.println(input);
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}