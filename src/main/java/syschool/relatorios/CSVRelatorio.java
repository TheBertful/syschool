/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.relatorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import syschool.models.Disciplina;

/**
 *
 * @author Administrador
 */
public class CSVRelatorio extends Documento {

    @Override
    public void imprimir(ArrayList<Disciplina> disciplinas) {
        PrintWriter pw;
        try {
            pw = new PrintWriter(new File("Relatorio.csv"));
            StringBuilder sb = new StringBuilder();

            sb.append("Nome");
            sb.append(",");
            sb.append("Horário");
            sb.append(",");
            sb.append("Status");
            sb.append(",");
            sb.append('\n');

            /*for (int i = 0; i < disciplinas.size(); i++) {
            sb.append(getNome.disciplinas.getMaluco);
            sb.append(",");
            sb.append(getHorario);
            sb.append(",");
            sb.append(getStatus);
            sb.append(",");
            sb.newLine();
        }*/
            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*@Override
        protected void criarArquivo(){
            
        }
        
        @Override
        protected void formatarArquivo(){
            
        }
        
        @Override
        protected void inserirDados(){
            
        }*/

    }
}
