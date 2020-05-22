package app;

import model.ModelTest;
import org.junit.BeforeClass;
import org.junit.Test;
import simonadimitrova.electricitycompany.app.ElectricityApplication;

public class AppTest {
    @BeforeClass
    public static void fillDataBase() {
        ModelTest.fillDatabase();
    }

    @Test
    public void runApp() {
        ElectricityApplication.launch(ElectricityApplication.class);
    }
}
