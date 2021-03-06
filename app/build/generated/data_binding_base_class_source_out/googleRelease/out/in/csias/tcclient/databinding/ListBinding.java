// Generated by view binder compiler. Do not edit!
package in.csias.tcclient.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import in.csias.tcclient.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ListBinding implements ViewBinding {
  @NonNull
  private final ListView rootView;

  @NonNull
  public final ListView list;

  private ListBinding(@NonNull ListView rootView, @NonNull ListView list) {
    this.rootView = rootView;
    this.list = list;
  }

  @Override
  @NonNull
  public ListView getRoot() {
    return rootView;
  }

  @NonNull
  public static ListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ListBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    ListView list = (ListView) rootView;

    return new ListBinding((ListView) rootView, list);
  }
}
