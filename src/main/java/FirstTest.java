import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void firstTest01(){

        Assert.assertTrue(6<8);


    }

    @Test
    public void firstTest02(){

        Assert.assertTrue(3<4 , "test fail");

    }

    @Test
    public void firstTest03(){

        Assert.assertEquals("3","3","sayilar esit degil");

    }


}