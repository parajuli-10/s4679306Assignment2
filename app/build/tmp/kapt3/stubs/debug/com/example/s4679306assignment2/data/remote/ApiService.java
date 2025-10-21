package com.example.s4679306assignment2.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/example/s4679306assignment2/data/remote/ApiService;", "", "authFootscray", "Lcom/example/s4679306assignment2/data/remote/LoginResponse;", "body", "Lcom/example/s4679306assignment2/data/remote/LoginRequest;", "(Lcom/example/s4679306assignment2/data/remote/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDashboard", "Lcom/example/s4679306assignment2/data/remote/DashboardResponse;", "keypass", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.POST(value = "footscray/auth")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object authFootscray(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.s4679306assignment2.data.remote.LoginRequest body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.s4679306assignment2.data.remote.LoginResponse> $completion);
    
    @retrofit2.http.GET(value = "dashboard/{keypass}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDashboard(@retrofit2.http.Path(value = "keypass")
    @org.jetbrains.annotations.NotNull()
    java.lang.String keypass, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.s4679306assignment2.data.remote.DashboardResponse> $completion);
}