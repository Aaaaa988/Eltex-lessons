package ru.kiselev;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpVersion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import java.util.Arrays;


public class UserController {
    private ObservableList<User> usersData = FXCollections.observableArrayList();

    @FXML
    private TableView<User> tableUsers;
    @FXML
    private TableColumn<User, Integer> idCol;
    @FXML
    private TableColumn<User, String> fioCol;
    @FXML
    private TableColumn<User, String> phoneCol;
    @FXML
    private void initialize() {
        initData();
        idCol.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        fioCol.setCellValueFactory(new PropertyValueFactory<User, String>("fio"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<User, String>("phone"));
        tableUsers.setItems(usersData);
    }

    private void initData() {
        Vertx vertx = Vertx.vertx();
        HttpClientOptions options = new HttpClientOptions().setProtocolVersion(HttpVersion.HTTP_2).setSsl(true).setUseAlpn(true).setTrustAll(true);
        HttpClient client = vertx.createHttpClient(options);
        client.requestAbs(HttpMethod.GET, "http://localhost:1050/get_users",
                result -> {
                    System.out.println(result.statusCode());
                    result.bodyHandler(body -> {
                        System.out.println(body.toString());
                        ObjectMapper mapper = new ObjectMapper();
                        User [] users;
                        try {
                            users = mapper.readValue(body.toString(), User[].class);
                            usersData.addAll(Arrays.asList(users));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }).end();
    }
}
