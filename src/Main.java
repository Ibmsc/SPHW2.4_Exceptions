public class Main {
    public static void main(String[] args) {

        String login = "java_skypro_go";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";
        System.out.println("Пример №1(верный) ");
        System.out.println(checkCorrect(login, password, confirmPassword));

        String loginNegative = "java_skypro go";
        String passwordNegative = "D_1hWiKjjP_9";
        String confirmPasswordNegative = "D_1hWiKjjP_9";
        System.out.println("Пример №2(С ошибкой) ");
        System.out.println(checkCorrect(loginNegative, passwordNegative, confirmPasswordNegative));

        String loginNegative2 = "java_skypro_go";
        String passwordNegative2 = "D_1hWiKjjP_9D_1hWiKjjP_9";
        String confirmPasswordNegative2 = "D_1hWiKjjP_9";
        System.out.println("Пример №3(С ошибкой) ");
        System.out.println(checkCorrect(loginNegative2, passwordNegative2, confirmPasswordNegative2));

        String loginNegative3 = "java_skypro_go";
        String passwordNegative3 = "D_1hWiKjjP_91";
        String confirmPasswordNegative3 = "D_1hWiKjjP_9";
        System.out.println("Пример №4(С ошибкой) ");
        System.out.println(checkCorrect(loginNegative3, passwordNegative3, confirmPasswordNegative3));


    }

    public static boolean checkCorrect(String login, String password, String confirmPassword) {
        try {
            if (login.toCharArray().length > 20) {
                throw new WrongLoginException("Слишком длинный логин");
            }
            if (password.toCharArray().length > 20 || confirmPassword.toCharArray().length > 20) {
                throw new WrongPasswordException("Слишком длинный пароль");
            }
            if (!login.matches("\\w{1,20}")) {
                throw new WrongLoginException("Логин не соответствует условиям");
            }
            if (!password.matches("\\w{1,20}") || !confirmPassword.matches("\\w{1,20}")) {
                throw new WrongPasswordException("Пароль не соответствует условиям");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль не совпадает");
            }
        } catch (WrongLoginException | WrongPasswordException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }

}