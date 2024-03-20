package com.guizKev.api.persistence.entity;



import java.io.Serial;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "usuario")

@Builder
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(name = "nombre_usuario",columnDefinition = "varchar(10) not null")
    @Setter
    private String userName ;
    @Column(name = "contrasenaHash")
    @Setter
    private String passwordHash ;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
    @Override
    public String getPassword() {
        return this.passwordHash ;
    }
    @Override
    public String getUsername() {
        return this.userName ;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true ;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true ;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true ;
    }
    @Override
    public boolean isEnabled() {
        return true ;
    }

}
