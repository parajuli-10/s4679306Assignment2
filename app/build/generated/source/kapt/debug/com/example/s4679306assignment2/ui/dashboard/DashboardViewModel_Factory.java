package com.example.s4679306assignment2.ui.dashboard;

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
public final class DashboardViewModel_Factory implements Factory<DashboardViewModel> {
  private final Provider<Repository> repoProvider;

  public DashboardViewModel_Factory(Provider<Repository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public DashboardViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static DashboardViewModel_Factory create(Provider<Repository> repoProvider) {
    return new DashboardViewModel_Factory(repoProvider);
  }

  public static DashboardViewModel newInstance(Repository repo) {
    return new DashboardViewModel(repo);
  }
}
