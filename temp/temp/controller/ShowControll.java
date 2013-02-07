/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learning.dataajar.controller;

import com.learning.dataajar.gui.ShowPanel;
import com.learning.dataajar.model.ShowModel;

/**
 *
 * @author hendri
 */
public class ShowControll {

    private ShowPanel view;
    private ShowModel model;

    public void setModel(ShowModel model) {
        this.model = model;
    }

    public void setView(ShowPanel view) {
        this.view = view;
    }

    public void startTree() {
        model.startIDTree();
    }
}
