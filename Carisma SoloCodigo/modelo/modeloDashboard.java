/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import logica.categoriaDAO;
import logica.categoriaVO;

/**
 *
 * @author Alisson
 */
public class modeloDashboard {
    
    public ArrayList <categoriaVO> RescataCategoria(){
        categoriaDAO categoria = new categoriaDAO();
        ArrayList<categoriaVO> listacategoria = null;
        listacategoria = categoria.rescatarcategoria();
        return listacategoria;
    }
    
}
