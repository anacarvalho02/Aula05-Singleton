import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = Login.getInstancia();

        System.out.println("=== Sistema de Login (Singleton) ===");

        String captcha = login.gerarCaptcha();
        System.out.println("Captcha: " + captcha);

        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Digite o captcha: ");
        String captchaDigitado = scanner.nextLine();

        login.autenticar(usuario, senha, captchaDigitado);

        scanner.close();
    }
}
