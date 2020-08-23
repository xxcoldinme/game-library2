package org.stonlexx.test;

import org.stonlexx.gamelibrary.GameLibrary;
import org.stonlexx.gamelibrary.core.bean.manager.BeanManager;
import org.stonlexx.gamelibrary.core.configuration.LibraryCoreConfiguration;
import org.stonlexx.test.bean.TestPlayer;

public class TestStarter {

    public static void main(String[] args) {
        LibraryCoreConfiguration coreConfiguration = GameLibrary.getInstance().getLibraryCore().getCoreConfiguration();
        coreConfiguration.addPropertyConfiguration(TestStarter.class.getClassLoader(), "test.properties");

        BeanManager beanManager = GameLibrary.getInstance().getLibraryCore().getBeanManager();
        beanManager.scanPackages("org.stonlexx.test");

        TestPlayer testPlayer = beanManager.getBean(TestPlayer.class).getBeanObject();

        beanManager.destroy();
    }

}
