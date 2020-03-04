package ru.ashamaz.model;

import ru.ashamaz.process.IDispatcher;

/**
 * The Player class is an Object tha is able to communicate with other instances of this class
 */
public class Player {
    private static final String NO_DISPATCHER = "The player is not registered in any dispatchers";
    private String nickname;
    private int messageCounter = 0;
    private IDispatcher dispatcher;

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public int getMessageCounter() {
        return messageCounter;
    }

    public IDispatcher getDispatcher() {
        return dispatcher;
    }

    /**
     * incrementation of counter must be in dispatcher. So, we make a public method for it
     */
    public int incrementCounter() {
        return ++messageCounter;
    }

    /**
     * sendMessage is a method for initial message
     *
     * @param text - the String text to send
     * @param to   - the Player to whom we send message
     *             <p>
     *             first we check that the Player has registered dispatcher.
     *             If it is not nullm we complete Message and set this instance as FROM Player.
     *             Then we call dispatchers method to process message
     */

    public void sendMessage(String text, Player to) {
        if (dispatcher == null) {
            throw new RuntimeException(NO_DISPATCHER);
        }
        Message message = new Message(text, to);
        message.setFrom(this);
        dispatcher.sendMessage(message);
    }

    /**
     * When the dispatcher gets message, it notifies the recipient PLayer, calling it's method handleMessage
     *
     * @param receivedMessage - got String message
     * @param from            - the sender of message
     *                        We check that dispatcher is registered,
     *                        then complete Message and reply to it
     */

    public void handleMessage(String receivedMessage, Player from) {
        if (dispatcher == null) {
            throw new RuntimeException(NO_DISPATCHER);
        }
        System.out.println("The user " + nickname + " has got a message '" + receivedMessage + "' from " + from.getNickname());
        Message message = new Message(receivedMessage + " " + messageCounter, from);
        message.setFrom(this);
        dispatcher.sendMessage(message);
    }

    /**
     * Dispatcher is a class for communicating with other instances. For using the One dispatcher, we have to register our Players in it,
     * So, we need setter for it
     */
    public void setDispatcher(IDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public String getNickname() {
        return nickname;
    }
}
