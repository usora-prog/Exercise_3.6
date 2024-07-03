import java.util.Scanner;
import java.util.List;
import java.util.HashMap;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, List<User>> userMap = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя " + (i + 1));
            String name = in.nextLine();
            System.out.println("Введите возраст пользователя " + (i + 1));
            int age = Integer.parseInt(in.nextLine());

            User user = new User(name, age);
            if (userMap.containsKey(age)) {
                userMap.get(age).add(user);
            } else {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                userMap.put(age, userList);
            }
        }

        System.out.println("Введите требуемый возраст");
        int requiredAge = Integer.parseInt(in.nextLine());

        if (userMap.containsKey(requiredAge)) {
            List<User> users = userMap.get(requiredAge);
            users.sort(Comparator.comparing(User::getName));
            for (User user : users) {
                System.out.println(user);
            }
        } else {
            System.out.println("Пользователь с возрастом '" + requiredAge + "' не найден");
        }
    }
}

class User {
    private String name;
    private Integer age;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    User(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return (name + ", возраст " + age + " лет");
    }
}