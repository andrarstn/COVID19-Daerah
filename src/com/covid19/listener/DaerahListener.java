/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.covid19.listener;

import com.covid19.entitas.Daerah;
import com.covid19.model.DaerahModel;

/**
 *
 * @author andra
 */
public interface DaerahListener {
    public void onChange(DaerahModel model);
    public void onInsert(Daerah d);
    public void onUpdate(Daerah d);
    public void onDelete();
}
