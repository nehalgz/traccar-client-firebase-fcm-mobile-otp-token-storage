// Generated by view binder compiler. Do not edit!
package in.csias.tcclient.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.csias.tcclient.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MainBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final FragmentContainerView fragment;

  private MainBinding(@NonNull CoordinatorLayout rootView,
      @NonNull FragmentContainerView fragment) {
    this.rootView = rootView;
    this.fragment = fragment;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MainBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.fragment;
      FragmentContainerView fragment = ViewBindings.findChildViewById(rootView, id);
      if (fragment == null) {
        break missingId;
      }

      return new MainBinding((CoordinatorLayout) rootView, fragment);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
