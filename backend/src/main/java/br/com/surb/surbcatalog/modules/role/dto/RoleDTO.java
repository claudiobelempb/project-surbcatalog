package br.com.surb.surbcatalog.modules.role.dto;

import br.com.surb.surbcatalog.modules.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1098897813427276436L;

    private String roleId;
    private String authority;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private Boolean active;
    private final Set<UserDTO> users = new HashSet<>();

//    users.forEach(user -> this.users.add(new UserDTO(user)));
}
