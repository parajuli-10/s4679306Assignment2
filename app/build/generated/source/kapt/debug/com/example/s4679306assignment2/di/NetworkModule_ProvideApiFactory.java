package com.example.s4679306assignment2.di;

import com.example.s4679306assignment2.data.remote.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class NetworkModule_ProvideApiFactory implements Factory<ApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public ApiService get() {
    return provideApi(retrofitProvider.get());
  }

  public static NetworkModule_ProvideApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideApiFactory(retrofitProvider);
  }

  public static ApiService provideApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideApi(retrofit));
  }
}
