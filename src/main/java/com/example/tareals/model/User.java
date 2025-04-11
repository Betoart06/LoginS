package com.example.tareals.model;

/**
 * Clase que representa un usuario del sistema.
 * Contiene información básica como nombre de usuario y contraseña.
 */
public class User {
    private String username;
    private String password;

    /**
     * Constructor por defecto.
     */
    public User() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param username Nombre de usuario
     * @param password Contraseña del usuario
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return Nombre de usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param username Nombre de usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return Contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password Contraseña del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }
}