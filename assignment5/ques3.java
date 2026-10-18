import java.util.Objects;
import java.util.Optional;

class Result<T extends Number> {
    private T marks;
    private double maximumMarks;

    Result(T marks, double maximumMarks) {
        this.marks = Objects.requireNonNull(marks, "Marks cannot be null");
        this.maximumMarks = maximumMarks;

        if (maximumMarks <= 0) {
            throw new IllegalArgumentException("Maximum marks must be positive");
        }
    }

    double getPercentage() {
        return marks.doubleValue() / maximumMarks * 100;
    }

    double getAverage() {
        return marks.doubleValue();
    }

    boolean hasPassed(double threshold) {
        return getPercentage() >= threshold;
    }

    Optional<T> getMarks() {
        return Optional.ofNullable(marks);
    }
}

public class ques3 {
    public static void main(String[] args) {
        Result<Integer> student1 = new Result<>(85, 100);
        Result<Double> student2 = new Result<>(42.5, 50);

        student1.getMarks().ifPresent(m -> {
            System.out.println("Marks are " + m);
            System.out.println("Percentage is  " + student1.getPercentage());
            System.out.println("Average is " + student1.getAverage());
            System.out.println("Passed? " + student1.hasPassed(40));
        });

        student2.getMarks().ifPresent(m -> {
            System.out.println("Marks are " + m);
            System.out.println("Percentage is  " + student2.getPercentage());
            System.out.println("Average is " + student2.getAverage());
            System.out.println("Passed ? " + student2.hasPassed(40));
        });
    }
}