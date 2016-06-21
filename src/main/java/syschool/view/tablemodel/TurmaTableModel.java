/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.view.tablemodel;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import syschool.controllers.TurmaController;
import syschool.db.ConexaoMySQL;
import syschool.models.Disciplina;
import syschool.models.Professor;
import syschool.models.Turma;

/**
 *
 * @author Bert
 */
public class TurmaTableModel extends AbstractTableModel {
    Turma listaTurmas[];
    TurmaController turmaController;

    public TurmaTableModel() {
        turmaController = new TurmaController();
        try {
            listaTurmas = turmaController.list();
        } catch (Exception ex) {
            Logger.getLogger(TurmaTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    @Override
    public int getRowCount() {
        if(listaTurmas.length > 0){
            return listaTurmas.length;
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
            case 0:
                return listaTurmas[rowIndex].getId_turma();
            
            case 1:
                return listaTurmas[rowIndex].getHorario();                
            
            case 2:
                String query = "SELECT * FROM professor where id_disciplina = " + listaTurmas[rowIndex].getId_disciplina();
                Statement st;
                ResultSet rs;
                Professor p = new Professor();
                Disciplina d = new Disciplina();
                try{
                    st = ConexaoMySQL.getConexao().createStatement();
                    rs = st.executeQuery(query);
                    p.setMatricula(rs.getInt("matricula"));
                    p.setNome(rs.getString("nome"));
                    p.setData_nasc(rs.getDate("data_nasc"));
                    p.setEmail(rs.getString("email"));
                    p.setCpf(rs.getString("cpf"));
                    p.setId_curso(rs.getInt("id_curso"));
                    p.setId_disciplina(rs.getInt("id_disciplina"));
                    p.setSenha(rs.getString("senha"));
                    query = "SELECT * FROM disciplina where id_disciplina = " + listaTurmas[rowIndex].getId_disciplina();
                    st = ConexaoMySQL.getConexao().createStatement();
                    rs = st.executeQuery(query);
                    d.setId_disciplina(rs.getInt("id_matricula"));
                    d.setNome_disciplina(rs.getString("nome_disciplina"));
                } catch (Exception ex) {
                    Logger.getLogger(TurmaTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                return p.getNome();
            
            case 3:
                return "Não implementado";
                
            default:               
                return listaTurmas[rowIndex].getId_turma();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
             case 0:
                return "id_turma";
            
            case 1:
                return "horario";
                
            case 2:
                return "professor";
                
            case 3:
                return "alunos";
                                
            default:               
                return "#error";
        }        
    }
    
    public Turma getTurmaAt(int index){
        if(listaTurmas[index] != null){
            return listaTurmas[index];
        }else{
            return null;
        }        
    }

    @Override
    public void fireTableDataChanged() {
        try {
            listaTurmas = turmaController.list();
        } catch (Exception ex) {
            Logger.getLogger(TurmaTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.fireTableDataChanged(); 
    }
}
