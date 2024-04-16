import java.sql.*;
import java.util.Scanner;

public class Main {
    static final String DB_Driver = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/ProjectDB";
    static final String DB_name = "postgres";
    static final String DB_password = "7222";

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {
            Class.forName(DB_Driver);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            dbConnection = DriverManager.getConnection(DB_URL, DB_name, DB_password);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    private static void createDBTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE Products("
                + "PRODUCT_ID SERIAL, "
                + "PRODUCT_NAME VARCHAR(50) NOT NULL, "
                + "PRICE DECIMAL(9,2) NOT NULL, "
                + "PRIMARY KEY (PRODUCT_ID) "
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            statement.execute(createTableSQL);
            System.out.println("Table \"Products\" is created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static void insertValues() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String insertDBValues = "INSERT INTO PRODUCTS"
                + "(PRODUCT_NAME, PRICE) "
                + "VALUES "
                + "('Chocolate', 2.45)";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            statement.execute(insertDBValues);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static void selectDBValues() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String selectQuery = "SELECT PRODUCT_NAME, PRICE FROM PRODUCTS";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet res = statement.executeQuery(selectQuery);
            while (res.next()) {
                String productName = res.getString("PRODUCT_NAME");
                String price = res.getString("PRICE");

                System.out.println("Product Name: " + productName);
                System.out.println("Price: " + price);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mainMenu() {
        System.out.println("\n-----------------------------------\n\n" +
                "1) Check your balance\n" +
                "2) Money transaction\n" +
                "3) Exit menu\n\n" +
                "-----------------------------------\n");
        System.out.print("Select operation: ");

        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();

        switch (ch) {
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                System.out.println("Exiting the menu...");
                break;
            }
            default: {
                System.out.println("Enter a correct number.");
                break;
            }
        }
    }

    public static void main(String[] args) {

        mainMenu();
/*
        try {
            createDBTable();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            insertValues();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            selectDBValues();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 */
    }
}