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
public class Manager extends User{
    @Getter @Setter
    protected Integer id;
    @Getter @Setter
    protected String name;
    @Getter @Setter
    protected String phone;
    @Getter @Setter
    private ArrayList<Sale> product;


    public String ProductString(){
        String string = "Продал: { ";

        for (Sale i: product){
            string += i.getProductName() + " стоимостью: " + i.getProductPrice() + " ";
        }

        return string+"}";
    }

    @Override
    public String toString() {
        return "2"+getId() + " " + getName() + " " + getPhone()+ " " + ProductString();
    }

    public void toDataBase(Statement statement) throws SQLException {

        Integer exist = statement.executeUpdate("INSERT IGNORE INTO Managers(id, name, phone) " +
                "VALUE('"+ 2 + this.id +"', '"+this.name+"','"+this.phone+"')");
        int index_sale = 0;
        ResultSet resultSet = null;
        if(exist == 1) {
            for(int i = 0; i<product.size(); i++) {
                statement.executeUpdate("INSERT IGNORE INTO Sale(sale,cost) VALUE('" + product.get(i).getProductName() + "','" + product.get(i).getProductPrice() + "')");
                resultSet = statement.executeQuery("SELECT id_sale FROM Sale WHERE sale = '" + product.get(i).getProductName() + "' AND cost = '"+product.get(i).getProductPrice()+"'");
                if (resultSet.next()) {
                    index_sale = resultSet.getInt(1);
                }
                if (index_sale > 0) {
                    statement.executeUpdate("INSERT IGNORE INTO Man_and_Sale(id_man, id_sale) " +
                            "VALUE('" + 2 + this.id + "', '" + index_sale + "')");
                }
            }
        }

    }
}
