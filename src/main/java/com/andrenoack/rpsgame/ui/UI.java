package com.andrenoack.rpsgame.ui;

import com.andrenoack.rpsgame.Controller;
import com.andrenoack.rpsgame.Model;

/**
 * Interface that User Interface implementations have to conform to.
 */
public interface UI {

    public void start(Controller controller, Model model);

}
