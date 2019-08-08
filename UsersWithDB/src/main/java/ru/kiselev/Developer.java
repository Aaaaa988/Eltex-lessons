package ru.kiselev;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
public class Developer extends User{
    @Getter @Setter
    protected Integer id;
    @Getter @Setter
    protected String name;
    @Getter @Setter
    protected String phone;
    @Getter @Setter
    ArrayList<String> prog_langs;

    public String Langs_String(){
        String string = "";

        for(int i = 0; i< prog_langs.size(); i++){
            string += prog_langs.get(i)+ " ";
        }

        return string;
    }

    public void addLang(String... args) {
        for (String str : args) {
            prog_langs.add(str);
        }
    }

    @Override
    public String toString() {
        return "1"+getId()+" "+getName()+" "+getPhone() + " Языки: " + getProg_langs();
    }

    public void toDataBase(Statement statement) throws SQLException {

        Integer exist = statement.executeUpdate("INSERT IGNORE INTO Developers(id, name, phone) " +
                "VALUE('"+ 1 + this.id +"', '"+this.name+"','"+this.phone+"')");
        if(exist == 1) {
            for (int i = 0; i < prog_langs.size(); i++) {
                int index_lang = 0;
                ResultSet resultSet = statement.executeQuery("SELECT id_lang FROM Langs WHERE lang = '" + prog_langs.get(i) + "'");
                if (resultSet.next()) {
                    index_lang = resultSet.getInt(1);
                }
                if (index_lang > 0) {
                    statement.executeUpdate("INSERT IGNORE INTO Dev_and_Lang(id_dev, id_lang) " +
                            "VALUE('" + 1 + this.id + "', '" + index_lang + "')");
                }
            }
        }
    }

}
