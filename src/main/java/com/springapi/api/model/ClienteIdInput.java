package com.springapi.api.model;

import javax.validation.constraints.NotNull;

public class ClienteIdInput {

    @NotNull
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
