/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.view.tablemodel;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import syschool.controllers.InscricaoController;
import syschool.models.Inscricao;
import syschool.models.Aluno;

/**
 *
 * @author Administrador
 */
public class InscricaoTableModel extends AbstractTableModel {
    
    Inscricao listaInscricoes[];
    InscricaoController inscricaoController;
    
    public InscricaoTableModel(){
        inscricaoController = new InscricaoController();
        try {
            listaInscricoes = inscricaoController.list();
        } catch (Exception ex) {
            Logger.getLogger(InscricaoTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int getRowCount() {
        if(listaInscricoes.length == 0) return 0;
        if(listaInscricoes.length > 0){
            return listaInscricoes.length;
        }else{
            return 0;
        }
        
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: // nome aluno
                Aluno a = new Aluno();
                
                return listaInscricoes[rowIndex].getId_inscricao();
            
            case 1:
                return listaInscricoes[rowIndex].getMatricula();                
                        
            default:               
                return listaInscricoes[rowIndex].getId_inscricao();
        }
    }
    
}
