package com.ziwu.jvm.method.instruction;

import java.util.Random;

public class Profiteer extends Business {
    @Override
    public double afterDiscount(double oldPrise, Custom custom) {
        if (custom.isVip()) {
            return oldPrise * pitAcquaintance();
        }
        return super.afterDiscount(oldPrise, custom);
    }

    private static double pitAcquaintance() {
        return new Random().nextDouble() + 0.8d;
    }
}
