/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Base64;

/**
 *
 * @author helde
 */
public class Login {
    boolean adm;
    
    public boolean perfilUser(String per){
        
        if("Administrador".equals(per)){
          adm = true;  
        }else if("Usuário".equals(per)){
            adm = false;
        }
        return adm;
    }
    
    public String criptografar(String senha){
        String codificado = Base64.getEncoder().encodeToString(senha.getBytes());
        return codificado;
    }
    
    public String descriptografar(String senha){
        byte[] decodificado = Base64.getDecoder().decode(senha);
        String senhadecodificada = new String(decodificado);       
        return senhadecodificada;
    }
    
}
