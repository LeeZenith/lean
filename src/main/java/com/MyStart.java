package com;

import sun.applet.Main;

public class MyStart {
    public static void main(String[] args) {
        final Class<Main> mainClass = Main.class;
        final Main main = new Main();
        final Class<? extends Main> aClass = main.getClass();


    }

}
