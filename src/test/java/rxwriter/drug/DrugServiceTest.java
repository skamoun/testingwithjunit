package rxwriter.drug;

import org.junit.jupiter.api.Test;
import rxwriter.drug.database.DrugRecord;
import rxwriter.drug.database.DrugSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrugServiceTest  implements DrugSource {
@Test
    void drugsAreReturnedSorted(){

        DrugService drugService = new DrugService(this);
        List<DispensableDrug> drugs = drugService.findDrugsStartingWith("as");
        assertNotNull(drugs);
        assertEquals(2,drugs.size());
        assertEquals("asmanex",drugs.get(0).drugName());
        assertEquals("aspirin",drugs.get(1).drugName());
    }
@Test
    void throwsExceptionOnEmptyStartsWith(){
    DrugService drugService = new DrugService(this);

    Exception thrown = assertThrows(IllegalArgumentException.class, () -> drugService.findDrugsStartingWith(""));
    System.out.println(thrown.getMessage());
}

    @Override
    public List<DrugRecord> findDrugsStartingWith(String startingString) {
        List<DrugRecord> records=new ArrayList<>();
        if(startingString.equals("as")){
            records.add(new DrugRecord("aspirin", new int[] {3645, 3530}, 0));
            records.add(new DrugRecord("asmanex", new int[] {301}, 0));
        }
        else if(startingString.equals("aspirin")){
            records.add(new DrugRecord("aspirin", new int[] {3645, 3530}, 0));

        }
        return records;
    }
}