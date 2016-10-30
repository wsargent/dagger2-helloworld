
package com.company;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

public class Main {

    interface Printer {
        void printMsg(String msg);
    }

    static class ConsolePrinter implements Printer {
        @Override
        public void printMsg(String msg) {
            System.out.println(msg);
        }
    }

    @Component(modules = ConsoleModule.class)
    interface HelloWorldApp {
        Printer getPrinter();
    }

    @Module
    static class ConsoleModule {
        @Provides
        Printer providePrinter() {
            return new ConsolePrinter();
        }
    }

    public static void main(String[] args) {
        HelloWorldApp app = DaggerMain_HelloWorldApp.create();
        app.getPrinter().printMsg("Hello World!");
    }
}
