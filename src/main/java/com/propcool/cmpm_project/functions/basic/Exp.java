package com.propcool.cmpm_project.functions.basic;

import com.propcool.cmpm_project.functions.Function;
import com.propcool.cmpm_project.functions.combination.Exponential;

public class Exp extends Exponential {
    public Exp(double number, Function f) {
        super(new Constant(number), f);
    }
    public Exp(Function f) {
        this(Math.E, f);
    }
    public Exp() {
        this(new Variable());
    }
    public Exp(double number){this(number, new Variable());}
}
