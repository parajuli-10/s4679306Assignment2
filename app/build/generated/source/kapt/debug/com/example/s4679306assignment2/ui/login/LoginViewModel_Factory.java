package com.example.s4679306assignment2.ui.login;

import com.example.s4679306assignment2.data.Repository;
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
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<Repository> repoProvider;

  public LoginViewModel_Factory(Provider<Repository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static LoginViewModel_Factory create(Provider<Repository> repoProvider) {
    return new LoginViewModel_Factory(repoProvider);
  }

  public static LoginViewModel newInstance(Repository repo) {
    return new LoginViewModel(repo);
  }
}
