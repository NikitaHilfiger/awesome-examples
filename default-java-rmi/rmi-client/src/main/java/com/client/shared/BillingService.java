package main.java.com.client.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*

Your remote interface must extend Remote.

Your remote object must implement your remote interface.
It can either extend UnicastRemoteObject or be exported manually by calling UnicastRemoteObject.exportObject().

*/
public interface BillingService extends Remote {
    // Регистрация новой карты
    public void addNewCard(Card card) throws RemoteException;

    // Добавление денежных средств на карту
    public void addMoney(Card card, double money) throws RemoteException;

    // Снятие денежных средств с карты
    public void subMoney(Card card, double money) throws RemoteException;

    // Получение баланса карты
    public double getCardBalance(Card card) throws RemoteException;
}
