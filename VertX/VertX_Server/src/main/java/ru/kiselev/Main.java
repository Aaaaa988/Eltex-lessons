package ru.kiselev;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.json.JsonObject;

public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40)); // количество обработчиков

        JsonObject object = new JsonObject();
        object.put("user", "boris");
        object.put("phone", "900");

        vertx.createHttpServer().requestHandler(request -> {
            System.out.println(request.uri()); // что было вызвано
            request.response()
                    .putHeader("Content-Type", "application/json")
                    .end(object.toString());
        }).listen(8081);
    }
}
