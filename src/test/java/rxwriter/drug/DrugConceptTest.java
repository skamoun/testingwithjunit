package rxwriter.drug;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrugConceptTest {


    public final static DrugConcept OPIATES_TEST = new DrugConcept(new DrugClassification[]{
            DrugClassification.ANTIANXIETY,
            DrugClassification.ANALGESICS_NARCOTIC,
            DrugClassification.NARCOTIC_ANTIHISTAMINE});
@Test
    void drugBelongsInConceptIfOneClassMatches(){
   DispensableDrug dispensableDrug = new DispensableDrug("adrug",
           new DrugClassification[]{DrugClassification.ANALGESIC,DrugClassification.ANTIANXIETY},false);
        assertTrue(OPIATES_TEST.isDrugInConcept(dispensableDrug));
    }
    @Test
    void drugNotInConceptIfNoClassMatches(){
        DispensableDrug dispensableDrug = new DispensableDrug("adrug",
                new DrugClassification[]{DrugClassification.ANALGESIC,DrugClassification.ANTIFUNGAL},false);
        assertFalse(OPIATES_TEST.isDrugInConcept(dispensableDrug));
    }
}