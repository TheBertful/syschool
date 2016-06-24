/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import syschool.models.Disciplina;
import syschool.controllers.DisciplinaController;
/**
 *
 * @author Priscila
 */
public class AlunoTableModel extends AbstractTableModel{
    
    
    DisciplinaController disciplinaController = new DisciplinaController();
    private ArrayList<Disciplina> ListaDeDisciplinas;
    private String [] colunas = {"Nome","Horário","Status"};
    private static AlunoTableModel instance = null;
    
    public AlunoTableModel(int id_aluno) throws Exception{
        ListaDeDisciplinas = disciplinaController.listDisciplinasAluno(id_aluno);
    }
    
    public AlunoTableModel(){
        
    }
    
    public static AlunoTableModel getInstance() {
        if(instance == null) 
            instance = new AlunoTableModel();
        return instance;
    }
    //Add as disciplinas
    public void setDisciplinaList(ArrayList<Disciplina> ListaDeDisciplinas){
       this.ListaDeDisciplinas = ListaDeDisciplinas ;
       fireTableDataChanged();
    }
    
       
    //remove linha
    public void CancelaInscricao(int RowIndex){
        this.ListaDeDisciplinas.remove(RowIndex);
        fireTableDataChanged();
    
    }
    
    
    @Override
    public int getRowCount() {
        //numero de linha da tabela
        return this.ListaDeDisciplinas.size();
    }

    @Override
    public int getColumnCount() {
        //numero de colunas da tabela
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.ListaDeDisciplinas.get(rowIndex).getNome_disciplina();
            case 1:
                return this.ListaDeDisciplinas.get(rowIndex).getHorario();

            case 2:
                return this.ListaDeDisciplinas.get(rowIndex).getStatus();

            default:
                return this.ListaDeDisciplinas.get(rowIndex);
        }
        
    }
    
    @Override
    public String getColumnName(int i){
        return colunas[i];
    }
    
    public String getNome_disciplina(int rowIndex){
        return this.ListaDeDisciplinas.get(rowIndex).getNome_disciplina();
    }
    
    public String getHorario(int rowIndex){
        return this.ListaDeDisciplinas.get(rowIndex).getHorario();
    }
    
    
    
}
