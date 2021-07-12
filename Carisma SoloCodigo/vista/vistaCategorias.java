package vista;

import controlador.controladorCategorias;
import java.awt.Color;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.categoriaDAO;
public class vistaCategorias extends javax.swing.JFrame {
    DefaultTableModel temp;

    /**
     * Creates new form vistaCategorias
     */
    public vistaCategorias() {
        initComponents();
        URL url = getClass().getResource("/imagenes/logoCarisma.jpg");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
        ocultarpanel();
    }
    public void despliegaPantalla(){
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void Mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public void setControladorCategorias (controladorCategorias objControladorCategorias){

        guardarBTN.addActionListener(objControladorCategorias);
        modificarBTN.addActionListener(objControladorCategorias);
        volverBTN.addActionListener(objControladorCategorias);
        aceptarBTN.addActionListener(objControladorCategorias);
        cancelarBTN.addActionListener(objControladorCategorias);        
        
        guardarBTN.setActionCommand(controladorCategorias.botonGuardar);
        modificarBTN.setActionCommand(controladorCategorias.botonModificar);
        volverBTN.setActionCommand(controladorCategorias.botonVolver);
        aceptarBTN.setActionCommand(controladorCategorias.botonAceptar);
        cancelarBTN.setActionCommand(controladorCategorias.botonCancelar);

        
    }
        public void cargarCombo (ArrayList listaCategoria){
        categoriaCB.removeAllItems();
        categoriaCB.addItem("Seleccionar");
        for (int i = 0; i < listaCategoria.size(); i++) {
            String categoria = listaCategoria.get(i).toString();
            this.categoriaCB.addItem(categoria);
        }
    }
    public void Limpiar(){
        nombreCategoriaTB.setText("");
        nombreCategoriaTB.requestFocus(); 
        
    }
    public String getNombreCategoriaTB(){       
        String nombre =  nombreCategoriaTB.getText();
        return nombre;
    }
    public String getNombreCategoriaCB(){       
        String nombre = categoriaCB.getSelectedItem().toString();
        return nombre;
    }

    public void ocultarCB(){
        categoriaCB.setVisible(false);
    }
        public void mostrarCB(){
        categoriaCB.setVisible(true);
    }
    public void mostrarpanel(){
        panelmodificar.setVisible(true);
    }
    public void ocultarpanel(){
        panelmodificar.setVisible(false);
    }
    public void botoncancelar(){
        ocultarpanel();
        mostrarCB();
    }
    public void llenarTB(String categoria){
        nuevacategoriaTB.setText(categoria);
    }
    public String getCB(){
        String categoria = categoriaCB.getSelectedItem().toString();
        return categoria;
    }
    public String getTB(){
        String nuevo = nuevacategoriaTB.getText();
        return nuevo;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bodyPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        imgBrandLBL = new javax.swing.JLabel();
        rightsPanel = new javax.swing.JPanel();
        copyrightLBL = new javax.swing.JLabel();
        brandLBL = new javax.swing.JLabel();
        versionLBL = new javax.swing.JLabel();
        btnPanel = new javax.swing.JPanel();
        guardarBTN = new javax.swing.JButton();
        modificarBTN = new javax.swing.JButton();
        volverBTN = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        operationLBL = new javax.swing.JLabel();
        nomLBL = new javax.swing.JLabel();
        nombreCategoriaTB = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        operation2LBL = new javax.swing.JLabel();
        categoriaCB = new javax.swing.JComboBox<>();
        panelmodificar = new javax.swing.JPanel();
        aceptarBTN = new javax.swing.JButton();
        cancelarBTN = new javax.swing.JButton();
        nuevacategoriaTB = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        seleccionarLBL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setUndecorated(true);

        bodyPanel.setBackground(java.awt.Color.white);
        bodyPanel.setPreferredSize(new java.awt.Dimension(1080, 720));

        headerPanel.setBackground(new java.awt.Color(202, 18, 30));

        imgBrandLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.jpg"))); // NOI18N

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgBrandLBL)
                .addContainerGap(930, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgBrandLBL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );

        rightsPanel.setBackground(java.awt.Color.darkGray);

        copyrightLBL.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        copyrightLBL.setForeground(new java.awt.Color(255, 255, 255));
        copyrightLBL.setText("© 2016 Freelancer, Chile.");

        brandLBL.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        brandLBL.setForeground(new java.awt.Color(255, 255, 255));
        brandLBL.setText("Punto De Venta");

        versionLBL.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        versionLBL.setForeground(new java.awt.Color(255, 255, 255));
        versionLBL.setText("v 1.0");

        javax.swing.GroupLayout rightsPanelLayout = new javax.swing.GroupLayout(rightsPanel);
        rightsPanel.setLayout(rightsPanelLayout);
        rightsPanelLayout.setHorizontalGroup(
            rightsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(brandLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(versionLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(copyrightLBL)
                .addGap(19, 19, 19))
        );
        rightsPanelLayout.setVerticalGroup(
            rightsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightsPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(rightsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(brandLBL)
                        .addComponent(versionLBL))
                    .addComponent(copyrightLBL))
                .addContainerGap())
        );

        btnPanel.setBackground(java.awt.Color.lightGray);
        btnPanel.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));

        guardarBTN.setBackground(java.awt.Color.lightGray);
        guardarBTN.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        guardarBTN.setForeground(new java.awt.Color(255, 255, 255));
        guardarBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/More_2-64.png"))); // NOI18N
        guardarBTN.setText("Guardar Nuevo");
        guardarBTN.setToolTipText("");
        guardarBTN.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        guardarBTN.setBorderPainted(false);
        guardarBTN.setFocusPainted(false);
        guardarBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardarBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guardarBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                guardarBTNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                guardarBTNMouseExited(evt);
            }
        });

        modificarBTN.setBackground(java.awt.Color.lightGray);
        modificarBTN.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        modificarBTN.setForeground(new java.awt.Color(255, 255, 255));
        modificarBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificarIconx64.png"))); // NOI18N
        modificarBTN.setText("Modificar");
        modificarBTN.setToolTipText("");
        modificarBTN.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        modificarBTN.setBorderPainted(false);
        modificarBTN.setFocusPainted(false);
        modificarBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modificarBTN.setMaximumSize(new java.awt.Dimension(64, 82));
        modificarBTN.setMinimumSize(new java.awt.Dimension(64, 82));
        modificarBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        modificarBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarBTNMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                modificarBTNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                modificarBTNMouseExited(evt);
            }
        });

        volverBTN.setBackground(java.awt.Color.lightGray);
        volverBTN.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        volverBTN.setForeground(new java.awt.Color(255, 255, 255));
        volverBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Previous_2-64.png"))); // NOI18N
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
            .addComponent(guardarBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
            .addComponent(modificarBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(volverBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addComponent(guardarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(modificarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volverBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        operationLBL.setFont(new java.awt.Font("Lucida Console", 0, 36)); // NOI18N
        operationLBL.setText("Datos de la Categoría");

        nomLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        nomLBL.setText("Nombre");

        nombreCategoriaTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        nombreCategoriaTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreCategoriaTBKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(operationLBL)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nomLBL)
                        .addGap(90, 90, 90)
                        .addComponent(nombreCategoriaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(428, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(operationLBL)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomLBL)
                    .addComponent(nombreCategoriaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(410, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nuevo / Modificar", new javax.swing.ImageIcon(getClass().getResource("/imagenes/settings-16.png")), jPanel1); // NOI18N

        operation2LBL.setFont(new java.awt.Font("Lucida Console", 0, 36)); // NOI18N
        operation2LBL.setText("Buscar Categoría");

        categoriaCB.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        categoriaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        aceptarBTN.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        aceptarBTN.setText("Aceptar");

        cancelarBTN.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        cancelarBTN.setText("Cancelar");

        nuevacategoriaTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nuevacategoriaTBKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        jLabel1.setText("Ingrese Nuevo Nombre");

        javax.swing.GroupLayout panelmodificarLayout = new javax.swing.GroupLayout(panelmodificar);
        panelmodificar.setLayout(panelmodificarLayout);
        panelmodificarLayout.setHorizontalGroup(
            panelmodificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmodificarLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panelmodificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(aceptarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(panelmodificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nuevacategoriaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        panelmodificarLayout.setVerticalGroup(
            panelmodificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmodificarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelmodificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevacategoriaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(panelmodificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        seleccionarLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        seleccionarLBL.setText("Seleccione Categoría");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(panelmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(seleccionarLBL)
                            .addComponent(operation2LBL))
                        .addGap(18, 18, 18)
                        .addComponent(categoriaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(operation2LBL)
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoriaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seleccionarLBL))
                .addGap(18, 18, 18)
                .addComponent(panelmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buscar", new javax.swing.ImageIcon(getClass().getResource("/imagenes/search-16.png")), jPanel2); // NOI18N

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addComponent(rightsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(rightsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarBTNMouseClicked
               
    }//GEN-LAST:event_modificarBTNMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        categoriaDAO categoria = new categoriaDAO();
        ArrayList listacategoria = categoria.rescatarcategoria();
        cargarCombo(listacategoria);
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void guardarBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarBTNMouseEntered
        guardarBTN.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_guardarBTNMouseEntered

    private void guardarBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarBTNMouseExited
        guardarBTN.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_guardarBTNMouseExited

    private void modificarBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarBTNMouseEntered
        modificarBTN.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_modificarBTNMouseEntered

    private void modificarBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarBTNMouseExited
        modificarBTN.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_modificarBTNMouseExited

    private void volverBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBTNMouseEntered
        volverBTN.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_volverBTNMouseEntered

    private void volverBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBTNMouseExited
        volverBTN.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_volverBTNMouseExited

    private void nombreCategoriaTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreCategoriaTBKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();

            evt.consume();

        }
        if (nombreCategoriaTB.getText().length() == 30) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_nombreCategoriaTBKeyTyped

    private void nuevacategoriaTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevacategoriaTBKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();

            evt.consume();

        }
        if (nuevacategoriaTB.getText().length() == 30) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_nuevacategoriaTBKeyTyped

    public void botonmodificar(){
        if (!categoriaCB.getSelectedItem().toString().equals("Seleccionar")) {
             mostrarpanel();
             ocultarCB();
             llenarTB(getCB());
        }else{
            Mensaje("Seleccione item");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBTN;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel brandLBL;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton cancelarBTN;
    private javax.swing.JComboBox<String> categoriaCB;
    private javax.swing.JLabel copyrightLBL;
    private javax.swing.JButton guardarBTN;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel imgBrandLBL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton modificarBTN;
    private javax.swing.JLabel nomLBL;
    private javax.swing.JTextField nombreCategoriaTB;
    private javax.swing.JTextField nuevacategoriaTB;
    private javax.swing.JLabel operation2LBL;
    private javax.swing.JLabel operationLBL;
    private javax.swing.JPanel panelmodificar;
    private javax.swing.JPanel rightsPanel;
    private javax.swing.JLabel seleccionarLBL;
    private javax.swing.JLabel versionLBL;
    private javax.swing.JButton volverBTN;
    // End of variables declaration//GEN-END:variables
}
