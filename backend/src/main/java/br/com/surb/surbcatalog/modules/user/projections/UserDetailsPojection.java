package br.com.surb.surbcatalog.modules.user.projections;

import java.util.UUID;

public interface UserDetailsPojection {
    String getUsername();

    String getPassword();

    UUID getRoleId();

    String getAuthority();


}
