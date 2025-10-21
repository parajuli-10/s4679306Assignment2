package com.example.s4679306assignment2.di;

import com.example.s4679306assignment2.data.Repository;
import com.example.s4679306assignment2.data.remote.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class NetworkModule_ProvideRepositoryFactory implements Factory<Repository> {
  private final Provider<ApiService> apiProvider;

  public NetworkModule_ProvideRepositoryFactory(Provider<ApiService> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public Repository get() {
    return provideRepository(apiProvider.get());
  }

  public static NetworkModule_ProvideRepositoryFactory create(Provider<ApiService> apiProvider) {
    return new NetworkModule_ProvideRepositoryFactory(apiProvider);
  }

  public static Repository provideRepository(ApiService api) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideRepository(api));
  }
}
