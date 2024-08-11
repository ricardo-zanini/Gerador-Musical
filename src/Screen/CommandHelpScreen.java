package Screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;
import javax.swing.table.DefaultTableCellRenderer;

public class CommandHelpScreen extends Screen{

    private JTable table;
    private static final String[] COLUMN_NAMES = {"Comando", "Informação Musical ou Ação"};
    private static final Object[][] DATA = {
        {"A ou a", "Nota Lá"},
        {"B ou b", "Nota Si"},
        {"C ou c", "Nota Dó"},
        {"D ou d", "Nota Ré"},
        {"E ou e", "Nota Mi"},
        {"F ou f", "Nota Fá"},
        {"G ou g", "Nota Sol"},
        {"Espaço", "Silêncio ou pausa"},
        {"+", "Aumenta volume em dobro"},
        {"-", "Reseta volume"},
        {"O, o, I, i, U ou u", "Repete nota anterior; se não for nota, faz um som de Telefone tocando"},
        {"R+", "Aumenta em UMA oitava"},
        {"R-", "Diminui em UMA oitava"},
        {"?", "Toca uma nota aleatória"},
        {"Nova Linha", "Troca instrumento para um novo aleatório"},
        {"BPM+", "Aumenta BPM em 80 unidades"},
        {";", "BPM aleatório"},
        {"Outro", "Passa para o próximo caractere"},
    };
    private JScrollPane tableScroll;

    public CommandHelpScreen() {
        super("Tabela de Comandos");

        createComponents();
        configComponents();
        addComponents();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public void createComponents() {
        setTitle("Tabela de Comandos");
        setTable(new JTable(DATA, COLUMN_NAMES));
        setTableScroll(new JScrollPane(getTable()));
    }

    public void configComponents() {

        getTableScroll().setBounds(30,20,520,422);

        getTable().getTableHeader().setFont(new Font(null, Font.BOLD, 14));
        getTable().getTableHeader().setBackground(new Color(216, 225, 240));
        getTable().getTableHeader().setReorderingAllowed(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        getTable().getColumnModel().getColumn(0).setPreferredWidth(100);
        getTable().getColumnModel().getColumn(1).setPreferredWidth(400);
        getTable().getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        getTable().getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        getTable().setEnabled(false);
        getTable().setRowHeight(22);

    }

    public void addComponents() {
        this.add(getTableScroll());
    }

    public JTable getTable() {
        return table;
    }
    public void setTable(JTable table) {
        this.table = table;
    }

    public JScrollPane getTableScroll() {
        return tableScroll;
    }
    public void setTableScroll(JScrollPane tableScroll) {
        this.tableScroll = tableScroll;
    }

}
