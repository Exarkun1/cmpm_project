package com.propcool.cmpm_project.analysing.build;

import com.propcool.cmpm_project.functions.Function;
/**
 * Интерфейс для создания функции по её началу, концу и знаку между ними
 * */
public interface FunctionFactory {
    Function createFunction(String begin, String end, char symbol);
}
