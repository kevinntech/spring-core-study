package me.whiteship.demospring51;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Event {
    Integer id;

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotEmpty
    String title;

    @Min(0)
    Integer limit;

    @Email
    String email;

    public Integer getLimit() {
        return limit;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
