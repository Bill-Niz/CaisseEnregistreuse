package Model;

import com.mysql.jdbc.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public  class DataModel  {
    
    private String HOST="127.0.0.1";
    private String PORT="3306";
    private String DB = "caisse";
    private String USER="client";
    private String PWD="FRaceKpYcfupYbvL";
    private String URL="jdbc:mysql://";
    private Connection connection;
    
    
    
        
    public DataModel(){
        connect();
    
    }

    DataModel(String string) {
       System.out.println("From : " + string);
      connect();
    }
    /**
     * 
     */
    private void connect(){
        this.setURL();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK!");
            this.connection = DriverManager.getConnection(this.URL, this.USER, this.PWD);
            System.out.println("Connection effective");
        } catch (SQLException ex) {
            Logger.getLogger(DataModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    /**
     * 
     * @param table
     * @return ResultSEt
     */
    public ResultSet getAllDataFromTable(String table){
        ResultSet result = null;
        String query = "SELECT * FROM `"+ table +"` ";
        Statement state ;
        try {
            state = this.connection.createStatement();
            result = state.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(DataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    
    /**
     * 
     * @return 
     */
    public String getHOST() {
        return HOST;
    }
    /**
     * 
     * @param HOST 
     */
    public void setHOST(String HOST) {
        this.HOST = HOST;
    }
    /**
     * 
     * @return Port
     */
    public String getPORT() {
        return PORT;
    }
    /**
     * 
     * @param PORT 
     */
    public void setPORT(String PORT) {
        this.PORT = PORT;
    }
    
    /**
     * 
     * @return url
     */
    public String getURL() {
        return URL;
    }
    /**
     * 
     */
    public void setURL() {
        this.URL += this.HOST + ":" + this.PORT + "/" + this.DB;
    }
    /**
     * 
     * @return Password
     */
    public String getPWD() {
        return PWD;
    }
    /**
     * 
     * @param PWD 
     */
    public void setPWD(String PWD) {
        this.PWD = PWD;
    }
    /**
     * 
     * @return User
     */
    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }
    /**
     * 
     * @return Connection
     */
    public Connection getConnection() {
        return connection;
    }
    /**
     * 
     * @param connection 
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    /**
     * 
     * @return 
     */
    public String getDB() {
        return DB;
    }
    /**
     * 
     * @param DB 
     */
    public void setDB(String DB) {
        this.DB = DB;
    }
    
}