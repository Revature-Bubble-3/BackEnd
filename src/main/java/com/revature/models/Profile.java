package com.revature.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.revature.utilites.SecurityUtil;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;



@Component
@Entity
@Table(name = "profile")
@Getter @Setter @AllArgsConstructor
public class Profile {
    @Id
    @Column(name = "profile_id")
    private int pid;

    @Column(name = "username",
            columnDefinition = "TEXT",
            nullable = false,
            unique = true)
    private String username;

    @Column(name = "passkey",
            columnDefinition = "TEXT",
            nullable = false,
            unique = true)

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passkey;

    @Column(name = "first_name",
            columnDefinition = "TEXT",
            nullable = false)
    private String firstName;

    @Column(name = "last_name",
            columnDefinition = "TEXT",
            nullable = false)
    private String lastName;

    @Column(name = "email",
            columnDefinition = "TEXT",
            nullable = false,
            unique = true)
    private String email;

    @Column(name = "following")
    @ManyToMany
    private List<Profile> following;

    @ManyToMany (mappedBy = "likes")
    @JsonIgnore
    private Set<Post> likedPosts = new LinkedHashSet<>();

    @Column(name = "friends")
    @ManyToMany
    private List<Profile> friends;

    public Profile() {
        this.pid = SecurityUtil.getId();
    }

    public Profile(int pid, String username, String passkey, String firstName, String lastName, String email, List<Profile> following, List<Profile> firends) {
        this.pid = pid;
        this.username = username;
        this.passkey = passkey;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.following = following;
        this.friends = friends;
    }

    public Profile(int pid, String username, String passkey, String firstName, String lastName, String email, List<Profile> following) {
        this.pid = pid;
        this.username = username;
        this.passkey = passkey;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.following = following;
    }

    public Profile(int pid, String username, String passkey, String firstName, String lastName, String email) {
        this.pid = pid;
        this.username = username;
        this.passkey = passkey;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Profile(String username, String passkey, String firstName, String lastName, String email) {
        this();
        this.username = username;
        this.passkey = passkey;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return pid == profile.pid && username.equals(profile.username) && passkey.equals(profile.passkey) && firstName.equals(profile.firstName) && lastName.equals(profile.lastName) && email.equals(profile.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, username, passkey, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "pid=" + pid +
                ", username='" + username + '\'' +
                ", passkey='" + passkey + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public boolean isIncomplete() {
        return this.username == null || this.passkey == null || this.firstName == null || this.lastName == null ||
                this.email == null || this.likedPosts == null || this.username.isEmpty() || this.passkey.isEmpty() ||
                this.firstName.isEmpty() || this.lastName.isEmpty() || this.email.isEmpty() || this.pid < 100;
    }
}
