/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.controllers;

import java.sql.Statement;
import syschool.models.Disciplina;
import syschool.db.ConexaoMySQL;
import java.sql.ResultSet;
/**
 *
 * @author Administrador
 */
public class DisciplinaController {
    public void inserir(Disciplina d) throws Exception{
        String query = "INSERT INTO disciplina (id_disciplina, nome_disciplina) VALUES ('%d','%s')";
        query = String.format(query, d.getId_disciplina(), d.getNome_disciplina());
                
        Statement st = ConexaoMySQL.getConexao().createStatement();        
        st.executeUpdate(query);        
    }
    
    public Disciplina[] list() throws Exception{
                
        String query = "SELECT count(*) FROM disciplina";  
        Statement st = ConexaoMySQL.getConexao().createStatement();
        ResultSet rs = st.executeQuery(query);
        
        int numDisciplinas = 0;
        while (rs.next()) {
            numDisciplinas = rs.getInt(1);
        }
        Disciplina[] disciplinas = new Disciplina[numDisciplinas];
        
        query = "SELECT * FROM disciplina";
        rs = st.executeQuery(query);        
        
        int count = 0;
        while (rs.next())
        { 
            Disciplina c = new Disciplina();
            c.setId_disciplina(rs.getInt("id_disciplina"));
            c.setNome_disciplina(rs.getString("nome_disciplina"));      
            disciplinas[count] = c;
            count++;
        }
        
        st.close();
        
        return disciplinas;         
     }
}
