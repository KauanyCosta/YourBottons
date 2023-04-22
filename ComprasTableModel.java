/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Compras;

/**
 *
 * @author Kauany
 */
public class ComprasTableModel extends AbstractTableModel {

    private ArrayList<Compras> listaCompras;

    public ComprasTableModel(ArrayList<Compras> listaCompras) {
        this.listaCompras = listaCompras;
    }

    @Override
    public int getRowCount() {
        return listaCompras.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Compras compra = listaCompras.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return compra.getBottons().getNome();
            case 1:
                return compra.getCodcompra();

            case 2:
                return compra.getValorcompra();

            case 3:
                return compra.getCodUsuario();

            case 4:
                return compra.getQuantidade();

            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Bottom";
            case 1:
                return "Código da Compra";

            case 2:
                return "Valor";

            case 3:
                return "Código do usuário";

            case 4:
                return "Quantidade";
            default:
                return "NoName";
        }
    }

    public Compras getCompras(int row) {
        return listaCompras.get(row);
    }
}
