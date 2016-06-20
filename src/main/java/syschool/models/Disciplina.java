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

    public Disciplina(int id_disciplina, String nome_disciplina) {
        this.id_disciplina = id_disciplina;
        this.nome_disciplina = nome_disciplina;
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
    
    
}
