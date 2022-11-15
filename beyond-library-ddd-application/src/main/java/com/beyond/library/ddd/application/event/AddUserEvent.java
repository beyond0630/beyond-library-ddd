package com.beyond.library.ddd.application.event;

import com.beyond.library.ddd.domain.entity.User;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @author beyond
 * @since 2022/11/15
 */
@Data
public class AddUserEvent extends ApplicationEvent {

    private User user;

    public AddUserEvent(final Object source) {
        super(source);
    }

    public AddUserEvent(final Object source, final User user) {
        super(source);
        this.user = user;
    }

}
