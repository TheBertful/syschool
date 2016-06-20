/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.controllers;

import java.sql.Statement;
import syschool.models.Turma;
import syschool.db.ConexaoMySQL;
import java.sql.ResultSet;

/**
 *
 * @author Administrador
 */
public class TurmaController {
    public void inserir(Turma t) throws Exception{
        String query = "INSERT INTO turma (id_turma, sala, horario, curso, disciplina) VALUES ('%d','%d','%s', '%d', '%d')";
        query = String.format(query, t.getId_turma(), t.getSala(), t.getHorario(), t.getId_curso(), t.getId_disciplina());
                
        Statement st = ConexaoMySQL.getConexao().createStatement();        
        st.executeUpdate(query);
    }
    public Turma[] list() throws Exception{
                
        String query = "SELECT count(*) FROM turma";        
        Statement st = ConexaoMySQL.getConexao().createStatement();
        ResultSet rs = st.executeQuery(query);
        
        int numTurmas = 0;
        while (rs.next()) {
            numTurmas = rs.getInt(1);
        }
        Turma[] turmas = new Turma[numTurmas];
        
        query = "SELECT * FROM turma";
        rs = st.executeQuery(query);        
        
        int count = 0;
        while (rs.next())
        { 
            Turma t = new Turma();
            t.setId_turma(rs.getInt("id_turma"));
            t.setSala(rs.getInt("sala"));
            t.setHorario(rs.getTimestamp("horario"));
            t.setId_curso(rs.getInt("id_curso"));
            t.setId_disciplina(rs.getInt("id_disciplina"));
            turmas[count] = t;
            count++;
        }
        
        st.close();
        
        return turmas;
     }
}
