/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.controllers;

import java.sql.ResultSet;
import java.sql.Statement;
import syschool.db.ConexaoMySQL;
import syschool.models.Inscricao;

/**
 *
 * @author labinfo
 */
public class InscricaoController {
    
    public void inserir (Inscricao i) throws Exception{
         String query = "INSERT INTO inscricao (id_inscricao, status, id_disciplina, matricula) VALUES ('%d','%s','%d', '%d')";
        query = String.format(query, i.getId_inscricao(), i.getStatus(), i.getId_disciplina(), i.getMatricula());
                
        Statement st = ConexaoMySQL.getConexao().createStatement();        
        st.executeUpdate(query);
    }
    
    public Inscricao [] list() throws Exception{
        String query = "SELECT count(*) FROM inscricao";        
        Statement st = ConexaoMySQL.getConexao().createStatement();
        ResultSet rs = st.executeQuery(query);
        
        int numInscricao = 0;
        while (rs.next()) {
            numInscricao = rs.getInt(1);
        }
        Inscricao[] inscricao= new Inscricao[numInscricao];
        
        query = "SELECT * FROM inscricao";
        rs = st.executeQuery(query);        
        
        int count = 0;
        while (rs.next())
        { 
            Inscricao i = new Inscricao();
            i.setId_inscricao(rs.getInt("id_inscricao"));
            i.setStatus(rs.getString("status"));
            i.setId_disciplina(rs.getInt("id_disciplina"));
            i.setMatricula(rs.getInt("matricula"));
            
            inscricao[count] = i;
            count++;
        }
        
        st.close();
        
        return inscricao;
    }    
}
