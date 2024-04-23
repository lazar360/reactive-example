import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources

        // Print all numbers in the intNumberStream stream
        System.out.println("Print all numbers in the intNumberStream stream");
        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumberStream that are less than 5
        System.out.println("Print numbers from intNumberStream that are less than 5");
        StreamSources.intNumbersStream().filter(number -> number<5).forEach(System.out::println);

        // Print the second and third numbers in intNumberStream that's greater than 5 // 8 and 10
        System.out.println("Print the second and third numbers in intNumberStream that's greater than 5");
        StreamSources.intNumbersStream()
                .filter(number -> number>5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        // Print the first number in intNumberStream that's greater than 5
        System.out.println("Print the first number in intNumberStream that's greater than 5");
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)  // Check for numbers greater than 5
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println(-1));

        // Print first names of all users in userStream
        System.out.println("Print first names of all users in userStream");
        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));

        // Print first names in userStream for users that have Ids from numberStream
        System.out.println("Print first names in userStream for users that have Ids from numberStream");
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(User::getFirstName)
                .forEach(System.out::println);

        // Print first names in userStream for users that have Ids from numberStream
        System.out.println("Print first names in userStream for users that have Ids from numberStream 2 ");
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(i -> i == user.getId()))
                .map(User::getFirstName)
                .forEach(System.out::println);







    }
}
