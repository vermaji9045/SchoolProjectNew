package com.School.SchoolValleyProject.Model;

import com.School.SchoolValleyProject.annotations.FieldsValueMatch;
import com.School.SchoolValleyProject.annotations.PasswordValidator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@FieldsValueMatch.List({

        @FieldsValueMatch(

                field = "pwd",
                fieldMatch = "confirmPwd",
                message="Password do not match"
        ),
        @FieldsValueMatch(

                field = "email",
                fieldMatch = "confirmEmail",
                message = "Email do not match"
        )
})
public class Person extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int personid;

    @NotBlank(message = "Name must not be Blank")
    @Size(min=3,message = "Name must have at least 5 characters")
    private String name;

    @NotBlank(message="Mobile number must not be blank")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotBlank(message="Email must not be blank")
    @Email(message="Please provide a valid mail id")
    private String email;
    @NotBlank(message = "Confirm email not be blank")
    @Email(message = "Please provide confirm email address")
    @Transient
    private String confirmEmail;

    @NotBlank(message = "Password must not be blanl")
    @Size(min=5,message = "Password must be at least 5 char long")
    private String pwd;

    @NotBlank(message = "Confirm Password must not blank ")
    @Size(min = 5,message = "Confirm Password must be at least 5 char long")
    @Transient
    @PasswordValidator
    private String confirmPwd;


}