package ru.ashamaz.model;

import org.junit.Test;
import ru.ashamaz.process.Dispatcher;

import static org.junit.Assert.*;


public class PlayerTest {

    @Test(expected = RuntimeException.class)
    public void sendMessageWithException() {
        Player player = new Player("Bob");
        Player player2 = new Player("Alice");
        player.sendMessage("mess", player2);

    }

    @Test
    public void testHandleMessage() {
        Dispatcher dispatcher = new Dispatcher(2);
        Player player = new Player("Bob");
        Player player2 = new Player("Alice");
        dispatcher.registerPlayers(player, player2);
        player.sendMessage("mess", player2);
        assertEquals(player.getMessageCounter(), dispatcher.getLimit());
        assertEquals(player2.getMessageCounter(), dispatcher.getLimit());
    }

}