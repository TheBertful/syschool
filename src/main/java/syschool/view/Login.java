/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syschool.view;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import syschool.controllers.AlunoController;
import syschool.controllers.ProfessorController;
import syschool.models.Aluno;
import syschool.models.Professor;

/**
 *
 * @author Hugo
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSyschool = new javax.swing.JLabel();
        lbMatricula = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        pwSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbSyschool.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbSyschool.setText("syschool");

        lbMatricula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbMatricula.setText("Matrícula:");

        lbSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSenha.setText("Senha:");

        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                enter(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnSair))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbSenha)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 87, Short.MAX_VALUE)
                                .addComponent(btnLogin))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(pwSenha))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbMatricula)
                        .addGap(14, 14, 14)
                        .addComponent(txtMatricula)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbSyschool)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSyschool)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMatricula)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSenha)
                    .addComponent(pwSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnLogin))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        if (txtMatricula.getText().isEmpty() || Arrays.toString(pwSenha.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.");
        }

        AlunoController ac = new AlunoController();
        ProfessorController pc = new ProfessorController();
        
        // Aluno
        if (txtMatricula.getText().startsWith("1")) {
            try {
                Aluno[] alunos = ac.list();
                
                for (Aluno aluno : alunos) {
                    if ((aluno.getMatricula() == Integer.parseInt(txtMatricula.getText())) && (aluno.getSenha().equals(Arrays.toString(pwSenha.getPassword())))) {
                        MenuAluno mAluno = new MenuAluno(Integer.parseInt(txtMatricula.getText()));
                        mAluno.setVisible(true);
                        this.dispose();
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // Professor
        if (txtMatricula.getText().startsWith("2")) {
            try {
                Professor[] professores = pc.list();
                
                for (Professor professor : professores) {
                    if (professor.getMatricula() == Integer.parseInt(txtMatricula.getText()) && (professor.getSenha().equals(Arrays.toString(pwSenha.getPassword())))) {
                        MenuProfessor mProf = new MenuProfessor(Integer.parseInt(txtMatricula.getText()));
                        mProf.setVisible(true);
                        this.dispose();
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // Coordenador
        if (txtMatricula.getText().startsWith("3")) {
            try {
                Professor[] professores = pc.list();

                for (Professor professor : professores) {
                    if (professor.getMatricula() == Integer.parseInt(txtMatricula.getText()) && (professor.getSenha().equals(Arrays.toString(pwSenha.getPassword())))) {
                        MenuCoordenador mCoordenador = new MenuCoordenador(Integer.parseInt(txtMatricula.getText()));
                        mCoordenador.setVisible(true);
                        this.dispose();
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // Admin
        if (txtMatricula.getText().startsWith("4")) {
            try {
                Professor[] professores = pc.list();

                for (Professor professor : professores) {
                    if (professor.getMatricula() == Integer.parseInt(txtMatricula.getText()) && (professor.getSenha().equals(Arrays.toString(pwSenha.getPassword())))) {
                        MenuAdmin mAdm = new MenuAdmin(Integer.parseInt(txtMatricula.getText()));
                        mAdm.setVisible(true);
                        this.dispose();
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void enter(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enter
        // TODO add your handling code here:
    }//GEN-LAST:event_enter

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lbMatricula;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbSyschool;
    private javax.swing.JPasswordField pwSenha;
    private javax.swing.JTextField txtMatricula;
    // End of variables declaration//GEN-END:variables
}