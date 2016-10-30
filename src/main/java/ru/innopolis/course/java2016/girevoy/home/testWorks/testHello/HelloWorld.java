package ru.innopolis.course.java2016.girevoy.home.testWorks.testHello;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Arxan on 05.10.2016.
 */
public class HelloWorld {
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		SecretKey secretKey;
		secretKey = KeyGenerator.getInstance("AES").generateKey();
		System.out.println(secretKey.getEncoded());
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] bytes = cipher.doFinal("TMP".getBytes());

		cipher.init(Cipher.DECRYPT_MODE,secretKey);
		System.out.println(cipher.doFinal(bytes));

	}
}
