import javax.swing.*;
import java.awt.*;

public class BarChartView implements IObserverInterface {
    IModelInterface m_model;
    JFrame m_viewFrame;
    JPanel m_viewPanel;

    public BarChartView(IModelInterface model) {
        this.m_model = model;
        createElements();
        model.registerObserver(this);
    }

    public void createElements() {
        m_viewFrame = new JFrame("BarChartView");
        m_viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_viewFrame.setSize(400, 300);
        m_viewFrame.setVisible(true);
    }

    @Override
    public void update() {
        double red = m_model.getRedPercentage();
        double green = m_model.getGreenPercentage();
        double blue = m_model.getBluePercentage();
        m_viewPanel = createChartPanel(red, green, blue);
        if (m_viewPanel != null) {
            m_viewFrame.getContentPane().removeAll();
            m_viewFrame.add(m_viewPanel);
            m_viewFrame.revalidate();
            m_viewFrame.repaint();
        }
    }

    private JPanel createChartPanel(double red, double green, double blue) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int width = getWidth();
                int height = getHeight();
                int barWidth = width / 3;

                g.setColor(Color.RED);
                g.fillRect(0, height - (int) (height * red), barWidth, (int) (height * red));

                g.setColor(Color.GREEN);
                g.fillRect(barWidth, height - (int) (height * green), barWidth, (int) (height * green));

                g.setColor(Color.BLUE);
                g.fillRect(2 * barWidth, height - (int) (height * blue), barWidth, (int) (height * blue));
            }
        };
        return panel;
    }
}
