import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.*;

public class Labels implements ActionListener {
    public String ip,loja;
    public volatile JButton box = new JButton();
    public Labels(String ip, String loja){
        this.ip = ip;
        this.loja = loja;
        AlinharTexto();
    }

    public void AlinharTexto() {
        box.setText("<html><div style='text-align: center;'>" + loja + "<br/>IP: " + ip + "</div></html>");
        box.setFont(new Font("Arial", Font.BOLD, 15));
        box.addActionListener(this);
        Frame.ADDPainel(loja,box);
    }

    public void actionPerformed(ActionEvent e) {
        Runtime run = Runtime.getRuntime();
        String cmd = "cmd /c start cmd.exe /c ping " + ip + " -t";
        try {
            run.exec(String.join("& ", cmd));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
