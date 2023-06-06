package org.example.vista;


import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class Ventana extends JFrame {
    private JLabel lblId;
    private JLabel lblPaisInicial;
    private JTextField txtPaisInicial;
    private JLabel lblUrl;
    private JTextField txtId;
    private JTextField txtUrl;
    private JLabel lblNombre;
    private JLabel lblTipo;
    private JLabel lblAnio;
    private JLabel lblMuertes;
    private JTextField txtNombre;
    private JTextField txtTipo;
    private JTextField txtAnio;
    private JTextField txtMuertes;
    private JButton btnAgregar;
    private JButton btnCargar;
    private GridLayout layout;
    private JTable tblEpidemia;
    private JScrollPane scroll;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel imagenEpidemia;

//Panel4 Actualizacion
    private JLabel AlblId;
    private JLabel AlblPaisInicial;
    private JTextField AtxtPaisInicial;
    private JLabel AlblUrl;
    private JTextField AtxtId;
    private JTextField AtxtUrl;
    private JLabel AlblNombre;
    private JLabel AlblTipo;
    private JLabel AlblAnio;
    private JLabel AlblMuertes;
    private JTextField AtxtNombre;
    private JTextField AtxtTipo;
    private JTextField AtxtAnio;
    private JTextField AtxtMuertes;
    private JButton btnActualizar;
    private JButton btnBorrar;



    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(920,580);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);


        //panel1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(10, 218, 27, 255));
        lblId = new JLabel("ID:");
        txtId = new JTextField(5);
        txtId.setText("0");
        txtId.setEnabled(false);
        lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(15);
        lblAnio = new JLabel("Fecha:");
        txtAnio = new JTextField(8);
        lblTipo = new JLabel("Patogeno:");
        txtTipo = new JTextField(10);
        lblMuertes = new JLabel("Muertes:");
        txtMuertes = new JTextField(12);
        lblPaisInicial = new JLabel("Pais Inicial: ");
        txtPaisInicial = new JTextField(15);
        lblUrl = new JLabel("URL:");
        txtUrl = new JTextField(40);
        btnAgregar = new JButton("Agregar");
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblNombre);
        panel1.add(txtNombre);
        panel1.add(lblAnio);
        panel1.add(txtAnio);
        panel1.add(lblTipo);
        panel1.add(txtTipo);
        panel1.add(lblMuertes);
        panel1.add(txtMuertes);
        panel1.add(lblPaisInicial);
        panel1.add(txtPaisInicial);
        panel1.add(lblUrl);
        panel1.add(txtUrl);
        panel1.add(btnAgregar);

        //panel2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(18, 104, 188, 255));
        btnCargar = new JButton("Cargar Datos");
        panel2.add(btnCargar);
        tblEpidemia = new JTable();
        scroll = new JScrollPane(tblEpidemia);
        panel2.add(scroll);




        //panel3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(245, 10, 10, 255));
        imagenEpidemia = new JLabel("...");
        panel3.add(imagenEpidemia);

        //panel4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(234, 230, 32, 255));
        AlblId = new JLabel("ID:");
        AtxtId = new JTextField(5);
        AtxtId.setText("0");
        AtxtId.setEnabled(false);
        AlblNombre = new JLabel("Nombre:");
        AtxtNombre = new JTextField(15);
        AlblAnio = new JLabel("Fecha:");
        AtxtAnio = new JTextField(8);
        AlblTipo = new JLabel("Patogeno:");
        AtxtTipo = new JTextField(10);
        AlblMuertes = new JLabel("Muertes:");
        AtxtMuertes = new JTextField(12);
        AlblPaisInicial = new JLabel("Pais Inicial: ");
        AtxtPaisInicial = new JTextField(15);
        AlblUrl = new JLabel("URL:");
        AtxtUrl = new JTextField(40);
        btnActualizar = new JButton("Actualizar Datos");
        btnBorrar = new JButton("Eliminar");
        panel4.add(AlblId);
        panel4.add(AtxtId);
        panel4.add(AlblNombre);
        panel4.add(AtxtNombre);
        panel4.add(AlblAnio);
        panel4.add(AtxtAnio);
        panel4.add(AlblTipo);
        panel4.add(AtxtTipo);
        panel4.add(AlblMuertes);
        panel4.add(AtxtMuertes);
        panel4.add(AlblPaisInicial);
        panel4.add(AtxtPaisInicial);
        panel4.add(AlblUrl);
        panel4.add(AtxtUrl);
        panel4.add(btnActualizar);
        panel4.add(btnBorrar);


        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblTipo() {
        return lblTipo;
    }

    public void setLblTipo(JLabel lblTipo) {
        this.lblTipo = lblTipo;
    }

    public JLabel getLblAnio() {
        return lblAnio;
    }

    public void setLblAnio(JLabel lblAnio) {
        this.lblAnio = lblAnio;
    }

    public JLabel getLblMuertes() {
        return lblMuertes;
    }

    public void setLblMuertes(JLabel lblMuertes) {
        this.lblMuertes = lblMuertes;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtTipo() {
        return txtTipo;
    }

    public void setTxtTipo(JTextField txtTipo) {
        this.txtTipo = txtTipo;
    }

    public JTextField getTxtAnio() {
        return txtAnio;
    }

    public void setTxtAnio(JTextField txtAnio) {
        this.txtAnio = txtAnio;
    }

    public JTextField getTxtMuertes() {
        return txtMuertes;
    }

    public void setTxtMuertes(JTextField txtMuertes) {
        this.txtMuertes = txtMuertes;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JTable getTblEpidemia() {
        return tblEpidemia;
    }

    public void setTblEpidemia(JTable tblEpidemia) {
        this.tblEpidemia = tblEpidemia;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getImagenEpidemia() {
        return imagenEpidemia;
    }

    public void setImagenEpidemia(JLabel imagenEpidemia) {
        this.imagenEpidemia = imagenEpidemia;
    }

    public JLabel getLblPaisInicial() {
        return lblPaisInicial;
    }

    public void setLblPaisInicial(JLabel lblPaisInicial) {
        this.lblPaisInicial = lblPaisInicial;
    }

    public JTextField getTxtPaisInicial() {
        return txtPaisInicial;
    }

    public void setTxtPaisInicial(JTextField txtPaisInicial) {
        this.txtPaisInicial = txtPaisInicial;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JLabel getAlblId() {
        return AlblId;
    }

    public void setAlblId(JLabel alblId) {
        AlblId = alblId;
    }

    public JLabel getAlblPaisInicial() {
        return AlblPaisInicial;
    }

    public void setAlblPaisInicial(JLabel alblPaisInicial) {
        AlblPaisInicial = alblPaisInicial;
    }

    public JTextField getAtxtPaisInicial() {
        return AtxtPaisInicial;
    }

    public void setAtxtPaisInicial(JTextField atxtPaisInicial) {
        AtxtPaisInicial = atxtPaisInicial;
    }

    public JLabel getAlblUrl() {
        return AlblUrl;
    }

    public void setAlblUrl(JLabel alblUrl) {
        AlblUrl = alblUrl;
    }

    public JTextField getAtxtId() {
        return AtxtId;
    }

    public void setAtxtId(JTextField atxtId) {
        AtxtId = atxtId;
    }

    public JTextField getAtxtUrl() {
        return AtxtUrl;
    }

    public void setAtxtUrl(JTextField atxtUrl) {
        AtxtUrl = atxtUrl;
    }

    public JLabel getAlblNombre() {
        return AlblNombre;
    }

    public void setAlblNombre(JLabel alblNombre) {
        AlblNombre = alblNombre;
    }

    public JLabel getAlblTipo() {
        return AlblTipo;
    }

    public void setAlblTipo(JLabel alblTipo) {
        AlblTipo = alblTipo;
    }

    public JLabel getAlblAnio() {
        return AlblAnio;
    }

    public void setAlblAnio(JLabel alblAnio) {
        AlblAnio = alblAnio;
    }

    public JLabel getAlblMuertes() {
        return AlblMuertes;
    }

    public void setAlblMuertes(JLabel alblMuertes) {
        AlblMuertes = alblMuertes;
    }

    public JTextField getAtxtNombre() {
        return AtxtNombre;
    }

    public void setAtxtNombre(JTextField atxtNombre) {
        AtxtNombre = atxtNombre;
    }

    public JTextField getAtxtTipo() {
        return AtxtTipo;
    }

    public void setAtxtTipo(JTextField atxtTipo) {
        AtxtTipo = atxtTipo;
    }

    public JTextField getAtxtAnio() {
        return AtxtAnio;
    }

    public void setAtxtAnio(JTextField atxtAnio) {
        AtxtAnio = atxtAnio;
    }

    public JTextField getAtxtMuertes() {
        return AtxtMuertes;
    }

    public void setAtxtMuertes(JTextField atxtMuertes) {
        AtxtMuertes = atxtMuertes;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnBorrar(JButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }

    public void limpiar (){
        txtNombre.setText("");
        txtAnio.setText("");
        txtTipo.setText("");
        txtMuertes.setText("");
        txtPaisInicial.setText("");
        txtUrl.setText("");
    }


    public void limpiar2 (){
        AtxtId.setText("");
        AtxtNombre.setText("");
        AtxtAnio.setText("");
        AtxtTipo.setText("");
        AtxtMuertes.setText("");
        AtxtPaisInicial.setText("");
        AtxtUrl.setText("");
    }

}
