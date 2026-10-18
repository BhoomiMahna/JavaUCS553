import java.util.*;

class Subject {
    String subjectId;
    int maxSeats;
    HashSet<String> studentSet;
    ArrayList<String> requiredSubjects;
    LinkedList<String> pendingStudents;

    Subject(String id, int seats, ArrayList<String> required) {
        subjectId = id;
        maxSeats = seats;
        requiredSubjects = required;
        studentSet = new HashSet<>();
        pendingStudents = new LinkedList<>();
    }
}

public class Main {
    static HashMap<String, Subject> subjectMap = new HashMap<>();
    static HashMap<String, HashSet<String>> academicRecords = new HashMap<>();

    static void createSubject(String id, int seats, ArrayList<String> required) {
        subjectMap.put(id, new Subject(id, seats, required));
    }

    static void enrollStudent(String rollNo, String id) {
        Subject sub = subjectMap.get(id);

        if (sub == null) {
            System.out.println("Subject unavailable");
            return;
        }

        if (sub.studentSet.contains(rollNo)) {
            System.out.println("Already enrolled");
            return;
        }

        HashSet<String> passed = academicRecords.getOrDefault(
            rollNo, new HashSet<>()
        );

        if (!passed.containsAll(sub.requiredSubjects)) {
            System.out.println("Complete prerequisites first");
            return;
        }

        if (sub.studentSet.size() < sub.maxSeats) {
            sub.studentSet.add(rollNo);
            System.out.println("Enrollment successful");
        } else {
            if (!sub.pendingStudents.contains(rollNo)) {
                sub.pendingStudents.offer(rollNo);
                System.out.println("Added to waiting queue");
            }
        }
    }

    static void markCompleted(String rollNo, String id) {
        academicRecords.computeIfAbsent(
            rollNo, key -> new HashSet<>()
        ).add(id);
    }

    static void withdrawStudent(String rollNo, String id) {
        Subject sub = subjectMap.get(id);

        if (sub == null) {
            System.out.println("Subject unavailable");
            return;
        }

        if (sub.studentSet.remove(rollNo)) {
            System.out.println("Enrollment cancelled");
            fillVacancy(sub);
        } else if (sub.pendingStudents.remove(rollNo)) {
            System.out.println("Removed from waiting queue");
        } else {
            System.out.println("Student not found");
        }
    }

    static void fillVacancy(Subject sub) {
        while (sub.studentSet.size() < sub.maxSeats
                && !sub.pendingStudents.isEmpty()) {
            String nextRoll = sub.pendingStudents.poll();

            HashSet<String> passed = academicRecords.getOrDefault(
                nextRoll, new HashSet<>()
            );

            if (passed.containsAll(sub.requiredSubjects)) {
                sub.studentSet.add(nextRoll);
                System.out.println(nextRoll + " enrolled in " + sub.subjectId);
            }
        }
    }

    static void showDetails(String id) {
        Subject sub = subjectMap.get(id);

        if (sub == null) {
            System.out.println("Subject unavailable");
            return;
        }

        System.out.println("Subject ID: " + sub.subjectId);
        System.out.println("Enrolled Students: " + sub.studentSet);
        System.out.println("Waiting Students: " + sub.pendingStudents);
    }

    public static void main(String[] args) {
        createSubject("IT101", 2, new ArrayList<>());
        createSubject("IT202", 1, new ArrayList<>(Arrays.asList("IT101")));

        markCompleted("R01", "IT101");
        markCompleted("R02", "IT101");
        markCompleted("R03", "IT101");

        enrollStudent("R01", "IT202");
        enrollStudent("R02", "IT202");
        enrollStudent("R03", "IT202");

        showDetails("IT202");

        withdrawStudent("R01", "IT202");

        showDetails("IT202");
    }
}