/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.relatorios;

/**
 *
 * @author Administrador
 */
public class RelatorioFactory {
    public Documento criarRelatorio(String formato) {
        switch(formato) {
            case "json":
                return new JSONRelatorio();            
 
            case "csv":
                return new CSVRelatorio();            
 
            case "txt":
                return new TXTRelatorio();
        }
        return null;
    }
}
