package ru.ashamaz.process;

import org.junit.Test;
import ru.ashamaz.model.Player;

import static org.junit.Assert.*;

public class DispatcherTest {

    @Test
    public void registerPlayers() {
        Dispatcher dispatcher = new Dispatcher(2);
        Player player = new Player("Ivan");
        assertNull(player.getDispatcher());
        dispatcher.registerPlayers(player);
        assertNotNull(player.getDispatcher());
    }

    @Test
    public void sendMessage() {
        Dispatcher dispatcher = new Dispatcher(2);
        Player player = new Player("Bob");
        Player player2 = new Player("Alice");
        dispatcher.registerPlayers(player, player2);
        player.sendMessage("Hello, Alice", player2);
        assertEquals(player.getMessageCounter(), dispatcher.getLimit());
        assertEquals(player2.getMessageCounter(), dispatcher.getLimit());
    }
}