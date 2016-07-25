/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.db;

/**
 *
 * @author Administrador
 */
public class Sessao {    
    
    private Sessao() {
        
    }
    
    private Sessao(int _matricula){
        matricula = _matricula;
    }
    
    private static class SessaoHolder{
        private static final Sessao INSTANCE = new Sessao();
    }
    
    public static int getMatricula(){
        return matricula;
    }
    
    public static void setMatricula(int _matricula){
        matricula = _matricula;
    }
    
    public static Sessao getInstance(){
        return SessaoHolder.INSTANCE;
    }
    
    private static int matricula;
}
