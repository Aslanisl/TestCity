package ru.mail.aslanisl.test.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ru.mail.aslanisl.test.presentation.MainActivity;
import ru.mail.aslanisl.test.di.module.AppModule;
import ru.mail.aslanisl.test.presentation.RecyclerFragment;

/**
 * Created by Ivan on 31.01.2018.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(RecyclerFragment fragment);
}
