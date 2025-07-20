
package com.Tienda.Ropa.Repositorios;

import com.Tienda.Ropa.Modelos.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppUserRespositorio extends JpaRepository<AppUser,Integer> {
    public AppUser findByEmail(String email);
}
