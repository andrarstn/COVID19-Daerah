/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.covid19.entitas;

/**
 *
 * @author andra
 */
public class Daerah {
    private Integer id,odp,pdp,positif;
    private String nama,status;

    public Daerah() {
    }

    public Daerah(Integer odp, Integer pdp, Integer positif, String nama, String status) {
        this.odp = odp;
        this.pdp = pdp;
        this.positif = positif;
        this.nama = nama;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOdp() {
        return odp;
    }

    public void setOdp(Integer odp) {
        this.odp = odp;
    }

    public Integer getPdp() {
        return pdp;
    }

    public void setPdp(Integer pdp) {
        this.pdp = pdp;
    }

    public Integer getPositif() {
        return positif;
    }

    public void setPositif(Integer positif) {
        this.positif = positif;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
