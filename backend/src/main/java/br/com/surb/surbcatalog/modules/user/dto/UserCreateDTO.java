package br.com.surb.surbcatalog.modules.user.dto;

import br.com.surb.surbcatalog.modules.user.validator.create.UserCreateValid;

import java.io.Serial;
import java.io.Serializable;
@UserCreateValid
public class UserCreateDTO extends UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6785870495100091634L;
    private String password;

    public UserCreateDTO() {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
