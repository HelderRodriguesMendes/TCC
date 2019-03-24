package Controller;

import javax.swing.JOptionPane;

/**
 *
 * @author helde
 */
public class Sindicalizado {

    public String verificar_CPF(String CPF, int id) {
        System.out.println("CPF SIND " + CPF);

        String a = "", b = "", c = "", d = "";
        if (CPF.length() == 11) {
            String[] array = new String[11];
            for (int i = 0; i < 11; i++) {
                array[i] = "" + CPF.charAt(i);
            }
            a = array[0];
            a += array[1];
            a += array[2];

            b = array[3];
            b += array[4];
            b += array[5];

            c = array[6];
            c += array[7];
            c += array[8];

            d = array[9];
            d += array[10];
            CPF = a + "." + b + "." + c + "-" + d;
            
        } else  if (CPF.length() == 14) {
            String[] array = new String[14];
            for (int i = 0; i < 14; i++) {
                array[i] = "" + CPF.charAt(i);
            }
            if (!".".equals(array[3]) || !".".equals(array[7]) || !"-".equals(array[11])) {

                a = array[0];
                a += array[1];
                a += array[2];

                b = array[4];
                b += array[5];
                b += array[6];

                c = array[8];
                c += array[9];
                c += array[10];

                d = array[12];
                d += array[13];
                
                CPF = a + "." + b + "." + c + "-" + d;
            }
        }else{
            CPF = "";
        }
        return CPF;
    }
}
