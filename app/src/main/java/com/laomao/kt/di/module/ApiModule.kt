package com.laomao.kt.di.module

import android.content.Context
import android.support.annotation.Nullable
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.laomao.kt.api.LaomaoApi
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers
import java.io.File

/**
 * Created by laomao on 2017/6/1.
 */
@Module(includes = arrayOf(AppModule::class))
class ApiModule {
    @Provides fun provideRetrofit(baseUrl: HttpUrl, client: OkHttpClient, gson: Gson) =
            Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build()
    @Provides fun provideBaseUrl() = HttpUrl.parse("https://api.leancloud.cn/1.1/")
    @Provides fun provideOkhttp(context: Context, interceptor: HttpLoggingInterceptor): OkHttpClient {
        val cacheSize = 1024 * 1024 * 10L
        val cacheDir = File(context.cacheDir, "http")
        val cache = Cache(cacheDir, cacheSize)
        return OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor)
                .addInterceptor { chain ->
                    chain.proceed(chain.request().newBuilder()
                            .addHeader("Content-Type", "application/json")
                            .addHeader("X-LC-Id", "LY9qvSrv3qK6CXE2HIT4s4mj-gzGzoHsz")
                            .addHeader("X-LC-Key", "vB9XsJyWk9v86Ivc3wd4lq2P")
                            .build())
                }
                .build()
    }

    @Provides fun provideInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor {
            message ->
            Log.d("okhttp", message)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides fun provideGson() = GsonBuilder().create()

    @Provides fun provideApi(retrofit: Retrofit) = retrofit.create(LaomaoApi::class.java)

}