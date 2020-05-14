/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.covid19.model;

import com.covid19.entitas.Daerah;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author andra
 */
public class TableDaerahModel extends AbstractTableModel {
    private List<Daerah> list = new ArrayList<Daerah>();
    
    public void setList(List<Daerah> list){
        this.list = list;
    }
    
    public boolean add(Daerah e) {
        try{
            return list.add(e);
        }finally{
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Daerah get(int index) {
        return list.get(index);
    }

    public Daerah set(int index, Daerah element) {
        try {
            return list.set(index, element);
        } finally {
            //karena set merubah, jadi pake fireTablRowsUpdate
            fireTableRowsUpdated(index, index);
        }
    }

    public Daerah remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "NAMA";
            case 2:
                return "ODP";
            case 3:
                return "PDP";
            case 4:
                return "POSITIF";
            case 5:
                return "STATUS";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getOdp();
            case 3:
                return list.get(rowIndex).getPdp();
            case 4:
                return list.get(rowIndex).getPositif();
            case 5:
                return list.get(rowIndex).getStatus();
            default:
                return null;
        }
    }
}
