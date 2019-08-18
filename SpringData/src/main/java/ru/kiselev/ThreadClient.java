package ru.kiselev;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.net.Socket;

import java.util.ArrayList;
import java.util.Scanner;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Setter
@lombok.Getter
public class ThreadClient implements Runnable {

    private Socket socket;
    private UserRepository CrudRepository;

    public void run(){
        InputStream inStream = null;
        try {
            inStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner in = new Scanner(inStream);
        String client_request = in.nextLine();
        String [] arg = client_request.split(" ");
        String [] tokens = arg[1].split("/");
        String output = null;

        if (tokens[1].equals("get_users") && tokens.length == 2) {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<User> users = new ArrayList<>();
            CrudRepository.findAll().forEach(users::add);
            try {
                output = mapper.writeValueAsString(users);
            } catch (IOException e) {
                e.printStackTrace();
            }
            output = "HTTP/1.1 200 OK\n" +
                     "Content-Type:application/json\n" +
                     "\n" + output;
        }

        else if (tokens[1].equals("get_user") && tokens.length > 2) {
            Integer id = Integer.valueOf(tokens[2]);
            ObjectMapper mapper = new ObjectMapper();
            User u = CrudRepository.findById(id).get();
            try {
                output = mapper.writeValueAsString(u);
            } catch (IOException e) {
                e.printStackTrace();
            }
            output = "HTTP/1.1 200 OK\n" +
                     "Content-Type:application/json\n" +
                     "\n" + output;
        }
        else if (tokens[1].equals("index.html") && tokens.length == 2) {
            String path = "src/main/resources/index.html";
            File file = new File(path);
            Scanner sc = null;
            try {
                sc = new Scanner(file).useDelimiter("\0");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String html_page = sc.next();
            output = "HTTP/1.1 200 OK\n" +
                     "Content-Length:" + html_page.length() + "\n" +
                     "\n" + html_page;
        }
        else {
            output = "HTTP/1.1 404";
        }
        OutputStream outStream = null;
        try {
            outStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter out = new PrintWriter(outStream);
        out.write(output);
        out.flush();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
