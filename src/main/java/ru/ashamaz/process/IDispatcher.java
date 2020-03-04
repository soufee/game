package ru.ashamaz.process;

import ru.ashamaz.model.Message;
import ru.ashamaz.model.Player;

/**
 * IDispatcher is an interface of dispatcher
 * due to dispatcher can be in different implementations, it's better to use interface
 */
public interface IDispatcher {
    /**
     * @param players - varaargs for registering some players together
     */
    void registerPlayers(Player... players);

    /**
     * @param message the message to send
     */
    void sendMessage(Message message);
}
