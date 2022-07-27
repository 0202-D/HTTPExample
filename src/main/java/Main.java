import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author Dm.Petrov
 * DATE: 27.07.2022
 */
public class Main {
    private static final String REMOTE_SERVICE_URI = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        CloseableHttpClient httpClient = getCloseableHttpClient();
        HttpGet request = new HttpGet(REMOTE_SERVICE_URI);
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            List<Post> list = objectMapper.readValue(response.getEntity().getContent(),
                    new TypeReference<>() {
                    });
            list.stream().filter(el -> el.getUpvotes() > 0).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static CloseableHttpClient getCloseableHttpClient() {
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();
    }
}
