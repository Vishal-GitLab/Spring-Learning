import java.sql.*;

public class TransactionDemo {

    private static final String URL = "jdbc:mysql://localhost/demo_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Root@12345";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {       // ye try with resources hai 
            System.out.println("Connected to Database");

            // ak order placement ka sinario semulate karne wale hai
            // agar ham relational database ka use karte  hai E-Commerse website ke liye to to ham  2 table ka use karte hai data  ko track karne ke liye
            // 1. Order   -- order me order ki details save ho rhi hai ..jaise kitna disscount applicable tha kya dilevery fees pay ki , kaun sa method use kiya
            // 2. OrderItems -- ordr ko  seprate item me store kar rhe h .. jaise kuch log id ya kuch confirmation ya kuch security add karna

            // ORDER into orderTURNED OFF AUTO COMMIT == NO AUTO SAVE
            conn.setAutoCommit(false);
            try {
                // INSERT INTO ORDER
                int orderId  = insertOrder(conn,101,"Alice",2000.0);

                // INSERT INTO ORDER ITEM
                insertOrderItem(conn,orderId,"Laptop01", 1, 2000.0);

                // agar dono connection khatm hote hai to ye chalega
                // this is manual commit
                conn.commit();
                System.out.println("Transaction Committed Seccusessfully ");

            } catch (Exception e) {        // ha Exception ka use karenge    yha ham SQLException ka use nahi karenge kyunki hme exception yhi find karni hai
                e.printStackTrace();       // agar beech me kahi error aayi to ye catch karega
                conn.rollback();        // pura pura jo operation tha vo roll back ho jayega
                System.out.println("Operation rolledback successfully ");
            }   finally {
              conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertOrderItem(Connection conn, int orderId, String productName, int quantity, double price) {
        String sql = "INSERT INTO order_items(order_id, product_name, quantity, price)" + "  VALUES (?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // (?,?,?)";  ye jo placeholder hai isko ham set karenge
            pstmt.setInt(1,orderId);
            pstmt.setString(2,productName);
            pstmt.setInt(3,quantity);
            pstmt.setDouble(4,price);

            // int x =   10/0;       // ham exception gnerate kar rhe hai taki hme sab kuch sahi se dekhne ko mil jaye

            int rows  = pstmt.executeUpdate();
            System.out.println("INSERTED into order_items: " + rows) ;
            // result ke liye isko use karte hai
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int insertOrder(Connection conn, int customerId, String customerName, double price) {
         String sql =  "INSERT INTO orders(user_id,customer_name,total_amount) " + " VALUES (?,?,?)";          // ?,?,? ye maine place holder lga diye... iska use isliye kar rhe hai ki ham prepared bna rhe hai
       // kyunki9 hame return krana hai ...  orderId ham use karenge isliye ak additional parameter key ka use karenge
         try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
             // (?,?,?)";  ye jo placeholder hai isko ham set karenge
             pstmt.setInt(1,customerId);
             pstmt.setString(2,customerName);
             pstmt.setDouble(3,price);
              int rows  = pstmt.executeUpdate();
             System.out.println("INSERTED into orders: " + rows) ;
             // result ke liye isko use karte hai
             try (ResultSet rs =  pstmt.getGeneratedKeys()) {
                 if (rs.next()) {
                     int orderId =  rs.getInt(1);
                     System.out.println("ORDER ID: " + orderId);
                     return orderId;
                 }  else{     // agar generate nhi huaa to
                     throw new SQLException("Order ID not generated");
                 }
             }
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
    }

    public void changeThings(){

    }
}













