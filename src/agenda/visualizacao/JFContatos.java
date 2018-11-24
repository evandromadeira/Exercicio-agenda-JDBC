package agenda.visualizacao;

import agenda.exception.AgendaException;
import agenda.controle.AgendaContatos;
import agenda.modelo.Pessoa;
import javax.swing.JOptionPane;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JFContatos extends javax.swing.JFrame {

    private AgendaContatos agenda;
    private Pessoa contato;

    public JFContatos() throws AgendaException {
        this.agenda = new AgendaContatos();
        initComponents();
        setLocationRelativeTo(null);
        atualizarLstContatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlDados = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        pnlBotoes = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        pnlConsulta = new javax.swing.JPanel();
        srcContatos = new javax.swing.JScrollPane();
        lstContatos = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlDados.setLayout(new java.awt.GridBagLayout());

        lblNome.setText("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlDados.add(lblNome, gridBagConstraints);

        lblEndereco.setText("Endereco");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlDados.add(lblEndereco, gridBagConstraints);

        lblTelefone.setText("Telefone");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlDados.add(lblTelefone, gridBagConstraints);

        txtNome.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlDados.add(txtNome, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlDados.add(txtEndereco, gridBagConstraints);

        txtTelefone.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlDados.add(txtTelefone, gridBagConstraints);

        getContentPane().add(pnlDados, java.awt.BorderLayout.CENTER);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        pnlBotoes.add(btnSalvar);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        pnlBotoes.add(btnExcluir);

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        pnlBotoes.add(btnLimpar);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        pnlBotoes.add(btnFechar);

        getContentPane().add(pnlBotoes, java.awt.BorderLayout.SOUTH);

        pnlConsulta.setLayout(new java.awt.BorderLayout());

        lstContatos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstContatos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstContatosValueChanged(evt);
            }
        });
        srcContatos.setViewportView(lstContatos);

        pnlConsulta.add(srcContatos, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlConsulta, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        boolean novo = false;

        if (contato == null) {
            contato = new Pessoa();
            novo = true;
        }
        contato.setNome(txtNome.getText());
        contato.setEndereco(txtEndereco.getText());
        contato.setTelefone(txtTelefone.getText());
        if (novo) {
            try {
                agenda.adicionar(contato);
            } catch (AgendaException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(),
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        limpar();
        atualizarLstContatos();
    }//GEN-LAST:event_btnSalvarActionPerformed

    /**
     * Atualiza os dados na Listagem
     */
    private void atualizarLstContatos() {
        lstContatos.setListData(new Vector(agenda.getContatos()));
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            agenda.remover(agenda.getContatos().indexOf(contato));
        } catch (AgendaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        limpar();
        atualizarLstContatos();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void lstContatosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstContatosValueChanged
        Pessoa c = (Pessoa) lstContatos.getSelectedValue();
        if (c != null) {
            contato = c;
            txtNome.setText(contato.getNome());
            txtEndereco.setText(contato.getEndereco());
            txtTelefone.setText(contato.getTelefone());
        }
    }//GEN-LAST:event_lstContatosValueChanged

    private void limpar() {
        contato = null;
        txtNome.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
}//GEN-LAST:event_btnLimparActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        System.exit(0);
}//GEN-LAST:event_btnFecharActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new JFContatos().setVisible(true);
                } catch (AgendaException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JList lstContatos;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JPanel pnlConsulta;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JScrollPane srcContatos;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
