package info.User.Register.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

@Entity
public class User {

    @Id
    private String username;
    @JsonIgnore
    @Column
    private String password;
    @Column
    private String email;

    public User() {
    }

    public User(String username) {
	this();
	setUsername(username);
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	Preconditions.checkArgument(!Strings.isNullOrEmpty(MoreObjects.firstNonNull(username, "").trim()));
	this.username = username.trim();
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    @Override
    public String toString() {
	return MoreObjects.toStringHelper(this).add("username", username).toString();
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null || !(obj instanceof User)) {
	    return false;
	}
	if (obj == this) {
	    return true;
	}
	User other = (User) obj;
	return Objects.equals(username, other.username);
    }

    @Override
    public int hashCode() {
	return username.hashCode();
    }

    public void clearPassword() {
	password = null;
    }
}
