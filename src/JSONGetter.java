import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class JSONGetter extends Thread {

    private String jsonData;

    public static String url = "https://api.upcdatabase.org/product/0111222333446?apikey=098f6bc22621d_demo_4de4e8326b4f6";

    public String getJson() {
        return jsonData;
    }

    private String readData(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cr;
        while ((cr = rd.read()) != -1)
        {
            sb.append((char) cr);
        }

        return sb.toString();
    }

    public String ConnectAndGetData()
    {
        this.jsonData = null;
        try(InputStream is = new URL(url).openStream())
        {
            try(BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8"))))
            {
                this.jsonData = readData(br);
            }
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }

        return this.jsonData;
    }

    @Override
    public void run() {
        ConnectAndGetData();
        super.run();
    }

}