package main.java.com.server;

import main.java.com.server.shared.BillingService;
import main.java.com.server.shared.Card;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BillingServiceImpl extends UnicastRemoteObject implements BillingService {

    private static final long serialVersionUID = 1L;

    private List<Card> cards;

    // инициализация сервера
    public BillingServiceImpl() throws RemoteException {
        super();
        cards = new ArrayList<>();
    }

    @Override
    public void addNewCard(Card card) throws RemoteException {
        cards.add(card);
        System.out.println("register card : " + card.getNumber());
    }

    @Override
    public void addMoney(Card card, double money) throws RemoteException {
        for (Card crd : cards) {
            if (crd.equals(card)) {
                crd.setMoney(crd.getMoney() + money);
                System.out.println("add money : "
                        + "card " + card.getNumber()
                        + ", summa = " + money);
                break;
            }
        }
    }

    @Override
    public void subMoney(Card card, double money) throws RemoteException {
        for (Card crd : cards) {
            if (crd.equals(card)) {
                crd.setMoney(crd.getMoney() - money);
                System.out.println(
                        "sub money : "
                        + "card : " + card.getNumber()
                        + ", summa = " + money
                );
                break;
            }
        }
    }

    @Override
    public double getCardBalance(Card card) throws RemoteException {
        double balance = 0;
        for (Card crd : cards) {
            if (crd.equals(card)) {
                balance = crd.getMoney();
                System.out.println("balance : "
                        + "card : " + card.getNumber()
                        + ", summa = " + balance);
                break;
            }
        }
        return balance;
    }

    /**
     * Старт registry и запуск удаленного RMI объекта BillingService
     */
    public static void main (String[] args) throws Exception {
        String localhost    = "http://127.0.1.1";
        String RMI_HOSTNAME = "java.rmi.server.hostname";

        try {
            System.setProperty(RMI_HOSTNAME, localhost);
            System.setProperty("java.security.policy", ".java.policy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }

//            System.setProperty(RMI_HOSTNAME, localhost);
            // Создание удаленного RMI объекта
            BillingService service = new BillingServiceImpl();  

            // Определение имени удаленного RMI объекта
            String serviceName = "BillingService";

            System.out.println("Initializing " + serviceName);

            Registry registry = LocateRegistry.createRegistry(1099);

            /*
             * Регистрация удаленного RMI объекта BillingService
             * в реестре rmiregistry
             */
            registry.rebind(serviceName, service);
            System.out.println("Start " + serviceName);
        } catch (RemoteException e) {
            System.err.println("RemoteException : "+e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Exception : " + e.getMessage());
            System.exit(2);
        }
    }
}
