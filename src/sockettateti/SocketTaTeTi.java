package sockettateti;

import java.net.*;
import java.io.*;
import static sockettateti.TaTeTi.Botones;

public class SocketTaTeTi extends Thread {

    private ServerSocket ssk = null;
    private Socket sk = null;
    private ObjectInputStream Entrada = null;
    private ObjectOutputStream Salida = null; 
    private Object jlblResultados;
    
    public SocketTaTeTi(){
        
    }
    
    public void Iniciar(){
        try{
            sk = new Socket ("localhost",12345);
            System.out.println("Cliente Dentro");
            Salida= new ObjectOutputStream(sk.getOutputStream());
            Entrada= new ObjectInputStream(sk.getInputStream());
            Salida.flush();
        }catch(IOException ioe){
            try{
                ssk= new ServerSocket (12345);
                System.out.println("Servidor Creado");
                sk=ssk.accept();
                Salida= new ObjectOutputStream(sk.getOutputStream());
                Entrada= new ObjectInputStream(sk.getInputStream());
                Salida.flush();
            }catch(IOException ioe2){
                System.out.println("ERROR 1");
            }
        }
    }
    
    public void run(){
        String msje="";
        while (true){
            try{
                msje=(String)Entrada.readObject();
                if (obtenerServidor()){
                    TaTeTi.Botones[Integer.parseInt(msje)].setText("X");
                    TaTeTi.Botones[Integer.parseInt(msje)].setEnabled(false);
                }else{
                    TaTeTi.Botones[Integer.parseInt(msje)].setText("O");
                    TaTeTi.Botones[Integer.parseInt(msje)].setEnabled(false);
                }
            }catch(IOException ioe){
                System.out.println("ERROR 2");
            } catch (ClassNotFoundException cnfe) {
                System.out.println("ERROR 3");
            }
        }
    }
    
    public void Enviar(String msje){
        try{
            Salida.writeObject(msje);
            Salida.flush();
        }catch(IOException ioe2){
            System.out.println("ERROR 4");
        }
    }
    
    public boolean obtenerServidor(){
        if (ssk == null){
            return false;
        }else{
            return true;
        }
    }
    
    public void Cerrar(){
        try{
            if (ssk == null){
                sk.close();
                Salida.flush();
                Salida.close();
            }else{
                ssk.close();
                sk.close();
                Salida.flush();
                Salida.close();
            }     
        }catch(IOException ioe){
            System.out.println("ERROR 5");
        }
    }
   
    public int Ganador(){
        int ganar = 0;
        //Pregunta Horizontales Primera Fila
            if ((Botones[0].getText().equals("X")) && (Botones[1].getText().equals("X")) && (Botones[2].getText().equals("X"))){
                ganar = 1;
            }else if ((Botones[0].getText().equals("O")) && (Botones[1].getText().equals("O")) && (Botones[2].getText().equals("O"))){
                ganar = 2;
            }
        //Pregunta Horizontales Sgda Fila
            if ((Botones[3].getText().equals("X")) && (Botones[4].getText().equals("X")) && (Botones[5].getText().equals("X"))){
                ganar = 1;
            }else if ((Botones[3].getText().equals("O")) && (Botones[4].getText().equals("O")) && (Botones[5].getText().equals("O"))){
                ganar = 2;
            } 
        //Pregunta Horizontales Tercera Fila   
            if ((Botones[6].getText().equals("X")) && (Botones[7].getText().equals("X")) && (Botones[8].getText().equals("X"))){
               ganar = 1;
            }else if ((Botones[6].getText().equals("O")) && (Botones[7].getText().equals("O")) && (Botones[8].getText().equals("O"))){
               ganar = 2;
            }    
        
        //Pregunta Verticales

            if ((Botones[0].getText().equals("X")) && (Botones[3].getText().equals("X")) && (Botones[6].getText().equals("X"))){
                ganar = 1;
            }else if ((Botones[0].getText().equals("O")) && (Botones[3].getText().equals("O")) && (Botones[6].getText().equals("O"))) {
                ganar = 2;
            }
            
            if ((Botones[1].getText().equals("X")) && (Botones[4].getText().equals("X")) && (Botones[7].getText().equals("X"))){
                ganar = 1;
            }else if ((Botones[1].getText().equals("O")) && (Botones[4].getText().equals("O")) && (Botones[7].getText().equals("O"))) {
                ganar = 2;
            } 
            
            if ((Botones[2].getText().equals("X")) && (Botones[5].getText().equals("X")) && (Botones[8].getText().equals("X"))){
               ganar = 1;
            }else if ((Botones[2].getText().equals("O")) && (Botones[5].getText().equals("O")) && (Botones[8].getText().equals("O"))) {
               ganar = 2;
            }
        
        //Pregunta Diagonales
        
            if ((Botones[0].getText().equals("X")) && (Botones[4].getText().equals("X")) && (Botones[8].getText().equals("X"))){
                ganar = 1;
            }else if ((Botones[0].getText().equals("O")) && (Botones[4].getText().equals("O")) && (Botones[8].getText().equals("O"))){
                ganar = 2;
            }
            
            if ((Botones[2].getText().equals("X")) && (Botones[4].getText().equals("X")) && (Botones[6].getText().equals("X"))){
                ganar = 1;
            }else if ((Botones[2].getText().equals("O")) && (Botones[4].getText().equals("O")) && (Botones[6].getText().equals("O"))){
                ganar = 2;
            }   
    return (ganar);
    }
    
    
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
            java.util.logging.Logger.getLogger(TaTeTi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaTeTi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaTeTi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaTeTi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaTeTi().setVisible(true);
            }
        });
    }
}