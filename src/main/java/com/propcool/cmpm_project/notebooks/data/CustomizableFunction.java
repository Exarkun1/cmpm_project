package com.propcool.cmpm_project.notebooks.data;

import com.propcool.cmpm_project.functions.Function;
import javafx.scene.paint.Color;

import java.util.List;
/**
 * Класс хранящий всю необходимую информацию о функциях
 * */
public class CustomizableFunction {
    public CustomizableFunction(Function function, List<String> params){
        this.function = function;
        this.params = params;
    }
    public Function getFunction() {
        return function;
    }
    public List<String> getParams() {
        return params;
    }
    public String getExpression() {
        return functionData.getExpression();
    }

    public void setExpression(String expression) {
        functionData.setExpression(expression);
    }

    public Color getColor() {
        return Color.valueOf(functionData.getColor());
    }

    public void setColor(Color color) {
        functionData.setColor(color.toString());
    }

    public int getWidth() { return functionData.getWidth(); }

    public void setWidth(int width) { functionData.setWidth(width);}

    public FunctionData getData() { return functionData;}
    private final Function function;
    private final List<String> params;
    private final FunctionData functionData = new FunctionData();
}
