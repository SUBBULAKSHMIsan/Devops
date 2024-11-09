package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ExpressionEvaluatorTest {

    @Test
    public void testEvaluatePostfix() {
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        
        assertEquals(4, evaluator.evaluatePostfix("231*+9-"));
        assertEquals(14, evaluator.evaluatePostfix("512+4*+3-"));
        assertEquals(9, evaluator.evaluatePostfix("34+5*"));
    }
}
