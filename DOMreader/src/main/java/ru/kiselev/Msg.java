package ru.kiselev;

public class Msg {
    private String msg;

    Msg(String to, String from, String msg){
        this.msg = "to " + to + " from " + from + " message: " + msg;

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
