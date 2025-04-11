package com.example.tareals.service;

import com.example.tareals.model.User;

/**
 * Interfaz que define los servicios relacionados con la gestión de usuarios.
 */
public interface UserService {

    /**
     * Valida las credenciales del usuario.
     *
     * @param user Objeto User con las credenciales a validar
     * @return true si las credenciales son válidas, false en caso contrario
     */
    boolean validateUser(User user);
}