package com.example.tareals.service;

import com.example.tareals.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementación de la interfaz UserService que proporciona
 * servicios relacionados con la gestión de usuarios.
 */
@Service
public class UserServiceImpl implements UserService {

    // Simulamos una base de datos de usuarios con un Map
    private final Map<String, String> usersDatabase;

    /**
     * Constructor que inicializa la "base de datos" de usuarios.
     * En un entorno real, esto sería reemplazado por una conexión
     * a una base de datos real o un repositorio.
     */
    public UserServiceImpl() {
        usersDatabase = new HashMap<>();
        // Agregamos algunos usuarios de prueba
        usersDatabase.put("Betoart", "12345");
        usersDatabase.put("Lapin2", "54321");
        usersDatabase.put("Pava", "45678");
    }

    /**
     * Valida las credenciales del usuario comparándolas con los datos almacenados.
     *
     * @param user Objeto User con las credenciales a validar
     * @return true si las credenciales son válidas, false en caso contrario
     */
    @Override
    public boolean validateUser(User user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            return false;
        }

        // Verificamos si el usuario existe y si la contraseña coincide
        String storedPassword = usersDatabase.get(user.getUsername());
        return storedPassword != null && storedPassword.equals(user.getPassword());
    }
}