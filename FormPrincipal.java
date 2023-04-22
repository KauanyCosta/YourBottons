/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import modelDominio.Bottons;
import modelDominio.Usuario;

/**
 *
 * @author Kauany
 */
public class FormPrincipal extends javax.swing.JDialog {

    /**
     * Creates new form FormPrincipal
     */
    public FormPrincipal(Usuario usrSelecionado) {
        initComponents();
        
        int tipo = usrSelecionado.getTipo();
        if (tipo == 2) {
            jBCompras1.setEnabled(false);
            jBUsuarios.setEnabled(false);
        }
        
        jBBottons.setBackground(Color.white);
        jBUsuarios.setBackground(Color.white);
        jBCompras1.setBackground(Color.white);
        jBSair.setBackground(Color.white);
        jBSugestoes.setBackground(Color.white);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBBottons = new javax.swing.JButton();
        jBUsuarios = new javax.swing.JButton();
        jBSugestoes = new javax.swing.JButton();
        jBCompras1 = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Principal");
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(230, 215, 255));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel1.setText("Bem vindo(a)! Deseja:");

        jBBottons.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jBBottons.setText("Bottons");
        jBBottons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBottonsActionPerformed(evt);
            }
        });

        jBUsuarios.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jBUsuarios.setText("Usuários");
        jBUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUsuariosActionPerformed(evt);
            }
        });

        jBSugestoes.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jBSugestoes.setText("Sugestões");
        jBSugestoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSugestoesActionPerformed(evt);
            }
        });

        jBCompras1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jBCompras1.setText("Compras");
        jBCompras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCompras1ActionPerformed(evt);
            }
        });

        jBSair.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jBSair.setText("Sair");
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBBottons, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jBCompras1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSugestoes, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBBottons, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBSugestoes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBCompras1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBBottonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBottonsActionPerformed
        FormBottonsEstoque frmbttns = new FormBottonsEstoque();
        frmbttns.setModal(true);
        frmbttns.setVisible(true);
    }//GEN-LAST:event_jBBottonsActionPerformed

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        dispose();
        FormLogin frmlg = new FormLogin();
        frmlg.setModal(true);
        frmlg.setVisible(true);
    }//GEN-LAST:event_jBSairActionPerformed

    private void jBUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUsuariosActionPerformed
        FormUsuarios frmusr = new FormUsuarios();
        frmusr.setModal(true);
        frmusr.setVisible(true);
    }//GEN-LAST:event_jBUsuariosActionPerformed

    private void jBCompras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCompras1ActionPerformed
        FormCompras frmcprs = new FormCompras();
        frmcprs.setModal(true);
        frmcprs.setVisible(true);
    }//GEN-LAST:event_jBCompras1ActionPerformed

    private void jBSugestoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSugestoesActionPerformed
        FormSugestao frsgt = new FormSugestao();
        frsgt.setModal(true);
        frsgt.setVisible(true);
    }//GEN-LAST:event_jBSugestoesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBottons;
    private javax.swing.JButton jBCompras1;
    private javax.swing.JButton jBSair;
    private javax.swing.JButton jBSugestoes;
    private javax.swing.JButton jBUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
