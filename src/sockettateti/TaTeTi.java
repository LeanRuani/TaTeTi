package sockettateti;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TaTeTi extends javax.swing.JFrame implements ActionListener {

    public static JButton[] Botones;
    public static JLabel jl;
    public static SocketTaTeTi js;
    
    public TaTeTi() {
        initComponents(); 
        Botones = new JButton[9];
        for(int x = 0; x < 9; x++){
            Botones[x] = new JButton("");
            Botones[x].addActionListener(this);
            Tablero.add(Botones[x]); 
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        for (int x=0; x < 9; x++){
            if (ae.getSource()==Botones[x]){
                if (js.obtenerServidor()){ 
                    Botones[x].setText("O");
                    Botones[x].setEnabled(false);
                    if (js.Ganador() == 1){
                        jlblResultados.setText("Ganaste");
                    }else{
                        jlblResultados.setText("Pediste");
                    }
                    
                }else{
                    Botones[x].setText("X");
                    Botones[x].setEnabled(false);
                    if (js.Ganador() == 2){
                        jlblResultados.setText("Ganaste");
                    }else{
                        jlblResultados.setText("Pediste");
                    }
                }
                js.Enviar(Integer.toString(x));
                }
            }
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tablero = new javax.swing.JPanel();
        jbtnEmpezar = new javax.swing.JButton();
        jbtnCerrar = new javax.swing.JButton();
        jlblResultados = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tablero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Tablero.setLayout(new java.awt.GridLayout(3, 3));

        jbtnEmpezar.setText("Emprezar");
        jbtnEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEmpezarActionPerformed(evt);
            }
        });

        jbtnCerrar.setText("Salir");
        jbtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tablero, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnEmpezar, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(jlblResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Tablero, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtnEmpezar)
                        .addGap(18, 18, 18)
                        .addComponent(jlblResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnCerrar)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEmpezarActionPerformed
       js = new SocketTaTeTi();
       js.Iniciar();
       js.start();
       if (js.obtenerServidor()){
            this.setTitle("Servidor");
        }else{
            this.setTitle("Cliente");
        }
        jbtnEmpezar.setEnabled(false);
    }//GEN-LAST:event_jbtnEmpezarActionPerformed

    private void jbtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCerrarActionPerformed
        js.Cerrar();
    }//GEN-LAST:event_jbtnCerrarActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Tablero;
    private javax.swing.JButton jbtnCerrar;
    private javax.swing.JButton jbtnEmpezar;
    private javax.swing.JLabel jlblResultados;
    // End of variables declaration//GEN-END:variables
}
