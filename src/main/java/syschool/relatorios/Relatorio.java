/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.relatorios;

import java.util.ArrayList;
import syschool.models.Disciplina;

/**
 *
 * @author Administrador
 */
public interface Relatorio {
    public void imprimir(ArrayList<Disciplina> disciplinas);
}
