package {{ cookiecutter.package_name }}.di;


import android.os.Environment;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    @Singleton
    @Provides
    @Named("cached")
    OkHttpClient provideOkHttpClient() {
        Cache cache = new Cache(Environment.getDownloadCacheDirectory(), 10 * 1024 * 1024);
        return new OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .cache(cache)
                .build();
    }

    @Singleton
    @Provides
    @Named("non_cached")
    OkHttpClient provideNonCachedOkHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .build();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofit(Gson gson, @Named("cached") OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
    }

    /**
     * Example service
     */
    /*@Provides
    @Singleton
    WordpressService provideService(Retrofit.Builder builder) {
        return builder.baseUrl(BuildConfig.API_URL)
                .build()
                .create(WordpressService.class);
    }
    */

}
