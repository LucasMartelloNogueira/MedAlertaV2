package FrontEnd;

public class home extends javax.swing.JFrame {
    String Nomedapessoah;
    String idadedapessoah;
    String enderecodapessoah;

    public home() {}

    public void receber(String _nome, String _idade,String _endereco){
        Nomedapessoah = _nome;
        idadedapessoah = _idade;
        enderecodapessoah = _endereco;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")

    private void initComponents() {
        NaoMexerNissoHome = new javax.swing.JPanel();
        Nome_home = new javax.swing.JLabel();
        idade_home = new javax.swing.JLabel();
        endereco_home = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Nome_home.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Nome_home.setText(Nomedapessoah);

        idade_home.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idade_home.setText(idadedapessoah);

        endereco_home.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        endereco_home.setText(enderecodapessoah);

        javax.swing.GroupLayout NaoMexerNissoHomeLayout = new javax.swing.GroupLayout(NaoMexerNissoHome);
        NaoMexerNissoHome.setLayout(NaoMexerNissoHomeLayout);
        NaoMexerNissoHomeLayout.setHorizontalGroup(
            NaoMexerNissoHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NaoMexerNissoHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NaoMexerNissoHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(endereco_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(NaoMexerNissoHomeLayout.createSequentialGroup()
                        .addComponent(Nome_home, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(idade_home, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        NaoMexerNissoHomeLayout.setVerticalGroup(
            NaoMexerNissoHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NaoMexerNissoHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NaoMexerNissoHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idade_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nome_home, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endereco_home, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NaoMexerNissoHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NaoMexerNissoHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(639, 287));
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new home().setVisible(true);
            }
        });
    }                   
    private javax.swing.JPanel NaoMexerNissoHome;
    public javax.swing.JLabel Nome_home;
    public javax.swing.JLabel endereco_home;
    public javax.swing.JLabel idade_home;
}

