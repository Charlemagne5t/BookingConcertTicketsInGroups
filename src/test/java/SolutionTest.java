import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        BookMyShow bookMyShow = new BookMyShow(19,37);
        Assert.assertArrayEquals(bookMyShow.gather(28,8), new int[]{0,0});
        Assert.assertTrue(bookMyShow.scatter(10, 15));
        Assert.assertArrayEquals(bookMyShow.gather(47,16), new int[]{});
        Assert.assertTrue(bookMyShow.scatter(45, 8));
        Assert.assertTrue(bookMyShow.scatter(34, 8));
        Assert.assertTrue(bookMyShow.scatter(28, 7));
    }
}
