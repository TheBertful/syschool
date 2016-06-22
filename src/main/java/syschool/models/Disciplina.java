/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.models;

/**
 *
 * @author Hugo
 */
public class Disciplina {
    private int id_disciplina;
    private String nome_disciplina;
    private int id_curso;
    private String horario;
    private int alunos;
    private int inscricoesPendentes;
    
    public Disciplina(int id_disciplina, String nome_disciplina, int id_curso, String horario) {
        this.id_disciplina = id_disciplina;
        this.nome_disciplina = nome_disciplina;
        this.id_curso = id_curso;
        this.horario = horario;
    }

    public Disciplina(String nome_disciplina, String horario, int alunos, int inscricoesPendentes) {
        this.nome_disciplina = nome_disciplina;
        this.horario = horario;
        this.alunos = alunos;
        this.inscricoesPendentes = inscricoesPendentes;
    }
    
    public Disciplina() {
    }

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public String getNome_disciplina() {
        return nome_disciplina;
    }

    public void setNome_disciplina(String nome_disciplina) {
        this.nome_disciplina = nome_disciplina;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getAlunos() {
        return alunos;
    }

    public void setAlunos(int alunos) {
        this.alunos = alunos;
    }

    public int getInscricoesPendentes() {
        return inscricoesPendentes;
    }

    public void setInscricoesPendentes(int inscricoesPendentes) {
        this.inscricoesPendentes = inscricoesPendentes;
    }
    
    
}
