public class ques1 {
    static <T extends Number> double calculateSum(T[] values) {
        double total = 0;

        for (T value : values) {
            total += value.doubleValue();
        }

        return total;
    }

    public static void main(String[] args) {
        Integer[] nums1 = {10, 20, 30, 40};
        Float[] nums2 = {1.5f, 2.5f, 3.5f};
        Double[] nums3 = {2.5, 4.5, 6.5};

        System.out.println("Integer sum is " + calculateSum(nums1));
        System.out.println("Float sum is " + calculateSum(nums2));
        System.out.println("Double sum is " + calculateSum(nums3));
    }
}