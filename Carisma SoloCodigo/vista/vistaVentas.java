package vista;

import controlador.controladorVentas;
import java.awt.Color;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.productoVO;
import logica.ventaprodVO;
import modelo.modeloVentas;


public class vistaVentas extends javax.swing.JFrame {
    String dato= "0";
    double dato2=0;
    boolean confirmacion;
    Date now = new Date(System.currentTimeMillis());
    String hora = hora();
    
    
    /**
     * Creates new form vistaVentas
     */
    public vistaVentas() {
        initComponents();
        URL url = getClass().getResource("/imagenes/logoCarisma.jpg");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
        llenardescuento();
    }
    public void despliegaPantalla(){
        setLocationRelativeTo(null);
        setVisible(true);
        fecha.setText(fecha());
    }
    public void setControladorVentas(controladorVentas objControladorVentas){

        nuevoBTN.addActionListener(objControladorVentas);
        cancelarBTN.addActionListener(objControladorVentas);
        volverBTN.addActionListener(objControladorVentas);
        codigoProductoTB.addActionListener(objControladorVentas);
        agregarVentaBTN.addActionListener(objControladorVentas);
        quitarVentaBTN.addActionListener(objControladorVentas);
        buscarCodigoProductoBTN.addActionListener(objControladorVentas);
                
        quitarVentaBTN.setActionCommand(controladorVentas.quitarVentaBTN);
        nuevoBTN.setActionCommand(controladorVentas.botonNuevo);
        cancelarBTN.setActionCommand(controladorVentas.botonAnularVenta);
        volverBTN.setActionCommand(controladorVentas.botonVolver);
        agregarVentaBTN.setActionCommand(controladorVentas.agregarVentaBTN);
        codigoProductoTB.setActionCommand(controladorVentas.text);
        buscarCodigoProductoBTN.setActionCommand(controladorVentas.buscarprod);
    }
    

    public void eliminadetabla(int dato1){
         DefaultTableModel dt =(DefaultTableModel)this.jTable1.getModel();
         dt.removeRow(dato1); 
    }
    public int selecciontablanumero(){
            int numFilaSeleccionada = this.jTable1.getSelectedRow();  
        return numFilaSeleccionada;            
    } 


    public String getcodproducto(){
        String codProducto = codigoProductoTB.getText();
        return codProducto;
    }
    public String getnomproducto(){
        String nomProducto = nombreProductoTB.getText();

        return nomProducto;
    }  
    
    public void setnumeroventa(int numero){
        numeroventa.setText(String.valueOf(numero));
    }
    public String getstockproducto(){
        String stockProducto = stockProductoTB.getText();

        return stockProducto;
    } 
    public int getnumeroventa(){
       int numero = Integer.parseInt(numeroventa.getText());
       return numero;
    }
    public String getprecioproducto(){
        String precioProducto = precioProductoTB.getText();

        return precioProducto;
    }   
    public int getposiciontabla(){
        DefaultTableModel dt =(DefaultTableModel)jTable1.getModel();
        int contar = dt.getRowCount();
        return contar;
    }
    
     public String getcantidadproducto(){
        String cantidadProducto = cantidadVentaTB.getText();

        return cantidadProducto;
    }      
      public String gettotalproducto(){
        String totalProducto = TotalProductoTB.getText();

        return totalProducto;
    }
    public String gettotalapagar(){
        String total = totalPagarVentaTB.getText().trim();
        return total;
    }
    public String getfecha(){
        String fechas = fecha.getText().trim();
        return fechas;
    }
    public String getvalorventa(){
        String valor=valorVentaTB.getText();
        return valor;
    } 
    public String getdescuento(){
        String desc = descuentoVentaTB.getText();
        return desc;
    }
    public String getsubtotal(){
        String sub = subTotalVentaTB.getText();
        return sub;
    }
    public String getiva(){
        String ivas = ivaVentaTB.getText();
        return ivas;
    }
    public ArrayList getproductos(){
        DefaultTableModel dt =(DefaultTableModel)this.jTable1.getModel();
        ArrayList list = new ArrayList();
        for (int i = 0; i < jTable1.getRowCount() ; i++) {
            String datoa = jTable1.getModel().getValueAt(i, 0).toString().trim();
            list.add(datoa+",");
        }
        return list;
    }
    public ArrayList getcodigostabla(){
        DefaultTableModel dt =(DefaultTableModel)this.jTable1.getModel();
        ArrayList list = new ArrayList();
        for (int i = 0; i < jTable1.getRowCount() ; i++) {
            String datoa = jTable1.getModel().getValueAt(i, 0).toString().trim();
            list.add(datoa);
        }
        return list;
    }
    //WEBEO DE LA TABLA
    public String getid_prod(int row){
        DefaultTableModel dt =(DefaultTableModel)this.jTable1.getModel();
         String id_prod="";
            id_prod = jTable1.getModel().getValueAt(row, 0).toString().trim();
        return id_prod;
    }
    
    public String getnombreprod(int row){
        DefaultTableModel dt =(DefaultTableModel)this.jTable1.getModel();
        String nombre ="";
            nombre = jTable1.getModel().getValueAt(row, 1).toString().trim(); 
        return nombre;
    }
     public String getdescuentoprod(int row){
        DefaultTableModel dt =(DefaultTableModel)this.jTable1.getModel();
         String descuento="";
            descuento = jTable1.getModel().getValueAt(row, 6).toString().trim();
        return descuento;
     }
       
    public String getvalorprod(int row){
        DefaultTableModel dt =(DefaultTableModel)this.jTable1.getModel();
        String valorprod="";
            valorprod = jTable1.getModel().getValueAt(row, 3).toString().trim();
        return valorprod;
    }    
    public String getcantidadprod(int row){
        DefaultTableModel dt =(DefaultTableModel)this.jTable1.getModel();
         String cantidad="";
            cantidad = jTable1.getModel().getValueAt(row, 4).toString().trim();
        return cantidad;
    }    
    
    
    
    
    public ArrayList getstocktabla(){
        DefaultTableModel dt =(DefaultTableModel)this.jTable1.getModel();
        ArrayList list = new ArrayList();
        for (int i = 0; i < jTable1.getRowCount() ; i++) {
            String datoa = jTable1.getModel().getValueAt(i, 4).toString().trim();
            list.add(datoa);
        }
        return list;
    }
    public int getrowtabla(){
        int count = jTable1.getRowCount();
        return count;
    }
    public String getvuelto(){
        String vuelto =vueltoTB.getText();
        return vuelto;
    }
    public String getsencillo(){
        String sencillo = importeTB.getText();
        return sencillo;
    }
    public String gethora(){
        String total = hora;
        return total;
    }    
    public String getcodigo(){
        String codigo = codigoProductoTB.getText();
        return  codigo;
    }
    public String gettipodeventa(){
        String codigo = tipoDocVentaCB.getSelectedItem().toString();
        return  codigo;
    }    
    public String gettipopago(){
        String codigo = tipoPagoVentaCB.getSelectedItem().toString();
        return  codigo;
    }     
    public String fecha(){

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
        
        String fecha = date.format(now).toString();
        //System.out.println(date.format(now));
        //System.out.println(hour.format(now));
        //System.out.println(now);
        return fecha;
    }
    public String hora(){

        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
        
        String hora = hour.format(now).toString();
        //System.out.println(date.format(now));
        //System.out.println(hour.format(now));
        //System.out.println(now);
        return hora;
    }   
    public void limpiarCB(){
        tipoDocVentaCB.setSelectedIndex(0);
        tipoPagoVentaCB.setSelectedIndex(0);
    }
    public void limpiarnombreprod(){
        codigoProductoTB.setText("");
        nombreProductoTB.setText("");
        stockProductoTB.setText("");
        cantidadVentaTB.setText("");
        precioProductoTB.setText("");
        TotalProductoTB.setText("");
        descuentoCB.setSelectedIndex(0);
    }
    public void Mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
        
        public void llenarproductoTB(String nombre){
            nombreProductoTB.setText(nombre);
        }
        public void llenarstockTB(String nombre){
            stockProductoTB.setText(nombre);
        } 
        public void llenarprecioTB(String nombre){
            precioProductoTB.setText(nombre);
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
        btnPanel = new javax.swing.JPanel();
        nuevoBTN = new javax.swing.JButton();
        cancelarBTN = new javax.swing.JButton();
        volverBTN = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        dataSalesLBL = new javax.swing.JLabel();
        tipoDocLBL = new javax.swing.JLabel();
        codigoProductoLBL = new javax.swing.JLabel();
        dataProductLBL = new javax.swing.JLabel();
        codigoProductoTB = new javax.swing.JTextField();
        nombreProductoLBL = new javax.swing.JLabel();
        nombreProductoTB = new javax.swing.JTextField();
        tipoDocVentaCB = new javax.swing.JComboBox<>();
        tipoPagoLBL = new javax.swing.JLabel();
        tipoPagoVentaCB = new javax.swing.JComboBox<>();
        LBLFECHA = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        buscarCodigoProductoBTN = new javax.swing.JButton();
        numeroventa = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        stockProductoLBL = new javax.swing.JLabel();
        stockProductoTB = new javax.swing.JTextField();
        cantidadVentaLBL = new javax.swing.JLabel();
        cantidadVentaTB = new javax.swing.JTextField();
        precioVentaLBL = new javax.swing.JLabel();
        totalVentaLBL = new javax.swing.JLabel();
        precioProductoTB = new javax.swing.JTextField();
        TotalProductoTB = new javax.swing.JTextField();
        descuentoLBL = new javax.swing.JLabel();
        descuentoCB = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        valorVentaLBL = new javax.swing.JLabel();
        valorVentaTB = new javax.swing.JTextField();
        descuentoVentaTB = new javax.swing.JTextField();
        descuentoVentaLBL = new javax.swing.JLabel();
        subTotalVentaLBL = new javax.swing.JLabel();
        subTotalVentaTB = new javax.swing.JTextField();
        ivaVentaLBL = new javax.swing.JLabel();
        ivaVentaTB = new javax.swing.JTextField();
        totalPagarVentaLBL = new javax.swing.JLabel();
        totalPagarVentaTB = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        importeLBL = new javax.swing.JLabel();
        importeTB = new javax.swing.JTextField();
        vueltoLBL = new javax.swing.JLabel();
        vueltoTB = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        agregarVentaBTN = new javax.swing.JButton();
        quitarVentaBTN = new javax.swing.JButton();
        rightsPanel = new javax.swing.JPanel();
        copyrightLBL = new javax.swing.JLabel();
        brandLBL1 = new javax.swing.JLabel();
        versionLBL1 = new javax.swing.JLabel();
        brandLogoCarisma = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 750));
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
                .addGap(19, 19, 19)
                .addComponent(imgBrandLBL)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgBrandLBL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );

        btnPanel.setBackground(java.awt.Color.lightGray);
        btnPanel.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));

        nuevoBTN.setBackground(java.awt.Color.lightGray);
        nuevoBTN.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        nuevoBTN.setForeground(new java.awt.Color(255, 255, 255));
        nuevoBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dollar-64.png"))); // NOI18N
        nuevoBTN.setText("Generar Venta");
        nuevoBTN.setToolTipText("");
        nuevoBTN.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        nuevoBTN.setBorderPainted(false);
        nuevoBTN.setFocusPainted(false);
        nuevoBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nuevoBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nuevoBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nuevoBTNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nuevoBTNMouseExited(evt);
            }
        });

        cancelarBTN.setBackground(java.awt.Color.lightGray);
        cancelarBTN.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        cancelarBTN.setForeground(new java.awt.Color(255, 255, 255));
        cancelarBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Remove_2-64.png"))); // NOI18N
        cancelarBTN.setText("Cancelar Vta.");
        cancelarBTN.setToolTipText("");
        cancelarBTN.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        cancelarBTN.setBorderPainted(false);
        cancelarBTN.setFocusPainted(false);
        cancelarBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelarBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelarBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelarBTNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelarBTNMouseExited(evt);
            }
        });
        cancelarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBTNActionPerformed(evt);
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
            .addComponent(nuevoBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cancelarBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(volverBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addComponent(nuevoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volverBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(202, 18, 30));

        dataSalesLBL.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        dataSalesLBL.setForeground(new java.awt.Color(255, 255, 255));
        dataSalesLBL.setText("Datos de la Venta");

        tipoDocLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        tipoDocLBL.setForeground(new java.awt.Color(255, 255, 255));
        tipoDocLBL.setText("Tipo Documento");

        codigoProductoLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        codigoProductoLBL.setForeground(new java.awt.Color(255, 255, 255));
        codigoProductoLBL.setText("Código");

        dataProductLBL.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        dataProductLBL.setForeground(new java.awt.Color(255, 255, 255));
        dataProductLBL.setText("Datos del Producto");

        codigoProductoTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        codigoProductoTB.setToolTipText("Presione Enter");
        codigoProductoTB.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                codigoProductoTBInputMethodTextChanged(evt);
            }
        });
        codigoProductoTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoProductoTBActionPerformed(evt);
            }
        });
        codigoProductoTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoProductoTBKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoProductoTBKeyTyped(evt);
            }
        });

        nombreProductoLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        nombreProductoLBL.setForeground(new java.awt.Color(255, 255, 255));
        nombreProductoLBL.setText("Nombre");

        nombreProductoTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        nombreProductoTB.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        nombreProductoTB.setEnabled(false);
        nombreProductoTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreProductoTBKeyTyped(evt);
            }
        });

        tipoDocVentaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Boleta", "Factura" }));

        tipoPagoLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        tipoPagoLBL.setForeground(new java.awt.Color(255, 255, 255));
        tipoPagoLBL.setText("Tipo Pago");

        tipoPagoVentaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Efectivo", "Tarjeta de débito", "Tarjeta de crédito" }));

        LBLFECHA.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        LBLFECHA.setForeground(new java.awt.Color(255, 255, 255));
        LBLFECHA.setText("Fecha");

        fecha.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        fecha.setEnabled(false);

        buscarCodigoProductoBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search-16.png"))); // NOI18N

        numeroventa.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataProductLBL)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(dataSalesLBL)
                        .addGap(30, 30, 30)
                        .addComponent(numeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tipoDocLBL)
                                    .addComponent(LBLFECHA))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tipoDocVentaCB, 0, 178, Short.MAX_VALUE)
                                    .addComponent(fecha))
                                .addGap(29, 29, 29))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(codigoProductoLBL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codigoProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(buscarCodigoProductoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(nombreProductoLBL)
                                .addGap(18, 18, 18)
                                .addComponent(nombreProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(tipoPagoLBL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tipoPagoVentaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataSalesLBL)
                    .addComponent(numeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoDocLBL)
                    .addComponent(tipoDocVentaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoPagoVentaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoPagoLBL))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLFECHA)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(dataProductLBL)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(codigoProductoTB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigoProductoLBL)
                            .addComponent(nombreProductoLBL)
                            .addComponent(nombreProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buscarCodigoProductoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(202, 18, 30));

        stockProductoLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        stockProductoLBL.setForeground(new java.awt.Color(255, 255, 255));
        stockProductoLBL.setText("Stock");

        stockProductoTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stockProductoTB.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        stockProductoTB.setEnabled(false);
        stockProductoTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockProductoTBKeyTyped(evt);
            }
        });

        cantidadVentaLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        cantidadVentaLBL.setForeground(new java.awt.Color(255, 255, 255));
        cantidadVentaLBL.setText("Cantidad");

        cantidadVentaTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        cantidadVentaTB.setToolTipText("Presione Enter");
        cantidadVentaTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadVentaTBActionPerformed(evt);
            }
        });
        cantidadVentaTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadVentaTBKeyTyped(evt);
            }
        });

        precioVentaLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        precioVentaLBL.setForeground(new java.awt.Color(255, 255, 255));
        precioVentaLBL.setText("Precio");

        totalVentaLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        totalVentaLBL.setForeground(new java.awt.Color(255, 255, 255));
        totalVentaLBL.setText("Total");

        precioProductoTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        precioProductoTB.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        precioProductoTB.setEnabled(false);
        precioProductoTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioProductoTBKeyTyped(evt);
            }
        });

        TotalProductoTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        TotalProductoTB.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TotalProductoTB.setEnabled(false);

        descuentoLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        descuentoLBL.setForeground(new java.awt.Color(255, 255, 255));
        descuentoLBL.setText("Descuento");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(stockProductoLBL)
                        .addGap(28, 28, 28)
                        .addComponent(stockProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(descuentoLBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descuentoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(precioVentaLBL, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cantidadVentaLBL, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(precioProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(cantidadVentaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalVentaLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TotalProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockProductoLBL)
                    .addComponent(stockProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precioVentaLBL)
                    .addComponent(precioProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadVentaLBL)
                    .addComponent(cantidadVentaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalVentaLBL)
                    .addComponent(TotalProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descuentoLBL)
                    .addComponent(descuentoCB, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );

        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre ", "Stock", "Precio", "Cantidad", "Total", "Descuento"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel6.setBackground(new java.awt.Color(202, 18, 30));

        valorVentaLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        valorVentaLBL.setForeground(new java.awt.Color(255, 255, 255));
        valorVentaLBL.setText("Valor Venta");

        valorVentaTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        valorVentaTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorVentaTBActionPerformed(evt);
            }
        });

        descuentoVentaTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N

        descuentoVentaLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        descuentoVentaLBL.setForeground(new java.awt.Color(255, 255, 255));
        descuentoVentaLBL.setText("Descuento");

        subTotalVentaLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        subTotalVentaLBL.setForeground(new java.awt.Color(255, 255, 255));
        subTotalVentaLBL.setText("Sub Total");

        subTotalVentaTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N

        ivaVentaLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        ivaVentaLBL.setForeground(new java.awt.Color(255, 255, 255));
        ivaVentaLBL.setText("IVA");

        ivaVentaTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N

        totalPagarVentaLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        totalPagarVentaLBL.setForeground(new java.awt.Color(255, 255, 255));
        totalPagarVentaLBL.setText("Total a Pagar");

        totalPagarVentaTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(valorVentaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descuentoVentaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subTotalVentaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ivaVentaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(valorVentaLBL)
                        .addGap(46, 46, 46)
                        .addComponent(descuentoVentaLBL)
                        .addGap(54, 54, 54)
                        .addComponent(subTotalVentaLBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ivaVentaLBL)
                        .addGap(51, 51, 51)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalPagarVentaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(totalPagarVentaLBL)
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorVentaLBL)
                    .addComponent(descuentoVentaLBL)
                    .addComponent(subTotalVentaLBL)
                    .addComponent(ivaVentaLBL)
                    .addComponent(totalPagarVentaLBL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorVentaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descuentoVentaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subTotalVentaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ivaVentaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalPagarVentaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(202, 18, 30));

        importeLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        importeLBL.setForeground(new java.awt.Color(255, 255, 255));
        importeLBL.setText("Sencillo");

        importeTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        importeTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importeTBActionPerformed(evt);
            }
        });
        importeTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                importeTBKeyTyped(evt);
            }
        });

        vueltoLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        vueltoLBL.setForeground(new java.awt.Color(255, 255, 255));
        vueltoLBL.setText("Vuelto");

        vueltoTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        vueltoTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vueltoTBKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(importeTB, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vueltoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(importeLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vueltoLBL)
                .addGap(42, 42, 42))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importeLBL)
                    .addComponent(vueltoLBL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(importeTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vueltoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(202, 18, 30));

        agregarVentaBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/More_2-64.png"))); // NOI18N
        agregarVentaBTN.setText("Agregar");
        agregarVentaBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        agregarVentaBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        quitarVentaBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Less_2-64.png"))); // NOI18N
        quitarVentaBTN.setText("Quitar");
        quitarVentaBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        quitarVentaBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(agregarVentaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quitarVentaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quitarVentaBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agregarVentaBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

        brandLogoCarisma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/carismaLogo.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rightsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(brandLogoCarisma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(brandLogoCarisma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rightsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void codigoProductoTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoProductoTBActionPerformed
               modeloVentas modelo= new modeloVentas();
            String codigo = getcodigo();
            if (codigo.equals("")) {
                limpiarnombreprod();
                Mensaje("Ingrese código");
            }else{
                
                ArrayList<productoVO> list = new ArrayList();
                list = modelo.consultaproducto(codigo);
                if (list.isEmpty()) {
                    limpiarnombreprod();
                    Mensaje("Código No existe");
                    
                }else{
                    for (int i = 0; i < list.size(); i++) {
                        nombreProductoTB.setText(list.get(i).getNomProducto());
                        stockProductoTB.setText(list.get(i).getStockProducto());
                        precioProductoTB.setText(String.valueOf(list.get(i).getPrecioProducto()));
                    }
                    
                    
                }

            } 
         
    }//GEN-LAST:event_codigoProductoTBActionPerformed

    private void codigoProductoTBInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_codigoProductoTBInputMethodTextChanged
        
    }//GEN-LAST:event_codigoProductoTBInputMethodTextChanged
    public double restartotales(int posiciontabla){
        double totalresta= 0;
        if (!totalPagarVentaTB.getText().equals("")) {
            DefaultTableModel dt =(DefaultTableModel)jTable1.getModel();
            String resta = jTable1.getModel().getValueAt(posiciontabla, 5).toString().trim(); //1
            System.out.println(resta);
            double  numeroresta = Double.parseDouble(resta);
            double totalanterior = Double.parseDouble(totalPagarVentaTB.getText());
            totalresta = totalanterior - numeroresta;
        }
        return totalresta;
    }
    public void setcodigo(String modi){
        codigoProductoTB.setText(modi);
    }
    public void llenardescuento(){
        descuentoCB.addItem("Sin Descuento");
        for (int i = 1; i < 101; i++) {
            descuentoCB.addItem(i+"%");
        }
    }
    private void codigoProductoTBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoProductoTBKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoProductoTBKeyPressed

    public void limpiartodo(){
        limpiartotales();
        limpiarnombreprod();
        limpiartabla();
        limpiarCB();
    }
    
    private void cantidadVentaTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadVentaTBActionPerformed
        int stock = Integer.parseInt(stockProductoTB.getText());
        int cantidad = Integer.parseInt(cantidadVentaTB.getText());
        double precio= Double.parseDouble(precioProductoTB.getText());
        StringTokenizer st = new StringTokenizer(obtenerdescuento(),"%",true);
        
        if (cantidad==0) {
            Mensaje("Debe ingresar cantidad superior a 0");
        }else if (cantidad<=stock) {
            if (obtenerdescuento().equals("Sin Descuento")) {
                double total = cantidad*precio;
                TotalProductoTB.setText(String.valueOf(total));  
            }else{
                String descuento = st.nextToken();
                double desc = Double.parseDouble(descuento);
                double totaldesc = desc/100;
                double totaldescuento = (cantidad*precio)*totaldesc;
                double totalfinal = (cantidad*precio)-totaldescuento;
                TotalProductoTB.setText(String.valueOf(totalfinal)); 
                System.out.println(totaldesc);
            }
        }else{
            Mensaje("La cantidad debe ser menor al stock");
        }

    }//GEN-LAST:event_cantidadVentaTBActionPerformed

    public double obtenercantidaddescuento(){
        int stock = Integer.parseInt(stockProductoTB.getText());
        int cantidad = Integer.parseInt(cantidadVentaTB.getText());
        double precio = Double.parseDouble(precioProductoTB.getText());
        StringTokenizer st = new StringTokenizer(obtenerdescuento(),"%",true);
         double totaldescuento = 0;
        if (cantidad<stock) {
            if (obtenerdescuento().equals("Sin Descuento")) {
                double total = cantidad*precio;
                TotalProductoTB.setText(String.valueOf(total));  
            }else{
                String descuento = st.nextToken();
                double desc = Double.parseDouble(descuento);
                double totaldesc = desc/100;
                totaldescuento = (cantidad*precio)*totaldesc;
                double totalfinal = (cantidad*precio)-totaldescuento;
                TotalProductoTB.setText(String.valueOf(totalfinal)); 
                System.out.println(totaldesc);
            }
        }else{

        }
        return totaldescuento;
    }
    public void restardescuento(int posicion){
        DefaultTableModel dt =(DefaultTableModel)jTable1.getModel();
        double dato1=0,total =0;

                String datoa = jTable1.getModel().getValueAt(posicion, 6).toString().trim();
                dato1= Double.parseDouble(datoa);
                total = Double.parseDouble(descuentoVentaTB.getText());
                total = total-dato1;
                System.out.println(total+"  total   "+dato1+"        dato1");
            
            descuentoVentaTB.setText(String.valueOf(total));
    }
    
    public double obtenersuma(boolean vf){
        DefaultTableModel dt =(DefaultTableModel)jTable1.getModel();
        int ver = selecciontablanumero();
        int posi = getposiciontabla();
        double total =0;
        if (dato.equals("")) {
            Mensaje("No se ha ingresado producto");
        }else{
            if (vf == true) {
                for (int j = 0; j < posi; j++) {
                    dato = jTable1.getModel().getValueAt(j, 5).toString().trim();
                    dato2= Double.parseDouble(dato);
                    total = total + dato2;

                }
            }else if(vf == false){
                double totalresta = restartotales(ver);
                total = totalresta;
                restardescuento(ver);
            }
        }

        return total;
    }
    public void setvalorventa(String valor){
        valorVentaTB.setText(valor);
    }    
    public void limpiartabla(){
        DefaultTableModel dt =(DefaultTableModel)jTable1.getModel();
        dt.setRowCount(0);
    }
    public void limpiartotales(){
        valorVentaTB.setText("");
        descuentoVentaTB.setText("");
        subTotalVentaTB.setText("");
        ivaVentaTB.setText("");
        totalPagarVentaTB.setText("");
        importeTB.setText("");
        vueltoTB.setText("");
    }   
    private void cancelarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBTNActionPerformed

    }//GEN-LAST:event_cancelarBTNActionPerformed

    private void valorVentaTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorVentaTBActionPerformed
        
    }//GEN-LAST:event_valorVentaTBActionPerformed

    public void llenarvuelto(Double vuelto){
        vueltoTB.setText(vuelto.toString());
    }
    private void importeTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importeTBActionPerformed
        System.out.println("sencilloo");
        if (!importeTB.getText().trim().equals("") && !totalPagarVentaTB.getText().trim().equals("") && !totalPagarVentaTB.getText().trim().equals("0.0") ) {
            double total = Double.parseDouble(totalPagarVentaTB.getText());
            double sencillo = Double.parseDouble(importeTB.getText());
            if (sencillo>total) {
                double vuelto = sencillo-total;
                llenarvuelto(vuelto);
            
            }else{
                Mensaje("El sencillo debe ser mayor al total");
            }

        }
    }//GEN-LAST:event_importeTBActionPerformed

    private void nuevoBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoBTNMouseEntered
        nuevoBTN.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_nuevoBTNMouseEntered

    private void nuevoBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoBTNMouseExited
        nuevoBTN.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_nuevoBTNMouseExited

    private void cancelarBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarBTNMouseEntered
        cancelarBTN.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_cancelarBTNMouseEntered

    private void cancelarBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarBTNMouseExited
        cancelarBTN.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_cancelarBTNMouseExited

    private void volverBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBTNMouseEntered
        volverBTN.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_volverBTNMouseEntered

    private void volverBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBTNMouseExited
        volverBTN.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_volverBTNMouseExited

    private void codigoProductoTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoProductoTBKeyTyped
        if (codigoProductoTB.getText().length() == 10) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_codigoProductoTBKeyTyped

    private void nombreProductoTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreProductoTBKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();

            evt.consume();

        }
        if (nombreProductoTB.getText().length() == 30) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_nombreProductoTBKeyTyped

    private void stockProductoTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockProductoTBKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

        }
        if (stockProductoTB.getText().length() == 3) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_stockProductoTBKeyTyped

    private void precioProductoTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioProductoTBKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

        }
        if (precioProductoTB.getText().length() == 9) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_precioProductoTBKeyTyped

    private void cantidadVentaTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadVentaTBKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

        }
        if (cantidadVentaTB.getText().length() == 3) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_cantidadVentaTBKeyTyped

    private void importeTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importeTBKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

        }
        if (importeTB.getText().length() == 9) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_importeTBKeyTyped

    private void vueltoTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vueltoTBKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

        }
        if (vueltoTB.getText().length() == 9) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_vueltoTBKeyTyped
    
    public String obtenerdescuento(){
        String descuento = descuentoCB.getSelectedItem().toString();
        return descuento;
    }
    
    
    public void obtenertotales(double suma){
           // double descuento = Double.parseDouble(descuentoVentaTB.getText());
            double Total = suma;
            totalPagarVentaTB.setText(String.valueOf(Total));
            double iva = Total*0.19;
            ivaVentaTB.setText(String.valueOf(iva));
            double subtotal = Total-iva;
            subTotalVentaTB.setText(String.valueOf(subtotal));            
        
    }
    public void modificadescuento(String dato){
        descuentoVentaTB.setText(dato);
    }
    public String  sumadescuentos(){
        DefaultTableModel dt =(DefaultTableModel)jTable1.getModel();
        double suma=0, total=0;
        for (int i = 0; i < dt.getRowCount(); i++) {
            suma = Double.parseDouble(jTable1.getModel().getValueAt(i, 6).toString().trim());
            total = total +suma;     
        }
        return String.valueOf(total);
    }
    
    public void llenartabla(String codigo, String nombre, String stock, String precio, String cantidad, String total, Double descuento, int i){
        DefaultTableModel dt =(DefaultTableModel)jTable1.getModel();
            int ver = getposiciontabla();
            for (int j = 0; j < ver; j++) {
                dato = jTable1.getModel().getValueAt(j, 0).toString().trim();
            }
                if (!codigo.equals(dato) ) {  
                    dt.addRow(new Object[1]);
                    jTable1.setValueAt(codigo, i, 0);
                    jTable1.setValueAt(nombre, i, 1);
                    jTable1.setValueAt(stock, i, 2);
                    jTable1.setValueAt(precio, i, 3);
                    jTable1.setValueAt(cantidad, i, 4);
                    jTable1.setValueAt(total, i, 5);       
                    jTable1.setValueAt(descuento, i, 6); 

                    this.jTable1.setModel(dt); 
                }else{
                    Mensaje("articulo ya ingresado ");
                }


    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBLFECHA;
    private javax.swing.JTextField TotalProductoTB;
    private javax.swing.JButton agregarVentaBTN;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel brandLBL1;
    private javax.swing.JLabel brandLogoCarisma;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton buscarCodigoProductoBTN;
    private javax.swing.JButton cancelarBTN;
    private javax.swing.JLabel cantidadVentaLBL;
    private javax.swing.JTextField cantidadVentaTB;
    private javax.swing.JLabel codigoProductoLBL;
    private javax.swing.JTextField codigoProductoTB;
    private javax.swing.JLabel copyrightLBL;
    private javax.swing.JLabel dataProductLBL;
    private javax.swing.JLabel dataSalesLBL;
    private javax.swing.JComboBox descuentoCB;
    private javax.swing.JLabel descuentoLBL;
    private javax.swing.JLabel descuentoVentaLBL;
    private javax.swing.JTextField descuentoVentaTB;
    private javax.swing.JTextField fecha;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel imgBrandLBL;
    private javax.swing.JLabel importeLBL;
    private javax.swing.JTextField importeTB;
    private javax.swing.JLabel ivaVentaLBL;
    private javax.swing.JTextField ivaVentaTB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nombreProductoLBL;
    private javax.swing.JTextField nombreProductoTB;
    private javax.swing.JButton nuevoBTN;
    private javax.swing.JTextField numeroventa;
    private javax.swing.JTextField precioProductoTB;
    private javax.swing.JLabel precioVentaLBL;
    private javax.swing.JButton quitarVentaBTN;
    private javax.swing.JPanel rightsPanel;
    private javax.swing.JLabel stockProductoLBL;
    private javax.swing.JTextField stockProductoTB;
    private javax.swing.JLabel subTotalVentaLBL;
    private javax.swing.JTextField subTotalVentaTB;
    private javax.swing.JLabel tipoDocLBL;
    private javax.swing.JComboBox<String> tipoDocVentaCB;
    private javax.swing.JLabel tipoPagoLBL;
    private javax.swing.JComboBox<String> tipoPagoVentaCB;
    private javax.swing.JLabel totalPagarVentaLBL;
    private javax.swing.JTextField totalPagarVentaTB;
    private javax.swing.JLabel totalVentaLBL;
    private javax.swing.JLabel valorVentaLBL;
    private javax.swing.JTextField valorVentaTB;
    private javax.swing.JLabel versionLBL1;
    private javax.swing.JButton volverBTN;
    private javax.swing.JLabel vueltoLBL;
    private javax.swing.JTextField vueltoTB;
    // End of variables declaration//GEN-END:variables
}
