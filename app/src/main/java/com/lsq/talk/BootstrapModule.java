package com.lsq.talk;

import android.accounts.AccountManager;
import android.content.Context;

import com.lsq.talk.authenticator.BootstrapAuthenticatorActivity;
import com.lsq.talk.authenticator.LogoutService;
import com.lsq.talk.core.CheckIn;
import com.lsq.talk.core.TimerService;
import com.lsq.talk.ui.BootstrapTimerActivity;
import com.lsq.talk.ui.CarouselActivity;
import com.lsq.talk.ui.CheckInsListFragment;
import com.lsq.talk.ui.ItemListFragment;
import com.lsq.talk.ui.NewsActivity;
import com.lsq.talk.ui.NewsListFragment;
import com.lsq.talk.ui.UserActivity;
import com.lsq.talk.ui.UserListFragment;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module
(
        complete = false,

        injects = {
                BootstrapApplication.class,
                BootstrapAuthenticatorActivity.class,
                CarouselActivity.class,
                BootstrapTimerActivity.class,
                CheckInsListFragment.class,
                NewsActivity.class,
                NewsListFragment.class,
                UserActivity.class,
                UserListFragment.class,
                TimerService.class
        }

)
public class BootstrapModule  {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
        return new LogoutService(context, accountManager);
    }

}
