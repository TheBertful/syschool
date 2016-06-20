/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.controllers;

import java.sql.Statement;
import syschool.models.Curso;
import syschool.db.ConexaoMySQL;
import java.sql.ResultSet;
/**
 *
 * @author Administrador
 */
public class CursoController {
    public void inserir(Curso c) throws Exception{
        String query = "INSERT INTO curso (id_curso, nome_curso) VALUES ('%d','%s')";
        query = String.format(query, c.getId_curso(), c.getNome_curso());
                
        Statement st = ConexaoMySQL.getConexao().createStatement();        
        st.executeUpdate(query);        
    }
    
    public Curso[] list() throws Exception{
                
        String query = "SELECT count(*) FROM curso";  
        Statement st = ConexaoMySQL.getConexao().createStatement();
        ResultSet rs = st.executeQuery(query);
        
        int numCursos = 0;
        while (rs.next()) {
            numCursos = rs.getInt(1);
        }
        Curso[] cursos = new Curso[numCursos];
        
        query = "SELECT * FROM curso";
        rs = st.executeQuery(query);        
        
        int count = 0;
        while (rs.next())
        { 
            Curso c = new Curso();
            c.setId_curso(rs.getInt("id_curso"));
            c.setNome_curso(rs.getString("nome_curso"));      
            cursos[count] = c;
            count++;
        }
        
        st.close();
        
        return cursos;         
     }
}
