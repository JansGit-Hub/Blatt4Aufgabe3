import java.util.ArrayList;

public class DataModel implements IModelInterface{
    private int m_redValue = 0;
    private int m_greenValue = 0;
    private int m_blueValue = 0;
    private ArrayList<IObserverInterface> m_observers = new ArrayList<IObserverInterface>();
    @Override
    public double getRedPercentage() {
        double total = m_redValue + m_greenValue + m_blueValue;
        if (total>0){
            return m_redValue / total;
        }
        return 0;
    }

    @Override
    public double getGreenPercentage() {
        double total = m_redValue + m_greenValue + m_blueValue;
        if (total>0){
            return m_greenValue / total;
        }
        return 0;
    }

    @Override
    public double getBluePercentage() {
        double total = m_redValue + m_greenValue + m_blueValue;
        if (total>0){
            return m_blueValue / total;
        }
        return 0;
    }

    @Override
    public void setRedValue(int value) {
        m_redValue = value;
        notifyObservers();
    }

    @Override
    public void setBlueValue(int value) {
        m_blueValue = value;
        notifyObservers();
    }

    @Override
    public void setGreenValue(int value) {
        m_greenValue = value;
        notifyObservers();
    }

    @Override
    public void registerObserver(IObserverInterface o) {
        m_observers.add(o);
    }

    @Override
    public void removeObserver(IObserverInterface o) {
        if(m_observers.contains(o))
            m_observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(int i = 0; i < m_observers.size(); ++i){
            m_observers.get(i).update();
        }
    }
}