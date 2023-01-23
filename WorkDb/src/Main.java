import com.mysql.cj.jdbc.CallableStatement;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

//        String username = "root";
//        String password = "root";
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//
//        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MyDb","root","root");
//
//            System.out.println("Sql select");
//            connection.close();
//        } catch (Exception e) {
//            System.out.println("Connection failed");
//        }


        String username = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MyDb","root","root")){
               // System.out.println("Sql select");

              Statement statement = connection.createStatement();

             // statement.executeQuery("SQL SCRIPT");// SELECT ResultSet
             // statement.execute("SQL SCRIPT");// SELECT Bool
             // statement.executeUpdate("SQL SCRIPT");// DROP,CREATE,INSERT,UPDATE,DELETE +


                // statement.executeUpdate("SQL SCRIPT");// DROP,CREATE,INSERT,UPDATE,DELETE

//                String sqlScript = "CREATE TABLE Cars (marka varchar(50),model varchar(50),year int);";
//                int result =  statement.executeUpdate(sqlScript);
//                System.out.println("Created "+result + " table");


//                String sqlScript = "insert INTO Cars (marka,model,year) values ('BMW','X5',2022),('Audi','Q7',2021),('Nissan','Patrol',2020);";
//                int result =  statement.executeUpdate(sqlScript);
//                System.out.println("Inserted "+result + " rows");

//ЗАМЕНИТЬ ВСЕ ГОДА НА 2015 ГДЕ В МАРКЕ ПРИСУТСТВУЕТ БУКВА А
//                String sqlScript = "update Cars set year=2015 where marka LIKE '%a%'";
//                int result =  statement.executeUpdate(sqlScript);
//                System.out.println("Updated "+result + " rows");


                //Удалить ВСЕ машины ГДЕ В МАРКЕ не ПРИСУТСТВУЕТ БУКВА А
//                String sqlScript = "delete from Cars where marka NOT LIKE '%a%'";
//                int result =  statement.executeUpdate(sqlScript);
//                System.out.println("Deleted "+result + " rows");





                String sqlScript = "SELECT * FROM Cars";
                ResultSet resultSet =  statement.executeQuery(sqlScript);

                int count = 1;
               while (resultSet.next()){
                   System.out.print(count++ + ") " + resultSet.getString(1) + "  ");
                   System.out.print(resultSet.getString(2) + "  ");
                   System.out.print(resultSet.getString("model") + "  ");
                   System.out.println(resultSet.getInt(3));
               }

               //         SPEED
                // ORM      -  +   +
                // SCRIPT   +  -   -


//                System.out.println("resultSet.getMetaData(); => " + resultSet.getMetaData().getColumnLabel(1));
//                System.out.println("resultSet.getMetaData(); => " + resultSet.getMetaData().getColumnLabel(2));
//                System.out.println("resultSet.getMetaData(); => " + resultSet.getMetaData().getColumnLabel(3));


                // => 5

//                Statement statement = connection.createStatement();
//               ResultSet resultSet =  statement.executeQuery("SELECT * FROM Persons");
//
//               while (resultSet.next()){
//                   System.out.println(resultSet.getString(1));
//                   System.out.println(resultSet.getString(2));
//                   System.out.println(resultSet.getInt(3));
//               }

//                Scanner scanner = new Scanner(System.in);
//                System.out.print("Enter marka : ");//Audi
//                String one = scanner.nextLine();
//                System.out.print("Enter model : ");//Q7
//                String two = scanner.nextLine();
//                System.out.print("Enter year : ");//2022
//                int three = scanner.nextInt();
//
//               // String sqlScript = "insert INTO Cars (marka,year,model) values ('"+one+"',"+three+",'"+two+"')";
//               String sqlScript = "insert INTO Cars (marka,year,model) values ("+one+","+three+","+two+")";
//                System.out.println("sqlScript => " + sqlScript);
//                int result =  statement.executeUpdate(sqlScript);
//                System.out.println("Inserted "+result + " rows");


//                String sqlScript = "insert INTO Cars (marka,model,year) values (?,?,?)";
//                PreparedStatement preparedStatement = connection.prepareStatement(sqlScript);
//                preparedStatement.setString(1,one);
//                preparedStatement.setString(2,two);
//                preparedStatement.setInt(3,three);
//
//                int result =   preparedStatement.executeUpdate();
//                System.out.println("sqlScript => " + sqlScript);
//                System.out.println("Inserted "+result + " rows");
            }


        } catch (Exception e) {
            System.out.println("Connection failed + " + e.getMessage());
        }
    }
}