import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

			String message;
			String key;
			String result = "";
			int keyIndex = 0;

			System.out.print("Informe a mensagem a ser criptografada: ");
			message = sc.nextLine();

			System.out.print("Informe a chave: ");
			key = sc.nextLine().toUpperCase();

			for (int i = 0; i < message.length(); i++) {
				int keyCode;
				int keyType = -1;
				
				// LETRAS MAIUSCULAS
				if (message.charAt(i) >= 65 && message.charAt(i) <= 90) {
					keyCode = alphabet.indexOf(message.charAt(i));
					keyType = 1;
				} // LETRAS MINUSCULAS
				else if (message.charAt(i) >= 97 && message.charAt(i) <= 122) {
					keyCode = alphabet.toLowerCase().indexOf(message.charAt(i));
					keyType = 0;
				} // OUTROS CARACTERES
				else {
					keyCode = -1;
				}

				// CRIPTOGRAFA CASO SEJA LETRA
				if (keyCode > -1) {
					keyCode += alphabet.indexOf(key.charAt(keyIndex));
					keyIndex += 1;

					keyCode %= alphabet.length();

					if (keyIndex == key.length())
						keyIndex = 0;

					result += (keyType > 0) ? (char) alphabet.charAt(keyCode)
							: (char) alphabet.toLowerCase().charAt(keyCode);

				} // IGNORA CASO SEJA OUTRO CARACTER
				else {
					result += message.charAt(i);
				}
			}
			
			System.out.printf("Cifra de Vigenere: %s\n", result);
		}
	}
}
