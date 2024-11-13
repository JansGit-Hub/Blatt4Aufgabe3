import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableView implements IObserverInterface{
    private IModelInterface m_model;
    private JFrame tableFrame;
    private JPanel panel;
    private JTextField tfRed;
    private JLabel lblRed;
    private JTextField tfGreen;
    private JLabel lblGreen;
    private JTextField tfBlue;
    private JLabel lblBlue;
    private JButton btnSet;

    public TableView(IModelInterface model){
        this.m_model = model;
        createComponents();
        model.registerObserver(this);
    }
    public void createComponents(){
        tableFrame = new JFrame("TableView");
        panel = new JPanel(new GridLayout(4,2));
        tfRed = new JTextField(5);
        lblRed = new JLabel("rot");
        tfGreen = new JTextField(5);
        lblGreen = new JLabel("green");
        tfBlue = new JTextField(5);
        lblBlue = new JLabel("blue");
        btnSet = new JButton("Set");

        btnSet.addActionListener(e ->{
            int r = Integer.parseInt(tfRed.getText());
            int g = Integer.parseInt(tfGreen.getText());
            int b = Integer.parseInt(tfBlue.getText());
            m_model.setRedValue(r);
            m_model.setGreenValue(g);
            m_model.setBlueValue(b);
                });

        panel.add(tfRed);
        panel.add(lblRed);
        panel.add(tfGreen);
        panel.add(lblGreen);
        panel.add(tfBlue);
        panel.add(lblBlue);
        panel.add(btnSet);

        tableFrame.add(panel);
        tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableFrame.setSize(100,100);
        tableFrame.setVisible(true);

    }

    @Override
    public void update() {

    }
}