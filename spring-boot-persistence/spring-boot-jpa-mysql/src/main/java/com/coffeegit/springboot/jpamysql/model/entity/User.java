package com.coffeegit.springboot.jpamysql.model.entity;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import com.coffeegit.springboot.jpamysql.model.entity.audit.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Table(name = "users", schema = "public")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends DateAudit {
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
	
	@Column(name = "first_name", nullable = false, length = 100)
	private String firstName;
	
	@Column(name = "last_name", nullable = true, length = 100)
    private String lastName;
	
	@Column(name = "email", unique = true, nullable = false, length = 345)
    @Email(message = "Email must be valid")
    private String email;
	
	@Column(name = "password", nullable = false, length = 72)
    private String password;
	
	@Column(name = "account_non_expired", nullable = false)
    @ColumnDefault("false")
    private Boolean accountNonExpired = false;

    @Column(name = "account_non_locked", nullable = false)
    @ColumnDefault("false")
    private Boolean accountNonLocked = false;

    @Column(name = "credentials_non_expired", nullable = false)
    @ColumnDefault("false")
    private Boolean credentialsNonExpired = false;

    @Column(name = "enabled", nullable = false)
    @ColumnDefault("false")
    private Boolean enabled;

    @Column(name = "token_expired", nullable = false)
    @ColumnDefault("false")
    private Boolean tokenExpired;
    
    @ManyToMany 
    @JoinTable( 
        name = "users_roles", 
		// The owning entity.
        joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id"), 
		// Non owning entity.
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id")) 
    // @JsonIgnoreProperties({"users", "id"}) // This ignore the fields in Role entity.
    @JsonIgnore
    private Collection<Role> roles;
    
    @ManyToMany
    @JoinTable(
        name = "users_groups",
		// The owning entity.
        joinColumns = @JoinColumn(
            name = "user_id", referencedColumnName = "id"
        ),
		// Non owning entity.
        inverseJoinColumns = @JoinColumn(
            name = "group_id", referencedColumnName = "id"
        )
    )
    // @JsonIgnoreProperties({"users", "id"}) // This ignore the fields in Group entity.
    @JsonIgnore
    private Collection<Group> groups;

    @JsonIgnore
    public void removeRoles(Collection<Role> roles) {
        for (Role role : roles) {
            removeRole(role);
        }
    }

    /**
     * Add user and also to child entity role.
     *
     * @param role
     */
    @JsonIgnore
    public void setRole(Role role) {
        this.roles.add(role);
        role.getUsers().add(this);
    }

    /**
     * Remove user and also to child entity role.
     *
     * @param role
     */
    @JsonIgnore
    public void removeRole(Role role) {
        this.roles.remove(role);
        role.getUsers().remove(role);
    }

    @JsonIgnore
    public void removeUserGroups(Role role) {
        this.roles.remove(role);
        role.getUsers().remove(this);
    }

    @JsonIgnore
    public void addUserGroups(Group group) {
        this.groups.add(group);
        group.getUsers().add(this);
    }

    @JsonIgnore
    public void removeUserGroups(Group group) {
        this.groups.remove(group);
        group.getUsers().remove(this);
    }
}
