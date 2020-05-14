/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.covid19.daoimplements;

import com.covid19.dao.DaerahDao;
import com.covid19.entitas.Daerah;
import com.covid19.error.DaerahException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andra
 */
public class DaerahDaoImplement implements DaerahDao{
    private Connection conn;
    private final String insertDaerah = "INSERT INTO daerah"+"(nama,odp,pdp,positif,status) VALUES "+"(?,?,?,?,?)";
    private final String updateDaerah = "UPDATE daerah SET nama=?,odp=?,pdp=?,positif=?,status=? WHERE id=?";
    private final String getAllDaerah = "SELECT * FROM daerah";
    private final String getDaerahZonaHijau = "SELECT * FROM daerah WHERE status='Zona Hijau'";
    private final String getDaerahZonaMerah = "SELECT * FROM daerah WHERE status='Zona Merah'";

    public DaerahDaoImplement(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void insertDaerah(Daerah d) throws DaerahException {
        PreparedStatement stmt=null;
        try{
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(insertDaerah, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, d.getNama());
            stmt.setInt(2, d.getOdp());
            stmt.setInt(3, d.getPdp());
            stmt.setInt(4, d.getPositif());
            stmt.setString(5, d.getStatus());
            stmt.executeUpdate();
            
            ResultSet result = stmt.getGeneratedKeys();
            if(result.next()){
                d.setId(result.getInt(1));
            }
            conn.commit();
        }catch(SQLException ux){
            try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            throw new DaerahException(ux.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(stmt!=null){
               try{
                 stmt.close();  
               }catch(SQLException x){
                   
               }
            }
        }
    }

    @Override
    public void updateDaerah(Daerah d) throws DaerahException {
        PreparedStatement stmt=null;
        try{
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(updateDaerah, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, d.getNama());
            stmt.setInt(2, d.getOdp());
            stmt.setInt(3, d.getPdp());
            stmt.setInt(4, d.getPositif());
            stmt.setString(5, d.getStatus());
            stmt.setInt(6, d.getId());
            stmt.executeUpdate();
            conn.commit();
        }catch(SQLException ux){
            try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            throw new DaerahException(ux.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(stmt!=null){
               try{
                 stmt.close();  
               }catch(SQLException x){
                   
               }
            }
        }
    }

    @Override
    public List<Daerah> getZonaHijau() throws DaerahException {
        Statement stmt=null;
        List<Daerah> list = new ArrayList<Daerah>();
        try{
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(getDaerahZonaHijau);
            while(result.next()){
                Daerah d = new Daerah();
                d.setId(result.getInt("id"));
                d.setNama(result.getString("nama"));
                d.setOdp(result.getInt("odp"));
                d.setPdp(result.getInt("pdp"));
                d.setPositif(result.getInt("positif"));
                d.setStatus(result.getString("status"));
                
                list.add(d);
            }
            return list;
        }catch(SQLException ux){
            throw new DaerahException(ux.getMessage());
        }finally{
            if(stmt!=null){
               try{
                 stmt.close();  
               }catch(SQLException x){
                   
               }
            }
        }
    }

    @Override
    public List<Daerah> getZonaMerah() throws DaerahException {
        Statement stmt=null;
        List<Daerah> list = new ArrayList<Daerah>();
        try{
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(getDaerahZonaMerah);
            while(result.next()){
                Daerah d = new Daerah();
                d.setId(result.getInt("id"));
                d.setNama(result.getString("nama"));
                d.setOdp(result.getInt("odp"));
                d.setPdp(result.getInt("pdp"));
                d.setPositif(result.getInt("positif"));
                d.setStatus(result.getString("status"));
                
                list.add(d);
            }
            return list;
        }catch(SQLException ux){
            throw new DaerahException(ux.getMessage());
        }finally{
            if(stmt!=null){
               try{
                 stmt.close();  
               }catch(SQLException x){
                   
               }
            }
        }
    }
    
    @Override
    public List<Daerah> getAllDaerah() throws DaerahException {
        Statement stmt=null;
        List<Daerah> list = new ArrayList<Daerah>();
        try{
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(getAllDaerah);
            while(result.next()){
                Daerah d = new Daerah();
                d.setId(result.getInt("id"));
                d.setNama(result.getString("nama"));
                d.setOdp(result.getInt("odp"));
                d.setPdp(result.getInt("pdp"));
                d.setPositif(result.getInt("positif"));
                d.setStatus(result.getString("status"));
                
                list.add(d);
            }
            return list;
        }catch(SQLException ux){
            throw new DaerahException(ux.getMessage());
        }finally{
            if(stmt!=null){
               try{
                 stmt.close();  
               }catch(SQLException x){
                   
               }
            }
        }
    }
    
}
