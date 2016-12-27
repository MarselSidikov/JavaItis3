package ru.itis.di.messages;

import ru.itis.di.messages.factories.MessagesFactory;
import ru.itis.di.messages.factories.ProviderFactory;
import ru.itis.di.messages.messages.Message;
import ru.itis.di.messages.providers.MessageWithNameProvider;
import ru.itis.di.messages.providers.Provider;

public class Program {
    public static void main(String[] args) {
        Provider provider = ProviderFactory.getInstance().getProvider();
        provider.show();
    }
}
