package com.alihaine.swingy;

import com.alihaine.swingy.controller.GameLoop;


public class Swingy {

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.print("Error args");
            return;
        }
        if (!args[0].equals("console") && !args[0].equals("gui")) {
            System.out.print("Error args");
            return ;
        }
        GameLoop.gameLoop.LaunchGame(args[0]);
    }
}
