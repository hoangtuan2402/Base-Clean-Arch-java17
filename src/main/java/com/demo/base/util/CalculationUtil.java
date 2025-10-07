package com.demo.base.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.math.BigDecimal;

@Slf4j
@UtilityClass
public class CalculationUtil {
    public BigDecimal calculate(String formula) {
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
            String result = engine.eval(formula).toString();
            return new BigDecimal(result);
        } catch (Exception ex) {
            log.error("[Calculate][ERROR] An error has occurred when calculate formula: {} error message: ", formula,  ex);
        }
        return BigDecimal.ZERO;
    }

}
