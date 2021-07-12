package vista;

import controlador.controladorConfigurarUsuario;
import java.awt.Color;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class vistaConfigurarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form vistaConfigurarUsuario
     */
    public vistaConfigurarUsuario() {
        initComponents();
        URL url = getClass().getResource("/imagenes/logoCarisma.jpg");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
    }
    public void setControladorConfigurarUsuario (controladorConfigurarUsuario objControladorConfigurarUsuario){

        volverBTN.addActionListener(objControladorConfigurarUsuario);
        AceptarUsuariorBTN.addActionListener(objControladorConfigurarUsuario);
        CancelarUsuarioBTN.addActionListener(objControladorConfigurarUsuario);
        AceptarPassBTN.addActionListener(objControladorConfigurarUsuario);
        CancelarPassBTN.addActionListener(objControladorConfigurarUsuario);

        volverBTN.setActionCommand(controladorConfigurarUsuario.botonVolver); 
        AceptarUsuariorBTN.setActionCommand(controladorConfigurarUsuario.botonAceptarUsuario); 
        CancelarUsuarioBTN.setActionCommand(controladorConfigurarUsuario.botonCancelarUsuario);
        AceptarPassBTN.setActionCommand(controladorConfigurarUsuario.botonAceptarPass); 
        CancelarPassBTN.setActionCommand(controladorConfigurarUsuario.botonCancelarPass); 
    }
    public void Mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public void despliegaPantalla(){
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void limpiar (){
        nombreAnteriorTB.setText("");
        nombreNuevoTB.setText("");
        contraAnteriorTB.setText("");
        contraNuevaTB.setText("");
        confirmarTB.setText("");
        nombreUsuarioTB.setText("");
        nombreAnteriorTB.requestFocus(); 
    }
    public String getNombreUsuarioAntiguo(){       
        String nombre =  nombreAnteriorTB.getText();
        return nombre;
    }
    public String getNombreUsuarioNuevo(){       
        String nombre =  nombreNuevoTB.getText();
        return nombre;
    }
    public String getPassAntigua(){       
        String pass1 = contraAnteriorTB.getText();
        return pass1;
    }
    public String getNombreUsuario(){       
        String pass1 = nombreUsuarioTB.getText();
        return pass1;
    }

    public String getPassNueva(){       
        String pass2 = contraNuevaTB.getText();
        return pass2;
    }
    public String getConfirmarPass(){       
        String pass3 = confirmarTB.getText();
        return pass3;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bodyPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        logoLBL = new javax.swing.JLabel();
        brandLBL1 = new javax.swing.JLabel();
        versionLBL1 = new javax.swing.JLabel();
        btnPanel = new javax.swing.JPanel();
        volverBTN = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        operationLBL = new javax.swing.JLabel();
        nombreAnteriorLBL = new javax.swing.JLabel();
        nombreAnteriorTB = new javax.swing.JTextField();
        nombreNuevoLBL = new javax.swing.JLabel();
        nombreNuevoTB = new javax.swing.JTextField();
        AceptarUsuariorBTN = new javax.swing.JButton();
        CancelarUsuarioBTN = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        operationLBL1 = new javax.swing.JLabel();
        contraNuevaLBL = new javax.swing.JLabel();
        contraNuevaTB = new javax.swing.JTextField();
        confirmarLBL = new javax.swing.JLabel();
        confirmarTB = new javax.swing.JTextField();
        contraAnteriorLBL = new javax.swing.JLabel();
        contraAnteriorTB = new javax.swing.JTextField();
        AceptarPassBTN = new javax.swing.JButton();
        CancelarPassBTN = new javax.swing.JButton();
        nombreUsuarioLBL = new javax.swing.JLabel();
        nombreUsuarioTB = new javax.swing.JTextField();
        copyrightLBL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(650, 470));
        setMinimumSize(new java.awt.Dimension(650, 470));
        setPreferredSize(new java.awt.Dimension(635, 470));

        bodyPanel.setBackground(java.awt.Color.white);
        bodyPanel.setPreferredSize(new java.awt.Dimension(635, 470));

        headerPanel.setBackground(new java.awt.Color(237, 239, 245));

        logoLBL.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        logoLBL.setForeground(new java.awt.Color(255, 255, 255));
        logoLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/shop 64x64.png"))); // NOI18N

        brandLBL1.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        brandLBL1.setForeground(new java.awt.Color(255, 255, 255));
        brandLBL1.setText("Punto De Venta");

        versionLBL1.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        versionLBL1.setForeground(new java.awt.Color(255, 255, 255));
        versionLBL1.setText("v 1.1");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(logoLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(brandLBL1)
                    .addComponent(versionLBL1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoLBL)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(brandLBL1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(versionLBL1)
                        .addGap(12, 12, 12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnPanel.setBackground(new java.awt.Color(38, 38, 38));
        btnPanel.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));

        volverBTN.setBackground(java.awt.Color.lightGray);
        volverBTN.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        volverBTN.setForeground(new java.awt.Color(255, 255, 255));
        volverBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/before 48x48.png"))); // NOI18N
        volverBTN.setText("Volver");
        volverBTN.setToolTipText("");
        volverBTN.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        volverBTN.setBorderPainted(false);
        volverBTN.setFocusPainted(false);
        volverBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        volverBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        volverBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                volverBTNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                volverBTNMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(volverBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPanelLayout.createSequentialGroup()
                .addContainerGap(351, Short.MAX_VALUE)
                .addComponent(volverBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jTabbedPane1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(517, 327));

        operationLBL.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        operationLBL.setText("Cambiar Usuario");

        nombreAnteriorLBL.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        nombreAnteriorLBL.setText("Nombre anterior");

        nombreAnteriorTB.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        nombreAnteriorTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreAnteriorTBKeyTyped(evt);
            }
        });

        nombreNuevoLBL.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        nombreNuevoLBL.setText("Nombre nuevo");

        nombreNuevoTB.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        nombreNuevoTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreNuevoTBKeyTyped(evt);
            }
        });

        AceptarUsuariorBTN.setBackground(java.awt.SystemColor.activeCaption);
        AceptarUsuariorBTN.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        AceptarUsuariorBTN.setText("Aceptar");

        CancelarUsuarioBTN.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        CancelarUsuarioBTN.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(operationLBL)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(AceptarUsuariorBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(CancelarUsuarioBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nombreNuevoLBL)
                                .addComponent(nombreAnteriorLBL))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nombreAnteriorTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nombreNuevoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(operationLBL)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreAnteriorTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreAnteriorLBL))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreNuevoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreNuevoLBL))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelarUsuarioBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AceptarUsuariorBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Modificar Usuario", new javax.swing.ImageIcon(getClass().getResource("/imagenes/user-16.png")), jPanel1); // NOI18N

        operationLBL1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        operationLBL1.setText("Cambiar Contraseña");

        contraNuevaLBL.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        contraNuevaLBL.setText("Nueva contraseña");

        contraNuevaTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        contraNuevaTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contraNuevaTBKeyTyped(evt);
            }
        });

        confirmarLBL.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        confirmarLBL.setText("Confirmar contraseña");

        confirmarTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        confirmarTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                confirmarTBKeyTyped(evt);
            }
        });

        contraAnteriorLBL.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        contraAnteriorLBL.setText("Contraseña anterior");

        contraAnteriorTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        contraAnteriorTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contraAnteriorTBKeyTyped(evt);
            }
        });

        AceptarPassBTN.setBackground(java.awt.SystemColor.activeCaption);
        AceptarPassBTN.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        AceptarPassBTN.setText("Aceptar");

        CancelarPassBTN.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        CancelarPassBTN.setText("Cancelar");

        nombreUsuarioLBL.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        nombreUsuarioLBL.setText("Nombre de usuario");

        nombreUsuarioTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        nombreUsuarioTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreUsuarioTBKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(operationLBL1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(AceptarPassBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(CancelarPassBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(contraNuevaLBL)
                                .addComponent(contraAnteriorLBL)
                                .addComponent(confirmarLBL))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(contraAnteriorTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(contraNuevaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(confirmarTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(nombreUsuarioLBL)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nombreUsuarioTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(operationLBL1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreUsuarioTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreUsuarioLBL))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraAnteriorTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contraAnteriorLBL))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraNuevaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contraNuevaLBL))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmarTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmarLBL))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelarPassBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AceptarPassBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Modificar Contraseña", new javax.swing.ImageIcon(getClass().getResource("/imagenes/key_16.png")), jPanel2); // NOI18N

        copyrightLBL.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        copyrightLBL.setText("© 2016 - 2017 Freelancer, Chile.");

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addGap(351, 351, 351)
                                .addComponent(copyrightLBL))
                            .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(copyrightLBL)
                .addGap(32, 32, 32))
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 459, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBTNMouseEntered
        volverBTN.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_volverBTNMouseEntered

    private void volverBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBTNMouseExited
        volverBTN.setBackground(Color.LIGHT_GRAY);        
    }//GEN-LAST:event_volverBTNMouseExited

    private void nombreAnteriorTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreAnteriorTBKeyTyped
        if (nombreAnteriorTB.getText().length() == 15) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_nombreAnteriorTBKeyTyped

    private void nombreNuevoTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreNuevoTBKeyTyped
        if (nombreNuevoTB.getText().length() == 15) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_nombreNuevoTBKeyTyped

    private void nombreUsuarioTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreUsuarioTBKeyTyped
        if (nombreUsuarioTB.getText().length() == 15) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_nombreUsuarioTBKeyTyped

    private void contraAnteriorTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraAnteriorTBKeyTyped
        if (contraAnteriorTB.getText().length() == 10) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_contraAnteriorTBKeyTyped

    private void contraNuevaTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraNuevaTBKeyTyped
        if (contraNuevaTB.getText().length() == 10) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_contraNuevaTBKeyTyped

    private void confirmarTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmarTBKeyTyped
        if (confirmarTB.getText().length() == 10) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_confirmarTBKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarPassBTN;
    private javax.swing.JButton AceptarUsuariorBTN;
    private javax.swing.JButton CancelarPassBTN;
    private javax.swing.JButton CancelarUsuarioBTN;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel brandLBL1;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JLabel confirmarLBL;
    private javax.swing.JTextField confirmarTB;
    private javax.swing.JLabel contraAnteriorLBL;
    private javax.swing.JTextField contraAnteriorTB;
    private javax.swing.JLabel contraNuevaLBL;
    private javax.swing.JTextField contraNuevaTB;
    private javax.swing.JLabel copyrightLBL;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel logoLBL;
    private javax.swing.JLabel nombreAnteriorLBL;
    private javax.swing.JTextField nombreAnteriorTB;
    private javax.swing.JLabel nombreNuevoLBL;
    private javax.swing.JTextField nombreNuevoTB;
    private javax.swing.JLabel nombreUsuarioLBL;
    private javax.swing.JTextField nombreUsuarioTB;
    private javax.swing.JLabel operationLBL;
    private javax.swing.JLabel operationLBL1;
    private javax.swing.JLabel versionLBL1;
    private javax.swing.JButton volverBTN;
    // End of variables declaration//GEN-END:variables
}
