/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.controllers;

import java.sql.Statement;
import syschool.models.Aluno;
import syschool.db.ConexaoMySQL;
import java.sql.ResultSet;

/**
 *
 * @author Administrador
 */
public class AlunoController {
    public void inserir(Aluno a) throws Exception{
        String query = "INSERT INTO aluno (matricula, nome, data_nasc, email, cpf, senha) VALUES ('%d','%s','%s', '%s', '%s', '%s')";
        query = String.format(query, a.getMatricula(), a.getNome(), a.getData_nasc(), a.getEmail(), a.getCpf(), a.getSenha());
                
        Statement st = ConexaoMySQL.getConexao().createStatement();        
        st.executeUpdate(query);
    }
    public Aluno[] list() throws Exception{
                
        String query = "SELECT count(*) FROM aluno";        
        Statement st = ConexaoMySQL.getConexao().createStatement();
        ResultSet rs = st.executeQuery(query);
        
        int numAlunos = 0;
        while (rs.next()) {
            numAlunos = rs.getInt(1);
        }
        Aluno[] alunos = new Aluno[numAlunos];
        
        query = "SELECT * FROM aluno";
        rs = st.executeQuery(query);        
        
        int count = 0;
        while (rs.next())
        { 
            Aluno a = new Aluno();
            a.setMatricula(rs.getInt("matricula"));
            a.setNome(rs.getString("nome"));
            a.setData_nasc(rs.getDate("data_nasc"));
            a.setEmail(rs.getString("email"));
            a.setCpf(rs.getString("cpf"));
            a.setSenha(rs.getString("senha"));
            alunos[count] = a;
            count++;
        }
        
        st.close();
        
        return alunos;
     }
    public int contar() throws Exception{
        
        String query = "SELECT count(*) FROM aluno";        
        Statement st = ConexaoMySQL.getConexao().createStatement();
        ResultSet rs = st.executeQuery(query);
        
        int numAlunos = 0;
        while (rs.next()) {
            numAlunos++;
        }
        return numAlunos;
    }
}
