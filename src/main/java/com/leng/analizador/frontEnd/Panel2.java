package com.leng.analizador.frontEnd;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;

import com.leng.analizador.frontEnd.compnents.ConstructorPanel;
import com.leng.analizador.frontEnd.compnents.Item;

public class Panel2 extends ConstructorPanel {

    //// paneles de imagenes
    private Panel2Auxi panel2Auxi;

    public Panel2() {
        super(new Color(245, 245, 220));

        panel2Auxi = new Panel2Auxi();
        this.add(panel2Auxi);

    }

    


}

class ItemListRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
            boolean cellHasFocus) {
        if (value instanceof Item) {
            Item item = (Item) value;
            value = item.getLabel();
        }
        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    }

}
