package com.example.s4679306assignment2.ui.dashboard;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/example/s4679306assignment2/ui/dashboard/DashboardActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/example/s4679306assignment2/ui/dashboard/EntityAdapter;", "binding", "Lcom/example/s4679306assignment2/databinding/ActivityDashboardBinding;", "vm", "Lcom/example/s4679306assignment2/ui/dashboard/DashboardViewModel;", "getVm", "()Lcom/example/s4679306assignment2/ui/dashboard/DashboardViewModel;", "vm$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onEntityClick", "item", "Lcom/example/s4679306assignment2/data/remote/DashboardEntity;", "Companion", "app_debug"})
public final class DashboardActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_KEYPASS = "extra_keypass";
    private com.example.s4679306assignment2.databinding.ActivityDashboardBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy vm$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.s4679306assignment2.ui.dashboard.EntityAdapter adapter = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.s4679306assignment2.ui.dashboard.DashboardActivity.Companion Companion = null;
    
    public DashboardActivity() {
        super();
    }
    
    private final com.example.s4679306assignment2.ui.dashboard.DashboardViewModel getVm() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void onEntityClick(com.example.s4679306assignment2.data.remote.DashboardEntity item) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/s4679306assignment2/ui/dashboard/DashboardActivity$Companion;", "", "()V", "EXTRA_KEYPASS", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}