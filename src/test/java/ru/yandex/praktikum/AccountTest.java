package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expected;

    public AccountTest(String name, boolean expected){
        this.name = name;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Тимоти Шаламе", true},  //валидный результат ру
                {"Timoti Shalome", true}, //валидный результат en
                {"Т м",true}, // 3 знака с пробелом
                {"Тим",false}, // 3 знака без пробела
                {"Тимоти Шаламеееееее", true}, //19 знаков
                {"Ти", false}, // 2 знака
                {"Тимотит Шаламеееееее", false}, // 20 знаков
                {" ТимотиШаламе", false},  //пробел в начале
                {"ШаламеПробел ", false}, //пробел в конце
                {"Ти моти Шаламе", false}, //2 пробела
                {"", false} //пусто
        };
    }
    @Test
    public void checkName(){
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(actual, expected);
    }
}