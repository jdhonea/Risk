import java.util.Observable;

public class playerNotification extends Observable {

    public void notify(int ownedBy){
        setChanged();
        notifyObservers(ownedBy);
    }
}
