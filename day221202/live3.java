public class live3 {
    static class Operator {
        private int idx;
        private int cnt = 0;

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) {

        //25+61=100
        //1 ~ 5자리수 덧셈 수식이 맞는지 확인하는 프로그램
        //띄어쓰기 없음
//        String str = "25+61=86"; //PASS
//        String str = "12345+12345=24690"; //PASS
        String str = "5++5=10"; //ERROR
//        String str = "10000+1=10002"; //FAIL

//        System.out.println(Arrays.toString(str.split("\\+|=")));
        System.out.println(isValid(str));
    }

    private static String isValid(String str) {

        Operator plus = new Operator();
        Operator equal = new Operator();

        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9') && str.charAt(i) != '+' && str.charAt(i) != '=') return "ERROR";
            // +라면 cnt1 증가
            if (str.charAt(i) == '+') {
                plus.setCnt(plus.getCnt() + 1);
                plus.setIdx(i);
                continue;
            }

            if (str.charAt(i) == '=') {
                equal.setCnt(equal.getCnt() + 1);
                equal.setIdx(i);
                continue;
            }
        }

        if(plus.getCnt() != 1 || equal.getCnt() != 1 || plus.getIdx() >= equal.getIdx()) return "ERROR";
        if(plus.getIdx() < 1 || equal.getIdx() < 3 || equal.getIdx() >= str.length() - 1) return "ERROR";
        return getValueCheck(str.split("\\+|="));
    }

    private static String getValueCheck(String[] numbers) {
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        int result = Integer.parseInt(numbers[2]);

        if(num1 + num2 != result) return "FAIL";
        return "PASS";
    }
}



