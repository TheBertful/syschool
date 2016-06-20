/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.models;

import java.sql.Timestamp;

/**
 *
 * @author Hugo
 */
public class Turma {
    private int id_turma;
    private int sala;
    private Timestamp horario;
    private int id_curso;
    private int id_disciplina;

    public Turma() {
    }

    public Turma(int id_turma, int sala, Timestamp horario, int id_curso, int id_disciplina) {
        this.id_turma = id_turma;
        this.sala = sala;
        this.horario = horario;
        this.id_curso = id_curso;
        this.id_disciplina = id_disciplina;
    }

    public int getId_turma() {
        return id_turma;
    }

    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public Timestamp getHorario() {
        return horario;
    }

    public void setHorario(Timestamp horario) {
        this.horario = horario;
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
