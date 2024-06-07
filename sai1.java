import java.sql.*;

class A{
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/db1";
        String user = "root";
        String password = "1234";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM my_table";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String col1Value = resultSet.getString("col1");
                String col2Value = resultSet.getString("col2");
                String col3Value = resultSet.getString("col3");
                System.out.println("Col1: " + col1Value + ", Col2: " + col2Value + ", Col3: " + col3Value);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
