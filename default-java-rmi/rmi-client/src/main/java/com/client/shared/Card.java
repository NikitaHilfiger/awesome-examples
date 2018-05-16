package main.java.com.client.shared;

import java.io.Serializable;

//Serializable для возможности преобразования объекта в последовательность байт и обратно
public class Card implements Serializable {

    private static long SERIAL_VERSION_UID = 1L;

    private String name;

    private String number;

    private double money;

    public static long getSerialVersionUid() {
        return SERIAL_VERSION_UID;
    }

    public static void setSerialVersionUid(long serialVersionUid) {
        SERIAL_VERSION_UID = serialVersionUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Card(String name, String number, double money) {
        super();
        this.name = name;
        this.number = number;
        this.money = money;

    }

    @Override
    public boolean equals(Object o) {
        return this.getNumber().equals(
                ((Card) o).getNumber()
        );
    }
}
