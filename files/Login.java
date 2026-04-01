import java.util.Random;

public class Login {

    private static Login instancia;

    private final String usuarioCorreto = "ana";
    private final String senhaCorreta   = "endurence";
    private String captchaAtual;

    private Login() {}

    public static Login getInstancia() {
        if (instancia == null) {
            instancia = new Login();
        }
        return instancia;
    }

    public String gerarCaptcha() {
        String caracteres = "123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        captchaAtual = sb.toString();
        return captchaAtual;
    }

    public boolean autenticar(String usuario, String senha, String captchaDigitado) {
        if (!captchaDigitado.equals(captchaAtual)) {
            System.out.println("[ERRO] Captcha incorreto. Possível bot detectado.");
            return false;
        }
        if (!usuario.equals(usuarioCorreto) || !senha.equals(senhaCorreta)) {
            System.out.println("[ERRO] Usuário ou senha inválidos.");
            return false;
        }
        System.out.println("[SUCESSO] Login realizado com sucesso. Bem-vindo, " + usuario + "!");
        return true;
    }
}
