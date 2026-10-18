import java.util.Optional;

public class ques2 {
    public static void main(String[] args) {
        Optional<String> email = Optional.of("student@gmail.com");
        Optional<String> emptyEmail = Optional.empty();

        email.ifPresent(value -> System.out.println("Email is " + value));

        String defaultEmail = emptyEmail.orElse("default@gmail.com");
        System.out.println("Default email is " + defaultEmail);

        try {
            String address = emptyEmail.orElseThrow(
                () -> new RuntimeException("Email address is missing")
            );
            System.out.println(address);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}