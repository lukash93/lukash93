package vista;

import javax.swing.JOptionPane;
import java.awt.Color;
import java.util.ArrayList;
import controlador.controladorProductos;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class vistaProductos extends javax.swing.JFrame {
    //NUEVO
    String operando="";
    DefaultTableModel temp;
    String retorno;
    /**
     * Creates new form vistaProductos
     */
    public vistaProductos() {
        initComponents();
        URL url = getClass().getResource("/imagenes/logoCarisma.jpg");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
        setLocationRelativeTo(null);
        ocultar.setVisible(false);
        
    }
    public void bloquearTB(){
        codigoProductoTB.setEditable(false);
    }
    public void habilitarTB(){
        codigoProductoTB.setEditable(true);
    }
    
    public void mostrarpanel(){
        ocultar.setVisible(true);
    }
    public void ocultarpanel(){
        ocultar.setVisible(false);
    }
    public void botoncancelar(){
        ocultarpanel();
        Limpiar();
    }
    public void setControladorProductos(controladorProductos objControladorProductos){

        guardarBTN.addActionListener(objControladorProductos);
        modificarBTN.addActionListener(objControladorProductos);
        volverBTN.addActionListener(objControladorProductos);
        buscarBTN.addActionListener(objControladorProductos);
        AceptarBTN.addActionListener(objControladorProductos);
        CancelarBTN.addActionListener(objControladorProductos);
        guardarBTN.setActionCommand(controladorProductos.botonGuardar);
        modificarBTN.setActionCommand(controladorProductos.botonModificar);
        volverBTN.setActionCommand(controladorProductos.botonVolver);
        buscarBTN.setActionCommand(controladorProductos.botonBuscar);
        AceptarBTN.setActionCommand(controladorProductos.botonAceptar);
        CancelarBTN.setActionCommand(controladorProductos.botonCancelar);
    }
     public void cargarCombo (ArrayList listaCategoria){
        categoriaCB.removeAllItems();
        categoriaCB.addItem("Seleccionar");
        for (int i = 0; i < listaCategoria.size(); i++) {
            String categoria = listaCategoria.get(i).toString();
            this.categoriaCB.addItem(categoria);
        }
    }
     //NUEVO
     
    public void mostrarPanel(){
         ocultar.setVisible(true);
     }
    public void LimpiarTabla(){
        try{
            temp = (DefaultTableModel) productosJT.getModel();
            int a =temp.getRowCount()-1;
            for(int i=0; i<a; i++)
                temp.removeRow(0); 
        }catch(Exception e){
            System.out.println(e);
        }
        busquedaTB.setText("");
        
    }
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
    
    public String selecciontabla(){
            int numFilaSeleccionada = this.productosJT.getSelectedRow();  

            if(numFilaSeleccionada >= 0 && this.productosJT.getModel().getValueAt(numFilaSeleccionada, 0 )!= null) {

            operando =this.productosJT.getModel().getValueAt(numFilaSeleccionada, 0).toString().trim();

            }
        return operando;            
    }
    
    public void Limpiar(){
        nombreProductoTB.setText("");
        codigoProductoTB.setText("");
        descripcionProductoTA.setText("");
        colorTB.setText("");
        stockTB.setText("");
        marcaTB.setText("");
        tallaTB.setText("");
        costoTB.setText("");
        utilidadTB.setText("");
        categoriaCB.setSelectedIndex(0);
        precioTB.setText("");
        codigoProductoTB.requestFocus(); 
        
    }
    public void setNombreProducto(String nombreProducto){
        nombreProductoTB.setText(nombreProducto);
    }
    public void setCodigoProducto(String codigoProducto){
        codigoProductoTB.setText(codigoProducto);
    }
    public void setDescripcionProducto(String descripProducto){
        descripcionProductoTA.setText(descripProducto);
    }
    public Object setNombreCategoria(String nombreCategoria){
        return categoriaCB.getSelectedItem();
    }
    public void setMarcaProducto(String marcaProducto){
        marcaTB.setText(marcaProducto);
    }
    public void setStockProducto(String stockProducto){
        stockTB.setText(stockProducto);
    }
    public void setColorProducto(String colorProducto){
        colorTB.setText(colorProducto);
    }
    public void setTallaProducto(String tallaProducto){
        tallaTB.setText(tallaProducto);
    }
    public void setPrecioProducto(double precioProducto){
        precioTB.setText(String.valueOf(precioProducto));
    }
    public void setCostoProducto(double costoProducto){
        costoTB.setText(String.valueOf(costoProducto));
    }
    public void setUtilidadProducto(double utilidadProducto){
        utilidadTB.setText(String.valueOf(utilidadProducto));
    }
    public String getBusqueda(){
        return busquedaTB.getText();
    }
    public String getNombreProducto(){
        return nombreProductoTB.getText();
    }
    public double getCostoProducto(){
        return Double.parseDouble(costoTB.getText());
    }
     public double getUtilidadProducto(){
        return Double.parseDouble(utilidadTB.getText());
    }
    public String getCodigoProducto(){
        return codigoProductoTB.getText();
    }
    public String getDescripProducto(){
        return descripcionProductoTA.getText();
    }
    public void llenarCategoria(String Categoria){
        categoriaCB.addItem(Categoria);
    }
    public String getColorProducto(){
        return colorTB.getText();
    }
    public String getMarcaProducto(){
        return marcaTB.getText();
    }
    public String getStockProducto(){
        return stockTB.getText();
    }
    public String getCategoria(){
        return (String) categoriaCB.getSelectedItem();
    }
    public String getTallaProducto(){
        return tallaTB.getText();
    }
    public double getPrecioProducto(){
        return Double.parseDouble(precioTB.getText());
    }
   
    public void despliegaPantalla(){
            setLocationRelativeTo(null);  
            setVisible(true);  
    }
    public void Mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public String nombreProductoRB (){
        return nombreProductoRB.getActionCommand();
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
    public void setUtilidad(double Utilidad){
        utilidadTB.setText(String.valueOf(Utilidad));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBusqueda = new javax.swing.ButtonGroup();
        bodyPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        imgBrandLBL = new javax.swing.JLabel();
        rightsPanel = new javax.swing.JPanel();
        copyrightLBL = new javax.swing.JLabel();
        brandLBL1 = new javax.swing.JLabel();
        versionLBL1 = new javax.swing.JLabel();
        btnPanel = new javax.swing.JPanel();
        guardarBTN = new javax.swing.JButton();
        modificarBTN = new javax.swing.JButton();
        volverBTN = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        operationLBL = new javax.swing.JLabel();
        codLBL = new javax.swing.JLabel();
        codigoProductoTB = new javax.swing.JTextField();
        nomLBL = new javax.swing.JLabel();
        nombreProductoTB = new javax.swing.JTextField();
        descLBL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionProductoTA = new javax.swing.JTextArea();
        catLBL = new javax.swing.JLabel();
        categoriaCB = new javax.swing.JComboBox<>();
        marcaLBL = new javax.swing.JLabel();
        marcaTB = new javax.swing.JTextField();
        stockLBL = new javax.swing.JLabel();
        stockTB = new javax.swing.JTextField();
        colorLBL = new javax.swing.JLabel();
        colorTB = new javax.swing.JTextField();
        tallaLBL = new javax.swing.JLabel();
        tallaTB = new javax.swing.JTextField();
        precioLBL = new javax.swing.JLabel();
        precioTB = new javax.swing.JTextField();
        ocultar = new javax.swing.JPanel();
        AceptarBTN = new javax.swing.JButton();
        CancelarBTN = new javax.swing.JButton();
        costoTB = new javax.swing.JTextField();
        utilidadTB = new javax.swing.JTextField();
        precioLBL1 = new javax.swing.JLabel();
        precioLBL2 = new javax.swing.JLabel();
        precioLBL3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        operation2LBL = new javax.swing.JLabel();
        codigoProductoRB = new javax.swing.JRadioButton();
        nombreProductoRB = new javax.swing.JRadioButton();
        busquedaTB = new javax.swing.JTextField();
        buscarBTN = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        productosJT = new javax.swing.JTable();

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

        guardarBTN.setBackground(java.awt.Color.lightGray);
        guardarBTN.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        guardarBTN.setForeground(new java.awt.Color(255, 255, 255));
        guardarBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/More_2-64.png"))); // NOI18N
        guardarBTN.setText("Nuevo");
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
        operationLBL.setText("Datos del Producto");

        codLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        codLBL.setText("Código Producto");

        codigoProductoTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        codigoProductoTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoProductoTBKeyTyped(evt);
            }
        });

        nomLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        nomLBL.setText("Nombre");

        nombreProductoTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        nombreProductoTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreProductoTBKeyTyped(evt);
            }
        });

        descLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        descLBL.setText("Descripción");

        descripcionProductoTA.setColumns(20);
        descripcionProductoTA.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        descripcionProductoTA.setRows(5);
        descripcionProductoTA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionProductoTAKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(descripcionProductoTA);

        catLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        catLBL.setText("Categoría");

        categoriaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Accesorios" }));

        marcaLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        marcaLBL.setText("Marca");

        marcaTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        marcaTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                marcaTBKeyTyped(evt);
            }
        });

        stockLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        stockLBL.setText("Stock");

        stockTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stockTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockTBKeyTyped(evt);
            }
        });

        colorLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        colorLBL.setText("Color");

        colorTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        colorTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                colorTBKeyTyped(evt);
            }
        });

        tallaLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        tallaLBL.setText("Talla");

        tallaTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        tallaTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tallaTBKeyTyped(evt);
            }
        });

        precioLBL.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        precioLBL.setText("Precio Venta");

        precioTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        precioTB.setText("0.0");
        precioTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioTBActionPerformed(evt);
            }
        });
        precioTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioTBKeyTyped(evt);
            }
        });

        AceptarBTN.setText("Aceptar");

        CancelarBTN.setText("Cancelar");

        javax.swing.GroupLayout ocultarLayout = new javax.swing.GroupLayout(ocultar);
        ocultar.setLayout(ocultarLayout);
        ocultarLayout.setHorizontalGroup(
            ocultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ocultarLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(AceptarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(CancelarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        ocultarLayout.setVerticalGroup(
            ocultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ocultarLayout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(ocultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AceptarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        costoTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        costoTB.setText("0.0");
        costoTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costoTBActionPerformed(evt);
            }
        });
        costoTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costoTBKeyTyped(evt);
            }
        });

        utilidadTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        utilidadTB.setText("0.0");
        utilidadTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                utilidadTBKeyTyped(evt);
            }
        });

        precioLBL1.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        precioLBL1.setText("Precio Costo");

        precioLBL2.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        precioLBL2.setText("Utilidad");

        precioLBL3.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        precioLBL3.setForeground(new java.awt.Color(153, 153, 153));
        precioLBL3.setText("Presione Enter");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descLBL)
                    .addComponent(operationLBL)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(nomLBL)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nombreProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(codLBL)
                            .addGap(18, 18, 18)
                            .addComponent(codigoProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(catLBL)
                            .addComponent(marcaLBL)
                            .addComponent(stockLBL)
                            .addComponent(precioLBL1))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoriaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ocultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(stockTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(marcaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(costoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(precioLBL3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(colorLBL)
                                    .addComponent(tallaLBL)
                                    .addComponent(precioLBL)
                                    .addComponent(precioLBL2))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(precioTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tallaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colorTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(utilidadTB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(operationLBL)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codLBL))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomLBL)
                    .addComponent(nombreProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descLBL)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catLBL)
                    .addComponent(categoriaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorLBL)
                    .addComponent(colorTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marcaLBL)
                    .addComponent(marcaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tallaLBL)
                    .addComponent(tallaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockLBL)
                    .addComponent(stockTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precioLBL)
                    .addComponent(precioTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(utilidadTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(costoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(precioLBL2))
                    .addComponent(precioLBL1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(precioLBL3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ocultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nuevo / Modificar", new javax.swing.ImageIcon(getClass().getResource("/imagenes/settings-16.png")), jPanel1); // NOI18N

        operation2LBL.setFont(new java.awt.Font("Lucida Console", 0, 36)); // NOI18N
        operation2LBL.setText("Buscar Producto");

        grupoBusqueda.add(codigoProductoRB);
        codigoProductoRB.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        codigoProductoRB.setSelected(true);
        codigoProductoRB.setText("Código Producto");

        grupoBusqueda.add(nombreProductoRB);
        nombreProductoRB.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        nombreProductoRB.setText("Nombre Producto");

        busquedaTB.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        busquedaTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                busquedaTBKeyTyped(evt);
            }
        });

        buscarBTN.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        buscarBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search-64_1.png"))); // NOI18N
        buscarBTN.setText("Buscar");

        productosJT = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        productosJT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Descripción", "Categoría", "Marca", "Stock", "Color", "Talla", "Precio", "Costo", "Utilidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(productosJT);
        if (productosJT.getColumnModel().getColumnCount() > 0) {
            productosJT.getColumnModel().getColumn(0).setResizable(false);
            productosJT.getColumnModel().getColumn(1).setResizable(false);
            productosJT.getColumnModel().getColumn(2).setResizable(false);
            productosJT.getColumnModel().getColumn(3).setResizable(false);
            productosJT.getColumnModel().getColumn(4).setResizable(false);
            productosJT.getColumnModel().getColumn(5).setResizable(false);
            productosJT.getColumnModel().getColumn(6).setResizable(false);
            productosJT.getColumnModel().getColumn(7).setResizable(false);
            productosJT.getColumnModel().getColumn(8).setResizable(false);
            productosJT.getColumnModel().getColumn(9).setResizable(false);
            productosJT.getColumnModel().getColumn(10).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(codigoProductoRB)
                                .addGap(18, 18, 18)
                                .addComponent(nombreProductoRB))
                            .addComponent(busquedaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(buscarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(operation2LBL))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(operation2LBL)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigoProductoRB)
                            .addComponent(nombreProductoRB))
                        .addGap(18, 18, 18)
                        .addComponent(busquedaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buscarBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
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
                        .addComponent(jTabbedPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        this.LimpiarTabla();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void costoTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costoTBActionPerformed
        if(!costoTB.getText().equals("") && !precioTB.getText().equals("")){
            double costo = Double.parseDouble(costoTB.getText());
            double venta = Double.parseDouble(precioTB.getText());
            double total = 0.0;
            if (costo < venta) {
                total = venta - costo;
                setUtilidad(total);
            } else {
                Mensaje("El costo debe ser menor que la venta");
            }
        }else{
            Mensaje("Debe ingresar datos");
        }
    }//GEN-LAST:event_costoTBActionPerformed

    private void precioTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioTBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioTBActionPerformed

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

    private void descripcionProductoTAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionProductoTAKeyTyped
        if (descripcionProductoTA.getText().length() == 255) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_descripcionProductoTAKeyTyped

    private void marcaTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marcaTBKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();

            evt.consume();

        }
        if (marcaTB.getText().length() == 30) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_marcaTBKeyTyped

    private void stockTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockTBKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

        }
        if (stockTB.getText().length() == 3) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_stockTBKeyTyped

    private void costoTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costoTBKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

        }
        if (costoTB.getText().length() == 9) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_costoTBKeyTyped

    private void colorTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_colorTBKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();

            evt.consume();

        }
        if (colorTB.getText().length() == 20) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_colorTBKeyTyped

    private void tallaTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tallaTBKeyTyped
        if (tallaTB.getText().length() == 6) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_tallaTBKeyTyped

    private void precioTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioTBKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

        }
        if (precioTB.getText().length() == 9) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_precioTBKeyTyped

    private void utilidadTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utilidadTBKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

        }
        if (utilidadTB.getText().length() == 9) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_utilidadTBKeyTyped

    private void busquedaTBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busquedaTBKeyTyped
        if (busquedaTB.getText().length() == 30) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_busquedaTBKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarBTN;
    private javax.swing.JButton CancelarBTN;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel brandLBL1;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton buscarBTN;
    private javax.swing.JTextField busquedaTB;
    private javax.swing.JLabel catLBL;
    private javax.swing.JComboBox<String> categoriaCB;
    private javax.swing.JLabel codLBL;
    private javax.swing.JRadioButton codigoProductoRB;
    private javax.swing.JTextField codigoProductoTB;
    private javax.swing.JLabel colorLBL;
    private javax.swing.JTextField colorTB;
    private javax.swing.JLabel copyrightLBL;
    private javax.swing.JTextField costoTB;
    private javax.swing.JLabel descLBL;
    private javax.swing.JTextArea descripcionProductoTA;
    private javax.swing.ButtonGroup grupoBusqueda;
    private javax.swing.JButton guardarBTN;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel imgBrandLBL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel marcaLBL;
    private javax.swing.JTextField marcaTB;
    private javax.swing.JButton modificarBTN;
    private javax.swing.JLabel nomLBL;
    private javax.swing.JRadioButton nombreProductoRB;
    private javax.swing.JTextField nombreProductoTB;
    private javax.swing.JPanel ocultar;
    private javax.swing.JLabel operation2LBL;
    private javax.swing.JLabel operationLBL;
    private javax.swing.JLabel precioLBL;
    private javax.swing.JLabel precioLBL1;
    private javax.swing.JLabel precioLBL2;
    private javax.swing.JLabel precioLBL3;
    private javax.swing.JTextField precioTB;
    private javax.swing.JTable productosJT;
    private javax.swing.JPanel rightsPanel;
    private javax.swing.JLabel stockLBL;
    private javax.swing.JTextField stockTB;
    private javax.swing.JLabel tallaLBL;
    private javax.swing.JTextField tallaTB;
    private javax.swing.JTextField utilidadTB;
    private javax.swing.JLabel versionLBL1;
    private javax.swing.JButton volverBTN;
    // End of variables declaration//GEN-END:variables
}
