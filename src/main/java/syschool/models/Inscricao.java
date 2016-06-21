/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.models;

/**
 *
 * @author labinfo
 */
public class Inscricao {
    
    private int id_inscricao;
    private String status;
    private int id_disciplina;
    private int matricula;

    public int getId_inscricao() {
        return id_inscricao;
    }

    public void setId_inscricao(int id_inscricao) {
        this.id_inscricao = id_inscricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
        
    public Inscricao(){
    }
    
    public Inscricao(int id_inscricao, String status, int id_disciplina, int matricula){
        
        this.id_inscricao = id_inscricao;
        this.status = status;
        this.id_disciplina = id_disciplina;
        this.matricula = matricula;
    }
}
