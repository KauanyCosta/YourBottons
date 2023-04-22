/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Bottons;

/**
 *
 * @author Kauany
 */
public class BottonsTableModel extends AbstractTableModel {

    private ArrayList<Bottons> listaBottons;
    

    public BottonsTableModel(ArrayList<Bottons> listaBottons) {
        this.listaBottons = listaBottons;
    }

    @Override
    public int getRowCount() {
        return listaBottons.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bottons bottom = listaBottons.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return bottom.getNome();
            case 1:
                return bottom.getDescricao();
            case 2:
                return bottom.getValor();
            case 3:
                return bottom.getDataLancamentoString();
            case 4:
                return bottom.getQuantEstoque();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nome:";
            case 1:
                return "Personalização";
            case 2:
                return "Valor";
            case 3:
                return "Data de Lançamento";
            case 4:
                return "Quantidade Estoque";
            default:
                return "NoName";

        }
    }

    public Bottons getBottons(int row) {
        return listaBottons.get(row);
    }

}
