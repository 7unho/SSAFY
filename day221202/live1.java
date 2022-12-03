import java.util.ArrayList;

public class live1 {
    public static int splitAndSum(String text) {
        // text가 널이거나 비어있다면 리턴
        if (isEmpty(text)) return 0;

        return getSum(toInts(text.split("-")));
    }

    private static int getSum(ArrayList<Integer> ints) {
        int result = 0;
        for(Integer value: ints) result += value;
        return result;
    }

    private static ArrayList<Integer> toInts(String[] values) {
        ArrayList<Integer> ints = new ArrayList<Integer>();
        for(String value: values) ints.add(Integer.parseInt(value));
        return ints;
    }

    private static boolean isEmpty(String text) {
        return (text == null || text.isEmpty()) ? true : false;
    }

    public static void main(String[] args) {
        // 스플릿 한 요소들을 더하기
        System.out.println(splitAndSum("11-22-33"));
    }

}