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
public class Curso {
    private int id_curso;
    private String nome_curso;

    public Curso() {
    }

    public Curso(int id_curso, String nome_curso) {
        this.id_curso = id_curso;
        this.nome_curso = nome_curso;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }
    
    
}
