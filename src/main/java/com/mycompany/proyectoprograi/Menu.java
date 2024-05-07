/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectoprograi;

import java.awt.Desktop;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Walter Morales
 */

public class Menu extends javax.swing.JFrame {

    
    
    
    public Menu() {
        initComponents();
        setVisible(true);
        this.setLocationRelativeTo(null);
        mostrarEmpleadosEnTabla();
        mostrarProveedoresEnTabla();
        mostarClientesEnTabla();
        mostarArticulosEnTabla();
        mostrarFacturasEnTabla();
        
 
    }
    
    public void ocultarBoton() {
        // Ocultar el botón
        JtEmpleados.setVisible(false);
    
}
    
    public void ocultarTab1(){
        //Ocultar tab1 "Empleados"
         Jpanel.removeTabAt(5);  // Asume que la pestaña 1 es la primera pestaña
    
    }
    
    private void mostrarEmpleadosEnTabla() {
    try {
        // Leer todos los empleados
        ArrayList empleados = new ArrayList();
        DataInputStream entrada = new DataInputStream(new FileInputStream("Empleados.bin"));

        while (entrada.available() > 0) {
            String codigo = entrada.readUTF();
            String nombre = entrada.readUTF();
            String puesto = entrada.readUTF();
            String salario = entrada.readUTF();
            String usuario = entrada.readUTF();
            String clave = entrada.readUTF();

            empleados.add(new String[] {codigo, nombre, puesto, salario, usuario, clave});
        }

        entrada.close();

        // Crear un modelo para la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Puesto");
        model.addColumn("Salario");
        model.addColumn("Usuario");
        model.addColumn("Clave");

        // Agregar los empleados al modelo
        for (int i = 0; i < empleados.size(); i++) {
            String[] empleado = (String[]) empleados.get(i);
            model.addRow(empleado);
        }

        // Asignar el modelo a la tabla
        JtableEmpleados.setModel(model);
    } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(this, "El archivo de empleados no existe", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al leer el archivo de empleados", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
 private void mostrarProveedoresEnTabla() {
    try {
        // Leer todos los empleados
        ArrayList proveedores = new ArrayList();
        DataInputStream entrada = new DataInputStream(new FileInputStream("Proveedores.bin"));

        while (entrada.available() > 0) {
            String codigo = entrada.readUTF();
            String nit = entrada.readUTF();
            String nombre = entrada.readUTF();
            String direccion = entrada.readUTF();
            String telefono = entrada.readUTF();
            

            proveedores.add(new String[] {codigo, nit, nombre, direccion, telefono});
        }

        entrada.close();

        // Crear un modelo para la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nit");
        model.addColumn("Nombre");
        model.addColumn("Direccion");
        model.addColumn("Telefono");
        

        // Agregar los Proveedores al modelo
        for (int i = 0; i < proveedores.size(); i++) {
            String[] proveedor = (String[]) proveedores.get(i);
            model.addRow(proveedor);
        }

        // Asignar el modelo a la tabla
        JtableProveedores.setModel(model);
    } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(this, "El archivo de Proveedores no existe", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al leer el archivo de Proveedores", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void mostarClientesEnTabla() {
    try {
        // Leer todos los empleados
        ArrayList clientes = new ArrayList();
        DataInputStream entrada = new DataInputStream(new FileInputStream("Clientes.bin"));

        while (entrada.available() > 0) {
            String nit = entrada.readUTF();
            String nombre = entrada.readUTF();
            String direccion = entrada.readUTF();


            clientes.add(new String[] {nit, nombre, direccion});
        }

        entrada.close();

        // Crear un modelo para la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nit");
        model.addColumn("Nombre");
        model.addColumn("Direccion");

        // Agregar los empleados al modelo
        for (int i = 0; i < clientes.size(); i++) {
            String[] cliente = (String[]) clientes.get(i);
            model.addRow(cliente);
        }

        // Asignar el modelo a la tabla
        JtableClientes.setModel(model);
    } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(this, "El archivo de empleados no existe", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al leer el archivo de empleados", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void mostarArticulosEnTabla() {
    try {
        // Leer todos los empleados
        ArrayList articulos = new ArrayList();
        DataInputStream entrada = new DataInputStream(new FileInputStream("Articulos.bin"));

        while (entrada.available() > 0) {
            String nombre = entrada.readUTF();
            String descripcion = entrada.readUTF();
            String cantidad = entrada.readUTF();
            String precio = entrada.readUTF();
            String proveedor = entrada.readUTF();


            articulos.add(new String[] {nombre, descripcion, cantidad, precio, proveedor});
        }

        entrada.close();

        // Crear un modelo para la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Descripcion");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        model.addColumn("Proveedor");

        // Agregar los empleados al modelo
        for (int i = 0; i < articulos.size(); i++) {
            String[] articulo = (String[]) articulos.get(i);
            model.addRow(articulo);
        }

        // Asignar el modelo a la tabla
        JtableArticulos.setModel(model);
    } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(this, "El archivo de articulos no existe", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al leer el archivo de articulos", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


private void mostrarFacturasEnTabla() {
    try {
        // Leer todas las facturas
        ArrayList<Factura> facturas = new ArrayList<>();
        try (DataInputStream entrada = new DataInputStream(new FileInputStream("Facturas.bin"))) {
            while (entrada.available() > 0) {
                String nit = entrada.readUTF();
                String nombre = entrada.readUTF();
                String direccion = entrada.readUTF();
                String producto = entrada.readUTF();
                int cantidad = entrada.readInt();
                float precio = entrada.readFloat();
                float total = entrada.readFloat();

                facturas.add(new Factura(nit, nombre, direccion, producto, cantidad, precio, total));
            }
        }

        // Crear un modelo para la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NIT");
        model.addColumn("Nombre");
        model.addColumn("Dirección");
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        model.addColumn("Total");

        // Agregar las facturas al modelo
        for (Factura factura : facturas) {
            Object[] fila = {factura.getNit(), factura.getNombre(), factura.getDireccion(), factura.getProducto(), factura.getCantidad(), factura.getPrecio(), factura.getTotal()};
            model.addRow(fila);
        }

        // Asignar el modelo a la tabla
        JtableFacturas.setModel(model);
    } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(this, "El archivo de facturas no existe", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al leer el archivo de facturas", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JtEmpleados = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Jpanel = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JtNitCliente = new javax.swing.JTextField();
        JtNombreCliente = new javax.swing.JTextField();
        JtDireccionCliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtableClientes = new javax.swing.JTable();
        BtGuardarCliente = new javax.swing.JButton();
        BtBuscarCliente = new javax.swing.JButton();
        BtEditarCliente = new javax.swing.JButton();
        BtEliminarCliente = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        Jtable = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        TfCodProveedor = new javax.swing.JTextField();
        TfNitProveedor = new javax.swing.JTextField();
        TfNombreProveedor = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        JtableProveedores = new javax.swing.JTable();
        BtGuardarProveedor = new javax.swing.JButton();
        BtBuscarProveedor = new javax.swing.JButton();
        BtEditarProveedor = new javax.swing.JButton();
        BtEliminarProveedor = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        TfDireccionProveedor = new javax.swing.JTextField();
        TfTelefonoProveedor = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        JtNombreArticulo = new javax.swing.JTextField();
        JtDescripcionArticulo = new javax.swing.JTextField();
        JtCantidadArticulo = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        JtableArticulos = new javax.swing.JTable();
        BtGuardarArticulo = new javax.swing.JButton();
        BtBuscarArticulo = new javax.swing.JButton();
        BtEditarArticulo = new javax.swing.JButton();
        BtEliminarArticulo = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        JtPrecioArticulo = new javax.swing.JTextField();
        JtProveedorArticulo = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        JtNitFactura = new javax.swing.JTextField();
        JtNombreFactura = new javax.swing.JTextField();
        JtDireccionFactura = new javax.swing.JTextField();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        JtCantidadProducto = new javax.swing.JTextField();
        JtNombreProducto = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        JtPrecioProducto = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        JtTotalProducto = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        JtableFacturas = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JtCodEmpleado = new javax.swing.JTextField();
        JtNombreEmpleado = new javax.swing.JTextField();
        JtPuesto = new javax.swing.JTextField();
        JtSalario = new javax.swing.JTextField();
        JbGuardar = new javax.swing.JButton();
        BtBuscar = new javax.swing.JButton();
        BtEditar = new javax.swing.JButton();
        BtEliminar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        JtableEmpleados = new javax.swing.JTable();
        JtUsuario = new javax.swing.JTextField();
        JtClave = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        JtEmpleados.setText("Empleados");
        JtEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtEmpleadosActionPerformed(evt);
            }
        });

        jButton2.setText("Clientes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Proveedores");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Articulos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Facturacion");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Reportes");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JtEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JtEmpleados)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Jpanel.setBackground(new java.awt.Color(255, 255, 255));
        Jpanel.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jLabel5.setText("Nit");

        jLabel6.setText("Nombre");

        jLabel7.setText("Direccion");

        JtableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nit", "Nombre", "Direccion"
            }
        ));
        jScrollPane2.setViewportView(JtableClientes);

        BtGuardarCliente.setText("Guardar");
        BtGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGuardarClienteActionPerformed(evt);
            }
        });

        BtBuscarCliente.setText("Buscar");
        BtBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarClienteActionPerformed(evt);
            }
        });

        BtEditarCliente.setText("Editar");
        BtEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarClienteActionPerformed(evt);
            }
        });

        BtEliminarCliente.setText("Eliminar");
        BtEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEliminarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JtNitCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(JtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(226, 226, 226))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(BtGuardarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(BtBuscarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(BtEditarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(BtEliminarCliente)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JtNitCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtGuardarCliente)
                    .addComponent(BtBuscarCliente)
                    .addComponent(BtEditarCliente)
                    .addComponent(BtEliminarCliente))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Jpanel.addTab("Clientes", jPanel3);

        Jtable.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                JtableComponentRemoved(evt);
            }
        });

        jLabel11.setText("Cod. Proveedor");

        jLabel12.setText("Nit");

        jLabel13.setText("Nombre");

        JtableProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nit", "Nombre", "Direccion", "Telefono"
            }
        ));
        jScrollPane4.setViewportView(JtableProveedores);

        BtGuardarProveedor.setText("Agregar");
        BtGuardarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGuardarProveedorActionPerformed(evt);
            }
        });

        BtBuscarProveedor.setText("Buscar");
        BtBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarProveedorActionPerformed(evt);
            }
        });

        BtEditarProveedor.setText("Editar");
        BtEditarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarProveedorActionPerformed(evt);
            }
        });

        BtEliminarProveedor.setText("Eliminar");
        BtEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEliminarProveedorActionPerformed(evt);
            }
        });

        jLabel14.setText("Direccion");

        jLabel15.setText("Telefono");

        javax.swing.GroupLayout JtableLayout = new javax.swing.GroupLayout(Jtable);
        Jtable.setLayout(JtableLayout);
        JtableLayout.setHorizontalGroup(
            JtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JtableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JtableLayout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JtableLayout.createSequentialGroup()
                        .addGroup(JtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfCodProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(28, 28, 28)
                        .addGroup(JtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfNitProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(JtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JtableLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(TfNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JtableLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(JtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JtableLayout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JtableLayout.createSequentialGroup()
                                .addComponent(TfDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TfTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))
                    .addGroup(JtableLayout.createSequentialGroup()
                        .addComponent(BtGuardarProveedor)
                        .addGap(18, 18, 18)
                        .addComponent(BtBuscarProveedor)
                        .addGap(18, 18, 18)
                        .addComponent(BtEditarProveedor)
                        .addGap(18, 18, 18)
                        .addComponent(BtEliminarProveedor)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        JtableLayout.setVerticalGroup(
            JtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JtableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TfCodProveedor)
                        .addComponent(TfNitProveedor))
                    .addComponent(TfNombreProveedor)
                    .addGroup(JtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TfDireccionProveedor)
                        .addComponent(TfTelefonoProveedor)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtGuardarProveedor)
                    .addComponent(BtBuscarProveedor)
                    .addComponent(BtEditarProveedor)
                    .addComponent(BtEliminarProveedor))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Jtable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Jtable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Jpanel.addTab("Proveedores", jPanel4);

        jPanel10.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                jPanel10ComponentRemoved(evt);
            }
        });

        jLabel16.setText("Nombre");

        jLabel17.setText("Descripcion");

        jLabel18.setText("Cantidad");

        JtableArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Descripcion", "Cantidad", "Precio U.", "Proveedor"
            }
        ));
        jScrollPane5.setViewportView(JtableArticulos);

        BtGuardarArticulo.setText("Agregar");
        BtGuardarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGuardarArticuloActionPerformed(evt);
            }
        });

        BtBuscarArticulo.setText("Buscar");
        BtBuscarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarArticuloActionPerformed(evt);
            }
        });

        BtEditarArticulo.setText("Editar");
        BtEditarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarArticuloActionPerformed(evt);
            }
        });

        BtEliminarArticulo.setText("Eliminar");
        BtEliminarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEliminarArticuloActionPerformed(evt);
            }
        });

        jLabel19.setText("Precio U.");

        jLabel20.setText("Proveedor");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane5)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(JtNombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JtDescripcionArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JtCantidadArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(JtPrecioArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(JtProveedorArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(BtGuardarArticulo)
                        .addGap(18, 18, 18)
                        .addComponent(BtBuscarArticulo)
                        .addGap(18, 18, 18)
                        .addComponent(BtEditarArticulo)
                        .addGap(18, 18, 18)
                        .addComponent(BtEliminarArticulo)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JtDescripcionArticulo)
                    .addComponent(JtNombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JtPrecioArticulo)
                        .addComponent(JtProveedorArticulo)
                        .addComponent(JtCantidadArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtGuardarArticulo)
                    .addComponent(BtBuscarArticulo)
                    .addComponent(BtEditarArticulo)
                    .addComponent(BtEliminarArticulo))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Jpanel.addTab("Articulos", jPanel5);

        jPanel11.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                jPanel11ComponentRemoved(evt);
            }
        });

        jLabel21.setText("Nit");

        jLabel22.setText("Nombre");

        jLabel23.setText("Direccion");

        JtNitFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtNitFacturaActionPerformed(evt);
            }
        });

        jButton27.setText("Facturar");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setText("Anular Factura");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        JtCantidadProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtCantidadProductoActionPerformed(evt);
            }
        });

        JtNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtNombreProductoActionPerformed(evt);
            }
        });

        jLabel24.setText("Nombre Producto");

        jLabel25.setText("Cantidad");

        JtPrecioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtPrecioProductoActionPerformed(evt);
            }
        });

        jLabel26.setText("Precio");

        JtTotalProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtTotalProductoActionPerformed(evt);
            }
        });

        jLabel27.setText("Total");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(JtNitFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                        .addComponent(JtNombreFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)))
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JtDireccionFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(JtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JtTotalProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel27)))))
                        .addGap(179, 179, 179))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jButton27)
                                .addGap(18, 18, 18)
                                .addComponent(jButton28))
                            .addComponent(jLabel24))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JtNombreFactura)
                            .addComponent(JtNitFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtDireccionFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 68, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtTotalProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(180, 180, 180)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton28)
                    .addComponent(jButton27))
                .addGap(23, 23, 23))
        );

        JtableFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nit", "Nombre", "Producto", "Precio U.", "Total"
            }
        ));
        jScrollPane6.setViewportView(JtableFacturas);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 11, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 12, Short.MAX_VALUE)))
        );

        Jpanel.addTab("Facturacion", jPanel6);

        jButton15.setText("Reporte Empleados");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Reporte Clientes");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Reporte Articulos");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Reporte Facturas");

        jButton29.setText("Reporte Proveedores");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(464, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton15)
                .addGap(15, 15, 15)
                .addComponent(jButton17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton29)
                .addGap(18, 18, 18)
                .addComponent(jButton18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton16)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        Jpanel.addTab("Reportes", jPanel8);

        jLabel1.setText("Cod. Empleado");

        jLabel2.setText("Nombre");

        jLabel3.setText("Puesto");

        jLabel4.setText("Salario");

        JbGuardar.setText("Agregar");
        JbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbGuardarActionPerformed(evt);
            }
        });

        BtBuscar.setText("Buscar");
        BtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarActionPerformed(evt);
            }
        });

        BtEditar.setText("Editar");
        BtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarActionPerformed(evt);
            }
        });

        BtEliminar.setText("Eliminar");
        BtEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEliminarActionPerformed(evt);
            }
        });

        JtableEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Puesto", "Salario", "Usuario", "Clave"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(JtableEmpleados);

        jLabel8.setText("Usuario");

        jLabel9.setText("Clave");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JtCodEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(JtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(34, 34, 34)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99))
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(JbGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(BtBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(BtEditar)
                                .addGap(18, 18, 18)
                                .addComponent(BtEliminar))
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JtCodEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbGuardar)
                    .addComponent(BtBuscar)
                    .addComponent(BtEditar)
                    .addComponent(BtEliminar))
                .addGap(26, 26, 26))
        );

        Jpanel.addTab("Empleados", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Jpanel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbGuardarActionPerformed

        String codEmpleado = JtCodEmpleado.getText();
        if (existeEmpleado(codEmpleado)) {
            JOptionPane.showMessageDialog(this, "El empleado ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            FileOutputStream archivo = new FileOutputStream("Empleados.bin", true); // true para modo de apertura para agregar al final
            DataOutputStream escritura = new DataOutputStream(archivo);

            Empleado empleado = new Empleado();
            empleado.setCodigo(JtCodEmpleado.getText());
            empleado.setNombre(JtNombreEmpleado.getText());
            empleado.setPuesto(JtPuesto.getText());
            empleado.setSalario(Float.parseFloat(JtSalario.getText()));
            empleado.setUsuario(JtUsuario.getText());
            empleado.setClave(JtClave.getText());

            escritura.writeUTF(codEmpleado);
            escritura.writeUTF(JtNombreEmpleado.getText());
            escritura.writeUTF(JtPuesto.getText());
            escritura.writeUTF(JtSalario.getText());
            escritura.writeUTF(JtUsuario.getText());
            escritura.writeUTF(JtClave.getText());

            escritura.close();

            JtCodEmpleado.setText("");
            JtNombreEmpleado.setText("");
            JtPuesto.setText("");
            JtSalario.setText("");
            JtUsuario.setText("");
            JtClave.setText("");

            mostrarEmpleadosEnTabla();

            JOptionPane.showMessageDialog(this, "Agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean existeEmpleado(String codEmpleado) {
        try {
            DataInputStream entrada = new DataInputStream(new FileInputStream("Empleados.bin"));

            while (entrada.available() > 0) {
                String codigo = entrada.readUTF();
                entrada.readUTF(); // Saltar nombre
                entrada.readUTF(); // Saltar puesto
                entrada.readUTF(); // Saltar salario
                entrada.readUTF(); // Saltar usuario
                entrada.readUTF(); // Saltar clave

                if (codigo.equals(codEmpleado)) {
                    entrada.close();
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }//GEN-LAST:event_JbGuardarActionPerformed

    private void JtableComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_JtableComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_JtableComponentRemoved

    private void jPanel10ComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jPanel10ComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10ComponentRemoved

    private void jPanel11ComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jPanel11ComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11ComponentRemoved

    private void BtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarActionPerformed

        String codEmpleado = JtCodEmpleado.getText().trim();

        if (!codEmpleado.isEmpty()) {
            try {
                DataInputStream entrada = new DataInputStream(new FileInputStream("Empleados.bin"));

                while (entrada.available() > 0) {
                    String codigo = entrada.readUTF();
                    String nombre = entrada.readUTF();
                    String puesto = entrada.readUTF();
                    String salario = entrada.readUTF();
                    String usuario = entrada.readUTF();
                    String clave = entrada.readUTF();

                    if (codigo.equals(codEmpleado)) {
                        JtNombreEmpleado.setText(nombre);
                        JtPuesto.setText(puesto);
                        JtSalario.setText(salario);
                        JtUsuario.setText(usuario);
                        JtClave.setText(clave);
                        JOptionPane.showMessageDialog(this, "Empleado encontrado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        entrada.close();
                        return;
                    }
                }

                JOptionPane.showMessageDialog(this, "Empleado no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "El archivo de empleados no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer el archivo de empleados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un código de empleado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtBuscarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        String codEmpleado = JtCodEmpleado.getText().trim();

        if (!codEmpleado.isEmpty()) {
            try {
                // Leer todos los empleados
                ArrayList empleados = new ArrayList();
                DataInputStream entrada = new DataInputStream(new FileInputStream("Empleados.bin"));

                while (entrada.available() > 0) {

                    Empleado empleado = new Empleado();
                    empleado.setCodigo(JtCodEmpleado.getText());
                    empleado.setNombre(JtNombreEmpleado.getText());
                    empleado.setPuesto(JtPuesto.getText());
                    empleado.setSalario(Float.parseFloat(JtSalario.getText()));
                    empleado.setUsuario(JtUsuario.getText());
                    empleado.setClave(JtClave.getText());

                    String codigo = entrada.readUTF();
                    String nombre = entrada.readUTF();
                    String puesto = entrada.readUTF();
                    String salario = entrada.readUTF();
                    String usuario = entrada.readUTF();
                    String clave = entrada.readUTF();

                    empleados.add(new String[]{codigo, nombre, puesto, salario, usuario, clave});
                }

                entrada.close();

                // Buscar el empleado para editar
                for (int i = 0; i < empleados.size(); i++) {
                    String[] empleado = (String[]) empleados.get(i);

                    if (empleado[0].equals(codEmpleado)) {
                        // Editar los detalles del empleado
                        empleado[1] = JtNombreEmpleado.getText();
                        empleado[2] = JtPuesto.getText();
                        empleado[3] = JtSalario.getText();
                        empleado[4] = JtUsuario.getText();
                        empleado[5] = JtClave.getText();

                        JOptionPane.showMessageDialog(this, "Empleado editado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                // Reescribir todos los empleados en el archivo
                DataOutputStream salida = new DataOutputStream(new FileOutputStream("Empleados.bin"));

                for (int i = 0; i < empleados.size(); i++) {
                    String[] empleado = (String[]) empleados.get(i);

                    salida.writeUTF(empleado[0]);
                    salida.writeUTF(empleado[1]);
                    salida.writeUTF(empleado[2]);
                    salida.writeUTF(empleado[3]);
                    salida.writeUTF(empleado[4]);
                    salida.writeUTF(empleado[5]);
                    mostrarEmpleadosEnTabla();
                }

                salida.close();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "El archivo de empleados no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer o escribir el archivo de empleados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un código de empleado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtEditarActionPerformed

    private void BtEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEliminarActionPerformed
        String codEmpleado = JtCodEmpleado.getText().trim();

        if (!codEmpleado.isEmpty()) {
            DataInputStream entrada = null;
            DataOutputStream salida = null;
            try {
                // Leer todos los empleados
                List<Empleado> empleados = new ArrayList<>();
                entrada = new DataInputStream(new FileInputStream("Empleados.bin"));

                while (entrada.available() > 0) {
                    Empleado empleado = new Empleado();
                    empleado.setCodigo(entrada.readUTF());
                    empleado.setNombre(entrada.readUTF());
                    empleado.setPuesto(entrada.readUTF());
                    empleado.setSalario(Float.parseFloat(entrada.readUTF()));
                    empleado.setUsuario(entrada.readUTF());
                    empleado.setClave(entrada.readUTF());

                    empleados.add(empleado);
                }

                // Buscar el empleado para eliminar
                Iterator<Empleado> iterator = empleados.iterator();
                while (iterator.hasNext()) {
                    Empleado empleado = iterator.next();

                    if (empleado.getCodigo().equals(codEmpleado)) {
                        // Eliminar el empleado
                        iterator.remove();

                        JOptionPane.showMessageDialog(this, "Empleado eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }

                // Reescribir todos los empleados en el archivo
                salida = new DataOutputStream(new FileOutputStream("Empleados.bin"));

                for (Empleado empleado : empleados) {
                    salida.writeUTF(empleado.getCodigo());
                    salida.writeUTF(empleado.getNombre());
                    salida.writeUTF(empleado.getPuesto());
                    salida.writeUTF(String.valueOf(empleado.getSalario()));
                    salida.writeUTF(empleado.getUsuario());
                    salida.writeUTF(empleado.getClave());
                }

                mostrarEmpleadosEnTabla();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "El archivo de empleados no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al leer o escribir el archivo de empleados", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (entrada != null) {
                        entrada.close();
                    }
                    if (salida != null) {
                        salida.close();
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error al cerrar el archivo de empleados", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un código de empleado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtEliminarActionPerformed

    private void JtEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtEmpleadosActionPerformed

        Jpanel.setSelectedIndex(5);
    }//GEN-LAST:event_JtEmpleadosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Jpanel.setSelectedIndex(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Jpanel.setSelectedIndex(1);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        Jpanel.setSelectedIndex(3);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Jpanel.setSelectedIndex(4);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        Jpanel.setSelectedIndex(2);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BtGuardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGuardarProveedorActionPerformed

        String codProveedor = TfCodProveedor.getText();
        if (existeProveedor(codProveedor)) {
            JOptionPane.showMessageDialog(this, "El Proveedor ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            FileOutputStream archivo = new FileOutputStream("Proveedores.bin", true); // true para modo de apertura para agregar al final
            DataOutputStream escritura = new DataOutputStream(archivo);

            Proveedor proveedor = new Proveedor();
            proveedor.setCodigo(TfCodProveedor.getText());
            proveedor.setNit(TfNitProveedor.getText());
            proveedor.setNombre(TfNombreProveedor.getText());
            proveedor.setDireccion(TfDireccionProveedor.getText());
            proveedor.setTelefono(Integer.parseInt(TfTelefonoProveedor.getText()));

            escritura.writeUTF(codProveedor);
            escritura.writeUTF(TfNitProveedor.getText());
            escritura.writeUTF(TfNombreProveedor.getText());
            escritura.writeUTF(TfDireccionProveedor.getText());
            escritura.writeUTF(TfTelefonoProveedor.getText());

            escritura.close();

            TfCodProveedor.setText("");
            TfNitProveedor.setText("");
            TfNombreProveedor.setText("");
            TfDireccionProveedor.setText("");
            TfTelefonoProveedor.setText("");

            mostrarProveedoresEnTabla();

            JOptionPane.showMessageDialog(this, "Agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean existeProveedor(String codProveedor) {
        try {
            DataInputStream entrada = new DataInputStream(new FileInputStream("Proveedores.bin"));

            while (entrada.available() > 0) {
                String codigo = entrada.readUTF();

                entrada.readUTF(); // Saltar nit
                entrada.readUTF(); // Saltar nombre
                entrada.readUTF(); // Saltar direccion
                entrada.readUTF(); // Saltar telefono

                if (codigo.equals(codProveedor)) {
                    entrada.close();
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;


    }//GEN-LAST:event_BtGuardarProveedorActionPerformed

    private void BtBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarProveedorActionPerformed

        String codProveedor = TfCodProveedor.getText().trim();

        if (!codProveedor.isEmpty()) {
            try {
                DataInputStream entrada = new DataInputStream(new FileInputStream("Proveedores.bin"));

                while (entrada.available() > 0) {
                    String codigo = entrada.readUTF();
                    String nit = entrada.readUTF();
                    String nombre = entrada.readUTF();
                    String direccion = entrada.readUTF();
                    String telefono = entrada.readUTF();

                    if (codigo.equals(codProveedor)) {
                        TfNitProveedor.setText(nit);
                        TfNombreProveedor.setText(nombre);
                        TfDireccionProveedor.setText(direccion);
                        TfTelefonoProveedor.setText(telefono);

                        JOptionPane.showMessageDialog(this, "Proveedor encontrado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        entrada.close();
                        return;
                    }
                }

                JOptionPane.showMessageDialog(this, "Proveedor no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "El archivo de Proveedores no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer el archivo de Proveedores", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un código de Proveedor", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtBuscarProveedorActionPerformed

    private void BtEditarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarProveedorActionPerformed

        String codProveedor = TfCodProveedor.getText().trim();

        if (!codProveedor.isEmpty()) {
            try {
                // Leer todos los empleados
                ArrayList proveedores = new ArrayList();
                DataInputStream entrada = new DataInputStream(new FileInputStream("Proveedores.bin"));

                while (entrada.available() > 0) {
                    Proveedor proveedor = new Proveedor();
                    proveedor.setCodigo(TfCodProveedor.getText());
                    proveedor.setNit(TfNitProveedor.getText());
                    proveedor.setNombre(TfNombreProveedor.getText());
                    proveedor.setDireccion(TfDireccionProveedor.getText());
                    proveedor.setTelefono(Integer.parseInt(TfTelefonoProveedor.getText()));

                    String codigo = entrada.readUTF();
                    String nit = entrada.readUTF();
                    String nombre = entrada.readUTF();
                    String direccion = entrada.readUTF();
                    String telefono = entrada.readUTF();

                    proveedores.add(new String[]{codigo, nit, nombre, direccion, telefono});
                }

                entrada.close();

                // Buscar el empleado para editar
                for (int i = 0; i < proveedores.size(); i++) {
                    String[] proveedor = (String[]) proveedores.get(i);

                    if (proveedor[0].equals(codProveedor)) {
                        // Editar los detalles del empleado
                        proveedor[1] = TfNitProveedor.getText();
                        proveedor[2] = TfNombreProveedor.getText();
                        proveedor[3] = TfDireccionProveedor.getText();
                        proveedor[4] = TfTelefonoProveedor.getText();

                        JOptionPane.showMessageDialog(this, "Proveedor editado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                // Reescribir todos los empleados en el archivo
                DataOutputStream salida = new DataOutputStream(new FileOutputStream("Proveedores.bin"));

                for (int i = 0; i < proveedores.size(); i++) {
                    String[] proveedor = (String[]) proveedores.get(i);

                    salida.writeUTF(proveedor[0]);
                    salida.writeUTF(proveedor[1]);
                    salida.writeUTF(proveedor[2]);
                    salida.writeUTF(proveedor[3]);
                    salida.writeUTF(proveedor[4]);
                    mostrarProveedoresEnTabla();
                }

                salida.close();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "El archivo de empleados no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer o escribir el archivo de empleados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un código de empleado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtEditarProveedorActionPerformed

    private void BtEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEliminarProveedorActionPerformed

        String codProveedor = TfCodProveedor.getText().trim();

        if (!codProveedor.isEmpty()) {
            DataInputStream entrada = null;
            DataOutputStream salida = null;
            try {
                // Leer todos los proveedores
                List<Proveedor> proveedores = new ArrayList<>();
                entrada = new DataInputStream(new FileInputStream("Proveedores.bin"));

                while (entrada.available() > 0) {
                    Proveedor proveedor = new Proveedor();
                    proveedor.setCodigo(entrada.readUTF());
                    proveedor.setNit(entrada.readUTF());
                    proveedor.setNombre(entrada.readUTF());
                    proveedor.setDireccion(entrada.readUTF());
                    proveedor.setTelefono(Integer.parseInt(entrada.readUTF()));

                    proveedores.add(proveedor);
                }

                // Buscar el proveedor para eliminar
                Iterator<Proveedor> iterator = proveedores.iterator();
                while (iterator.hasNext()) {
                    Proveedor proveedor = iterator.next();

                    if (proveedor.getCodigo().equals(codProveedor)) {
                        // Eliminar el proveedor
                        iterator.remove();

                        JOptionPane.showMessageDialog(this, "Proveedor eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }

                // Reescribir todos los proveedores en el archivo
                salida = new DataOutputStream(new FileOutputStream("Proveedores.bin"));

                for (Proveedor proveedor : proveedores) {
                    salida.writeUTF(proveedor.getCodigo());
                    salida.writeUTF(proveedor.getNit());
                    salida.writeUTF(proveedor.getNombre());
                    salida.writeUTF(proveedor.getDireccion());
                    salida.writeUTF(String.valueOf(proveedor.getTelefono()));
                }

                mostrarProveedoresEnTabla();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "El archivo de proveedores no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al leer o escribir el archivo de proveedores", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (entrada != null) {
                        entrada.close();
                    }
                    if (salida != null) {
                        salida.close();
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error al cerrar el archivo de proveedores", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un código de proveedor", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtEliminarProveedorActionPerformed

    private void BtGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGuardarClienteActionPerformed

        String nitCliente = JtNitCliente.getText();
        if (existeCliente(nitCliente)) {
            JOptionPane.showMessageDialog(this, "El cliente ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            FileOutputStream archivo = new FileOutputStream("Clientes.bin", true); // true para modo de apertura para agregar al final
            DataOutputStream escritura = new DataOutputStream(archivo);

            Cliente cliente = new Cliente();
            cliente.setNit(JtNitCliente.getText());
            cliente.setNombre(JtNombreCliente.getText());
            cliente.setDireccion(JtDireccionCliente.getText());

            escritura.writeUTF(cliente.getNit());
            escritura.writeUTF(cliente.getNombre());
            escritura.writeUTF(cliente.getDireccion());

            escritura.close();

            JtNitCliente.setText("");
            JtNombreCliente.setText("");
            JtDireccionCliente.setText("");

            mostarClientesEnTabla();

            JOptionPane.showMessageDialog(this, "Agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean existeCliente(String nitCliente) {
        try {
            DataInputStream entrada = new DataInputStream(new FileInputStream("Clientes.bin"));

            while (entrada.available() > 0) {
                String nit = entrada.readUTF();
                entrada.readUTF(); // Saltar nombre
                entrada.readUTF(); // Saltar dirección

                if (nit.equals(nitCliente)) {
                    entrada.close();
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;

    }//GEN-LAST:event_BtGuardarClienteActionPerformed

    private void BtBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarClienteActionPerformed

        String nitCliente = JtNitCliente.getText().trim();

        if (!nitCliente.isEmpty()) {
            try {
                DataInputStream entrada = new DataInputStream(new FileInputStream("Clientes.bin"));

                while (entrada.available() > 0) {
                    String nit = entrada.readUTF();
                    String nombre = entrada.readUTF();
                    String direccion = entrada.readUTF();

                    if (nit.equals(nitCliente)) {
                        JtNitCliente.setText(nit);
                        JtNombreCliente.setText(nombre);
                        JtDireccionCliente.setText(direccion);

                        JOptionPane.showMessageDialog(this, "Cliente encontrado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        entrada.close();
                        return;
                    }
                }

                JOptionPane.showMessageDialog(this, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "El archivo de Clientes no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer el archivo de Clientes", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un código de Clientes", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_BtBuscarClienteActionPerformed

    private void BtEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarClienteActionPerformed

        String nitCliente = JtNitCliente.getText().trim();

        if (!nitCliente.isEmpty()) {
            DataInputStream entrada = null;
            DataOutputStream salida = null;
            try {
                // Leer todos los clientes
                List<Cliente> clientes = new ArrayList<>();
                entrada = new DataInputStream(new FileInputStream("Clientes.bin"));

                while (entrada.available() > 0) {
                    Cliente cliente = new Cliente();
                    cliente.setNit(entrada.readUTF());
                    cliente.setNombre(entrada.readUTF());
                    cliente.setDireccion(entrada.readUTF());

                    clientes.add(cliente);
                }

                // Buscar el cliente para editar
                for (Cliente cliente : clientes) {
                    if (cliente.getNit().equals(nitCliente)) {
                        // Editar los detalles del cliente
                        cliente.setNombre(JtNombreCliente.getText());
                        cliente.setDireccion(JtDireccionCliente.getText());

                        JOptionPane.showMessageDialog(this, "Cliente editado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                // Reescribir todos los clientes en el archivo
                salida = new DataOutputStream(new FileOutputStream("Clientes.bin"));

                for (Cliente cliente : clientes) {
                    salida.writeUTF(cliente.getNit());
                    salida.writeUTF(cliente.getNombre());
                    salida.writeUTF(cliente.getDireccion());
                }

                mostarClientesEnTabla();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "El archivo de clientes no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al leer o escribir el archivo de clientes", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (entrada != null) {
                        entrada.close();
                    }
                    if (salida != null) {
                        salida.close();
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error al cerrar el archivo de clientes", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un nit de cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_BtEditarClienteActionPerformed

    private void BtEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEliminarClienteActionPerformed

        String nitCliente = JtNitCliente.getText().trim();

        if (!nitCliente.isEmpty()) {
            DataInputStream entrada = null;
            DataOutputStream salida = null;
            try {
                // Leer todos los clientes
                List<Cliente> clientes = new ArrayList<>();
                entrada = new DataInputStream(new FileInputStream("Clientes.bin"));

                while (entrada.available() > 0) {
                    Cliente cliente = new Cliente();
                    cliente.setNit(entrada.readUTF());
                    cliente.setNombre(entrada.readUTF());
                    cliente.setDireccion(entrada.readUTF());

                    clientes.add(cliente);
                }

                // Buscar el cliente para eliminar
                Iterator<Cliente> iterator = clientes.iterator();
                while (iterator.hasNext()) {
                    Cliente cliente = iterator.next();

                    if (cliente.getNit().equals(nitCliente)) {
                        // Eliminar el cliente
                        iterator.remove();

                        JOptionPane.showMessageDialog(this, "Cliente eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }

                // Reescribir todos los clientes en el archivo
                salida = new DataOutputStream(new FileOutputStream("Clientes.bin"));

                for (Cliente cliente : clientes) {
                    salida.writeUTF(cliente.getNit());
                    salida.writeUTF(cliente.getNombre());
                    salida.writeUTF(cliente.getDireccion());
                }

                mostarClientesEnTabla();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "El archivo de clientes no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al leer o escribir el archivo de clientes", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (entrada != null) {
                        entrada.close();
                    }
                    if (salida != null) {
                        salida.close();
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error al cerrar el archivo de clientes", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un nit de cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_BtEliminarClienteActionPerformed

    private void BtGuardarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGuardarArticuloActionPerformed

        String nombreArticulo = JtNombreArticulo.getText();
        String nombreProveedor = JtProveedorArticulo.getText();

        if (!existeProveedor2(nombreProveedor)) {
            JOptionPane.showMessageDialog(this, "El Proveedor No! existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (existeArticulo(nombreArticulo)) {
            JOptionPane.showMessageDialog(this, "El Articulo ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DataOutputStream escritura = null;
        try {
            FileOutputStream archivo = new FileOutputStream("Articulos.bin", true); // true para modo de apertura para agregar al final
            escritura = new DataOutputStream(archivo);

            Articulo articulo = new Articulo();
            articulo.setNombre(JtNombreArticulo.getText());
            articulo.setDescripcion(JtDescripcionArticulo.getText());
            articulo.setCantidad(Integer.parseInt(JtCantidadArticulo.getText()));
            articulo.setPrecio(Float.parseFloat(JtPrecioArticulo.getText()));
            articulo.setProveedor(JtProveedorArticulo.getText());

            escritura.writeUTF(articulo.getNombre());
            escritura.writeUTF(articulo.getDescripcion());
            escritura.writeUTF(String.valueOf(articulo.getCantidad()));
            escritura.writeUTF(String.valueOf(articulo.getPrecio()));
            escritura.writeUTF(articulo.getProveedor());

            JtNombreArticulo.setText("");
            JtDescripcionArticulo.setText("");
            JtCantidadArticulo.setText("");
            JtPrecioArticulo.setText("");
            JtProveedorArticulo.setText("");

            mostarArticulosEnTabla();

            JOptionPane.showMessageDialog(this, "Agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (escritura != null) {
                    escritura.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar el archivo de artículos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean existeArticulo(String nombreArticulo) {
        try {
            DataInputStream entrada = new DataInputStream(new FileInputStream("Articulos.bin"));

            while (entrada.available() > 0) {
                String nombre = entrada.readUTF();
                entrada.readUTF(); // Saltar nombre
                entrada.readUTF(); // Saltar puesto

                if (nombre.equals(nombreArticulo)) {
                    entrada.close();
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;

    }

    private boolean existeProveedor2(String nombreProveedor) {
        try {
            DataInputStream entrada = new DataInputStream(new FileInputStream("Proveedores.bin"));

            while (entrada.available() > 0) {
                entrada.readUTF(); // Saltar primer registro
                entrada.readUTF(); // Saltar segundo registro
                String nombre = entrada.readUTF(); // Leer nombre del proveedor

                if (nombre.equals(nombreProveedor)) {
                    entrada.close();
                    return true;
                }
                entrada.readUTF(); // Saltar cuarto registro
                entrada.readUTF(); // Saltar quinto registro
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }//GEN-LAST:event_BtGuardarArticuloActionPerformed

    private void BtBuscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarArticuloActionPerformed
        String nombreArticulo = JtNombreArticulo.getText().trim();

        if (!nombreArticulo.isEmpty()) {
            try {
                DataInputStream entrada = new DataInputStream(new FileInputStream("Articulos.bin"));

                while (entrada.available() > 0) {
                    String nombre = entrada.readUTF();
                    String descripcion = entrada.readUTF();
                    String cantidad = entrada.readUTF();
                    String precio = entrada.readUTF();
                    String proveedor = entrada.readUTF();

                    if (nombre.equals(nombreArticulo)) {
                        JtNombreArticulo.setText(nombre);
                        JtDescripcionArticulo.setText(descripcion);
                        JtCantidadArticulo.setText(cantidad);
                        JtPrecioArticulo.setText(precio);
                        JtProveedorArticulo.setText(proveedor);

                        JOptionPane.showMessageDialog(this, "Articulo encontrado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        entrada.close();
                        return;
                    }
                }

                JOptionPane.showMessageDialog(this, "Articulo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "El archivo de Articulos no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer el archivo de Articulos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un código de Articulos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtBuscarArticuloActionPerformed

    private void BtEditarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarArticuloActionPerformed

        String nombreArticulo = JtNombreArticulo.getText().trim();

        if (!nombreArticulo.isEmpty()) {
            DataInputStream entrada = null;
            DataOutputStream salida = null;
            try {
                // Leer todos los articulos
                List<Articulo> articulos = new ArrayList<>();
                entrada = new DataInputStream(new FileInputStream("Articulos.bin"));

                while (entrada.available() > 0) {
                    Articulo articulo = new Articulo();
                    articulo.setNombre(entrada.readUTF());
                    articulo.setDescripcion(entrada.readUTF());
                    articulo.setCantidad(Integer.parseInt(entrada.readUTF()));
                    articulo.setPrecio(Float.parseFloat(entrada.readUTF()));
                    articulo.setProveedor(entrada.readUTF());

                    articulos.add(articulo);
                }

                // Buscar el articulo para editar
                for (Articulo articulo : articulos) {
                    if (articulo.getNombre().equals(nombreArticulo)) {
                        // Editar los detalles del articulo
                        articulo.setDescripcion(JtDescripcionArticulo.getText());
                        articulo.setCantidad(Integer.parseInt(JtCantidadArticulo.getText()));
                        articulo.setPrecio(Float.parseFloat(JtPrecioArticulo.getText()));
                        articulo.setProveedor(JtProveedorArticulo.getText());

                        JOptionPane.showMessageDialog(this, "Articulo editado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }

                // Reescribir todos los articulos en el archivo
                salida = new DataOutputStream(new FileOutputStream("Articulos.bin"));

                for (Articulo articulo : articulos) {
                    salida.writeUTF(articulo.getNombre());
                    salida.writeUTF(articulo.getDescripcion());
                    salida.writeUTF(String.valueOf(articulo.getCantidad()));
                    salida.writeUTF(String.valueOf(articulo.getPrecio()));
                    salida.writeUTF(articulo.getProveedor());
                }

                mostarArticulosEnTabla();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "El archivo de articulos no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al leer o escribir el archivo de articulos", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (entrada != null) {
                        entrada.close();
                    }
                    if (salida != null) {
                        salida.close();
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error al cerrar el archivo de articulos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre de articulo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtEditarArticuloActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        try {
            String filePath = "Empleados.html";
            try (FileWriter myWriter = new FileWriter(filePath); FileInputStream archivo = new FileInputStream("Empleados.bin"); DataInputStream lectura = new DataInputStream(archivo)) {

                myWriter.write("<html><head><title>Reporte de Empleados</title>");
                myWriter.write("<style>"
                        + "body {font-family: Arial, sans-serif; padding: 0 10px;}"
                        + "table {width: 100%; border-collapse: collapse; margin: 15px 0;}"
                        + "th {background-color: #4CAF50; color: white;}"
                        + "th, td {border: 1px solid #ddd; padding: 8px;}"
                        + "tr:nth-child(even) {background-color: #f2f2f2;}"
                        + "tr:hover {background-color: #ddd;}"
                        + "</style></head><body>");
                myWriter.write("<h2>Reporte de Empleados</h2>");
                myWriter.write("<table><tr><th>Codigo</th><th>Nombre</th><th>Puesto</th><th>Salario</th><th>Usuario</th><th>Clave</th></tr>");

                while (lectura.available() > 0) {
                    String codigo = lectura.readUTF();
                    String nombre = lectura.readUTF();
                    String puesto = lectura.readUTF();
                    String salario = lectura.readUTF();
                    String usuario = lectura.readUTF();
                    String clave = lectura.readUTF();
                    myWriter.write("<tr><td>" + codigo + "</td><td>" + nombre + "</td><td>" + puesto + "</td><td>" + salario + "</td><td>" + usuario + "</td><td>" + clave + "</td></tr>");
                }

                myWriter.write("</table></body></html>");
            }

            // Abrir el archivo HTML en el navegador predeterminado
            Desktop.getDesktop().browse(new File(filePath).toURI());
        } catch (IOException y) {
            y.printStackTrace();
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed

        try {
            String filePath = "Articulos.html";
            try (FileWriter myWriter = new FileWriter(filePath); FileInputStream archivo = new FileInputStream("Articulos.bin"); DataInputStream lectura = new DataInputStream(archivo)) {

                myWriter.write("<html><head><title>Reporte de Articulos</title>");
                myWriter.write("<style>"
                        + "body {font-family: Arial, sans-serif; padding: 0 10px;}"
                        + "table {width: 100%; border-collapse: collapse; margin: 15px 0;}"
                        + "th {background-color: #4CAF50; color: white;}"
                        + "th, td {border: 1px solid #ddd; padding: 8px;}"
                        + "tr:nth-child(even) {background-color: #f2f2f2;}"
                        + "tr:hover {background-color: #ddd;}"
                        + "</style></head><body>");
                myWriter.write("<h2>Reporte de Articulos</h2>");
                myWriter.write("<table><tr><th>Nombre</th><th>Descripcion</th><th>Cantidad</th><th>Precio</th><th>Proveedor</th></tr>");

                while (lectura.available() > 0) {
                    String nombre = lectura.readUTF();
                    String descripcion = lectura.readUTF();
                    String cantidad = lectura.readUTF();
                    String precio = lectura.readUTF();
                    String proveedor = lectura.readUTF();
                    myWriter.write("<tr><td>" + nombre + "</td><td>" + descripcion + "</td><td>" + cantidad + "</td><td>" + precio + "</td><td>" + proveedor + "</td></tr>");
                }

                myWriter.write("</table></body></html>");
            }

            // Abrir el archivo HTML en el navegador predeterminado
            Desktop.getDesktop().browse(new File(filePath).toURI());
        } catch (IOException y) {
            y.printStackTrace();
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        try {
            String filePath = "Proveedores.html";
            try (FileWriter myWriter = new FileWriter(filePath); FileInputStream archivo = new FileInputStream("Proveedores.bin"); DataInputStream lectura = new DataInputStream(archivo)) {

                myWriter.write("<html><head><title>Reporte de Proveedores</title>");
                myWriter.write("<style>"
                        + "body {font-family: Arial, sans-serif; padding: 0 10px;}"
                        + "table {width: 100%; border-collapse: collapse; margin: 15px 0;}"
                        + "th {background-color: #4CAF50; color: white;}"
                        + "th, td {border: 1px solid #ddd; padding: 8px;}"
                        + "tr:nth-child(even) {background-color: #f2f2f2;}"
                        + "tr:hover {background-color: #ddd;}"
                        + "</style></head><body>");
                myWriter.write("<h2>Reporte de Proveedores</h2>");
                myWriter.write("<table><tr><th>Codigo</th><th>Nit</th><th>Nomre</th><th>Direccion</th><th>Telefono</th></tr>");

                while (lectura.available() > 0) {
                    String codigo = lectura.readUTF();
                    String nit = lectura.readUTF();
                    String nombre = lectura.readUTF();
                    String direccion = lectura.readUTF();
                    String telefono = lectura.readUTF();
                    myWriter.write("<tr><td>" + codigo + "</td><td>" + nit + "</td><td>" + nombre + "</td><td>" + direccion + "</td><td>" + telefono
                            + "</td></tr>");
                }

                myWriter.write("</table></body></html>");
            }

            // Abrir el archivo HTML en el navegador predeterminado
            Desktop.getDesktop().browse(new File(filePath).toURI());
        } catch (IOException y) {
            y.printStackTrace();
        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        try {
            String filePath = "Clientes.html";
            try (FileWriter myWriter = new FileWriter(filePath); FileInputStream archivo = new FileInputStream("Clientes.bin"); DataInputStream lectura = new DataInputStream(archivo)) {

                myWriter.write("<html><head><title>Reporte de Clientes</title>");
                myWriter.write("<style>"
                        + "body {font-family: Arial, sans-serif; padding: 0 10px;}"
                        + "table {width: 100%; border-collapse: collapse; margin: 15px 0;}"
                        + "th {background-color: #4CAF50; color: white;}"
                        + "th, td {border: 1px solid #ddd; padding: 8px;}"
                        + "tr:nth-child(even) {background-color: #f2f2f2;}"
                        + "tr:hover {background-color: #ddd;}"
                        + "</style></head><body>");
                myWriter.write("<h2>Reporte de Clientes</h2>");
                myWriter.write("<table><tr><th>Nit</th><th>Nombre</th><th>Direccion</th>"
                        + "</tr>");

                while (lectura.available() > 0) {
                    String nit = lectura.readUTF();
                    String nombre = lectura.readUTF();
                    String direccion = lectura.readUTF();
                    myWriter.write("<tr><td>" + nit + "</td><td>" + nombre + "</td><td>" + direccion + "</td>"
                            + "</tr>");
                }

                myWriter.write("</table></body></html>");
            }

            // Abrir el archivo HTML en el navegador predeterminado
            Desktop.getDesktop().browse(new File(filePath).toURI());
        } catch (IOException y) {
            y.printStackTrace();
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
String nitCliente = JtNitFactura.getText();

if (!existeCliente(nitCliente)) {
    JOptionPane.showMessageDialog(this, "El cliente no existe", "Error", JOptionPane.ERROR_MESSAGE);
    return;
} else {
    DataInputStream entradaClientes = null;
    try {
        entradaClientes = new DataInputStream(new FileInputStream("Clientes.bin"));
        while (entradaClientes.available() > 0) {
            String nit = entradaClientes.readUTF();
            String nombre = entradaClientes.readUTF();
            String direccion = entradaClientes.readUTF();

            if (nit.equals(nitCliente)) {
                JtNitFactura.setText(nit);
                JtNombreFactura.setText(nombre);
                JtDireccionFactura.setText(direccion);

                entradaClientes.close();
                break;
            }
        }
    } catch (IOException ex) {
        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
    }

    String nombreArticulo = JtNombreProducto.getText().trim();

    if (!nombreArticulo.isEmpty()) {
        DataInputStream entradaArticulos = null;
        try {
            entradaArticulos = new DataInputStream(new FileInputStream("Articulos.bin"));
            while (entradaArticulos.available() > 0) {
                String nombre = entradaArticulos.readUTF();
                String descripcion = entradaArticulos.readUTF();
                String cantidad = entradaArticulos.readUTF();
                String precio = entradaArticulos.readUTF();
                String proveedor = entradaArticulos.readUTF();

                if (nombre.equals(nombreArticulo)) {
                    int cantidadIngresada = Integer.parseInt(JtCantidadProducto.getText().trim());
                    int cantidadDisponible = Integer.parseInt(cantidad);

                    if (cantidadIngresada > cantidadDisponible) {
                        JOptionPane.showMessageDialog(this, "La cantidad ingresada sobrepasa el inventario disponible", "Error", JOptionPane.ERROR_MESSAGE);
                        entradaArticulos.close();
                        return;
                    }

                    JtNombreProducto.setText(nombre);
                    JtPrecioProducto.setText(precio);

                    // Multiplicación de la cantidad ingresada y el precio
                    double precioProducto = Double.parseDouble(precio);
                    double total = cantidadIngresada * precioProducto;
                    JtTotalProducto.setText(String.valueOf(total));

                    entradaArticulos.close();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Articulo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (entradaArticulos != null) {
                    entradaArticulos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

try {
    File file = new File("Facturas.bin");
    if (!file.exists()) {
        file.createNewFile();
    }
    FileOutputStream archivo = new FileOutputStream(file, true); // true para modo de apertura para agregar al final
    DataOutputStream escritura = new DataOutputStream(archivo);

    Factura factura = new Factura();
    factura.setNit(JtNitFactura.getText());
    factura.setNombre(JtNombreFactura.getText());
    factura.setDireccion(JtDireccionFactura.getText());
    factura.setProducto(JtNombreProducto.getText());
    factura.setCantidad(Integer.parseInt(JtCantidadProducto.getText()));
    factura.setPrecio(Float.parseFloat(JtPrecioProducto.getText()));
    factura.setTotal(Float.parseFloat(JtTotalProducto.getText()));

    escritura.writeUTF(factura.getNit());
    escritura.writeUTF(factura.getNombre());
    escritura.writeUTF(factura.getDireccion());
    escritura.writeUTF(factura.getProducto());
    escritura.writeInt(factura.getCantidad());
    escritura.writeFloat(factura.getPrecio());
    escritura.writeFloat(factura.getTotal());

    escritura.close(); // Asegura que todos los datos se escriban en el archivo

    System.out.println("Se guardó la siguiente factura:");
    System.out.println("NIT: " + factura.getNit());
    System.out.println("Nombre: " + factura.getNombre());
    System.out.println("Dirección: " + factura.getDireccion());
    System.out.println("Producto: " + factura.getProducto());
    System.out.println("Cantidad: " + factura.getCantidad());
    System.out.println("Precio: " + factura.getPrecio());
    System.out.println("Total: " + factura.getTotal());

    JOptionPane.showMessageDialog(this, "Agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
} catch (IOException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error al guardar la factura", "Error", JOptionPane.ERROR_MESSAGE);
}
}
    }//GEN-LAST:event_jButton27ActionPerformed

    private void JtNitFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtNitFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtNitFacturaActionPerformed

    private void BtEliminarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEliminarArticuloActionPerformed

        String nombreArticulo = JtNombreArticulo.getText().trim();

        if (!nombreArticulo.isEmpty()) {
            DataInputStream entrada = null;
            DataOutputStream salida = null;
            try {
                // Leer todos los articulos
                List<Articulo> articulos = new ArrayList<>();
                entrada = new DataInputStream(new FileInputStream("Articulos.bin"));

                while (entrada.available() > 0) {
                    Articulo articulo = new Articulo();
                    articulo.setNombre(entrada.readUTF());
                    articulo.setDescripcion(entrada.readUTF());
                    articulo.setCantidad(Integer.parseInt(entrada.readUTF()));
                    articulo.setPrecio(Float.parseFloat(entrada.readUTF()));
                    articulo.setProveedor(entrada.readUTF());

                    articulos.add(articulo);
                }

                // Buscar el articulo para eliminar
                Iterator<Articulo> iterator = articulos.iterator();
                while (iterator.hasNext()) {
                    Articulo articulo = iterator.next();

                    if (articulo.getNombre().equals(nombreArticulo)) {
                        // Eliminar el articulo
                        iterator.remove();

                        JOptionPane.showMessageDialog(this, "Articulo eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }

                // Reescribir todos los articulos en el archivo
                salida = new DataOutputStream(new FileOutputStream("Articulos.bin"));

                for (Articulo articulo : articulos) {
                    salida.writeUTF(articulo.getNombre());
                    salida.writeUTF(articulo.getDescripcion());
                    salida.writeUTF(String.valueOf(articulo.getCantidad()));
                    salida.writeUTF(String.valueOf(articulo.getPrecio()));
                    salida.writeUTF(articulo.getProveedor());
                }

                mostarArticulosEnTabla();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "El archivo de articulos no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al leer o escribir el archivo de articulos", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (entrada != null) {
                        entrada.close();
                    }
                    if (salida != null) {
                        salida.close();
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error al cerrar el archivo de articulos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre de articulo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtEliminarArticuloActionPerformed

    private void JtCantidadProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtCantidadProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtCantidadProductoActionPerformed

    private void JtNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtNombreProductoActionPerformed

    private void JtPrecioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtPrecioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtPrecioProductoActionPerformed

    private void JtTotalProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtTotalProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtTotalProductoActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Menu().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscar;
    private javax.swing.JButton BtBuscarArticulo;
    private javax.swing.JButton BtBuscarCliente;
    private javax.swing.JButton BtBuscarProveedor;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtEditarArticulo;
    private javax.swing.JButton BtEditarCliente;
    private javax.swing.JButton BtEditarProveedor;
    private javax.swing.JButton BtEliminar;
    private javax.swing.JButton BtEliminarArticulo;
    private javax.swing.JButton BtEliminarCliente;
    private javax.swing.JButton BtEliminarProveedor;
    private javax.swing.JButton BtGuardarArticulo;
    private javax.swing.JButton BtGuardarCliente;
    private javax.swing.JButton BtGuardarProveedor;
    private javax.swing.JButton JbGuardar;
    private javax.swing.JTabbedPane Jpanel;
    private javax.swing.JTextField JtCantidadArticulo;
    private javax.swing.JTextField JtCantidadProducto;
    private javax.swing.JTextField JtClave;
    private javax.swing.JTextField JtCodEmpleado;
    private javax.swing.JTextField JtDescripcionArticulo;
    private javax.swing.JTextField JtDireccionCliente;
    private javax.swing.JTextField JtDireccionFactura;
    private javax.swing.JButton JtEmpleados;
    private javax.swing.JTextField JtNitCliente;
    private javax.swing.JTextField JtNitFactura;
    private javax.swing.JTextField JtNombreArticulo;
    private javax.swing.JTextField JtNombreCliente;
    private javax.swing.JTextField JtNombreEmpleado;
    private javax.swing.JTextField JtNombreFactura;
    private javax.swing.JTextField JtNombreProducto;
    private javax.swing.JTextField JtPrecioArticulo;
    private javax.swing.JTextField JtPrecioProducto;
    private javax.swing.JTextField JtProveedorArticulo;
    private javax.swing.JTextField JtPuesto;
    private javax.swing.JTextField JtSalario;
    private javax.swing.JTextField JtTotalProducto;
    private javax.swing.JTextField JtUsuario;
    private javax.swing.JPanel Jtable;
    private javax.swing.JTable JtableArticulos;
    private javax.swing.JTable JtableClientes;
    private javax.swing.JTable JtableEmpleados;
    private javax.swing.JTable JtableFacturas;
    private javax.swing.JTable JtableProveedores;
    private javax.swing.JTextField TfCodProveedor;
    private javax.swing.JTextField TfDireccionProveedor;
    private javax.swing.JTextField TfNitProveedor;
    private javax.swing.JTextField TfNombreProveedor;
    private javax.swing.JTextField TfTelefonoProveedor;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
