package com.guizKev.api.persistence.entity ;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Builder
@Getter @Setter
@AllArgsConstructor 
@NoArgsConstructor     
public class User implements UserDetails {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre_usuario", columnDefinition = "varchar(10) not null")
    @Setter
    private String userName;

    @Column(name = "contrasena_hash")
    @Setter @Getter
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return this.userName ;
    }
}
