/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entidadades.Administrador;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.swing.JOptionPane;

/**
 *
 * @author helde
 */
public class Login {

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
    
    public String validar_nova_senha(String s1, String s2){
        String se = "";
        if(s1.equals(s2)){
            se = encriptografar_senha(s1);
        }else{
            JOptionPane.showMessageDialog(null, "Erro", "As senhas não correspondem", JOptionPane.ERROR_MESSAGE);
        }
        return se;
    }

}
