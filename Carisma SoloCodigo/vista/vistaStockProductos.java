package vista;

import controlador.controladorStockProductos;
import java.awt.Color;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class vistaStockProductos extends javax.swing.JFrame {
    //NUEVO
    String retorno;
    DefaultTableModel temp;
  
    public vistaStockProductos() {
        initComponents();
        URL url = getClass().getResource("/imagenes/logoCarisma.jpg");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
    }
    public void setControladorStockProductos (controladorStockProductos objControladorStockProductos){

//        exportarBTN.addActionListener(objControladorStockProductos);
        volverBTN.addActionListener(objControladorStockProductos);
        buscarBTN.addActionListener(objControladorStockProductos);
        buscarTodosBTN.addActionListener(objControladorStockProductos);
        guardarBTN.addActionListener(objControladorStockProductos);
        
//        exportarBTN.setActionCommand(controladorStockProductos.botonExportar);
        volverBTN.setActionCommand(controladorStockProductos.botonVolver); 
        buscarBTN.setActionCommand(controladorStockProductos.botonBuscar); 
        buscarTodosBTN.setActionCommand(controladorStockProductos.botonBuscarTodo); 
        guardarBTN.setActionCommand(controladorStockProductos.botonGuardar);
    }
    //NUEVO
    public void LimpiarTabla(){
        try{
            temp = (DefaultTableModel) productosJT.getModel();
            int a =temp.getRowCount()-1;
            for(int i=a; i>=0; i--){
                temp.removeRow(i); 
            }
        }catch(Exception e){
            System.out.println(e);
        }
        busquedaTB.setText("");
        
    }
    //NUEVO
    public String saberradio() {
                if (codigoProductoRB.isSelected()) {
                    retorno = "codigoProducto";
                }else if (nombreProductoRB.isSelected()) {
                    retorno = "nombreProducto";
                }
        return retorno;     
    } 
    
    //NUEVO
    public String getBusqueda(){
        return busquedaTB.getText();
    }
    //NUEVO
    public void Mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    //NUEVO
    public void tabla(String codigoProducto, String nombreProducto, String descProducto, String categoriaProducto,
            String marcaProducto,String stockProducto, String colorProducto, String tallaProducto, double precioProducto,
            double costoProducto, double utilidadProducto, int y){

        DefaultTableModel dt =(DefaultTableModel)this.productosJT.getModel();
                   dt.addRow(new Object[y]);
                   for (int i = 0; i < y; i++) {
                    this.productosJT.setValueAt(codigoProducto , y-1 , 0);
                    this.productosJT.setValueAt(nombreProducto , y-1 , 1);
                    this.productosJT.setValueAt(descProducto, y-1 , 2);
                    this.productosJT.setValueAt(categoriaProducto, y-1, 3) ;
                    this.productosJT.setValueAt(marcaProducto , y-1, 4) ;
                    this.productosJT.setValueAt(stockProducto , y-1, 5) ;
                    this.productosJT.setValueAt(colorProducto , y-1, 6) ;
                    this.productosJT.setValueAt(tallaProducto, y-1, 7) ;
                    this.productosJT.setValueAt(precioProducto , y-1, 8) ;
                    this.productosJT.setValueAt(costoProducto , y-1, 9) ;
                    this.productosJT.setValueAt(utilidadProducto , y-1, 10) ;
        }
    }
    //NUEVO
    public void llenarTabla(String codigo, String nombre, String descripcion, String categoria,
            String marca, String stock, String color, String talla, double precio,
            double costo, double utilidad, int y){

        DefaultTableModel dt =(DefaultTableModel)this.productosJT.getModel();
                    dt.addRow(new Object[y]);
                    this.productosJT.setValueAt(codigo , y-1 , 0);
                    this.productosJT.setValueAt(nombre , y-1 , 1);
                    this.productosJT.setValueAt(descripcion , y-1 , 2);
                    this.productosJT.setValueAt(categoria , y-1, 3) ;
                    this.productosJT.setValueAt(marca , y-1, 4) ;
                    this.productosJT.setValueAt(stock , y-1, 5) ;
                    this.productosJT.setValueAt(color , y-1, 6) ;
                    this.productosJT.setValueAt(talla , y-1, 7) ;
                    this.productosJT.setValueAt(precio , y-1, 8) ;
                    this.productosJT.setValueAt(costo , y-1, 9) ;
                    this.productosJT.setValueAt(utilidad , y-1, 10) ;
    }

    public void despliegaPantalla(){
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void limpiartabla(){
        DefaultTableModel dt =(DefaultTableModel)productosJT.getModel();
        dt.setRowCount(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        bodyPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        imgBrandLBL = new javax.swing.JLabel();
        rightsPanel = new javax.swing.JPanel();
        copyrightLBL = new javax.swing.JLabel();
        brandLBL1 = new javax.swing.JLabel();
        versionLBL1 = new javax.swing.JLabel();
        btnPanel = new javax.swing.JPanel();
        exportarBTN = new javax.swing.JButton();
        volverBTN = new javax.swing.JButton();
        importarBTN = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        dataSearchLBL = new javax.swing.JLabel();
        buscarBTN = new javax.swing.JButton();
        nombreProductoRB = new javax.swing.JRadioButton();
        busquedaTB = new javax.swing.JTextField();
        codigoProductoRB = new javax.swing.JRadioButton();
        buscarTodosBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productosJT = new javax.swing.JTable();
        guardarBTN = new javax.swing.JButton();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgBrandLBL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );

        rightsPanel.setBackground(java.awt.Color.darkGray);

        copyrightLBL.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        copyrightLBL.setForeground(new java.awt.Color(255, 255, 255));
        copyrightLBL.setText("© 2016 Freelancer, Chile.");

        brandLBL1.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        brandLBL1.setForeground(new java.awt.Color(255, 255, 255));
        brandLBL1.setText("Punto De Venta");

        versionLBL1.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        versionLBL1.setForeground(new java.awt.Color(255, 255, 255));
        versionLBL1.setText("v 1.0");

        javax.swing.GroupLayout rightsPanelLayout = new javax.swing.GroupLayout(rightsPanel);
        rightsPanel.setLayout(rightsPanelLayout);
        rightsPanelLayout.setHorizontalGroup(
            rightsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(brandLBL1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(versionLBL1)
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
                        .addComponent(brandLBL1)
                        .addComponent(versionLBL1))
                    .addComponent(copyrightLBL))
                .addContainerGap())
        );

        btnPanel.setBackground(java.awt.Color.lightGray);
        btnPanel.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));

        exportarBTN.setBackground(java.awt.Color.lightGray);
        exportarBTN.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        exportarBTN.setForeground(new java.awt.Color(255, 255, 255));
        exportarBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logos Excel.png"))); // NOI18N
        exportarBTN.setText("Exportar");
        exportarBTN.setToolTipText("");
        exportarBTN.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        exportarBTN.setBorderPainted(false);
        exportarBTN.setFocusPainted(false);
        exportarBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportarBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exportarBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exportarBTNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exportarBTNMouseExited(evt);
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
        volverBTN.setMaximumSize(new java.awt.Dimension(64, 82));
        volverBTN.setMinimumSize(new java.awt.Dimension(64, 82));
        volverBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        volverBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                volverBTNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                volverBTNMouseExited(evt);
            }
        });

        importarBTN.setBackground(java.awt.Color.lightGray);
        importarBTN.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        importarBTN.setForeground(new java.awt.Color(255, 255, 255));
        importarBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logos Excel.png"))); // NOI18N
        importarBTN.setText("Importar");
        importarBTN.setToolTipText("");
        importarBTN.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        importarBTN.setBorderPainted(false);
        importarBTN.setFocusPainted(false);
        importarBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        importarBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        importarBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                importarBTNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                importarBTNMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exportarBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
            .addComponent(importarBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(volverBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addComponent(exportarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(importarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(volverBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(202, 18, 30));

        dataSearchLBL.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        dataSearchLBL.setForeground(new java.awt.Color(255, 255, 255));
        dataSearchLBL.setText("Opciones de búsqueda");

        buscarBTN.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        buscarBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search-64_1.png"))); // NOI18N
        buscarBTN.setText("Buscar");

        buttonGroup1.add(nombreProductoRB);
        nombreProductoRB.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        nombreProductoRB.setText("Nombre Producto");

        busquedaTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        busquedaTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                busquedaTBKeyTyped(evt);
            }
        });

        buttonGroup1.add(codigoProductoRB);
        codigoProductoRB.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        codigoProductoRB.setText("Código Producto");

        buscarTodosBTN.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        buscarTodosBTN.setText("Ver todos");
        buscarTodosBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarTodosBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataSearchLBL)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(codigoProductoRB)
                                .addGap(18, 18, 18)
                                .addComponent(nombreProductoRB))
                            .addComponent(busquedaTB))
                        .addGap(38, 38, 38)
                        .addComponent(buscarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(buscarTodosBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dataSearchLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigoProductoRB)
                            .addComponent(nombreProductoRB))
                        .addGap(15, 15, 15)
                        .addComponent(busquedaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buscarTodosBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buscarBTN)))
                .addGap(23, 23, 23))
        );

        productosJT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Descripción", "Categoría", "Marca", "Stock", "Color", "Talla", "Precio Venta", "Precio Costo", "Utilidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, true, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productosJT);
        if (productosJT.getColumnModel().getColumnCount() > 0) {
            productosJT.getColumnModel().getColumn(0).setResizable(false);
            productosJT.getColumnModel().getColumn(1).setResizable(false);
            productosJT.getColumnModel().getColumn(3).setResizable(false);
            productosJT.getColumnModel().getColumn(4).setResizable(false);
            productosJT.getColumnModel().getColumn(5).setResizable(false);
            productosJT.getColumnModel().getColumn(8).setResizable(false);
            productosJT.getColumnModel().getColumn(9).setResizable(false);
            productosJT.getColumnModel().getColumn(10).setResizable(false);
        }

        guardarBTN.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        guardarBTN.setText("Guardar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(guardarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guardarBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(rightsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1098, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exportarBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportarBTNMouseEntered
        exportarBTN.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_exportarBTNMouseEntered

    private void exportarBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportarBTNMouseExited
        exportarBTN.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_exportarBTNMouseExited

    private void volverBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBTNMouseEntered
        volverBTN.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_volverBTNMouseEntered

    private void volverBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBTNMouseExited
        volverBTN.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_volverBTNMouseExited

    private void buscarTodosBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarTodosBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarTodosBTNActionPerformed

    private void busquedaTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busquedaTBKeyTyped
        if (busquedaTB.getText().length() == 30) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_busquedaTBKeyTyped

    private void importarBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importarBTNMouseEntered
        importarBTN.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_importarBTNMouseEntered

    private void importarBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importarBTNMouseExited
        importarBTN.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_importarBTNMouseExited
    public String getcod_prod(int row){
        DefaultTableModel dt =(DefaultTableModel)this.productosJT.getModel();
         String cod_prod="";
            cod_prod = productosJT.getModel().getValueAt(row, 0).toString().trim();
        return cod_prod;
    }
    
    public String getnombreprod(int row){
        DefaultTableModel dt =(DefaultTableModel)this.productosJT.getModel();
        String nombre ="";
            nombre = productosJT.getModel().getValueAt(row, 1).toString().trim(); 
        return nombre;
    }
     public String getdescripcion(int row){
        DefaultTableModel dt =(DefaultTableModel)this.productosJT.getModel();
         String descripcion="";
            descripcion = productosJT.getModel().getValueAt(row, 2).toString().trim();
        return descripcion;
     }
       
    public String getcategoria(int row){
        DefaultTableModel dt =(DefaultTableModel)this.productosJT.getModel();
        String categoria="";
            categoria = productosJT.getModel().getValueAt(row, 3).toString().trim();
        return categoria;
    }    
    public String getmarca(int row){
        DefaultTableModel dt =(DefaultTableModel)this.productosJT.getModel();
         String marca="";
            marca = productosJT.getModel().getValueAt(row, 4).toString().trim();
        return marca;
    } 
    public String getstock_prod(int row){
        DefaultTableModel dt =(DefaultTableModel)this.productosJT.getModel();
         String stock="";
            stock = productosJT.getModel().getValueAt(row, 5).toString().trim();
        return stock;
    }
    
    public String getcolor(int row){
        DefaultTableModel dt =(DefaultTableModel)this.productosJT.getModel();
        String color ="";
            color = productosJT.getModel().getValueAt(row, 6).toString().trim(); 
        return color;
    }
     public String gettalla(int row){
        DefaultTableModel dt =(DefaultTableModel)this.productosJT.getModel();
         String talla="";
            talla = productosJT.getModel().getValueAt(row, 7).toString().trim();
        return talla;
     }
       
    public String getprecio_venta(int row){
        DefaultTableModel dt =(DefaultTableModel)this.productosJT.getModel();
        String valorprod="";
            valorprod = productosJT.getModel().getValueAt(row, 8).toString().trim();
        return valorprod;
    }    
    public String getprecio_costo(int row){
        DefaultTableModel dt =(DefaultTableModel)this.productosJT.getModel();
         String costo="";
            costo = productosJT.getModel().getValueAt(row, 9).toString().trim();
        return costo;
    } 
    public String getutilidad(int row){
        DefaultTableModel dt =(DefaultTableModel)this.productosJT.getModel();
         String utilidad="";
            utilidad = productosJT.getModel().getValueAt(row, 10).toString().trim();
        return utilidad;
    } 
    public int getrowtabla(){
        int count = productosJT.getRowCount();
        return count;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel brandLBL1;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton buscarBTN;
    private javax.swing.JButton buscarTodosBTN;
    private javax.swing.JTextField busquedaTB;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton codigoProductoRB;
    private javax.swing.JLabel copyrightLBL;
    private javax.swing.JLabel dataSearchLBL;
    public javax.swing.JButton exportarBTN;
    public javax.swing.JButton guardarBTN;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel imgBrandLBL;
    public javax.swing.JButton importarBTN;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton nombreProductoRB;
    public javax.swing.JTable productosJT;
    private javax.swing.JPanel rightsPanel;
    private javax.swing.JLabel versionLBL1;
    private javax.swing.JButton volverBTN;
    // End of variables declaration//GEN-END:variables
}
