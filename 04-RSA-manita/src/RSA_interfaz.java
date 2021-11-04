
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cactu
 * 
 * Tarea:
 * Realizar este programa de calculo de RSA  con una hermosa 
 * ventana en swing usando metodos privados (1 persona) max 3 digitos los primos
 * 
 */
public class RSA_interfaz extends javax.swing.JFrame {

    public RSA_interfaz() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     *  mis variables
     */ 
    
    String mensaje;
    int tamprimo; //2, 3, 4 etc
    BigInteger[] cifrado, descifrado;
    BigInteger p, q, n;
    BigInteger fi;
    BigInteger e, d;
    
    
    
    /**
     *  mis métodos
     */ 
    
    // constructor del tamaño del primo
    public RSA_interfaz (int tamprimo){
        this.tamprimo = tamprimo;
    }
    
    // metodo para generar los numeros primos
    public void generarPrimos(){
    
        p = new BigInteger(tamprimo, 10, new Random());
        
        do q = new BigInteger(tamprimo, 10, new Random());
         while(q.compareTo(p)==0); 
    
    }
    
    // metodo para generar las claves
    public void generarClaves(){
        /*
        Recordar que n = p*q
        fi = (p-1)*(q-1)
        */
        
        n = p.multiply(q);
        
        //(p-1)
        fi = p.subtract(BigInteger.valueOf(1));
        
        fi = fi.multiply(q.subtract(BigInteger.valueOf(1)));
        
        /*
        como calculabamos a e
        
        e debe de ser un coprimo de n de tal que
        1<e<fi(n)
        */
        
        do e = new BigInteger(2*tamprimo, new Random());
        while((e.compareTo(fi) != -1) || (e.gcd(fi).compareTo(BigInteger.valueOf(1)) != 0));
        
        //calcular a d = e ^ 1 mod fi   inverso multiplicativo de e
        
        d = e.modInverse(fi);
        
    }
    
    // metodo para cifrar con la llave pública
    public BigInteger[] cifrar(String mensaje){
    
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        
        BigInteger[] bigdigitos = new BigInteger[digitos.length];
        
        //vamos a iterar esos digitos grandotes
        
        for(i = 0; i < bigdigitos.length; i++){
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }
        
        // C=M^e mod(n)
        
        cifrado = new BigInteger[bigdigitos.length];
        
        for(i = 0; i < bigdigitos.length; i++){
            cifrado[i] = bigdigitos[i].modPow(e, n);
        }
        
        return cifrado;
    }
    
    // metodo para descifrar con la llave privada
    public String descifrar(BigInteger[] cifrado){
        
        System.out.println("Texto cifrado dentro de descifrar: " + cifrado);
        descifrado = new BigInteger[cifrado.length];
        
        //vamos a descifrar con la formula
        // Md = C ^d mod n
        
        for(int j = 0; j < descifrado.length; j++){
            descifrado[j] = cifrado[j].modPow(d, n);
        }
        
        char[] charArray = new char[descifrado.length];
        
        for(int j = 0; j < charArray.length; j++ ){
            charArray[j] = (char)(descifrado[j].intValue());
        }
        
        System.out.println("Descifrado: " + descifrado);
        return (new String(charArray));
    }
    
    // mensaje de ayuda
    public static void mensajeAyuda() {
        System.out.println("El archivo está vacío");
    }
    
    // mostrar bytes (?
    public static void mostrarBytes(byte[] buffer) {
        System.out.write(buffer, 0, buffer.length);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barra01 = new javax.swing.JTextField();
        barra02 = new javax.swing.JTextField();
        lblTarea = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        sldDigitos = new javax.swing.JSlider();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        bttCifrar = new javax.swing.JButton();
        bttDescifrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barra01.setEditable(false);
        barra01.setBackground(new java.awt.Color(247, 127, 0));
        barra01.setBorder(null);
        barra01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barra01ActionPerformed(evt);
            }
        });
        getContentPane().add(barra01, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 270, -1));

        barra02.setEditable(false);
        barra02.setBackground(new java.awt.Color(0, 48, 73));
        barra02.setBorder(null);
        barra02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barra02ActionPerformed(evt);
            }
        });
        getContentPane().add(barra02, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 430, -1));

        lblTarea.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        lblTarea.setForeground(new java.awt.Color(73, 80, 87));
        lblTarea.setText("<html>Tarea: Realizar este programa de calculo de RSA  con una hermosa ventana en swing usando metodos privados (1 persona) max 3 digitos los primos.</html>");
        getContentPane().add(lblTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 580, 70));

        lblNumero.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNumero.setForeground(new java.awt.Color(73, 80, 87));
        lblNumero.setText("Digitos para el número primo:");
        getContentPane().add(lblNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 250, -1));

        sldDigitos.setMajorTickSpacing(3);
        sldDigitos.setMaximum(3);
        sldDigitos.setMinimum(1);
        sldDigitos.setMinorTickSpacing(1);
        sldDigitos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(sldDigitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 210, -1));

        lbl1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl1.setForeground(new java.awt.Color(73, 80, 87));
        lbl1.setText("3");
        getContentPane().add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 20, -1));

        lbl2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl2.setForeground(new java.awt.Color(73, 80, 87));
        lbl2.setText("1");
        getContentPane().add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 20, -1));

        lbl3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl3.setForeground(new java.awt.Color(73, 80, 87));
        lbl3.setText("2");
        getContentPane().add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 20, -1));

        lblMensaje.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(73, 80, 87));
        getContentPane().add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 300, 30));

        bttCifrar.setText("Cifrar");
        bttCifrar.setActionCommand("");
        bttCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCifrarActionPerformed(evt);
            }
        });
        getContentPane().add(bttCifrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        bttDescifrar.setText("Descifrar");
        getContentPane().add(bttDescifrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, -1, -1));

        txtMensaje.setColumns(20);
        txtMensaje.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtMensaje.setRows(5);
        txtMensaje.setText("Texto a cifrar");
        txtMensaje.setWrapStyleWord(true);
        txtMensaje.setSelectedTextColor(new java.awt.Color(153, 153, 255));
        txtMensaje.setSelectionColor(new java.awt.Color(255, 153, 51));
        jScrollPane2.setViewportView(txtMensaje);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 210, 150));

        txtResultado.setEditable(false);
        txtResultado.setColumns(20);
        txtResultado.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtResultado.setRows(5);
        txtResultado.setText("Resultado");
        txtResultado.setWrapStyleWord(true);
        txtResultado.setSelectedTextColor(new java.awt.Color(153, 153, 255));
        txtResultado.setSelectionColor(new java.awt.Color(255, 153, 51));
        jScrollPane1.setViewportView(txtResultado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 560, 150));

        Fondo.setBackground(java.awt.Color.white);
        Fondo.setOpaque(true);
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barra02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barra02ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barra02ActionPerformed

    private void barra01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barra01ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barra01ActionPerformed

    private void bttCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCifrarActionPerformed
      
        // salto de línea
        System.out.println("\n");
        
        tamprimo = this.sldDigitos.getValue();
        // this.lblMensaje.setText("tamaño del primo: " + Integer.toString(tamprimo)); // se muestra el valor del slide
        
        // generamos los números primos
        System.out.println("1. Generamos los números primos");
        generarPrimos();
        
        // generamos las claves
        System.out.println("2. Generamos las claves");
        generarClaves();
        
        // tomamos el texto a cifrar
        mensaje = this.txtMensaje.getText();
            System.out.println("   >>>>>>>> Texto a cifrar: " + mensaje);
            this.lblMensaje.setText(mensaje);
        
        
        // ciframos con la llave pública
        System.out.println("3. Ciframos con la llave pública");
        System.out.println(cifrar(mensaje));

        // 
        
        // desciframos con la llave privada
        System.out.println("4. Descriframos con la llave privada");
        System.out.println(descifrar(cifrado));
        
        
    }//GEN-LAST:event_bttCifrarActionPerformed

    // main
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RSA_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RSA_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RSA_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RSA_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RSA_interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField barra01;
    private javax.swing.JTextField barra02;
    private javax.swing.JButton bttCifrar;
    private javax.swing.JButton bttDescifrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblTarea;
    private javax.swing.JSlider sldDigitos;
    private javax.swing.JTextArea txtMensaje;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
