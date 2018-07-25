package claw.web.test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Hashtable;
import java.util.Map;

public class JsoupDownloadFile {
    public static void main(String[] args) throws IOException {
        //Open a URL Stream
        String imageLocation= "http://triethoc.edu.vn/resources/uploaded/TrietHoc/Files/Thuy%E1%BA%BFt%20Duy%20t%C3%A2m%20%C4%90%E1%BB%A9c/georg-wilhelm-friedrich-hegel-3.jpg";
        String outputFolder = "D:\\Download/";
        String name = "banner.jpg";
        Map cookies = new Hashtable();

        Connection.Response resultImageResponse = Jsoup.connect(imageLocation).cookies(cookies).ignoreContentType(true).execute();

// output here
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(new java.io.File(outputFolder + name)));
//BufferedWriter out = new BufferedWriter(new FileWriter(outputFolder + name));
        out.write(resultImageResponse.body());          // resultImageResponse.body() is where the image's contents are.
        out.close();
    }
}
