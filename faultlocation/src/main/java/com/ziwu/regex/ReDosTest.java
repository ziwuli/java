package com.ziwu.regex;

import java.io.IOException;

public class ReDosTest {
    public static void main(String[] args) throws IOException {
        java.util.regex.Pattern.compile("(h|h|ih(((i|a|c|c|a|i|i|j|b|a|i|b|a|a|j))+h)ahbfhba|c|i)*").matcher(
                "hchcchicihcchciiicichhcichcihcchiihichiciiiihhcchi" +
                        "cchhcihchcihiihciichhccciccichcichiihcchcihhicchcciicchcccihiiihhihihihi" +
                        "chicihhcciccchihhhcchichchciihiicihciihcccciciccicciiiiiiiiicihhhiiiihchccch" +
                        "chhhhiiihchihcccchhhiiiiiiiicicichicihcciciihichhhhchihciiihhiccccccciciihh" +
                        "ichiccchhicchicihihccichicciihcichccihhiciccccccccichhhhihihhcchchihih" +
                        "iihhihihihicichihiiiihhhhihhhchhichiicihhiiiiihchccccchichci").matches();
    }
}
