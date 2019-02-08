/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
}
