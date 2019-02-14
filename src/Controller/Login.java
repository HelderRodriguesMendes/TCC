/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entidadades.Usuario;
import View.Tela_Login;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.swing.JOptionPane;

/**
 *
 * @author helde
 */
public class Login {

    boolean adm;

    public boolean perfilUser(Usuario usu) {
        if ("Administrador".equals(usu.getTipo_usuario())) {
            adm = true;
        } else if ("Sindicalizado".equals(usu.getTipo_usuario())) {
            adm = false;
        }
        return adm;
    }

    public static String encriptografar_senha(String senha) {
        String retorno = "";
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));  //transforma a senha em um array de bytes e mistura ela em um bigInt
            retorno = hash.toString(16); //o 16 informa o tamano que a senha vai ser gerada

        } catch (Exception e) {
        }

        return retorno;
    }

}
