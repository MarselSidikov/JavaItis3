package ru.itis.di.messages.factories;

import ru.itis.di.messages.messages.Message;
import ru.itis.di.messages.providers.Provider;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class ProviderFactory {
    private static ProviderFactory instance;

    private Provider provider;

    static {
        instance = new ProviderFactory();
    }

    private ProviderFactory() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\admin.WIN-IPM3OA3VQNQ\\Desktop\\JAVA\\JavaItis3\\SimpleDi\\src\\main\\resources\\ru.itis\\context.properties"));
            String providerClassName = properties.getProperty("provider.class");
            String providerParam = properties.getProperty("provider.param");
            Class<Provider> providerClass = (Class<Provider>) Class.forName(providerClassName);
            Constructor<Provider> providerConstructor = providerClass.getConstructor(Message.class, String.class);
            Message message = MessagesFactory.getInstance().getMessage();
            provider = providerConstructor.newInstance(message, providerParam);
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static ProviderFactory getInstance() {
        return instance;
    }

    public Provider getProvider() {
        return provider;
    }
}
