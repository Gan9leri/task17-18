package models;

import lombok.Data;

@Data
public class AuthRequestBodyModel {
    String userName, password;
}