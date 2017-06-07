package com.laomao.kt.di.component;

import com.laomao.kt.ui.activity.TestActivity;

import dagger.Component;

/**
 * Created by laomao on 2017/6/2.
 */
@Component
public interface IUserTestComponent {
 void inject(TestActivity testActivity);

}
