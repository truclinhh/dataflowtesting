import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {
    @ParameterizedTest
    @CsvFileSource(resources = "/testcases.csv")
    void test(int a, int b, int result){
        Student Stu = new Student();
        assertEquals(Stu.validate(a,b),result);
    }
}
