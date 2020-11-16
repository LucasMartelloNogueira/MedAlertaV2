package FrontEnd;
public class login extends javax.swing.JFrame {

    public login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
                     
    private void initComponents() {

        NaoMexerNisso = new javax.swing.JPanel();
        nome_l = new javax.swing.JLabel();
        Nome_l_e = new javax.swing.JTextField();
        idade_l = new javax.swing.JLabel();
        idade_l_e = new javax.swing.JTextField();
        endereco_l = new javax.swing.JLabel();
        endereco_l_e = new javax.swing.JTextField();
        prox_l = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NaoMexerNisso.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));

        nome_l.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nome_l.setText("Nome competo:");
        nome_l.setToolTipText("");

        Nome_l_e.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Nome_l_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nome_l_eActionPerformed(evt);
            }
        });

        idade_l.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idade_l.setText("Idade:");
        idade_l.setToolTipText("");

        idade_l_e.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idade_l_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idade_l_eActionPerformed(evt);
            }
        });

        endereco_l.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        endereco_l.setText("Endereço:");
        endereco_l.setToolTipText("");

        endereco_l_e.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        endereco_l_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endereco_l_eActionPerformed(evt);
            }
        });

        prox_l.setText("Prox.");
        prox_l.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prox_lActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NaoMexerNissoLayout = new javax.swing.GroupLayout(NaoMexerNisso);
        NaoMexerNisso.setLayout(NaoMexerNissoLayout);
        NaoMexerNissoLayout.setHorizontalGroup(
            NaoMexerNissoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NaoMexerNissoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NaoMexerNissoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idade_l)
                    .addComponent(nome_l)
                    .addComponent(endereco_l))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NaoMexerNissoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NaoMexerNissoLayout.createSequentialGroup()
                        .addGroup(NaoMexerNissoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nome_l_e, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endereco_l_e, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(162, Short.MAX_VALUE))
                    .addGroup(NaoMexerNissoLayout.createSequentialGroup()
                        .addComponent(idade_l_e, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prox_l)
                        .addGap(40, 40, 40))))
        );
        NaoMexerNissoLayout.setVerticalGroup(
            NaoMexerNissoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NaoMexerNissoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(NaoMexerNissoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome_l, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nome_l_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NaoMexerNissoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idade_l, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idade_l_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prox_l, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NaoMexerNissoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endereco_l, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endereco_l_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NaoMexerNisso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NaoMexerNisso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(639, 287));
        setLocationRelativeTo(null);
    }                     

    private void Nome_l_eActionPerformed(java.awt.event.ActionEvent evt) {                                         

    }                                        

    private void idade_l_eActionPerformed(java.awt.event.ActionEvent evt) {                                          
   
    }                                         

    private void endereco_l_eActionPerformed(java.awt.event.ActionEvent evt) {                                             
 
    }                        
                        
    //Importante é isso
    private void prox_lActionPerformed(java.awt.event.ActionEvent evt) {
        String NomeCompletoLogin = Nome_l_e.getText();
        String idadeLogin = idade_l_e.getText();
        String enderecoLogin =  endereco_l_e.getText();
        home tela = new home();
        tela.receber(NomeCompletoLogin, idadeLogin,enderecoLogin);
        tela.setVisible(true);
        dispose();
    }                              

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }               
    private javax.swing.JPanel NaoMexerNisso;
    public javax.swing.JTextField Nome_l_e;
    private javax.swing.JLabel endereco_l;
    private javax.swing.JTextField endereco_l_e;
    private javax.swing.JLabel idade_l;
    private javax.swing.JTextField idade_l_e;
    private javax.swing.JLabel nome_l;
    private javax.swing.JButton prox_l;                
}
