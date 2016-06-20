/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.models;

import java.sql.Date;

/**
 *
 * @author Hugo
 */
public class Professor {
    
    private int matricula;
    private String nome;
    private Date data_nasc;
    private String email;
    private int cpf;
    private int id_curso;
    private int id_disciplina;

    public Professor() {
    }

    public Professor(int matricula, String nome, Date data_nasc, String email, int cpf, int id_curso, int id_disciplina) {
        this.matricula = matricula;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.email = email;
        this.cpf = cpf;
        this.id_curso = id_curso;
        this.id_disciplina = id_disciplina;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }
    
    
}
