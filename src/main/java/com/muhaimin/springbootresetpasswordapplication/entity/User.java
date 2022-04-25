package com.muhaimin.springbootresetpasswordapplication.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "t_user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty(message = "{FIRST_NAME_REQUIRED}")
    private String firstName;
    @NotEmpty(message = "{LAST_NAME_REQUIRED}")
    private String lastName;
    @Email
    @NotEmpty(message = "{EMAIL_REQUIRED}")
    private String email;
    @NotEmpty(message = "{PASSWORD_REQUIRED}")
    private String password;
    @NotNull(message = "{BIRT_DATE_REQUIRED}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;
    @NotEmpty(message = "{PHONE_NUMBER_REQUIRED}")
    @Size(max = 13, min = 10)
    private String phoneNumber;
    @NotEmpty(message = "{DEPARTMENT_NAME_REQUIRED}")
    private String jurusan;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {
            @JoinColumn(name = "role_id")})
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
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
}