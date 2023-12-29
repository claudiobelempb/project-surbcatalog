package br.com.surb.surbcatalog.modules.user.dto;

import br.com.surb.surbcatalog.modules.user.entities.User;

public class UserCreateDTO extends UserDTO{
    private String password;

   public UserCreateDTO(){}

    public UserCreateDTO(String password) {
        this.password = password;
    }

    public UserCreateDTO(User entity, String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
