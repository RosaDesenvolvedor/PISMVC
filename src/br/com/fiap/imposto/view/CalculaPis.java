package br.com.fiap.imposto.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

public class CalculaPis implements Observer, TelaDeImposto {

    private TextField txtValorFaturado;
    private Button btnCalcular;

    //Construtor que compõe a tela

    public CalculaPis() {
        System.out.println("Construtor da View chamado");

        // O frame é uma subclasse de window que estende Container
        // Essa hierarquia de classes utiliza o padrão Composite
        // Para compor a tela, veja os métodos .add

        Frame frame =
                new Frame("Cálculo do PIS MVC e Design Patterns");
        frame.add("North", new Label("Valor Faturado"));

        txtValorFaturado = new TextField();
        frame.add("Center",txtValorFaturado);

        Panel panel = new Panel();
        btnCalcular = new Button("Calcular PIS");
        panel.add(btnCalcular);
        frame.add("South", panel);

        frame.addWindowListener(new CloseListener());
        frame.setSize(200,150);
        frame.setLocation(100,100);
        frame.setVisible(true);
    }

        //Método que retorna o valor para o cálculo de imposto
    @Override
    public float getValor() {
        return Float.parseFloat(txtValorFaturado.getText());
    }

    //Método que possibilita a view enviar a ação de calcular
    //Para o controller chamar o Model

    public void addController(ActionListener controller){
        System.out.println("A view adicionou o Controller");
        btnCalcular.addActionListener(controller);
    }
    // Update exibe uma mensagem na view contendo:
    // a classe model
    // o ToString sobrescrito
    // O valor do estado, atribuido valorDoPis da classe Pis

    //O método update será chamado pelo Model por notifyObservers
    @Override
    public void update(Observable objModel, Object estadoDoModel)
    {
        String msg = objModel.getClass() + "" + objModel.toString() +""+ ((Float)estadoDoModel).floatValue();
        JOptionPane.showMessageDialog(null, msg);
    }

    //Encerra o programa
    public static class CloseListener extends WindowAdapter{

        public void windowClosing(WindowEvent e){
            e.getWindow().setVisible(false);
            System.exit(0);
        }
    }

}
