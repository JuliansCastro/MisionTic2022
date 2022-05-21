/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.IngresoView;



/**
 *
 * @author daniel davila
 */
public class Principal {
    
    
    
    public static void main(String[] args){
        IngresoView ingresoView = new IngresoView();        
        IngresoController controlIngresoController = new IngresoController(ingresoView);
    }
}
