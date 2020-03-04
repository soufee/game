package ru.ashamaz.process;

import ru.ashamaz.model.Player;

/**
 * The Game thread is for process with one Dispatcher
 * When it finishes, the program must stop gracefully
 */
public class Game extends Thread {
    @Override
    public void run() {
        Player player1 = new Player("initiator");
        Player player2 = new Player("player2");
        IDispatcher dispatcher = new Dispatcher(10);
        dispatcher.registerPlayers(player1, player2);
        player1.sendMessage("hello", player2);
    }
}
