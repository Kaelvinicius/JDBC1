package application;

import db.DB;
import db.DbExeption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {
        // Recovering data
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = DB.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery("select * from department");

            while(rs.next()){
                System.out.println(rs.getInt("id") + ", " + rs.getString("name"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
