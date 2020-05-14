/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.covid19.model;

import com.covid19.connect.Connect;
import com.covid19.dao.DaerahDao;
import com.covid19.entitas.Daerah;
import com.covid19.error.DaerahException;
import com.covid19.listener.DaerahListener;

/**
 *
 * @author andra
 */
public class DaerahModel {
    private Integer id,odp,pdp,positif;
    private String nama, status;
    private DaerahListener listener;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        fireOnChange();
    }

    public Integer getOdp() {
        return odp;
    }

    public void setOdp(Integer odp) {
        this.odp = odp;
        fireOnChange();
    }

    public Integer getPdp() {
        return pdp;
    }

    public void setPdp(Integer pdp) {
        this.pdp = pdp;
        fireOnChange();
    }

    public Integer getPositif() {
        return positif;
    }

    public void setPositif(Integer positif) {
        this.positif = positif;
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public DaerahListener getListener() {
        return listener;
    }

    public void setListener(DaerahListener listener) {
        this.listener = listener;
    }
        
    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Daerah d) {
        if (listener != null) {
            listener.onInsert(d);
        }
    }

    protected void fireOnUpdate(Daerah d) {
        if (listener != null) {
            listener.onUpdate(d);
        }
    }

    protected void fireOnDelete() {

        if (listener != null) {
            listener.onDelete();
        }
    }
    
    public void reset(){
        setId(null);
        setNama("");
        setOdp(0);
        setPdp(0);
        setPositif(0);
        setStatus("");
    }
    
    public void insertDaerah() throws DaerahException{
        DaerahDao dao = Connect.getDaerahDao();
        
        Daerah d = new Daerah();
        d.setNama(nama);
        d.setOdp(odp);
        d.setPdp(pdp);
        d.setPositif(positif);
        d.setStatus(status);
        
        dao.insertDaerah(d);
        fireOnUpdate(d);
    }
    
    public void updateDaerah() throws DaerahException{
        DaerahDao dao = Connect.getDaerahDao();
        
        Daerah d = new Daerah();
        d.setId(id);
        d.setNama(nama);
        d.setOdp(odp);
        d.setPdp(pdp);
        d.setPositif(positif);
        d.setStatus(status);
        
        dao.updateDaerah(d);
        fireOnUpdate(d);
    }
}
