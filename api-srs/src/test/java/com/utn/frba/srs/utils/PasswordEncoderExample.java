package com.utn.frba.srs.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordEncoderExample {
    public static void main(String[] args) {
        // Crear un objeto BCryptPasswordEncoder
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Contraseña a codificar
        String password = "admin";

        // Codificar la contraseña
        String encodedPassword = passwordEncoder.encode(password);

        // Imprimir la contraseña codificada
        System.out.println("Contraseña codificada para 'admin': " + encodedPassword);

        // Generar una clave de 256 bits
        byte[] keyBytes = new byte[32];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(keyBytes);
        SecretKey secretKey = new SecretKeySpec(keyBytes, "HmacSHA256");

        // Codificar la clave en base64
        String base64Key = Base64.getEncoder().encodeToString(secretKey.getEncoded());

        // Imprimir la clave generada
        System.out.println("Clave generada: " + base64Key);
    }
}
