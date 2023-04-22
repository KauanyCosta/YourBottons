/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelDominio.Bottons;
import view.util.Imagem;

/**
 *
 * @author Kauany
 */
public class FormAlterarBottons extends javax.swing.JDialog {

    private int codigo;
    private Imagem imagem = null;

    /**
     * Creates new form FormInserirBottons
     */
    public FormAlterarBottons(Bottons bottonS) {
        initComponents();
        this.codigo = bottonS.getCodBottom();
        jTFNome.setText(bottonS.getNome());
        jTFValor.setText(bottonS.getPrecoString());
        jTFQuantidade.setText(Integer.toString(bottonS.getQuantEstoque()));
        jTFPersonalizacao.setText(bottonS.getDescricao());
        jTFData.setText(bottonS.getDataLancamentoString());
        imagem = new Imagem(bottonS.getImagem());
        jLImagem.setIcon(imagem.getImageIcon());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBSalvar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTFPersonalizacao = new javax.swing.JTextField();
        jTFValor = new javax.swing.JFormattedTextField();
        jTFData = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFQuantidade = new javax.swing.JFormattedTextField();
        jBVoltar = new javax.swing.JButton();
        jLImagem = new javax.swing.JLabel();
        jBCarregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add/Alterar/Excluir  Bottons");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(230, 215, 255));

        jLabel1.setText("Nome:");

        jTFNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Valor:");

        jLabel3.setText("Data de Lançamento:");

        jLabel4.setText("Imagem:");

        jBSalvar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jBSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/salvar.png"))); // NOI18N
        jBSalvar.setText("Salvar");
        jBSalvar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBCancelar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/cancelar (1).png"))); // NOI18N
        jBCancelar.setText("Cancelar");
        jBCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Personalização:");

        jTFPersonalizacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTFValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTFData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTFData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jLabel6.setText("Quantidade em Estoque:");

        jTFQuantidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTFQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jTFQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFQuantidadeActionPerformed(evt);
            }
        });

        jBVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/icons8-back-arrow-30.png"))); // NOI18N
        jBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVoltarActionPerformed(evt);
            }
        });

        jLImagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jBCarregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/addimagem.png"))); // NOI18N
        jBCarregar.setText("Carregar Imagem");
        jBCarregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jBCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCarregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBVoltar)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTFPersonalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(30, 30, 30)
                            .addComponent(jLImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jBCarregar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 102, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                            .addComponent(jTFPersonalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBVoltar)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(33, 33, 33))
                            .addComponent(jLabel5))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jBCarregar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jBVoltarActionPerformed

    private void jTFQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFQuantidadeActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        limpaCampos();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if (!jTFNome.getText().isEmpty()) {
            if (!jTFValor.getText().isEmpty()) {
                if (!jTFQuantidade.getText().isEmpty()) {
                    if (!jTFPersonalizacao.getText().isEmpty()) {

                        String precoDesformatado = jTFValor.getText();
                        precoDesformatado = precoDesformatado.replace(".", "");
                        precoDesformatado = precoDesformatado.replace(",", ".");
                        float preco = Float.parseFloat(precoDesformatado);
                        if (preco > 0) {
                            if (!jTFData.getText().isEmpty()) {
                                int retorno = JOptionPane.showConfirmDialog(this, "Tem certeza?", this.getTitle(), JOptionPane.YES_NO_OPTION);
                                if (retorno == JOptionPane.YES_OPTION) {
                                    //se foi preenchido o usuario pode fazer a inserção
                                    String nome = jTFNome.getText();
                                    String personalizacao = jTFPersonalizacao.getText();
                                    int quantidade = Integer.parseInt(jTFQuantidade.getText());
                                    Date datalancamento = null;

                                    try {
                                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                                        datalancamento = formato.parse(jTFData.getText());
                                    } catch (ParseException ex) {
                                        Logger.getLogger(FormAlterarBottons.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    Bottons bt = new Bottons(codigo, nome, preco, personalizacao, quantidade, datalancamento, imagem.getImagem());

                                    boolean ok = BottonsCliente.ccont.bottomAlterar(bt);
                                    if (ok) {
                                        JOptionPane.showMessageDialog(this, "Bottom alterado com sucesso", this.getTitle(),
                                                JOptionPane.INFORMATION_MESSAGE);
                                        limpaCampos();
                                        dispose();

                                    } else {
                                        JOptionPane.showMessageDialog(this, "Erro ao alterar bottom", this.getTitle(),
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Prencha o campo: Data!", this.getTitle(), JOptionPane.ERROR_MESSAGE);
                                jTFData.requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Prencha o campo: Valor!", this.getTitle(), JOptionPane.ERROR_MESSAGE);
                            jTFValor.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Prencha o campo: Personalização!", this.getTitle(), JOptionPane.ERROR_MESSAGE);
                        jTFPersonalizacao.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Prencha o campo: Quantidade!", this.getTitle(), JOptionPane.ERROR_MESSAGE);
                    jTFQuantidade.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Prencha o campo: Valor!", this.getTitle(), JOptionPane.ERROR_MESSAGE);
                jTFValor.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Prencha o campo: Nome!", this.getTitle(), JOptionPane.ERROR_MESSAGE);
            jTFNome.requestFocus();
        }

    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCarregarActionPerformed
         FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Imagens", ImageIO.getReaderFileSuffixes());
        jFileChooser1.addChoosableFileFilter(imageFilter);
        if (jFileChooser1.showOpenDialog(this) == jFileChooser1.APPROVE_OPTION) {
            imagem = new Imagem(jFileChooser1.getSelectedFile());
            jLImagem.setIcon(imagem.getImageIcon());
        }
    }//GEN-LAST:event_jBCarregarActionPerformed

    public void limpaCampos() {
        jTFNome.setText("");
        jTFData.setText("");
        jTFPersonalizacao.setText("");
        jTFQuantidade.setText("");
        jTFValor.setText("");
        jLImagem.setIcon(null);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBCarregar;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLImagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField jTFData;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFPersonalizacao;
    private javax.swing.JFormattedTextField jTFQuantidade;
    private javax.swing.JFormattedTextField jTFValor;
    // End of variables declaration//GEN-END:variables
}
