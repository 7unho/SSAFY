public class SegmentTree_recursive {
    public static class SegmentTree {
        int level = 0;
        int length = 0;
        int[] inputList;
        int inputListLength;
        int inputStartIndex = 0;
        int inputEndIndex = 0;
        int treeIndex = 1;
        String calculationMethod;
        int[] resultList;

        public SegmentTree(int[] inputList, String calculationMethod) {
            this.calculationMethod = calculationMethod;
            this.inputListLength = inputList.length;
            this.inputEndIndex = this.inputStartIndex - 1;
            this.inputList = new int[this.inputListLength];

            for (int i = 0; i < this.inputListLength; i++) {
                this.inputList[i] = inputList[i];
            }

            this.level = (int) Math.ceil(Math.log(this.inputListLength) / Math.log(2)) + 1;
            this.length = (int) Math.pow(2, this.level);
            this.resultList = new int[this.length];

            this.make(0, this.inputListLength - 1, 1);
        }

        public int gcd(int leftResult, int rightResult){
            if(rightResult == 0) return leftResult;

            return this.gcd(rightResult, leftResult % rightResult);
        }

        public int method(int leftResult, int rightResult){
            switch (this.calculationMethod){
                case "sum":
                    return leftResult + rightResult;
                case "max":
                    return Math.max(leftResult, rightResult);
                case "gcd":
                    return this.gcd(leftResult, rightResult);
            }

            return leftResult + rightResult;
        }

        public int updateProcess(int inputStartIndex, int inputEndIndex, int treeIndex, int updateIndex, int updateValue){
            // 구간에 영향을 미치지 않는 경우,
            if(updateIndex < inputStartIndex || updateIndex > inputEndIndex) return this.resultList[treeIndex];

            // 업데이트 하고자 하는 위치에 도달한 경우,
            if(inputStartIndex == inputEndIndex) {
                this.resultList[treeIndex] = updateValue;
                return this.resultList[treeIndex];
            }

            int inputMidIndex = (inputStartIndex + inputEndIndex) / 2;

            int left_result = this.updateProcess(inputStartIndex, inputMidIndex, treeIndex * 2, updateIndex, updateValue);
            int right_result = this.updateProcess(inputMidIndex + 1, inputEndIndex, treeIndex * 2 + 1, updateIndex, updateValue);

            this.resultList[treeIndex] = this.method(left_result, right_result);

            return this.resultList[treeIndex];
        }

        public void update(int updateIndex, int updateValue){
            this.treeIndex = 1;
            this.inputList[updateIndex] = updateValue;

            this.updateProcess(this.inputStartIndex, this.inputEndIndex, this.treeIndex, updateIndex, updateValue);
        }

        public int getRangeProcess(int inputStartIndex, int inputEndIndex, int treeIndex, int rangeStartIndex, int rangeEndIndex){
            if(inputEndIndex < rangeStartIndex || inputStartIndex > rangeEndIndex) return 0;

            if(inputStartIndex >= rangeStartIndex && inputEndIndex <= rangeEndIndex) return this.resultList[treeIndex];

            int inputMidIndex = (inputStartIndex + inputEndIndex) / 2;

            int left_result = this.getRangeProcess(inputStartIndex, inputMidIndex, treeIndex * 2, rangeStartIndex, rangeEndIndex);
            int right_result = this.getRangeProcess(inputMidIndex + 1, inputEndIndex, treeIndex * 2 + 1, rangeStartIndex, rangeEndIndex);

            return this.method(left_result, right_result);

        }
        private int make(int inputStartIndex, int inputEndIndex, int treeIndex) {
            // 1.
            if(inputStartIndex == inputEndIndex) {
                this.resultList[treeIndex] = this.inputList[inputStartIndex];
                return this.resultList[treeIndex];
            }

            // 2.
            int inputMidIndex = (inputStartIndex + inputEndIndex) / 2;

            // 3.
            int left_result = this.make(inputStartIndex, inputMidIndex, treeIndex * 2);
            int right_result = this.make(inputMidIndex + 1, inputEndIndex, treeIndex * 2 + 1);

            // 4.
            this.resultList[treeIndex] = this.method(left_result, right_result);

            // 5.
            return this.resultList[treeIndex];
        }
    }

    public static void main(String[] args) {
        int[] numberList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        SegmentTree segmentTreeSum = new SegmentTree(numberList, "sum");
        // 밑에는 잘 채워봐요
    }
}
