package ru.yandex.praktikum;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
            if (name == null || name.isEmpty())
                return false;
            if (name.length() < 2)
                return false;
            if (name.length() > 19)
                return false;
            if (name.startsWith(" ") || name.endsWith(" "))
                return false;
            if (name.split(" ").length != 2)
                return false;
        return true;
    }
}