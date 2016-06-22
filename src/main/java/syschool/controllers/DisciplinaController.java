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
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class DisciplinaController {
    
    private int idCurso; 

    public DisciplinaController() { }
    
    public DisciplinaController(int idCurso) {
        this.idCurso = idCurso;
    }
     
    public void inserir(Disciplina d) throws Exception {
        String query = "INSERT INTO disciplina (id_disciplina, nome_disciplina) VALUES ('%d','%s', '%d', '%s')";
        query = String.format(query, d.getId_disciplina(), d.getNome_disciplina(), d.getId_curso(), d.getHorario());

        Statement st = ConexaoMySQL.getConexao().createStatement();
        st.executeUpdate(query);
    }

    public Disciplina[] list() throws Exception {

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
        while (rs.next()) {
            Disciplina c = new Disciplina();
            c.setId_disciplina(rs.getInt("id_disciplina"));
            c.setNome_disciplina(rs.getString("nome_disciplina"));
            c.setId_curso(rs.getInt("id_curso"));
            c.setHorario(rs.getString("horario"));
            disciplinas[count] = c;
            count++;
        }

        st.close();

        return disciplinas;
    }

    public ArrayList<Disciplina> listCoordenador() throws Exception {
        ArrayList<Disciplina> disciplinas = new ArrayList();
        
        String query = "SELECT DISTINCT nome_disciplina, horario,\n"
                + "(SELECT COUNT(*) FROM inscricao, disciplina WHERE inscricao.id_disciplina = disciplina.id_disciplina AND inscricao.status LIKE 'A') AS alunos,\n"
                + "(SELECT COUNT(*) FROM inscricao, disciplina WHERE inscricao.id_disciplina = disciplina.id_disciplina AND inscricao.status LIKE 'P') AS pendentes \n"
                + "FROM disciplina, inscricao;";
        Disciplina d;
        Statement st = ConexaoMySQL.getConexao().createStatement();
        ResultSet rs = st.executeQuery(query);
                
        while (rs.next()) {
            d = new Disciplina(rs.getString("nome_disciplina"),
                               rs.getString("horario"),
                               rs.getInt("alunos"),
                               rs.getInt("pendentes"));
            disciplinas.add(d);
        }
        
        return disciplinas;
    }
    
    public ArrayList<Disciplina> listProfessor() throws Exception {
        ArrayList<Disciplina> disciplinas = new ArrayList();
        
        String query = "SELECT DISTINCT d.nome_disciplina, c.nome_curso, d.horario,\n"
                + "(SELECT COUNT(*) FROM inscricao, disciplina WHERE inscricao.id_disciplina = disciplina.id_disciplina AND inscricao.status LIKE 'A') AS alunos,\n"
                + "(SELECT COUNT(*) FROM inscricao, disciplina WHERE inscricao.id_disciplina = disciplina.id_disciplina AND inscricao.status LIKE 'P') AS pendentes \n"
                + "FROM disciplina d, curso c, inscricao "
                + "where d.id_curso = c.id_curso";
        Disciplina d;
        Statement st = ConexaoMySQL.getConexao().createStatement();
        ResultSet rs = st.executeQuery(query);
                
        while (rs.next()) {
            d = new Disciplina(rs.getString("nome_disciplina"),
                               rs.getString("nome_curso"),
                               rs.getString("horario"),
                               rs.getInt("alunos"),
                               rs.getInt("pendentes"));
            disciplinas.add(d);
        }
        
        return disciplinas;
    }
    
    
    public ArrayList<Disciplina> listDisciplinasCurso() throws Exception {
        ArrayList<Disciplina> disciplinas = new ArrayList();
        
        String query = "select d.nome_disciplina, d.horario, p.nome as professor "
                + "from disciplina d, professor p "
                + "where d.id_disciplina = d.id_disciplina and d.id_curso = "+idCurso;
        Disciplina d;
        Statement st = ConexaoMySQL.getConexao().createStatement();
        ResultSet rs = st.executeQuery(query);
                
        while (rs.next()) {
            d = new Disciplina(rs.getString("nome_disciplina"),
                               rs.getString("horario"),
                               rs.getString("professor"));
            disciplinas.add(d);
        }
        
        return disciplinas;
        
    }
    
    public ArrayList<Inscricao> listInscricoes() throws Exception {
        ArrayList<Inscricao> inscricoes = new ArrayList();
        
        String query = "SELECT a.nome_aluno as aluno, d.nome_disciplina as disciplina "
                + "FROM aluno a, disciplina d, inscricao i "
                + "where i.id_disciplina = d.id_disciplina and a.matricula = i.matricula";
    }
}
