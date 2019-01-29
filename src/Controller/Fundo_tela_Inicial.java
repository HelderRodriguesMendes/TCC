/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author Helder Rodrigues
 */
public class Fundo_tela_Inicial extends JDesktopPane{
    private Image imagem;
    public Fundo_tela_Inicial(String Image){
        this.imagem = new ImageIcon(Image).getImage();
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this); // posicionando a imagem no tamano da tela, onde o getWidth() pega a largura da tela, e o getHeight() pega a altura da tela 
    }
}
