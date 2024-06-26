//package br.com.leadersofts.qikserve.infrastructure.security;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name = "users")
//@Table(name = "users")
//@EqualsAndHashCode(of = "id")
//public class User implements UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    private String login;
//
//    private String passwod;
//
//    private UserRole role;
//
//    public User(String login, String password, UserRole role) {
//        this.login = login;
//        this.passwod = password;
//        this.role = role;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        return this.role == UserRole.ADMIN ?
//                List.of((new SimpleGrantedAuthority("ROLE_ADMIN")),(new SimpleGrantedAuthority("ROLE_USER"))) :
//                List.of(new SimpleGrantedAuthority("ROLE_USER"));
//    }
//
//    @Override
//    public String getPassword() {
//        return this.passwod;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.login;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
