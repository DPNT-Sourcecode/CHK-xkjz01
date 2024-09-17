package befaster.solutions.SUM;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumSolutionTest {
    private SumSolution sum;

    @BeforeEach
    public void setUp() {
        sum = new SumSolution();
    }

    @Test
    public void compute_sum() {
        assertEquals(3, sum.compute(1,2));
        assertEquals(7, sum.compute(3,4));
        assertEquals(10, sum.compute(3,4));
        assertEquals(10,sum.compute(6,4));
        assertEquals(0, sum.compute(0,0));
        assertThat(sum.compute(1, 1), equalTo(2));
    }
}


