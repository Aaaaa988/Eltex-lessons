package ru.kiselev;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpVersion;

public class Main {
    public static void main(String[] args) {
        Vertx vertex = Vertx.vertx();
        HttpClientOptions options = new HttpClientOptions().
                setProtocolVersion(HttpVersion.HTTP_2).
                setSsl(true).
                setUseAlpn(true).
                setTrustAll(true);
        HttpClient client = vertex.createHttpClient(options);
        client.requestAbs(HttpMethod.GET, "https://api.vk.com/method/users.get?user_id=210700286&v=5.52",
                result -> {
                    System.out.println(result.statusCode());
                    result.bodyHandler(body -> {
                        System.out.println(body.toString());
                    });
        }).end();

    }
}
