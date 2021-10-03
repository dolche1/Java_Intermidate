package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerEx {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();
        List<Action> friend1List = new ArrayList<>();

        friend1List.add(Action.NOJNICI);
        friend1List.add(Action.BUMAGA);
        friend1List.add(Action.NOJNICI);

        List<Action> friend2List = new ArrayList<>();

        friend2List.add(Action.BUMAGA);
        friend2List.add(Action.KAMEN);
        friend2List.add(Action.KAMEN);

        BestFriend bestFriend1 = new BestFriend("Vanya", friend1List, exchanger);
        BestFriend bestFriend2 = new BestFriend("Sergey", friend2List, exchanger);



    }
}
enum Action{
    KAMEN, NOJNICI, BUMAGA;
}

class BestFriend extends Thread {
    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger;

    public BestFriend(String name, List<Action> myActions, Exchanger<Action> exchanger) {
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
        this.start();
    }

    private void whoWins(Action myAction, Action friendsAction) {
        if ((myAction == Action.BUMAGA) && (friendsAction == Action.KAMEN) ||
                (myAction == Action.KAMEN && friendsAction == Action.NOJNICI) ||
                (myAction == Action.NOJNICI && friendsAction == Action.BUMAGA)) {
            System.out.println(name + " wins");
        }
    }

    @Override
    public void run() {
        Action reply;
        for (Action action : myActions) {

            try {
              reply = exchanger.exchange(action);
              whoWins(action, reply);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

