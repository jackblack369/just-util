package com.jackson.demo2;

import java.util.List;
import java.util.UUID;

public class PojoToSchema {

    private class Credential {
        private String id;
        private long issued;
    }

    private UUID id;
    private String name;
    private List<String> roles;
    private Credential credential;
}
