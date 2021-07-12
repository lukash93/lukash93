package vista;

import controlador.controladorVentasRealizadas;
import java.awt.Color;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.ventaVO;
import logica.ventaprodVO;
import modelo.modeloVentasRealizadas;

public class vistaVentasRealizadas extends javax.swing.JFrame {
    String codigo="0";
    String codigoselec = "";
    controladorVentasRealizadas controladordetalleventa = new controladorVentasRealizadas();
    /**
     * Creates new form vistaVentasRealizadas
     */
    public vistaVentasRealizadas() {
        initComponents();
        URL url = getClass().getResource("/imagenes/logoCarisma.jpg");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
    }
    public void setControladorVentasRealizadas (controladorVentasRealizadas objControladorVentasRealizadas){
        buscarBTN.addActionListener(objControladorVentasRealizadas);
        volverBTN.addActionListener(objControladorVentasRealizadas);
        
        volverBTN.setActionCommand(controladorVentasRealizadas.botonVolver);   
        buscarBTN.setActionCommand(controladorVentasRealizadas.botonBuscar);
    }
    public void despliegaPantalla(){
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void limpiartabla(){
        DefaultTableModel dt =(DefaultTableModel)ventasJT.getModel();
        dt.setRowCount(0);
    }
    public void limpiartabla2(){
        DefaultTableModel dt =(DefaultTableModel)detalleJT.getModel();
        dt.setRowCount(0);
    }
    public void Mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    //NUEVO
    public void tabla(String idVenta, String tipoDocumento, String tipoVenta, String fecha,
            String hora, String codigoProducto, double valorNeto, double valorDescuento, double subtotal,
            double iva, double total, double sencillo, double vuelto, int y){

        DefaultTableModel dt =(DefaultTableModel)this.ventasJT.getModel();
                   dt.addRow(new Object[y]);
                   for (int i = 0; i < y; i++) {
                    this.ventasJT.setValueAt(idVenta , y-1 , 0);
                    this.ventasJT.setValueAt(tipoDocumento , y-1 , 1);
                    this.ventasJT.setValueAt(tipoVenta , y-1 , 2);
                    this.ventasJT.setValueAt(fecha , y-1, 3) ;
                    this.ventasJT.setValueAt(hora , y-1, 4) ;
                    this.ventasJT.setValueAt(codigoProducto , y-1, 5) ;
                    this.ventasJT.setValueAt(valorNeto , y-1, 6) ;
                    this.ventasJT.setValueAt(valorDescuento , y-1, 7) ;
                    this.ventasJT.setValueAt(subtotal , y-1, 8) ;
                    this.ventasJT.setValueAt(iva , y-1, 9) ;
                    this.ventasJT.setValueAt(total , y-1, 10) ;
                    this.ventasJT.setValueAt(sencillo , y-1, 11) ;
                    this.ventasJT.setValueAt(vuelto , y-1, 12) ;
        }
    }
    //NUEVO
    public void llenarTabla(String idVenta, String tipoDocumento, String tipoVenta, String fecha,
            String hora, String codigoProducto, double valorNeto, double valorDescuento, double subtotal,
            double iva, double total, double sencillo, double vuelto, int y){

        DefaultTableModel dt =(DefaultTableModel)this.ventasJT.getModel();
                    dt.addRow(new Object[y]);
                    this.ventasJT.setValueAt(idVenta , y-1 , 0);
                    this.ventasJT.setValueAt(tipoDocumento , y-1 , 1);
                    this.ventasJT.setValueAt(tipoVenta , y-1 , 2);
                    this.ventasJT.setValueAt(fecha , y-1, 3) ;
                    this.ventasJT.setValueAt(hora , y-1, 4) ;
                    this.ventasJT.setValueAt(codigoProducto , y-1, 5) ;
                    this.ventasJT.setValueAt(valorNeto , y-1, 6) ;
                    this.ventasJT.setValueAt(valorDescuento , y-1, 7) ;
                    this.ventasJT.setValueAt(subtotal , y-1, 8) ;
                    this.ventasJT.setValueAt(iva , y-1, 9) ;
                    this.ventasJT.setValueAt(total , y-1, 10) ;
                    this.ventasJT.setValueAt(sencillo , y-1, 11) ;
                    this.ventasJT.setValueAt(vuelto , y-1, 12) ;
    }
    //NUEVO
    public void llenarTablaDetalle(String idProducto, String nombreProducto, String valorDescuento, String precio,
            String cantidad, int y){

        DefaultTableModel dt =(DefaultTableModel)this.detalleJT.getModel();
                    dt.addRow(new Object[y]);
                    this.detalleJT.setValueAt(idProducto , y-1 , 0);
                    this.detalleJT.setValueAt(nombreProducto , y-1 , 1);
                    this.detalleJT.setValueAt(valorDescuento , y-1 , 2);
                    this.detalleJT.setValueAt(precio , y-1, 3) ;
                    this.detalleJT.setValueAt(cantidad , y-1, 4) ;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        exportarDetalleBTN = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        dataSearchLBL = new javax.swing.JLabel();
        desdeLBL = new javax.swing.JLabel();
        hastaLBL = new javax.swing.JLabel();
        buscarBTN = new javax.swing.JButton();
        fechaDesde = new com.toedter.calendar.JDateChooser();
        fechaHasta = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        ventasJT = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        detalleJT = new javax.swing.JTable();

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
        exportarBTN.setText("Exportar Ventas");
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

        exportarDetalleBTN.setBackground(java.awt.Color.lightGray);
        exportarDetalleBTN.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        exportarDetalleBTN.setForeground(new java.awt.Color(255, 255, 255));
        exportarDetalleBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logos Excel.png"))); // NOI18N
        exportarDetalleBTN.setText("Exportar Detalle");
        exportarDetalleBTN.setToolTipText("");
        exportarDetalleBTN.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        exportarDetalleBTN.setBorderPainted(false);
        exportarDetalleBTN.setFocusPainted(false);
        exportarDetalleBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportarDetalleBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exportarDetalleBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exportarDetalleBTNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exportarDetalleBTNMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exportarBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(volverBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(exportarDetalleBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addComponent(exportarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(exportarDetalleBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(volverBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(202, 18, 30));

        dataSearchLBL.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        dataSearchLBL.setForeground(new java.awt.Color(255, 255, 255));
        dataSearchLBL.setText("Opciones de búsqueda");

        desdeLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        desdeLBL.setForeground(new java.awt.Color(255, 255, 255));
        desdeLBL.setText("Desde");

        hastaLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        hastaLBL.setForeground(new java.awt.Color(255, 255, 255));
        hastaLBL.setText("Hasta");

        buscarBTN.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        buscarBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search-64_1.png"))); // NOI18N
        buscarBTN.setText("Buscar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataSearchLBL)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(desdeLBL)
                            .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hastaLBL)
                            .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(buscarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataSearchLBL)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(desdeLBL)
                            .addComponent(hastaLBL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechaDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(fechaHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscarBTN)
                        .addGap(23, 23, 23))))
        );

        ventasJT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID venta", "Tipo de documento", "Tipo de Venta", "Fecha", "Hora", "Productos", "Valor Neto", "Valor descuento", "Subtotal", "IVA", "Total", "Sencillo", "Vuelto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ventasJT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ventasJTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ventasJT);
        if (ventasJT.getColumnModel().getColumnCount() > 0) {
            ventasJT.getColumnModel().getColumn(0).setResizable(false);
            ventasJT.getColumnModel().getColumn(1).setResizable(false);
            ventasJT.getColumnModel().getColumn(2).setResizable(false);
            ventasJT.getColumnModel().getColumn(3).setResizable(false);
            ventasJT.getColumnModel().getColumn(4).setResizable(false);
            ventasJT.getColumnModel().getColumn(5).setResizable(false);
            ventasJT.getColumnModel().getColumn(6).setResizable(false);
            ventasJT.getColumnModel().getColumn(7).setResizable(false);
            ventasJT.getColumnModel().getColumn(8).setResizable(false);
            ventasJT.getColumnModel().getColumn(9).setResizable(false);
            ventasJT.getColumnModel().getColumn(10).setResizable(false);
            ventasJT.getColumnModel().getColumn(11).setResizable(false);
            ventasJT.getColumnModel().getColumn(12).setResizable(false);
        }

        detalleJT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id producto", "Nombre", "Descuento", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(detalleJT);
        if (detalleJT.getColumnModel().getColumnCount() > 0) {
            detalleJT.getColumnModel().getColumn(0).setResizable(false);
            detalleJT.getColumnModel().getColumn(1).setResizable(false);
            detalleJT.getColumnModel().getColumn(2).setResizable(false);
            detalleJT.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(rightsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1081, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void ventasJTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ventasJTMouseClicked
        if(evt.getClickCount()==2){
        int seleccion = selecciontablanumero();
         capturacodigo(seleccion);
         codigoselec = capturacodigo(seleccion);
         System.out.println("el codigo del producto es:" +codigoselec); 
//         controladordetalleventa.verDetalle(codigoselec);
        limpiartabla2();
        modeloVentasRealizadas consulta = new modeloVentasRealizadas();
        ArrayList<ventaprodVO> listaden = null;
        listaden = consulta.consultaDetalleProducto(codigoselec);
            for (int i = 0; i < listaden.size(); i++) {           
                      String idProducto = listaden.get(i).getId_producto();
                      String nombre = listaden.get(i).getNombre_producto();
                      System.out.println(nombre);
                      String descuento = listaden.get(i).getDescuento_producto();
                      String precio = listaden.get(i).getValor_producto();
                      String cantidad = listaden.get(i).getCantidad();
                      System.out.println(cantidad);
                      llenarTablaDetalle(idProducto, nombre, descuento, precio,cantidad, i+1);
            }
        }
    }//GEN-LAST:event_ventasJTMouseClicked

    private void exportarDetalleBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportarDetalleBTNMouseEntered
        exportarDetalleBTN.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_exportarDetalleBTNMouseEntered

    private void exportarDetalleBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportarDetalleBTNMouseExited
        exportarDetalleBTN.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_exportarDetalleBTNMouseExited
    //NUEVO
    public int selecciontablanumero(){
        int numFilaSeleccionada = this.ventasJT.getSelectedRow();  
        return numFilaSeleccionada;            
    } 
    public String capturacodigo(int dato){
        DefaultTableModel dt =(DefaultTableModel)this.ventasJT.getModel();
        codigo = ventasJT.getModel().getValueAt(dato, 0).toString().trim();
        return codigo;
    }    
    public String getcodigo2(){
        String dato = codigo;
        return dato;
    }
    //NUEVO
    public void limpiarCalendarios(){
        fechaDesde.setCalendar(null);
        fechaHasta.setCalendar(null);
    }
    public String ObtenerfechaDesde(){
        String total= ""; 
        if (fechaDesde.getDate() == null) {
            
        }else{
            DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd");
            String convertido = fechaHora.format(fechaDesde.getDate());
            System.out.println(convertido);
            String a = convertido.substring(0,4);
            String b = convertido.substring(5,7);
            String c = convertido.substring(8,10);
            total = a+b+c;

        }
       //Date as = fechaDesde.getDate();
     return total;
    }
    //NUEVO
    public String ObtenerfechaHasta(){
       //Date as = fechaDesde.getDate();
       String total= "";
        if (fechaHasta.getDate() ==null) {
            
        }else{
            DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd");
            String convertido = fechaHora.format(fechaHasta.getDate());
            String a = convertido.substring(0,4);
            String b = convertido.substring(5,7);
            String c = convertido.substring(8,10);
            total = a+b+c;  
        }
     return total;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel brandLBL1;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton buscarBTN;
    private javax.swing.JLabel copyrightLBL;
    private javax.swing.JLabel dataSearchLBL;
    private javax.swing.JLabel desdeLBL;
    public javax.swing.JTable detalleJT;
    public javax.swing.JButton exportarBTN;
    public javax.swing.JButton exportarDetalleBTN;
    public com.toedter.calendar.JDateChooser fechaDesde;
    public com.toedter.calendar.JDateChooser fechaHasta;
    private javax.swing.JLabel hastaLBL;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel imgBrandLBL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel rightsPanel;
    public javax.swing.JTable ventasJT;
    private javax.swing.JLabel versionLBL1;
    private javax.swing.JButton volverBTN;
    // End of variables declaration//GEN-END:variables
}
