package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Alert.UserAlert;
import Screen.CommandHelpScreen;

public class CommandHelpItem extends JMenuItem implements ActionListener {

    public CommandHelpItem() {
        super("Tabela de Comandos");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // try {
        //     new CommandHelpScreen();
        // } catch (Exception e1) {
        //     UserAlert userAlert = new UserAlert("ERRO - Erro ao abrir tabela de comandos"); 
        // }
        new CommandHelpScreen();
    }
}
