package befaster.solutions.HLO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloSolutionTest {
    @Test
    public void testHello(){
        HelloSolution helloWorld = new HelloSolution();
        assertEquals("Hello, Craftsman!", helloWorld.hello("Craftsman!"));
        assertEquals("Hello, Mr. X!", helloWorld.hello("Mr. X!"));
    }

}