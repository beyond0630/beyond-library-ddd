package com.beyond.library.ddd.application.exe.cmd;

import com.beyond.library.ddd.application.exe.Executor;
import com.beyond.library.ddd.client.cmd.Command;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author beyond
 * @since 2022/11/14
 */
@Slf4j
public abstract class CommandExecutor<T extends Command, R> implements Executor, InitializingBean {

    public abstract R execute(T command);

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("initialized {}", this.getName());
    }
}
