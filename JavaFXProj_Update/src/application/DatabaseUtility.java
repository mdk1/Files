package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseUtility {

    private static Connection con;
    private static final String Driver = "org.sqlite.JDBC";
   //jdbc:sqlite:C:\\Software\\SQL lite\\SQLiteStudio-3.2.1\\SQLiteStudio\\ABCorporationDB
    private static final String ConnectionString = "jdbc:sqlite:C:\\Software\\SQL lite\\SQLiteStudio-3.2.1\\SQLiteStudio\\ABCorporationDB";
    //private static final String user = "username";
    //private static final String pwd = "password";

    /**
     * create Database object
     */
    public DatabaseUtility() {
    }

    /**
     * to load the database base driver
     * @return a database connection
     * @throws SQLException throws an exception if an error occurs
     */
    public static Connection dbConnect() throws SQLException {
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        con = DriverManager.getConnection(ConnectionString);
        return con;
    }

    /**
     * to get a result set of a query
     * @param query custom query
     * @return a result set of custom query
     * @throws SQLException throws an exception if an error occurs
     */
    public static ResultSet dbExecuteQuery(String query) throws SQLException {
        Connection con = dbConnect();
        ResultSet rs;
        PreparedStatement st = con.prepareStatement(query);
        rs = st.executeQuery();

        return rs;
    }
    
    
    
    /**
     * to run an update query such as update, delete
     * @param query custom query
     * @throws SQLException throws an exception if an error occurs
     */
    public static void dbExecuteUpdate(String query) throws SQLException {
        Connection con = dbConnect();
        ResultSet rs;
        PreparedStatement st = con.prepareStatement(query);
        st.executeUpdate();
    }

  //2.4 Close database  Connection
    public static void dbDisconnect() throws SQLException {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception e){
           throw e;
        }
    }


}

   