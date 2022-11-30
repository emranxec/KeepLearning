package programs;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptEngineManagerExp {

    public static void main(String[] args) throws ScriptException {
        String exp ="X+Y-5";
        int x=10;
        int y=5;
        exp = exp.replace("X","10");
        exp =exp.replace("Y","5");
        ScriptEngineManager s=new ScriptEngineManager();
        ScriptEngine se=s.getEngineByName("JavaScript");
        Integer result=(Integer)se.eval(exp);
        System.out.println(result);
    }
}
