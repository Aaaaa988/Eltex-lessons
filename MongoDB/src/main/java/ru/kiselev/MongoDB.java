package ru.kiselev;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MongoDB {
    public static void main(String[] args) {
        PropertiesLoad prop = null;
        try {
            prop = new PropertiesLoad();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MongoClient mongoClient = MongoClients.create(prop.getHost());
        MongoDatabase db = mongoClient.getDatabase(prop.getBaseName());
        MongoCollection<Document> collection = db.getCollection(prop.getTable());

        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"Ivan", "900"));
        users.add(new User(2,"Sasha", "600"));
        users.add(new User(3,"Oleg", "300"));

        for(User i: users){
            System.out.println(i.toString());
        }

        List<Document> userList = null;
        for(int i = 0; i<users.size(); i++){
            // создание записи
            Document doc =  new Document("id", users.get(i).getId()).append("name", users.get(i).getName()).append("phone", users.get(i).getPhone());
            collection.insertOne(doc); //
        }
        // получение всех записей
        for (Document cur : collection.find()) {
            System.out.println(cur.toJson());
        }
        //Удаление коллекции после работы программы
        db.getCollection(prop.getTable()).drop();

    }
}
