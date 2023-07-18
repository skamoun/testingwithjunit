package rxwriter.prescription;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DurationUnitTest {

    @Test
    public void matchUnitBySingularString() {
        assertSame(DurationUnit.WEEK, DurationUnit.getByTextValue("week"));
    }

    @Test
    public void matchUnitByPluralString() {
        assertSame(DurationUnit.WEEK, DurationUnit.getByTextValue("weeks"));
    }

@Test
    public void returnNullForUnmatchedUnit(){
        assertNull(DurationUnit.getByTextValue("bob"));
    }



}