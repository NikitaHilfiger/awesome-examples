package com.application.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {

    private final String firstName;

    private final String lasName;

    private final long id;
}
