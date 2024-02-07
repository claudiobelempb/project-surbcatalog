package br.com.surb.surbcatalog.modules.user.dto;

import br.com.surb.surbcatalog.modules.user.validator.update.UserUpdateValid;

import java.io.Serial;
import java.io.Serializable;

@UserUpdateValid
public class UserUpdateDTO extends UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 3673800532696994621L;
    private String password;


    public UserUpdateDTO() {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
