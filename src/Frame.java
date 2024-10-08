import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Frame{

    static private JFrame frame = new JFrame("IPTEST");
    static private JPanel painel = new JPanel();

    static int eixoX = 0,eixoY = 0,lojaAnterior = 0;

    public static void AbrirFrame(){

        painel.setLayout(new GridBagLayout());
        frame.setSize(900,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setBackground(Color.black);


        JScrollPane scrollPane = new JScrollPane(painel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBackground(Color.black);
        painel.setBackground(Color.black);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        //frame.setVisible(true);

    }
    public static void ADDPainel(String loja, JButton box){
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 20, 5, 5);

        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 5;
        c.ipady = 5;

        eixoY++;

        ValidarLoja(Integer.parseInt(loja.substring(5)));

        c.gridy = eixoY;
        c.gridx = eixoX;

        painel.repaint();
        painel.revalidate();
        painel.add(box,c);

    }
    public static void RMVPainel(JButton box){
        frame.remove(box);
    }


    public static void ValidarLoja(int loja){
        if(loja != lojaAnterior){
            eixoX++;
            eixoY = 0;
            lojaAnterior = loja;
        }
    }

    public static void SetVisible(){
        frame.setVisible(true);
    }
}
