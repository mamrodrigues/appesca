package br.org.unesco.appesca.util;

/**
 * Created by yesus on 1/11/16.
 */
public class ConstantesREST {
    public static String HOST = "http://192.168.1.3:8080/appesca-web/";
    //private final static String HOST = "http://macbookyesus.local:8080/appesca-web/";

    /**
     * SERVICOS REST
     */
    public final static String AUTHENTICATION_SERVICE = "rest/usuario/autenticacao";
    public final static String USUARIO_IMAGEM = "rest/usuario/imagem";
    public final static String FORMULARIO_LISTA = "rest/formulario/lista";


    public static String getURLService(String SERVICE_REST){
        return HOST + SERVICE_REST;
    }

    public static void main(String[] args) {
        ConstantesREST.getURLService(AUTHENTICATION_SERVICE);
    }
}
