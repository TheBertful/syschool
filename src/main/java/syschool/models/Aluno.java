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
public class Aluno {
    
    private int matricula;
    private String nome;
    private Date data_nasc;
    private String email;
    private String cpf;
    
    public Aluno() {
    }

    public Aluno(int matricula, String nome, Date data_nasc, String email, String cpf) {
        this.matricula = matricula;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.email = email;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
