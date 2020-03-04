package ru.ashamaz.model;

/**
 * Message entity contains
 * - text message
 * - Player sender
 * - Player recipient
 */
public class Message {
    private String message;
    private Player from;
    private Player to;

    public Message(String message, Player to) {
        this.message = message;
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public Player getFrom() {
        return from;
    }

    public void setFrom(Player from) {
        this.from = from;
    }

    public Player getTo() {
        return to;
    }
}
