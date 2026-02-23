import java.sql.*;

public class TransectionDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/spring_fist";
    private static final String USER = "root";
    private static final String PASSWORD = "Password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)){
            System.out.println("Connected to the Database!");

            // TURNED OFF AUTO COMMIT == NO AUTO SAVE
            con.setAutoCommit(false);

            try {
                // order, order_items
                // INSERT INTO ORDER
                int orderId = insertOrder(con, 101, "Alice01", 2000.0);

                // INSERT INTO ORDER ITEM
                insertOrderItem(con, orderId, "Laptop01", 1, 2000.0);

                // MANUAL COMMIT
                con.commit();
                System.out.println("Transaction Committed Successfully");
            } catch (Exception e) {
                e.printStackTrace();
                con.rollback();
                System.out.println("Operation rollback successfully");
            } finally {
                con.setAutoCommit(true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertOrderItem(Connection con, int orderId, String productName, int quantity, double price) {
        String sql = "INSERT INTO order_itms(order_id, product_name, quantity, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            stmt.setString(2, productName);
            stmt.setInt(3, quantity);
            stmt.setDouble(4, price);

//            int x = 10/0;

            int rows = stmt.executeUpdate();
            System.out.println("INSERTED into order_items: " + rows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int insertOrder(Connection con, int customerId, String customerName, double price) {
        String sql = "INSERT INTO orders(user_id, customer_name, total_amount) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1,customerId);
            stmt.setString(2,customerName);
            stmt.setDouble(3,price);

            int rows = stmt.executeUpdate();
            System.out.println("INSERTED into orders: " + rows);

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int orderId = rs.getInt(1);
                    System.out.println("ORDER ID: " + orderId);
                    return orderId;
                } else {
                    throw new SQLException("Order ID not generated");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
