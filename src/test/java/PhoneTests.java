import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PhoneTests {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("I'm in before suite phase");
    }

    @Test
    public void test001() {
        Phone myPhone01;
        myPhone01 = new Phone();
        Phone myPhone02 = new Phone("Samsung", 16, 780);
    }

    @Test
    public void test002() {
        String color = "white";
        Phone myNewPhone001 = new Phone("iPhone", color, 16);
        myNewPhone001.call("34234123412");
        myNewPhone001.sendMessage();
    }

    @Test
    public void testNameGetter() {
        Phone myNewPhone001 = new Phone("iPhone", "blue", 16);
        Assert.assertEquals(myNewPhone001.getModel(), "iPhone");
    }

    //TODO: create your own class and tests for it
}
