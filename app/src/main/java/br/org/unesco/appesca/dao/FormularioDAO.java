package br.org.unesco.appesca.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.org.unesco.appesca.model.Formulario;

/**
 * Created by yesus on 11/29/15.
 */
public class FormularioDAO implements Serializable{



    private static List<Formulario> listaFormulario;


    public static List<Formulario> findListaFormulario() {
        if(listaFormulario==null){
            listaFormulario = new ArrayList<>();
        }
        return listaFormulario;
    }

}
