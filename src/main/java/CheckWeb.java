import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CheckWeb {

    public static void main(String[] args) throws Exception {
        int b = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<String> urlList = new ArrayList<>();
        urlList.add("http://traveluingx-01.uata.lokal/travel/version");
        urlList.add("http://traveluingx-01.uatb.lokal/travel/version");
        urlList.add("http://activityapp-01.uata.lokal:8080/activiti-app/util/version");
        urlList.add("http://traveluingx-01.uata.lokal/travel/version");
        urlList.add("http://activityapp-01.uatb.lokal:8080/activiti-app/util/version");
        urlList.add("http://mobileapiapp-01.uatb.lokal:8080//versions");
        urlList.add("http://mobileapiapp-01.uatb.lokal:8080//versions");
        urlList.add("http://traveluingx-01.uata.lokal/travel/version");
        urlList.add("http://traveluingx-01.uata.lokal/travel/version");
        urlList.add("http://traveluingx-01.uata.lokal/travel/version");
        urlList.add("http://traveluingx-01.uata.lokal/travel/version");
        urlList.add("http://traveluingx-01.uata.lokal/travel/version");
        urlList.add("http://traveluingx-01.uata.lokal/travel/version");
        urlList.add("http://traveluingx-01.uata.lokal/travel/version");
        urlList.add("http://traveluingx-01.uata.lokal/travel/version");
        urlList.add("http://traveluingx-01.uata.lokal/travel/version");
        urlList.add("http://activityapp-01.uata.lokal:8080/activiti-app/util/version");
        urlList.add("http://activityapp-01.uata.lokal:8080/activiti-app/util/version");

        CountDownLatch latch = new CountDownLatch(urlList.size());
        for (int a = 0; a < urlList.size(); a++) {
            int finalA = a;
            executorService.submit(() -> pingURL(urlList.get(finalA), 5000, latch, finalA));
        }
        latch.await();
        System.out.println("FINISHED");
        executorService.shutdown();
    }

    public static boolean pingURL(String url, int timeout, CountDownLatch latch, int position) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            connection.setRequestMethod("HEAD");
            connection.setDoOutput(true);
            int responseCode = connection.getResponseCode();
            System.out.println("ok - " + position);

            String text = new BufferedReader(new InputStreamReader(connection.getInputStream())).lines()
                    .collect(Collectors.joining("\n"));
            System.out.println(text);
            latch.countDown();
            return (200 <= responseCode && responseCode <= 399);
        } catch (IOException exception) {
            System.out.println("no - " + position);
            latch.countDown();
            return false;
        }
    }
}
