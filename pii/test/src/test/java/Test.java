import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String pattern = "^(啊啊啊|不不不|dfdf){1}-(行驶证|发动机){1}：(\\w)+(-([0-9]{1,2})){0,1}$";

        System.out.println(Pattern.matches(pattern,"不不不-发动机：ss"));
    }
}
