package Model.Object;

/**
 * Created by Mr Hung on 2/12/2017.
 */
public interface Subject {
    public void registerObserver(MummyObserver ob);
    public void removeObserver(MummyObserver ob);
    public void notifyObserver();
}
