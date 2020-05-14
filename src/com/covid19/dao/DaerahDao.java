/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.covid19.dao;

import com.covid19.entitas.Daerah;
import com.covid19.error.DaerahException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author andra
 */
public interface DaerahDao {
    public void insertDaerah(Daerah d) throws DaerahException;
    public void updateDaerah(Daerah d) throws DaerahException;
    public List<Daerah> getZonaHijau() throws DaerahException;
    public List<Daerah> getZonaMerah() throws DaerahException;
    public List<Daerah> getAllDaerah() throws DaerahException;
}
