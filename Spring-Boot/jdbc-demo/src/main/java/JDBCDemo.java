import java.sql.*;

public class JDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/demo_db";          //  database kaha locate hai ye btane ke liye url ka use kiya jata hai
    private static final String USER = "root";     // fir ye mention karenge ki kis user se connect krana cah rhe hai
    private static final String PASSWORD = "Root@12345";

    public static void main(String[] args) {
//        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);   // fir mai srround karunga try catch block k sath

        try {         // ye automatically database ko close kar dega
            Connection  conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the Database!");
//            insertStudent(conn, "Alice", "alice@gmail.com");      // ak bar data insert ho gya hai bar bar nhi karte hai
            updateStudent(conn, 1, "Bob","alice@gmail.com");
            selectStudent(conn);
            deleteStudent(conn,1);
         } catch (SQLException e) {
            e.printStackTrace();       // exception ko print karne ke liye use hota hai
        }
    }


    private static void insertStudent(Connection conn, String name, String email) {
        String sql = "INSERT INTO student (name, email) VALUES ('" + name + "','" + email + "')";
        try (Statement stmt = conn.createStatement()) {    // Statement ak interface hai jo ki ak object ko hole karta hai jiske jariye sql statement ko execute kar sakte hai
            int rows = stmt.executeUpdate(sql);
            System.out.println("INSERTED: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //  ham data fetch karke print krayenge  database se

    private static void selectStudent(Connection conn) {
        String sql = "SELECT * FROM student";
        try (Statement stmt = conn.createStatement()) {
          ResultSet resultSet = stmt.executeQuery(sql);      // jo ye resultSet hota h .. jo query me data hai vo  ye resultSet deta hai
            System.out.println("Student List: ");
            while (resultSet.next())   {  // while ka use isliye kiya gua hia ki hamko pta nhi hai ki kitna data hai
                // resultSet boolean return karta hai  ye tabhi return karta hai jab koi additional data  ho tb
                  int id =  resultSet.getInt("id");
                  String name =  resultSet.getString("name");
                  String email =  resultSet.getString("email");
                System.out.println(id +" ; "+ name + " : " + email);
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // updates query
    private static void updateStudent (Connection  conn, int id, String name, String email) {
//        String sql =  "UPDATE student SET name = '" + name + "', email = '" + email + "'WHERE id = " + id;
        String sql =  "UPDATE student SET name = ?, email = ? WHERE id = ?";     // this is playsHolder
        // UPDATE student SET name = 'Alice', email =  'email@gmail.com'
        // WHERE id  = 10;

//        try (Statement stmt = conn.createStatement()) {
        try (PreparedStatement pstmt   = conn.prepareStatement(sql)) {               // PreparedStatement ko much more secure mana jata hai
//            int rows = stmt.executeUpdate(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,email);
            pstmt.setInt(3,id);
            int rows =  pstmt.executeUpdate();
            System.out.println("UPDATED: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // for the delete
    private static void deleteStudent(Connection conn, int id) {
        String sql = "DELETE FROM student WHERE id- = " + id;
        try (Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate(sql);
            System.out.println("DELETED: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


/*
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);           // DriverManager ak class hai jo sab kuch manage karta hai isko help se connection stablish kiya hu
            System.out.println("Connected to the Database!");
        } catch (SQLException e) {
            e.printStackTrace();       // exception ko print karne ke liye use hota hai
         }    finally {    //  jo data hm open karte hai use close bhi krna padta hai
               //  conn.close();      //  fir mai srround karunga try catch block k sath
            try {
                conn.close();
                System.out.println("Connection Closed");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

 */