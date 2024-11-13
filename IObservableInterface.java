public interface IObservableInterface {
    public void registerObserver(IObserverInterface o);
    public void removeObserver(IObserverInterface o);
    public void notifyObservers();
}
