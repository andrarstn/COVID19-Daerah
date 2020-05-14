/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.covid19.controller;

import com.covid19.model.DaerahModel;
import com.covid19.view.DaerahView;
import javax.swing.JOptionPane;

/**
 *
 * @author andra
 */
public class DaerahController {
    private DaerahModel model;

    public void setModel(DaerahModel model) {
        this.model = model;
    }
    
    public void reset(DaerahView view){
        model.reset();
    }
    
    public void insertDaerah(DaerahView view){
        String status="Zona Hijau";
        String nama = view.getTxtnama().getText();
        Integer odp = Integer.parseInt(view.getTxtodp().getText());
        Integer pdp = Integer.parseInt(view.getTxtpdp().getText());
        Integer positif = Integer.parseInt(view.getTxtpositif().getText());
        if(nama.equals("")){
            JOptionPane.showMessageDialog(view, "Tidak boleh kosong");
        }else {
            if(positif>0){
                status = "Zona Merah";
            }
            model.setNama(nama);
            model.setOdp(odp);
            model.setPdp(pdp);
            model.setPositif(positif);
            model.setStatus(status);
            try {
                model.insertDaerah();
                JOptionPane.showConfirmDialog(view, "Berhasil insert");
                model.reset();
            } catch (Exception e) {
            }
        }
    }
    
    public void updateDaerah(DaerahView view){
        String status="Zona Hijau";
        Integer id = Integer.parseInt(view.getTxtid().getText());
        String nama = view.getTxtnama().getText();
        Integer odp = Integer.parseInt(view.getTxtodp().getText());
        Integer pdp = Integer.parseInt(view.getTxtpdp().getText());
        Integer positif = Integer.parseInt(view.getTxtpositif().getText());
        if(nama.equals("")){
            JOptionPane.showMessageDialog(view, "Tidak boleh kosong");
        }else {
            if(positif>0){
                status = "Zona Merah";
            }
            model.setId(id);
            model.setNama(nama);
            model.setOdp(odp);
            model.setPdp(pdp);
            model.setPositif(positif);
            model.setStatus(status);
            try {
                model.updateDaerah();
                JOptionPane.showMessageDialog(view, "Berhasil update");
                model.reset();
            } catch (Exception e) {
            }
        }
    }
}
