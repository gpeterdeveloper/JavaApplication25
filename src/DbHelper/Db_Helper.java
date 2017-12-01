/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbHelper;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
* @author Peter Foster Gartzke <gpeterdeveloper@gmail.com>
 */
public class Db_Helper {
  Connection conn;// class wide database connection
    Statement stat2;

    public Db_Helper() {
       
    }

    /**
     * 
     * @param conn database connection
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Db_Helper(Connection conn) throws SQLException, IOException, ClassNotFoundException {
        this.conn = conn;
        stat2 = conn.createStatement();
        if(stat2 != null){
            try {
                stat2.execute("DROP TABLE Books");//closes database connection
            } catch (SQLException ex) {
                
            }
            
        }
        buildIt();
        
    }
    
   /**
    * Build temporary table
    * @throws IOException
    * @throws ClassNotFoundException
    * @throws SQLException 
    */
    public void buildIt() throws IOException, ClassNotFoundException, SQLException{
        
        
        //stat2 = null;
        //DataBaseConnection.init(args[0]);
    
    try{  // setsup an object of the statment interface by using a method of the Connection object
        stat2 = conn.createStatement();
        //Creates a table
        stat2.executeUpdate("CREATE TABLE Books (BookTitle CHAR(50), AuthorFirstName CHAR(20), AuthorLastName CHAR(20), YearPublished CHAR(4), Publisher CHAR(20), ISBN CHAR(13) )");
   
        //inserts data into the table created
        stat2.executeUpdate("INSERT INTO Books VALUES ('Learning Android Intents','Wajahat','Karim','2014','Packt','9781783289639')");
        stat2.executeUpdate("INSERT INTO Books VALUES ('Mastering Regular Expressions','Jeffrey','Friedl','2002','O_Reilly','9780596002893')");
        stat2.executeUpdate("INSERT INTO Books VALUES ('Introduction to JAVA Programming','Daniel','Liang','2015','Pearson','9780133761313')");
        stat2.executeUpdate("INSERT INTO Books VALUES ('Learn JavaFX 8','Kishori','Sharan','2015','Apress','9781484211434')");
        stat2.executeUpdate("INSERT INTO Books VALUES ('Java Regular Expressions','Mehran','Habibi','2004','Apress','9781590591079')");
        
     }
     catch (SQLException ex) {
                        Logger.getLogger(Db_Helper.class.getName()).log(Level.SEVERE, null, ex);
                    }//end of catch
    }
    
    
    /**
     * Drop table and close connection on exit
     * @throws SQLException 
     */
    public void closeAndDrop() throws SQLException{
        if(stat2 != null)
            stat2.execute("DROP TABLE Books");//closes database connection
        
        conn.close();
    }
    
    
    
    
    
    
    
    
}