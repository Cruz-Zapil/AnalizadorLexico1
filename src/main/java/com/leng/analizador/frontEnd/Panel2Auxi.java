package com.leng.analizador.frontEnd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import com.leng.analizador.frontEnd.compnents.Item;
import com.leng.analizador.frontEnd.graficos.InicioGrafico;

public class Panel2Auxi extends JPanel {

    public Panel2Auxi() {

        this.setLayout(new BorderLayout());

        // Crear dos JTextAreas

        JComboBox<Item> comboBox = new JComboBox<>(createItems());
        comboBox.setRenderer(new ItemListRenderer());
        comboBox.addActionListener(new ItemSelectionListener(comboBox));
        this.add(comboBox);

        // Agregar el JScrollPane al panel
        this.add(comboBox, BorderLayout.NORTH);
        this.setBounds(50, 30, 500, 370);
        this.setVisible(true);

    }

    private static DefaultComboBoxModel<Item> createItems() {
        DefaultComboBoxModel<Item> model = new DefaultComboBoxModel<>();
        model.addElement(new Item("Mostrar Graficas"));
        model.addElement(new Item("Palabras clave",
                new String[] { "and", "as", "assert", "break", "class", "continue", "def", "elif", "or", "not", "if",
                        "else", "while", "except", "finally", "for", "from", "global", "import", "lambda", "pass",
                        "in", "range", "return", "input", "int", "float", "str",
                        "bool", "True", "False", "None", "is", "nonlocal", "raise", "try", "with", "yield" }));
        model.addElement(new Item("Identificadores", new String[] { "_Mi_Numero", "Identificador","clave_Num" }));
        model.addElement(new Item("Aritmetifcos", new String[] { "+", "-", "**", "/", "%", "*" }));
        model.addElement(new Item("Comparacion", new String[] { "==", "!=", ">", "<", ">=", "<=" }));
        model.addElement(new Item("Logicos", new String[] { "and", "or", "not" }));
        model.addElement(new Item("Asignacion", new String[] { "=", "*=", "-=" }));

        return model;
    }

}

class ItemSelectionListener implements ActionListener {
    private JComboBox<Item> comboBox;

    public ItemSelectionListener(JComboBox<Item> comboBox) {
        this.comboBox = comboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<?> source = (JComboBox<?>) e.getSource();
        Item selected = (Item) source.getSelectedItem();
        if (selected != null && selected.getSubItems().length > 0) {
            JPopupMenu popupMenu = new JPopupMenu();
            for (String subItem : selected.getSubItems()) {
                JMenuItem menuItem = new JMenuItem(subItem);
                menuItem.addActionListener(new SubItemActionListener(subItem)); // Agregar un ActionListener al JMenuItem
                popupMenu.add(menuItem);
            }
            popupMenu.show(source, 0, source.getHeight());
        }
    }
}

class SubItemActionListener implements ActionListener {
    private String subItem;

    public SubItemActionListener(String subItem) {
        this.subItem = subItem;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Realizar la acción deseada con el subítem seleccionado
        // Por ejemplo, mostrar un mensaje
        JOptionPane.showMessageDialog(null, "Has seleccionado: " + subItem);
        new InicioGrafico().insertar(subItem);
    }
}

