/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Compras;
import modelDominio.Sugestao;

/**
 *
 * @author Kauany
 */
public class SugestaoTableModel extends AbstractTableModel{

    private ArrayList<Sugestao> listaSugestao;

    public SugestaoTableModel(ArrayList<Sugestao> listaSugestao) {
        this.listaSugestao = listaSugestao;
    }
    
     @Override
    public int getRowCount() {
        return listaSugestao.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sugestao sugestao = listaSugestao.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return sugestao.getCodsugestao();
            case 1:
                return sugestao.getDescricao();
            case 2:
                return sugestao.getUsuario().getNomeusuario();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Código da sugestão";
            case 1:
                return "Sugestão";
            case 2:
                return "Nome do usuário";
            default:
                return "NoName";
        }
    }

    public Sugestao getSugestao(int row) {
        return listaSugestao.get(row);
    }
     
    
}
