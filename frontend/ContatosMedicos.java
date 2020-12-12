package frontend;

import backend.usuario.PessoaFisica;
import backend.Agenda;
import backend.Pessoa;
import javax.swing.table.DefaultTableModel;
import backend.usuario.Medico;
import backend.FuncoesArquivos;
/**
 *
 * @author leosa
 */
public class ContatosMedicos extends javax.swing.JFrame {
    PessoaFisica pessoa;
 
    public ContatosMedicos() {
    }
    public void receber(PessoaFisica pessoa){
        this.pessoa = pessoa;
        initComponents();
    }
    @SuppressWarnings("unchecked")
                    
    private void initComponents() {

        voltar = new javax.swing.JButton();
        novoContato = new javax.swing.JButton();
        excluirContato = new javax.swing.JButton();
        nomeMedico = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numeroMedico = new javax.swing.JTextField();
        salvarContato = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaContato = new javax.swing.JTable();
        cancelar = new javax.swing.JButton();
        especialidade = new javax.swing.JLabel();
        especialidadeMedico = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        voltar.setText("Retornar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        novoContato.setText("Novo contato");
        novoContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoContatoActionPerformed(evt);
            }
        });

        excluirContato.setText("Excluir");
        excluirContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirContatoActionPerformed(evt);
            }
        });

        nomeMedico.setEnabled(false);

        jLabel1.setText("Nome do Médico:");

        jLabel2.setText("Numero do telefone:");

        numeroMedico.setEnabled(false);

        salvarContato.setText("Salvar");
        salvarContato.setEnabled(false);
        salvarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarContatoActionPerformed(evt);
            }
        });

        tabelaContato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Número ", "Especialidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaContato);

        cancelar.setText("Cancelar");
        cancelar.setEnabled(false);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        especialidade.setText("Especialidade:");

        especialidadeMedico.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salvarContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numeroMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(especialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(especialidadeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(voltar)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(novoContato)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(excluirContato, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(voltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novoContato)
                    .addComponent(excluirContato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(especialidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(especialidadeMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(salvarContato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        DefaultTableModel val = (DefaultTableModel) tabelaContato.getModel();
        for(Pessoa medico : this.pessoa.getContatosMedicos().getContatos()){
            String nome = medico.getNome();
            String numero = medico.getTelefone();
            String especialidade = (String) medico.getParticularidade();
            val.addRow(new String[]{nome, numero, especialidade});   
        }

        pack();
        setLocationRelativeTo(null);
    }                      

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {                                       
        Home tela = new Home();
        tela.receber(pessoa);
        tela.setVisible(true);
        dispose();
    }                                      

    private void novoContatoActionPerformed(java.awt.event.ActionEvent evt) {                                            
        nomeMedico.setEnabled(true);
        numeroMedico.setEnabled(true);
        salvarContato.setEnabled(true);
        especialidadeMedico.setEnabled(true);
        cancelar.setEnabled(true);
    }                                           

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        ContatosMedicos emergencias = new ContatosMedicos();
        emergencias.receber(pessoa);
        emergencias.setVisible(true);
        dispose();
    }  

    private void salvarContatoActionPerformed(java.awt.event.ActionEvent evt) {                                              
        Agenda agendaTemp = this.pessoa.getContatosMedicos();
        if(agendaTemp == null){
            agendaTemp = new Agenda();
        }
        Medico medico = new Medico(nomeMedico.getText(), numeroMedico.getText(),"a", "b", especialidadeMedico.getText());
        medico.salvarDadosArquivo();
        this.pessoa.adicionarContatoMedico(medico);
        ContatosMedicos emergencias = new ContatosMedicos();
        emergencias.receber(pessoa);
        emergencias.setVisible(true);
        dispose();
    }

    private void excluirContatoActionPerformed(java.awt.event.ActionEvent evt) {                                               
        String nomeMedicoExcluir = tabelaContato.getValueAt(tabelaContato.getSelectedRow(),0).toString();
        Agenda agendaTemp = this.pessoa.getContatosMedicos();
        if(agendaTemp == null){
            return;
        }
        this.pessoa.removerContatoMedico(nomeMedicoExcluir);
        ContatosMedicos emergencias = new ContatosMedicos();
        emergencias.receber(pessoa);
        emergencias.setVisible(true);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ContatosMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContatosMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContatosMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContatosMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContatosMedicos().setVisible(true);
            }
        });
    }
                
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel especialidade;
    private javax.swing.JTextField especialidadeMedico;
    private javax.swing.JButton excluirContato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeMedico;
    private javax.swing.JButton novoContato;
    private javax.swing.JTextField numeroMedico;
    private javax.swing.JButton salvarContato;
    private javax.swing.JTable tabelaContato;
    private javax.swing.JButton voltar;           
}
