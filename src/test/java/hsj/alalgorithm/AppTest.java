package hsj.alalgorithm;
import com.hsj.dataStructure.Trie.Trie;
import com.hsj.dataStructure.realizationmap.BSTMap;
import com.hsj.dataStructure.string.MyString;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IllegalAccessException {
        MyString<String> str = new MyString<>();
        str.addLast("shj");
        str.addLast("sasd");
        str.addLast("wqee");
        str.add("huangshijie", 1);
        System.out.println(str.toString());
    }
}
