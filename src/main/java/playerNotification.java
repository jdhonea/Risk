import java.util.Observable;

//Observable is not serializable so the notify functionality needed to be implemented in a separate class to keep from breaking our undo feature.
//When the player attacks, it will send the defending player's ID# here which will then notify all the observers and pass them the ID#

/**
 * Notifies the players watching when a player makes an attack.
 */
public class playerNotification extends Observable {
    /**
     * Notifies the watching players that a player has attacked.
     * @param ownedBy   the player number of the player being attacked
     */
    public void notify(int ownedBy){
        setChanged();
        notifyObservers(ownedBy);
    }
}
