/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.controllers;

import java.sql.Statement;
import syschool.models.Professor;
import syschool.db.ConexaoMySQL;
import java.sql.ResultSet;

/**Professor
 *
 * @author Administrador
 */
public class ProfessorController {
    public void inserir(Professor p) throws Exception{
        String query = "INSERT INTO professor (matricula, nome, data_nasc, email, cpf, id_curso, id_disciplina) VALUES ('%d','%s','%s', '%s', '%s', '%d', '%d', '%s')";
        query = String.format(query, p.getMatricula(), p.getNome(), p.getData_nasc(), p.getEmail(), p.getCpf(), p.getId_curso(), p.getId_disciplina(), p.getSenha());
                
        Statement st = ConexaoMySQL.getConexao().createStatement();        
        st.executeUpdate(query);
    }
    public Professor[] list() throws Exception{
                
        String query = "SELECT count(*) FROM professor";        
        Statement st = ConexaoMySQL.getConexao().createStatement();
        ResultSet rs = st.executeQuery(query);
        
        int numProfessores = 0;
        while (rs.next()) {
            numProfessores = rs.getInt(1);
        }
        Professor[] professores = new Professor[numProfessores];
        
        query = "SELECT * FROM professor";
        rs = st.executeQuery(query);        
        
        int count = 0;
        while (rs.next())
        { 
            Professor p = new Professor();
            p.setMatricula(rs.getInt("matricula"));
            p.setNome(rs.getString("nome"));
            p.setData_nasc(rs.getDate("data_nasc"));
            p.setEmail(rs.getString("email"));
            p.setCpf(rs.getString("cpf"));
            p.setId_curso(rs.getInt("id_curso"));
            p.setId_disciplina(rs.getInt("id_disciplina"));
            p.setSenha(rs.getString("senha"));
            professores[count] = p;
            count++;
        }
        
        st.close();
        
        return professores;
     }
}
