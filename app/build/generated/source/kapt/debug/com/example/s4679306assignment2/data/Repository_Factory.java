package com.example.s4679306assignment2.data;

import com.example.s4679306assignment2.data.remote.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class Repository_Factory implements Factory<Repository> {
  private final Provider<ApiService> apiProvider;

  public Repository_Factory(Provider<ApiService> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public Repository get() {
    return newInstance(apiProvider.get());
  }

  public static Repository_Factory create(Provider<ApiService> apiProvider) {
    return new Repository_Factory(apiProvider);
  }

  public static Repository newInstance(ApiService api) {
    return new Repository(api);
  }
}
