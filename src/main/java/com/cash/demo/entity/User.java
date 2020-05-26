package com.cash.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ApiModel(description = "All details about the User. ")
public class User {

    @Id
    @GeneratedValue(generator = "user_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq")
    @ApiModelProperty(notes = "The database generated user ID")
    private Long id;

    @NotEmpty(message = "Email is required")
    @Email
    @ApiModelProperty(notes = "The user email")
    private String email;

    @NotEmpty(message = "Firstname is required")
    @Size(min = 3, max = 15)
    @ApiModelProperty(notes = "The user firstname")
    private String firstname;

    @NotEmpty(message = "Lastname is required")
    @Size(min = 3, max = 15)
    @ApiModelProperty(notes = "The user lastname")
    private String lastname;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    @ApiModelProperty(notes = "The loans from user")
    private List<Loan> loans = new ArrayList<>();

    public User(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
}
