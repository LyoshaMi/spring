import java.sql.*;

public class MainApp {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) {
        try{
            connect();
            clearTableEx();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void savepointEx() throws SQLException {
        statement.executeUpdate("INSERT INTO students (name, score) VALUES ('Leha1', 100);");
        Savepoint sp1 = connection.setSavepoint();
        statement.executeUpdate("INSERT INTO students (name, score) VALUES ('Leha2', 100);");
        connection.rollback(sp1);
        statement.executeUpdate("INSERT INTO students (name, score) VALUES ('Leha', 100);");
        connection.commit();
    }

    private static void batchEx() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 0; i < 10000; i++){
            preparedStatement.setString(1, "Leha" + (i + 1));
            preparedStatement.setInt(2, 77);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.commit();
    }

    private static void transactionAndPreparedStatementEx() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 0; i < 10000; i++){
            preparedStatement.setString(1, "Leha" + (i + 1));
            preparedStatement.setInt(2, 77);
            preparedStatement.executeUpdate();
        }
        connection.commit();
    }

    private static void clearTableEx() throws SQLException {
        statement.executeUpdate("DELETE FROM students;");
    }

    private static void updateEx() throws SQLException {
        statement.executeUpdate("UPDATE students SET score = 80 WHERE id = 1;");
    }

    private static void insertEx() throws SQLException {
        statement.executeUpdate("INSERT INTO students (name, score) VALUES ('Vasya', 100);");
    }

    private static void selectEx() {
        try (ResultSet rs = statement.executeQuery("SELECT * FROM students;")){
            while (rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getString("score"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?);");
        } catch (ClassNotFoundException |  SQLException e) {
            throw new SQLException("Unable to connect");
        }

    }

    public static void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}