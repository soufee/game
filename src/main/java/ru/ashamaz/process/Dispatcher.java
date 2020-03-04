package ru.ashamaz.process;

import ru.ashamaz.model.Message;
import ru.ashamaz.model.Player;

/**
 * An implementation of IDispatcher
 * limit is the stop condition
 */

public class Dispatcher implements IDispatcher {
    private int limit;

    public Dispatcher(int limit) {
        this.limit = limit;
    }


    /**
     * For communication between some instances of Player class, they must use the one Dispatcher.
     * So, the method registerPlayers sets to all passed entities the one dispatcher
     *
     * @param players - varargs list of players
     */

    @Override
    public void registerPlayers(Player... players) {
        for (Player player : players) {
            player.setDispatcher(this);
        }
    }

    /**
     * @param message - the Message entity to process
     *                If the stop condition is reached, the program stops
     *                else the counter of message sender increments and the message handles by recipient
     */

    @Override
    public void sendMessage(Message message) {
        if (message.getTo().getMessageCounter() >= limit && message.getFrom().getMessageCounter() >= limit) {
            System.out.println("The limit " + limit + " is reached!");
            return;
        }
        message.getFrom().incrementCounter();
        System.out.println("The user " + message.getFrom().getNickname() + " sends a message '" + message.getMessage() + "' to " + message.getTo().getNickname());
        message.getTo().handleMessage(message.getMessage(), message.getFrom());

    }

    public int getLimit() {
        return limit;
    }
}
