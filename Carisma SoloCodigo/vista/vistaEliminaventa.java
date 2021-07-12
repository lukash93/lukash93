package vista;

import controlador.controladorAnularVenta;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class vistaEliminaventa extends javax.swing.JFrame {
    String operando="";
    String codigo="";

    public vistaEliminaventa() {
        initComponents();
        URL url = getClass().getResource("/imagenes/logoCarisma.jpg");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
    }
    public void setControladorAnularVenta (controladorAnularVenta objControladorAnularVenta){
        buscarBTN.addActionListener(objControladorAnularVenta);
        volverBTN.addActionListener(objControladorAnularVenta);
        anularVentaBTN.addActionListener(objControladorAnularVenta);
        
        volverBTN.setActionCommand(controladorAnularVenta.botonVolver);   
        buscarBTN.setActionCommand(controladorAnularVenta.botonBuscar);
        anularVentaBTN.setActionCommand(controladorAnularVenta.botonAnular);
    }
    //NUEVO
    public ArrayList getcodigostabla(){
        DefaultTableModel dt =(DefaultTableModel)this.ventasJT.getModel();
        ArrayList list = new ArrayList();
        for (int i = 0; i < ventasJT.getRowCount() ; i++) {
            String datoa = ventasJT.getModel().getValueAt(i, 0).toString().trim();
            list.add(datoa);
        }
        return list;
    }
        public String capturacodigo(int dato){
        DefaultTableModel dt =(DefaultTableModel)this.ventasJT.getModel();
        codigo = ventasJT.getModel().getValueAt(dato, 0).toString().trim();
        return codigo;
    }   
        public int selecciontablanumero(){
            int numFilaSeleccionada = this.ventasJT.getSelectedRow();  
        return numFilaSeleccionada;            
    } 
        
    
    public ArrayList getproductos(){
        DefaultTableModel dt =(DefaultTableModel)this.ventasJT.getModel();
        ArrayList list = new ArrayList();
        for (int i = 0; i < ventasJT.getRowCount() ; i++) {
            String datoa = ventasJT.getModel().getValueAt(i, 5).toString().trim();
            list.add(datoa+",");
        }
        return list;
    }
    public int getrowtabla(){
        int count = ventasJT.getRowCount();
        return count;
    }
    public void Mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public String selecciontabla(){
            int numFilaSeleccionada = this.ventasJT.getSelectedRow();  

            if(numFilaSeleccionada >= 0 && this.ventasJT.getModel().getValueAt(numFilaSeleccionada, 0 )!= null) {

            operando =this.ventasJT.getModel().getValueAt(numFilaSeleccionada, 0).toString().trim();

            }
        return operando;            
    }
    public void despliegaPantalla(){
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void limpiartabla(){
        DefaultTableModel dt =(DefaultTableModel)ventasJT.getModel();
        dt.setRowCount(0);
    }
    public void limpiarCalendarios(){
        fechaDesde.setCalendar(null);
        fechaHasta.setCalendar(null);
    }
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        dataSearchLBL = new javax.swing.JLabel();
        anularVentaBTN = new javax.swing.JButton();
        volverBTN = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        dataSearchLBL1 = new javax.swing.JLabel();
        desdeLBL = new javax.swing.JLabel();
        hastaLBL = new javax.swing.JLabel();
        buscarBTN = new javax.swing.JButton();
        fechaDesde = new com.toedter.calendar.JDateChooser();
        fechaHasta = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        ventasJT = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        dataSearchLBL.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        dataSearchLBL.setForeground(new java.awt.Color(202, 18, 30));
        dataSearchLBL.setText("Ventas Realizadas");

        anularVentaBTN.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        anularVentaBTN.setForeground(new java.awt.Color(202, 18, 30));
        anularVentaBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Remove_2-64.png"))); // NOI18N
        anularVentaBTN.setText("Anular Venta");
        anularVentaBTN.setToolTipText("");
        anularVentaBTN.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        anularVentaBTN.setBorderPainted(false);
        anularVentaBTN.setContentAreaFilled(false);
        anularVentaBTN.setFocusPainted(false);
        anularVentaBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        anularVentaBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        anularVentaBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anularVentaBTNActionPerformed(evt);
            }
        });

        volverBTN.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        volverBTN.setForeground(new java.awt.Color(202, 18, 30));
        volverBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Previous_2-64.png"))); // NOI18N
        volverBTN.setText("Volver");
        volverBTN.setToolTipText("");
        volverBTN.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        volverBTN.setBorderPainted(false);
        volverBTN.setContentAreaFilled(false);
        volverBTN.setFocusPainted(false);
        volverBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        volverBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jPanel5.setBackground(new java.awt.Color(202, 18, 30));

        dataSearchLBL1.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        dataSearchLBL1.setForeground(new java.awt.Color(255, 255, 255));
        dataSearchLBL1.setText("Opciones de búsqueda");

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
                    .addComponent(dataSearchLBL1)
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
                .addComponent(dataSearchLBL1)
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(anularVentaBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(volverBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataSearchLBL)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(dataSearchLBL)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(volverBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anularVentaBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void anularVentaBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anularVentaBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anularVentaBTNActionPerformed

    private void ventasJTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ventasJTMouseClicked

    }//GEN-LAST:event_ventasJTMouseClicked


    /**
     * @param args the command line arguments
     */

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anularVentaBTN;
    private javax.swing.JButton buscarBTN;
    private javax.swing.JLabel dataSearchLBL;
    private javax.swing.JLabel dataSearchLBL1;
    private javax.swing.JLabel desdeLBL;
    public com.toedter.calendar.JDateChooser fechaDesde;
    public com.toedter.calendar.JDateChooser fechaHasta;
    private javax.swing.JLabel hastaLBL;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable ventasJT;
    private javax.swing.JButton volverBTN;
    // End of variables declaration//GEN-END:variables
}
