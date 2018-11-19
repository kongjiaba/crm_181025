import org.apache.commons.lang3.StringUtils;

/**
 * @author WJUN
 * @create 2018/10/26 17:50
 * StringUtils是apache提供的一个工具类
 * 在commons-langs的jar包中
 * 该类是apache提供的一个对String操作的类
 */
public class StringUtilsTest {
    public static void main(String[] args){
           String str1 = null;
           String str2 = "";
           String str3 = " ";
           System.out.println(StringUtils.isEmpty(str1));//true
           System.out.println(StringUtils.isEmpty(str2));//true
           System.out.println(StringUtils.isEmpty(str3));//false
            System.out.println("----------------");
           System.out.println(StringUtils.isBlank(str1));//true
           System.out.println(StringUtils.isBlank(str2));//true
           System.out.println(StringUtils.isBlank(str3));//true
    }
}
