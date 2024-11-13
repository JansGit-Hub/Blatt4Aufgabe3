import javax.swing.*;

public class NumberView implements IObserverInterface {
    private IModelInterface m_model;
    private JFrame numberFrame;
    private JPanel numberPanel;

    public NumberView(IModelInterface model) {
        this.m_model = model;
        createElements();
        model.registerObserver(this);
    }

    public void createElements() {
        numberFrame = new JFrame("NumberFrame");
        numberFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        numberFrame.setSize(400, 300);
        numberPanel = new JPanel();
        numberFrame.add(numberPanel);
        numberFrame.setVisible(true);
    }

    private JPanel createNumberPanel(double red, double green, double blue) {
        JPanel panel = new JPanel();
        JLabel lblRed = new JLabel(String.format("Red: %.2f", red));
        JLabel lblGreen = new JLabel(String.format("Green: %.2f", green));
        JLabel lblBlue = new JLabel(String.format("Blue: %.2f", blue));

        panel.add(lblRed);
        panel.add(lblGreen);
        panel.add(lblBlue);

        return panel;
    }

    @Override
    public void update() {
        double red = m_model.getRedPercentage();
        double green = m_model.getGreenPercentage();
        double blue = m_model.getBluePercentage();
        JPanel newPanel = createNumberPanel(red, green, blue);
        numberFrame.getContentPane().removeAll();
        numberFrame.add(newPanel);
        numberFrame.revalidate();
        numberFrame.repaint();
    }
}
