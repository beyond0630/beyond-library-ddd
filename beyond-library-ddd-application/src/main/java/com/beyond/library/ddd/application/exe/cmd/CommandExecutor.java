package com.beyond.library.ddd.application.exe.cmd;

import com.beyond.library.ddd.application.exe.Executor;
import com.beyond.library.ddd.client.cmd.Command;

/**
 * @author beyond
 * @since 2022/11/14
 */
public interface CommandExecutor<T extends Command, R> extends Executor {

    R execute(T t);

}
