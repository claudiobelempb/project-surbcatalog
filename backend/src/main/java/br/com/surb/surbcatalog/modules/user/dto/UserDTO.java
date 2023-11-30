package br.com.surb.surbcatalog.modules.user.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4188542304189279824L;

    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;

    public UserDTO() {
    }

    private UserDTO(UserDTOBuilder builder){
        userId = builder.userId;
        firstName = builder.firstName;
        lastName = builder.lastName;
        email = builder.email;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public static UserDTOBuilder newUserDTO() {
        return new UserDTOBuilder();
    }

    public static final class UserDTOBuilder {
        private UUID userId;
        private String firstName;
        private String lastName;
        private String email;

        private UserDTOBuilder() {
        }


        public UserDTOBuilder userId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public UserDTOBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDTOBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserDTOBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserDTO build() {
            UserDTO userDTO = new UserDTO();
            userDTO.firstName = this.firstName;
            userDTO.userId = this.userId;
            userDTO.lastName = this.lastName;
            userDTO.email = this.email;
            return userDTO;
        }
    }
}
