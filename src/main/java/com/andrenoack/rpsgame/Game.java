package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.players.*;
import com.andrenoack.rpsgame.ui.UI;
import com.andrenoack.rpsgame.ui.UIFactory;
import com.andrenoack.rpsgame.ui.swing.SwingUIFactory;

/**
 * This is the main class for starting the application.
 */
class Game {

    public static void main(String... args) {
        AutoChoosingStrategy autoChoosingStrategy = new RandomAutoChoosingStrategy();
        PlayerFactoryRegistry playerFactoryRegistry = new PlayerFactoryRegistry();
        playerFactoryRegistry.add(GameType.COMPUTER_VS_COMPUTER, new ComputerVsComputerPlayerFactory(autoChoosingStrategy));
        playerFactoryRegistry.add(GameType.PLAYER_VS_COMPUTER, new PlayerVsComputerPlayerFactory(autoChoosingStrategy));
        Model model = new DefaultModel(playerFactoryRegistry);
        Controller controller = new Controller(model);
        UIFactory uiFactory = new SwingUIFactory();
        UI ui = uiFactory.createUI();
        ui.start(controller, model);
    }
}
