/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.covid19.connect;

import com.covid19.dao.DaerahDao;
import com.covid19.daoimplements.DaerahDaoImplement;
import com.covid19.error.DaerahException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author andra
 */
public class Connect {
    private static Connection db;
    private static DaerahDao d;
    
    public static Connection getDB(){
        if(db==null){
            try{
                Driver driver = new Driver();
                DriverManager.registerDriver(driver);
                
                String url = "jdbc:mysql://localhost/responsi_pbo";
                String user = "root";
                String pass = "";
                
                db = (Connection) DriverManager.getConnection(url,user,pass);
            }catch(SQLException ex){
            }
        }
        return db;
    }
    
    public static DaerahDao getDaerahDao() throws DaerahException{
        if(d==null){
            d = new DaerahDaoImplement(getDB());
        }
        return d;
    }
}
